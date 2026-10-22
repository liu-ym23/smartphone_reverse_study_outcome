package androidx.window.layout;

import C7.f;
import Z7.d;
import androidx.annotation.RequiresApi;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\f\u0010\bJ\u001d\u0010\u000f\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u0006*\u00020\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0014\u001a\u00020\u0006*\u00020\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002¢\u0006\u0004\b\u0014\u0010\u0017J'\u0010\u0019\u001a\u0012\u0012\u0002\b\u0003 \u0018*\b\u0012\u0002\b\u0003\u0018\u00010\u00160\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001b\u001a\u0012\u0012\u0002\b\u0003 \u0018*\b\u0012\u0002\b\u0003\u0018\u00010\u00160\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ'\u0010\u001c\u001a\u0012\u0012\u0002\b\u0003 \u0018*\b\u0012\u0002\b\u0003\u0018\u00010\u00160\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001aJ'\u0010\u001d\u001a\u0012\u0012\u0002\b\u0003 \u0018*\b\u0012\u0002\b\u0003\u0018\u00010\u00160\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001aR\u001d\u0010#\u001a\u0004\u0018\u00010\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0018\u0010$\u001a\u00020\u0006*\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Landroidx/window/layout/SafeWindowLayoutComponentProvider;", "", AppAgent.CONSTRUCT, "()V", "Ljava/lang/ClassLoader;", "classLoader", "", "canUseWindowLayoutComponent", "(Ljava/lang/ClassLoader;)Z", "isWindowLayoutProviderValid", "isWindowExtensionsValid", "isFoldingFeatureValid", "isWindowLayoutComponentValid", "Lkotlin/Function0;", "block", "validate", "(LS7/a;)Z", "Ljava/lang/reflect/Method;", "LZ7/d;", "clazz", "doesReturn", "(Ljava/lang/reflect/Method;LZ7/d;)Z", "Ljava/lang/Class;", "(Ljava/lang/reflect/Method;Ljava/lang/Class;)Z", "kotlin.jvm.PlatformType", "windowExtensionsProviderClass", "(Ljava/lang/ClassLoader;)Ljava/lang/Class;", "windowExtensionsClass", "foldingFeatureClass", "windowLayoutComponentClass", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "windowLayoutComponent$delegate", "LC7/f;", "getWindowLayoutComponent", "()Landroidx/window/extensions/layout/WindowLayoutComponent;", "windowLayoutComponent", "isPublic", "(Ljava/lang/reflect/Method;)Z", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SafeWindowLayoutComponentProvider {
    public static final SafeWindowLayoutComponentProvider INSTANCE = new SafeWindowLayoutComponentProvider();

    /* renamed from: windowLayoutComponent$delegate, reason: from kotlin metadata */
    private static final f windowLayoutComponent = kotlin.a.a(new S7.a() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$windowLayoutComponent$2
        @Override // S7.a
        public final WindowLayoutComponent invoke() {
            ClassLoader classLoader = SafeWindowLayoutComponentProvider.class.getClassLoader();
            if (classLoader == null || !SafeWindowLayoutComponentProvider.INSTANCE.canUseWindowLayoutComponent(classLoader)) {
                return null;
            }
            try {
                return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
            } catch (UnsupportedOperationException unused) {
                return null;
            }
        }
    });

    private SafeWindowLayoutComponentProvider() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canUseWindowLayoutComponent(ClassLoader classLoader) {
        return isWindowLayoutProviderValid(classLoader) && isWindowExtensionsValid(classLoader) && isWindowLayoutComponentValid(classLoader) && isFoldingFeatureValid(classLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doesReturn(Method method, d dVar) {
        return doesReturn(method, M.a.Z(dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> foldingFeatureClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.FoldingFeature");
    }

    private final boolean isFoldingFeatureValid(final ClassLoader classLoader) {
        return validate(new S7.a() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider.isFoldingFeatureValid.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0062  */
            @Override // S7.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.SecurityException {
                /*
                    r5 = this;
                    androidx.window.layout.SafeWindowLayoutComponentProvider r0 = androidx.window.layout.SafeWindowLayoutComponentProvider.INSTANCE
                    java.lang.ClassLoader r5 = r1
                    java.lang.Class r5 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$foldingFeatureClass(r0, r5)
                    java.lang.String r1 = "getBounds"
                    r2 = 0
                    java.lang.reflect.Method r1 = r5.getMethod(r1, r2)
                    java.lang.String r3 = "getType"
                    java.lang.reflect.Method r3 = r5.getMethod(r3, r2)
                    java.lang.String r4 = "getState"
                    java.lang.reflect.Method r5 = r5.getMethod(r4, r2)
                    java.lang.String r2 = "getBoundsMethod"
                    kotlin.jvm.internal.k.e(r1, r2)
                    kotlin.jvm.internal.n r2 = kotlin.jvm.internal.m.f4928a
                    java.lang.Class<android.graphics.Rect> r4 = android.graphics.Rect.class
                    Z7.d r4 = r2.b(r4)
                    boolean r4 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$doesReturn(r0, r1, r4)
                    if (r4 == 0) goto L62
                    boolean r1 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$isPublic(r0, r1)
                    if (r1 == 0) goto L62
                    java.lang.String r1 = "getTypeMethod"
                    kotlin.jvm.internal.k.e(r3, r1)
                    java.lang.Class r1 = java.lang.Integer.TYPE
                    Z7.d r4 = r2.b(r1)
                    boolean r4 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$doesReturn(r0, r3, r4)
                    if (r4 == 0) goto L62
                    boolean r3 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$isPublic(r0, r3)
                    if (r3 == 0) goto L62
                    java.lang.String r3 = "getStateMethod"
                    kotlin.jvm.internal.k.e(r5, r3)
                    Z7.d r1 = r2.b(r1)
                    boolean r1 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$doesReturn(r0, r5, r1)
                    if (r1 == 0) goto L62
                    boolean r5 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$isPublic(r0, r5)
                    if (r5 == 0) goto L62
                    r5 = 1
                    goto L63
                L62:
                    r5 = 0
                L63:
                    java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SafeWindowLayoutComponentProvider.AnonymousClass1.invoke():java.lang.Boolean");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPublic(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    private final boolean isWindowExtensionsValid(final ClassLoader classLoader) {
        return validate(new S7.a() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider.isWindowExtensionsValid.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
            @Override // S7.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.SecurityException {
                /*
                    r4 = this;
                    androidx.window.layout.SafeWindowLayoutComponentProvider r0 = androidx.window.layout.SafeWindowLayoutComponentProvider.INSTANCE
                    java.lang.ClassLoader r1 = r1
                    java.lang.Class r1 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$windowExtensionsClass(r0, r1)
                    java.lang.String r2 = "getWindowLayoutComponent"
                    r3 = 0
                    java.lang.reflect.Method r1 = r1.getMethod(r2, r3)
                    java.lang.ClassLoader r4 = r1
                    java.lang.Class r4 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$windowLayoutComponentClass(r0, r4)
                    java.lang.String r2 = "getWindowLayoutComponentMethod"
                    kotlin.jvm.internal.k.e(r1, r2)
                    boolean r2 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$isPublic(r0, r1)
                    if (r2 == 0) goto L2d
                    java.lang.String r2 = "windowLayoutComponentClass"
                    kotlin.jvm.internal.k.e(r4, r2)
                    boolean r4 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$doesReturn(r0, r1, r4)
                    if (r4 == 0) goto L2d
                    r4 = 1
                    goto L2e
                L2d:
                    r4 = 0
                L2e:
                    java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SafeWindowLayoutComponentProvider.C08171.invoke():java.lang.Boolean");
            }
        });
    }

    @RequiresApi(24)
    private final boolean isWindowLayoutComponentValid(final ClassLoader classLoader) {
        return validate(new S7.a() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider.isWindowLayoutComponentValid.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0038  */
            @Override // S7.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.SecurityException {
                /*
                    r4 = this;
                    androidx.window.layout.SafeWindowLayoutComponentProvider r0 = androidx.window.layout.SafeWindowLayoutComponentProvider.INSTANCE
                    java.lang.ClassLoader r4 = r1
                    java.lang.Class r4 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$windowLayoutComponentClass(r0, r4)
                    java.lang.Class<android.app.Activity> r1 = android.app.Activity.class
                    java.lang.Class<java.util.function.Consumer> r2 = java.util.function.Consumer.class
                    java.lang.Class[] r1 = new java.lang.Class[]{r1, r2}
                    java.lang.String r3 = "addWindowLayoutInfoListener"
                    java.lang.reflect.Method r1 = r4.getMethod(r3, r1)
                    java.lang.String r3 = "removeWindowLayoutInfoListener"
                    java.lang.Class[] r2 = new java.lang.Class[]{r2}
                    java.lang.reflect.Method r4 = r4.getMethod(r3, r2)
                    java.lang.String r2 = "addListenerMethod"
                    kotlin.jvm.internal.k.e(r1, r2)
                    boolean r1 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$isPublic(r0, r1)
                    if (r1 == 0) goto L38
                    java.lang.String r1 = "removeListenerMethod"
                    kotlin.jvm.internal.k.e(r4, r1)
                    boolean r4 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$isPublic(r0, r4)
                    if (r4 == 0) goto L38
                    r4 = 1
                    goto L39
                L38:
                    r4 = 0
                L39:
                    java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SafeWindowLayoutComponentProvider.C08181.invoke():java.lang.Boolean");
            }
        });
    }

    private final boolean isWindowLayoutProviderValid(final ClassLoader classLoader) {
        return validate(new S7.a() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider.isWindowLayoutProviderValid.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // S7.a
            public final Boolean invoke() throws NoSuchMethodException, SecurityException {
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
                Method getWindowExtensionsMethod = safeWindowLayoutComponentProvider.windowExtensionsProviderClass(classLoader).getDeclaredMethod("getWindowExtensions", null);
                Class windowExtensionsClass = safeWindowLayoutComponentProvider.windowExtensionsClass(classLoader);
                k.e(getWindowExtensionsMethod, "getWindowExtensionsMethod");
                k.e(windowExtensionsClass, "windowExtensionsClass");
                return Boolean.valueOf(safeWindowLayoutComponentProvider.doesReturn(getWindowExtensionsMethod, (Class<?>) windowExtensionsClass) && safeWindowLayoutComponentProvider.isPublic(getWindowExtensionsMethod));
            }
        });
    }

    private final boolean validate(S7.a block) {
        try {
            return ((Boolean) block.invoke()).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> windowExtensionsClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensions");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> windowExtensionsProviderClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> windowLayoutComponentClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
    }

    public final WindowLayoutComponent getWindowLayoutComponent() {
        return (WindowLayoutComponent) windowLayoutComponent.getF4884a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doesReturn(Method method, Class<?> cls) {
        return method.getReturnType().equals(cls);
    }
}
