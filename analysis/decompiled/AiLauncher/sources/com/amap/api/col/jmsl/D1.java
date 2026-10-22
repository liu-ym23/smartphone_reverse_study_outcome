package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Looper;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public class D1 {

    /* renamed from: a, reason: collision with root package name */
    public static long f15989a;

    /* renamed from: b, reason: collision with root package name */
    public static Vector<C1569j2> f15990b = new Vector<>();

    public static class a extends AbstractRunnableC1545d2 {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f15991d;

        public a(Context context) {
            this.f15991d = context;
        }

        @Override // com.amap.api.col.jmsl.AbstractRunnableC1545d2
        public final void runTask() {
            try {
                C1573k2.g(this.f15991d);
                C1573k2.i(this.f15991d);
                C1573k2.h(this.f15991d);
                C1594q.b(this.f15991d);
                e3.d(this.f15991d);
            } catch (RejectedExecutionException unused) {
            } catch (Throwable th) {
                C1541c2.b(th, "Lg", "proL");
            }
        }
    }

    public static String a(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + "/a/" + str;
    }

    public static List<C1569j2> b() {
        Vector<C1569j2> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = f15990b;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return f15990b;
        }
    }

    public static void c(Context context) {
        try {
            if (System.currentTimeMillis() - f15989a < 60000) {
                return;
            }
            f15989a = System.currentTimeMillis();
            V1.h().f(new a(context));
        } catch (Throwable th) {
            C1541c2.b(th, "Lg", "proL");
        }
    }

    public static void d(C1569j2 c1569j2) {
        try {
            synchronized (Looper.getMainLooper()) {
                try {
                    if (c1569j2 == null) {
                        return;
                    }
                    if (f15990b.contains(c1569j2)) {
                        return;
                    }
                    f15990b.add(c1569j2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean e(String[] strArr, String str) {
        if (strArr != null && str != null) {
            try {
                for (String str2 : strArr) {
                    str = str.trim();
                    if (str.startsWith("at ")) {
                        if (str.contains(str2 + ".") && str.endsWith(")") && !str.contains("uncaughtException")) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static String f(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }
}
