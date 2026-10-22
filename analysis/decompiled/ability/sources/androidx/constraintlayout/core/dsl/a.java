package androidx.constraintlayout.core.dsl;

import android.content.Context;
import android.util.Log;
import android.view.SavedStateReaderKt;
import androidx.datastore.preferences.protobuf.CodedOutputStream;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.sqlite.SQLite;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class a {
    public static void A(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static void B(InvocationTargetException invocationTargetException, StringBuilder sb, String str) {
        sb.append(invocationTargetException.getMessage());
        Log.e(str, sb.toString());
    }

    public static int C(int i, int i6, int i10, int i11) {
        return CodedOutputStream.computeUInt32SizeNoTag(i) + i6 + i10 + i11;
    }

    public static int D(int i, int i6, int i10, int i11) {
        return ((i * i6) + i10) * i11;
    }

    public static int a(int i, int i6, int i10) {
        return (Integer.hashCode(i) + i6) * i10;
    }

    public static int b(int i, int i6, int i10, int i11) {
        return ((i * i6) / i10) + i11;
    }

    public static String c(int i, String str, String str2, String str3) {
        return str + i + str2 + str3;
    }

    public static String d(int i, String str, String str2, String str3, String str4) {
        return str + str2 + str3 + i + str4;
    }

    public static String e(long j5, String str, StringBuilder sb) {
        sb.append(j5);
        sb.append(str);
        return sb.toString();
    }

    public static String f(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String g(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String h(String str, String str2, String str3) {
        String str4 = str + str2;
        k.f(str4, str3);
        return str4;
    }

    public static String i(StringBuilder sb, Class cls, String str) {
        sb.append(cls.getName());
        sb.append(str);
        return sb.toString();
    }

    public static String j(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static StringBuilder k(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb;
    }

    public static StringBuilder l(String str, String str2, String str3, String str4, boolean z10) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(z10);
        sb.append(str4);
        return sb;
    }

    public static KotlinNothingValueException m(int i, String str) {
        SQLite.throwSQLiteException(i, str);
        return new KotlinNothingValueException();
    }

    public static KotlinNothingValueException n(String str) {
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        return new KotlinNothingValueException();
    }

    public static JSONObject o(String str, String str2) {
        return new JSONObject().put(str, str2);
    }

    public static void p(int i, String str, String str2) {
        Log.d(str2, str + i);
    }

    public static void q(Context context, int i, String str, LinkedHashMap linkedHashMap, String str2) {
        String string = context.getString(i);
        k.e(string, str);
        linkedHashMap.put(str2, string);
    }

    public static /* synthetic */ void r(AutoCloseable autoCloseable) throws Exception {
        boolean zIsTerminated;
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (!(autoCloseable instanceof ExecutorService)) {
            throw new IllegalArgumentException();
        }
        ExecutorService executorService = (ExecutorService) autoCloseable;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z10 = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z10) {
                    executorService.shutdownNow();
                    z10 = true;
                }
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    public static void s(ClassNotFoundException classNotFoundException, StringBuilder sb, String str) {
        sb.append(classNotFoundException.getMessage());
        Log.e(str, sb.toString());
    }

    public static void t(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        Log.e(str, sb.toString());
    }

    public static void u(IllegalAccessException illegalAccessException, StringBuilder sb, String str) {
        sb.append(illegalAccessException.getMessage());
        Log.e(str, sb.toString());
    }

    public static void v(NoSuchMethodException noSuchMethodException, StringBuilder sb, String str) {
        sb.append(noSuchMethodException.getMessage());
        Log.e(str, sb.toString());
    }

    public static void w(String str, String str2, String str3) {
        Log.w(str3, str + str2);
    }

    public static void x(String str, String str2, String str3, String str4, String str5) {
        Log.w(str5, str + str2 + str3 + str4);
    }

    public static void y(StringBuilder sb, int i, String str, int i6, String str2) {
        sb.append(i);
        sb.append(str);
        sb.append(i6);
        sb.append(str2);
    }

    public static void z(StringBuilder sb, Class cls, String str) {
        sb.append(cls.getName());
        sb.append(str);
    }
}
