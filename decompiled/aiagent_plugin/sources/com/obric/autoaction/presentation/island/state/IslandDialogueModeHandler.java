package com.obric.autoaction.presentation.island.state;

import com.obric.autogui.common.api.presentation.WidgetState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IslandDialogueModeHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IslandDialogueModeHandler extends a {
    public IslandDialogueModeHandler() {
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onStateWillChange(WidgetState r2, WidgetState r3) {
        o.e(r3, "state");
        super.onStateWillChange(r2, r3);
        if (ZeusTransformUtils.instanceOf(r3, WidgetState.Clarify.class) == false) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, WidgetState.CallUser.class) == true) goto L9;
        com.obric.autoaction.presentation.island.a.a().b(8, false);
        return;
    }
}
