package androidx.webkit.internal;

import android.os.Build;
import android.webkit.WebView;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import nvc.a;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class WebViewGlueCommunicator {
    private static final String GLUE_FACTORY_PROVIDER_FETCHER_CLASS = "org.chromium.support_lib_glue.SupportLibReflectionUtil";
    private static final String GLUE_FACTORY_PROVIDER_FETCHER_METHOD = "createWebViewProviderFactory";

    public static class LAZY_COMPAT_CONVERTER_HOLDER {
        static final WebkitToCompatConverter INSTANCE = null;

        private LAZY_COMPAT_CONVERTER_HOLDER() {
        }

        static {
            INSTANCE = new WebkitToCompatConverter(WebViewGlueCommunicator.getFactory().getWebkitToCompatConverter());
        }
    }

    public static class LAZY_FACTORY_HOLDER {
        static final WebViewProviderFactory INSTANCE = null;

        private LAZY_FACTORY_HOLDER() {
        }

        static {
            INSTANCE = WebViewGlueCommunicator.createGlueProviderFactory();
        }
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public static ClassLoader getWebViewClassLoader() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return ApiHelperForP.getWebViewClassLoader();
    L7:
        return getWebViewProviderFactory().getClass().getClassLoader();
    }

    private static Object getWebViewProviderFactory() {
        Method r100 = WebView.class.getDeclaredMethod("getFactory", new Class[0]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L7 NoSuchMethodException -> L10
        r100.setAccessible(true);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L7 NoSuchMethodException -> L10
        return r100.invoke(null, new Object[0]);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static WebViewProviderFactory createGlueProviderFactory() {
        goto L9
    L4:
        return new WebViewProviderFactoryAdapter((WebViewProviderFactoryBoundaryInterface) a.a(WebViewProviderFactoryBoundaryInterface.class, fetchGlueProviderFactoryImpl()));
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L9:
        return new IncompatibleApkWebViewProviderFactory();
    }

    private static InvocationHandler fetchGlueProviderFactoryImpl() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        return (InvocationHandler) INVOKESTATIC_androidx_webkit_internal_WebViewGlueCommunicator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(GLUE_FACTORY_PROVIDER_FETCHER_CLASS, false, getWebViewClassLoader()).getDeclaredMethod(GLUE_FACTORY_PROVIDER_FETCHER_METHOD, new Class[0]).invoke(null, new Object[0]);
    }

    private WebViewGlueCommunicator() {
    }

    public static WebkitToCompatConverter getCompatConverter() {
        return LAZY_COMPAT_CONVERTER_HOLDER.INSTANCE;
    }

    public static WebViewProviderFactory getFactory() {
        return LAZY_FACTORY_HOLDER.INSTANCE;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_webkit_internal_WebViewGlueCommunicator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
}
