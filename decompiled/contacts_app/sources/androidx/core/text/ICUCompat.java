package androidx.core.text;

import android.icu.util.ULocale;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    static class Api21Impl {
        private Api21Impl() {
        }

        static String getScript(Locale r0) {
            return r0.getScript();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static ULocale forLocale(Locale r0) {
            return ULocale.forLocale(r0);
        }

        static ULocale addLikelySubtags(Object r0) {
            return ULocale.addLikelySubtags((ULocale) r0);
        }

        static String getScript(Object r0) {
            return ((ULocale) r0).getScript();
        }
    }

    static {
    }

    public static String maximizeAndGetScript(Locale r0) {
        return Api24Impl.getScript(Api24Impl.addLikelySubtags(Api24Impl.forLocale(r0)));
    }

    private static String getScriptBelowApi21(String r5) {
        Method r2 = sGetScriptMethod;     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
        if (r2 == null) goto L11;
        return (String) r2.invoke(null, new Object[]{r5});
    L11:
        return null;
    L9:
        e = move-exception;
        Log.w(TAG, e);
    L7:
        e = move-exception;
        Log.w(TAG, e);
        goto L11
    }

    private static String addLikelySubtagsBelowApi21(Locale r4) {
        String r5 = r4.toString();
        Method r1 = sAddLikelySubtagsMethod;     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
        if (r1 == null) goto L11;
        return (String) r1.invoke(null, new Object[]{r5});
    L11:
        return r5;
    L9:
        e = move-exception;
        Log.w(TAG, e);
    L7:
        e = move-exception;
        Log.w(TAG, e);
        goto L11
    }

    private ICUCompat() {
    }
}
