package com.bytedance.android.live.soloktv.viewmodel;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/soloktv/viewmodel/g;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/soloktv/viewmodel/g;)Lcom/bytedance/android/live/soloktv/viewmodel/g;", "com/bytedance/android/live/soloktv/viewmodel/SoloKtvEditViewModel$init$1$onPositionChanged$1$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class SoloKtvEditViewModel$init$1$onPositionChanged$$inlined$let$lambda$1 extends Lambda implements Function1<g, g> {
    final /* synthetic */ long $musicDuration$inlined;
    final /* synthetic */ rjc.c $position$inlined;
    final /* synthetic */ float $progress;
    final /* synthetic */ SoloKtvEditViewModel.b this$0;

    public SoloKtvEditViewModel$init$1$onPositionChanged$$inlined$let$lambda$1(float r100, SoloKtvEditViewModel.b r101, long r102, rjc.c r103) {
        this.$progress = r100;
        this.this$0 = r101;
        this.$musicDuration$inlined = r102;
        this.$position$inlined = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final g invoke2(g r110) {
        Intrinsics.checkNotNullParameter(r110, "$receiver");
        return g.a(r110, 0, 0, 0, this.$progress, (long) (this.$position$inlined.f538236c * 1000), null, null, null, TTVideoEngineInterface.PLAYER_OPTION_SET_NETSPEED_LEVEL);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ g invoke(g r100) {
        return invoke2(r100);
    }
}
