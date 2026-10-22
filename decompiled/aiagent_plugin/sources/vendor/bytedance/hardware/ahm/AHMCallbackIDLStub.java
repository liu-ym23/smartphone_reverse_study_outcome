package vendor.bytedance.hardware.ahm;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AHMCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes5.dex */
final class AHMCallbackIDLStub extends IAHMCallbackIDL.Stub implements IAHMCallbackIDL {
    private final /* synthetic */ IAHMCallbackIDL $$delegate_0;

    @Override // vendor.bytedance.hardware.ahm.IAHMCallbackIDL
    public void submitBuffer(byte[] r1) {
        this.$$delegate_0.submitBuffer(r1);
    }

    public AHMCallbackIDLStub() {
        Object r0 = (IAHMCallbackIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAHMCallbackIDLSPI.class), IAHMCallbackIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAHMCallbackIDL.Default();
    L6:
        this.$$delegate_0 = (IAHMCallbackIDL) ZeusTransformUtils.preCheckCast(r0, IAHMCallbackIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMCallbackIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        o.c(r1, "asBinder(...)");
        return r1;
    }
}
