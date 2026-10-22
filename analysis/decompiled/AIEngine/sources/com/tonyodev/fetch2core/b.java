package com.tonyodev.fetch2core;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.tonyodev.fetch2core.Downloader;
import gc.o;
import gc.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.AbstractMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import mb.x;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {
    @SuppressLint({"DefaultLocale"})
    public static final boolean a(int i10, AbstractMap abstractMap) {
        String lowerCase;
        String strK = k(abstractMap, "Accept-Ranges", "accept-ranges", "AcceptRanges");
        String strK2 = k(abstractMap, "Transfer-Encoding", "transfer-encoding", "TransferEncoding");
        long jF = f(abstractMap);
        boolean z = i10 == 206 || g.b(strK, "bytes");
        if (jF <= -1 || !z) {
            if (jF > -1) {
                if (strK2 != null) {
                    lowerCase = strK2.toLowerCase(Locale.ROOT);
                    g.e(lowerCase, "toLowerCase(...)");
                } else {
                    lowerCase = null;
                }
                if (!g.b(lowerCase, "chunked")) {
                }
            }
            return false;
        }
        return true;
    }

    public static final long b(long j10, long j11, long j12) {
        if (j11 >= 1 && j10 >= 1 && j12 >= 1) {
            return ((long) Math.abs(Math.ceil((j11 - j10) / j12))) * 1000;
        }
        return -1L;
    }

    public static final int c(long j10, long j11) {
        if (j11 < 1) {
            return -1;
        }
        if (j10 < 1) {
            return 0;
        }
        if (j10 >= j11) {
            return 100;
        }
        return (int) ((j10 / j11) * 100);
    }

    public static final String d(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb2 = new StringBuilder();
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                sb2.append(line);
                sb2.append('\n');
            }
            return sb2.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static final void e(File file) throws FileNotFoundException {
        if (file.exists()) {
            return;
        }
        if (file.getParentFile() != null) {
            File parentFile = file.getParentFile();
            g.c(parentFile);
            if (!parentFile.exists()) {
                File parentFile2 = file.getParentFile();
                g.c(parentFile2);
                if (!parentFile2.mkdirs()) {
                    throw new FileNotFoundException(file + " file_not_found");
                }
                if (file.createNewFile()) {
                    return;
                }
                throw new FileNotFoundException(file + " file_not_found");
            }
        }
        if (file.createNewFile()) {
            return;
        }
        throw new FileNotFoundException(file + " file_not_found");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long f(java.util.AbstractMap r6) {
        /*
            java.lang.String r0 = "content-range"
            java.lang.String r1 = "ContentRange"
            java.lang.String r2 = "Content-Range"
            java.lang.String[] r0 = new java.lang.String[]{r2, r0, r1}
            java.lang.String r0 = k(r6, r0)
            if (r0 == 0) goto L1c
            java.lang.String r1 = "/"
            r2 = 6
            int r1 = gc.q.u0(r2, r0, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L1d
        L1c:
            r1 = 0
        L1d:
            r2 = -1
            if (r1 == 0) goto L4c
            r4 = -1
            int r5 = r1.intValue()
            if (r5 == r4) goto L4c
            int r4 = r1.intValue()
            int r5 = r0.length()
            if (r4 >= r5) goto L4c
            int r1 = r1.intValue()
            int r1 = r1 + 1
            java.lang.String r0 = r0.substring(r1)
            java.lang.String r1 = "substring(...)"
            kotlin.jvm.internal.g.e(r0, r1)
            java.lang.Long r0 = gc.n.d0(r0)
            if (r0 == 0) goto L4c
            long r0 = r0.longValue()
            goto L4d
        L4c:
            r0 = r2
        L4d:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6d
            java.lang.String r0 = "Content-Length"
            java.lang.String r1 = "ContentLength"
            java.lang.String r4 = "content-length"
            java.lang.String[] r0 = new java.lang.String[]{r4, r0, r1}
            java.lang.String r6 = k(r6, r0)
            if (r6 == 0) goto L6c
            java.lang.Long r6 = gc.n.d0(r6)
            if (r6 == 0) goto L6c
            long r0 = r6.longValue()
            return r0
        L6c:
            return r2
        L6d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2core.b.f(java.util.AbstractMap):long");
    }

    public static final String g(String url) {
        g.f(url, "url");
        String strSubstring = url.substring(q.r0(url, "//", 0, false, 6) + 2, q.u0(6, url, ":"));
        g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final int h(String url) {
        g.f(url, "url");
        String strSubstring = url.substring(q.u0(6, url, ":") + 1, url.length());
        g.e(strSubstring, "substring(...)");
        int iR0 = q.r0(strSubstring, "/", 0, false, 6);
        if (iR0 == -1) {
            return Integer.parseInt(strSubstring);
        }
        String strSubstring2 = strSubstring.substring(0, iR0);
        g.e(strSubstring2, "substring(...)");
        return Integer.parseInt(strSubstring2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.File i(java.lang.String r1) throws java.io.IOException {
        /*
            java.lang.String r0 = "filePath"
            kotlin.jvm.internal.g.f(r1, r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L37
            java.io.File r1 = r0.getParentFile()
            if (r1 == 0) goto L34
            java.io.File r1 = r0.getParentFile()
            kotlin.jvm.internal.g.c(r1)
            boolean r1 = r1.exists()
            if (r1 != 0) goto L34
            java.io.File r1 = r0.getParentFile()
            kotlin.jvm.internal.g.c(r1)
            boolean r1 = r1.mkdirs()
            if (r1 == 0) goto L37
            r0.createNewFile()
            return r0
        L34:
            r0.createNewFile()
        L37:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tonyodev.fetch2core.b.i(java.lang.String):java.io.File");
    }

    public static final Uri j(String path) {
        g.f(path, "path");
        if (q(path)) {
            Uri uri = Uri.parse(path);
            g.e(uri, "parse(...)");
            return uri;
        }
        Uri uriFromFile = Uri.fromFile(new File(path));
        g.e(uriFromFile, "fromFile(...)");
        return uriFromFile;
    }

    public static final String k(AbstractMap abstractMap, String... strArr) {
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                return null;
            }
            List list = (List) abstractMap.get(strArr[i10]);
            String str = list != null ? (String) kotlin.collections.a.v0(list) : null;
            if (str != null && !q.t0(str)) {
                return str;
            }
            i10++;
        }
    }

    public static final Long l(String filePath) throws IOException {
        g.f(filePath, "filePath");
        File fileI = i(filePath);
        if (fileI.exists()) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileI, "r");
            try {
                try {
                    Long lValueOf = Long.valueOf(randomAccessFile.readLong());
                    try {
                        randomAccessFile.close();
                        return lValueOf;
                    } catch (Exception unused) {
                        return lValueOf;
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                randomAccessFile.close();
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (Exception unused4) {
                }
                throw th;
            }
        }
        return null;
    }

    public static final String m(String url) {
        g.f(url, "url");
        try {
            Uri uri = Uri.parse(url);
            return uri.getScheme() + "://" + uri.getAuthority();
        } catch (Exception unused) {
            return "https://google.com";
        }
    }

    public static final Set<Downloader.FileDownloaderType> n(Downloader.b bVar, Downloader<?, ?> downloader) {
        Set<Downloader.FileDownloaderType> setU = x.U(Downloader.FileDownloaderType.f8203a);
        try {
            Downloader.a aVarD0 = downloader.D0(bVar, new a4.a(25));
            if (aVarD0 != null) {
                if (a(aVarD0.f8206a, aVarD0.f8210e)) {
                    setU.add(Downloader.FileDownloaderType.f8204b);
                }
                downloader.E(aVarD0);
            }
        } catch (Exception unused) {
        }
        return setU;
    }

    public static final boolean o(long j10, long j11, long j12) {
        return TimeUnit.NANOSECONDS.toMillis(j11 - j10) >= j12;
    }

    public static final boolean p(String url) {
        g.f(url, "url");
        try {
            if (o.k0(url, "fetchlocal://", false) && g(url).length() > 0) {
                if (h(url) > -1) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean q(String path) {
        g.f(path, "path");
        if (path.length() <= 0) {
            path = null;
        }
        return path != null && (o.k0(path, "content://", false) || o.k0(path, "file://", false));
    }
}
