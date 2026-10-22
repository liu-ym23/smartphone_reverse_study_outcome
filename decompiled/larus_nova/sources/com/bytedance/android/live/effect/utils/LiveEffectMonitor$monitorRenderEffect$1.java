package com.bytedance.android.live.effect.utils;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.effect.base.RenderTriggerType;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"sendRenderEffectLog", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class LiveEffectMonitor$monitorRenderEffect$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $addList;
    final /* synthetic */ String $curList;
    final /* synthetic */ String $endType;
    final /* synthetic */ String $extraLog;
    final /* synthetic */ String $reason;
    final /* synthetic */ String $removeList;
    final /* synthetic */ RenderTriggerType $renderTriggerType;
    final /* synthetic */ int $result;
    final /* synthetic */ String $trace;

    public LiveEffectMonitor$monitorRenderEffect$1(int r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, RenderTriggerType r108) {
        this.$result = r100;
        this.$reason = r101;
        this.$trace = r102;
        this.$curList = r103;
        this.$addList = r104;
        this.$removeList = r105;
        this.$endType = r106;
        this.$extraLog = r107;
        this.$renderTriggerType = r108;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        NewBroadcastMonitor.a r100 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_RENDER_EFFECT, null, null, 14);
        r100.l(this.$result);
        r100.i("reason", this.$reason);
        r100.i("trace", this.$trace);
        r100.i("curList", this.$curList);
        r100.i("addList", this.$addList);
        r100.i("removeList", this.$removeList);
        r100.i("endType", this.$endType);
        r100.i("extraLog", this.$extraLog);
        RenderTriggerType r101 = this.$renderTriggerType;
        if (r101 == null) goto L5;
        r100.i("renderTriggerType", r101.name());
    L5:
        r100.a().report();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
