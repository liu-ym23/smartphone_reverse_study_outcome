package com.ttnet.org.chromium.base;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f18320a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static SharedPreferences f18321a;

        static {
            f18321a = e.a();
        }

        public static /* synthetic */ SharedPreferences a() {
            return f18321a;
        }
    }

    static {
    }

    public static /* synthetic */ SharedPreferences a() {
        return b();
    }

    public static SharedPreferences b() {
        return PreferenceManager.getDefaultSharedPreferences(f18320a);
    }

    public static SharedPreferences c() {
        return a.a();
    }

    public static Context d() {
        return f18320a;
    }

    public static void e(Context r10) {
        f(r10);
    }

    public static void f(Context r10) {
        if (c.f18315a == true) goto L5;
    L7:
        f18320a = r10;
        return;
    L5:
        if ((r10 instanceof Application) == false) goto L7;
        r10 = new ContextWrapper(r10);
        goto L7
    }
}
