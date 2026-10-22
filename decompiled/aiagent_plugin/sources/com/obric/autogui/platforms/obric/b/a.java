package com.obric.autogui.platforms.obric.b;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.system.POILocationInfo;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.z;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: MemoryApiPOILocation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "LocationImpl/MemoryPOI";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30064a = null;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.obric.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MemoryApiPOILocation.kt */
    @f(b = "MemoryApiPOILocation.kt", c = {28}, d = "acquirePOILocation", e = "com.obric.autogui.platforms.obric.location.MemoryApiPOILocation")
    static final class C0790a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f30067c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f30068d;

        C0790a(a r3, d.c.d<? super C0790a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30067c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30066b = r3;
            this.f30068d |= Integer.MIN_VALUE;
            return this.f30067c.a(null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: MemoryApiPOILocation.kt */
    @f(b = "MemoryApiPOILocation.kt", c = {29}, d = "invokeSuspend", e = "com.obric.autogui.platforms.obric.location.MemoryApiPOILocation$acquirePOILocation$result$1")
    static final class b extends l implements m<am, d.c.d<? super POILocationInfo>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f30070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z.f<Throwable> f30071c;

        /* JADX INFO: renamed from: com.obric.autogui.platforms.obric.b.a$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: MemoryApiPOILocation.kt */
        @f(b = "MemoryApiPOILocation.kt", c = {36, 37}, d = "invokeSuspend", e = "com.obric.autogui.platforms.obric.location.MemoryApiPOILocation$acquirePOILocation$result$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super POILocationInfo>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f30072a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Context f30073b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ z.f<Throwable> f30074c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private /* synthetic */ Object f30075d;

            /* JADX INFO: renamed from: com.obric.autogui.platforms.obric.b.a$b$1$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: MemoryApiPOILocation.kt */
            @f(b = "MemoryApiPOILocation.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.obric.location.MemoryApiPOILocation$acquirePOILocation$result$1$1$companyDeferred$1")
            static final class C0791a extends l implements m<am, d.c.d<? super MemoryResponse<Location>>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f30076a;

                C0791a(d.c.d<? super C0791a> r3) {
                    super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                public final Object a(am r3, d.c.d<? super MemoryResponse<Location>> r4) {
                    return ((C0791a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0791a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new C0791a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.m
                public /* synthetic */ Object invoke(am r3, d.c.d<? super MemoryResponse<Location>> r4) {
                    return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r1) {
                    d.c.a.b.a();
                    if (this.f30076a != 0) goto L7;
                    o.a(r1);
                    return com.obric.memorydata.sdk.awareness.a.f33811a.a(e.f33825b);
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.obric.autogui.platforms.obric.b.a$b$1$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: MemoryApiPOILocation.kt */
            @f(b = "MemoryApiPOILocation.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.obric.location.MemoryApiPOILocation$acquirePOILocation$result$1$1$homeDeferred$1")
            static final class C0792b extends l implements m<am, d.c.d<? super MemoryResponse<Location>>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f30077a;

                C0792b(d.c.d<? super C0792b> r3) {
                    super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                public final Object a(am r3, d.c.d<? super MemoryResponse<Location>> r4) {
                    return ((C0792b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0792b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new C0792b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.m
                public /* synthetic */ Object invoke(am r3, d.c.d<? super MemoryResponse<Location>> r4) {
                    return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r1) {
                    d.c.a.b.a();
                    if (this.f30077a != 0) goto L7;
                    o.a(r1);
                    return com.obric.memorydata.sdk.awareness.a.f33811a.a(e.f33824a);
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            AnonymousClass1(Context r3, z.f<Throwable> r4, d.c.d<? super AnonymousClass1> r5) {
                Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f30073b = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
                this.f30074c = r4;
                super(2, r7);
            }

            public final Object a(am r3, d.c.d<? super POILocationInfo> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.f30073b, this.f30074c, r6);
                r0.f30075d = r4;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super POILocationInfo> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object, java.lang.Throwable] */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r19) {
                Object r3 = d.c.a.b.a();
                int r4 = this.f30072a;
                if (r4 == 0) goto L14;
                if (r4 == 1) goto L11;
                if (r4 != 2) goto L10;
                MemoryResponse r5 = (MemoryResponse) ZeusTransformUtils.preCheckCast(this.f30075d, MemoryResponse.class, "com.obric.aiagent.plugin");
                o.a(r19);     // Catch: Throwable -> L51
                Object r6 = r19;
            L22:
                MemoryResponse r7 = (MemoryResponse) ZeusTransformUtils.preCheckCast(r6, MemoryResponse.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
                String r8 = this.f30073b.getString(ZeusTransformUtils.mapRes(R.string.obric_location_home_unknown, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_location_home_unknown"));     // Catch: Throwable -> L51
                d.h.b.o.c(r8, "getString(...)");     // Catch: Throwable -> L51
                String r2 = this.f30073b.getString(ZeusTransformUtils.mapRes(R.string.obric_location_company_unknown, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_location_company_unknown"));     // Catch: Throwable -> L51
                d.h.b.o.c(r2, "getString(...)");     // Catch: Throwable -> L51
                if (r5.isSuccess() == false) goto L35;
                Location r0 = (Location) ZeusTransformUtils.preCheckCast(r5.getData(), Location.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
                if (r0 == null) goto L30;
                Bundle r1 = r0.getExtras();     // Catch: Throwable -> L51
                if (r1 == null) goto L30;
                String r9 = r1.getString(SensitiveType.ADDRESS);     // Catch: Throwable -> L51
            L31:
                if (r9 != null) goto L33;
                r8 = "";
            L34:
                String r14 = r8;
                if (r7.isSuccess() == false) goto L48;
                Location r10 = (Location) ZeusTransformUtils.preCheckCast(r7.getData(), Location.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
                if (r10 == null) goto L43;
                Bundle r11 = r10.getExtras();     // Catch: Throwable -> L51
                if (r11 == null) goto L43;
                String r12 = r11.getString(SensitiveType.ADDRESS);     // Catch: Throwable -> L51
            L44:
                if (r12 != null) goto L46;
                r2 = "";
            L49:
                return new POILocationInfo(true, r14, r2, System.currentTimeMillis());
            L46:
                r2 = r12;
            L43:
                r12 = null;
                goto L44
            L48:
                Loog.INSTANCE.w(a.TAG, "get company location failed, errorCode: " + r7.getCode() + ", errorMessage: " + r7.getMessage());     // Catch: Throwable -> L51
                goto L49
            L33:
                r8 = r9;
            L30:
                r9 = null;
                goto L31
            L35:
                Loog.INSTANCE.w(a.TAG, "get home location failed, errorCode: " + r5.getCode() + ", errorMessage: " + r5.getMessage());     // Catch: Throwable -> L51
                goto L34
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                au r13 = (au) ZeusTransformUtils.preCheckCast(this.f30075d, au.class, "com.obric.aiagent.plugin");
                o.a(r19);     // Catch: Throwable -> L51
                au r15 = r13;
                Object r16 = r19;
            L18:
                MemoryResponse r17 = (MemoryResponse) ZeusTransformUtils.preCheckCast(r16, MemoryResponse.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
                d.c.d r18 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
                this.f30075d = r17;     // Catch: Throwable -> L51
                this.f30072a = 2;     // Catch: Throwable -> L51
                r6 = r15.a(r18);     // Catch: Throwable -> L51
                if (r6 != r3) goto L21;
                return r3;
            L21:
                r5 = r17;
                goto L22
            L14:
                o.a(r19);
                am r20 = (am) ZeusTransformUtils.preCheckCast(this.f30075d, am.class, "com.obric.aiagent.plugin");
                au r110 = i.b(r20, null, null, (m) ZeusTransformUtils.preCheckCast(new C0792b(null), m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Throwable -> L51
                r15 = i.b(r20, null, null, (m) ZeusTransformUtils.preCheckCast(new C0791a(null), m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Throwable -> L51
                d.c.d r111 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
                this.f30075d = r15;     // Catch: Throwable -> L51
                this.f30072a = 1;     // Catch: Throwable -> L51
                r16 = r110.a(r111);     // Catch: Throwable -> L51
                if (r16 != r3) goto L18;
                return r3;
            L51:
                th = move-exception;
                Loog.INSTANCE.e(a.TAG, "failed to execute RCSearchStateWhenStartQuery (e: " + th + ").", th);
                this.f30074c.f38504a = th;
                return null;
            }
        }

        b(Context r3, z.f<Throwable> r4, d.c.d<? super b> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30070b = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            this.f30071c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super POILocationInfo> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f30070b, this.f30071c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super POILocationInfo> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30069a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            g r9 = (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin");
            m r2 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f30070b, this.f30071c, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30069a = 1;
            r8 = i.a(r9, r2, r3);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    static {
        f30064a = new a();
    }

    private a() {
    }

    public final Object a(Context r8, boolean r9, d.c.d<? super com.obric.autogui.common.d<POILocationInfo>> r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, C0790a.class) == false) goto L7;
        C0790a r13 = (C0790a) ZeusTransformUtils.preCheckCast(r12, C0790a.class, "com.obric.aiagent.plugin");
        if ((r13.f30068d & Integer.MIN_VALUE) == 0) goto L7;
        r13.f30068d -= Integer.MIN_VALUE;
    L8:
        Object r7 = r13.f30066b;
        Object r14 = d.c.a.b.a();
        int r1 = r13.f30068d;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        z.f r15 = (z.f) ZeusTransformUtils.preCheckCast(r13.f30065a, z.f.class, "com.obric.aiagent.plugin");
        o.a(r7);
    L18:
        POILocationInfo r16 = (POILocationInfo) ZeusTransformUtils.preCheckCast(r7, POILocationInfo.class, "com.obric.aiagent.plugin");
        if (r15.f38504a == 0) goto L22;
        Loog.INSTANCE.e(TAG, "failed to get POI location from Memory (thr) (e: " + r15.f38504a + ").", (Throwable) ZeusTransformUtils.preCheckCast(r15.f38504a, Throwable.class, "com.obric.aiagent.plugin"));
        return com.obric.autogui.common.d.f29012a.a("failed-to-execute");
    L22:
        if (r16 != null) goto L26;
        Loog.INSTANCE.e(TAG, "failed to get POI location from Memory (timeout).");
        return com.obric.autogui.common.d.f29012a.a("poi-timeout");
    L26:
        return com.obric.autogui.common.d.f29012a.a(r16);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r7);
        z.f r17 = new z.f();
        m r18 = (m) ZeusTransformUtils.preCheckCast(new b(r11, r17, null), m.class, "com.obric.aiagent.plugin");
        r13.f30065a = r17;
        r13.f30068d = 1;
        Object r19 = dg.b(8000, r18, r13);
        if (r19 != r14) goto L17;
        return r14;
    L17:
        r15 = r17;
        r7 = r19;
    L7:
        r13 = new C0790a(this, r12);
        goto L8
    }
}
