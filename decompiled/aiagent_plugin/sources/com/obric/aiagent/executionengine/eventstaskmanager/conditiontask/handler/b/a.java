package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.b;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g;
import com.obric.eventkit.task.model.BluetoothCondition;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.AwarenessConditionConfig;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.obric.memorydata.sdk.awareness.model.BluetoothDeviceInfo;
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

/* JADX INFO: compiled from: PersistentBluetoothConditionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e<BluetoothCondition> {
    private static final String TAG = "PersistentBluetoothConditionHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0348a f17037a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PersistentBluetoothConditionHandler.kt */
    public static final class C0348a {
        public /* synthetic */ C0348a(h r1) {
            this();
        }

        private C0348a() {
        }
    }

    /* JADX INFO: compiled from: PersistentBluetoothConditionHandler.kt */
    @f(b = "PersistentBluetoothConditionHandler.kt", c = {37}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.bluetooth.PersistentBluetoothConditionHandler$isConditionMetInternal$bluetoothData$1")
    static final class b extends l implements m<am, d.c.d<? super MemoryResponse<List<? extends BluetoothDeviceInfo>>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17038a;

        b(d.c.d<? super b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super MemoryResponse<List<BluetoothDeviceInfo>>> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super MemoryResponse<List<? extends BluetoothDeviceInfo>>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17038a;
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
            this.f17038a = 1;
            r5 = r6.a("connect_bluetooth_devices", r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: PersistentBluetoothConditionHandler.kt */
    @f(b = "PersistentBluetoothConditionHandler.kt", c = {75}, d = "registerTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.bluetooth.PersistentBluetoothConditionHandler")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f17041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f17042d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f17043e;
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

    /* JADX INFO: compiled from: PersistentBluetoothConditionHandler.kt */
    @f(b = "PersistentBluetoothConditionHandler.kt", c = {79}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.bluetooth.PersistentBluetoothConditionHandler$registerTask$2$1")
    static final class d extends l implements d.h.a.b<d.c.d<? super MemoryResponse<Void>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AwarenessConditionConfig f17046c;

        d(String r3, AwarenessConditionConfig r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17045b = r3;
            this.f17046c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super MemoryResponse<Void>> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f17045b, this.f17046c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super MemoryResponse<Void>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17044a;
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
            String r2 = this.f17045b;
            AwarenessConditionConfig r3 = this.f17046c;
            d.c.d<? super MemoryResponse<Void>> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17044a = 1;
            r7 = r8.b(r2, EventNames.BLUETOOTH_DEVICE_CONNECTED, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: PersistentBluetoothConditionHandler.kt */
    @f(b = "PersistentBluetoothConditionHandler.kt", c = {97}, d = "unregisterTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.bluetooth.PersistentBluetoothConditionHandler")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f17049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f17050d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f17051e;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17050d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17049c = r3;
            this.f17051e |= Integer.MIN_VALUE;
            return this.f17050d.b(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f17037a = new C0348a(null);
    }

    public a() {
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a a(ConditionTask r3, Condition r4) {
        return a(r3, (BluetoothCondition) ZeusTransformUtils.preCheckCast((Condition) ZeusTransformUtils.wrapperContextForParams(r4, Condition.class, "com.obric.aiagent.plugin"), BluetoothCondition.class, "com.obric.aiagent.plugin"));
    }

    public com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a a(ConditionTask r2, BluetoothCondition r3) {
        d.h.b.o.e(r2, "task");
        d.h.b.o.e(r3, "condition");
        if (a(r3) == false) goto L6;
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f17016b;
    L6:
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f;
    }

    private final boolean a(BluetoothCondition r7) {
        MemoryResponse r6 = (MemoryResponse) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new b(null), m.class, "com.obric.aiagent.plugin"), 1, null), MemoryResponse.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "isConditionMetInternal bluetoothData = " + r6.getData() + ", conditionName = " + r7.getName());
        if (r6.isSuccess() == true) goto L6;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "isConditionMetInternal bluetoothData error code = " + r6.getCode() + ", msg = " + r6.getMessage());
        return false;
    L6:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r6.getData(), List.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L9;
        return false;
    L9:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L12;
    L14:
        Iterator r10 = r9.iterator();
    L16:
        if (r10.hasNext() == false) goto L24;
        BluetoothDeviceInfo r0 = (BluetoothDeviceInfo) ZeusTransformUtils.preCheckCast(r10.next(), BluetoothDeviceInfo.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r0.getName(), r7.getName()) == true) goto L20;
    L22:
        boolean r1 = false;
    L23:
        if (r1 == false) goto L16;
        return true;
    L20:
        if (d.h.b.o.a(r0.getAddress(), r7.getAddress()) == false) goto L22;
        r1 = true;
    L24:
        return false;
    L12:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L14;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [T, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c] */
    /* JADX WARN: Type inference failed for: r2v14, types: [T, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x019b -> B:47:0x01a0). Please report as a decompilation issue!!! */
    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object a(ConditionTask r23, List<BluetoothCondition> r24, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c> r25) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L7;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin");
        if ((r3.i & Integer.MIN_VALUE) == 0) goto L7;
        r3.i -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.g;
        Object r5 = d.c.a.b.a();
        int r6 = r3.i;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        int r1 = r3.f;
        z.f r7 = (z.f) ZeusTransformUtils.preCheckCast(r3.f17043e, z.f.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r10 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r3.f17042d, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        Iterator r11 = (Iterator) ZeusTransformUtils.preCheckCast(r3.f17041c, Iterator.class, "com.obric.aiagent.plugin");
        z.f r12 = (z.f) ZeusTransformUtils.preCheckCast(r3.f17040b, z.f.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r3.f17039a, String.class, "com.obric.aiagent.plugin");
        o.a(r4);
        int r18 = r1;
        Iterator r8 = r11;
    L47:
        r7.f38504a = r10.a((com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin"));
        r7 = r12;
        String r9 = r13;
        int r14 = r18;
    L26:
        if (r8.hasNext() == false) goto L49;
        Object r15 = r8.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L30;
        p.c();
    L30:
        BluetoothCondition r17 = (BluetoothCondition) ZeusTransformUtils.preCheckCast(r15, BluetoothCondition.class, "com.obric.aiagent.plugin");
        String r19 = g.f17272a.a("bluetooth", r9, r14);
        String r110 = r17.getAddress();
        CharSequence r111 = (CharSequence) ZeusTransformUtils.preCheckCast(r110, CharSequence.class, "com.obric.aiagent.plugin");
        if (r111 != null) goto L33;
    L36:
        boolean r112 = true;
    L37:
        if (r112 == true) goto L39;
        AwarenessConditionConfig r113 = AwarenessConditionConfig.Companion.a("device_address", r110);
    L43:
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r114 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r7.f38504a, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        d.h.a.b r115 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r19, r113, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r3.f17039a = r9;
        r3.f17040b = r7;
        r3.f17041c = r8;
        r3.f17042d = r114;
        r3.f17043e = r7;
        r3.f = r16;
        r3.i = 1;
        r18 = r16;
        Object r116 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.f.a(TAG, "registerPersistentContextEvent " + r19 + " bluetooth_device_connected", 0, r115, r3, 4, null);
        if (r116 != r5) goto L46;
        return r5;
    L46:
        r13 = r9;
        r12 = r7;
        r4 = r116;
        r10 = r114;
        goto L47
    L39:
        AwarenessConditionConfig.a r117 = AwarenessConditionConfig.Companion;
        String r118 = r17.getName();
        if (r118 != null) goto L42;
        r118 = "";
    L42:
        r113 = r117.a(SensitiveType.DEVICE_NAME, r118);
        goto L43
    L33:
        if (d.o.o.d(r111) == true) goto L36;
        r112 = false;
        goto L37
    L49:
        return r7.f38504a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r4);
        r9 = r23.getId();
        if (r9 != null) goto L17;
        r9 = "";
    L17:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "registerTask taskId = " + r9);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L20;
        boolean r20 = true;
    L21:
        if (r20 == true) goto L23;
        r7 = new z.f();
        r7.f38504a = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.f17052a, 0, 1, null);
        r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        r14 = 0;
        goto L26
    L23:
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.f17052a, "register bluetooth failed: taskId is empty", 0, 2, null);
    L20:
        r20 = false;
    L7:
        r3 = new c(this, r2);
        goto L8
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object b(ConditionTask r7, List<BluetoothCondition> r8, d.c.d<? super x> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r11, e.class, "com.obric.aiagent.plugin");
        if ((r0.f17051e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17051e -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f17049c;
        Object r12 = d.c.a.b.a();
        int r2 = r0.f17051e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Iterator r13 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f17048b, Iterator.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r0.f17047a, String.class, "com.obric.aiagent.plugin");
        o.a(r6);
    L26:
        if (r13.hasNext() == false) goto L31;
        String r15 = g.f17272a.a("bluetooth", r14, ((al) ZeusTransformUtils.preCheckCast(r13, al.class, "com.obric.aiagent.plugin")).a());
        r0.f17047a = r14;
        r0.f17048b = r13;
        r0.f17051e = 1;
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
