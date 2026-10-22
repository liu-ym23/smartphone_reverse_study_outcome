package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ObricActionResultCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class ObricActionResultCallbackIDLStub extends IObricActionResultCallbackIDL.Stub implements IObricActionResultCallbackIDL {
    private final /* synthetic */ IObricActionResultCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IObricActionResultCallbackIDL
    public void onResult(boolean r1, String r2, String r3) {
        this.$$delegate_0.onResult(r1, r2, r3);
    }

    public ObricActionResultCallbackIDLStub() {
        Object r0 = (IObricActionResultCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IObricActionResultCallbackIDLSPI.class), IObricActionResultCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IObricActionResultCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IObricActionResultCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IObricActionResultCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IObricActionResultCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
