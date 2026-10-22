package vendor.bytedance.hardware.ahm;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AHMIDLExt.kt */
/* JADX INFO: loaded from: classes5.dex */
final class AHMIDLStub extends IAHMIDL.Stub implements IAHMIDL {
    private final /* synthetic */ IAHMIDL $$delegate_0;

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_close() {
        return this.$$delegate_0.ipc_ahm_close();
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_open(IAHMCallbackIDL r3) {
        IAHMCallbackIDL r4 = (IAHMCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAHMCallbackIDL.class, "com.obric.aiagent.plugin");
        return this.$$delegate_0.ipc_ahm_open(r4);
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_open_v2(IAHMCallbackIDL r3, int r4) {
        IAHMCallbackIDL r5 = (IAHMCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAHMCallbackIDL.class, "com.obric.aiagent.plugin");
        return this.$$delegate_0.ipc_ahm_open_v2(r5, r4);
    }

    public AHMIDLStub() {
        Object r0 = (IAHMIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAHMIDLSPI.class), IAHMIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAHMIDL.Default();
    L6:
        this.$$delegate_0 = (IAHMIDL) ZeusTransformUtils.preCheckCast(r0, IAHMIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        o.c(r1, "asBinder(...)");
        return r1;
    }
}
