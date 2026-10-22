package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.o2;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k extends o2<f10.e, InteractEntranceCell, l> {
    public k() {
        this(null);
    }

    public k(Object r100) {
        Function2<InteractEntranceCell, l, f10.e> r101 = PreviewOpenFeatureBehaviorProviderKt.f61428a;
        Intrinsics.checkNotNullParameter(r101, "behaviorFactory");
        super(r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.o2
    public final f10.e b(o2.b r100, o2.a r101, f10.e r102) {
        l r103 = (l) r101;
        f10.e r104 = r102;
        Intrinsics.checkNotNullParameter((InteractEntranceCell) r100, "data");
        Intrinsics.checkNotNullParameter(r104, "behavior");
        return r104;
    }
}
