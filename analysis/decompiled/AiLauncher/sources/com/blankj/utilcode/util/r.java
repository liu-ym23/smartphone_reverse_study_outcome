package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import androidx.core.app.j;
import com.blankj.utilcode.util.i;
import com.blankj.utilcode.util.p;
import java.util.List;

/* loaded from: classes.dex */
public class r {
    public static Bitmap A(View view) {
        return e.a(view);
    }

    public static void a(p.a aVar) {
        q.f19239g.d(aVar);
    }

    public static int b(float f10) {
        return m.a(f10);
    }

    public static void c(Activity activity) {
        g.a(activity);
    }

    public static String d(String str, Object... objArr) {
        return o.a(str, objArr);
    }

    public static List<Activity> e() {
        return q.f19239g.i();
    }

    public static int f() {
        return l.a();
    }

    public static Application g() {
        return q.f19239g.m();
    }

    public static String h() {
        return j.a();
    }

    public static Intent i(String str, boolean z10) {
        return f.b(str, z10);
    }

    public static int j() {
        return d.a();
    }

    public static Notification k(i.a aVar, p.b<j.d> bVar) {
        return i.a(aVar, bVar);
    }

    public static k l() {
        return k.a("Utils");
    }

    public static int m() {
        return d.b();
    }

    public static void n(Application application) {
        q.f19239g.n(application);
    }

    public static boolean o(Activity activity) {
        return a.a(activity);
    }

    public static boolean p() {
        return q.f19239g.o();
    }

    public static boolean q() {
        return PermissionUtils.t();
    }

    public static boolean r(Intent intent) {
        return f.c(intent);
    }

    public static boolean s() {
        return s.a();
    }

    public static View t(int i10) {
        return s.b(i10);
    }

    public static void u() {
        v(b.f());
    }

    public static void v(Runnable... runnableArr) {
        for (Runnable runnable : runnableArr) {
            ThreadUtils.b().execute(runnable);
        }
    }

    public static void w(p.a aVar) {
        q.f19239g.s(aVar);
    }

    public static void x(Runnable runnable) {
        ThreadUtils.e(runnable);
    }

    public static void y(Runnable runnable, long j10) {
        ThreadUtils.f(runnable, j10);
    }

    public static void z(Application application) {
        q.f19239g.w(application);
    }
}
