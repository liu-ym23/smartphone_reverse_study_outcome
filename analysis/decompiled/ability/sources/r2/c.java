package r2;

import M0.i;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes2.dex */
public abstract class c {
    static {
        new ArrayList();
    }

    public static String a(Context context, File file) throws IOException {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String strB = b(file, applicationInfo.sourceDir);
        if (strB != null) {
            String[] strArr = applicationInfo.splitSourceDirs;
            if (strArr != null) {
                for (String str : strArr) {
                    strB = b(file, str);
                    if (strB != null) {
                    }
                }
            }
            try {
                ClassLoader classLoader = c.class.getClassLoader();
                while (!(classLoader instanceof BaseDexClassLoader) && classLoader.getParent() != null) {
                    classLoader = classLoader.getParent();
                }
                if (!(classLoader instanceof BaseDexClassLoader)) {
                    return strB;
                }
                Field declaredField = BaseDexClassLoader.class.getDeclaredField("pathList");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(classLoader);
                Field declaredField2 = obj.getClass().getDeclaredField("nativeLibraryDirectories");
                declaredField2.setAccessible(true);
                for (String str2 : (String[]) declaredField2.get(obj)) {
                    File file2 = new File(str2, System.mapLibraryName("apminsightb"));
                    if (file2.exists()) {
                        M.a.k(file2, file);
                        i.j(file.getAbsolutePath());
                        return null;
                    }
                }
                return "not_found";
            } catch (Throwable th) {
                return th.getMessage();
            }
        }
        return null;
    }

    public static String b(File file, String str) throws IOException {
        InputStream inputStream;
        ZipFile zipFile;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            zipFile = new ZipFile(new File(str), 1);
            try {
                StringBuilder sb = new StringBuilder("lib/");
                String str2 = Build.CPU_ABI;
                sb.append(str2);
                sb.append("/");
                sb.append(System.mapLibraryName("apminsightb"));
                ZipEntry entry = zipFile.getEntry(sb.toString());
                if (entry == null) {
                    int iIndexOf = str2.indexOf(45);
                    StringBuilder sb2 = new StringBuilder("lib/");
                    if (iIndexOf <= 0) {
                        iIndexOf = str2.length();
                    }
                    sb2.append(str2.substring(0, iIndexOf));
                    sb2.append("/");
                    sb2.append(System.mapLibraryName("apminsightb"));
                    String string = sb2.toString();
                    ZipEntry entry2 = zipFile.getEntry(string);
                    if (entry2 == null) {
                        String str3 = "Library entry not found:" + string;
                        try {
                            zipFile.close();
                        } catch (IOException unused) {
                        }
                        return str3;
                    }
                    entry = entry2;
                }
                file.createNewFile();
                inputStream = zipFile.getInputStream(entry);
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            zipFile = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, i);
            }
            i.j(file.getAbsolutePath());
            i.i(fileOutputStream);
            i.i(inputStream);
            try {
                zipFile.close();
            } catch (IOException unused2) {
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream2 = fileOutputStream;
            try {
                String message = th.getMessage();
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException unused3) {
                    }
                }
                return message;
            } finally {
                i.i(fileOutputStream2);
                i.i(inputStream);
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException unused4) {
                    }
                }
            }
        }
    }
}
