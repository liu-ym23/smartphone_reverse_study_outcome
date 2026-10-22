package com.android.server.security.intrusiondetection;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.security.intrusiondetection.IntrusionDetectionEvent;
import android.util.Slog;
import com.android.server.ServiceThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class DataAggregator {
    private static final int MSG_BATCH_DATA = 1;
    private static final int MSG_DISABLE = 2;
    private static final int MSG_SINGLE_DATA = 0;
    private static final int STORED_EVENTS_SIZE_LIMIT = 1024;
    private static final String TAG = "IntrusionDetection DataAggregator";
    private Context mContext;
    private final ArrayList<DataSource> mDataSources;
    private Handler mHandler;
    private ServiceThread mHandlerThread;
    private final IntrusionDetectionService mIntrusionDetectionService;
    private final AtomicBoolean mIsLoggingInitialized;
    private List<IntrusionDetectionEvent> mStoredEvents;

    private static class EventHandler extends Handler {
        private final DataAggregator mDataAggregator;

        EventHandler(Looper looper, DataAggregator dataAggregator) {
            super(looper);
            this.mDataAggregator = dataAggregator;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0: goto L7;
                case 1: goto L6;
                case 2: goto L5;
                default: goto L4;
            };
        L4:
            Slog.w(DataAggregator.TAG, "Unknown message: " + msg.what);
            return;
        L5:
            DataAggregator.m8045$$Nest$monDisable(this.mDataAggregator);
            return;
        L6:
            DataAggregator.m8046$$Nest$monNewBatchData(this.mDataAggregator, (List) msg.obj);
            return;
        L7:
            DataAggregator.m8047$$Nest$monNewSingleData(this.mDataAggregator, (IntrusionDetectionEvent) msg.obj);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$monDisable, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8045$$Nest$monDisable(DataAggregator r0) {
        r0.onDisable();
    }

    /* JADX INFO: renamed from: -$$Nest$monNewBatchData, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8046$$Nest$monNewBatchData(DataAggregator r0, List r1) {
        r0.onNewBatchData(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monNewSingleData, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8047$$Nest$monNewSingleData(DataAggregator r0, IntrusionDetectionEvent r1) {
        r0.onNewSingleData(r1);
    }

    public DataAggregator(Context context, IntrusionDetectionService intrusionDetectionService) {
        this.mIsLoggingInitialized = new AtomicBoolean(false);
        this.mStoredEvents = new ArrayList();
        this.mIntrusionDetectionService = intrusionDetectionService;
        this.mContext = context;
        this.mDataSources = new ArrayList();
    }

    void setHandler(Looper looper, ServiceThread serviceThread) {
        this.mHandlerThread = serviceThread;
        this.mHandler = new EventHandler(looper, this);
    }

    private void initialize() {
        this.mDataSources.add(new SecurityLogSource(this.mContext, this));
        this.mDataSources.add(new NetworkLogSource(this));
    }

    public void enable() {
        if (this.mIsLoggingInitialized.get() == true) goto L5;
        initialize();
        this.mIsLoggingInitialized.set(true);
    L5:
        this.mHandlerThread = new ServiceThread(TAG, 10, false);
        this.mHandlerThread.start();
        this.mHandler = new EventHandler(this.mHandlerThread.getLooper(), this);
        Iterator<DataSource> r0 = this.mDataSources.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        DataSource ds = r0.next();
        ds.enable();
        goto L7
    }

    public void addSingleData(IntrusionDetectionEvent event) {
        this.mHandler.obtainMessage(0, event).sendToTarget();
    }

    public void addBatchData(List<IntrusionDetectionEvent> events) {
        this.mHandler.obtainMessage(1, events).sendToTarget();
    }

    public void disable() {
        this.mHandler.obtainMessage(2).sendToTarget();
    }

    private void onNewSingleData(IntrusionDetectionEvent event) {
        if (this.mStoredEvents.size() >= 1024) goto L5;
        this.mStoredEvents.add(event);
        return;
    L5:
        this.mIntrusionDetectionService.addNewData(this.mStoredEvents);
        this.mStoredEvents = new ArrayList();
    }

    private void onNewBatchData(List<IntrusionDetectionEvent> events) {
        this.mIntrusionDetectionService.addNewData(events);
    }

    private void onDisable() {
        Iterator<DataSource> r0 = this.mDataSources.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        DataSource ds = r0.next();
        ds.disable();
        goto L4
    L6:
        this.mHandlerThread.quitSafely();
        this.mHandlerThread = null;
    }
}
