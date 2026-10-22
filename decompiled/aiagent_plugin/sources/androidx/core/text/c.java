package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ICUCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    private static final String TAG = "ICUCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f1357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f1358b;

    /* JADX INFO: compiled from: ICUCompat.java */
    static class a {
        static String a(Locale r0) {
            return r0.getScript();
        }
    }

    /* JADX INFO: compiled from: ICUCompat.java */
    static class b {
        static ULocale a(Locale r0) {
            return ULocale.forLocale(r0);
        }

        static ULocale a(Object r2) {
            return ULocale.addLikelySubtags((ULocale) ZeusTransformUtils.preCheckCast(r2, ULocale.class, "com.obric.aiagent.plugin"));
        }

        static String b(Object r2) {
            return ((ULocale) ZeusTransformUtils.preCheckCast(r2, ULocale.class, "com.obric.aiagent.plugin")).getScript();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        Class r0 = ZeusTransformUtils.forName("libcore.icu.ICU", "com.obric.aiagent.plugin");     // Catch: Exception -> L6
        f1357a = r0.getMethod("getScript", new Class[]{String.class});     // Catch: Exception -> L6
        f1358b = r0.getMethod("addLikelySubtags", new Class[]{String.class});     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        f1357a = null;
        f1358b = null;
        a(TAG, e);
        return;
    L9:
        if (Build.VERSION.SDK_INT >= 24) goto L20;
        f1358b = ZeusTransformUtils.forName("libcore.icu.ICU", "com.obric.aiagent.plugin").getMethod("addLikelySubtags", new Class[]{Locale.class});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static String a(Locale r4) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return b.b(b.a(b.a(r4)));
    L7:
        if (Build.VERSION.SDK_INT >= 21) goto L22;
        String r5 = b(r4);
        if (r5 != null) goto L20;
        return null;
    L20:
        return a(r5);
    L22:
        return a.a((Locale) ZeusTransformUtils.preCheckCast(f1358b.invoke(null, new Object[]{r4}), Locale.class, "com.obric.aiagent.plugin"));
    L11:
        e = move-exception;
        a(TAG, e);
    L16:
        return a.a(r4);
    L13:
        e = move-exception;
        a(TAG, e);
        goto L16
    }

    private static String a(String r5) {
        Method r2 = f1357a;     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
        if (r2 == null) goto L11;
        return (String) ZeusTransformUtils.preCheckCast(r2.invoke(null, new Object[]{r5}), String.class, "com.obric.aiagent.plugin");
    L11:
        return null;
    L9:
        e = move-exception;
        a(TAG, e);
    L7:
        e = move-exception;
        a(TAG, e);
        goto L11
    }

    private static String b(Locale r4) {
        String r5 = r4.toString();
        Method r1 = f1358b;     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
        if (r1 == null) goto L11;
        return (String) ZeusTransformUtils.preCheckCast(r1.invoke(null, new Object[]{r5}), String.class, "com.obric.aiagent.plugin");
    L11:
        return r5;
    L9:
        e = move-exception;
        a(TAG, e);
    L7:
        e = move-exception;
        a(TAG, e);
        goto L11
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, Throwable r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
