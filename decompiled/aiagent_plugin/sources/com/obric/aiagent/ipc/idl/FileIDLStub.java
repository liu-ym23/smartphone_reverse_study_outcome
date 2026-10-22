package com.obric.aiagent.ipc.idl;

import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: FileIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FileIDLStub extends IFileIDL.Stub implements IFileIDL {
    private final /* synthetic */ IFileIDL $$delegate_0;

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public boolean deleteFile(FilePath r1) {
        return this.$$delegate_0.deleteFile(r1);
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List listAllFile(FilePath r1) {
        return this.$$delegate_0.listAllFile(r1);
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List listDir(FilePath r1) {
        return this.$$delegate_0.listDir(r1);
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public ParcelFileDescriptor openFile(FilePath r1, int r2) {
        return this.$$delegate_0.openFile(r1, r2);
    }

    public FileIDLStub() {
        Object r0 = (IFileIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFileIDLSPI.class), IFileIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFileIDL.Default();
    L6:
        this.$$delegate_0 = (IFileIDL) ZeusTransformUtils.preCheckCast(r0, IFileIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        o.c(r1, "asBinder(...)");
        return r1;
    }
}
