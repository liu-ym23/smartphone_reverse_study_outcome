package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OpenRealTimeCallCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class OpenRealTimeCallCallbackIDLStub extends IOpenRealTimeCallCallbackIDL.Stub implements IOpenRealTimeCallCallbackIDL {
    private final /* synthetic */ IOpenRealTimeCallCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IOpenRealTimeCallCallbackIDL
    public void onResult(int r1) {
        this.$$delegate_0.onResult(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IOpenRealTimeCallCallbackIDL
    public void onResultWithMsg(int r1, String r2) {
        this.$$delegate_0.onResultWithMsg(r1, r2);
    }

    public OpenRealTimeCallCallbackIDLStub() {
        Object r0 = (IOpenRealTimeCallCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOpenRealTimeCallCallbackIDLSPI.class), IOpenRealTimeCallCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IOpenRealTimeCallCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IOpenRealTimeCallCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IOpenRealTimeCallCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IOpenRealTimeCallCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
