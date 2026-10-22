package com.obric.autoaction.app.launcherpage.query.task;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.condition.location.ConditionLocationRepo;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.strategy.SensitiveOperation;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.event.task.nlp.api.j;
import com.obric.event.task.nlp.api.k;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.LocationCondition;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.oui.orecyclerview.widget.ItemTouchHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.z;
import d.l.n;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: LocationConditionConvertor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f24338a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f24339b = 0;

    /* JADX INFO: compiled from: LocationConditionConvertor.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24340a = null;

        static {
            int[] r0 = new int[k.values().length];
            r0[k.f32925a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[k.f32926b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f24340a = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.query.task.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LocationConditionConvertor.kt */
    @d.c.b.a.f(b = "LocationConditionConvertor.kt", c = {135, 144, 158}, d = "getLocationInfoForDraft", e = "com.obric.autoaction.app.launcherpage.query.task.LocationConditionConvertor")
    static final class C0557b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f24342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f24343c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f24344d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f24345e;

        C0557b(b r3, d.c.d<? super C0557b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24344d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24343c = r3;
            this.f24345e |= Integer.MIN_VALUE;
            return b.a(this.f24344d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: LocationConditionConvertor.kt */
    @d.c.b.a.f(b = "LocationConditionConvertor.kt", c = {138}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.query.task.LocationConditionConvertor$getLocationInfoForDraft$2")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z.f<com.obric.event.task.nlp.api.d<List<LocationCondition>>> f24347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f24348c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f24349d;

        /* JADX INFO: compiled from: LocationConditionConvertor.kt */
        @d.c.b.a.f(b = "LocationConditionConvertor.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.query.task.LocationConditionConvertor$getLocationInfoForDraft$2$homeDeferred$1")
        static final class a extends l implements m<am, d.c.d<? super MemoryResponse<Location>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24350a;

            a(d.c.d<? super a> r3) {
                super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(am r3, d.c.d<? super MemoryResponse<Location>> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super MemoryResponse<Location>> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r1) {
                d.c.a.b.a();
                if (this.f24350a != 0) goto L7;
                o.a(r1);
                return com.obric.memorydata.sdk.awareness.a.f33811a.a(com.obric.memorydata.sdk.awareness.e.f33824a);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        c(z.f<com.obric.event.task.nlp.api.d<List<LocationCondition>>> r3, j r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24347b = r3;
            this.f24348c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f24347b, this.f24348c, r6);
            r0.f24349d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r10v2, types: [T, com.obric.event.task.nlp.api.d] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24346a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L11:
            MemoryResponse r12 = (MemoryResponse) ZeusTransformUtils.preCheckCast(r11, MemoryResponse.class, "com.obric.aiagent.plugin");
            z.f<com.obric.event.task.nlp.api.d<List<LocationCondition>>> r2 = this.f24347b;
            r2.f38504a = b.a(b.f24338a, k.f32925a, this.f24348c, r12);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            au r13 = i.b((am) ZeusTransformUtils.preCheckCast(this.f24349d, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new a(null), m.class, "com.obric.aiagent.plugin"), 3, null);
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24346a = 1;
            r11 = r13.a(r3);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: LocationConditionConvertor.kt */
    @d.c.b.a.f(b = "LocationConditionConvertor.kt", c = {147}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.query.task.LocationConditionConvertor$getLocationInfoForDraft$3")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z.f<com.obric.event.task.nlp.api.d<List<LocationCondition>>> f24352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f24353c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f24354d;

        /* JADX INFO: compiled from: LocationConditionConvertor.kt */
        @d.c.b.a.f(b = "LocationConditionConvertor.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.query.task.LocationConditionConvertor$getLocationInfoForDraft$3$companyDeferred$1")
        static final class a extends l implements m<am, d.c.d<? super MemoryResponse<Location>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24355a;

            a(d.c.d<? super a> r3) {
                super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(am r3, d.c.d<? super MemoryResponse<Location>> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super MemoryResponse<Location>> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r1) {
                d.c.a.b.a();
                if (this.f24355a != 0) goto L7;
                o.a(r1);
                return com.obric.memorydata.sdk.awareness.a.f33811a.a(com.obric.memorydata.sdk.awareness.e.f33825b);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        d(z.f<com.obric.event.task.nlp.api.d<List<LocationCondition>>> r3, j r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24352b = r3;
            this.f24353c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            d r0 = new d(this.f24352b, this.f24353c, r6);
            r0.f24354d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r10v2, types: [T, com.obric.event.task.nlp.api.d] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24351a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L11:
            MemoryResponse r12 = (MemoryResponse) ZeusTransformUtils.preCheckCast(r11, MemoryResponse.class, "com.obric.aiagent.plugin");
            z.f<com.obric.event.task.nlp.api.d<List<LocationCondition>>> r2 = this.f24352b;
            r2.f38504a = b.a(b.f24338a, k.f32926b, this.f24353c, r12);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            au r13 = i.b((am) ZeusTransformUtils.preCheckCast(this.f24354d, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new a(null), m.class, "com.obric.aiagent.plugin"), 3, null);
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24351a = 1;
            r11 = r13.a(r3);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: LocationConditionConvertor.kt */
    @d.c.b.a.f(b = "LocationConditionConvertor.kt", c = {222}, d = "getSearchLocationInfo", e = "com.obric.autoaction.app.launcherpage.query.task.LocationConditionConvertor")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f24357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f24358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24359d;

        e(b r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24358c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24357b = r3;
            this.f24359d |= Integer.MIN_VALUE;
            return b.a(this.f24358c, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: LocationConditionConvertor.kt */
    @d.c.b.a.f(b = "LocationConditionConvertor.kt", c = {51}, d = "handleLocationConditionCandidate", e = "com.obric.autoaction.app.launcherpage.query.task.LocationConditionConvertor")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f24361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f24362c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f24363d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f24364e;

        f(b r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24363d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24362c = r3;
            this.f24364e |= Integer.MIN_VALUE;
            return this.f24363d.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private b() {
    }

    public static final /* synthetic */ com.obric.event.task.nlp.api.d a(b r0, k r1, j r2, MemoryResponse r3) {
        return r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ Object a(b r2, com.obric.event.task.nlp.api.i r3, Context r4, d.c.d r5) {
        return r2.a(r3, (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, String r3, j r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f24338a = new b();
        TAG = "LocationConditionConvertor";
        f24339b = 20;
    }

    public final Object a(String r25, com.obric.event.task.nlp.api.i r26, Context r27, d.c.d<? super com.obric.event.task.nlp.api.d<com.obric.event.task.nlp.api.i>> r28) {
        String r1 = r25;
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r27, Context.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, f.class) == false) goto L7;
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if ((r6.f24364e & Integer.MIN_VALUE) == 0) goto L7;
        r6.f24364e -= Integer.MIN_VALUE;
    L8:
        Object r7 = r6.f24362c;
        Object r8 = d.c.a.b.a();
        int r9 = r6.f24364e;
        int r10 = 1;
        if (r9 == 0) goto L14;
        if (r9 != 1) goto L13;
        com.obric.event.task.nlp.api.i r0 = (com.obric.event.task.nlp.api.i) ZeusTransformUtils.preCheckCast(r6.f24361b, com.obric.event.task.nlp.api.i.class, "com.obric.aiagent.plugin");
        r1 = (String) ZeusTransformUtils.preCheckCast(r6.f24360a, String.class, "com.obric.aiagent.plugin");
        o.a(r7);
    L18:
        com.obric.event.task.nlp.api.d r2 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r7, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        if (r2.a() != null) goto L26;
        String r4 = r2.b();
        if (r4 != null) goto L23;
        String r11 = "";
    L24:
        ILogDepend.Companion.e(TAG, "handleLocationConditionCandidate errMsg = " + r11);
        return new com.obric.event.task.nlp.api.d(null, r11, r2.c(), null, 8, null);
    L23:
        r11 = r4;
        goto L24
    L26:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r2.a(), List.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L29;
    L32:
        boolean r14 = true;
    L33:
        if (r14 == false) goto L36;
        ILogDepend.Companion.e(TAG, "handleLocationConditionCandidate errMsg = location data empty");
        return new com.obric.event.task.nlp.api.d(null, "location data empty", ErrorCode.EventTask.LOCATION_DATA_EMPTY, null, 8, null);
    L36:
        LocationCondition r15 = (LocationCondition) ZeusTransformUtils.preCheckCast(r12.get(0), LocationCondition.class, "com.obric.aiagent.plugin");
        String r16 = r15.getAddrName();
        com.obric.event.task.nlp.b.c r17 = com.obric.event.task.nlp.b.c.f32953a;
        if (r16 != null) goto L39;
        String r18 = "";
    L40:
        String r19 = r17.a("location", r18, 0);
        com.obric.event.task.nlp.b.c.f32953a.a(r1, r19, (Condition) ZeusTransformUtils.preCheckCast(r15, Condition.class, "com.obric.aiagent.plugin"));
        ILogDepend.Companion r20 = ILogDepend.Companion;
        String r21 = TAG;
        r20.i(r21, "handleLocationConditionCandidate selected id = " + r19 + ", name = " + r16);
        com.obric.event.task.nlp.api.b r22 = new com.obric.event.task.nlp.api.b(r19, r16);
        ArrayList r23 = new ArrayList();
        int r24 = n.d(f24339b, r12.size());
        ILogDepend.Companion.i(r21, "handleLocationConditionCandidate max size = " + r24);
        if (r24 < 2) goto L49;
    L42:
        if (r10 >= r24) goto L49;
        LocationCondition r29 = (LocationCondition) ZeusTransformUtils.preCheckCast(r12.get(r10), LocationCondition.class, "com.obric.aiagent.plugin");
        String r110 = r29.getAddrName();
        com.obric.event.task.nlp.b.c r111 = com.obric.event.task.nlp.b.c.f32953a;
        if (r110 != null) goto L46;
        String r112 = "";
    L47:
        String r113 = r111.a("location", r112, r10);
        com.obric.event.task.nlp.b.c.f32953a.a(r1, r113, (Condition) ZeusTransformUtils.preCheckCast(r29, Condition.class, "com.obric.aiagent.plugin"));
        com.obric.event.task.nlp.api.b r30 = new com.obric.event.task.nlp.api.b(r113, r110);
        ILogDepend.Companion.i(TAG, "handleLocationConditionCandidate candidate index = " + r10 + ", id = " + r113 + ", name = " + r110);
        r23.add(r30);
        r10 = r10 + 1;
        r12 = r12;
        r1 = r1;
        goto L42
    L46:
        r112 = r110;
    L49:
        return new com.obric.event.task.nlp.api.d(new com.obric.event.task.nlp.api.i(r0.a(), null, new com.obric.event.task.nlp.api.a(r22, (List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.aiagent.plugin")), 2, null), null, 0, null, 10, null);
    L39:
        r18 = r16;
        goto L40
    L29:
        if (r13.isEmpty() == true) goto L32;
        r14 = false;
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r7);
        ILogDepend.Companion.i(TAG, "handleLocationConditionCandidate taskStrKey = " + r1);
        r6.f24360a = r1;
        r6.f24361b = r26;
        r6.f24364e = 1;
        r7 = a(r26, r3, r6);
        if (r7 != r8) goto L17;
        return r8;
    L17:
        r0 = r26;
    L7:
        r6 = new f(this, r5);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object a(com.obric.event.task.nlp.api.i r21, Context r22, d.c.d<? super com.obric.event.task.nlp.api.d<List<LocationCondition>>> r23) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r22, Context.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, C0557b.class) == false) goto L7;
        C0557b r4 = (C0557b) ZeusTransformUtils.preCheckCast(r3, C0557b.class, "com.obric.aiagent.plugin");
        if ((r4.f24345e & Integer.MIN_VALUE) == 0) goto L7;
        r4.f24345e -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.f24343c;
        Object r6 = d.c.a.b.a();
        int r7 = r4.f24345e;
        boolean r9 = true;
        if (r7 == 0) goto L17;
        if (r7 == 1) goto L16;
        if (r7 == 2) goto L16;
        if (r7 != 3) goto L15;
        z.f r0 = (z.f) ZeusTransformUtils.preCheckCast(r4.f24342b, z.f.class, "com.obric.aiagent.plugin");
        z.f r2 = (z.f) ZeusTransformUtils.preCheckCast(r4.f24341a, z.f.class, "com.obric.aiagent.plugin");
        o.a(r5);
        T r8 = r5;
    L50:
        r0.f38504a = r8;
    L60:
        if (r2.f38504a == 0) goto L63;
        T r10 = r2.f38504a;
        d.h.b.o.a(r10);
        return r10;
    L63:
        ILogDepend.Companion.e(TAG, "getLocationInfoForDraft location flow error");
        return new com.obric.event.task.nlp.api.d(null, "location flow error", ErrorCode.EventTask.LOCATION_FLOW_ERROR, null, 8, null);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        z.f r11 = (z.f) ZeusTransformUtils.preCheckCast(r4.f24341a, z.f.class, "com.obric.aiagent.plugin");
        o.a(r5);
    L58:
        r2 = r11;
        goto L60
    L17:
        o.a(r5);
        ILogDepend.Companion r12 = ILogDepend.Companion;
        String r13 = TAG;
        r12.i(r13, "getLocationInfoForDraft");
        j r14 = r21.a();
        if (r14 != null) goto L21;
        ILogDepend.Companion.e(r13, "getLocationInfoForDraft location eventType empty");
        return new com.obric.event.task.nlp.api.d(null, "location eventType empty", ErrorCode.EventTask.LOCATION_EVENT_TYPE_EMPTY, null, 8, null);
    L21:
        k r15 = r21.b();
        if (r15 != null) goto L26;
        ILogDepend.Companion.e(r13, "getLocationInfoForDraft location locationType empty");
        return new com.obric.event.task.nlp.api.d(null, "location locationType empty", ErrorCode.EventTask.LOCATION_LOCATION_TYPE_EMPTY, null, 8, null);
    L26:
        if (AOPlatformTools.INSTANCE.platformStrategy().checkSensitiveOp(r1, SensitiveOperation.ACCESS_FINE_LOCATION).isAllowed() == true) goto L29;
        ILogDepend.Companion.e(r13, "getLocationInfoForDraft location no permission");
        return new com.obric.event.task.nlp.api.d(null, "location no permission", ErrorCode.EventTask.LOCATION_NOT_PERMISSION, null, 8, null);
    L29:
        r2 = new z.f();
        int r16 = a.f24340a[r15.ordinal()];
        String r17 = null;
        if (r16 == 1) goto L54;
        if (r16 == 2) goto L51;
        com.obric.event.task.nlp.api.a r18 = r21.c();
        if (r18 == null) goto L37;
        com.obric.event.task.nlp.api.b r19 = r18.a();
        if (r19 == null) goto L37;
        r17 = r19.b();
    L37:
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin");
        if (r20 != null) goto L40;
    L43:
        if (r9 == false) goto L46;
        ILogDepend.Companion.e(r13, "getLocationInfoForDraft location selected name empty");
        return new com.obric.event.task.nlp.api.d(null, "location selected name empty", ErrorCode.EventTask.LOCATION_CUSTOM_NAME_EMPTY, null, 8, null);
    L46:
        r4.f24341a = r2;
        r4.f24342b = r2;
        r4.f24345e = 3;
        Object r24 = a(r17, r14, r4);
        if (r24 != r6) goto L49;
        return r6;
    L49:
        r0 = r2;
        r8 = r24;
        goto L50
    L40:
        if (r20.length() == 0) goto L43;
        r9 = false;
        goto L43
    L51:
        g r25 = (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin");
        m r26 = (m) ZeusTransformUtils.preCheckCast(new d(r2, r14, null), m.class, "com.obric.aiagent.plugin");
        r4.f24341a = r2;
        r4.f24345e = 2;
        if (i.a(r25, r26, r4) != r6) goto L57;
        return r6;
    L57:
        r11 = r2;
        goto L58
    L54:
        g r27 = (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin");
        m r28 = (m) ZeusTransformUtils.preCheckCast(new c(r2, r14, null), m.class, "com.obric.aiagent.plugin");
        r4.f24341a = r2;
        r4.f24345e = 1;
        if (i.a(r27, r28, r4) != r6) goto L57;
        return r6;
    L7:
        r4 = new C0557b(this, r3);
        goto L8
    }

    private final com.obric.event.task.nlp.api.d<List<LocationCondition>> a(k r19, j r20, MemoryResponse<Location> r21) {
        String r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_location_name_home, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_name_home"));
        d.h.b.o.c(r0, "getString(...)");
        if (r19 != k.f32926b) goto L5;
        r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_location_name_company, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_name_company"));
        d.h.b.o.c(r0, "getString(...)");
        boolean r2 = true;
    L6:
        String r9 = r0;
        if (r21.isSuccess() == false) goto L25;
        Location r1 = (Location) ZeusTransformUtils.preCheckCast(r21.getData(), Location.class, "com.obric.aiagent.plugin");
        if (r2 == true) goto L11;
        String r3 = "home";
    L12:
        String r10 = r3;
        if (r20 != j.f32921a) goto L15;
        String r4 = "inside";
    L16:
        String r5 = r4;
        double r6 = 0.0d;
        if (r1 == null) goto L19;
        double r7 = r1.getLongitude();
    L20:
        if (r1 == null) goto L23;
        r6 = r1.getLatitude();
    L23:
        return new com.obric.event.task.nlp.api.d(p.a(new LocationCondition("place_alias", r5, Double.valueOf(r7), Double.valueOf(r6), Integer.valueOf(ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION), r9, r10)), null, 0, null, 10, null);
    L19:
        r7 = 0.0d;
        goto L20
    L15:
        r4 = "outside";
        goto L16
    L11:
        r3 = "company";
        goto L12
    L25:
        return new com.obric.event.task.nlp.api.d(null, "get " + r9 + " location failed, errorCode: " + r21.getCode() + ", errorMessage: " + r21.getMessage(), ErrorCode.EventTask.LOCATION_PLACE_ALIAS_INFO_EMPTY, null, 8, null);
    L5:
        r2 = false;
        goto L6
    }

    private final Object a(String r16, j r17, d.c.d<? super com.obric.event.task.nlp.api.d<List<LocationCondition>>> r18) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, e.class) == false) goto L7;
        e r4 = (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.aiagent.plugin");
        if ((r4.f24359d & Integer.MIN_VALUE) == 0) goto L7;
        r4.f24359d -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f24357b;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f24359d;
        boolean r7 = true;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        j r0 = (j) ZeusTransformUtils.preCheckCast(r4.f24356a, j.class, "com.obric.aiagent.plugin");
        o.a(r3);
    L18:
        com.obric.autoaction.app.launcherpage.condition.location.n r1 = (com.obric.autoaction.app.launcherpage.condition.location.n) ZeusTransformUtils.preCheckCast(((com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin")).a(), com.obric.autoaction.app.launcherpage.condition.location.n.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L21;
        List<com.obric.autoaction.app.launcherpage.condition.location.o> r8 = r1.a();
    L22:
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L25;
    L28:
        if (r7 == false) goto L31;
        ILogDepend.Companion.e(TAG, "getSearchLocationInfo location info empty");
        return new com.obric.event.task.nlp.api.d(null, "location info empty", ErrorCode.EventTask.LOCATION_CUSTOM_INFO_EMPTY, null, 8, null);
    L31:
        ArrayList r10 = new ArrayList();
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L33:
        if (r11.hasNext() == false) goto L40;
        com.obric.autoaction.app.launcherpage.condition.location.o r12 = (com.obric.autoaction.app.launcherpage.condition.location.o) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.autoaction.app.launcherpage.condition.location.o.class, "com.obric.aiagent.plugin");
        if (r0 != j.f32921a) goto L37;
        String r13 = "inside";
    L38:
        r10.add(new LocationCondition("geo_radius", r13, d.c.b.a.b.a(r12.c().a()), d.c.b.a.b.a(r12.c().b()), d.c.b.a.b.a(ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION), r12.a(), null));
        goto L33
    L37:
        r13 = "outside";
        goto L38
    L40:
        return new com.obric.event.task.nlp.api.d(r10, null, 0, null, 10, null);
    L25:
        if (r9.isEmpty() == true) goto L28;
        r7 = false;
        goto L28
    L21:
        r8 = null;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r3);
        ILogDepend.Companion.i(TAG, "getSearchLocationInfo name = " + r16 + ", eventType = " + r17);
        ConditionLocationRepo r14 = new ConditionLocationRepo();
        Context r15 = (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r4.f24356a = r17;
        r4.f24359d = 1;
        r3 = r14.a(r15, r16, r4);
        if (r3 != r5) goto L17;
        return r5;
    L17:
        r0 = r17;
    L7:
        r4 = new e(this, r2);
        goto L8
    }
}
