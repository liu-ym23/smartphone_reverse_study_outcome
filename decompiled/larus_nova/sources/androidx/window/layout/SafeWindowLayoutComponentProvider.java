package androidx.window.layout;

import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import com.alipay.sdk.m.l.c;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u0016\u0010\u001e\u001a\u00020\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160 H\u0002J\u0018\u0010!\u001a\u00020\u0016*\u00020\u00172\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0018\u0010!\u001a\u00020\u0016*\u00020\u00172\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0018\u0010\r\u001a\u0006\u0012\u0002\b\u00030\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0018\u0010\u0015\u001a\u00020\u0016*\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0018¨\u0006$"}, d2 = {"Landroidx/window/layout/SafeWindowLayoutComponentProvider;", "", "loader", "Ljava/lang/ClassLoader;", "consumerAdapter", "Landroidx/window/core/ConsumerAdapter;", "(Ljava/lang/ClassLoader;Landroidx/window/core/ConsumerAdapter;)V", "foldingFeatureClass", "Ljava/lang/Class;", "getFoldingFeatureClass", "()Ljava/lang/Class;", "windowExtensionsClass", "getWindowExtensionsClass", "windowExtensionsProviderClass", "getWindowExtensionsProviderClass", "windowLayoutComponent", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "getWindowLayoutComponent", "()Landroidx/window/extensions/layout/WindowLayoutComponent;", "windowLayoutComponentClass", "getWindowLayoutComponentClass", "isPublic", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)Z", "canUseWindowLayoutComponent", "isFoldingFeatureValid", "isWindowExtensionsValid", "isWindowLayoutComponentValid", "isWindowLayoutProviderValid", c.f25505j, "block", "Lkotlin/Function0;", "doesReturn", "clazz", "Lkotlin/reflect/KClass;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SafeWindowLayoutComponentProvider {
    private final ConsumerAdapter consumerAdapter;
    private final ClassLoader loader;

    private final Class<?> getFoldingFeatureClass() {
        return INVOKEVIRTUAL_androidx_window_layout_SafeWindowLayoutComponentProvider_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(this.loader, "androidx.window.extensions.layout.FoldingFeature");
    }

    private final Class<?> getWindowExtensionsClass() {
        return INVOKEVIRTUAL_androidx_window_layout_SafeWindowLayoutComponentProvider_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(this.loader, "androidx.window.extensions.WindowExtensions");
    }

    private final Class<?> getWindowExtensionsProviderClass() {
        return INVOKEVIRTUAL_androidx_window_layout_SafeWindowLayoutComponentProvider_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(this.loader, "androidx.window.extensions.WindowExtensionsProvider");
    }

    private final Class<?> getWindowLayoutComponentClass() {
        return INVOKEVIRTUAL_androidx_window_layout_SafeWindowLayoutComponentProvider_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(this.loader, "androidx.window.extensions.layout.WindowLayoutComponent");
    }

    private final boolean isFoldingFeatureValid() {
        return validate(new AnonymousClass1(this));
    }

    private final boolean isWindowExtensionsValid() {
        return validate(new C88041(this));
    }

    private final boolean isWindowLayoutComponentValid() {
        return validate(new C88051(this));
    }

    private final boolean isWindowLayoutProviderValid() {
        return validate(new C88061(this));
    }

    private final boolean canUseWindowLayoutComponent() {
        if (isWindowLayoutProviderValid() == true) goto L5;
    L11:
        return false;
    L5:
        if (isWindowExtensionsValid() == false) goto L11;
        if (isWindowLayoutComponentValid() == false) goto L11;
        if (isFoldingFeatureValid() == false) goto L11;
        return true;
    }

    public final WindowLayoutComponent getWindowLayoutComponent() {
        if (canUseWindowLayoutComponent() == true) goto L9;
        WindowLayoutComponent r100 = (WindowLayoutComponent) null;
        return null;
    L9:
        return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
    L6:
        WindowLayoutComponent r101 = (WindowLayoutComponent) null;
        return null;
    }

    public static final /* synthetic */ ConsumerAdapter access$getConsumerAdapter$p(SafeWindowLayoutComponentProvider r100) {
        return r100.consumerAdapter;
    }

    public static final /* synthetic */ Class access$getFoldingFeatureClass(SafeWindowLayoutComponentProvider r100) {
        return r100.getFoldingFeatureClass();
    }

    public static final /* synthetic */ Class access$getWindowExtensionsClass(SafeWindowLayoutComponentProvider r100) {
        return r100.getWindowExtensionsClass();
    }

    public static final /* synthetic */ Class access$getWindowExtensionsProviderClass(SafeWindowLayoutComponentProvider r100) {
        return r100.getWindowExtensionsProviderClass();
    }

    public static final /* synthetic */ Class access$getWindowLayoutComponentClass(SafeWindowLayoutComponentProvider r100) {
        return r100.getWindowLayoutComponentClass();
    }

    private final boolean isPublic(Method r100) {
        return Modifier.isPublic(r100.getModifiers());
    }

    private final boolean validate(Function0<Boolean> r100) {
        return r100.invoke().booleanValue();
    L8:
        return false;
    }

    public SafeWindowLayoutComponentProvider(ClassLoader r100, ConsumerAdapter r101) {
        Intrinsics.checkNotNullParameter(r100, "loader");
        Intrinsics.checkNotNullParameter(r101, "consumerAdapter");
        this.loader = r100;
        this.consumerAdapter = r101;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_androidx_window_layout_SafeWindowLayoutComponentProvider_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    public static final /* synthetic */ boolean access$isPublic(SafeWindowLayoutComponentProvider r100, Method r101) {
        return r100.isPublic(r101);
    }

    private final boolean doesReturn(Method r100, Class<?> r101) {
        return r100.getReturnType().equals(r101);
    }

    private final boolean doesReturn(Method r100, KClass<?> r101) {
        return doesReturn(r100, JvmClassMappingKt.getJavaClass(r101));
    }

    public static final /* synthetic */ boolean access$doesReturn(SafeWindowLayoutComponentProvider r100, Method r101, Class r102) {
        return r100.doesReturn(r101, r102);
    }

    public static final /* synthetic */ boolean access$doesReturn(SafeWindowLayoutComponentProvider r100, Method r101, KClass r102) {
        return r100.doesReturn(r101, r102);
    }
}
