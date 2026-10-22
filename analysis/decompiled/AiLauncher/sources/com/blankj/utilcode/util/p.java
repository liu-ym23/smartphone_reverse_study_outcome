package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.util.Log;
import android.view.Lifecycle;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static Application f19238a;

    public static class a {
        public void a(Activity activity) {
        }

        public void b(Activity activity) {
        }

        public void c(Activity activity) {
        }

        public void d(Activity activity) {
        }

        public void e(Activity activity) {
        }

        public void f(Activity activity) {
        }

        public void g(Activity activity, Lifecycle.Event event) {
        }
    }

    public interface b<T> {
        void accept(T t10);
    }

    public interface c {
        void a(Activity activity);

        void b(Activity activity);
    }

    public static Application a() {
        Application application = f19238a;
        if (application != null) {
            return application;
        }
        b(r.g());
        if (f19238a == null) {
            throw new NullPointerException("reflect failed.");
        }
        Log.i("Utils", r.h() + " reflect app success.");
        return f19238a;
    }

    public static void b(Application application) {
        if (application == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        Application application2 = f19238a;
        if (application2 == null) {
            f19238a = application;
            r.n(application);
            r.u();
        } else {
            if (application2.equals(application)) {
                return;
            }
            r.z(f19238a);
            f19238a = application;
            r.n(application);
        }
    }
}
