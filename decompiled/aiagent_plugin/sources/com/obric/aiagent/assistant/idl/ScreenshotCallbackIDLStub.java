package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ScreenshotCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class ScreenshotCallbackIDLStub extends IScreenshotCallbackIDL.Stub implements IScreenshotCallbackIDL {
    private final /* synthetic */ IScreenshotCallbackIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
    public void onError(String r1) {
        this.$$delegate_0.onError(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
    public void onReceivedScreenshot(Bitmap r1) {
        this.$$delegate_0.onReceivedScreenshot(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
    public void onReceivedScreenshotUri(Uri r1) {
        this.$$delegate_0.onReceivedScreenshotUri(r1);
    }

    public ScreenshotCallbackIDLStub() {
        Object r0 = (IScreenshotCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IScreenshotCallbackIDLSPI.class), IScreenshotCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IScreenshotCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IScreenshotCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
