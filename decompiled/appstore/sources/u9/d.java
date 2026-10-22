package u9;

import com.media.cache.model.VideoCacheInfo;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f24906a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Object f24907b;

    static {
        f24906a = Pattern.compile("GET /(.*) HTTP");
        f24907b = new Object();
    }

    public static String a(byte[] r10) {
        StringBuffer r11 = new StringBuffer();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        r11.append(String.format("%02x", new Object[]{Byte.valueOf(r10[r13])}));
        r13 = r13 + 1;
        goto L3
    L6:
        return r11.toString();
    }

    public static void b(Closeable r10) {
        if (r10 == null) goto L10;
        r10.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        o0.a.d("LocalProxyUtils close " + r10 + " failed, exception = " + e);
        return;
    }

    public static String c(String r10) {
        return a(MessageDigest.getInstance("MD5").digest(r10.getBytes()));
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static String d(String r10) {
        return URLDecoder.decode(r10, "UTF-8");
    L4:
        e = move-exception;
        o0.a.d("Encoding not supported, ignored: " + e.getMessage());
        return null;
    }

    public static String e(String r10) {
        return URLEncoder.encode(r10, "UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException("Error encoding url", e);
    }

    public static boolean f(char r10) {
        Character.UnicodeBlock r11 = Character.UnicodeBlock.of(r10);
        if (r11 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) goto L5;
        return true;
    L5:
        if (r11 != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) goto L7;
        return true;
    L7:
        if (r11 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) goto L9;
        return true;
    L9:
        if (r11 != Character.UnicodeBlock.GENERAL_PUNCTUATION) goto L11;
        return true;
    L11:
        if (r11 != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) goto L13;
        return true;
    L13:
        if (r11 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) goto L23;
        return false;
    L23:
        return true;
    }

    public static boolean g(float r10, float r11) {
        if (Math.abs(r10 - r11) >= 1.0E-4f) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean h(String r10) {
        char[] r11 = Pattern.compile("\\s*|t*|r*|n*").matcher(r10).replaceAll("").replaceAll("\\p{P}", "").trim().toCharArray();
        float r12 = r11.length;
        float r13 = 0.0f;
        int r14 = 0;
    L4:
        if (r14 >= r11.length) goto L12;
        char r15 = r11[r14];
        if (Character.isLetterOrDigit(r15) == true) goto L10;
        if (f(r15) == true) goto L10;
        r13 = r13 + 1.0f;
    L10:
        r14 = r14 + 1;
        goto L4
    L12:
        if (r12 > 0.0f) goto L15;
        return false;
    L15:
        if ((r13 / r12) <= 0.4d) goto L18;
        return true;
    L18:
        return false;
    }

    public static void i(File r10) {
        File r11 = new File(r10, "tempFile");
        if (r11.exists() == true) goto L5;
        r11.createNewFile();
        r11.delete();
        return;
    L5:
        r11.delete();
    }

    public static VideoCacheInfo j(File r10) {
        File r11 = new File(r10, "video.info");
        ObjectInputStream r12 = null;
        if (r11.exists() == true) goto L52;
        o0.a.c("readProxyCacheInfo failed, file not exist.");
        return null;
    L52:
        Object r13 = f24907b;     // Catch: Throwable -> L25 Exception -> L27
        monitor-enter(r13);     // Catch: Throwable -> L25 Exception -> L27
        ObjectInputStream r14 = new ObjectInputStream(new FileInputStream(r11));     // Catch: Throwable -> L17
        VideoCacheInfo r15 = (VideoCacheInfo) r14.readObject();     // Catch: Throwable -> L15
        monitor-exit(r13);     // Catch: Throwable -> L15
        r14.close();     // Catch: Exception -> L13
    L14:
        return r15;
    L13:
        o0.a.d("readProxyCacheInfo failed, close fis failed.");
    L17:
        th = th;
        ObjectInputStream r16 = null;
    L19:
        monitor-exit(r13);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L21 Exception -> L23
    L23:
        e = e;
    L29:
        o0.a.d("readProxyCacheInfo failed, exception=" + e.getMessage());     // Catch: Throwable -> L21
        if (r16 != null) goto L40;
    L34:
        return null;
    L40:
        r16.close();     // Catch: Exception -> L33
    L33:
        o0.a.d("readProxyCacheInfo failed, close fis failed.");
    L21:
        th = th;
        r12 = r16;
    L35:
        if (r12 != null) goto L47;
    L39:
        throw th;
    L47:
        r12.close();     // Catch: Exception -> L38
    L38:
        o0.a.d("readProxyCacheInfo failed, close fis failed.");
        goto L39
    L15:
        th = th;
    L27:
        e = e;
        r16 = null;
    L25:
        th = th;
        goto L35
    }

    public static void k(File r10) {
        if (r10.exists() == true) goto L5;
        return;
    L5:
        if (r10.setLastModified(System.currentTimeMillis()) == true) goto L9;
        i(r10);
        return;
    }

    public static void l(VideoCacheInfo r10, File r11) {
        File r12 = new File(r11, "video.info");
        ObjectOutputStream r13 = null;
        Object r14 = f24907b;     // Catch: Throwable -> L16 Exception -> L18
        monitor-enter(r14);     // Catch: Throwable -> L16 Exception -> L18
        ObjectOutputStream r15 = new ObjectOutputStream(new FileOutputStream(r12));     // Catch: Throwable -> L13
        r15.writeObject(r10);     // Catch: Throwable -> L11
        monitor-exit(r14);     // Catch: Throwable -> L11
        r15.close();     // Catch: Exception -> L10
        return;
    L11:
        th = th;
        r13 = r15;
    L14:
        monitor-exit(r14);     // Catch: Throwable -> L13
    L13:
        th = th;
        goto L14
    L15:
        throw th;     // Catch: Throwable -> L16 Exception -> L18
    L37:
        th = th;
    L10:
        o0.a.d("writeProxyCacheInfo failed, close fos failed.");
        return;
    L18:
        e = move-exception;
        o0.a.d("writeProxyCacheInfo failed, exception=" + e.getMessage());     // Catch: Throwable -> L16
        if (r13 == null) goto L41;
        r13.close();     // Catch: Exception -> L10
        return;
    L41:
        return;
    L16:
        th = move-exception;
        if (r13 != null) goto L28;
    L27:
        throw th;
    L28:
        r13.close();     // Catch: Exception -> L26
    L26:
        o0.a.d("writeProxyCacheInfo failed, close fos failed.");
        goto L27
    }
}
