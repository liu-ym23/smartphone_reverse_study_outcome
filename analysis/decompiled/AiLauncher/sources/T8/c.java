package T8;

import io.objectbox.BoxStore;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Arrays;
import jc.C4791a;

/* loaded from: classes4.dex */
public class c {
    /* JADX WARN: Removed duplicated region for block: B:14:0x00e0  */
    static {
        /*
            Method dump skipped, instructions count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: T8.c.<clinit>():void");
    }

    public static void a(String str) throws IOException {
        String str2 = "/native/" + str;
        URL resource = c.class.getResource(str2);
        if (resource == null) {
            System.err.println("Not available in classpath: " + str2);
            return;
        }
        File file = new File(str);
        try {
            URLConnection uRLConnectionOpenConnection = resource.openConnection();
            int contentLength = uRLConnectionOpenConnection.getContentLength();
            long lastModified = uRLConnectionOpenConnection.getLastModified();
            if (file.exists() && file.length() == contentLength && file.lastModified() == lastModified) {
                return;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(uRLConnectionOpenConnection.getInputStream());
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    C4791a.a(bufferedInputStream, bufferedOutputStream);
                    C4791a.b(bufferedInputStream);
                    if (lastModified > 0) {
                        file.setLastModified(lastModified);
                    }
                } finally {
                    C4791a.b(bufferedOutputStream);
                }
            } catch (Throwable th) {
                C4791a.b(bufferedInputStream);
                throw th;
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public static void b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c() {
        /*
            java.lang.String r0 = "os.arch"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            java.lang.String r1 = "x64"
            java.lang.String r2 = "x86"
            r3 = 0
            if (r0 == 0) goto L9d
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r4 = "amd64"
            boolean r4 = r0.equalsIgnoreCase(r4)
            if (r4 != 0) goto L9c
            java.lang.String r4 = "x86_64"
            boolean r4 = r0.equalsIgnoreCase(r4)
            if (r4 == 0) goto L23
            goto L9c
        L23:
            boolean r4 = r0.equalsIgnoreCase(r2)
            if (r4 == 0) goto L2c
            r3 = r2
            goto L9d
        L2c:
            java.lang.String r4 = "aarch64"
            boolean r4 = r4.equals(r0)
            java.lang.String r5 = "arm64"
            if (r4 != 0) goto L9a
            java.lang.String r4 = "armv8"
            boolean r4 = r0.startsWith(r4)
            if (r4 != 0) goto L9a
            boolean r4 = r0.startsWith(r5)
            if (r4 == 0) goto L45
            goto L9a
        L45:
            java.lang.String r4 = "arm"
            boolean r5 = r0.startsWith(r4)
            if (r5 == 0) goto L9d
            java.lang.String r5 = "armv7"
            boolean r6 = r0.startsWith(r5)
            java.lang.String r7 = "armv6"
            if (r6 != 0) goto L7e
            java.lang.String r6 = "armeabi-v7"
            boolean r6 = r0.startsWith(r6)
            if (r6 == 0) goto L60
            goto L7e
        L60:
            boolean r6 = r0.startsWith(r7)
            if (r6 == 0) goto L68
        L66:
            r3 = r7
            goto L87
        L68:
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L87
            java.lang.String r4 = d()
            if (r4 == 0) goto L87
            java.lang.String r4 = r4.toLowerCase()
            boolean r6 = r4.startsWith(r5)
            if (r6 == 0) goto L80
        L7e:
            r3 = r5
            goto L87
        L80:
            boolean r4 = r4.startsWith(r7)
            if (r4 == 0) goto L87
            goto L66
        L87:
            if (r3 != 0) goto L9d
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.String r4 = d()
            java.lang.Object[] r4 = new java.lang.Object[]{r7, r0, r4}
            java.lang.String r5 = "[ObjectBox] 32-bit ARM os.arch unknown (will use %s), please report this to us: os.arch=%s, machine=%s%n"
            r3.printf(r5, r4)
            r3 = r7
            goto L9d
        L9a:
            r3 = r5
            goto L9d
        L9c:
            r3 = r1
        L9d:
            if (r3 != 0) goto Lca
            java.lang.String r3 = "sun.arch.data.model"
            java.lang.String r3 = java.lang.System.getProperty(r3)
            java.lang.String r4 = "64"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto Lae
            goto Lba
        Lae:
            java.lang.String r1 = "32"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto Lb8
            r1 = r2
            goto Lba
        Lb8:
            java.lang.String r1 = "unknown"
        Lba:
            java.io.PrintStream r2 = java.lang.System.err
            java.lang.String r4 = d()
            java.lang.Object[] r0 = new java.lang.Object[]{r1, r0, r3, r4}
            java.lang.String r3 = "[ObjectBox] os.arch unknown (will use %s), please report this to us: os.arch=%s, model=%s, machine=%s%n"
            r2.printf(r3, r0)
            return r1
        Lca:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: T8.c.c():java.lang.String");
    }

    public static String d() throws IOException {
        String line = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("uname -m").getInputStream(), Charset.defaultCharset()));
            line = bufferedReader.readLine();
            bufferedReader.close();
            return line;
        } catch (Exception unused) {
            return line;
        }
    }

    public static String e() {
        String[] strArr = null;
        try {
            strArr = (String[]) Class.forName("android.os.Build").getField("SUPPORTED_ABIS").get(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
        }
        return strArr != null ? Arrays.toString(strArr) : "";
    }

    public static boolean f() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (BoxStore.U() == null) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("android.content.Context");
            if (BoxStore.v0() == null) {
                Class.forName("com.getkeepsafe.relinker.ReLinker").getMethod("loadLibrary", cls, String.class, String.class).invoke(null, BoxStore.U(), "objectbox-jni", "5.0.0-2025-09-27");
                return true;
            }
            BoxStore.v0().getClass().getMethod("loadLibrary", cls, String.class, String.class).invoke(BoxStore.v0(), BoxStore.U(), "objectbox-jni", "5.0.0-2025-09-27");
            return true;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }
}
