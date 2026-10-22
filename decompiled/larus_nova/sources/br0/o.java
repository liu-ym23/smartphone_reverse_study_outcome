package br0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o extends lr0.a {
    public o(MiniGameContext r100) {
        Intrinsics.checkNotNullParameter(r100, "miniGameContext");
        super(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener
    public final Bundle onEvent(Bundle r100) {
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r101 = AnchorMiniGameDataContext.a.a();
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r102 = r101.getOpenLynxPanelInGame();
        if (r102 == null) goto L10;
        r102.setValue(Boolean.TRUE);
        return null;
    L10:
        return null;
    L9:
        return null;
    }
}
