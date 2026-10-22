package com.bytedance.android.live.core.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.core.cmc.setting.CMCSettings;
import com.bytedance.android.live.core.log.ALogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c50.a f66191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c50.e f66192b;

    public i0() {
    }

    public static boolean b() {
        if (CMCSettings.LIVE_CMC_CONFIG.getValue().mEnable == true) goto L5;
        return false;
    L5:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r100 = false;
        goto L8
    }

    public static Handler c() {
        if (f66191a != null) goto L15;
        monitor-enter(i0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f66191a != null) goto L9;
        c50.a r100 = new c50.a(Looper.getMainLooper());     // Catch: Throwable -> L11
        f66191a = r100;     // Catch: Throwable -> L11
        f66192b = new c50.e(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(i0.class);     // Catch: Throwable -> L11
    L15:
        return f66191a;
    }

    public static void a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (b() == false) goto L47;
        c();
        c50.e r101 = f66192b;
        Integer r102 = r101.f22455a.remove(r100);
        f50.a r103 = r101.f22457c;
        HashMap<Integer, c50.d> r104 = r101.f22456b;
        if (r103.f475607a == false) goto L18;
        if (r102 == null) goto L12;
        int r105 = r102.intValue();
    L13:
        if (r104 == null) goto L18;
        c50.d r106 = r104.get(Integer.valueOf(r105));
        if (r106 == null) goto L18;
        r106.b();
        goto L18
    L12:
        r105 = -1;
    L18:
        if (r102 != null) goto L20;
        return;
    L20:
        if (r102.intValue() == (-1)) goto L48;
        c50.d r107 = r101.f22456b.remove(r102);
        if (r107 == null) goto L28;
        ArrayList<c50.c> r108 = r107.f22454d;
        if (r108 == null) goto L27;
        r108.clear();
    L27:
        r107.f22451a = null;
        r107.f22452b = -1;
    L28:
        d50.a r109 = r101.f22458d;
        int r110 = r102.intValue();
        r109.f466891d.remove(Integer.valueOf(r110));
        if (r110 == (-1)) goto L49;
        f50.a r111 = r109.f466890c;
        Handler r112 = r109.f466888a;
        HashMap<Integer, c50.d> r113 = r109.f466889b;
        if (r111.f475607a == false) goto L39;
        if (r113 == null) goto L38;
        c50.d r114 = r113.get(Integer.valueOf(r110));
        if (r114 == null) goto L38;
        r114.b();
    L38:
        r111.b(r112, r113);
    L39:
        r109.f466888a.removeMessages(r110);
        f50.a r115 = r109.f466890c;
        Handler r116 = r109.f466888a;
        HashMap<Integer, c50.d> r117 = r109.f466889b;
        if (r115.f475607a == false) goto L43;
        r115.b(r116, r117);
    L43:
        r109.f();
        return;
    L49:
        return;
    L48:
        return;
    }

    public static void d(Runnable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        c().postAtTime(r100, 5);
    }

    public static void f(Runnable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        c().postAtTime(r100, 3);
    }

    public static void g(Runnable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Message r101 = Message.obtain(c(), r100);
        if (Build.VERSION.SDK_INT < 22) goto L7;
        ALogger.i("SlideTaskDelay", "setAsynchronous true");
        r101.setAsynchronous(true);
    L7:
        c().sendMessageAtTime(r101, 3);
    }

    public static void h(Runnable r100) {
        c().post(r100);
    }

    public static void e(String r100, Runnable r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        Handler r102 = c();
        if (b() == true) goto L7;
    L11:
        r102.postAtTime(r101, 5);
        return;
    L7:
        if (CMCSettings.LIVE_CMC_CONFIG.getValue().mInsertSupport == false) goto L11;
        if (f66192b.b(r100, r101, 5) == true) goto L13;
        r102.postAtTime(r101, 5);
        return;
    }

    public static void i(String r100, Runnable r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        Handler r102 = c();
        if (b() == true) goto L7;
        r102.post(r101);
        return;
    L7:
        if (f66192b.b(r100, r101, SystemClock.uptimeMillis()) == true) goto L11;
        r102.post(r101);
        return;
    }

    public static void k(String r100, Runnable r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        Handler r102 = c();
        if (b() == false) goto L45;
        c50.e r103 = f66192b;
        if (r103.f22457c.f475607a == false) goto L10;
    L10:
        Integer r104 = r103.f22455a.get(r100);
        if (r104 == null) goto L13;
        int r105 = r104.intValue();
    L14:
        if (r105 == (-1)) goto L42;
        c50.d r106 = r103.f22456b.get(Integer.valueOf(r105));
        if (r106 == null) goto L19;
        c50.c r107 = r106.a(r101);
    L20:
        if (r107 != null) goto L31;
        Iterator<Map.Entry<Integer, c50.d>> r108 = r103.f22456b.entrySet().iterator();
    L23:
        if (r108.hasNext() == false) goto L31;
        Map.Entry<Integer, c50.d> r109 = r108.next();
        if (r109.getKey().intValue() == r105) goto L23;
        c50.d r110 = r109.getValue();
        if (r110 == null) goto L30;
        r107 = r110.a(r101);
    L30:
        if (r107 == null) goto L23;
    L31:
        d50.a r111 = r103.f22458d;
        if (r107 == null) goto L41;
        f50.a r112 = r111.f466890c;
        HashMap<Integer, c50.d> r113 = r111.f466889b;
        if (r112.f475607a == false) goto L40;
        if (r113 == null) goto L40;
        c50.d r114 = r113.get(Integer.valueOf(r107.f22450d));
        if (r114 == null) goto L40;
        r114.b();
    L40:
        r111.f466888a.removeCallbacks(r107);
        r111.d(r107);
        boolean r115 = true;
    L43:
        if (r115 == true) goto L53;
        r102.removeCallbacks(r101);
        return;
    L53:
        return;
    L41:
        r111.getClass();
        goto L42
    L19:
        r107 = null;
    L42:
        r115 = false;
        goto L43
    L13:
        r105 = -1;
        goto L14
    L45:
        r102.removeCallbacks(r101);
    }

    public static void j(String r100, Runnable r101, long r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        Handler r103 = c();
        if (b() == true) goto L7;
        r103.postDelayed(r101, r102);
        return;
    L7:
        if (f66192b.b(r100, r101, SystemClock.uptimeMillis() + r102) == true) goto L11;
        r103.postDelayed(r101, r102);
        return;
    }
}
