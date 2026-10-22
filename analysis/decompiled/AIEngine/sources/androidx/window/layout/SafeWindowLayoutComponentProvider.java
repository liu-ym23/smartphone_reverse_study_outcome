package androidx.window.layout;

import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SafeWindowLayoutComponentProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final SafeWindowLayoutComponentProvider f2688a = new SafeWindowLayoutComponentProvider();

    /* renamed from: b, reason: collision with root package name */
    public static final lb.d f2689b = kotlin.b.b(new zb.a<WindowLayoutComponent>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$windowLayoutComponent$2
        public static WindowLayoutComponent b() {
            final ClassLoader classLoader = SafeWindowLayoutComponentProvider.class.getClassLoader();
            if (classLoader != null) {
                SafeWindowLayoutComponentProvider.f2688a.getClass();
                if (SafeWindowLayoutComponentProvider.b(new zb.a<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // zb.a
                    public final Boolean invoke() throws NoSuchMethodException, SecurityException, ClassNotFoundException {
                        SafeWindowLayoutComponentProvider.f2688a.getClass();
                        ClassLoader classLoader2 = classLoader;
                        Method getWindowExtensionsMethod = classLoader2.loadClass("androidx.window.extensions.WindowExtensionsProvider").getDeclaredMethod("getWindowExtensions", null);
                        Class<?> windowExtensionsClass = classLoader2.loadClass("androidx.window.extensions.WindowExtensions");
                        kotlin.jvm.internal.g.e(getWindowExtensionsMethod, "getWindowExtensionsMethod");
                        kotlin.jvm.internal.g.e(windowExtensionsClass, "windowExtensionsClass");
                        return Boolean.valueOf(getWindowExtensionsMethod.getReturnType().equals(windowExtensionsClass) && Modifier.isPublic(getWindowExtensionsMethod.getModifiers()));
                    }
                }) && SafeWindowLayoutComponentProvider.b(new zb.a<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x003a  */
                    @Override // zb.a
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.ClassNotFoundException {
                        /*
                            r3 = this;
                            androidx.window.layout.SafeWindowLayoutComponentProvider r0 = androidx.window.layout.SafeWindowLayoutComponentProvider.f2688a
                            r0.getClass()
                            java.lang.String r0 = "androidx.window.extensions.WindowExtensions"
                            java.lang.ClassLoader r3 = r1
                            java.lang.Class r0 = r3.loadClass(r0)
                            java.lang.String r1 = "getWindowLayoutComponent"
                            r2 = 0
                            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)
                            java.lang.String r1 = "androidx.window.extensions.layout.WindowLayoutComponent"
                            java.lang.Class r3 = r3.loadClass(r1)
                            java.lang.String r1 = "getWindowLayoutComponentMethod"
                            kotlin.jvm.internal.g.e(r0, r1)
                            int r1 = r0.getModifiers()
                            boolean r1 = java.lang.reflect.Modifier.isPublic(r1)
                            if (r1 == 0) goto L3a
                            java.lang.String r1 = "windowLayoutComponentClass"
                            kotlin.jvm.internal.g.e(r3, r1)
                            java.lang.Class r0 = r0.getReturnType()
                            boolean r3 = r0.equals(r3)
                            if (r3 == 0) goto L3a
                            r3 = 1
                            goto L3b
                        L3a:
                            r3 = 0
                        L3b:
                            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                            return r3
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1.invoke():java.lang.Object");
                    }
                }) && SafeWindowLayoutComponentProvider.b(new zb.a<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0045  */
                    @Override // zb.a
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException {
                        /*
                            r3 = this;
                            androidx.window.layout.SafeWindowLayoutComponentProvider r0 = androidx.window.layout.SafeWindowLayoutComponentProvider.f2688a
                            r0.getClass()
                            java.lang.String r0 = "androidx.window.extensions.layout.WindowLayoutComponent"
                            java.lang.ClassLoader r3 = r1
                            java.lang.Class r3 = r3.loadClass(r0)
                            java.lang.Class<android.app.Activity> r0 = android.app.Activity.class
                            java.lang.Class<java.util.function.Consumer> r1 = java.util.function.Consumer.class
                            java.lang.Class[] r0 = new java.lang.Class[]{r0, r1}
                            java.lang.String r2 = "addWindowLayoutInfoListener"
                            java.lang.reflect.Method r0 = r3.getMethod(r2, r0)
                            java.lang.String r2 = "removeWindowLayoutInfoListener"
                            java.lang.Class[] r1 = new java.lang.Class[]{r1}
                            java.lang.reflect.Method r3 = r3.getMethod(r2, r1)
                            java.lang.String r1 = "addListenerMethod"
                            kotlin.jvm.internal.g.e(r0, r1)
                            int r0 = r0.getModifiers()
                            boolean r0 = java.lang.reflect.Modifier.isPublic(r0)
                            if (r0 == 0) goto L45
                            java.lang.String r0 = "removeListenerMethod"
                            kotlin.jvm.internal.g.e(r3, r0)
                            int r3 = r3.getModifiers()
                            boolean r3 = java.lang.reflect.Modifier.isPublic(r3)
                            if (r3 == 0) goto L45
                            r3 = 1
                            goto L46
                        L45:
                            r3 = 0
                        L46:
                            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                            return r3
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1.invoke():java.lang.Object");
                    }
                }) && SafeWindowLayoutComponentProvider.b(new zb.a<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0089  */
                    @Override // zb.a
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException {
                        /*
                            r4 = this;
                            androidx.window.layout.SafeWindowLayoutComponentProvider r0 = androidx.window.layout.SafeWindowLayoutComponentProvider.f2688a
                            r0.getClass()
                            java.lang.String r0 = "androidx.window.extensions.layout.FoldingFeature"
                            java.lang.ClassLoader r4 = r1
                            java.lang.Class r4 = r4.loadClass(r0)
                            java.lang.String r0 = "getBounds"
                            r1 = 0
                            java.lang.reflect.Method r0 = r4.getMethod(r0, r1)
                            java.lang.String r2 = "getType"
                            java.lang.reflect.Method r2 = r4.getMethod(r2, r1)
                            java.lang.String r3 = "getState"
                            java.lang.reflect.Method r4 = r4.getMethod(r3, r1)
                            java.lang.String r1 = "getBoundsMethod"
                            kotlin.jvm.internal.g.e(r0, r1)
                            java.lang.Class<android.graphics.Rect> r1 = android.graphics.Rect.class
                            kotlin.jvm.internal.c r1 = kotlin.jvm.internal.i.a(r1)
                            java.lang.Class r1 = xb.a.e(r1)
                            java.lang.Class r3 = r0.getReturnType()
                            boolean r1 = r3.equals(r1)
                            if (r1 == 0) goto L89
                            int r0 = r0.getModifiers()
                            boolean r0 = java.lang.reflect.Modifier.isPublic(r0)
                            if (r0 == 0) goto L89
                            java.lang.String r0 = "getTypeMethod"
                            kotlin.jvm.internal.g.e(r2, r0)
                            java.lang.Class r0 = java.lang.Integer.TYPE
                            kotlin.jvm.internal.c r1 = kotlin.jvm.internal.i.a(r0)
                            java.lang.Class r1 = xb.a.e(r1)
                            java.lang.Class r3 = r2.getReturnType()
                            boolean r1 = r3.equals(r1)
                            if (r1 == 0) goto L89
                            int r1 = r2.getModifiers()
                            boolean r1 = java.lang.reflect.Modifier.isPublic(r1)
                            if (r1 == 0) goto L89
                            java.lang.String r1 = "getStateMethod"
                            kotlin.jvm.internal.g.e(r4, r1)
                            kotlin.jvm.internal.c r0 = kotlin.jvm.internal.i.a(r0)
                            java.lang.Class r0 = xb.a.e(r0)
                            java.lang.Class r1 = r4.getReturnType()
                            boolean r0 = r1.equals(r0)
                            if (r0 == 0) goto L89
                            int r4 = r4.getModifiers()
                            boolean r4 = java.lang.reflect.Modifier.isPublic(r4)
                            if (r4 == 0) goto L89
                            r4 = 1
                            goto L8a
                        L89:
                            r4 = 0
                        L8a:
                            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1.invoke():java.lang.Object");
                    }
                })) {
                    try {
                        return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
                    } catch (UnsupportedOperationException unused) {
                        return null;
                    }
                }
            }
            return null;
        }

        @Override // zb.a
        public final /* bridge */ /* synthetic */ WindowLayoutComponent invoke() {
            return b();
        }
    });

    public static WindowLayoutComponent a() {
        return (WindowLayoutComponent) f2689b.getValue();
    }

    public static boolean b(zb.a aVar) {
        try {
            return ((Boolean) aVar.invoke()).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }
}
