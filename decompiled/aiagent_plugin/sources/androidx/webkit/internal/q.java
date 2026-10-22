package androidx.webkit.internal;

import android.os.Build;
import android.webkit.WebView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: WebViewGlueCommunicator.java */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: compiled from: WebViewGlueCommunicator.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final v f3007a = null;

        static {
            f3007a = new v(q.a().a());
        }
    }

    /* JADX INFO: compiled from: WebViewGlueCommunicator.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final s f3008a = null;

        static {
            f3008a = q.c();
        }
    }

    public static s a() {
        return b.f3008a;
    }

    public static v b() {
        return a.f3007a;
    }

    private static InvocationHandler e() {
        return (InvocationHandler) ZeusTransformUtils.preCheckCast(Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, d()).getDeclaredMethod("createWebViewProviderFactory", new Class[0]).invoke(null, new Object[0]), InvocationHandler.class, "com.obric.aiagent.plugin");
    }

    static s c() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        goto L13
    L8:
        return new t((WebViewProviderFactoryBoundaryInterface) ZeusTransformUtils.preCheckCast(org.chromium.support_lib_boundary.a.a.a(WebViewProviderFactoryBoundaryInterface.class, e()), WebViewProviderFactoryBoundaryInterface.class, "com.obric.aiagent.plugin"));
    L17:
        e = move-exception;
        throw new RuntimeException(e);
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    L13:
        return new h();
    L5:
        return new h();
    }

    public static ClassLoader d() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return f.b();
    L7:
        return f().getClass().getClassLoader();
    }

    private static Object f() {
        Method r0 = WebView.class.getDeclaredMethod("getFactory", new Class[0]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L7 NoSuchMethodException -> L10
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L7 NoSuchMethodException -> L10
        return r0.invoke(null, new Object[0]);
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
}
