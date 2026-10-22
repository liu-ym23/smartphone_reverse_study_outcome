package com.obric.oui.color;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.h.b.p;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: StrokeToken.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StrokeToken {
    public static final StrokeToken INSTANCE = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.e> OUI_Effect_Stroke_Blue_Regular = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Blue_Regular_Dark = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Blue_Regular_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.e> OUI_Effect_Stroke_Blue_Thin = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Blue_Thin_Dark = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Blue_Thin_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.e> OUI_Effect_Stroke_Green_Regular = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Green_Regular_Dark = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Green_Regular_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.e> OUI_Effect_Stroke_Green_Thin = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Green_Thin_Dark = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Green_Thin_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.e> OUI_Effect_Stroke_Red_Regular = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Red_Regular_Dark = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Red_Regular_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.e> OUI_Effect_Stroke_Red_Thin = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Red_Thin_Dark = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Red_Thin_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.e> OUI_Effect_Stroke_Regular = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Regular_Dark = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Regular_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.e> OUI_Effect_Stroke_Thick = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Thick_Dark = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Thick_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.e> OUI_Effect_Stroke_Thin = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Thin_Dark = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Thin_Light = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Tinted_Dark = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Tinted_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.e> OUI_Effect_Stroke_UltraThin = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_UltraThin_Dark = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_UltraThin_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.e> OUI_Effect_Stroke_Yellow_Regular = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Yellow_Regular_Dark = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Yellow_Regular_Light = null;
    private static final d.h.a.b<Boolean, com.obric.oui.color.e> OUI_Effect_Stroke_Yellow_Thin = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Yellow_Thin_Dark = null;
    public static final com.obric.oui.color.e OUI_Effect_Stroke_Yellow_Thin_Light = null;

    /* JADX INFO: compiled from: StrokeToken.kt */
    static final class a extends p implements d.h.a.b<Boolean, com.obric.oui.color.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f34483a = null;

        static {
            f34483a = new a();
        }

        a() {
            super(1);
        }

        public final com.obric.oui.color.e a(boolean r2) {
            com.obric.oui.color.f r1 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular.invoke(Boolean.valueOf(r2));
            o.c(r1, "OUI_Effect_Stroke_Blue_Regular.invoke(isLight)");
            return com.obric.oui.color.g.a((com.obric.oui.color.f) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.color.f.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.e invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    /* JADX INFO: compiled from: StrokeToken.kt */
    static final class b extends p implements d.h.a.b<Boolean, com.obric.oui.color.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f34484a = null;

        static {
            f34484a = new b();
        }

        b() {
            super(1);
        }

        public final com.obric.oui.color.e a(boolean r2) {
            com.obric.oui.color.f r1 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Thin.invoke(Boolean.valueOf(r2));
            o.c(r1, "OUI_Effect_Stroke_Blue_Thin.invoke(isLight)");
            return com.obric.oui.color.g.a((com.obric.oui.color.f) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.color.f.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.e invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    /* JADX INFO: compiled from: StrokeToken.kt */
    static final class c extends p implements d.h.a.b<Boolean, com.obric.oui.color.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f34485a = null;

        static {
            f34485a = new c();
        }

        c() {
            super(1);
        }

        public final com.obric.oui.color.e a(boolean r2) {
            com.obric.oui.color.f r1 = StrokeTokenCore.OUI_Effect_Stroke_Green_Regular.invoke(Boolean.valueOf(r2));
            o.c(r1, "OUI_Effect_Stroke_Green_Regular.invoke(isLight)");
            return com.obric.oui.color.g.a((com.obric.oui.color.f) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.color.f.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.e invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    /* JADX INFO: compiled from: StrokeToken.kt */
    static final class d extends p implements d.h.a.b<Boolean, com.obric.oui.color.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f34486a = null;

        static {
            f34486a = new d();
        }

        d() {
            super(1);
        }

        public final com.obric.oui.color.e a(boolean r2) {
            com.obric.oui.color.f r1 = StrokeTokenCore.OUI_Effect_Stroke_Green_Thin.invoke(Boolean.valueOf(r2));
            o.c(r1, "OUI_Effect_Stroke_Green_Thin.invoke(isLight)");
            return com.obric.oui.color.g.a((com.obric.oui.color.f) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.color.f.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.e invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    /* JADX INFO: compiled from: StrokeToken.kt */
    static final class e extends p implements d.h.a.b<Boolean, com.obric.oui.color.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f34487a = null;

        static {
            f34487a = new e();
        }

        e() {
            super(1);
        }

        public final com.obric.oui.color.e a(boolean r2) {
            com.obric.oui.color.f r1 = StrokeTokenCore.OUI_Effect_Stroke_Red_Regular.invoke(Boolean.valueOf(r2));
            o.c(r1, "OUI_Effect_Stroke_Red_Regular.invoke(isLight)");
            return com.obric.oui.color.g.a((com.obric.oui.color.f) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.color.f.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.e invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    /* JADX INFO: compiled from: StrokeToken.kt */
    static final class f extends p implements d.h.a.b<Boolean, com.obric.oui.color.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f34488a = null;

        static {
            f34488a = new f();
        }

        f() {
            super(1);
        }

        public final com.obric.oui.color.e a(boolean r2) {
            com.obric.oui.color.f r1 = StrokeTokenCore.OUI_Effect_Stroke_Red_Thin.invoke(Boolean.valueOf(r2));
            o.c(r1, "OUI_Effect_Stroke_Red_Thin.invoke(isLight)");
            return com.obric.oui.color.g.a((com.obric.oui.color.f) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.color.f.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.e invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    /* JADX INFO: compiled from: StrokeToken.kt */
    static final class g extends p implements d.h.a.b<Boolean, com.obric.oui.color.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f34489a = null;

        static {
            f34489a = new g();
        }

        g() {
            super(1);
        }

        public final com.obric.oui.color.e a(boolean r2) {
            com.obric.oui.color.f r1 = StrokeTokenCore.OUI_Effect_Stroke_Regular.invoke(Boolean.valueOf(r2));
            o.c(r1, "OUI_Effect_Stroke_Regular.invoke(isLight)");
            return com.obric.oui.color.g.a((com.obric.oui.color.f) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.color.f.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.e invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    /* JADX INFO: compiled from: StrokeToken.kt */
    static final class h extends p implements d.h.a.b<Boolean, com.obric.oui.color.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f34490a = null;

        static {
            f34490a = new h();
        }

        h() {
            super(1);
        }

        public final com.obric.oui.color.e a(boolean r2) {
            com.obric.oui.color.f r1 = StrokeTokenCore.OUI_Effect_Stroke_Thick.invoke(Boolean.valueOf(r2));
            o.c(r1, "OUI_Effect_Stroke_Thick.invoke(isLight)");
            return com.obric.oui.color.g.a((com.obric.oui.color.f) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.color.f.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.e invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    /* JADX INFO: compiled from: StrokeToken.kt */
    static final class i extends p implements d.h.a.b<Boolean, com.obric.oui.color.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f34491a = null;

        static {
            f34491a = new i();
        }

        i() {
            super(1);
        }

        public final com.obric.oui.color.e a(boolean r2) {
            com.obric.oui.color.f r1 = StrokeTokenCore.OUI_Effect_Stroke_Thin.invoke(Boolean.valueOf(r2));
            o.c(r1, "OUI_Effect_Stroke_Thin.invoke(isLight)");
            return com.obric.oui.color.g.a((com.obric.oui.color.f) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.color.f.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.e invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    /* JADX INFO: compiled from: StrokeToken.kt */
    static final class j extends p implements d.h.a.b<Boolean, com.obric.oui.color.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f34492a = null;

        static {
            f34492a = new j();
        }

        j() {
            super(1);
        }

        public final com.obric.oui.color.e a(boolean r2) {
            com.obric.oui.color.f r1 = StrokeTokenCore.OUI_Effect_Stroke_UltraThin.invoke(Boolean.valueOf(r2));
            o.c(r1, "OUI_Effect_Stroke_UltraThin.invoke(isLight)");
            return com.obric.oui.color.g.a((com.obric.oui.color.f) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.color.f.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.e invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    /* JADX INFO: compiled from: StrokeToken.kt */
    static final class k extends p implements d.h.a.b<Boolean, com.obric.oui.color.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f34493a = null;

        static {
            f34493a = new k();
        }

        k() {
            super(1);
        }

        public final com.obric.oui.color.e a(boolean r2) {
            com.obric.oui.color.f r1 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Regular.invoke(Boolean.valueOf(r2));
            o.c(r1, "OUI_Effect_Stroke_Yellow_Regular.invoke(isLight)");
            return com.obric.oui.color.g.a((com.obric.oui.color.f) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.color.f.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.e invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    /* JADX INFO: compiled from: StrokeToken.kt */
    static final class l extends p implements d.h.a.b<Boolean, com.obric.oui.color.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f34494a = null;

        static {
            f34494a = new l();
        }

        l() {
            super(1);
        }

        public final com.obric.oui.color.e a(boolean r2) {
            com.obric.oui.color.f r1 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Thin.invoke(Boolean.valueOf(r2));
            o.c(r1, "OUI_Effect_Stroke_Yellow_Thin.invoke(isLight)");
            return com.obric.oui.color.g.a((com.obric.oui.color.f) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.color.f.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.e invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    /* JADX INFO: compiled from: StrokeToken.kt */
    static final class m extends p implements d.h.a.b<Boolean, com.obric.oui.color.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, com.obric.oui.color.f> f34495a;

        m(Function1<Boolean, com.obric.oui.color.f> r3) {
            this.f34495a = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.aiagent.plugin");
            super(1);
        }

        public final com.obric.oui.color.e a(boolean r2) {
            com.obric.oui.color.f r1 = this.f34495a.invoke(Boolean.valueOf(r2));
            o.c(r1, "provider.invoke(isLight)");
            return com.obric.oui.color.g.a((com.obric.oui.color.f) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.color.f.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.color.e invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    public static /* synthetic */ void getOUI_Effect_Stroke_Blue_Regular$annotations() {
    }

    public static /* synthetic */ void getOUI_Effect_Stroke_Blue_Thin$annotations() {
    }

    public static /* synthetic */ void getOUI_Effect_Stroke_Green_Regular$annotations() {
    }

    public static /* synthetic */ void getOUI_Effect_Stroke_Green_Thin$annotations() {
    }

    public static /* synthetic */ void getOUI_Effect_Stroke_Red_Regular$annotations() {
    }

    public static /* synthetic */ void getOUI_Effect_Stroke_Red_Thin$annotations() {
    }

    public static /* synthetic */ void getOUI_Effect_Stroke_Regular$annotations() {
    }

    public static /* synthetic */ void getOUI_Effect_Stroke_Thick$annotations() {
    }

    public static /* synthetic */ void getOUI_Effect_Stroke_Thin$annotations() {
    }

    public static /* synthetic */ void getOUI_Effect_Stroke_UltraThin$annotations() {
    }

    public static /* synthetic */ void getOUI_Effect_Stroke_Yellow_Regular$annotations() {
    }

    public static /* synthetic */ void getOUI_Effect_Stroke_Yellow_Thin$annotations() {
    }

    /* JADX INFO: renamed from: lambda$CycHbhzIbhQzjA8E-9l-h9dCQgw, reason: not valid java name */
    public static /* synthetic */ com.obric.oui.color.f m994lambda$CycHbhzIbhQzjA8E9lh9dCQgw(d.h.a.b r0, Boolean r1) {
        return m995registerProviderTokens$lambda2$lambda1(r0, r1);
    }

    private StrokeToken() {
    }

    public static /* synthetic */ void register$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        register(r0, r1);
    }

    public static final void register(Object r1, boolean r2) {
        o.e(r1, "customTokenOwner");
        StrokeTokenCore.register(INSTANCE, r1, r2);
    }

    public static /* synthetic */ void registerTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerTokens(r5, r2);
    }

    public static final void registerTokens(Map<String, com.obric.oui.color.e> r6, boolean r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        o.e(r8, "customTokens");
        StrokeToken r0 = INSTANCE;
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(ao.a(r8.size())), Map.class, "com.obric.aiagent.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Object r3 = r9.next();
        r2.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), ((com.obric.oui.color.e) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), com.obric.oui.color.e.class, "com.obric.aiagent.plugin")).d());
        goto L4
    L6:
        StrokeTokenCore.registerTokens(r0, r2, r7);
    }

    public static /* synthetic */ void registerProvider$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerProvider(r0, r1);
    }

    public static final void registerProvider(Object r1, boolean r2) {
        o.e(r1, "customTokenOwner");
        StrokeTokenCore.registerProvider(INSTANCE, r1, r2);
    }

    public static /* synthetic */ void registerProviderTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerProviderTokens(r5, r2);
    }

    public static final void registerProviderTokens(Map<String, ? extends d.h.a.b<? super Boolean, com.obric.oui.color.e>> r6, boolean r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        o.e(r8, "customTokens");
        StrokeToken r0 = INSTANCE;
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(ao.a(r8.size())), Map.class, "com.obric.aiagent.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Object r3 = r9.next();
        Object r4 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin")).getKey();
        final d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), d.h.a.b.class, "com.obric.aiagent.plugin");
        r2.put(r4, new $$Lambda$StrokeToken$CycHbhzIbhQzjA8E9lh9dCQgw(r5));
        goto L4
    L6:
        StrokeTokenCore.registerProviderTokens(r0, r2, r7);
    }

    /* JADX INFO: renamed from: registerProviderTokens$lambda-2$lambda-1, reason: not valid java name */
    private static final com.obric.oui.color.f m995registerProviderTokens$lambda2$lambda1(d.h.a.b r2, Boolean r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "$provider");
        o.c(r3, "isLight");
        return ((com.obric.oui.color.e) ZeusTransformUtils.preCheckCast(r4.invoke(r3), com.obric.oui.color.e.class, "com.obric.aiagent.plugin")).d();
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.e> parse(String r2) {
        Function1<Boolean, com.obric.oui.color.f> r3 = StrokeTokenCore.parseProvider(INSTANCE, r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return (d.h.a.b) ZeusTransformUtils.preCheckCast(new m(r3), d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public static final com.obric.oui.color.e parse(String r1, boolean r2) {
        com.obric.oui.color.f r3 = StrokeTokenCore.parse(INSTANCE, r1, r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        return com.obric.oui.color.g.a(r3);
    }

    static {
        INSTANCE = new StrokeToken();
        com.obric.oui.color.f r0 = StrokeTokenCore.OUI_Effect_Stroke_Regular_Light;
        o.c(r0, "OUI_Effect_Stroke_Regular_Light");
        OUI_Effect_Stroke_Regular_Light = com.obric.oui.color.g.a(r0);
        com.obric.oui.color.f r1 = StrokeTokenCore.OUI_Effect_Stroke_Regular_Dark;
        o.c(r1, "OUI_Effect_Stroke_Regular_Dark");
        OUI_Effect_Stroke_Regular_Dark = com.obric.oui.color.g.a(r1);
        OUI_Effect_Stroke_Regular = (d.h.a.b) ZeusTransformUtils.preCheckCast(g.f34489a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.color.f r2 = StrokeTokenCore.OUI_Effect_Stroke_UltraThin_Light;
        o.c(r2, "OUI_Effect_Stroke_UltraThin_Light");
        OUI_Effect_Stroke_UltraThin_Light = com.obric.oui.color.g.a(r2);
        com.obric.oui.color.f r3 = StrokeTokenCore.OUI_Effect_Stroke_UltraThin_Dark;
        o.c(r3, "OUI_Effect_Stroke_UltraThin_Dark");
        OUI_Effect_Stroke_UltraThin_Dark = com.obric.oui.color.g.a(r3);
        OUI_Effect_Stroke_UltraThin = (d.h.a.b) ZeusTransformUtils.preCheckCast(j.f34492a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.color.f r4 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Light;
        o.c(r4, "OUI_Effect_Stroke_Thin_Light");
        OUI_Effect_Stroke_Thin_Light = com.obric.oui.color.g.a(r4);
        com.obric.oui.color.f r5 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark;
        o.c(r5, "OUI_Effect_Stroke_Thin_Dark");
        OUI_Effect_Stroke_Thin_Dark = com.obric.oui.color.g.a(r5);
        OUI_Effect_Stroke_Thin = (d.h.a.b) ZeusTransformUtils.preCheckCast(i.f34491a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.color.f r6 = StrokeTokenCore.OUI_Effect_Stroke_Thick_Light;
        o.c(r6, "OUI_Effect_Stroke_Thick_Light");
        OUI_Effect_Stroke_Thick_Light = com.obric.oui.color.g.a(r6);
        com.obric.oui.color.f r7 = StrokeTokenCore.OUI_Effect_Stroke_Thick_Dark;
        o.c(r7, "OUI_Effect_Stroke_Thick_Dark");
        OUI_Effect_Stroke_Thick_Dark = com.obric.oui.color.g.a(r7);
        OUI_Effect_Stroke_Thick = (d.h.a.b) ZeusTransformUtils.preCheckCast(h.f34490a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.color.f r8 = StrokeTokenCore.OUI_Effect_Stroke_Tinted_Light;
        o.c(r8, "OUI_Effect_Stroke_Tinted_Light");
        OUI_Effect_Stroke_Tinted_Light = com.obric.oui.color.g.a(r8);
        com.obric.oui.color.f r9 = StrokeTokenCore.OUI_Effect_Stroke_Tinted_Dark;
        o.c(r9, "OUI_Effect_Stroke_Tinted_Dark");
        OUI_Effect_Stroke_Tinted_Dark = com.obric.oui.color.g.a(r9);
        com.obric.oui.color.f r10 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Light;
        o.c(r10, "OUI_Effect_Stroke_Blue_Regular_Light");
        OUI_Effect_Stroke_Blue_Regular_Light = com.obric.oui.color.g.a(r10);
        com.obric.oui.color.f r11 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Dark;
        o.c(r11, "OUI_Effect_Stroke_Blue_Regular_Dark");
        OUI_Effect_Stroke_Blue_Regular_Dark = com.obric.oui.color.g.a(r11);
        OUI_Effect_Stroke_Blue_Regular = (d.h.a.b) ZeusTransformUtils.preCheckCast(a.f34483a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.color.f r12 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Thin_Light;
        o.c(r12, "OUI_Effect_Stroke_Blue_Thin_Light");
        OUI_Effect_Stroke_Blue_Thin_Light = com.obric.oui.color.g.a(r12);
        com.obric.oui.color.f r13 = StrokeTokenCore.OUI_Effect_Stroke_Blue_Thin_Dark;
        o.c(r13, "OUI_Effect_Stroke_Blue_Thin_Dark");
        OUI_Effect_Stroke_Blue_Thin_Dark = com.obric.oui.color.g.a(r13);
        OUI_Effect_Stroke_Blue_Thin = (d.h.a.b) ZeusTransformUtils.preCheckCast(b.f34484a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.color.f r14 = StrokeTokenCore.OUI_Effect_Stroke_Red_Regular_Light;
        o.c(r14, "OUI_Effect_Stroke_Red_Regular_Light");
        OUI_Effect_Stroke_Red_Regular_Light = com.obric.oui.color.g.a(r14);
        com.obric.oui.color.f r15 = StrokeTokenCore.OUI_Effect_Stroke_Red_Regular_Dark;
        o.c(r15, "OUI_Effect_Stroke_Red_Regular_Dark");
        OUI_Effect_Stroke_Red_Regular_Dark = com.obric.oui.color.g.a(r15);
        OUI_Effect_Stroke_Red_Regular = (d.h.a.b) ZeusTransformUtils.preCheckCast(e.f34487a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.color.f r16 = StrokeTokenCore.OUI_Effect_Stroke_Red_Thin_Light;
        o.c(r16, "OUI_Effect_Stroke_Red_Thin_Light");
        OUI_Effect_Stroke_Red_Thin_Light = com.obric.oui.color.g.a(r16);
        com.obric.oui.color.f r17 = StrokeTokenCore.OUI_Effect_Stroke_Red_Thin_Dark;
        o.c(r17, "OUI_Effect_Stroke_Red_Thin_Dark");
        OUI_Effect_Stroke_Red_Thin_Dark = com.obric.oui.color.g.a(r17);
        OUI_Effect_Stroke_Red_Thin = (d.h.a.b) ZeusTransformUtils.preCheckCast(f.f34488a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.color.f r18 = StrokeTokenCore.OUI_Effect_Stroke_Green_Regular_Light;
        o.c(r18, "OUI_Effect_Stroke_Green_Regular_Light");
        OUI_Effect_Stroke_Green_Regular_Light = com.obric.oui.color.g.a(r18);
        com.obric.oui.color.f r19 = StrokeTokenCore.OUI_Effect_Stroke_Green_Regular_Dark;
        o.c(r19, "OUI_Effect_Stroke_Green_Regular_Dark");
        OUI_Effect_Stroke_Green_Regular_Dark = com.obric.oui.color.g.a(r19);
        OUI_Effect_Stroke_Green_Regular = (d.h.a.b) ZeusTransformUtils.preCheckCast(c.f34485a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.color.f r20 = StrokeTokenCore.OUI_Effect_Stroke_Green_Thin_Light;
        o.c(r20, "OUI_Effect_Stroke_Green_Thin_Light");
        OUI_Effect_Stroke_Green_Thin_Light = com.obric.oui.color.g.a(r20);
        com.obric.oui.color.f r21 = StrokeTokenCore.OUI_Effect_Stroke_Green_Thin_Dark;
        o.c(r21, "OUI_Effect_Stroke_Green_Thin_Dark");
        OUI_Effect_Stroke_Green_Thin_Dark = com.obric.oui.color.g.a(r21);
        OUI_Effect_Stroke_Green_Thin = (d.h.a.b) ZeusTransformUtils.preCheckCast(d.f34486a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.color.f r22 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Regular_Light;
        o.c(r22, "OUI_Effect_Stroke_Yellow_Regular_Light");
        OUI_Effect_Stroke_Yellow_Regular_Light = com.obric.oui.color.g.a(r22);
        com.obric.oui.color.f r23 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Regular_Dark;
        o.c(r23, "OUI_Effect_Stroke_Yellow_Regular_Dark");
        OUI_Effect_Stroke_Yellow_Regular_Dark = com.obric.oui.color.g.a(r23);
        OUI_Effect_Stroke_Yellow_Regular = (d.h.a.b) ZeusTransformUtils.preCheckCast(k.f34493a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.color.f r24 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Thin_Light;
        o.c(r24, "OUI_Effect_Stroke_Yellow_Thin_Light");
        OUI_Effect_Stroke_Yellow_Thin_Light = com.obric.oui.color.g.a(r24);
        com.obric.oui.color.f r25 = StrokeTokenCore.OUI_Effect_Stroke_Yellow_Thin_Dark;
        o.c(r25, "OUI_Effect_Stroke_Yellow_Thin_Dark");
        OUI_Effect_Stroke_Yellow_Thin_Dark = com.obric.oui.color.g.a(r25);
        OUI_Effect_Stroke_Yellow_Thin = (d.h.a.b) ZeusTransformUtils.preCheckCast(l.f34494a, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.e> getOUI_Effect_Stroke_Regular() {
        return OUI_Effect_Stroke_Regular;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.e> getOUI_Effect_Stroke_UltraThin() {
        return OUI_Effect_Stroke_UltraThin;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.e> getOUI_Effect_Stroke_Thin() {
        return OUI_Effect_Stroke_Thin;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.e> getOUI_Effect_Stroke_Thick() {
        return OUI_Effect_Stroke_Thick;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.e> getOUI_Effect_Stroke_Blue_Regular() {
        return OUI_Effect_Stroke_Blue_Regular;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.e> getOUI_Effect_Stroke_Blue_Thin() {
        return OUI_Effect_Stroke_Blue_Thin;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.e> getOUI_Effect_Stroke_Red_Regular() {
        return OUI_Effect_Stroke_Red_Regular;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.e> getOUI_Effect_Stroke_Red_Thin() {
        return OUI_Effect_Stroke_Red_Thin;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.e> getOUI_Effect_Stroke_Green_Regular() {
        return OUI_Effect_Stroke_Green_Regular;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.e> getOUI_Effect_Stroke_Green_Thin() {
        return OUI_Effect_Stroke_Green_Thin;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.e> getOUI_Effect_Stroke_Yellow_Regular() {
        return OUI_Effect_Stroke_Yellow_Regular;
    }

    public static final d.h.a.b<Boolean, com.obric.oui.color.e> getOUI_Effect_Stroke_Yellow_Thin() {
        return OUI_Effect_Stroke_Yellow_Thin;
    }
}
