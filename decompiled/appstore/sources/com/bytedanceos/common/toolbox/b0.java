package com.bytedanceos.common.toolbox;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;

/* JADX INFO: loaded from: classes2.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b0 f9996a;

    public b0() {
    }

    public static /* synthetic */ void a(b0 r10, String r11, Context r12) {
        r10.u(r11, r12);
    }

    public static /* synthetic */ void b(b0 r10, String r11, Context r12, String r13, boolean r14, Runnable r15) {
        r10.w(r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ void c(b0 r10, String r11, Context r12, String r13, boolean r14) {
        r10.v(r11, r12, r13, r14);
    }

    public static /* synthetic */ void d(b0 r10, String r11, Context r12, String r13) {
        r10.B(r11, r12, r13);
    }

    public static /* synthetic */ void e(b0 r10, String r11, Context r12, String r13, String r14) {
        r10.z(r11, r12, r13, r14);
    }

    public static /* synthetic */ void f(b0 r10, String r11, String r12, String r13) {
        r10.A(r11, r12, r13);
    }

    public static /* synthetic */ void g(b0 r10, String r11, Context r12, String r13, int r14) {
        r10.x(r11, r12, r13, r14);
    }

    public static /* synthetic */ void h(b0 r10, String r11, Context r12, String r13, long r14) {
        r10.y(r11, r12, r13, r14);
    }

    public static b0 n() {
        if (f9996a != null) goto L16;
        monitor-enter(b0.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f9996a != null) goto L11;
        f9996a = new b0();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b0.class);     // Catch: Throwable -> L9
    L16:
        return f9996a;
    }

    public final /* synthetic */ void A(String r10, String r11, String r12) {
        q(r10, BaseApplication.c()).edit().putString(r11, f.b(r12)).commit();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final /* synthetic */ void B(String r10, Context r11, String r12) {
        q(r10, r11).edit().remove(r12).commit();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void C(final String r10, final boolean r11, final String r12, final Context r13) {
        i(new v(this, r12, r13, r10, r11));
    }

    public void D(final String r10, final boolean r11, final String r12, final Context r13, final Runnable r14) {
        i(new a0(this, r12, r13, r10, r11, r14));
    }

    public void E(final String r10, final int r11, final String r12, final Context r13) {
        i(new y(this, r12, r13, r10, r11));
    }

    public void F(final String r10, final long r11, final String r12, final Context r13) {
        i(new w(this, r12, r13, r10, r11));
    }

    public void G(final String r10, final String r11, final String r12) {
        i(new z(this, r12, r10, r11));
    }

    public void H(final String r10, final String r11, final String r12, final Context r13) {
        i(new u(this, r12, r13, r10, r11));
    }

    public void I(final String r10, final String r11, final Context r12) {
        i(new t(this, r11, r12, r10));
    }

    public final void i(Runnable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (e.z0() == false) goto L6;
        w3.c.b(r10);
        return;
    L6:
        r10.run();
    }

    public void j(final String r10, final Context r11) {
        i(new x(this, r10, r11));
    }

    public boolean k(Context r10, String r11, String r12) {
        SharedPreferences r13 = q(r11, r10);
        if (r13 != null) goto L5;
        return false;
    L5:
        return r13.contains(r12);
    }

    public Boolean l(String r10, String r11, Context r12) {
        return m(r10, r11, r12, false);
    }

    public Boolean m(String r10, String r11, Context r12, boolean r13) {
        return Boolean.valueOf(q(r11, r12).getBoolean(r10, r13));
    }

    public int o(String r10, String r11, Context r12) {
        return q(r11, r12).getInt(r10, -1);
    }

    public long p(String r10, String r11, Context r12) {
        return q(r11, r12).getLong(r10, 0);
    }

    public final SharedPreferences q(String r10, Context r11) {
        if (BaseApplication.c().o() == false) goto L5;
        String r12 = "com.obric.appstore";
    L7:
        if (TextUtils.isEmpty(r10) == false) goto L10;
        r10 = r12;
    L10:
        return r11.getSharedPreferences(r10, 0);
    L5:
        r12 = "com.bytedanceos.gamestore";
        goto L7
    }

    public String r(String r10, String r11) {
        return t(r10, r11, BaseApplication.c(), "");
    }

    public String s(String r10, String r11, Context r12) {
        return t(r10, r11, r12, "");
    }

    public String t(String r10, String r11, Context r12, String r13) {
        SharedPreferences r14 = q(r11, r12);
        if (r14 == null) goto L5;
        String r15 = r14.getString(r10, r13);
    L6:
        if (r15 == r13) goto L14;
        return f.a(r15);
    L9:
        e = move-exception;
        e.printStackTrace();
        return r15;
    L14:
        return r15;
    L5:
        r15 = r13;
        goto L6
    }

    public final /* synthetic */ void u(String r10, Context r11) {
        q(r10, r11).edit().clear().commit();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final /* synthetic */ void v(String r10, Context r11, String r12, boolean r13) {
        q(r10, r11).edit().putBoolean(r12, r13).commit();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final /* synthetic */ void w(String r10, Context r11, String r12, boolean r13, Runnable r14) {
        q(r10, r11).edit().putBoolean(r12, r13).commit();     // Catch: Exception -> L6
        if (r14 == null) goto L11;
        r14.run();     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public final /* synthetic */ void x(String r10, Context r11, String r12, int r13) {
        q(r10, r11).edit().putInt(r12, r13).commit();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final /* synthetic */ void y(String r10, Context r11, String r12, long r13) {
        q(r10, r11).edit().putLong(r12, r13).commit();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final /* synthetic */ void z(String r10, Context r11, String r12, String r13) {
        q(r10, r11).edit().putString(r12, f.b(r13)).commit();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
