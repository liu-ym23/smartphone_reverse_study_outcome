package r3;

import com.baidu.platform.comapi.bmsdk.BmLocated;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f14090a;

    static {
        f14090a = System.getProperty("org.tensorflow.NativeLibrary.DEBUG") != null;
    }

    public static String a(InputStream inputStream) throws IOException {
        String strMapLibraryName = System.mapLibraryName("tensorflow_jni");
        int iIndexOf = strMapLibraryName.indexOf(".");
        File fileCreateTempFile = File.createTempFile(iIndexOf < 0 ? strMapLibraryName : strMapLibraryName.substring(0, iIndexOf), iIndexOf < 0 ? null : strMapLibraryName.substring(iIndexOf));
        String absolutePath = fileCreateTempFile.getAbsolutePath();
        fileCreateTempFile.deleteOnExit();
        b("extracting native library to: " + absolutePath);
        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
        try {
            byte[] bArr = new byte[BmLocated.ALIGN_TOP];
            long j4 = 0;
            while (true) {
                int i4 = inputStream.read(bArr);
                if (i4 < 0) {
                    fileOutputStream.close();
                    inputStream.close();
                    b(String.format("copied %d bytes to %s", Long.valueOf(j4), absolutePath));
                    return absolutePath;
                }
                fileOutputStream.write(bArr, 0, i4);
                j4 += i4;
            }
        } catch (Throwable th) {
            fileOutputStream.close();
            inputStream.close();
            throw th;
        }
    }

    public static void b(String str) {
        if (f14090a) {
            System.err.println("org.tensorflow.NativeLibrary: " + str);
        }
    }

    public static String c() {
        String lowerCase = System.getProperty("os.name").toLowerCase();
        return lowerCase.contains("linux") ? "linux" : (lowerCase.contains("os x") || lowerCase.contains("darwin")) ? "darwin" : lowerCase.contains("windows") ? "windows" : lowerCase.replaceAll("\\s", "");
    }
}
