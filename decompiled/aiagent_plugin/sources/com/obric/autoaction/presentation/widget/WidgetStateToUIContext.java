package com.obric.autoaction.presentation.widget;

import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import kotlinx.coroutines.b.x;

/* JADX INFO: compiled from: WidgetStateToUIContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WidgetStateToUIContext extends AutoAgentWidgetStateDefaultListener {
    public WidgetStateToUIContext() {
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onStateWillChange(WidgetState r9, WidgetState r10) {
        o.e(r10, "state");
        super.onStateWillChange(r9, r10);
        x<GlobalUIContext> r8 = AutoActionUIContext.INSTANCE.getState();
    L3:
        GlobalUIContext r11 = r8.c();
        if (r8.a(r11, GlobalUIContext.copy$default((GlobalUIContext) ZeusTransformUtils.preCheckCast(r11, GlobalUIContext.class, "com.obric.aiagent.plugin"), null, null, null, r10, 7, null)) == false) goto L3;
    }
}
