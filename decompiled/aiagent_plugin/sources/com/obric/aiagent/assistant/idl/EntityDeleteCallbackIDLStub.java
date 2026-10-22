package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EntityDeleteCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class EntityDeleteCallbackIDLStub extends IEntityDeleteCallbackIDL.Stub implements IEntityDeleteCallbackIDL {
    private final /* synthetic */ IEntityDeleteCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IEntityDeleteCallbackIDL
    public void onResult(int r1, String r2, String[] r3) {
        this.$$delegate_0.onResult(r1, r2, r3);
    }

    public EntityDeleteCallbackIDLStub() {
        Object r0 = (IEntityDeleteCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityDeleteCallbackIDLSPI.class), IEntityDeleteCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IEntityDeleteCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IEntityDeleteCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IEntityDeleteCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
