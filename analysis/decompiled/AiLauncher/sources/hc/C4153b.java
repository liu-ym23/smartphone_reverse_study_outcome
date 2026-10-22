package hc;

import com.fasterxml.jackson.core.JsonPointer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Random;

/* renamed from: hc.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4153b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f32982a = false;

    /* renamed from: b, reason: collision with root package name */
    public static String f32983b;

    /* renamed from: c, reason: collision with root package name */
    public static String f32984c;

    /* renamed from: hc.b$a */
    public class a implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        public final String f32985a = "jansi-" + C4153b.e();

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f32985a) && !str.endsWith(".lck");
        }
    }

    public static void a() {
        File[] fileArrListFiles = new File(d().getAbsolutePath()).listFiles(new a());
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (!new File(file.getAbsolutePath() + ".lck").exists()) {
                    try {
                        file.delete();
                    } catch (SecurityException e10) {
                        System.err.println("Failed to delete old native lib" + e10.getMessage());
                    }
                }
            }
        }
    }

    public static String b(InputStream inputStream, InputStream inputStream2) throws IOException {
        byte[] bArr = new byte[com.stepos.agentframework.chatui.longtext.b.THRESHOLD];
        byte[] bArr2 = new byte[com.stepos.agentframework.chatui.longtext.b.THRESHOLD];
        do {
            int iK = k(inputStream, bArr);
            int iK2 = k(inputStream2, bArr2);
            if (iK <= 0) {
                if (iK2 > 0) {
                    return "EOF on first stream but not second";
                }
                return null;
            }
            if (iK2 <= 0) {
                return "EOF on second stream but not first";
            }
            if (iK2 != iK) {
                return "Read size different (" + iK + " vs " + iK2 + ")";
            }
        } while (Arrays.equals(bArr, bArr2));
        return "Content differs";
    }

    public static boolean c(String str, String str2, String str3) throws IOException {
        InputStream resourceAsStream;
        String str4 = str + "/" + str2;
        String str5 = String.format("jansi-%s-%s-%s", e(), j(), str2);
        File file = new File(str3, str5);
        File file2 = new File(str3, str5 + ".lck");
        try {
            try {
                resourceAsStream = C4153b.class.getResourceAsStream(str4);
            } catch (IOException e10) {
                System.err.println(e10.getMessage());
            }
            try {
                if (!file2.exists()) {
                    new FileOutputStream(file2).close();
                }
                Files.copy(resourceAsStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
                file.deleteOnExit();
                file2.deleteOnExit();
                file.setReadable(true);
                file.setWritable(true);
                file.setExecutable(true);
                InputStream resourceAsStream2 = C4153b.class.getResourceAsStream(str4);
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        String strB = b(resourceAsStream2, fileInputStream);
                        if (strB != null) {
                            throw new RuntimeException(String.format("Failed to write a native library file at %s because %s", file, strB));
                        }
                        fileInputStream.close();
                        if (resourceAsStream2 != null) {
                            resourceAsStream2.close();
                        }
                        if (i(file)) {
                            f32984c = C4153b.class.getResource(str4).toExternalForm();
                            return true;
                        }
                        return false;
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            file.deleteOnExit();
            file2.deleteOnExit();
            throw th;
        }
    }

    public static File d() {
        return new File(System.getProperty("jansi.tmpdir", System.getProperty("java.io.tmpdir")));
    }

    public static String e() throws IOException {
        URL resource = C4153b.class.getResource("/org/fusesource/jansi/jansi.properties");
        String property = "unknown";
        if (resource != null) {
            try {
                Properties properties = new Properties();
                properties.load(resource.openStream());
                property = properties.getProperty("version", "unknown");
                return property.trim().replaceAll("[^0-9.]", "");
            } catch (IOException e10) {
                System.err.println(e10);
            }
        }
        return property;
    }

    public static boolean f(String str) {
        return C4153b.class.getResource(str) != null;
    }

    public static synchronized boolean g() {
        if (!f32982a) {
            Thread thread = new Thread(new Runnable() { // from class: hc.a
                @Override // java.lang.Runnable
                public final void run() {
                    C4153b.a();
                }
            }, "cleanup");
            thread.setPriority(1);
            thread.setDaemon(true);
            thread.start();
        }
        try {
            h();
        } catch (Exception e10) {
            if (!Boolean.parseBoolean(System.getProperty("jansi.graceful", "true"))) {
                throw new RuntimeException("Unable to load jansi native library. You may want set the `jansi.graceful` system property to true to be able to use Jansi on your platform", e10);
            }
        }
        return f32982a;
    }

    public static void h() throws Exception {
        if (f32982a) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        String property = System.getProperty("library.jansi.path");
        String property2 = System.getProperty("library.jansi.name");
        if (property2 == null) {
            property2 = System.mapLibraryName("jansi");
            if (property2.endsWith(".dylib")) {
                property2 = property2.replace(".dylib", ".jnilib");
            }
        }
        if (property != null) {
            String str = property + "/" + C4154c.c();
            if (i(new File(str, property2))) {
                f32982a = true;
                return;
            }
            linkedList.add(str);
            if (i(new File(property, property2))) {
                f32982a = true;
                return;
            }
            linkedList.add(property);
        }
        String str2 = String.format("/%s/native/%s", C4153b.class.getPackage().getName().replace('.', JsonPointer.SEPARATOR), C4154c.c());
        if (f(str2 + "/" + property2)) {
            if (c(str2, property2, d().getAbsolutePath())) {
                f32982a = true;
                return;
            }
            linkedList.add(str2);
        }
        for (String str3 : System.getProperty("java.library.path", "").split(File.pathSeparator)) {
            if (!str3.isEmpty()) {
                if (i(new File(str3, property2))) {
                    f32982a = true;
                    return;
                }
                linkedList.add(str3);
            }
        }
        throw new Exception(String.format("No native library found for os.name=%s, os.arch=%s, paths=[%s]", C4154c.d(), C4154c.a(), String.join(File.pathSeparator, linkedList)));
    }

    public static boolean i(File file) {
        if (file.exists()) {
            try {
                String absolutePath = file.getAbsolutePath();
                System.load(absolutePath);
                f32983b = absolutePath;
                return true;
            } catch (UnsatisfiedLinkError e10) {
                if (file.canExecute()) {
                    System.err.printf("Failed to load native library:%s. osinfo: %s%n", file.getName(), C4154c.c());
                } else {
                    System.err.printf("Failed to load native library:%s. The native library file at %s is not executable, make sure that the directory is mounted on a partition without the noexec flag, or set the jansi.tmpdir system property to point to a proper location.  osinfo: %s%n", file.getName(), file, C4154c.c());
                }
                System.err.println(e10);
            }
        }
        return false;
    }

    public static String j() {
        return Long.toHexString(new Random().nextLong());
    }

    public static int k(InputStream inputStream, byte[] bArr) throws IOException {
        int length = bArr.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = inputStream.read(bArr, i10, length - i10);
            if (i11 <= 0) {
                break;
            }
            i10 += i11;
        }
        return i10;
    }
}
