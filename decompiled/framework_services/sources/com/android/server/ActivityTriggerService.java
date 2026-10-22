package com.android.server;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Slog;
import com.android.server.am.HostingRecord;

/* JADX INFO: loaded from: classes.dex */
public class ActivityTriggerService extends SystemService {
    public static final int PROC_ADDED_NOTIFICATION = 1;
    public static final int PROC_REMOVED_NOTIFICATION = 0;
    private static String TAG;
    private EventHandlerThread eventHandler;

    public class EventHandlerThread extends HandlerThread {
        private Handler handler;

        public EventHandlerThread(ActivityTriggerService this$0, String name) {
            super(name);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            this.handler = new Handler();
        }

        public Handler getHandler() {
            return this.handler;
        }
    }

    static class LocalRunnable implements Runnable {
        private int event;
        private long lvCode;
        private String packageName;
        private int pid;
        private String procName;

        LocalRunnable(String packageName, long lvCode, String procName, int pid, int event) {
            this.packageName = packageName;
            this.lvCode = lvCode;
            this.procName = procName;
            this.pid = pid;
            this.event = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityTriggerService.notifyAction_native(this.packageName, this.lvCode, this.procName, this.pid, this.event);
        }
    }

    static native void notifyAction_native(String r0, long r1, String r3, int r4, int r5);

    static {
        TAG = "ActivityTriggerService";
    }

    public ActivityTriggerService(Context context) {
        super(context);
        this.eventHandler = new EventHandlerThread(this, "EventHandlerThread");
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        Slog.i(TAG, "Starting ActivityTriggerService");
        this.eventHandler.start();
        publishLocalService(ActivityTriggerService.class, this);
    }

    public void updateRecord(HostingRecord hr, ApplicationInfo info, int pid, int event) {
        if (hr == null) goto L5;
        this.eventHandler.getHandler().post(new LocalRunnable(info.packageName, info.longVersionCode, info.processName, pid, event));
        return;
    }
}
