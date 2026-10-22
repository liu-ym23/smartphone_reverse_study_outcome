package com.bytedance.common.wschannel;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.server.WsChannelReceiver;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f6888a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f6889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Application f6890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static C0085a f6891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Map f6892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Map f6893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f6894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static b f6895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f6896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f6897j;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.a$a, reason: collision with other inner class name */
    public static class C0085a implements LifeCycleMonitor.AppStateListener {
        public C0085a() {
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.AppStateListener
        public void onEnterToBackground() {
            a.a(true);
            if (a.c() != null) goto L5;
        L6:
            d4.a.h(a.b());
            return;
        L5:
            if (b.a(a.c()) == true) goto L6;
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.AppStateListener
        public void onEnterToForeground() {
            a.a(false);
            if (a.c() != null) goto L5;
        L6:
            d4.a.i(a.b());
            return;
        L5:
            if (b.a(a.c()) == true) goto L6;
        }

        public /* synthetic */ C0085a(z3.a r10) {
            this();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f6899b;

        public b() {
            this.f6898a = false;
            this.f6899b = new ConcurrentHashMap();
        }

        public static /* synthetic */ boolean a(b r10) {
            return r10.f6898a;
        }

        public static /* synthetic */ boolean b(b r10, boolean r11) {
            r10.f6898a = r11;
            return r11;
        }

        public /* synthetic */ b(z3.a r10) {
            this();
        }
    }

    static {
        f6888a = new Object();
        f6891d = new C0085a(null);
        f6892e = new ConcurrentHashMap();
        f6893f = new ConcurrentHashMap();
    }

    public static /* synthetic */ boolean a(boolean r10) {
        f6897j = r10;
        return r10;
    }

    public static /* synthetic */ Application b() {
        return f6890c;
    }

    public static /* synthetic */ b c() {
        return f6895h;
    }

    public static void d(Application r10, OnMessageReceiveListener r11, boolean r12, boolean r13) {
        if (f6889b == false) goto L5;
        return;
    L5:
        f6889b = true;
        f6890c = r10;
        f6896i = r13;
        f6894g = j4.a.b(r10);
        cf.a.a(r10);     // Catch: Throwable -> L8
    L9:
        boolean r14 = j4.a.f(r10, f6894g);
        if (r12 == false) goto L13;
        if (r14 == false) goto L13;
        b r15 = new b(null);
        f6895h = r15;
        b.b(r15, false);
    L13:
        if (r14 == false) goto L18;
        if (r13 == false) goto L16;
        LifeCycleMonitor r16 = new LifeCycleMonitor();
        r16.d(f6891d);
        r10.registerActivityLifecycleCallbacks(r16);
    L16:
        WsConstants.setOnMessageReceiveListener(r11);
    L21:
        if (f6895h != null) goto L26;
        d4.a.o(f6890c, r14, true);
        return;
    L26:
        return;
    L18:
        if (j4.a.g(f6894g) == false) goto L21;
        h();
    L8:
        Log.d("WsChannel", "没有AppProvider，忽略");
        goto L9
    }

    public static Context e() {
        return f6890c;
    }

    public static f4.a f(int r10) {
        return (f4.a) f6893f.get(Integer.valueOf(r10));
    }

    public static void g(Application r10, OnMessageReceiveListener r11) {
        d(r10, r11, false, true);
    }

    public static void h() {
        IntentFilter r10 = new IntentFilter();     // Catch: Exception -> L4
        r10.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L4
        f6890c.registerReceiver(new WsChannelReceiver(), r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
