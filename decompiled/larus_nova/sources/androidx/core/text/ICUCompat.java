package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static String getScript(Locale r100) {
            return r100.getScript();
        }
    }

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static ULocale addLikelySubtags(Object r100) {
            return ULocale.addLikelySubtags((ULocale) r100);
        }

        public static ULocale forLocale(Locale r100) {
            return ULocale.forLocale(r100);
        }

        public static String getScript(Object r100) {
            return ((ULocale) r100).getScript();
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        if (Build.VERSION.SDK_INT < 24) goto L10;
        return;
    L10:
        sAddLikelySubtagsMethod = INVOKESTATIC_androidx_core_text_ICUCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private ICUCompat() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_core_text_ICUCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static String addLikelySubtagsBelowApi21(Locale r100) {
        String r101 = r100.toString();
        Method r102 = sAddLikelySubtagsMethod;     // Catch: Throwable -> L8
        if (r102 == null) goto L7;
        return (String) r102.invoke(null, new Object[]{r101});
    L7:
        return r101;
    }

    private static String getScriptBelowApi21(String r100) {
        Method r101 = sGetScriptMethod;     // Catch: Throwable -> L8
        if (r101 == null) goto L7;
        return (String) r101.invoke(null, new Object[]{r100});
    L7:
        return null;
    }

    public static String maximizeAndGetScript(Locale r100) {
        if (Build.VERSION.SDK_INT < 24) goto L11;
        return Api24Impl.getScript(Api24Impl.addLikelySubtags(Api24Impl.forLocale(r100)));
    L11:
        return Api21Impl.getScript((Locale) sAddLikelySubtagsMethod.invoke(null, new Object[]{r100}));
    L10:
        return Api21Impl.getScript(r100);
    }
}
