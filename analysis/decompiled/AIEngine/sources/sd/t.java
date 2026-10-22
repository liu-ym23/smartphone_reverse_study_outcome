package sd;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.util.logging.Logger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class t extends l {
    @Override // sd.l
    public k a(x xVar) {
        File file = new File(xVar.f11982a.r());
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (zIsFile || zIsDirectory || jLastModified != 0 || length != 0 || file.exists()) {
            return new k(zIsFile, zIsDirectory, Long.valueOf(length), null, Long.valueOf(jLastModified), null);
        }
        return null;
    }

    @Override // sd.l
    public final j b(x file) {
        kotlin.jvm.internal.g.f(file, "file");
        return new s(new RandomAccessFile(new File(file.f11982a.r()), "r"));
    }

    @Override // sd.l
    public final e0 c(x file) {
        kotlin.jvm.internal.g.f(file, "file");
        File file2 = new File(file.f11982a.r());
        Logger logger = v.f11978a;
        return new d(new FileInputStream(file2), f0.f11935d);
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
