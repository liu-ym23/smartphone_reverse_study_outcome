package com.bytedance.platform.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.platform.thread.monitor.ThreadMonitorManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Handler f7876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap f7877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List f7878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static List f7879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Map f7880e;

    /* JADX INFO: renamed from: com.bytedance.platform.thread.a$a, reason: collision with other inner class name */
    public static class HandlerThreadC0098a extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f7881a;

        public HandlerThreadC0098a(String r10, int r11) {
            super(r10, r11);
            this.f7881a = false;
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.f7881a == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f7881a = true;     // Catch: Throwable -> L11
            super.start();     // Catch: Throwable -> L11
            monitor-exit(this);
        }
    }

    static {
        f7876a = new Handler(Looper.getMainLooper());
        f7877b = new HashMap();
        f7878c = Arrays.asList(new String[]{"NpthHandlerThread", "NewVideo-HandlerThread", "trace_time_update_thread"});
        f7879d = Arrays.asList(new String[]{"DBHelper-AsyncOp-New"});
        f7880e = new HashMap();
    }

    public static HandlerThread a(String r10) {
        return b(r10, 0, "");
    }

    public static HandlerThread b(String r10, int r11, String r12) {
        Iterator r13 = f7877b.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        if (((HandlerThread) ((Map.Entry) r13.next()).getValue()).isAlive() == true) goto L4;
        r13.remove();
        goto L4
    L8:
        HandlerThread r14 = (HandlerThread) f7877b.get(r10);
        if (r14 != null) goto L17;
        HandlerThreadC0098a r15 = new HandlerThreadC0098a(r10, r11);
        r15.start();
        ThreadMonitorManager.b(r15);
        f7877b.put(r10, r15);
        return r15;
    L17:
        return r14;
    }
}
