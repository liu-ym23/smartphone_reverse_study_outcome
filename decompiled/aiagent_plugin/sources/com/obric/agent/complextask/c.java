package com.obric.agent.complextask;

import android.os.SystemClock;
import com.obric.agent.trace.q;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.IFlowNetworkIDL;
import com.obric.aiagent.assistant.idl.bean.DMConstData;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.ttnet.ITTNet;
import com.obric.assistant.dm.api.statemachine.core.ComplexTaskState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskId;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.core.TaskType;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.aa;
import d.n;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bs;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: compiled from: ComplexTaskTracer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final String TAG = "ComplexTaskTracer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14330a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a<TaskId, List<com.obric.agent.complextask.b>> f14331b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a<TaskId, com.obric.agent.complextask.a> f14332c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ca f14333d;

    /* JADX INFO: compiled from: ComplexTaskTracer.kt */
    private static final class a<K, V> extends LinkedHashMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f14334a;

        public a(int r4) {
            super(16, 0.75f, true);
            this.f14334a = r4;
        }

        public Collection<Object> a() {
            return super.values();
        }

        public int b() {
            return super.size();
        }

        public Set<Map.Entry<Object, Object>> c() {
            return super.entrySet();
        }

        public Set<Object> d() {
            return super.keySet();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<K, V>> entrySet() {
            return (Set<Map.Entry<K, V>>) c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<K> keySet() {
            return (Set<K>) d();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final int size() {
            return b();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Collection<V> values() {
            return (Collection<V>) a();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
            if (size() <= this.f14334a) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskTracer.kt */
    @d.c.b.a.f(b = "ComplexTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.complextask.ComplexTaskTracer$notifyStopComplexTask$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14336b;

        b(String r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14336b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f14336b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f14335a != 0) goto L19;
            o.a(r5);
            String r4 = this.f14336b;
            if (r4 == null) goto L17;
            TaskId r6 = TaskId.Companion.a(r4, TaskType.COMPLEX);
            Long r0 = null;
            if (c.a().get(r6) != 0) goto L9;
            ((Map) ZeusTransformUtils.preCheckCast(c.a(), Map.class, "com.obric.aiagent.plugin")).put(r6, new com.obric.agent.complextask.a(null, d.c.b.a.b.a(SystemClock.elapsedRealtime()), 1, null));
            goto L17
        L9:
            com.obric.agent.complextask.a r7 = (com.obric.agent.complextask.a) ZeusTransformUtils.preCheckCast(c.a().get(r6), com.obric.agent.complextask.a.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L12;
            r0 = r7.b();
        L12:
            if (r0 != null) goto L17;
            com.obric.agent.complextask.a r8 = (com.obric.agent.complextask.a) ZeusTransformUtils.preCheckCast(c.a().get(r6), com.obric.agent.complextask.a.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L17;
            r8.a(d.c.b.a.b.a(SystemClock.elapsedRealtime()));
        L17:
            return x.f38692a;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.complextask.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ComplexTaskTracer.kt */
    @d.c.b.a.f(b = "ComplexTaskTracer.kt", c = {111}, d = "invokeSuspend", e = "com.obric.agent.complextask.ComplexTaskTracer$onComplexTaskStateChanged$1")
    static final class C0287c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TaskInfo f14338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ State f14339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ State f14340d;

        C0287c(TaskInfo r3, State r4, State r5, d.c.d<? super C0287c> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14338b = r3;
            this.f14339c = r4;
            this.f14340d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0287c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0287c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0287c(this.f14338b, this.f14339c, this.f14340d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14337a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r10);
        L69:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r10);
            TaskId r11 = this.f14338b.getTaskId();
            State r2 = this.f14339c;
            String r3 = null;
            if (r2 == null) goto L20;
            List r5 = (List) ZeusTransformUtils.preCheckCast(c.b().get(r11), List.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L13;
            com.obric.agent.complextask.b r6 = (com.obric.agent.complextask.b) ZeusTransformUtils.preCheckCast(p.n(r5), com.obric.agent.complextask.b.class, "com.obric.aiagent.plugin");
        L14:
            if (r6 == null) goto L16;
            ComplexTaskState r7 = r6.a();
        L18:
            if (d.h.b.o.a(r7, r2) == false) goto L20;
            r6.a(d.c.b.a.b.a(SystemClock.elapsedRealtime()));
            goto L20
        L16:
            r7 = null;
            goto L18
        L13:
            r6 = null;
        L20:
            Map<String, Object> r4 = c.f14330a.a(this.f14340d);
            if (ZeusTransformUtils.instanceOf(this.f14340d, ComplexTaskState.Terminated.class) == false) goto L27;
            com.obric.agent.complextask.a r8 = (com.obric.agent.complextask.a) ZeusTransformUtils.preCheckCast(c.a().get(r11), com.obric.agent.complextask.a.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L27;
            Long r9 = r8.b();
            if (r9 == null) goto L27;
            r4.put("terminate_cost", d.c.b.a.b.a(SystemClock.elapsedRealtime() - ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).longValue()));
        L27:
            IFlowNetworkIDL r12 = com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class));
            if (r12 == null) goto L30;
            r4.put("network_status", d.c.b.a.b.a(r12.getCurrentNetworkStatus()));
        L30:
            ITTNet r13 = (ITTNet) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITTNet.class), ITTNet.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L33;
            int r14 = r13.getEffectiveConnectionType();
        L34:
            r4.put("network_status_v2", d.c.b.a.b.a(r14));
            com.obric.agent.complextask.b r15 = new com.obric.agent.complextask.b((ComplexTaskState) ZeusTransformUtils.preCheckCast(this.f14340d, ComplexTaskState.class, "com.obric.aiagent.plugin"), r4, SystemClock.elapsedRealtime());
            Map r16 = (Map) ZeusTransformUtils.preCheckCast(c.b(), Map.class, "com.obric.aiagent.plugin");
            Object r17 = r16.get(r11);
            if (r17 != null) goto L37;
            r17 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            r16.put(r11, r17);
        L37:
            ((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin")).add(r15);
            if (this.f14340d.isCompletedOrCanceled() == false) goto L69;
            State r18 = this.f14339c;
            if (r18 == null) goto L69;
            if (r18.isIdle() == true) goto L69;
            Map<String, String> r19 = ((ComplexTaskState) ZeusTransformUtils.preCheckCast(this.f14340d, ComplexTaskState.class, "com.obric.aiagent.plugin")).getExtra();
            if (r19 == null) goto L49;
            String r20 = (String) ZeusTransformUtils.preCheckCast(r19.get("client_meta"), String.class, "com.obric.aiagent.plugin");
            if (r20 == null) goto L49;
            r3 = new JSONObject(r20).optString("o_is_user_remind");
        L49:
            if (d.h.b.o.a(r3, "1") == false) goto L52;
            c.b().remove(r11);
            return x.f38692a;
        L52:
            List r21 = (List) ZeusTransformUtils.preCheckCast(c.b().get(r11), List.class, "com.obric.aiagent.plugin");
            if (r21 == null) goto L57;
            com.obric.agent.complextask.b r22 = (com.obric.agent.complextask.b) ZeusTransformUtils.preCheckCast(p.n(r21), com.obric.agent.complextask.b.class, "com.obric.aiagent.plugin");
            if (r22 == null) goto L57;
            r22.a(d.c.b.a.b.a(SystemClock.elapsedRealtime()));
        L57:
            List r23 = (List) ZeusTransformUtils.preCheckCast(c.b().remove(r11), List.class, "com.obric.aiagent.plugin");
            Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(r23, Collection.class, "com.obric.aiagent.plugin");
            if (r24 != null) goto L60;
        L63:
            boolean r25 = true;
        L64:
            if (r25 == true) goto L69;
            JSONObject r26 = c.a(c.f14330a, this.f14338b, r23);
            c.a().remove(r11);
            c r110 = c.f14330a;
            d.c.d<? super x> r27 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14337a = 1;
            if (r110.a(r26, r27) != r0) goto L69;
            return r0;
        L60:
            if (r24.isEmpty() == true) goto L63;
            r25 = false;
            goto L64
        L33:
            r14 = -404;
            goto L34
        }
    }

    /* JADX INFO: compiled from: ComplexTaskTracer.kt */
    @d.c.b.a.f(b = "ComplexTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.complextask.ComplexTaskTracer$onReceiveMessage$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IMMessage f14342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TaskId f14343c;

        d(IMMessage r3, TaskId r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14342b = r3;
            this.f14343c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f14342b, this.f14343c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f14341a != 0) goto L17;
            o.a(r5);
            Map<String, String> r6 = this.f14342b.getExt();
            if (r6 == null) goto L15;
            String r7 = (String) ZeusTransformUtils.preCheckCast(r6.get("inner_log_id"), String.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L15;
            TaskId r4 = this.f14343c;
            if (c.a().get(r4) != 0) goto L11;
            ((Map) ZeusTransformUtils.preCheckCast(c.a(), Map.class, "com.obric.aiagent.plugin")).put(r4, new com.obric.agent.complextask.a(r7, null, 2, null));
            goto L15
        L11:
            com.obric.agent.complextask.a r8 = (com.obric.agent.complextask.a) ZeusTransformUtils.preCheckCast(c.a().get(r4), com.obric.agent.complextask.a.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L15;
            r8.a(r7);
        L15:
            return x.f38692a;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ComplexTaskTracer.kt */
    @d.c.b.a.f(b = "ComplexTaskTracer.kt", c = {271}, d = "invokeSuspend", e = "com.obric.agent.complextask.ComplexTaskTracer$onTimeout$2")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14345b;

        e(String r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14345b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f14345b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14344a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            q.f15713a.a(this.f14345b, false);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14344a = 1;
            if (ax.a(1000, r7) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskTracer.kt */
    @d.c.b.a.f(b = "ComplexTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.complextask.ComplexTaskTracer$reportChangeTransitionFailed$1")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14348c;

        f(String r3, String r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14347b = r3;
            this.f14348c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f14347b, this.f14348c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f14346a != 0) goto L10;
            o.a(r3);
            JSONObject r4 = new JSONObject();
            r4.put("from_state", this.f14347b);
            r4.put("to_state", this.f14348c);
            ISecureLogDepend.Companion.i(c.TAG, "ComplexTask report change transition failed: " + r4);
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L8;
            r2.reportToFlow("o_complex_task_transition", r4);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ComplexTaskTracer.kt */
    @d.c.b.a.f(b = "ComplexTaskTracer.kt", c = {257}, d = "invokeSuspend", e = "com.obric.agent.complextask.ComplexTaskTracer$startTimeout$1")
    static final class g extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f14350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14351c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TaskInfo f14352d;

        g(long r3, String r5, TaskInfo r6, d.c.d<? super g> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14350b = r3;
            this.f14351c = r5;
            this.f14352d = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f14350b, this.f14351c, this.f14352d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14349a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L11:
            c.a(c.f14330a, this.f14351c, this.f14352d);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            long r3 = (long) (this.f14350b * 1.5d);
            d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14349a = 1;
            if (ax.a(r3, r9) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskTracer.kt */
    @d.c.b.a.f(b = "ComplexTaskTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.complextask.ComplexTaskTracer$uploadComplexTaskInfo$2")
    static final class h extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f14354b;

        h(JSONObject r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14354b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f14354b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f14353a != 0) goto L10;
            o.a(r3);
            ISecureLogDepend.Companion.i(c.TAG, "ComplexTask report data: " + this.f14354b);
            IAppLog r4 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L7;
            r4.reportToFlow("o_complex_task", this.f14354b);
            return x.f38692a;
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private c() {
    }

    public static final /* synthetic */ a a() {
        return f14332c;
    }

    public static final /* synthetic */ JSONObject a(c r2, TaskInfo r3, List r4) {
        return r2.a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(c r0, String r1, TaskInfo r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ a b() {
        return f14331b;
    }

    static {
        f14330a = new c();
        f14331b = new a(10);
        f14332c = new a(10);
    }

    public final void a(TaskInfo r7, State r8, State r9) {
        d.h.b.o.e(r7, "taskInfo");
        d.h.b.o.e(r9, "newState");
        if (ZeusTransformUtils.instanceOf(r9, ComplexTaskState.class) == true) goto L5;
        return;
    L5:
        i.a(com.obric.agent.e.f14435a.b(), null, null, (m) ZeusTransformUtils.preCheckCast(new C0287c(r7, r8, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final JSONObject a(TaskInfo r10, List<com.obric.agent.complextask.b> r11) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        JSONObject r12 = new JSONObject();
        IMMessage r1 = r10.getMessage();
        int r2 = 0;
        if (r1 == null) goto L9;
        Map<String, String> r3 = r1.getExt();
        if (r3 == null) goto L9;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get("o_task_state"), String.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        boolean r5 = d.h.b.o.a(r4, "addition_complex_task");
    L10:
        r12.put("complex_task_is_addition", r5);
        Long r6 = ((com.obric.agent.complextask.b) ZeusTransformUtils.preCheckCast(p.m(r9), com.obric.agent.complextask.b.class, "com.obric.aiagent.plugin")).d();
        if (r6 == null) goto L13;
        long r7 = r6.longValue();
    L14:
        r12.put("app_intent_cost", r7 - ((com.obric.agent.complextask.b) ZeusTransformUtils.preCheckCast(p.k(r9), com.obric.agent.complextask.b.class, "com.obric.aiagent.plugin")).c());
        com.obric.agent.complextask.a r8 = (com.obric.agent.complextask.a) ZeusTransformUtils.preCheckCast(f14332c.get(r10.getTaskId()), com.obric.agent.complextask.a.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L19;
        String r13 = r8.a();
        if (r13 == null) goto L19;
        r12.put("app_intent_logId", r13);
    L19:
        Iterator r14 = r9.iterator();
    L21:
        if (r14.hasNext() == false) goto L29;
        com.obric.agent.complextask.b r15 = (com.obric.agent.complextask.b) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.agent.complextask.b.class, "com.obric.aiagent.plugin");
        String r16 = r15.a().getStateName();
        Long r17 = r15.d();
        if (r17 == null) goto L25;
        r12.put(r16 + "_cost", ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.aiagent.plugin")).longValue() - r15.c());
    L25:
        Iterator<Map.Entry<String, Object>> r18 = r15.b().entrySet().iterator();
    L27:
        if (r18.hasNext() == false) goto L21;
        Map.Entry r19 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.getKey(), String.class, "com.obric.aiagent.plugin");
        r12.put(r16 + '_' + r20, r19.getValue());
        goto L27
    L29:
        IMMessage r21 = r10.getMessage();
        if (r21 == null) goto L36;
        Map<String, String> r22 = r21.getExt();
        if (r22 == null) goto L36;
        String r23 = (String) ZeusTransformUtils.preCheckCast(r22.get("o_event_task"), String.class, "com.obric.aiagent.plugin");
        if (r23 == null) goto L36;
        com.obric.eventkit.task.model.a r24 = (com.obric.eventkit.task.model.a) ZeusTransformUtils.preCheckCast(com.obric.eventkit.eventstaskmanager.b.a().fromJson(r23, com.obric.eventkit.task.model.a.class), com.obric.eventkit.task.model.a.class, "com.obric.aiagent.plugin");
    L37:
        if (r24 == null) goto L39;
        r2 = r24.a();
    L39:
        r12.put("event_task_type", r2);
        return r12;
    L36:
        r24 = null;
        goto L37
    L13:
        r7 = SystemClock.elapsedRealtime();
    L9:
        r5 = false;
        goto L10
    }

    public final Object a(JSONObject r4, d.c.d<? super x> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new h(r4, null), m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Map<String, Object> a(State r5) {
        d.h.b.o.e(r5, "newState");
        Map<String, Object> r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ComplexTaskState.Idle.class) == false) goto L5;
    L36:
        return r4;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, ComplexTaskState.Thinking.class) == false) goto L22;
        List r6 = (List) ZeusTransformUtils.preCheckCast(f14331b.get(((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r5, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getTaskId()), List.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L9;
        com.obric.agent.complextask.b r7 = (com.obric.agent.complextask.b) ZeusTransformUtils.preCheckCast(p.n(r6), com.obric.agent.complextask.b.class, "com.obric.aiagent.plugin");
    L10:
        boolean r0 = false;
        if (r7 == null) goto L17;
        ComplexTaskState r1 = r7.a();
        if (r1 == null) goto L17;
        if (r1.getState() != DMConstData.a.f16243a.ordinal()) goto L17;
        r0 = true;
    L17:
        if (r0 == false) goto L36;
        long r2 = SystemClock.elapsedRealtime() - r7.c();
        if (r2 <= 0) goto L36;
        r4.put("complex_task_first_token_cost", Long.valueOf(r2));
        goto L36
    L9:
        r7 = null;
        goto L10
    L22:
        if (ZeusTransformUtils.instanceOf(r5, ComplexTaskState.Terminated.class) == false) goto L30;
        String r3 = (String) ZeusTransformUtils.preCheckCast(((ComplexTaskState.Terminated) ZeusTransformUtils.preCheckCast(r5, ComplexTaskState.Terminated.class, "com.obric.aiagent.plugin")).getExtra().get("stop_reason"), String.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L26;
        r4.put("stop_reason", r3);
    L26:
        String r8 = (String) ZeusTransformUtils.preCheckCast(((ComplexTaskState.Terminated) ZeusTransformUtils.preCheckCast(r5, ComplexTaskState.Terminated.class, "com.obric.aiagent.plugin")).getExtra().get("running_action"), String.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L36;
        r4.put("running_action", r8);
        goto L36
    L30:
        if (ZeusTransformUtils.instanceOf(r5, ComplexTaskState.Clarify.class) == true) goto L36;
        if (ZeusTransformUtils.instanceOf(r5, ComplexTaskState.ClarifyAck.class) == true) goto L36;
        if (ZeusTransformUtils.instanceOf(r5, ComplexTaskState.ThinkingCompleted.class) == true) goto L36;
        ZeusTransformUtils.instanceOf(r5, ComplexTaskState.TTS.class);
        goto L36
    }

    public final void a(String r7, String r8) {
        d.h.b.o.e(r7, "fromState");
        d.h.b.o.e(r8, "toState");
        i.a(com.obric.agent.e.f14435a.b(), null, null, (m) ZeusTransformUtils.preCheckCast(new f(r7, r8, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void b(String r2, String r3) {
        d.h.b.o.e(r2, "className");
        d.h.b.o.e(r3, DBDefinition.SEGMENT_INFO);
        JSONObject r1 = new JSONObject();
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        r1.put("obric_oauto_class", r2);     // Catch: Throwable -> L5
        n.f(r1.put("obric_oauto_info", r3));     // Catch: Throwable -> L5
    L7:
        IAppLog r4 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        r4.reportToFlow("obric_oauto_task_tech_monitor", r1);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r5 = n.f38560a;
        n.f(o.a(th));
        goto L7
    }

    public final void a(TaskId r7, IMMessage r8) {
        d.h.b.o.e(r7, DBDefinition.TASK_ID);
        d.h.b.o.e(r8, "message");
        i.a(com.obric.agent.e.f14435a.b(), null, null, (m) ZeusTransformUtils.preCheckCast(new d(r8, r7, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void c(String r7, String r8) {
        d.h.b.o.e(r8, "reason");
        i.a(com.obric.agent.e.f14435a.b(), null, null, (m) ZeusTransformUtils.preCheckCast(new b(r7, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(String r12, long r13, TaskInfo r15) {
        d.h.b.o.e(r12, "questionId");
        ca r11 = f14333d;
        if (r11 == null) goto L5;
        ca.a.a(r11, null, 1, null);
    L5:
        f14333d = i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new g(r13, r12, r15, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final void a(String r7, TaskInfo r8) {
        IFlowAppIntentIDL r6 = r.a(aa.b(IFlowAppIntentIDL.class));
        if (r6 == null) goto L12;
        if (r8 == null) goto L9;
        IMMessage r0 = r8.getMessage();
        if (r0 == null) goto L9;
        String r1 = r0.getMessageId();
        if (r1 == null) goto L9;
    L10:
        r6.stopComplexTask(r1);
    L9:
        r1 = r7;
    L12:
        if (r8 == null) goto L16;
        IDialogStateManager r2 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L16;
        r2.cancelTask(r8);
    L16:
        i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new e(r7, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }
}
