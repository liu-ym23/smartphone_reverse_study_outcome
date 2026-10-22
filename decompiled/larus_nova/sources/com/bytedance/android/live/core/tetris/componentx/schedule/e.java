package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.v;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e extends ComponentBatchBaseLoadState {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f65591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap<Integer, m> f65592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f70.b f65593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f65594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> f65595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap<f70.b, LinkedHashMap<Integer, m>> f65596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f65597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q f65598i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ComponentSchedulingManager.a f65599j;

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final b b() {
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final void c(BatchTogetherConditionManager.BatchLoadConditionType r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final void d() {
        StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> r100 = this.f65595f;
        ComponentBatchBaseLoadState.a.C1077a r101 = new ComponentBatchBaseLoadState.a.C1077a();
        StateMachine.a r102 = StateMachine.f66079c;
        r100.d(r101, null);
    }

    public final Integer e() {
        if (this.f65592c.isEmpty() == false) goto L7;
        return null;
    L7:
        return (Integer) CollectionsKt.last(this.f65592c.keySet());
    }

    public final void f() {
        String r100 = this.f65591b;
        StringBuilder r101 = new StringBuilder("localCurrentLoadingLayerType = ");
        r101.append(this.f65593d);
        r101.append(" getLoadingBatchKey = ");
        r101.append(this.f65594e);
        r101.append(" size is ");
        LinkedHashMap<f70.b, LinkedHashMap<Integer, m>> r102 = this.f65596g;
        int r103 = 0;
        if (r102 == null) goto L11;
        LinkedHashMap<Integer, m> r104 = r102.get(this.f65593d);
        if (r104 == null) goto L11;
        m r105 = r104.get(Integer.valueOf(this.f65594e));
        if (r105 == null) goto L11;
        LayerDescriptorList r106 = r105.f65623b;
        if (r106 == null) goto L11;
        int r107 = r106.size();
    L12:
        r101.append(r107);
        ALogger.i(r100, r101.toString());
        if (v.a() == false) goto L26;
        LinkedHashMap<f70.b, LinkedHashMap<Integer, m>> r108 = this.f65596g;
        if (r108 == null) goto L26;
        LinkedHashMap<Integer, m> r109 = r108.get(this.f65593d);
        if (r109 == null) goto L26;
        m r110 = r109.get(Integer.valueOf(this.f65594e));
        if (r110 == null) goto L26;
        LayerDescriptorList r111 = r110.f65623b;
        if (r111 == null) goto L26;
        Iterator<j70.h<? extends h70.b>> r112 = r111.iterator();
    L24:
        if (r112.hasNext() == false) goto L26;
        ALogger.i(this.f65591b, r112.next().toString());
    L26:
        ComponentSchedulingManager.a r113 = this.f65599j;
        f70.b r114 = this.f65593d;
        int r115 = this.f65594e;
        LinkedHashMap<f70.b, LinkedHashMap<Integer, m>> r116 = this.f65596g;
        if (r116 == null) goto L31;
        LinkedHashMap<Integer, m> r117 = r116.get(r114);
        if (r117 == null) goto L31;
        m r118 = r117.get(Integer.valueOf(this.f65594e));
    L32:
        r113.a(r114, r115, r118);
        LinkedHashMap<Integer, m> r119 = this.f65596g.get(this.f65593d);
        if (r119 == null) goto L35;
        m r120 = r119.get(Integer.valueOf(this.f65594e));
    L36:
        if (r120 == null) goto L38;
        this.f65592c.put(Integer.valueOf(this.f65594e), r120);
    L38:
        LinkedHashMap<Integer, m> r121 = this.f65596g.get(this.f65593d);
        if (r121 == null) goto L41;
        int r122 = r121.size();
    L43:
        if (r122 != this.f65592c.size()) goto L51;
        f70.b r123 = this.f65593d;
        if (r123 == null) goto L51;
        if (Intrinsics.areEqual(r123, (f70.b) CollectionsKt.last(this.f65596g.keySet())) == false) goto L50;
        StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> r124 = this.f65595f;
        ComponentBatchBaseLoadState.a.b r125 = new ComponentBatchBaseLoadState.a.b();
        StateMachine.a r126 = StateMachine.f66079c;
        r124.d(r125, null);
        return;
    L50:
        int r127 = d80.a.f467382a;
        this.f65593d = (f70.b) d80.a.a(this.f65596g, r123);
        this.f65592c.clear();
        this.f65594e = 0;
    L51:
        Integer r128 = e();
        if (r128 == null) goto L60;
        int r129 = r128.intValue();
        LinkedHashMap<Integer, m> r130 = this.f65596g.get(this.f65593d);
        if (r130 == null) goto L57;
        r103 = r130.size();
    L57:
        if (r129 >= r103) goto L59;
        r103 = r128.intValue() + 1;
        goto L60
    L59:
        r103 = Integer.MAX_VALUE;
    L60:
        this.f65594e = r103;
        StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> r131 = this.f65595f;
        ComponentBatchBaseLoadState.a.c r132 = new ComponentBatchBaseLoadState.a.c();
        StateMachine.a r133 = StateMachine.f66079c;
        r131.d(r132, null);
        return;
    L41:
        r122 = 0;
        goto L43
    L35:
        r120 = null;
    L31:
        r118 = null;
    L11:
        r107 = 0;
        goto L12
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final void a() {
        super.a();
        this.f65592c.clear();
        this.f65594e = 0;
    }

    public final void g(Map<Integer, Set<BatchTogetherConditionManager.BatchLoadConditionType>> r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionsMap");
        StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> r101 = this.f65595f;
        ComponentBatchBaseLoadState.a.c r102 = new ComponentBatchBaseLoadState.a.c();
        StateMachine.a r103 = StateMachine.f66079c;
        r101.d(r102, null);
    }

    public e(LinkedHashMap r100, j r101, q r102, p r103) {
        Intrinsics.checkNotNullParameter(r100, "componentSchedulingList");
        Intrinsics.checkNotNullParameter(r103, "componentBatchLoadListener");
        this.f65596g = r100;
        this.f65597h = r101;
        this.f65598i = r102;
        this.f65599j = r103;
        this.f65591b = "ComponentLoadState";
        this.f65592c = new LinkedHashMap();
        if (r100 == null) goto L7;
        Set r104 = r100.keySet();
        if (r104 == null) goto L7;
        f70.b r105 = (f70.b) CollectionsKt.first(r104);
    L8:
        this.f65593d = r105;
        StateMachine.a r106 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b>, Unit> r107 = new ComponentBatchInOrderLoadState$stateMachine$1(this);
        r106.getClass();
        this.f65595f = StateMachine.a.a(r107);
        return;
    L7:
        r105 = null;
        goto L8
    }
}
