package gb;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2core.Downloader;
import gc.o;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.g;
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {
    public static final void a(int i10, String fileTempDir) {
        File[] fileArrListFiles;
        g.f(fileTempDir, "fileTempDir");
        try {
            File file = new File(fileTempDir);
            if (!file.exists() || (fileArrListFiles = file.listFiles()) == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            for (File file2 : fileArrListFiles) {
                g.c(file2);
                if (o.k0(d.V(file2), i10 + ".", false)) {
                    arrayList.add(file2);
                }
            }
            int size = arrayList.size();
            while (i11 < size) {
                Object obj = arrayList.get(i11);
                i11++;
                File file3 = (File) obj;
                if (file3.exists()) {
                    file3.delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static final String b(int i10, int i11, String fileTempDir) {
        g.f(fileTempDir, "fileTempDir");
        return fileTempDir + "/" + i10 + "." + i11 + ".data";
    }

    public static final String c(int i10, String fileTempDir) {
        g.f(fileTempDir, "fileTempDir");
        return fileTempDir + "/" + i10 + ".meta.data";
    }

    public static final Downloader.b d(Download download, String str) {
        return f(download, -1L, -1L, str, 0, 16);
    }

    public static Downloader.b f(Download download, long j10, long j11, String str, int i10, int i11) {
        String str2 = (i11 & 8) != 0 ? "GET" : str;
        int i12 = (i11 & 16) != 0 ? 1 : i10;
        g.f(download, "download");
        long j12 = j10 == -1 ? 0L : j10;
        String strValueOf = j11 == -1 ? "" : String.valueOf(j11);
        LinkedHashMap linkedHashMapO0 = kotlin.collections.b.o0(download.getHeaders());
        linkedHashMapO0.put("Range", a0.a.h("bytes=", j12, "-", strValueOf));
        return new Downloader.b(download.getId(), download.getUrl(), linkedHashMapO0, download.getFile(), com.tonyodev.fetch2core.b.j(download.getFile()), download.getTag(), download.getIdentifier(), str2, download.getExtras(), "", i12);
    }

    public static final void g(int i10, int i11, String fileTempDir) throws IOException {
        g.f(fileTempDir, "fileTempDir");
        try {
            String filePath = c(i10, fileTempDir);
            long j10 = i11;
            g.f(filePath, "filePath");
            File fileI = com.tonyodev.fetch2core.b.i(filePath);
            if (fileI.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileI, "rw");
                try {
                    randomAccessFile.seek(0L);
                    randomAccessFile.setLength(0L);
                    randomAccessFile.writeLong(j10);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
                randomAccessFile.close();
            }
        } catch (Exception unused3) {
        }
    }
}
