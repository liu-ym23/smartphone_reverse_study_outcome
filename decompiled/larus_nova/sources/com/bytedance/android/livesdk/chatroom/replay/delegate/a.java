package com.bytedance.android.livesdk.chatroom.replay.delegate;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.livesdk.chatroom.replay.ui.ReplayInteractionDelegateUIState;
import com.bytedance.android.livesdk.chatroom.vs_base.base.d;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.bytedance.android.live.core.tetris.layer.core.delegate.c<uq1.b> {
    public a() {
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.c
    public final Class a(LayerIndex r100, h70.b r101) {
        Intrinsics.checkNotNullParameter(r100, "layerIndex");
        Intrinsics.checkNotNullParameter((uq1.b) r101, "layerContext");
        d r102 = ReplayRoomFragmentScopeUtil.f117917a;
        ReplayInteractionDelegateUIState r103 = (ReplayInteractionDelegateUIState) ReplayRoomFragmentScopeUtil.a(ReplayInteractionDelegateUIState.class);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "layerIndex");
        if (r103.m(4) == false) goto L6;
        return (Class) ((Map) r103.f110236d.getValue()).get(r100);
    L6:
        return (Class) ((Map) r103.f110235c.getValue()).get(r100);
    }
}
