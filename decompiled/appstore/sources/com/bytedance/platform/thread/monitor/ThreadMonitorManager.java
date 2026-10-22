package com.bytedance.platform.thread.monitor;

import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Printer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class ThreadMonitorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List f7882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List f7883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map f7884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map f7885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f7886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f7887f;

    public interface IMonitor {
        void monitorLog(String r10, JSONObject r11);
    }

    public static class a implements Printer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f7888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f7889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7890c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f7891d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ HandlerThread f7892e;

        public a(HandlerThread r10) {
            this.f7892e = r10;
        }

        @Override // android.util.Printer
        public void println(String r10) {
            if (r10.startsWith(">>>>> Dispatching") == false) goto L6;
            this.f7888a = SystemClock.currentThreadTimeMillis();
            this.f7889b = SystemClock.elapsedRealtime();
            return;
        L6:
            if (r10.startsWith("<<<<< Finished") == false) goto L13;
            this.f7890c = SystemClock.currentThreadTimeMillis();
            this.f7891d = SystemClock.elapsedRealtime();
            String r11 = this.f7892e.getName();
            e6.a r12 = (e6.a) ThreadMonitorManager.a().get(r11);
            if (r12 != null) goto L10;
            r12 = new e6.a(r11);
            ThreadMonitorManager.a().put(r11, r12);
        L10:
            r12.f19317c++;
            r12.f19315a += this.f7890c - this.f7888a;
            r12.f19316b += this.f7891d - this.f7889b;
            return;
        }
    }

    static {
        f7882a = new ArrayList();
        f7883b = new ArrayList();
        f7884c = new ConcurrentHashMap();
        f7885d = new ConcurrentHashMap();
        f7886e = false;
        f7887f = true;
    }

    public static /* synthetic */ Map a() {
        return f7884c;
    }

    public static void b(HandlerThread r10) {
        if (f7887f == true) goto L6;
        return;
    L6:
        if (f7883b.contains(r10) == true) goto L9;
        f7883b.add(r10);
        r10.getLooper().setMessageLogging(new a(r10));
        return;
    }
}
