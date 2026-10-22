package a1;

import android.content.res.TypedArray;
import androidx.datastore.preferences.protobuf.m;
import b0.p;
import com.google.crypto.tink.shaded.protobuf.k;
import i1.f;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static final boolean a(int i2) {
        return i2 == 6 || i2 == 4;
    }

    public static int b(int i2, int i10, int i11) {
        return m.s(i2) + i10 + i11;
    }

    public static int c(int i2, int i10, int i11, int i12) {
        return m.t(i2) + i10 + i11 + i12;
    }

    public static int d(int i2, int i10, int i11, int i12, int i13) {
        return Math.max(((i2 * i10) / i11) + i12, i13);
    }

    public static String e(char c10, String str, String str2) {
        return str + str2 + c10;
    }

    public static String f(int i2, String str, String str2) {
        return str + i2 + str2;
    }

    public static String g(Class cls, String str) {
        return str + cls;
    }

    public static String h(String str, long j2) {
        return str + j2;
    }

    public static String i(String str, String str2) {
        return str + str2;
    }

    public static String j(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String k(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String l(StringBuilder sb2, String str, char c10) {
        sb2.append(str);
        sb2.append(c10);
        return sb2.toString();
    }

    public static String m(StringBuilder sb2, String str, String str2) {
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    public static StringBuilder n(int i2, String str, String str2) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(i2);
        sb2.append(str2);
        return sb2;
    }

    public static StringBuilder o(String str, String str2, String str3, int i2, String str4) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(i2);
        sb2.append(str4);
        return sb2;
    }

    public static StringBuilder p(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
        sb2.append(str5);
        return sb2;
    }

    public static void q(int i2, int i10, int i11, int i12, int i13) {
        ib.c.a(i2);
        ib.c.a(i10);
        ib.c.a(i11);
        ib.c.a(i12);
        ib.c.a(i13);
    }

    public static void r(int i2, p pVar, int i10, f fVar) {
        pVar.b0(Integer.valueOf(i2));
        pVar.b(Integer.valueOf(i10), fVar);
    }

    public static /* synthetic */ void s(AutoCloseable autoCloseable) throws Exception {
        boolean zIsTerminated;
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (!(autoCloseable instanceof ExecutorService)) {
            if (!(autoCloseable instanceof TypedArray)) {
                throw new IllegalArgumentException();
            }
            ((TypedArray) autoCloseable).recycle();
            return;
        }
        ExecutorService executorService = (ExecutorService) autoCloseable;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z4 = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z4) {
                    executorService.shutdownNow();
                    z4 = true;
                }
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
    }

    public static /* synthetic */ void t(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static int u(int i2, int i10, int i11) {
        return k.X(i2) + i10 + i11;
    }

    public static int v(int i2, int i10, int i11, int i12) {
        return k.Y(i2) + i10 + i11 + i12;
    }

    public static String w(String str, String str2) {
        return str + str2;
    }

    public static String x(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static /* synthetic */ String y(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "null" : "SYNTHESIZED" : "DELEGATION" : "FAKE_OVERRIDE" : "DECLARATION";
    }
}
