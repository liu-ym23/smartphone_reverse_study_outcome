package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/LiveOpenFeatureChooseListFragment$b;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/LiveOpenFeatureChooseListFragment$b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LiveOpenFeatureChooseListFragment$processGroupListVisibleScroll$1 extends Lambda implements Function1<LiveOpenFeatureChooseListFragment.b, Unit> {
    final /* synthetic */ LiveOpenFeatureChooseListFragment this$0;

    public LiveOpenFeatureChooseListFragment$processGroupListVisibleScroll$1(LiveOpenFeatureChooseListFragment r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LiveOpenFeatureChooseListFragment.b r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        LiveOpenFeatureChooseListFragment.b r101 = this.this$0.f61475l;
        r101.f61479a = r100.f61479a;
        r101.f61480b = r100.f61480b;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LiveOpenFeatureChooseListFragment.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
