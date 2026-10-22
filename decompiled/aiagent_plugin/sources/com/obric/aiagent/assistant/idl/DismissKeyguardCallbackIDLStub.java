package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DismissKeyguardCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class DismissKeyguardCallbackIDLStub extends IDismissKeyguardCallbackIDL.Stub implements IDismissKeyguardCallbackIDL {
    private final /* synthetic */ IDismissKeyguardCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IDismissKeyguardCallbackIDL
    public void onResult(boolean r1, boolean r2) {
        this.$$delegate_0.onResult(r1, r2);
    }

    public DismissKeyguardCallbackIDLStub() {
        Object r0 = (IDismissKeyguardCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDismissKeyguardCallbackIDLSPI.class), IDismissKeyguardCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IDismissKeyguardCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IDismissKeyguardCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IDismissKeyguardCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IDismissKeyguardCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
