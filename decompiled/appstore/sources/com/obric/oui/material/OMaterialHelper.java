package com.obric.oui.material;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.VectorDrawable;
import android.provider.Settings;
import android.util.Log;
import android.view.IExtView;
import android.view.View;
import com.obric.oui.graphic.BlendMode;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OMaterialHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Integer f15209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f15210b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f15211c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float[] f15212d = null;

    @Deprecated
    public static final enum LEGACY_BLEND_MODE extends Enum<LEGACY_BLEND_MODE> {
        private static final /* synthetic */ LEGACY_BLEND_MODE[] $VALUES = null;
        public static final LEGACY_BLEND_MODE COLOR_BURN = null;
        public static final LEGACY_BLEND_MODE COLOR_DODGE = null;
        public static final LEGACY_BLEND_MODE DEFAULT = null;
        public static final LEGACY_BLEND_MODE LUMINOSITY = null;
        public static final LEGACY_BLEND_MODE OVERLAY = null;
        public static final LEGACY_BLEND_MODE PLUS_DARKER = null;
        public static final LEGACY_BLEND_MODE PLUS_LIGHTER = null;
        public static final LEGACY_BLEND_MODE SOFT_LIGHT = null;

        static {
            LEGACY_BLEND_MODE r10 = new LEGACY_BLEND_MODE("DEFAULT", 0);
            DEFAULT = r10;
            LEGACY_BLEND_MODE r11 = new LEGACY_BLEND_MODE("COLOR_BURN", 1);
            COLOR_BURN = r11;
            LEGACY_BLEND_MODE r12 = new LEGACY_BLEND_MODE("COLOR_DODGE", 2);
            COLOR_DODGE = r12;
            LEGACY_BLEND_MODE r13 = new LEGACY_BLEND_MODE("PLUS_DARKER", 3);
            PLUS_DARKER = r13;
            LEGACY_BLEND_MODE r14 = new LEGACY_BLEND_MODE("PLUS_LIGHTER", 4);
            PLUS_LIGHTER = r14;
            LEGACY_BLEND_MODE r15 = new LEGACY_BLEND_MODE("LUMINOSITY", 5);
            LUMINOSITY = r15;
            LEGACY_BLEND_MODE r16 = new LEGACY_BLEND_MODE("OVERLAY", 6);
            OVERLAY = r16;
            LEGACY_BLEND_MODE r17 = new LEGACY_BLEND_MODE("SOFT_LIGHT", 7);
            SOFT_LIGHT = r17;
            $VALUES = new LEGACY_BLEND_MODE[]{r10, r11, r12, r13, r14, r15, r16, r17};
        }

        private LEGACY_BLEND_MODE(String r10, int r11) {
            super(r10, r11);
        }

        public static LEGACY_BLEND_MODE valueOf(String r10) {
            return (LEGACY_BLEND_MODE) Enum.valueOf(LEGACY_BLEND_MODE.class, r10);
        }

        public static LEGACY_BLEND_MODE[] values() {
            return (LEGACY_BLEND_MODE[]) $VALUES.clone();
        }
    }

    public interface PaintApplier {
        void apply(Paint r10);
    }

    static {
        f15210b = new HashMap();
        f15211c = new HashMap();
        f15212d = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public static void A(Object r10, int... r11) {
        if (v() == true) goto L5;
        return;
    L5:
        Object r12 = k(r10);
        Map r13 = f15210b;
        Method r14 = (Method) r13.get("setObricBlendEffectToShadow");
        if (r14 == null) goto L15;
    L10:
        if (r12 == null) goto L17;
        r14.invoke(r12, new Object[]{r11});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("OMaterialHelper", "setBlendEffectToShadow error: " + e);
        return;
    L17:
        return;
    L15:
        r14 = NativeReflect.a(Class.forName("android.view.IExtEffect"), "setObricBlendEffectToShadow", new Class[]{int[].class});     // Catch: Exception -> L8
        r14.setAccessible(true);     // Catch: Exception -> L8
        r13.put("setObricBlendEffectToShadow", r14);     // Catch: Exception -> L8
        goto L10
    }

    public static void B(Object r10, float r11, float r12, int r13, int r14, float r15) {
        if (v() == true) goto L5;
        return;
    L5:
        Object r16 = k(r10);
        Map r17 = f15210b;
        Method r18 = (Method) r17.get("setObricBlurEffect_5");
        if (r18 == null) goto L14;
    L10:
        r18.invoke(r16, new Object[]{Float.valueOf(r11), Float.valueOf(r12), Integer.valueOf(r13), Integer.valueOf(r14), Float.valueOf(r15)});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        Class<?> r19 = Class.forName("android.view.IExtEffect");     // Catch: Exception -> L8
        Class r20 = Float.TYPE;     // Catch: Exception -> L8
        Class r21 = Integer.TYPE;     // Catch: Exception -> L8
        r18 = NativeReflect.a(r19, "setObricBlurEffect", new Class[]{r20, r20, r21, r21, r20});     // Catch: Exception -> L8
        r18.setAccessible(true);     // Catch: Exception -> L8
        r17.put("setObricBlurEffect_5", r18);     // Catch: Exception -> L8
        goto L10
    }

    public static void C(Object r10, pc.a r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        B(r10, r11.b(), r11.a(), r11.d(), r11.c(), r11.e());
    }

    public static void D(View r10, b r11) {
        E(r10, r11, 2);
    }

    public static void E(View r10, b r11, int r12) {
        if (r10 == null) goto L34;
        if (r11 != null) goto L6;
        return;
    L6:
        if (v() == false) goto L8;
        H(r10, r12, 1);
        if (r11.b() == null) goto L26;
        z(r10, V(r11.b()));
    L26:
        if (r11.d() == null) goto L35;
        C(r10, r11.d());
        return;
    L35:
        return;
    L8:
        if (r11.d() != null) goto L10;
        return;
    L10:
        if (r11.b() == null) goto L33;
        int[] r13 = V(r11.b());
        if (i.f15285b == true) goto L20;
        int r14 = 0;
    L15:
        if (r14 >= r13.length) goto L20;
        if ((r14 % 2) == 0) goto L19;
        r13[r14] = BlendMode.mapToLegacyObricBlend(r13[r14], true);
    L19:
        r14 = r14 + 1;
    L20:
        x(r10, r11.d().d(), r11.d().b(), r13);
        return;
    L33:
        return;
    }

    public static void F(Object r10, int r11) {
        if (v() == true) goto L5;
        return;
    L5:
        Object r12 = k(r10);
        Map r13 = f15210b;
        Method r14 = (Method) r13.get("setObricEffectSource_1");
        if (r14 == null) goto L14;
    L10:
        r14.invoke(r12, new Object[]{Integer.valueOf(r11)});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("OMaterialHelper", "setEffectSrc error: " + e);
        return;
    L14:
        r14 = NativeReflect.a(Class.forName("android.view.IExtEffect"), "setObricEffectSource", new Class[]{Integer.TYPE});     // Catch: Exception -> L8
        r14.setAccessible(true);     // Catch: Exception -> L8
        r13.put("setObricEffectSource_1", r14);     // Catch: Exception -> L8
        goto L10
    }

    public static void G(Object r10, int r11) {
        H(r10, r11, 1);
    }

    public static void H(Object r10, int r11, int r12) {
        if (v() == true) goto L5;
        return;
    L5:
        Object r13 = k(r10);
        Map r14 = f15210b;
        Method r15 = (Method) r14.get("setObricEffectSource_2");
        if (r15 == null) goto L14;
    L10:
        r15.invoke(r13, new Object[]{Integer.valueOf(r11), Integer.valueOf(r12)});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        Class<?> r16 = Class.forName("android.view.IExtEffect");     // Catch: Exception -> L8
        Class r17 = Integer.TYPE;     // Catch: Exception -> L8
        r15 = NativeReflect.a(r16, "setObricEffectSource", new Class[]{r17, r17});     // Catch: Exception -> L8
        r15.setAccessible(true);     // Catch: Exception -> L8
        r14.put("setObricEffectSource_2", r15);     // Catch: Exception -> L8
        goto L10
    }

    public static void I(Object r10, View r11) {
        if (v() == true) goto L5;
        return;
    L5:
        Object r12 = k(r10);
        Map r13 = f15210b;
        Method r14 = (Method) r13.get("setObricEffectSourceTarget");
        if (r14 == null) goto L14;
    L10:
        r14.invoke(r12, new Object[]{r11});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        r14 = NativeReflect.a(Class.forName("android.view.IExtEffect"), "setObricEffectSourceTarget", new Class[]{View.class});     // Catch: Exception -> L8
        r14.setAccessible(true);     // Catch: Exception -> L8
        r13.put("setObricEffectSourceTarget", r14);     // Catch: Exception -> L8
        goto L10
    }

    public static void J(Object r10, boolean r11) {
        K(r10, r11, f15212d);
    }

    public static void K(Object r10, boolean r11, float[] r12) {
        if (v() == true) goto L5;
        return;
    L5:
        Object r13 = k(r10);
        Map r14 = f15210b;
        Method r15 = (Method) r14.get("setObricLiquidGlassEffectRR");
        if (r15 == null) goto L17;
    L10:
        if (r11 == true) goto L13;
        r12 = new float[0];     // Catch: Exception -> L8
    L13:
        r15.invoke(r13, new Object[]{r12});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("OMaterialHelper", "setFluidEffect error: " + e);
        return;
    L17:
        r15 = NativeReflect.a(Class.forName("android.view.IExtEffect"), "setObricLiquidGlassEffectRR", new Class[]{float[].class});     // Catch: Exception -> L8
        r15.setAccessible(true);     // Catch: Exception -> L8
        r14.put("setObricLiquidGlassEffectRR", r15);     // Catch: Exception -> L8
        goto L10
    }

    public static void L(Object r10, int r11, b r12) {
        N(r10, r11, 1, r12);
    }

    public static void M(Object r10, int r11, b r12, int r13, int r14) {
        O(r10, r11, r14, r12, r13);
    }

    public static void N(Object r10, int r11, int r12, b r13) {
        if (r10 == null) goto L11;
        if (r13 != null) goto L6;
        return;
    L6:
        if (t(r13) == true) goto L9;
        G(r10, 0);
        return;
    L9:
        H(r10, r11, r12);
        b(r10, r13);
        return;
    }

    public static void O(Object r10, int r11, int r12, b r13, int r14) {
        g r15 = r(r10, r14);
        if (r15 == null) goto L12;
        if (r13 == null) goto L13;
        Object r16 = r15.a();
        if (t(r13) == true) goto L10;
        G(r16, 0);
        return;
    L10:
        H(r16, r11, r12);
        b(r16, r13);
        return;
    L13:
        return;
    }

    public static void P(Object r10, int r11, b[] r12) {
        Q(r10, r11, r12, 1);
    }

    public static void Q(Object r10, int r11, b[] r12, int r13) {
        if (r12 != null) goto L4;
        return;
    L4:
        int r14 = 0;
        if (r12.length != 1) goto L9;
        N(r10, r11, r13, r12[0]);
        return;
    L9:
        if (r14 >= r12.length) goto L14;
        if (r14 != 0) goto L12;
        int r15 = 1;
    L13:
        M(r10, r11, r12[r14], r15, r13);
        r14 = r14 + 1;
        goto L9
    L12:
        r15 = 2;
        goto L13
    }

    public static void R(Object r10, float r11) {
        B(r10, r11, 1.0f, 0, 0, 1.0f);
    }

    public static void S(Object r10, int r11, float r12, int r13) {
        if (v() == true) goto L5;
        return;
    L5:
        Object r14 = k(r10);
        Map r15 = f15210b;
        Method r16 = (Method) r15.get("setObricOverlayBlendEffect_3");
        if (r16 == null) goto L14;
    L10:
        r16.invoke(r14, new Object[]{Integer.valueOf(r11), Float.valueOf(r12), Integer.valueOf(r13)});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("OMaterialHelper", "setOverlayBlendEffect error: " + e);
        return;
    L14:
        Class<?> r17 = Class.forName("android.view.IExtEffect");     // Catch: Exception -> L8
        Class r18 = Integer.TYPE;     // Catch: Exception -> L8
        r16 = NativeReflect.a(r17, "setObricOverlayBlendEffect", new Class[]{r18, Float.TYPE, r18});     // Catch: Exception -> L8
        r16.setAccessible(true);     // Catch: Exception -> L8
        r15.put("setObricOverlayBlendEffect_3", r16);     // Catch: Exception -> L8
        goto L10
    }

    public static void T(Object r10, float r11, int r12) {
        U(r10, r11, r12, BlendMode.SRC_OVER.getPorterDuffMode());
    }

    public static void U(Object r10, float r11, int r12, int r13) {
        if (v() == true) goto L5;
        return;
    L5:
        Object r14 = k(r10);
        Map r15 = f15210b;
        Method r16 = (Method) r15.get("setObricBlurStroke");
        if (r16 == null) goto L14;
    L10:
        r16.invoke(r14, new Object[]{Float.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r13)});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("OMaterialHelper", "setStrokeEffect error: ", e);
        return;
    L14:
        Class<?> r17 = Class.forName("android.view.IExtEffect");     // Catch: Exception -> L8
        Class r18 = Float.TYPE;     // Catch: Exception -> L8
        Class r19 = Integer.TYPE;     // Catch: Exception -> L8
        r16 = NativeReflect.a(r17, "setObricBlurStroke", new Class[]{r18, r19, r19});     // Catch: Exception -> L8
        r16.setAccessible(true);     // Catch: Exception -> L8
        r15.put("setObricBlurStroke", r16);     // Catch: Exception -> L8
        goto L10
    }

    public static int[] V(com.obric.oui.color.a[] r10) {
        int r11 = 0;
        if (r10 == null) goto L5;
        int r12 = r10.length * 2;
        int[] r13 = new int[r12];
    L7:
        if (r11 >= r12) goto L13;
        com.obric.oui.color.a r14 = r10[r11 / 2];
        if ((r11 % 2) != 0) goto L11;
        int r15 = r14.c();
    L12:
        r13[r11] = r15;
        r11 = r11 + 1;
        goto L7
    L11:
        r15 = r14.b();
        goto L12
    L13:
        return r13;
    L5:
        return new int[0];
    }

    public static void a(Object r10, boolean r11) {
        if (r11 == false) goto L4;
        H(r10, 2, 1);
        return;
    L4:
        H(r10, 0, 0);
    }

    public static void b(Object r10, b r11) {
        if (r11.c() == null) goto L6;
        z(r10, V(r11.c().c()));
    L10:
        if (r11.d() == null) goto L13;
        C(r10, r11.d());
    L17:
        if (r11.j() == null) goto L19;
        T(r10, tc.f.g(r11.j().c()), r11.j().b());
    L21:
        if (r11.g() == null) goto L23;
        K(r10, true, r11.g().a());
        return;
    L23:
        f(r10);
        return;
    L19:
        T(r10, 0.0f, 0);
        goto L21
    L13:
        if (r11.e() == null) goto L15;
        R(r10, r11.e().floatValue());
        goto L17
    L15:
        e(r10);
        goto L17
    L6:
        if (r11.b() == null) goto L8;
        z(r10, V(r11.b()));
        goto L10
    L8:
        d(r10);
        goto L10
    }

    public static void c(Object r10, boolean r11) {
        if (r11 == false) goto L4;
        H(r10, 3, 1);
        return;
    L4:
        H(r10, 0, 0);
    }

    public static void d(Object r10) {
        if (v() == true) goto L5;
        return;
    L5:
        Object r11 = k(r10);
        Map r12 = f15210b;
        Method r13 = (Method) r12.get("setObricBlendEffect_curve");
        if (r13 == null) goto L14;
    L10:
        r13.invoke(r11, new Object[]{0, Float.valueOf(1.0f), new int[]{0, 0}});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        Log.e("OMaterialHelper", "clearBlendEffect error: " + e);
        return;
    L14:
        r13 = NativeReflect.a(Class.forName("android.view.IExtEffect"), "setObricBlendEffect", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: Exception -> L8
        r13.setAccessible(true);     // Catch: Exception -> L8
        r12.put("setObricBlendEffect_curve", r13);     // Catch: Exception -> L8
        goto L10
    }

    public static void e(Object r10) {
        B(r10, 0.0f, 1.0f, 0, 0, 1.0f);
    }

    public static void f(Object r10) {
        J(r10, false);
    }

    public static int g() {
        Map r10 = f15210b;
        Method r11 = (Method) r10.get("getEffectApi");
        if (r11 == null) goto L13;
    L7:
        Object r12 = r11.invoke(null, null);     // Catch: Exception -> L5
        if ((r12 instanceof Integer) == false) goto L15;
        return ((Integer) r12).intValue();
    L5:
        e = move-exception;
        Log.e("OUIMaterial", "getEffectApi failed: " + e);
        return 0;
    L15:
        return 0;
    L13:
        r11 = NativeReflect.a(Class.forName("android.view.IExtEffect"), "getEffectApi", new Class[0]);     // Catch: Exception -> L5
        r11.setAccessible(true);     // Catch: Exception -> L5
        r10.put("getEffectApi", r11);     // Catch: Exception -> L5
        goto L7
    }

    public static com.obric.oui.color.a[] h(Resources r10, int r11) {
        return com.obric.oui.color.a.a(r10, r11);
    }

    public static com.obric.oui.color.a[] i(Resources r10, int r11, int r12) {
        if (r11 == 0) goto L10;
        if (r12 == 0) goto L13;
        int[] r13 = r10.getIntArray(r11);
        int[] r14 = r10.getIntArray(r12);
        com.obric.oui.color.a[] r15 = new com.obric.oui.color.a[r13.length];
        int r16 = 0;
    L7:
        if (r16 >= r13.length) goto L9;
        r15[r16] = new com.obric.oui.color.a(r13[r16], BlendMode.mapToLegacyObricBlend(r14[r16]));
        r16 = r16 + 1;
        goto L7
    L9:
        return r15;
    L13:
        return null;
    L10:
        return null;
    }

    public static int j() {
        return 1;
    }

    public static Object k(Object r10) {
        if ((r10 instanceof View) == false) goto L7;
        return n((View) r10);
    L7:
        if ((r10 instanceof Paint) == false) goto L11;
        return l((Paint) r10);
    L11:
        if ((r10 instanceof VectorDrawable) == true) goto L13;
        return r10;
    L13:
        return m((VectorDrawable) r10);
    }

    public static Object l(Paint r10) {
        return s(r10, "paint_getExtEffect", Paint.class, "getExtEffect");
    }

    public static Object m(VectorDrawable r10) {
        return s(r10, "vectorDrawable_getExtEffect", VectorDrawable.class, "getExtEffect");
    }

    public static Object n(View r10) {
        return s(r10, "view_getExtEffect", View.class, "getExtEffect");
    }

    public static Object o(View r10) {
        Map r11 = f15210b;
        Method r12 = (Method) r11.get("view_getExtView");
        if (r12 == null) goto L11;
    L7:
        return r12.invoke(r10, null);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    L11:
        r12 = NativeReflect.a(View.class, "getExt", new Class[0]);     // Catch: Exception -> L5
        r12.setAccessible(true);     // Catch: Exception -> L5
        r11.put("view_getExtView", r12);     // Catch: Exception -> L5
        goto L7
    }

    public static int p() {
        if (f15209a != null) goto L6;
        f15209a = Integer.valueOf(g());
    L6:
        return f15209a.intValue();
    }

    public static int q(Context r10) {
        return Settings.Global.getInt(r10.getContentResolver(), "obric_current_effect_id", 2);
    }

    public static g r(Object r10, int r11) {
        Object r12 = k(r10);
        Map r13 = f15210b;
        Method r14 = (Method) r13.get("getEffectParas");
        if (r14 == null) goto L15;
    L7:
        Object r15 = r14.invoke(r12, new Object[]{Integer.valueOf(r11)});     // Catch: Exception -> L5
        if (r15 == null) goto L17;
        return new g(r15);
    L5:
        e = move-exception;
        Log.e("OMaterialHelper", "getMaterialParams error: " + e);
        return null;
    L17:
        return null;
    L15:
        r14 = NativeReflect.a(Class.forName("android.view.IExtEffect"), "getEffectParas", new Class[]{Integer.TYPE});     // Catch: Exception -> L5
        r14.setAccessible(true);     // Catch: Exception -> L5
        r13.put("getEffectParas", r14);     // Catch: Exception -> L5
        goto L7
    }

    public static Object s(Object r10, String r11, Class r12, String r13) {
        Map r14 = f15210b;
        Method r15 = (Method) r14.get(r11);
        if (r15 == null) goto L12;
    L8:
        return r15.invoke(r10, null);
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        r15 = NativeReflect.a(r12, r13, new Class[0]);     // Catch: Exception -> L6
        r15.setAccessible(true);     // Catch: Exception -> L6
        r14.put(r11, r15);     // Catch: Exception -> L6
        goto L8
    }

    public static boolean t(b r10) {
        if (r10 != null) goto L4;
    L12:
        return false;
    L4:
        if (r10.b() == null) goto L6;
    L11:
        return true;
    L6:
        if (r10.d() != null) goto L11;
        if (r10.e() != null) goto L11;
        if (r10.g() == null) goto L12;
        goto L11
    }

    public static boolean u(Context r10) {
        if (v() == true) goto L6;
        return false;
    L6:
        if (q(r10) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean v() {
        if (p() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean w() {
        if (p() < 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static void x(View r10, int r11, float r12, int... r13) {
        Object r14 = o(r10);
        Map r15 = f15210b;
        Method r16 = (Method) r15.get("legacy_setBackdropBlurEffectExt");
        if (r16 == null) goto L11;
    L7:
        r16.invoke(r14, new Object[]{Integer.valueOf(r11), Float.valueOf(r12), r13});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("OMaterialHelper", "setBackdropBlurEffectExt error: " + e);
        return;
    L11:
        r16 = NativeReflect.a(IExtView.class, "setBackdropBlurEffectExt", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: Exception -> L5
        r16.setAccessible(true);     // Catch: Exception -> L5
        r15.put("legacy_setBackdropBlurEffectExt", r16);     // Catch: Exception -> L5
        goto L7
    }

    public static void y(Object r10, int r11, float r12, int... r13) {
        if (v() == true) goto L5;
        return;
    L5:
        Object r14 = k(r10);
        Map r15 = f15210b;
        Method r16 = (Method) r15.get("setObricBlendEffect_curve");
        if (r16 == null) goto L14;
    L10:
        r16.invoke(r14, new Object[]{Integer.valueOf(r11), Float.valueOf(r12), r13});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("OMaterialHelper", "setBlendEffect error: " + e);
        return;
    L14:
        r16 = NativeReflect.a(Class.forName("android.view.IExtEffect"), "setObricBlendEffect", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: Exception -> L8
        r16.setAccessible(true);     // Catch: Exception -> L8
        r15.put("setObricBlendEffect_curve", r16);     // Catch: Exception -> L8
        goto L10
    }

    public static void z(Object r10, int... r11) {
        y(r10, 4, 1.0f, r11);
    }
}
