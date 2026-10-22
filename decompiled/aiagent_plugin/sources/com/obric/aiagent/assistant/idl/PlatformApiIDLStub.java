package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: PlatformApiIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class PlatformApiIDLStub extends IPlatformApiIDL.Stub implements IPlatformApiIDL {
    private final /* synthetic */ IPlatformApiIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
    public List<String> getTasksPackages(int r1, boolean r2, boolean r3, int r4) {
        return this.$$delegate_0.getTasksPackages(r1, r2, r3, r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
    public boolean moveTaskToDisplay(int r1, int r2, boolean r3) {
        return this.$$delegate_0.moveTaskToDisplay(r1, r2, r3);
    }

    public PlatformApiIDLStub() {
        Object r0 = (IPlatformApiIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPlatformApiIDLSPI.class), IPlatformApiIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IPlatformApiIDL.Default();
    L6:
        this.$$delegate_0 = (IPlatformApiIDL) ZeusTransformUtils.preCheckCast(r0, IPlatformApiIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
