package vendor.bytedance.hardware.ahm;

import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.d;
import com.obric.aiagent.ipc.utils.g;
import com.obric.aiagent.ipc.utils.j;
import com.obric.aiagent.ipc.utils.k;

/* JADX INFO: loaded from: classes5.dex */
class AHMCallbackIDLStubWrapper extends IAHMCallbackIDL.Stub {
    boolean log;
    final IAHMCallbackIDL.Stub origin;

    AHMCallbackIDLStubWrapper(IAHMCallbackIDL.Stub r2) {
        this(r2, true);
    }

    AHMCallbackIDLStubWrapper(IAHMCallbackIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMCallbackIDL
    public void submitBuffer(byte[] r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("AHMCallbackIDLStub", "submitBuffer(" + r21 + ")", e);
        g r2 = new g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        k.f18677a.b("AHMCallbackIDLStub", "submitBuffer(" + r21 + ") = fail", r2, r4);
        d.f18654a.b("AHMCallbackIDLStub", "submitBuffer", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("AHMCallbackIDLStub", "submitBuffer(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.submitBuffer(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("AHMCallbackIDLStub", "submitBuffer = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("AHMCallbackIDLStub", "submitBuffer(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        d.f18654a.b("AHMCallbackIDLStub", "submitBuffer", r14, r17);     // Catch: Exception -> L11
    }
}
