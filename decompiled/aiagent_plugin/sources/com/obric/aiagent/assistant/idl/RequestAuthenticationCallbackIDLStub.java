package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RequestAuthenticationCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class RequestAuthenticationCallbackIDLStub extends IRequestAuthenticationCallbackIDL.Stub implements IRequestAuthenticationCallbackIDL {
    private final /* synthetic */ IRequestAuthenticationCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationCancelled() {
        this.$$delegate_0.onAuthenticationCancelled();
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationFailed() {
        this.$$delegate_0.onAuthenticationFailed();
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationNotAvailable() {
        this.$$delegate_0.onAuthenticationNotAvailable();
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationPass() {
        this.$$delegate_0.onAuthenticationPass();
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL
    public void onAuthenticationTimeout() {
        this.$$delegate_0.onAuthenticationTimeout();
    }

    public RequestAuthenticationCallbackIDLStub() {
        Object r0 = (IRequestAuthenticationCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IRequestAuthenticationCallbackIDLSPI.class), IRequestAuthenticationCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IRequestAuthenticationCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
