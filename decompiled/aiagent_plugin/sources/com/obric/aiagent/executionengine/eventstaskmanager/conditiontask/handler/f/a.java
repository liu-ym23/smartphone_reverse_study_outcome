package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.f;

import android.util.EventsUtils;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.WifiCondition;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.AwarenessConditionConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.al;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.z;
import d.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: PersistentWifiConditionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e<WifiCondition> {
    private static final String TAG = "PersistentWifiConditionHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0353a f17257a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PersistentWifiConditionHandler.kt */
    public static final class C0353a {
        public /* synthetic */ C0353a(h r1) {
            this();
        }

        private C0353a() {
        }
    }

    /* JADX INFO: compiled from: PersistentWifiConditionHandler.kt */
    @f(b = "PersistentWifiConditionHandler.kt", c = {45}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.wifi.PersistentWifiConditionHandler$getCurrentWifiSSID$wifiData$1")
    static final class b extends l implements m<am, d.c.d<? super MemoryResponse<String>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17258a;

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
            int r1 = this.f17258a;
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
            this.f17258a = 1;
            r5 = r6.a("current_wifi_ssid", r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: PersistentWifiConditionHandler.kt */
    @f(b = "PersistentWifiConditionHandler.kt", c = {EventsUtils.FEAT_TYPE_PROC_FREQUENT_RESTART}, d = "registerTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.wifi.PersistentWifiConditionHandler")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f17261c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f17262d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f17263e;
        int f;
        /* synthetic */ Object g;
        final /* synthetic */ a h;
        int i;

        c(a r3, d.c.d<? super c> r4) {
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

    /* JADX INFO: compiled from: PersistentWifiConditionHandler.kt */
    @f(b = "PersistentWifiConditionHandler.kt", c = {92}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.wifi.PersistentWifiConditionHandler$registerTask$2$1")
    static final class d extends l implements d.h.a.b<d.c.d<? super MemoryResponse<Void>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AwarenessConditionConfig f17266c;

        d(String r3, AwarenessConditionConfig r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17265b = r3;
            this.f17266c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super MemoryResponse<Void>> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f17265b, this.f17266c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super MemoryResponse<Void>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17264a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d r8 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.f17179a;
            String r2 = this.f17265b;
            AwarenessConditionConfig r3 = this.f17266c;
            d.c.d<? super MemoryResponse<Void>> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17264a = 1;
            r7 = r8.a(r2, "device_wifi", r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: PersistentWifiConditionHandler.kt */
    @f(b = "PersistentWifiConditionHandler.kt", c = {110}, d = "unregisterTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.wifi.PersistentWifiConditionHandler")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f17269c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f17270d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f17271e;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17270d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17269c = r3;
            this.f17271e |= Integer.MIN_VALUE;
            return this.f17270d.b(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f17257a = new C0353a(null);
    }

    public a() {
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a a(ConditionTask r3, Condition r4) {
        return a(r3, (WifiCondition) ZeusTransformUtils.preCheckCast((Condition) ZeusTransformUtils.wrapperContextForParams(r4, Condition.class, "com.obric.aiagent.plugin"), WifiCondition.class, "com.obric.aiagent.plugin"));
    }

    public com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a a(ConditionTask r2, WifiCondition r3) {
        d.h.b.o.e(r2, "task");
        d.h.b.o.e(r3, "condition");
        if (a(r3) == false) goto L6;
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f17016b;
    L6:
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f17019e;
    }

    private final String a() {
        MemoryResponse r6 = (MemoryResponse) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new b(null), m.class, "com.obric.aiagent.plugin"), 1, null), MemoryResponse.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getCurrentWifiSSID wifiData = " + ((String) ZeusTransformUtils.preCheckCast(r6.getData(), String.class, "com.obric.aiagent.plugin")));
        if (r6.isSuccess() == true) goto L6;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "getCurrentWifiSSID wifiData error code = " + r6.getCode() + ", msg = " + r6.getMessage());
        return null;
    L6:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getData(), String.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L12;
        String r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r8 != null) goto L11;
        return null;
    L11:
        return d.o.o.c(r8, (CharSequence) ZeusTransformUtils.preCheckCast("\"", CharSequence.class, "com.obric.aiagent.plugin"));
    L12:
        return null;
    }

    private final boolean a(WifiCondition r4) {
        String r3 = a();
        if (r3 != null) goto L6;
        return false;
    L6:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "isConditionMetInternal curWifiSSID = " + r3 + ", conditionSsid = " + r4.getSsid());
        return d.h.b.o.a(r3, r4.getSsid());
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [T, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c] */
    /* JADX WARN: Type inference failed for: r2v14, types: [T, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0191 -> B:44:0x0196). Please report as a decompilation issue!!! */
    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object a(ConditionTask r22, List<WifiCondition> r23, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c> r24) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L7;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin");
        if ((r3.i & Integer.MIN_VALUE) == 0) goto L7;
        r3.i -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.g;
        Object r5 = d.c.a.b.a();
        int r6 = r3.i;
        boolean r8 = false;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        int r1 = r3.f;
        z.f r7 = (z.f) ZeusTransformUtils.preCheckCast(r3.f17263e, z.f.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r10 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r3.f17262d, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        Iterator r11 = (Iterator) ZeusTransformUtils.preCheckCast(r3.f17261c, Iterator.class, "com.obric.aiagent.plugin");
        z.f r12 = (z.f) ZeusTransformUtils.preCheckCast(r3.f17260b, z.f.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r3.f17259a, String.class, "com.obric.aiagent.plugin");
        o.a(r4);
        int r9 = r1;
        Iterator r14 = r11;
    L44:
        r7.f38504a = r10.a((com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin"));
        int r15 = r9;
        r7 = r12;
        String r16 = r13;
        r8 = false;
    L26:
        if (r14.hasNext() == false) goto L46;
        Object r17 = r14.next();
        int r18 = r15 + 1;
        if (r15 >= 0) goto L30;
        p.c();
    L30:
        WifiCondition r19 = (WifiCondition) ZeusTransformUtils.preCheckCast(r17, WifiCondition.class, "com.obric.aiagent.plugin");
        String r110 = g.f17272a.a("wifi", r16, r15);
        String r111 = r19.getBssid();
        if (r111 != null) goto L34;
        r111 = "";
    L34:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L36;
        boolean r112 = true;
    L37:
        if (r112 == false) goto L39;
        AwarenessConditionConfig r113 = AwarenessConditionConfig.Companion.a("wifi_bssid", r111);
    L40:
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r114 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r7.f38504a, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        d.h.a.b r20 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r110, r113, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r3.f17259a = r16;
        r3.f17260b = r7;
        r3.f17261c = r14;
        r3.f17262d = r114;
        r3.f17263e = r7;
        r3.f = r18;
        r3.i = 1;
        r9 = r18;
        Object r115 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.f.a(TAG, "registerPersistentFeatureEvent " + r110 + " device_wifi bssid=" + r111, 0, r20, r3, 4, null);
        if (r115 != r5) goto L43;
        return r5;
    L43:
        r13 = r16;
        r12 = r7;
        r4 = r115;
        r10 = r114;
        goto L44
    L39:
        r113 = AwarenessConditionConfig.Companion.a(3);
        goto L40
    L36:
        r112 = r8;
        goto L37
    L46:
        return r7.f38504a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r4);
        r16 = r22.getId();
        if (r16 != null) goto L17;
        r16 = "";
    L17:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "registerTask taskId = " + r16);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L20;
        boolean r21 = true;
    L21:
        if (r21 == true) goto L23;
        r7 = new z.f();
        r7.f38504a = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.f17052a, 0, 1, null);
        r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        r15 = 0;
        goto L26
    L23:
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.f17052a, "register wifi failed: taskId is empty", 0, 2, null);
    L20:
        r21 = false;
    L7:
        r3 = new c(this, r2);
        goto L8
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object b(ConditionTask r7, List<WifiCondition> r8, d.c.d<? super x> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r11, e.class, "com.obric.aiagent.plugin");
        if ((r0.f17271e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17271e -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f17269c;
        Object r12 = d.c.a.b.a();
        int r2 = r0.f17271e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Iterator r13 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f17268b, Iterator.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r0.f17267a, String.class, "com.obric.aiagent.plugin");
        o.a(r6);
    L26:
        if (r13.hasNext() == false) goto L31;
        String r15 = g.f17272a.a("wifi", r14, ((al) ZeusTransformUtils.preCheckCast(r13, al.class, "com.obric.aiagent.plugin")).a());
        r0.f17267a = r14;
        r0.f17268b = r13;
        r0.f17271e = 1;
        if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.f.a(TAG, r15, r0) != r12) goto L26;
        return r12;
    L31:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r6);
        String r16 = r7.getId();
        if (r16 != null) goto L17;
        r16 = "";
    L17:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "unregisterTask taskId = " + r16);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L20;
        boolean r17 = true;
    L21:
        if (r17 == true) goto L23;
        r13 = ((Iterable) ZeusTransformUtils.preCheckCast(p.a((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        r14 = r16;
        goto L26
    L23:
        return x.f38692a;
    L20:
        r17 = false;
    L7:
        r0 = new e(this, r11);
        goto L8
    }
}
