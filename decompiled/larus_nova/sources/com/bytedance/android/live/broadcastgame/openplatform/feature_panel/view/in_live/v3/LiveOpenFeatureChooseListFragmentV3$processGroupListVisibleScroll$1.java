package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/v3/LiveOpenFeatureChooseListFragmentV3$b;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/v3/LiveOpenFeatureChooseListFragmentV3$b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LiveOpenFeatureChooseListFragmentV3$processGroupListVisibleScroll$1 extends Lambda implements Function1<LiveOpenFeatureChooseListFragmentV3.b, Unit> {
    final /* synthetic */ LiveOpenFeatureChooseListFragmentV3 this$0;

    public LiveOpenFeatureChooseListFragmentV3$processGroupListVisibleScroll$1(LiveOpenFeatureChooseListFragmentV3 r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LiveOpenFeatureChooseListFragmentV3.b r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        LiveOpenFeatureChooseListFragmentV3.b r101 = this.this$0.B;
        r101.f61544a = r100.f61544a;
        r101.f61545b = r100.f61545b;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LiveOpenFeatureChooseListFragmentV3.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
