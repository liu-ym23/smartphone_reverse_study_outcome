package com.obric.autoaction.app.notification;

import com.obric.autoaction.app.notification.b.c;
import com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import d.h.b.o;

/* JADX INFO: compiled from: NotifCallUserListernerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NotifCallUserListernerImpl implements IAutoActionTaskFunctionEventListener {
    @Override // com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener
    public void onFunctionStarted(String r1) {
        o.e(r1, "functionName");
    }

    public NotifCallUserListernerImpl() {
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionTaskFunctionEventListener
    public void onFunctionStopped(String r2) {
        o.e(r2, "functionName");
        if (o.a(r2, "CallUser") == false) goto L5;
    L6:
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - NeedUser functions stopped; cancelling notif.");
        c.f24580b.a();
        return;
    L5:
        if (o.a(r2, "Clarify") == true) goto L6;
    }
}
