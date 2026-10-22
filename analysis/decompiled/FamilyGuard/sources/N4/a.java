package N4;

import N4.c;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class a implements c.a {

    /* renamed from: N4.a$a, reason: collision with other inner class name */
    private static class C0065a {

        /* renamed from: a, reason: collision with root package name */
        public ZipFile f4263a;

        /* renamed from: b, reason: collision with root package name */
        public ZipEntry f4264b;

        public C0065a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f4263a = zipFile;
            this.f4264b = zipEntry;
        }
    }

    private long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT];
        long j5 = 0;
        while (true) {
            int i5 = inputStream.read(bArr);
            if (i5 == -1) {
                outputStream.flush();
                return j5;
            }
            outputStream.write(bArr, 0, i5);
            j5 += i5;
        }
    }

    private C0065a c(Context context, String[] strArr, String str, d dVar) throws IOException {
        ZipFile zipFile = null;
        for (String str2 : e(context)) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (i5 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i5 = i6;
                }
            }
            if (zipFile != null) {
                int i7 = 0;
                while (true) {
                    int i8 = i7 + 1;
                    if (i7 < 5) {
                        for (String str3 : strArr) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("lib");
                            char c6 = File.separatorChar;
                            sb.append(c6);
                            sb.append(str3);
                            sb.append(c6);
                            sb.append(str);
                            String string = sb.toString();
                            dVar.g("Looking for %s in APK %s...", string, str2);
                            ZipEntry entry = zipFile.getEntry(string);
                            if (entry != null) {
                                return new C0065a(zipFile, entry);
                            }
                        }
                        i7 = i8;
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

    private void d(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private String[] e(Context context) {
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

    @Override // N4.c.a
    public void a(Context context, String[] strArr, String str, File file, d dVar) throws Throwable {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        long jB;
        C0065a c0065a = null;
        closeable = null;
        Closeable closeable = null;
        try {
            C0065a c0065aC = c(context, strArr, str, dVar);
            try {
                if (c0065aC == null) {
                    throw new b(str);
                }
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    try {
                        if (i5 < 5) {
                            dVar.g("Found %s! Extracting...", str);
                            try {
                                if (file.exists() || file.createNewFile()) {
                                    try {
                                        inputStream = c0065aC.f4263a.getInputStream(c0065aC.f4264b);
                                        try {
                                            fileOutputStream = new FileOutputStream(file);
                                            try {
                                                jB = b(inputStream, fileOutputStream);
                                                fileOutputStream.getFD().sync();
                                            } catch (FileNotFoundException | IOException unused) {
                                                d(inputStream);
                                                d(fileOutputStream);
                                                i5 = i6;
                                            } catch (Throwable th) {
                                                th = th;
                                                closeable = fileOutputStream;
                                                d(inputStream);
                                                d(closeable);
                                                throw th;
                                            }
                                        } catch (FileNotFoundException unused2) {
                                            fileOutputStream = null;
                                        } catch (IOException unused3) {
                                            fileOutputStream = null;
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } catch (FileNotFoundException unused4) {
                                        inputStream = null;
                                        fileOutputStream = null;
                                    } catch (IOException unused5) {
                                        inputStream = null;
                                        fileOutputStream = null;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        inputStream = null;
                                    }
                                    if (jB != file.length()) {
                                        d(inputStream);
                                        d(fileOutputStream);
                                    } else {
                                        d(inputStream);
                                        d(fileOutputStream);
                                        file.setReadable(true, false);
                                        file.setExecutable(true, false);
                                        file.setWritable(true);
                                        ZipFile zipFile = c0065aC.f4263a;
                                        if (zipFile != null) {
                                            zipFile.close();
                                        }
                                    }
                                }
                            } catch (IOException unused6) {
                            }
                            i5 = i6;
                        } else {
                            dVar.f("FATAL! Couldn't extract the library from the APK!");
                            ZipFile zipFile2 = c0065aC.f4263a;
                            if (zipFile2 != null) {
                                zipFile2.close();
                            }
                        }
                    } catch (IOException unused7) {
                        return;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                c0065a = c0065aC;
                if (c0065a != null) {
                    try {
                        ZipFile zipFile3 = c0065a.f4263a;
                        if (zipFile3 != null) {
                            zipFile3.close();
                        }
                    } catch (IOException unused8) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
