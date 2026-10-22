package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DowngradeAuthForDoraCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class DowngradeAuthForDoraCallbackIDLStub extends IDowngradeAuthForDoraCallbackIDL.Stub implements IDowngradeAuthForDoraCallbackIDL {
    private final /* synthetic */ IDowngradeAuthForDoraCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToNoneAuth() {
        this.$$delegate_0.onDowngradeToNoneAuth();
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onDowngradeToVoicePrint() {
        this.$$delegate_0.onDowngradeToVoicePrint();
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL
    public void onNotDowngrade() {
        this.$$delegate_0.onNotDowngrade();
    }

    public DowngradeAuthForDoraCallbackIDLStub() {
        Object r0 = (IDowngradeAuthForDoraCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDowngradeAuthForDoraCallbackIDLSPI.class), IDowngradeAuthForDoraCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IDowngradeAuthForDoraCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IDowngradeAuthForDoraCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IDowngradeAuthForDoraCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IDowngradeAuthForDoraCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
