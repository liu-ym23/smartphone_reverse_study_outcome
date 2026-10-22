package com.obric.oui.color;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: BlendToken.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BlendToken {
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> Blend_Base_Regular = null;
    public static final com.obric.oui.color.a[] Blend_Base_Regular_Dark = null;
    public static final com.obric.oui.color.a[] Blend_Base_Regular_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> Blend_Base_Thick = null;
    public static final com.obric.oui.color.a[] Blend_Base_Thick_Dark = null;
    public static final com.obric.oui.color.a[] Blend_Base_Thick_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> Blend_Blue_4 = null;
    public static final com.obric.oui.color.a[] Blend_Blue_4_Dark = null;
    public static final com.obric.oui.color.a[] Blend_Blue_4_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> Blend_Blue_6 = null;
    public static final com.obric.oui.color.a[] Blend_Blue_6_Dark = null;
    public static final com.obric.oui.color.a[] Blend_Blue_6_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> Blend_Fill_Element_2 = null;
    public static final com.obric.oui.color.a[] Blend_Fill_Element_2_Dark = null;
    public static final com.obric.oui.color.a[] Blend_Fill_Element_2_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> Blend_Fluid_Thin = null;
    public static final com.obric.oui.color.a[] Blend_Fluid_Thin_Dark = null;
    public static final com.obric.oui.color.a[] Blend_Fluid_Thin_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> Blend_Green_4 = null;
    public static final com.obric.oui.color.a[] Blend_Green_4_Dark = null;
    public static final com.obric.oui.color.a[] Blend_Green_4_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> Blend_Green_6 = null;
    public static final com.obric.oui.color.a[] Blend_Green_6_Dark = null;
    public static final com.obric.oui.color.a[] Blend_Green_6_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> Blend_Red_4 = null;
    public static final com.obric.oui.color.a[] Blend_Red_4_Dark = null;
    public static final com.obric.oui.color.a[] Blend_Red_4_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> Blend_Red_6 = null;
    public static final com.obric.oui.color.a[] Blend_Red_6_Dark = null;
    public static final com.obric.oui.color.a[] Blend_Red_6_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> Blend_Yellow_4 = null;
    public static final com.obric.oui.color.a[] Blend_Yellow_4_Dark = null;
    public static final com.obric.oui.color.a[] Blend_Yellow_4_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> Blend_Yellow_6 = null;
    public static final com.obric.oui.color.a[] Blend_Yellow_6_Dark = null;
    public static final com.obric.oui.color.a[] Blend_Yellow_6_Light = null;
    public static final BlendToken INSTANCE = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Blue_Regular = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Blue_Regular_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Blue_Regular_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Blue_Thin = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Blue_Thin_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Blue_Thin_Light = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Fill_Tinted_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Fill_Tinted_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Fluid_Regular = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Fluid_Regular_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Fluid_Regular_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Fluid_Thick = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Fluid_Thick_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Fluid_Thick_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Fluid_Thin = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Fluid_Thin_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Fluid_Thin_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Fluid_UltraThin = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Fluid_UltraThin_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Fluid_UltraThin_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Frost_Regular = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Frost_Regular_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Frost_Regular_Light = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Frost_Thick_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Frost_Thick_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Frost_Thin = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Frost_Thin_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Frost_Thin_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Frost_UltraThin = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Frost_UltraThin_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Frost_UltraThin_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Green_Regular = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Green_Regular_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Green_Regular_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Green_Thin = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Green_Thin_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Green_Thin_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Red_Regular = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Red_Regular_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Red_Regular_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Red_Thin = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Red_Thin_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Red_Thin_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Text_Primary = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Text_Primary_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Text_Primary_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Text_Secondary = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Text_Secondary_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Text_Secondary_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Text_Tertiary = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Text_Tertiary_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Text_Tertiary_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Yellow_Regular = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Yellow_Regular_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Yellow_Regular_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.a[]> OUI_Color_Blend_Yellow_Thin = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Yellow_Thin_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Blend_Yellow_Thin_Light = null;
    public static final com.obric.oui.color.a[] OUI_Color_Fills_Thick_Dark = null;
    public static final com.obric.oui.color.a[] OUI_Color_Fills_Thick_Light = null;
    public static final com.obric.oui.color.a OUI_Color_State_Active_Dark = null;
    public static final com.obric.oui.color.a OUI_Color_State_Active_Light = null;
    public static final com.obric.oui.color.a OUI_Color_State_Press_Dark = null;
    public static final com.obric.oui.color.a OUI_Color_State_Press_Light = null;
    private static final d.f providers$delegate = null;
    private static final d.f tokens$delegate = null;

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class a extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f34451a = null;

        static {
            f34451a = new a();
        }

        a() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.Blend_Base_Regular_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.Blend_Base_Regular_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class aa extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final aa f34452a = null;

        static {
            f34452a = new aa();
        }

        aa() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Text_Secondary_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Text_Secondary_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class ab extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ab f34453a = null;

        static {
            f34453a = new ab();
        }

        ab() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Text_Tertiary_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Text_Tertiary_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class ac extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ac f34454a = null;

        static {
            f34454a = new ac();
        }

        ac() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Yellow_Regular_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Yellow_Regular_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class ad extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ad f34455a = null;

        static {
            f34455a = new ad();
        }

        ad() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Yellow_Thin_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Yellow_Thin_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class ae extends d.h.b.p implements d.h.a.a<ConcurrentHashMap<String, d.h.a.b<? super Boolean, ? extends com.obric.oui.color.a[]>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ae f34456a = null;

        static {
            f34456a = new ae();
        }

        ae() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ConcurrentHashMap<String, d.h.a.b<? super Boolean, ? extends com.obric.oui.color.a[]>> invoke() {
            return a();
        }

        public final ConcurrentHashMap<String, d.h.a.b<Boolean, com.obric.oui.color.a[]>> a() {
            ConcurrentHashMap<String, d.h.a.b<Boolean, com.obric.oui.color.a[]>> r11 = new ConcurrentHashMap();
            com.obric.oui.material.n r0 = com.obric.oui.material.n.f35506a;
            BlendToken r1 = BlendToken.INSTANCE;
            Map<? extends String, ? extends d.h.a.b<Boolean, com.obric.oui.color.a[]>> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            Field[] r3 = r1.getClass().getDeclaredFields();     // Catch: Exception -> L11
            d.h.b.o.c(r3, "fields");     // Catch: Exception -> L11
            int r5 = 0;
            int r6 = r3.length;     // Catch: Exception -> L11
        L4:
            if (r5 >= r6) goto L13;
            Field r7 = r3[r5];     // Catch: Exception -> L11
            r5 = r5 + 1;     // Catch: Exception -> L11
            if (d.h.a.b.class.isAssignableFrom(r7.getType()) == false) goto L4;
            r7.setAccessible(true);     // Catch: Exception -> L11
            Object r9 = r7.get(r1);     // Catch: Exception -> L11
            if (d.h.b.ae.a(r9, 1) == false) goto L4;
            String r8 = r7.getName();     // Catch: Exception -> L11
            d.h.b.o.c(r8, "field.name");     // Catch: Exception -> L11
            Locale r10 = Locale.ROOT;     // Catch: Exception -> L11
            d.h.b.o.c(r10, "ROOT");     // Catch: Exception -> L11
            String r12 = r8.toLowerCase(r10);     // Catch: Exception -> L11
            d.h.b.o.c(r12, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
            d.h.b.o.c(r9, "value");     // Catch: Exception -> L11
            r2.put(r12, r9);     // Catch: Exception -> L11
        L13:
            r11.putAll(r2);
            return r11;
        L11:
            e = move-exception;
            a("TokenParser", d.h.b.o.a("Failed to parse tokens from ", r1.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L13
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class af extends d.h.b.p implements d.h.a.a<ConcurrentHashMap<String, com.obric.oui.color.a[]>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final af f34457a = null;

        static {
            f34457a = new af();
        }

        af() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ConcurrentHashMap<String, com.obric.oui.color.a[]> invoke() {
            return a();
        }

        public final ConcurrentHashMap<String, com.obric.oui.color.a[]> a() {
            ConcurrentHashMap<String, com.obric.oui.color.a[]> r11 = new ConcurrentHashMap();
            com.obric.oui.material.n r0 = com.obric.oui.material.n.f35506a;
            BlendToken r1 = BlendToken.INSTANCE;
            Map<? extends String, ? extends com.obric.oui.color.a[]> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            Field[] r3 = r1.getClass().getDeclaredFields();     // Catch: Exception -> L11
            d.h.b.o.c(r3, "fields");     // Catch: Exception -> L11
            int r5 = 0;
            int r6 = r3.length;     // Catch: Exception -> L11
        L4:
            if (r5 >= r6) goto L13;
            Field r7 = r3[r5];     // Catch: Exception -> L11
            r5 = r5 + 1;     // Catch: Exception -> L11
            if (com.obric.oui.color.a[].class.isAssignableFrom(r7.getType()) == false) goto L4;
            r7.setAccessible(true);     // Catch: Exception -> L11
            Object r8 = r7.get(r1);     // Catch: Exception -> L11
            if ((r8 instanceof com.obric.oui.color.a[]) == false) goto L4;
            String r9 = r7.getName();     // Catch: Exception -> L11
            d.h.b.o.c(r9, "field.name");     // Catch: Exception -> L11
            Locale r10 = Locale.ROOT;     // Catch: Exception -> L11
            d.h.b.o.c(r10, "ROOT");     // Catch: Exception -> L11
            String r12 = r9.toLowerCase(r10);     // Catch: Exception -> L11
            d.h.b.o.c(r12, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
            r2.put(r12, r8);     // Catch: Exception -> L11
        L13:
            r11.putAll(r2);
            return r11;
        L11:
            e = move-exception;
            a("TokenParser", d.h.b.o.a("Failed to parse tokens from ", r1.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L13
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class b extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f34458a = null;

        static {
            f34458a = new b();
        }

        b() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.Blend_Base_Thick_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.Blend_Base_Thick_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class c extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f34459a = null;

        static {
            f34459a = new c();
        }

        c() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.Blend_Blue_4_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.Blend_Blue_4_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class d extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f34460a = null;

        static {
            f34460a = new d();
        }

        d() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.Blend_Blue_6_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.Blend_Blue_6_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class e extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f34461a = null;

        static {
            f34461a = new e();
        }

        e() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.Blend_Fill_Element_2_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.Blend_Fill_Element_2_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class f extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f34462a = null;

        static {
            f34462a = new f();
        }

        f() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.Blend_Fluid_Thin_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.Blend_Fluid_Thin_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class g extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f34463a = null;

        static {
            f34463a = new g();
        }

        g() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.Blend_Green_4_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.Blend_Green_4_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class h extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f34464a = null;

        static {
            f34464a = new h();
        }

        h() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.Blend_Green_6_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.Blend_Green_6_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class i extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f34465a = null;

        static {
            f34465a = new i();
        }

        i() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.Blend_Red_4_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.Blend_Red_4_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class j extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f34466a = null;

        static {
            f34466a = new j();
        }

        j() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.Blend_Red_6_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.Blend_Red_6_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class k extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f34467a = null;

        static {
            f34467a = new k();
        }

        k() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.Blend_Yellow_4_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.Blend_Yellow_4_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class l extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f34468a = null;

        static {
            f34468a = new l();
        }

        l() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.Blend_Yellow_6_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.Blend_Yellow_6_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class m extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f34469a = null;

        static {
            f34469a = new m();
        }

        m() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Blue_Regular_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Blue_Regular_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class n extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f34470a = null;

        static {
            f34470a = new n();
        }

        n() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Blue_Thin_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Blue_Thin_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class o extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f34471a = null;

        static {
            f34471a = new o();
        }

        o() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Fluid_Regular_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Fluid_Regular_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class p extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f34472a = null;

        static {
            f34472a = new p();
        }

        p() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Fluid_Thick_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Fluid_Thick_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class q extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f34473a = null;

        static {
            f34473a = new q();
        }

        q() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Fluid_Thin_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Fluid_Thin_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class r extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f34474a = null;

        static {
            f34474a = new r();
        }

        r() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Fluid_UltraThin_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Fluid_UltraThin_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class s extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f34475a = null;

        static {
            f34475a = new s();
        }

        s() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Frost_Regular_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Frost_Regular_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class t extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final t f34476a = null;

        static {
            f34476a = new t();
        }

        t() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Frost_Thin_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Frost_Thin_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class u extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f34477a = null;

        static {
            f34477a = new u();
        }

        u() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Frost_UltraThin_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Frost_UltraThin_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class v extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f34478a = null;

        static {
            f34478a = new v();
        }

        v() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Green_Regular_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Green_Regular_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class w extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final w f34479a = null;

        static {
            f34479a = new w();
        }

        w() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Green_Thin_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Green_Thin_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class x extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final x f34480a = null;

        static {
            f34480a = new x();
        }

        x() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Red_Regular_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Red_Regular_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class y extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y f34481a = null;

        static {
            f34481a = new y();
        }

        y() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Red_Thin_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Red_Thin_Light;
        }
    }

    /* JADX INFO: compiled from: BlendToken.kt */
    static final class z extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.color.a[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final z f34482a = null;

        static {
            f34482a = new z();
        }

        z() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.a[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.color.a[] a(boolean r1) {
            if (r1 == true) goto L10;
            if (r1 == true) goto L9;
            return BlendToken.OUI_Color_Blend_Text_Primary_Dark;
        L9:
            throw new d.k();
        L10:
            return BlendToken.OUI_Color_Blend_Text_Primary_Light;
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ void getBlend_Base_Regular$annotations() {
    }

    public static /* synthetic */ void getBlend_Base_Thick$annotations() {
    }

    public static /* synthetic */ void getBlend_Blue_4$annotations() {
    }

    public static /* synthetic */ void getBlend_Blue_6$annotations() {
    }

    public static /* synthetic */ void getBlend_Fill_Element_2$annotations() {
    }

    public static /* synthetic */ void getBlend_Fluid_Thin$annotations() {
    }

    public static /* synthetic */ void getBlend_Green_4$annotations() {
    }

    public static /* synthetic */ void getBlend_Green_6$annotations() {
    }

    public static /* synthetic */ void getBlend_Red_4$annotations() {
    }

    public static /* synthetic */ void getBlend_Red_6$annotations() {
    }

    public static /* synthetic */ void getBlend_Yellow_4$annotations() {
    }

    public static /* synthetic */ void getBlend_Yellow_6$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Blue_Regular$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Blue_Thin$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Fluid_Regular$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Fluid_Thick$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Fluid_Thin$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Fluid_UltraThin$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Frost_Regular$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Frost_Thin$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Frost_UltraThin$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Green_Regular$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Green_Thin$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Red_Regular$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Red_Thin$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Text_Primary$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Text_Secondary$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Text_Tertiary$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Yellow_Regular$annotations() {
    }

    public static /* synthetic */ void getOUI_Color_Blend_Yellow_Thin$annotations() {
    }

    private BlendToken() {
    }

    static {
        INSTANCE = new BlendToken();
        tokens$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(af.f34457a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        providers$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(ae.f34456a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        Blend_Base_Thick_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-1726013665, com.obric.oui.a.a.s), new com.obric.oui.color.a(-604571914, com.obric.oui.a.a.f33929d)};
        Blend_Base_Thick_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.t), new com.obric.oui.color.a(-618388444, com.obric.oui.a.a.f33929d)};
        Blend_Base_Thick = (d.h.a.b) ZeusTransformUtils.preCheckCast(b.f34458a, d.h.a.b.class, "com.obric.aiagent.plugin");
        Blend_Base_Regular_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-14737633, com.obric.oui.a.a.s), new com.obric.oui.color.a(-855638017, com.obric.oui.a.a.f33929d)};
        Blend_Base_Regular_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.t), new com.obric.oui.color.a(-666746302, com.obric.oui.a.a.f33929d)};
        Blend_Base_Regular = (d.h.a.b) ZeusTransformUtils.preCheckCast(a.f34451a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Frost_Regular_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-14737633, com.obric.oui.a.a.s), new com.obric.oui.color.a(-855638017, com.obric.oui.a.a.f33929d)};
        OUI_Color_Blend_Frost_Regular_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.t), new com.obric.oui.color.a(-868072894, com.obric.oui.a.a.f33929d)};
        OUI_Color_Blend_Frost_Regular = (d.h.a.b) ZeusTransformUtils.preCheckCast(s.f34475a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Fluid_Regular_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(1722987186, com.obric.oui.a.a.C), new com.obric.oui.color.a(-13421773, com.obric.oui.a.a.s), new com.obric.oui.color.a(872415231, com.obric.oui.a.a.f33929d)};
        OUI_Color_Blend_Fluid_Regular_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2137483112, com.obric.oui.a.a.C), new com.obric.oui.color.a(-1716210508, com.obric.oui.a.a.t), new com.obric.oui.color.a(352321535, com.obric.oui.a.a.f33929d)};
        OUI_Color_Blend_Fluid_Regular = (d.h.a.b) ZeusTransformUtils.preCheckCast(o.f34471a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Frost_UltraThin_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-14737633, com.obric.oui.a.a.E)};
        OUI_Color_Blend_Frost_UltraThin_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-14737633, com.obric.oui.a.a.E)};
        OUI_Color_Blend_Frost_UltraThin = (d.h.a.b) ZeusTransformUtils.preCheckCast(u.f34477a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Fluid_UltraThin_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-15461356, com.obric.oui.a.a.E)};
        OUI_Color_Blend_Fluid_UltraThin_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-15461356, com.obric.oui.a.a.E)};
        OUI_Color_Blend_Fluid_UltraThin = (d.h.a.b) ZeusTransformUtils.preCheckCast(r.f34474a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Frost_Thin_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(1722329256, com.obric.oui.a.a.C), new com.obric.oui.color.a(-13421773, com.obric.oui.a.a.s), new com.obric.oui.color.a(-1711276033, com.obric.oui.a.a.f33929d)};
        OUI_Color_Blend_Frost_Thin_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2137417319, com.obric.oui.a.a.C)};
        OUI_Color_Blend_Frost_Thin = (d.h.a.b) ZeusTransformUtils.preCheckCast(t.f34476a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Fluid_Thin_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(869059788, com.obric.oui.a.a.C), new com.obric.oui.color.a(-1724697805, com.obric.oui.a.a.s), new com.obric.oui.color.a(352321535, com.obric.oui.a.a.f33929d)};
        OUI_Color_Blend_Fluid_Thin_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(1721342361, com.obric.oui.a.a.C)};
        OUI_Color_Blend_Fluid_Thin = (d.h.a.b) ZeusTransformUtils.preCheckCast(q.f34473a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Frost_Thick_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-1726013665, com.obric.oui.a.a.s), new com.obric.oui.color.a(-604506121, com.obric.oui.a.a.f33929d)};
        OUI_Color_Blend_Frost_Thick_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.t), new com.obric.oui.color.a(-618059479, com.obric.oui.a.a.f33929d)};
        OUI_Color_Blend_Fluid_Thick_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-1726013665, com.obric.oui.a.a.s), new com.obric.oui.color.a(-604506121, com.obric.oui.a.a.f33929d)};
        OUI_Color_Blend_Fluid_Thick_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-858993460, com.obric.oui.a.a.t), new com.obric.oui.color.a(-869717719, com.obric.oui.a.a.f33929d)};
        OUI_Color_Blend_Fluid_Thick = (d.h.a.b) ZeusTransformUtils.preCheckCast(p.f34472a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Fills_Thick_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(251658240, com.obric.oui.a.a.f33929d)};
        OUI_Color_Fills_Thick_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(620756991, com.obric.oui.a.a.f33929d)};
        OUI_Color_Blend_Text_Primary_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-13421773, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Text_Primary_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2500135, com.obric.oui.a.a.E)};
        OUI_Color_Blend_Text_Primary = (d.h.a.b) ZeusTransformUtils.preCheckCast(z.f34482a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Text_Secondary_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-6710887, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Text_Secondary_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-9211021, com.obric.oui.a.a.E)};
        OUI_Color_Blend_Text_Secondary = (d.h.a.b) ZeusTransformUtils.preCheckCast(aa.f34452a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Text_Tertiary_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-4342339, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Text_Tertiary_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-10921639, com.obric.oui.a.a.E)};
        OUI_Color_Blend_Text_Tertiary = (d.h.a.b) ZeusTransformUtils.preCheckCast(ab.f34453a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Fill_Tinted_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-1, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Fill_Tinted_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-16777216, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Blue_Thin_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-10049793, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Blue_Thin_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-10049793, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Blue_Thin = (d.h.a.b) ZeusTransformUtils.preCheckCast(n.f34470a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Blue_Regular_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-14253569, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Blue_Regular_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-14253569, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Blue_Regular = (d.h.a.b) ZeusTransformUtils.preCheckCast(m.f34469a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Red_Thin_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-30841, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Red_Thin_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-30841, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Red_Thin = (d.h.a.b) ZeusTransformUtils.preCheckCast(y.f34481a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Red_Regular_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-45747, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Red_Regular_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-45747, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Red_Regular = (d.h.a.b) ZeusTransformUtils.preCheckCast(x.f34480a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Green_Thin_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-8917601, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Green_Thin_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-8917601, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Green_Thin = (d.h.a.b) ZeusTransformUtils.preCheckCast(w.f34479a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Green_Regular_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-15415472, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Green_Regular_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-15415472, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Green_Regular = (d.h.a.b) ZeusTransformUtils.preCheckCast(v.f34478a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Yellow_Thin_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-11671, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Yellow_Thin_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-11671, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Yellow_Thin = (d.h.a.b) ZeusTransformUtils.preCheckCast(ad.f34455a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_Blend_Yellow_Regular_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-15078, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Yellow_Regular_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-15078, com.obric.oui.a.a.D)};
        OUI_Color_Blend_Yellow_Regular = (d.h.a.b) ZeusTransformUtils.preCheckCast(ac.f34454a, d.h.a.b.class, "com.obric.aiagent.plugin");
        OUI_Color_State_Press_Light = new com.obric.oui.color.a(-13421773, com.obric.oui.a.a.E);
        OUI_Color_State_Press_Dark = new com.obric.oui.color.a(-1724697805, com.obric.oui.a.a.E);
        OUI_Color_State_Active_Light = new com.obric.oui.color.a(-6710887, com.obric.oui.a.a.E);
        OUI_Color_State_Active_Dark = new com.obric.oui.color.a(-6710887, com.obric.oui.a.a.E);
        Blend_Blue_6_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-15042049, com.obric.oui.a.a.D)};
        Blend_Blue_6_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-15042049, com.obric.oui.a.a.D)};
        Blend_Blue_6 = (d.h.a.b) ZeusTransformUtils.preCheckCast(d.f34460a, d.h.a.b.class, "com.obric.aiagent.plugin");
        Blend_Blue_4_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-10049793, com.obric.oui.a.a.D)};
        Blend_Blue_4_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-10049793, com.obric.oui.a.a.D)};
        Blend_Blue_4 = (d.h.a.b) ZeusTransformUtils.preCheckCast(c.f34459a, d.h.a.b.class, "com.obric.aiagent.plugin");
        Blend_Yellow_6_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-873984, com.obric.oui.a.a.D)};
        Blend_Yellow_6_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-873984, com.obric.oui.a.a.D)};
        Blend_Yellow_6 = (d.h.a.b) ZeusTransformUtils.preCheckCast(l.f34468a, d.h.a.b.class, "com.obric.aiagent.plugin");
        Blend_Yellow_4_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-11671, com.obric.oui.a.a.D)};
        Blend_Yellow_4_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-11671, com.obric.oui.a.a.D)};
        Blend_Yellow_4 = (d.h.a.b) ZeusTransformUtils.preCheckCast(k.f34467a, d.h.a.b.class, "com.obric.aiagent.plugin");
        Blend_Green_6_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-16722873, com.obric.oui.a.a.D)};
        Blend_Green_6_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-16722873, com.obric.oui.a.a.D)};
        Blend_Green_6 = (d.h.a.b) ZeusTransformUtils.preCheckCast(h.f34464a, d.h.a.b.class, "com.obric.aiagent.plugin");
        Blend_Green_4_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-8917601, com.obric.oui.a.a.D)};
        Blend_Green_4_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-8917601, com.obric.oui.a.a.D)};
        Blend_Green_4 = (d.h.a.b) ZeusTransformUtils.preCheckCast(g.f34463a, d.h.a.b.class, "com.obric.aiagent.plugin");
        Blend_Red_6_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-53971, com.obric.oui.a.a.D)};
        Blend_Red_6_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-53971, com.obric.oui.a.a.D)};
        Blend_Red_6 = (d.h.a.b) ZeusTransformUtils.preCheckCast(j.f34466a, d.h.a.b.class, "com.obric.aiagent.plugin");
        Blend_Red_4_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-30841, com.obric.oui.a.a.D)};
        Blend_Red_4_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(-30841, com.obric.oui.a.a.D)};
        Blend_Red_4 = (d.h.a.b) ZeusTransformUtils.preCheckCast(i.f34465a, d.h.a.b.class, "com.obric.aiagent.plugin");
        Blend_Fill_Element_2_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(167772160, com.obric.oui.a.a.f33929d)};
        Blend_Fill_Element_2_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(536870911, com.obric.oui.a.a.f33929d)};
        Blend_Fill_Element_2 = (d.h.a.b) ZeusTransformUtils.preCheckCast(e.f34461a, d.h.a.b.class, "com.obric.aiagent.plugin");
        Blend_Fluid_Thin_Light = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-13421773, com.obric.oui.a.a.s), new com.obric.oui.color.a(1088018905, com.obric.oui.a.a.f33929d)};
        Blend_Fluid_Thin_Dark = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-13421773, com.obric.oui.a.a.s), new com.obric.oui.color.a(1088018905, com.obric.oui.a.a.f33929d)};
        Blend_Fluid_Thin = (d.h.a.b) ZeusTransformUtils.preCheckCast(f.f34462a, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    private final ConcurrentHashMap<String, com.obric.oui.color.a[]> getTokens() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(tokens$delegate.b(), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
    }

    private final ConcurrentHashMap<String, d.h.a.b<Boolean, com.obric.oui.color.a[]>> getProviders() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(providers$delegate.b(), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void register$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        register(r0, r1);
    }

    public static final void register(Object r12, boolean r13) {
        d.h.b.o.e(r12, "customTokenOwner");
        com.obric.oui.material.n r0 = com.obric.oui.material.n.f35506a;
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getTokens(), Map.class, "com.obric.aiagent.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Field[] r5 = r12.getClass().getDeclaredFields();     // Catch: Exception -> L11
        d.h.b.o.c(r5, "fields");     // Catch: Exception -> L11
        int r6 = 0;
        int r7 = r5.length;     // Catch: Exception -> L11
    L4:
        if (r6 >= r7) goto L13;
        Field r8 = r5[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (com.obric.oui.color.a[].class.isAssignableFrom(r8.getType()) == false) goto L4;
        r8.setAccessible(true);     // Catch: Exception -> L11
        Object r9 = r8.get(r12);     // Catch: Exception -> L11
        if ((r9 instanceof com.obric.oui.color.a[]) == false) goto L4;
        String r10 = r8.getName();     // Catch: Exception -> L11
        d.h.b.o.c(r10, "field.name");     // Catch: Exception -> L11
        Locale r11 = Locale.ROOT;     // Catch: Exception -> L11
        d.h.b.o.c(r11, "ROOT");     // Catch: Exception -> L11
        String r14 = r10.toLowerCase(r11);     // Catch: Exception -> L11
        d.h.b.o.c(r14, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        r4.put(r14, r9);     // Catch: Exception -> L11
    L13:
        r0.a(r1, r4, r13);
        return;
    L11:
        e = move-exception;
        INVOKESTATIC_com_obric_oui_color_BlendToken_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("TokenParser", d.h.b.o.a("Failed to parse tokens from ", r12.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L13
    }

    public static /* synthetic */ void registerTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerTokens(r5, r2);
    }

    public static final void registerTokens(Map<String, com.obric.oui.color.a[]> r4, boolean r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "customTokens");
        com.obric.oui.material.n.f35506a.a((Map) ZeusTransformUtils.preCheckCast(INSTANCE.getTokens(), Map.class, "com.obric.aiagent.plugin"), r6, r5);
    }

    public static /* synthetic */ void registerProvider$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerProvider(r0, r1);
    }

    public static final void registerProvider(Object r12, boolean r13) {
        d.h.b.o.e(r12, "customTokenOwner");
        com.obric.oui.material.n r0 = com.obric.oui.material.n.f35506a;
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getProviders(), Map.class, "com.obric.aiagent.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Field[] r5 = r12.getClass().getDeclaredFields();     // Catch: Exception -> L11
        d.h.b.o.c(r5, "fields");     // Catch: Exception -> L11
        int r6 = 0;
        int r7 = r5.length;     // Catch: Exception -> L11
    L4:
        if (r6 >= r7) goto L13;
        Field r8 = r5[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (d.h.a.b.class.isAssignableFrom(r8.getType()) == false) goto L4;
        r8.setAccessible(true);     // Catch: Exception -> L11
        Object r10 = r8.get(r12);     // Catch: Exception -> L11
        if (d.h.b.ae.a(r10, 1) == false) goto L4;
        String r9 = r8.getName();     // Catch: Exception -> L11
        d.h.b.o.c(r9, "field.name");     // Catch: Exception -> L11
        Locale r11 = Locale.ROOT;     // Catch: Exception -> L11
        d.h.b.o.c(r11, "ROOT");     // Catch: Exception -> L11
        String r14 = r9.toLowerCase(r11);     // Catch: Exception -> L11
        d.h.b.o.c(r14, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        d.h.b.o.c(r10, "value");     // Catch: Exception -> L11
        r4.put(r14, r10);     // Catch: Exception -> L11
    L13:
        r0.a(r1, r4, r13);
        return;
    L11:
        e = move-exception;
        INVOKESTATIC_com_obric_oui_color_BlendToken_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("TokenParser", d.h.b.o.a("Failed to parse tokens from ", r12.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L13
    }

    public static /* synthetic */ void registerProviderTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerProviderTokens(r5, r2);
    }

    public static final void registerProviderTokens(Map<String, ? extends d.h.a.b<? super Boolean, com.obric.oui.color.a[]>> r4, boolean r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "customTokens");
        com.obric.oui.material.n.f35506a.a((Map) ZeusTransformUtils.preCheckCast(INSTANCE.getProviders(), Map.class, "com.obric.aiagent.plugin"), r6, r5);
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> parse(String r4) {
        return (d.h.a.b) ZeusTransformUtils.preCheckCast(com.obric.oui.material.n.f35506a.a(r4, (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getProviders(), Map.class, "com.obric.aiagent.plugin")), d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public static final com.obric.oui.color.a[] parse(String r5, boolean r6) {
        com.obric.oui.material.n r0 = com.obric.oui.material.n.f35506a;
        BlendToken r1 = INSTANCE;
        if (((com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r0.a(r5, (Map) ZeusTransformUtils.preCheckCast(r1.getTokens(), Map.class, "com.obric.aiagent.plugin")), com.obric.oui.color.a[].class, "com.obric.aiagent.plugin")) != null) goto L10;
        com.obric.oui.material.n r2 = com.obric.oui.material.n.f35506a;
        if (r6 == false) goto L7;
        String r7 = "_light";
    L8:
        com.obric.oui.color.a[] r8 = (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(r2.a(d.h.b.o.a(r5, r7), (Map) ZeusTransformUtils.preCheckCast(r1.getTokens(), Map.class, "com.obric.aiagent.plugin")), com.obric.oui.color.a[].class, "com.obric.aiagent.plugin");
        goto L10
    L7:
        r7 = "_dark";
    L10:
        return (com.obric.oui.color.a[]) ZeusTransformUtils.preCheckCast(com.obric.oui.material.n.f35506a.a(r5, (Map) ZeusTransformUtils.preCheckCast(r1.getTokens(), Map.class, "com.obric.aiagent.plugin")), com.obric.oui.color.a[].class, "com.obric.aiagent.plugin");
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getBlend_Base_Thick() {
        return Blend_Base_Thick;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getBlend_Base_Regular() {
        return Blend_Base_Regular;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Frost_Regular() {
        return OUI_Color_Blend_Frost_Regular;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Fluid_Regular() {
        return OUI_Color_Blend_Fluid_Regular;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Frost_UltraThin() {
        return OUI_Color_Blend_Frost_UltraThin;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Fluid_UltraThin() {
        return OUI_Color_Blend_Fluid_UltraThin;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Frost_Thin() {
        return OUI_Color_Blend_Frost_Thin;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Fluid_Thin() {
        return OUI_Color_Blend_Fluid_Thin;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Fluid_Thick() {
        return OUI_Color_Blend_Fluid_Thick;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Text_Primary() {
        return OUI_Color_Blend_Text_Primary;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Text_Secondary() {
        return OUI_Color_Blend_Text_Secondary;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Text_Tertiary() {
        return OUI_Color_Blend_Text_Tertiary;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Blue_Thin() {
        return OUI_Color_Blend_Blue_Thin;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Blue_Regular() {
        return OUI_Color_Blend_Blue_Regular;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Red_Thin() {
        return OUI_Color_Blend_Red_Thin;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Red_Regular() {
        return OUI_Color_Blend_Red_Regular;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Green_Thin() {
        return OUI_Color_Blend_Green_Thin;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Green_Regular() {
        return OUI_Color_Blend_Green_Regular;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Yellow_Thin() {
        return OUI_Color_Blend_Yellow_Thin;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getOUI_Color_Blend_Yellow_Regular() {
        return OUI_Color_Blend_Yellow_Regular;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getBlend_Blue_6() {
        return Blend_Blue_6;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getBlend_Blue_4() {
        return Blend_Blue_4;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getBlend_Yellow_6() {
        return Blend_Yellow_6;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getBlend_Yellow_4() {
        return Blend_Yellow_4;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getBlend_Green_6() {
        return Blend_Green_6;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getBlend_Green_4() {
        return Blend_Green_4;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getBlend_Red_6() {
        return Blend_Red_6;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getBlend_Red_4() {
        return Blend_Red_4;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getBlend_Fill_Element_2() {
        return Blend_Fill_Element_2;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.a[]> getBlend_Fluid_Thin() {
        return Blend_Fluid_Thin;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_color_BlendToken_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
