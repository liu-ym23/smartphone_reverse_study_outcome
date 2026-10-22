package ob;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class v extends o {
    @Override // ob.o
    public void a(z zVar, z zVar2) throws IOException {
        q7.k.e(zVar2, "target");
        if (zVar.toFile().renameTo(zVar2.toFile())) {
            return;
        }
        throw new IOException("failed to move " + zVar + " to " + zVar2);
    }

    @Override // ob.o
    public final void b(z zVar) throws IOException {
        if (zVar.toFile().mkdir()) {
            return;
        }
        n nVarE = e(zVar);
        if (nVarE == null || !nVarE.f8012b) {
            throw new IOException("failed to create directory: " + zVar);
        }
    }

    @Override // ob.o
    public final void c(z zVar) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = zVar.toFile();
        if (file.delete() || !file.exists()) {
            return;
        }
        throw new IOException("failed to delete " + zVar);
    }

    @Override // ob.o
    public n e(z zVar) {
        q7.k.e(zVar, "path");
        File file = zVar.toFile();
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (zIsFile || zIsDirectory || jLastModified != 0 || length != 0 || file.exists()) {
            return new n(zIsFile, zIsDirectory, Long.valueOf(length), null, Long.valueOf(jLastModified), null);
        }
        return null;
    }

    @Override // ob.o
    public final u f(z zVar) {
        return new u(false, new RandomAccessFile(zVar.toFile(), "r"));
    }

    @Override // ob.o
    public final u g(z zVar) {
        q7.k.e(zVar, "file");
        return new u(true, new RandomAccessFile(zVar.toFile(), "rw"));
    }

    @Override // ob.o
    public final k0 h(z zVar) {
        q7.k.e(zVar, "file");
        File file = zVar.toFile();
        Logger logger = x.f8039a;
        return new e(1, new FileInputStream(file), m0.f8007d);
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
