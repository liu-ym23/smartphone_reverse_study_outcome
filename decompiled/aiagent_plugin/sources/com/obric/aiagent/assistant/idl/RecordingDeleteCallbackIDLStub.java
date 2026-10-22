package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RecordingDeleteCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class RecordingDeleteCallbackIDLStub extends IRecordingDeleteCallbackIDL.Stub implements IRecordingDeleteCallbackIDL {
    private final /* synthetic */ IRecordingDeleteCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IRecordingDeleteCallbackIDL
    public void onResult(int r1, String r2) {
        this.$$delegate_0.onResult(r1, r2);
    }

    public RecordingDeleteCallbackIDLStub() {
        Object r0 = (IRecordingDeleteCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IRecordingDeleteCallbackIDLSPI.class), IRecordingDeleteCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IRecordingDeleteCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IRecordingDeleteCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IRecordingDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IRecordingDeleteCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
