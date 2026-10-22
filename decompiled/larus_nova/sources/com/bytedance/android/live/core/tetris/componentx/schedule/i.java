package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentBatchPriorityMappingConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i extends ComponentBatchBaseLoadState {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f65605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap<Integer, m> f65606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f65607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> f65608e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f65609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BatchTogetherConditionManager f65610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashMap<Integer, m> f65611h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q f65612i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ComponentSchedulingManager.a f65613j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f65614k;

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final b b() {
        if (this.f65610g != null) goto L6;
        this.f65610g = new BatchTogetherConditionManager(this.f65609f, this.f65611h);
    L6:
        return this.f65610g;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final void d() {
        StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> r100 = this.f65608e;
        ComponentBatchBaseLoadState.a.C1077a r101 = new ComponentBatchBaseLoadState.a.C1077a();
        StateMachine.a r102 = StateMachine.f66079c;
        r100.d(r101, null);
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final void a() {
        super.a();
        this.f65606c.clear();
        this.f65607d = 0;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final void c(BatchTogetherConditionManager.BatchLoadConditionType r100) {
        if (r100 == null) goto L22;
        f r101 = this.f65614k;
        if (r101 != null) goto L6;
    L18:
        b r102 = b();
        if (r102 == null) goto L25;
        r102.b(1, r100);
        return;
    L25:
        return;
    L6:
        if (r101.b() != true) goto L18;
        if (r100 != BatchTogetherConditionManager.BatchLoadConditionType.END_ROOM_ENTER) goto L18;
        if (LiveInfraSettingKeys.LIVE_SUBBATCH_LOAD_FIX.getValue().booleanValue() == false) goto L18;
        b r103 = b();
        if (r103 == null) goto L23;
        ComponentBatchPriorityMappingConfig r104 = LiveInfraSettingKeys.LIVE_COMPONENT_DYNAMIC_BATCH_CONFIG.getValue().getPriorityMapping();
        if (r104 == null) goto L16;
        int r105 = r104.getP0_end();
    L17:
        r103.b(r105 + 1, r100);
        return;
    L16:
        r105 = 0;
        goto L17
    L23:
        return;
    }

    public final void e(Map<Integer, Set<BatchTogetherConditionManager.BatchLoadConditionType>> r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionsMap");
        b r101 = b();
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> r102 = this.f65608e;
        ComponentBatchBaseLoadState.a.c r103 = new ComponentBatchBaseLoadState.a.c();
        StateMachine.a r104 = StateMachine.f66079c;
        r102.d(r103, null);
    }

    public i(LinkedHashMap r100, q r101, o r102, f r103) {
        Intrinsics.checkNotNullParameter(r100, "componentSchedulingList");
        Intrinsics.checkNotNullParameter(r102, "componentBatchLoadListener");
        this.f65611h = r100;
        this.f65612i = r101;
        this.f65613j = r102;
        this.f65614k = r103;
        this.f65605b = "ComponentBatchTogetherLoadState";
        this.f65606c = new LinkedHashMap();
        StateMachine.a r104 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b>, Unit> r105 = new ComponentBatchTogetherLoadState$stateMachine$1(this);
        r104.getClass();
        this.f65608e = StateMachine.a.a(r105);
        this.f65609f = new h(this);
    }
}
