package Mb;

import Z8.C1177z;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\"\u0010\u001dJ\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J'\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0014H\u0002¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00020\u001b*\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010*J\u0013\u0010+\u001a\u00020\u001b*\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010*¨\u0006,"}, d2 = {"LMb/r;", "LMb/i;", "<init>", "()V", "LMb/z;", "path", "LMb/h;", "Y", "(LMb/z;)LMb/h;", Const.JSON_KEY_DIR, "", "U", "(LMb/z;)Ljava/util/List;", Const.STR_FILE, "LMb/g;", "e0", "(LMb/z;)LMb/g;", "LMb/I;", "v0", "(LMb/z;)LMb/I;", "", "mustCreate", "LMb/G;", "k0", "(LMb/z;Z)LMb/G;", "mustExist", "e", "LY8/t;", "m", "(LMb/z;Z)V", "source", "target", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/z;LMb/z;)V", "G", "", "toString", "()Ljava/lang/String;", "throwOnFailure", "D0", "(LMb/z;Z)Ljava/util/List;", "N0", "(LMb/z;)V", "I0", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public class r extends AbstractC0971i {
    public final List<z> D0(z dir, boolean throwOnFailure) throws IOException {
        File file = dir.toFile();
        String[] list = file.list();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                kotlin.jvm.internal.p.f(str);
                arrayList.add(dir.n(str));
            }
            C1177z.B(arrayList);
            return arrayList;
        }
        if (!throwOnFailure) {
            return null;
        }
        if (file.exists()) {
            throw new IOException("failed to list " + dir);
        }
        throw new FileNotFoundException("no such file: " + dir);
    }

    @Override // Mb.AbstractC0971i
    public void G(z path, boolean mustExist) throws IOException {
        kotlin.jvm.internal.p.i(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException(com.stepos.ailauncher.chat.trace.g.END_INTERRUPTED);
        }
        File file = path.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            throw new IOException("failed to delete " + path);
        }
        if (mustExist) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    public final void I0(z zVar) throws IOException {
        if (J(zVar)) {
            throw new IOException(zVar + " already exists.");
        }
    }

    public final void N0(z zVar) throws IOException {
        if (J(zVar)) {
            return;
        }
        throw new IOException(zVar + " doesn't exist.");
    }

    @Override // Mb.AbstractC0971i
    public List<z> U(z dir) throws IOException {
        kotlin.jvm.internal.p.i(dir, "dir");
        List<z> listD0 = D0(dir, true);
        kotlin.jvm.internal.p.f(listD0);
        return listD0;
    }

    @Override // Mb.AbstractC0971i
    public C0970h Y(z path) {
        kotlin.jvm.internal.p.i(path, "path");
        File file = path.toFile();
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (zIsFile || zIsDirectory || jLastModified != 0 || length != 0 || file.exists()) {
            return new C0970h(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null, null, 128, null);
        }
        return null;
    }

    @Override // Mb.AbstractC0971i
    public G e(z file, boolean mustExist) throws IOException {
        kotlin.jvm.internal.p.i(file, "file");
        if (mustExist) {
            N0(file);
        }
        return u.g(file.toFile(), true);
    }

    @Override // Mb.AbstractC0971i
    public AbstractC0969g e0(z file) {
        kotlin.jvm.internal.p.i(file, "file");
        return new q(false, new RandomAccessFile(file.toFile(), "r"));
    }

    @Override // Mb.AbstractC0971i
    public void g(z source, z target) throws IOException {
        kotlin.jvm.internal.p.i(source, "source");
        kotlin.jvm.internal.p.i(target, "target");
        if (source.toFile().renameTo(target.toFile())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // Mb.AbstractC0971i
    public G k0(z file, boolean mustCreate) throws IOException {
        kotlin.jvm.internal.p.i(file, "file");
        if (mustCreate) {
            I0(file);
        }
        return v.d(file.toFile(), false, 1, null);
    }

    @Override // Mb.AbstractC0971i
    public void m(z dir, boolean mustCreate) throws IOException {
        kotlin.jvm.internal.p.i(dir, "dir");
        if (dir.toFile().mkdir()) {
            return;
        }
        C0970h c0970hY = Y(dir);
        if (c0970hY == null || !c0970hY.getIsDirectory()) {
            throw new IOException("failed to create directory: " + dir);
        }
        if (mustCreate) {
            throw new IOException(dir + " already exists.");
        }
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }

    @Override // Mb.AbstractC0971i
    public I v0(z file) {
        kotlin.jvm.internal.p.i(file, "file");
        return u.k(file.toFile());
    }
}
