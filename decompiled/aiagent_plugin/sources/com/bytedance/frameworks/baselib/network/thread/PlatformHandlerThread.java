package com.bytedance.frameworks.baselib.network.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PlatformHandlerThread {
    private static final String TAG = "PlatformHandlerThread";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Handler f8571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HashMap<String, HandlerThread> f8572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static List<String> f8573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<String> f8574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Map<String, String> f8575e;

    public static class InnerHandlerThread extends HandlerThread {
        private volatile boolean isStart;

        public InnerHandlerThread(String r1) {
            super(r1);
            this.isStart = false;
        }

        public InnerHandlerThread(String r1, int r2) {
            super(r1, r2);
            this.isStart = false;
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.isStart == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.isStart = true;     // Catch: Throwable -> L11
            super.start();     // Catch: Throwable -> L11
            monitor-exit(this);
        }
    }

    static {
        f8571a = new Handler(Looper.getMainLooper());
        f8572b = new HashMap();
        f8573c = Arrays.asList(new String[]{"NpthHandlerThread", "NewVideo-HandlerThread", "trace_time_update_thread"});
        f8574d = Arrays.asList(new String[]{"DBHelper-AsyncOp-New"});
        f8575e = new HashMap();
    }

    public static HandlerThread a(String r2) {
        return a(r2, 0, "");
    }

    public static HandlerThread a(String r3, int r4, String r5) {
        Iterator<Map.Entry<String, HandlerThread>> r6 = f8572b.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        if (((HandlerThread) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), HandlerThread.class, "com.obric.aiagent.plugin")).isAlive() == true) goto L4;
        r6.remove();
        goto L4
    L8:
        HandlerThread r7 = (HandlerThread) ZeusTransformUtils.preCheckCast(f8572b.get(r3), HandlerThread.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L17;
        InnerHandlerThread r8 = new InnerHandlerThread(r3, r4);
        r8.start();
        f8572b.put(r3, r8);
        return r8;
    L17:
        return r7;
    }
}
