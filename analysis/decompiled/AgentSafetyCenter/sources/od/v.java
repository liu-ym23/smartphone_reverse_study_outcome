package od;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class v extends o {
    @Override // od.o
    public final g0 a(z zVar) {
        zVar.getClass();
        File file = zVar.toFile();
        Logger logger = x.f9494a;
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        k0 k0Var = new k0();
        b bVar = new b(1);
        bVar.f9419f = fileOutputStream;
        bVar.f9420g = k0Var;
        VarHandle.storeStoreFence();
        return bVar;
    }

    @Override // od.o
    public void b(z zVar, z zVar2) throws IOException {
        zVar.getClass();
        zVar2.getClass();
        if (zVar.toFile().renameTo(zVar2.toFile())) {
            return;
        }
        throw new IOException("failed to move " + zVar + " to " + zVar2);
    }

    @Override // od.o
    public final void c(z zVar) throws IOException {
        if (zVar.toFile().mkdir()) {
            return;
        }
        n nVarI = i(zVar);
        if (nVarI == null || !nVarI.f9472c) {
            f.k(zVar, "failed to create directory: ");
        }
    }

    @Override // od.o
    public final void d(z zVar) throws IOException {
        zVar.getClass();
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = zVar.toFile();
        if (file.delete() || !file.exists()) {
            return;
        }
        f.k(zVar, "failed to delete ");
    }

    @Override // od.o
    public final List g(z zVar) throws IOException {
        zVar.getClass();
        File file = zVar.toFile();
        String[] list = file.list();
        if (list == null) {
            if (file.exists()) {
                f.k(zVar, "failed to list ");
                return null;
            }
            f.d(zVar, "no such file: ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            str.getClass();
            arrayList.add(zVar.d(str));
        }
        kb.p.n0(arrayList);
        return arrayList;
    }

    @Override // od.o
    public n i(z zVar) {
        zVar.getClass();
        File file = zVar.toFile();
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (!zIsFile && !zIsDirectory && jLastModified == 0 && length == 0 && !file.exists()) {
            return null;
        }
        return new n(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null);
    }

    @Override // od.o
    public final u j(z zVar) {
        zVar.getClass();
        RandomAccessFile randomAccessFile = new RandomAccessFile(zVar.toFile(), "r");
        u uVar = new u();
        uVar.f9492g = new ReentrantLock();
        uVar.f9493h = randomAccessFile;
        VarHandle.storeStoreFence();
        return uVar;
    }

    @Override // od.o
    public final g0 k(z zVar) {
        zVar.getClass();
        File file = zVar.toFile();
        Logger logger = x.f9494a;
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        k0 k0Var = new k0();
        b bVar = new b(1);
        bVar.f9419f = fileOutputStream;
        bVar.f9420g = k0Var;
        VarHandle.storeStoreFence();
        return bVar;
    }

    @Override // od.o
    public final i0 l(z zVar) {
        zVar.getClass();
        File file = zVar.toFile();
        Logger logger = x.f9494a;
        return new c(new FileInputStream(file), k0.f9455d);
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
