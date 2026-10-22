package com.obric.aiagent.ipc.idl;

import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f.k;
import d.h.b.o;
import d.n.j;
import d.n.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: FileIDLStubImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FileIDLStubImpl implements IFileIDLSPI {
    public static /* synthetic */ FilePath lambda$D9pkWaaNq5QUimxy4V9CTL2Biog(FilePath r0, File r1, File r2) {
        return listAllFile$lambda$2(r0, r1, r2);
    }

    public FileIDLStubImpl() {
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return IFileIDLSPI.b.a(this);
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public ParcelFileDescriptor openFile(FilePath r2, int r3) {
        o.e(r2, Params.FILE_PATH);
        File r1 = r2.toLocalFile();
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.exists() == true) goto L8;
    L12:
        return null;
    L8:
        if (r1.isFile() == false) goto L12;
        return ParcelFileDescriptor.open(r1, r3);
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public boolean deleteFile(FilePath r5) {
        o.e(r5, Params.FILE_PATH);
        File r0 = r5.toLocalFile();
        if (r0 != null) goto L7;
        FileIDLStubImpl r4 = (FileIDLStubImpl) ZeusTransformUtils.preCheckCast(this, FileIDLStubImpl.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.e("FileIDLStubImpl", "Invalid path: " + r5);
        return false;
    L7:
        if (r0.exists() == true) goto L11;
        ILogDepend.Companion.d("FileIDLStubImpl", "file " + r0.getPath() + " is not exists.");
        return false;
    L11:
        if (r0.isDirectory() == false) goto L13;
        boolean r6 = k.h(r0);
    L14:
        ILogDepend.Companion.d("FileIDLStubImpl", "deleteFile " + r5 + " result " + r6);
        return r6;
    L13:
        r6 = r0.delete();
        goto L14
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List<FilePath> listDir(FilePath r11) {
        o.e(r11, Params.FILE_PATH);
        File r10 = r11.toLocalFile();
        if (r10 != null) goto L7;
        return p.b();
    L7:
        if (r10.exists() == false) goto L22;
        if (r10.isDirectory() == false) goto L22;
        File[] r0 = r10.listFiles();
        if (r0 == null) goto L17;
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r0.length), Collection.class, "com.obric.aiagent.plugin");
        int r2 = 0;
        int r4 = r0.length;
    L14:
        if (r2 >= r4) goto L16;
        File r5 = r0[r2];
        int r7 = r11.getBaseDir();
        StringBuilder r8 = new StringBuilder().append(r11.getRelativePath()).append('/');
        o.a(r5);
        r1.add(new FilePath(r7, r8.append(k.a(r5, r10)).toString(), r5.isDirectory()));
        r2 = r2 + 1;
        goto L14
    L16:
        List<FilePath> r12 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L18:
        if (r12 == null) goto L20;
        return r12;
    L20:
        return p.b();
    L17:
        r12 = null;
    L22:
        return p.b();
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List<FilePath> listAllFile(final FilePath r5) {
        o.e(r5, Params.FILE_PATH);
        ILogDepend.Companion.d("FileIDLStubImpl", "listAllFile filePath " + r5.getRelativePath());
        final File r4 = r5.toLocalFile();
        if (r4 == null) goto L5;
        ILogDepend.Companion.d("FileIDLStubImpl", "listAllFile localFile " + r4.getAbsoluteFile());
        if (r4.exists() == true) goto L9;
    L13:
        ILogDepend.Companion.d("FileIDLStubImpl", "localFile " + r4.getAbsoluteFile() + " is not exists or is not directory.");
        return p.b();
    L9:
        if (r4.isDirectory() == false) goto L13;
        return m.g(m.d((j) ZeusTransformUtils.preCheckCast(k.d(r4), j.class, "com.obric.aiagent.plugin"), new $$Lambda$FileIDLStubImpl$D9pkWaaNq5QUimxy4V9CTL2Biog(r5, r4)));
    L5:
        return p.b();
    }

    private static final FilePath listAllFile$lambda$2(FilePath r3, File r4, File r5) {
        o.e(r5, "it");
        return new FilePath(r3.getBaseDir(), r3.getRelativePath() + '/' + k.a(r5, r4), r5.isDirectory());
    }
}
