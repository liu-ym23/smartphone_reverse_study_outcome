package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import com.bytedance.android.live.broadcastgame.api.model.p;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/p;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/broadcastgame/api/model/p;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class OpenFeatureListHandler$loadOpenFeatureListFromLocal$1 extends Lambda implements Function1<p, Unit> {
    public static final OpenFeatureListHandler$loadOpenFeatureListFromLocal$1 INSTANCE = null;

    static {
        INSTANCE = new OpenFeatureListHandler$loadOpenFeatureListFromLocal$1();
    }

    public OpenFeatureListHandler$loadOpenFeatureListFromLocal$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(p r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(p r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
