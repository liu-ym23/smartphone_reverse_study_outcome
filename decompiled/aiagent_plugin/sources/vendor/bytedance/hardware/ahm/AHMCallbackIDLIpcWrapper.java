package vendor.bytedance.hardware.ahm;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.d;
import com.obric.aiagent.ipc.utils.g;
import com.obric.aiagent.ipc.utils.j;
import com.obric.aiagent.ipc.utils.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
class AHMCallbackIDLIpcWrapper implements IAHMCallbackIDL {
    boolean log;
    final IAHMCallbackIDL origin;

    AHMCallbackIDLIpcWrapper(IAHMCallbackIDL r3) {
        this((IAHMCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAHMCallbackIDL.class, "com.obric.aiagent.plugin"), true);
    }

    AHMCallbackIDLIpcWrapper(IAHMCallbackIDL r3, boolean r4) {
        this.origin = (IAHMCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAHMCallbackIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMCallbackIDL
    public void submitBuffer(byte[] r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        j.f18676a.a("IAHMCallbackIDLIPC", "submitBuffer(" + r21 + ")", e);     // Catch: Throwable -> L17
        g r2 = new g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IAHMCallbackIDLIPC", "submitBuffer(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        d.f18654a.a("IAHMCallbackIDLIPC", "submitBuffer", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IAHMCallbackIDLIPC", "submitBuffer(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IAHMCallbackIDLIPC", "submitBuffer(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.submitBuffer(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IAHMCallbackIDLIPC", "submitBuffer = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IAHMCallbackIDLIPC", "submitBuffer(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        d.f18654a.a("IAHMCallbackIDLIPC", "submitBuffer", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
