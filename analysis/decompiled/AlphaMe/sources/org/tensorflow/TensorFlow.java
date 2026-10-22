package org.tensorflow;

import B0.g;
import java.io.IOException;
import java.io.InputStream;
import r3.c;

/* loaded from: classes2.dex */
public abstract class TensorFlow {
    static {
        a();
    }

    public static void a() {
        boolean z4 = c.f14090a;
        try {
            try {
                version();
                c.b("isLoaded: true");
            } catch (UnsatisfiedLinkError e4) {
                c.b("tryLoadLibraryFailed: " + e4.getMessage());
                StringBuilder sb = new StringBuilder("org/tensorflow/native/");
                String strC = c.c();
                String lowerCase = System.getProperty("os.arch").toLowerCase();
                if (lowerCase.equals("amd64")) {
                    lowerCase = "x86_64";
                }
                sb.append(strC + "-" + lowerCase + "/");
                sb.append(System.mapLibraryName("tensorflow_jni"));
                String string = sb.toString();
                StringBuilder sb2 = new StringBuilder("resourceName: ");
                sb2.append(string);
                c.b(sb2.toString());
                InputStream resourceAsStream = c.class.getClassLoader().getResourceAsStream(string);
                if (resourceAsStream != null) {
                    try {
                        System.load(c.a(resourceAsStream));
                        return;
                    } catch (IOException e5) {
                        throw new UnsatisfiedLinkError(g.n("Unable to extract native library into a temporary file (", e5.toString(), ")"));
                    }
                }
                String strC2 = c.c();
                String lowerCase2 = System.getProperty("os.arch").toLowerCase();
                throw new UnsatisfiedLinkError("Cannot find TensorFlow native library for OS: " + strC2 + ", architecture: " + (lowerCase2.equals("amd64") ? "x86_64" : lowerCase2) + ". See https://github.com/tensorflow/tensorflow/tree/master/tensorflow/java/README.md for possible solutions (such as building the library from source). Additional information on attempts to find the native library can be obtained by adding org.tensorflow.NativeLibrary.DEBUG=1 to the system properties of the JVM.");
            }
        } catch (UnsatisfiedLinkError unused) {
            System.loadLibrary("tensorflow_jni");
        }
    }

    public static native String version();
}
