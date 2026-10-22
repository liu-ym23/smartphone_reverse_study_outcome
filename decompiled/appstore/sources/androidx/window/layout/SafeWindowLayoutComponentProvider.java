package androidx.window.layout;

import androidx.window.extensions.layout.WindowLayoutComponent;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
public final class SafeWindowLayoutComponentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SafeWindowLayoutComponentProvider f5263a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f5264b = null;

    static {
        f5263a = new SafeWindowLayoutComponentProvider();
        f5264b = kotlin.b.b(SafeWindowLayoutComponentProvider$windowLayoutComponent$2.INSTANCE);
    }

    public SafeWindowLayoutComponentProvider() {
    }

    public static final /* synthetic */ boolean a(SafeWindowLayoutComponentProvider r10, ClassLoader r11) {
        return r10.i(r11);
    }

    public static final /* synthetic */ boolean b(SafeWindowLayoutComponentProvider r10, Method r11, Class r12) {
        return r10.j(r11, r12);
    }

    public static final /* synthetic */ boolean c(SafeWindowLayoutComponentProvider r10, Method r11, KClass r12) {
        return r10.k(r11, r12);
    }

    public static final /* synthetic */ Class d(SafeWindowLayoutComponentProvider r10, ClassLoader r11) {
        return r10.l(r11);
    }

    public static final /* synthetic */ boolean e(SafeWindowLayoutComponentProvider r10, Method r11) {
        return r10.o(r11);
    }

    public static final /* synthetic */ Class f(SafeWindowLayoutComponentProvider r10, ClassLoader r11) {
        return r10.t(r11);
    }

    public static final /* synthetic */ Class g(SafeWindowLayoutComponentProvider r10, ClassLoader r11) {
        return r10.u(r11);
    }

    public static final /* synthetic */ Class h(SafeWindowLayoutComponentProvider r10, ClassLoader r11) {
        return r10.v(r11);
    }

    public final boolean i(ClassLoader r10) {
        if (r(r10) == true) goto L5;
    L11:
        return false;
    L5:
        if (p(r10) == false) goto L11;
        if (q(r10) == false) goto L11;
        if (n(r10) == false) goto L11;
        return true;
    }

    public final boolean j(Method r10, Class r11) {
        return r10.getReturnType().equals(r11);
    }

    public final boolean k(Method r10, KClass r11) {
        return j(r10, xf.a.a(r11));
    }

    public final Class l(ClassLoader r10) {
        return r10.loadClass("androidx.window.extensions.layout.FoldingFeature");
    }

    public final WindowLayoutComponent m() {
        return (WindowLayoutComponent) f5264b.getValue();
    }

    public final boolean n(final ClassLoader r10) {
        return s(new SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1(r10));
    }

    public final boolean o(Method r10) {
        return Modifier.isPublic(r10.getModifiers());
    }

    public final boolean p(final ClassLoader r10) {
        return s(new SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1(r10));
    }

    public final boolean q(final ClassLoader r10) {
        return s(new SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1(r10));
    }

    public final boolean r(final ClassLoader r10) {
        return s(new SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1(r10));
    }

    public final boolean s(Function0 r10) {
        return ((Boolean) r10.invoke()).booleanValue();
    L8:
        return false;
    }

    public final Class t(ClassLoader r10) {
        return r10.loadClass("androidx.window.extensions.WindowExtensions");
    }

    public final Class u(ClassLoader r10) {
        return r10.loadClass("androidx.window.extensions.WindowExtensionsProvider");
    }

    public final Class v(ClassLoader r10) {
        return r10.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
    }
}
