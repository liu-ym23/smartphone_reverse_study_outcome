package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ImageXUploadCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class ImageXUploadCallbackIDLStub extends IImageXUploadCallbackIDL.Stub implements IImageXUploadCallbackIDL {
    private final /* synthetic */ IImageXUploadCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL
    public void onResult(boolean r7, String r8, String r9, String r10, String r11) {
        this.$$delegate_0.onResult(r7, r8, r9, r10, r11);
    }

    public ImageXUploadCallbackIDLStub() {
        Object r0 = (IImageXUploadCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IImageXUploadCallbackIDLSPI.class), IImageXUploadCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IImageXUploadCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IImageXUploadCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
