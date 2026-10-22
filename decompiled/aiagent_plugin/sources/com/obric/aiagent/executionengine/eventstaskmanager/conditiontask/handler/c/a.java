package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c;

import android.util.EventsUtils;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.h;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.LocationCondition;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.AwarenessConditionConfig;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.obric.memorydata.sdk.awareness.model.GeoFenceInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ai;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.z;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: PersistentLocationConditionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e<LocationCondition> {
    private static final String TAG = "PersistentLocationConditionHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0349a f17056a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PersistentLocationConditionHandler.kt */
    public static final class C0349a {
        public /* synthetic */ C0349a(d.h.b.h r1) {
            this();
        }

        private C0349a() {
        }
    }

    /* JADX INFO: compiled from: PersistentLocationConditionHandler.kt */
    @d.c.b.a.f(b = "PersistentLocationConditionHandler.kt", c = {208}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.location.PersistentLocationConditionHandler$getCurrentLocationType$resp$1")
    static final class b extends l implements m<am, d.c.d<? super MemoryResponse<String>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17057a;

        b(d.c.d<? super b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super MemoryResponse<String>> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super MemoryResponse<String>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17057a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d r6 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.f17179a;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17057a = 1;
            r5 = r6.a("current_location_type", r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: PersistentLocationConditionHandler.kt */
    @d.c.b.a.f(b = "PersistentLocationConditionHandler.kt", c = {193}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.location.PersistentLocationConditionHandler$isInsideFence$response$1")
    static final class c extends l implements m<am, d.c.d<? super MemoryResponse<ArrayList<GeoFenceInfo>>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17058a;

        c(d.c.d<? super c> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super MemoryResponse<ArrayList<GeoFenceInfo>>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super MemoryResponse<ArrayList<GeoFenceInfo>>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17058a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d r6 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.f17179a;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17058a = 1;
            r5 = r6.a("current_geofences", r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: PersistentLocationConditionHandler.kt */
    @d.c.b.a.f(b = "PersistentLocationConditionHandler.kt", c = {77, EventsUtils.FEAT_TYPE_NFC_EVENT}, d = "registerGeoFenceCondition", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.location.PersistentLocationConditionHandler")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f17061c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f17062d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f17063e;
        int f;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17063e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17062d = r3;
            this.f |= Integer.MIN_VALUE;
            return a.a(this.f17063e, null, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: PersistentLocationConditionHandler.kt */
    @d.c.b.a.f(b = "PersistentLocationConditionHandler.kt", c = {82}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.location.PersistentLocationConditionHandler$registerGeoFenceCondition$addFenceTrace$1")
    static final class e extends l implements d.h.a.b<d.c.d<? super MemoryResponse<Void>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Double f17066c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Double f17067d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f17068e;

        e(String r3, Double r4, Double r5, int r6, d.c.d<? super e> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17065b = r3;
            this.f17066c = r4;
            this.f17067d = r5;
            this.f17068e = r6;
            super(1, r8);
        }

        public final Object a(d.c.d<? super MemoryResponse<Void>> r3) {
            return ((e) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r9) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f17065b, this.f17066c, this.f17067d, this.f17068e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super MemoryResponse<Void>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17064a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d r2 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.f17179a;
            String r12 = this.f17065b;
            double r3 = this.f17066c.doubleValue();
            double r5 = this.f17067d.doubleValue();
            int r7 = this.f17068e;
            d.c.d<? super MemoryResponse<Void>> r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17064a = 1;
            r11 = r2.a(r12, r3, r5, r7, r8);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: PersistentLocationConditionHandler.kt */
    @d.c.b.a.f(b = "PersistentLocationConditionHandler.kt", c = {95}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.location.PersistentLocationConditionHandler$registerGeoFenceCondition$subscribeTrace$1")
    static final class f extends l implements d.h.a.b<d.c.d<? super MemoryResponse<Void>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17071c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f17072d;

        f(String r3, String r4, String r5, d.c.d<? super f> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17070b = r3;
            this.f17071c = r4;
            this.f17072d = r5;
            super(1, r7);
        }

        public final Object a(d.c.d<? super MemoryResponse<Void>> r3) {
            return ((f) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f17070b, this.f17071c, this.f17072d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super MemoryResponse<Void>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17069a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d r9 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.f17179a;
            String r2 = this.f17070b;
            String r3 = this.f17071c;
            AwarenessConditionConfig r4 = AwarenessConditionConfig.Companion.a("fence_id", this.f17072d);
            d.c.d<? super MemoryResponse<Void>> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17069a = 1;
            r8 = r9.b(r2, r3, r4, r5);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: PersistentLocationConditionHandler.kt */
    @d.c.b.a.f(b = "PersistentLocationConditionHandler.kt", c = {ApWakeEvent.ACCELERATING_START}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.location.PersistentLocationConditionHandler$registerPlaceAliasCondition$2")
    static final class g extends l implements d.h.a.b<d.c.d<? super MemoryResponse<Void>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17075c;

        g(String r3, String r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17074b = r3;
            this.f17075c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super MemoryResponse<Void>> r3) {
            return ((g) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f17074b, this.f17075c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super MemoryResponse<Void>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17073a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d r9 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.f17179a;
            String r2 = this.f17074b;
            String r3 = this.f17075c;
            AwarenessConditionConfig r4 = AwarenessConditionConfig.Companion.a();
            d.c.d<? super MemoryResponse<Void>> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17073a = 1;
            r8 = r9.b(r2, r3, r4, r5);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: PersistentLocationConditionHandler.kt */
    @d.c.b.a.f(b = "PersistentLocationConditionHandler.kt", c = {47, 49}, d = "registerTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.location.PersistentLocationConditionHandler")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f17078c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f17079d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f17080e;
        Object f;
        /* synthetic */ Object g;
        final /* synthetic */ a h;
        int i;

        h(a r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return this.h.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: PersistentLocationConditionHandler.kt */
    @d.c.b.a.f(b = "PersistentLocationConditionHandler.kt", c = {232, 238}, d = "unregisterTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.location.PersistentLocationConditionHandler")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f17083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f17084d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f17085e;
        int f;
        /* synthetic */ Object g;
        final /* synthetic */ a h;
        int i;

        i(a r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return this.h.b(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f17056a = new C0349a(null);
    }

    public a() {
    }

    public static final /* synthetic */ Object a(a r2, String r3, int r4, LocationCondition r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a a(ConditionTask r3, Condition r4) {
        return a(r3, (LocationCondition) ZeusTransformUtils.preCheckCast((Condition) ZeusTransformUtils.wrapperContextForParams(r4, Condition.class, "com.obric.aiagent.plugin"), LocationCondition.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [T, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c] */
    /* JADX WARN: Type inference failed for: r10v12, types: [T, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c] */
    /* JADX WARN: Type inference failed for: r10v17, types: [T, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c] */
    /* JADX WARN: Type inference failed for: r10v8, types: [T, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x01c0 -> B:44:0x01c3). Please report as a decompilation issue!!! */
    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object a(ConditionTask r10, List<LocationCondition> r11, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, h.class) == false) goto L7;
        h r1 = (h) ZeusTransformUtils.preCheckCast(r14, h.class, "com.obric.aiagent.plugin");
        if ((r1.i & Integer.MIN_VALUE) == 0) goto L7;
        r1.i -= Integer.MIN_VALUE;
    L8:
        Object r15 = r1.g;
        Object r3 = d.c.a.b.a();
        int r4 = r1.i;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        z.f r9 = (z.f) ZeusTransformUtils.preCheckCast(r1.f, z.f.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r16 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r1.f17080e, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        Iterator r17 = (Iterator) ZeusTransformUtils.preCheckCast(r1.f17079d, Iterator.class, "com.obric.aiagent.plugin");
        z.f r5 = (z.f) ZeusTransformUtils.preCheckCast(r1.f17078c, z.f.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r1.f17077b, String.class, "com.obric.aiagent.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(r1.f17076a, a.class, "com.obric.aiagent.plugin");
        o.a(r15);
    L44:
        r9.f38504a = r16.a((com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin"));
    L37:
        a r18 = r0;
        r9 = r5;
    L29:
        if (r17.hasNext() == false) goto L46;
        ai r19 = (ai) ZeusTransformUtils.preCheckCast(r17.next(), ai.class, "com.obric.aiagent.plugin");
        int r2 = r19.c();
        LocationCondition r110 = (LocationCondition) ZeusTransformUtils.preCheckCast(r19.d(), LocationCondition.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r110.getMode(), "geo_radius") == true) goto L32;
        if (d.h.b.o.a(r110.getMode(), "place_alias") == false) goto L29;
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r9.f38504a, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        r1.f17076a = r18;
        r1.f17077b = r7;
        r1.f17078c = r9;
        r1.f17079d = r17;
        r1.f17080e = r6;
        r1.f = r9;
        r1.i = 2;
        r15 = r18.b(r7, r2, r110, r1);
        if (r15 != r3) goto L43;
        return r3;
    L43:
        r0 = r18;
        r16 = r6;
        r5 = r9;
        goto L44
    L32:
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r8 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r9.f38504a, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        r1.f17076a = r18;
        r1.f17077b = r7;
        r1.f17078c = r9;
        r1.f17079d = r17;
        r1.f17080e = r8;
        r1.f = r9;
        r1.i = 1;
        Object r111 = r18.a(r7, r2, r110, r1);
        if (r111 != r3) goto L35;
        return r3;
    L35:
        r0 = r18;
        r5 = r9;
        r9.f38504a = r8.a((com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r111, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin"));
        goto L37
    L46:
        return r9.f38504a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        z.f r20 = (z.f) ZeusTransformUtils.preCheckCast(r1.f, z.f.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r112 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r1.f17080e, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        r17 = (Iterator) ZeusTransformUtils.preCheckCast(r1.f17079d, Iterator.class, "com.obric.aiagent.plugin");
        r5 = (z.f) ZeusTransformUtils.preCheckCast(r1.f17078c, z.f.class, "com.obric.aiagent.plugin");
        r7 = (String) ZeusTransformUtils.preCheckCast(r1.f17077b, String.class, "com.obric.aiagent.plugin");
        r0 = (a) ZeusTransformUtils.preCheckCast(r1.f17076a, a.class, "com.obric.aiagent.plugin");
        o.a(r15);
        r20.f38504a = r112.a((com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin"));
        goto L37
    L16:
        o.a(r15);
        h.f17121a.b();
        String r113 = r10.getId();
        if (r113 != null) goto L19;
        r113 = "";
    L19:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "registerTask taskId=" + r113);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r113, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L22;
        boolean r114 = true;
    L24:
        if (r114 == true) goto L26;
        z.f r115 = new z.f();
        r115.f38504a = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.f17052a, 0, 1, null);
        r17 = p.r((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        r7 = r113;
        r18 = this;
        r9 = r115;
        goto L29
    L26:
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.f17052a, "register location failed: taskId is empty", 0, 2, null);
    L22:
        r114 = false;
    L7:
        r1 = new h(this, r14);
        goto L8
    }

    private final Object a(String r20, int r21, LocationCondition r22, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c> r23) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L7;
        d r2 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        if ((r2.f & Integer.MIN_VALUE) == 0) goto L7;
        r2.f -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f17062d;
        Object r9 = d.c.a.b.a();
        int r4 = r2.f;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r3 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r2.f17059a, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        o.a(r1);
    L37:
        return r3.a((com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin"));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r2.f17061c, String.class, "com.obric.aiagent.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r2.f17060b, String.class, "com.obric.aiagent.plugin");
        LocationCondition r7 = (LocationCondition) ZeusTransformUtils.preCheckCast(r2.f17059a, LocationCondition.class, "com.obric.aiagent.plugin");
        o.a(r1);
        LocationCondition r13 = r7;
    L28:
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r8 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r13.getType(), "inside") == false) goto L31;
        String r10 = EventNames.GEOFENCE_ENTERED;
    L32:
        d.h.a.b r12 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new f(r5, r10, r6, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r2.f17059a = r8;
        r2.f17060b = null;
        r2.f17061c = null;
        r2.f = 2;
        Object r11 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.f.a(TAG, "registerPersistentContextEvent " + r5 + ' ' + r10 + ' ' + r6, 20000, r12, r2);
        if (r11 != r9) goto L35;
        return r9;
    L35:
        r3 = r8;
        r1 = r11;
        goto L37
    L31:
        r10 = EventNames.GEOFENCE_EXITED;
        goto L32
    L16:
        o.a(r1);
        Double r14 = r22.getLongitude();
        Double r15 = r22.getLatitude();
        Integer r16 = r22.getRadius();
        if (r16 == null) goto L19;
        int r17 = r16.intValue();
    L20:
        int r18 = r17;
        if (r14 == null) goto L38;
        if (r15 == null) goto L38;
        String r19 = a(r20, r21);
        String r24 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g.f17272a.a("location_geofence", r20, r21);
        d.h.a.b r110 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new e(r19, r14, r15, r18, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r13 = r22;
        r2.f17059a = r13;
        r2.f17060b = r19;
        r2.f17061c = r24;
        r2.f = 1;
        Object r25 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.f.a(TAG, "addGeoFence " + r19, 20000, r110, r2);
        if (r25 != r9) goto L27;
        return r9;
    L27:
        r6 = r19;
        r1 = r25;
        r5 = r24;
    L38:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "longitude or latitude is null");
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.f17052a, "registerGeoFence failed: longitude or latitude is null", 0, 2, null);
    L19:
        r17 = 150;
    L7:
        r2 = new d(this, r0);
        goto L8
    }

    private final Object b(String r10, int r11, LocationCondition r12, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c> r13) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        String r9 = r12.getAddrType();
        if (d.h.b.o.a(r9, "home") == false) goto L9;
        if (d.h.b.o.a(r12.getType(), "inside") == false) goto L7;
        String r14 = EventNames.ARRIVE_HOME;
    L14:
        String r15 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g.f17272a.a("location_place", r10, r11);
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.f.a(TAG, "registerPersistentContextEvent " + r15 + ' ' + r14, 0, (d.h.a.b) ZeusTransformUtils.preCheckCast(new g(r15, r14, null), d.h.a.b.class, "com.obric.aiagent.plugin"), r6, 4, null);
    L7:
        r14 = EventNames.LEAVE_HOME;
        goto L14
    L9:
        if (d.h.b.o.a(r9, "company") == true) goto L11;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "unknown addrType " + r12.getAddrType());
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.f17052a, "registerPlaceAlias failed: unknown addrType " + r12.getAddrType(), 0, 2, null);
    L11:
        if (d.h.b.o.a(r12.getType(), "inside") == false) goto L13;
        r14 = EventNames.ARRIVE_COMPANY;
        goto L14
    L13:
        r14 = EventNames.LEAVE_COMPANY;
        goto L14
    }

    public com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a a(ConditionTask r2, LocationCondition r3) {
        d.h.b.o.e(r2, "task");
        d.h.b.o.e(r3, "condition");
        if (b(r2, r3) == false) goto L6;
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f17016b;
    L6:
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f17017c;
    }

    private final boolean b(ConditionTask r7, LocationCondition r8) {
        if (d.h.b.o.a(r8.getMode(), "geo_radius") == false) goto L21;
        String r9 = c(r7, r8);
        if (r9 != null) goto L8;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "isConditionMetInternal fenceId not found, fail closed");
        return false;
    L8:
        Boolean r6 = a(r9);
        if (r6 == null) goto L19;
        boolean r10 = r6.booleanValue();
        if (d.h.b.o.a(r8.getType(), "inside") == false) goto L14;
        if (r10 == false) goto L14;
        return true;
    L14:
        if (d.h.b.o.a(r8.getType(), "outside") == false) goto L18;
        if (r10 == true) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    L21:
        if (d.h.b.o.a(r8.getMode(), "place_alias") == false) goto L40;
        String r11 = a();
        if (r11 != null) goto L26;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "isConditionMetInternal currentLocationType is null, fail closed");
        return false;
    L26:
        String r12 = r8.getAddrType();
        String r0 = "home";
        if (d.h.b.o.a(r12, "home") == true) goto L33;
        if (d.h.b.o.a(r12, "company") == false) goto L40;
        r0 = "company";
    L33:
        if (d.h.b.o.a(r8.getType(), "inside") == false) goto L36;
        return d.h.b.o.a(r11, r0);
    L36:
        if (d.h.b.o.a(r11, r0) == true) goto L39;
        return true;
    L39:
        return false;
    L40:
        return false;
    }

    private final Boolean a(String r6) {
        boolean r1 = true;
        MemoryResponse r5 = (MemoryResponse) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (m) ZeusTransformUtils.preCheckCast(new c(null), m.class, "com.obric.aiagent.plugin"), 1, null), MemoryResponse.class, "com.obric.aiagent.plugin");
        if (r5.isSuccess() == true) goto L6;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "get current_geofences failed: code=" + r5.getCode() + ", message=" + r5.getMessage());
        return null;
    L6:
        ArrayList r7 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.getData(), ArrayList.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L9;
        return null;
    L9:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L12;
    L14:
        Iterator r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L13;
        if (d.h.b.o.a(((GeoFenceInfo) ZeusTransformUtils.preCheckCast(r9.next(), GeoFenceInfo.class, "com.obric.aiagent.plugin")).getFenceId(), r6) == false) goto L16;
    L20:
        return Boolean.valueOf(r1);
    L13:
        r1 = false;
        goto L20
    L12:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L14;
        goto L13
    }

    private final String a() {
        MemoryResponse r6 = (MemoryResponse) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (m) ZeusTransformUtils.preCheckCast(new b(null), m.class, "com.obric.aiagent.plugin"), 1, null), MemoryResponse.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getCurrentLocationType code=" + r6.getCode() + " msg=" + r6.getMessage() + " data=" + ((String) ZeusTransformUtils.preCheckCast(r6.getData(), String.class, "com.obric.aiagent.plugin")));
        if (r6.isSuccess() == true) goto L6;
        return null;
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r6.getData(), String.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x016b -> B:46:0x0172). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01b4 -> B:27:0x00fc). Please report as a decompilation issue!!! */
    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object b(ConditionTask r18, List<LocationCondition> r19, d.c.d<? super x> r20) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, i.class) == false) goto L7;
        i r4 = (i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin");
        if ((r4.i & Integer.MIN_VALUE) == 0) goto L7;
        r4.i -= Integer.MIN_VALUE;
        a r5 = this;
    L8:
        Object r6 = r4.g;
        Object r7 = d.c.a.b.a();
        int r8 = r4.i;
        int r9 = 0;
        if (r8 == 0) goto L16;
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L14;
        int r2 = r4.f17085e;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r4.f17084d, String.class, "com.obric.aiagent.plugin");
        Iterator r11 = (Iterator) ZeusTransformUtils.preCheckCast(r4.f17083c, Iterator.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r4.f17082b, String.class, "com.obric.aiagent.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(r4.f17081a, a.class, "com.obric.aiagent.plugin");
        o.a(r6);
    L46:
        MemoryResponse r13 = (MemoryResponse) ZeusTransformUtils.preCheckCast(r6, MemoryResponse.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "removeGeoFence " + r10 + " code=" + r13.getCode() + " msg=" + r13.getMessage());
        r5 = r0;
        String r14 = r12;
        r9 = r2;
        Iterator r15 = r11;
    L28:
        if (r15.hasNext() == false) goto L49;
        Object r16 = r15.next();
        int r17 = r9 + 1;
        if (r9 >= 0) goto L32;
        p.c();
    L32:
        LocationCondition r21 = (LocationCondition) ZeusTransformUtils.preCheckCast(r16, LocationCondition.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r21.getMode(), "geo_radius") == false) goto L35;
        String r110 = "location_geofence";
    L36:
        String r111 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g.f17272a.a(r110, r14, r9);
        r4.f17081a = r5;
        r4.f17082b = r14;
        r4.f17083c = r15;
        r4.f17084d = r21;
        r4.f17085e = r17;
        r4.f = r9;
        r4.i = 1;
        if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.f.a(TAG, r111, r4) != r7) goto L39;
        return r7;
    L39:
        String r112 = r14;
        r0 = r5;
        int r22 = r17;
        LocationCondition r23 = r21;
        int r113 = r9;
        Iterator r24 = r15;
        int r25 = r113;
    L41:
        if (d.h.b.o.a(r23.getMode(), "geo_radius") == false) goto L47;
        String r26 = r0.a(r112, r25);
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d r27 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.f17179a;
        r4.f17081a = r0;
        r4.f17082b = r112;
        r4.f17083c = r24;
        r4.f17084d = r26;
        r4.f17085e = r22;
        r4.i = 2;
        r6 = r27.b(r26, r4);
        if (r6 != r7) goto L45;
        return r7;
    L45:
        r11 = r24;
        r12 = r112;
        int r114 = r22;
        r10 = r26;
        r2 = r114;
        goto L46
    L47:
        r15 = r24;
        r9 = r22;
        r5 = r0;
        r14 = r112;
        goto L28
    L35:
        r110 = "location_place";
        goto L36
    L49:
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r25 = r4.f;
        r22 = r4.f17085e;
        r23 = (LocationCondition) ZeusTransformUtils.preCheckCast(r4.f17084d, LocationCondition.class, "com.obric.aiagent.plugin");
        r24 = (Iterator) ZeusTransformUtils.preCheckCast(r4.f17083c, Iterator.class, "com.obric.aiagent.plugin");
        r112 = (String) ZeusTransformUtils.preCheckCast(r4.f17082b, String.class, "com.obric.aiagent.plugin");
        r0 = (a) ZeusTransformUtils.preCheckCast(r4.f17081a, a.class, "com.obric.aiagent.plugin");
        o.a(r6);
        goto L41
    L16:
        o.a(r6);
        r14 = r18.getId();
        if (r14 != null) goto L19;
        r14 = "";
    L19:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "unregisterTask " + r14);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L22;
        boolean r28 = true;
    L23:
        if (r28 == true) goto L25;
        r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        goto L28
    L25:
        return x.f38692a;
    L22:
        r28 = false;
    L7:
        r5 = this;
        r4 = new i(r5, r3);
        goto L8
    }

    private final String c(ConditionTask r4, LocationCondition r5) {
        String r0 = r4.getId();
        if (r0 != null) goto L5;
        return null;
    L5:
        int r6 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.d.c(r4.getConditions(), aa.b(LocationCondition.class)).indexOf(r5);
        if (r6 >= 0) goto L8;
        return null;
    L8:
        return a(r0, r6);
    }

    private final String a(String r1, int r2) {
        return r1 + '_' + r2;
    }
}
