package com.obric.autogui.net.push.internal;

import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.matrix.sdk.push.a.b;
import com.obric.matrix.sdk.push.cross_process.MessageProvider;
import d.h.b.o;

/* JADX INFO: compiled from: PushMessageReceiverProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PushMessageReceiverProvider extends MessageProvider {
    public PushMessageReceiverProvider() {
    }

    @Override // com.obric.matrix.sdk.push.a
    public void onReceiveMsg(com.obric.matrix.sdk.push.a.a r4) {
        o.e(r4, "message");
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "push recv pass though msg = " + r4 + ", payload data=" + r4.a());
        a.f29134a.a(r4.a());
    }

    public void onRevokeMsg(b r4) {
        o.e(r4, "revokeMsg");
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "push recv revoke msg = " + r4.a());
    }
}
