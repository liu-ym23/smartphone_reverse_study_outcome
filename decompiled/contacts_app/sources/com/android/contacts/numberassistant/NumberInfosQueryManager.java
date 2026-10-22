package com.android.contacts.numberassistant;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public class NumberInfosQueryManager {
    private static final int EVENT_ARRANGE_QUERY = 1;
    private static final int EVENT_QUERY_COMPLETE = 0;
    private static NumberInfosQueryManager sMe;
    private Handler mArrangeHandler;
    private Handler mHandler;
    private String mLock;
    private Thread mQueryThread;
    private Deque<NumberInfosRequest> mRequests;

    public interface NumberInfosQueryListener {
        void onQueryComplete(String r1, Object r2, String r3);
    }

    public static class NumberInfosRequest {
        public Object cookie;
        public NumberInfosQueryListener listener;
        public String number;
        public NumberInfosManager.NumberInfos result;

        public NumberInfosRequest(String r1, Object r2, NumberInfosQueryListener r3) {
            this.number = r1;
            this.cookie = r2;
            this.listener = r3;
            this.result = null;
        }

        public void search(NumberInfosManager.NumberInfosListener r2) {
            NumberInfosManager.getInstance().getBaseInfos(this.number, r2);
        }

        public void reset() {
            this.number = null;
            this.result = null;
            this.cookie = null;
            this.listener = null;
        }
    }

    private class mWorkerRunnable implements Runnable {
        final /* synthetic */ NumberInfosQueryManager this$0;

        private mWorkerRunnable(NumberInfosQueryManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ mWorkerRunnable(NumberInfosQueryManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
        L2:
            String r0 = NumberInfosQueryManager.access$100(this.this$0);
            monitor-enter(r0);
            if (NumberInfosQueryManager.access$200(this.this$0).isEmpty() == true) goto L19;
            final NumberInfosRequest r1 = (NumberInfosRequest) NumberInfosQueryManager.access$200(this.this$0).pollLast();     // Catch: Throwable -> L16
            if (r1 == null) goto L14;
            r1.search(new AnonymousClass1(this, r1));     // Catch: Throwable -> L16
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L16
            goto L2
        L19:
            NumberInfosQueryManager.access$100(this.this$0).wait();     // Catch: InterruptedException -> L12 Throwable -> L16
        L12:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        }
    }

    static /* synthetic */ String access$100(NumberInfosQueryManager r0) {
        return r0.mLock;
    }

    static /* synthetic */ Deque access$200(NumberInfosQueryManager r0) {
        return r0.mRequests;
    }

    static /* synthetic */ Handler access$300(NumberInfosQueryManager r0) {
        return r0.mHandler;
    }

    private NumberInfosQueryManager() {
        this.mLock = new String("lock");
        this.mRequests = new ArrayDeque();
        this.mHandler = new AnonymousClass1(this);
        Thread r0 = new Thread(new mWorkerRunnable(this, null));
        this.mQueryThread = r0;
        r0.start();
        HandlerThread r1 = new HandlerThread("NumberInfosQuery-arrange");
        r1.start();
        final Looper r2 = r1.getLooper();
        this.mArrangeHandler = new AnonymousClass2(this, r2);
    }

    public static NumberInfosQueryManager getInstance() {
        if (sMe != null) goto L6;
        sMe = new NumberInfosQueryManager();
    L6:
        return sMe;
    }

    public void startQuery(String r2, Object r3, NumberInfosQueryListener r4) {
        NumberInfosRequest r0 = new NumberInfosRequest(r2, r3, r4);
        Handler r1 = this.mArrangeHandler;
        if (r1 == null) goto L6;
        r1.sendMessage(r1.obtainMessage(1, r0));
        return;
    }
}
