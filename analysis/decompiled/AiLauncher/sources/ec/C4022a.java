package ec;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import ec.AbstractC4023b;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: ec.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4022a implements AbstractC4023b.a {

    /* renamed from: ec.a$a, reason: collision with other inner class name */
    public static class C0399a {

        /* renamed from: a, reason: collision with root package name */
        public ZipFile f32444a;

        /* renamed from: b, reason: collision with root package name */
        public ZipEntry f32445b;

        public C0399a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f32444a = zipFile;
            this.f32445b = zipEntry;
        }
    }

    @Override // ec.AbstractC4023b.a
    public void a(Context context, String[] strArr, String str, File file, C4024c c4024c) throws Throwable {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        C0399a c0399a = null;
        closeable = null;
        Closeable closeable = null;
        try {
            C0399a c0399aC = c(context, strArr, str, c4024c);
            try {
                if (c0399aC == null) {
                    throw new org.extra.relinker.b(str);
                }
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    try {
                        if (i10 < 5) {
                            c4024c.g("Found %s! Extracting...", str);
                            try {
                                if (file.exists() || file.createNewFile()) {
                                    try {
                                        inputStream = c0399aC.f32444a.getInputStream(c0399aC.f32445b);
                                        try {
                                            fileOutputStream = new FileOutputStream(file);
                                        } catch (FileNotFoundException unused) {
                                            fileOutputStream = null;
                                            d(inputStream);
                                            d(fileOutputStream);
                                            i10 = i11;
                                        } catch (IOException unused2) {
                                            fileOutputStream = null;
                                            d(inputStream);
                                            d(fileOutputStream);
                                            i10 = i11;
                                        } catch (Throwable th) {
                                            th = th;
                                        }
                                        try {
                                            long jB = b(inputStream, fileOutputStream);
                                            fileOutputStream.getFD().sync();
                                            if (jB != file.length()) {
                                                d(inputStream);
                                                d(fileOutputStream);
                                            } else {
                                                d(inputStream);
                                                d(fileOutputStream);
                                                file.setReadable(true, false);
                                                file.setExecutable(true, false);
                                                file.setWritable(true);
                                                ZipFile zipFile = c0399aC.f32444a;
                                                if (zipFile != null) {
                                                    zipFile.close();
                                                }
                                            }
                                        } catch (FileNotFoundException unused3) {
                                            d(inputStream);
                                            d(fileOutputStream);
                                            i10 = i11;
                                        } catch (IOException unused4) {
                                            d(inputStream);
                                            d(fileOutputStream);
                                            i10 = i11;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            closeable = fileOutputStream;
                                            d(inputStream);
                                            d(closeable);
                                            throw th;
                                        }
                                    } catch (FileNotFoundException unused5) {
                                        inputStream = null;
                                    } catch (IOException unused6) {
                                        inputStream = null;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        inputStream = null;
                                    }
                                }
                            } catch (IOException unused7) {
                            }
                            i10 = i11;
                        } else {
                            c4024c.f("FATAL! Couldn't extract the library from the APK!");
                            ZipFile zipFile2 = c0399aC.f32444a;
                            if (zipFile2 != null) {
                                zipFile2.close();
                            }
                        }
                    } catch (IOException unused8) {
                        return;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                c0399a = c0399aC;
                if (c0399a != null) {
                    try {
                        ZipFile zipFile3 = c0399a.f32444a;
                        if (zipFile3 != null) {
                            zipFile3.close();
                        }
                    } catch (IOException unused9) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public final long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j10 = 0;
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                outputStream.flush();
                return j10;
            }
            outputStream.write(bArr, 0, i10);
            j10 += i10;
        }
    }

    public final C0399a c(Context context, String[] strArr, String str, C4024c c4024c) throws IOException {
        ZipFile zipFile = null;
        for (String str2 : e(context)) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (i10 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i10 = i11;
                }
            }
            if (zipFile != null) {
                int i12 = 0;
                while (true) {
                    int i13 = i12 + 1;
                    if (i12 < 5) {
                        for (String str3 : strArr) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("lib");
                            char c10 = File.separatorChar;
                            sb2.append(c10);
                            sb2.append(str3);
                            sb2.append(c10);
                            sb2.append(str);
                            String string = sb2.toString();
                            c4024c.g("Looking for %s in APK %s...", string, str2);
                            ZipEntry entry = zipFile.getEntry(string);
                            if (entry != null) {
                                return new C0399a(zipFile, entry);
                            }
                        }
                        i12 = i13;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
        }
        return null;
    }

    public final void d(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public final String[] e(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }
}
