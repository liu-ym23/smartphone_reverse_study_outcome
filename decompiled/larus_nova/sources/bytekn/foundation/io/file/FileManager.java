package bytekn.foundation.io.file;

import android.util.Base64;
import androidx.camera.video.AudioStats;
import bytekn.foundation.logger.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class FileManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21782a = null;

    public FileManager() {
    }

    static {
        f21782a = File.separator;
    }

    public static d a(final File r110) {
        return new d(r110.getName(), new f(r110.getAbsolutePath()), new f(r110.getCanonicalPath()), Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), Double.valueOf(r110.lastModified()), Long.valueOf(r110.length()), new FileManager$buildStats$fileType$1(r110).invoke());
    }

    public static void b(g r100) {
        r100.close();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean c(f r100) {
        if (r100 == null) goto L7;
        String r101 = r100.f21799b;
        if (r101 != null) goto L6;
        return false;
    L6:
        return d(r101);
    L7:
        return false;
    }

    public static boolean d(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return false;
    L12:
        return new PolarisFileWrapper(r100).getAbsoluteFile().exists();
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static String e(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return new PolarisFileWrapper(r100).getName();
    }

    public static List f(String r110) {
        if (r110 == null) goto L29;
        File r111 = new PolarisFileWrapper(r110).getAbsoluteFile();
        if (r111 == null) goto L29;
        if (r111.exists() == false) goto L29;
        if (r111.isDirectory() == false) goto L12;
        ArrayList r100 = new ArrayList();
        File[] r112 = r111.listFiles();
        if (r112 == null) goto L28;
        ArrayList r101 = new ArrayList(r112.length);
        int r102 = r112.length;
        int r103 = 0;
    L16:
        if (r103 >= r102) goto L28;
        File r104 = r112[r103];
        if (r104.isDirectory() == true) goto L20;
        Object r105 = Boolean.valueOf(r100.add(r104.getAbsolutePath()));
    L27:
        r101.add(r105);
        r103 = r103 + 1;
        goto L16
    L20:
        if (StringsKt.contains$default(r104.getName(), "__MACOSX", false, 2, null) == true) goto L25;
        List r106 = f(r104.getAbsolutePath());
        if (r106 == null) goto L24;
        r105 = Boolean.valueOf(r100.addAll(r106));
        goto L27
    L24:
        r105 = null;
        goto L27
    L25:
        r105 = Unit.INSTANCE;
    L28:
        return r100;
    L12:
        return CollectionsKt.emptyList();
    L29:
        return null;
    }

    public static String g(String r100) {
        if (r100 == null) goto L9;
        int r101 = StringsKt.lastIndexOf$default(r100, f21782a, 0, false, 6, null);
        if (r101 >= 0) goto L8;
        return null;
    L8:
        return r100.substring(r101 + 1, r100.length());
    L9:
        return null;
    }

    public static String h(b r100) {
        final ContentEncoding r101 = ContentEncoding.Utf8;
        InputStream r102 = r100.f21786a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputStream");
    L5:
        InputStreamReader r103 = new InputStreamReader(r102, new FileManager$contentEncoding2Charset$charset$1(r101).invoke().name());
        StringWriter r104 = new StringWriter();     // Catch: Throwable -> L13
        char[] r105 = new char[1024];     // Catch: Throwable -> L13
        int r106 = r103.read(r105);     // Catch: Throwable -> L13
    L8:
        if (r106 == (-1)) goto L10;
        r104.write(r105, 0, r106);     // Catch: Throwable -> L13
        r106 = r103.read(r105);     // Catch: Throwable -> L13
        goto L8
    L10:
        String r107 = r104.toString();     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r103, null);
        return r107;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    }

    public static void i(String r100) {
        new PolarisFileWrapper(r100).getAbsoluteFile().mkdirs();
    }

    public static b j(String r100) {
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r100).getAbsoluteFile());
        b r102 = new b();
        r102.f21786a = r101;
        return r102;
    }

    public static List m(String r100) {
        File[] r101 = new PolarisFileWrapper(r100).getAbsoluteFile().listFiles();
        if (r101 == null) goto L7;
        ArrayList r102 = new ArrayList(r101.length);
        int r103 = r101.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L10;
        r102.add(a(r101[r104]));
        r104 = r104 + 1;
        goto L5
    L10:
        return r102;
    L7:
        return null;
    }

    public static boolean n(f r100) {
        if (r100 == null) goto L7;
        String r101 = r100.f21799b;
        if (r101 != null) goto L6;
        return false;
    L6:
        return o(r101);
    L7:
        return false;
    }

    public static boolean o(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L5;
    L7:
        return false;
    L5:
        if (FilesKt.deleteRecursively(r101.getAbsoluteFile()) == false) goto L7;
        return true;
    }

    public static e k(f r100, boolean r101) {
        if (r100 == null) goto L7;
        String r102 = r100.f21799b;
        if (r102 != null) goto L6;
        return null;
    L6:
        return l(r102, r101);
    L7:
        return null;
    }

    public static e l(String r100, boolean r101) {
        PolarisFileOutputStreamWrapper r102 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r100).getAbsoluteFile(), r101);
        e r103 = new e();
        r103.f21797a = r102;
        return r103;
    }

    public static boolean p(f r100, f r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        if (c(r101) == false) goto L8;
        n(r101);
    L8:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.f21799b);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101.f21799b);
        if (r102.exists() == true) goto L12;
        return false;
    L12:
        return r102.renameTo(r103);
    L13:
        return false;
    }

    public static boolean q(final String r100, final String r101) {
        return s(r100, r101, new FileManager$unzip$1(r100, r101));
    }

    public static boolean r(String r100, String r101) {
        t(r100, r101);     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        String r102 = g(r100);
        if (r102 == null) goto L19;
        Logger.e$default(Logger.INSTANCE, "JKL", "[Unzip][B][File: " + r102 + "][" + bytekn.foundation.utils.b.a(e, 3) + ']', null, 4, null);
    L19:
        return s(r100, r101, null);
    L12:
        e = move-exception;
        String r103 = e.getMessage();
        if (r103 != null) goto L18;
        r103 = "Unzip Failed";
    L18:
        throw new UnzipException(r103);
    }

    public static void t(String r110, String r111) {
        String r100 = g(r110);
        if (r100 == null) goto L5;
        Logger.INSTANCE.d("JKL", "[Unzip][B][File: " + r100 + ']');
    L5:
        PolarisZipFileWrapper r101 = new PolarisZipFileWrapper(r110);
        PolarisFileWrapper r112 = new PolarisFileWrapper(r111);
        if (r112.exists() == false) goto L8;
        o(r112.getAbsolutePath());
    L8:
        Enumeration<? extends ZipEntry> r113 = r101.entries();
        byte[] r102 = new byte[8192];
    L10:
        if (r113.hasMoreElements() == false) goto L32;
        ZipEntry r103 = r113.nextElement();
        PolarisFileWrapper r104 = new PolarisFileWrapper(r112, r103.getName());
        String r105 = r103.getName();
        if (r105 != null) goto L14;
    L16:
        boolean r106 = false;
    L17:
        if (r106 == false) goto L10;
        if (r103.isDirectory() == true) goto L21;
        if (r104.getParentFile() != null) goto L25;
    L27:
        InputStream r107 = r101.getInputStream(r103);
        BufferedOutputStream r108 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r104));
    L28:
        int r109 = r107.read(r102);
        if (r109 == (-1)) goto L31;
        r108.write(r102, 0, r109);
        goto L28
    L31:
        r107.close();
        r108.close();
        goto L10
    L25:
        if (r104.getParentFile().exists() == true) goto L27;
        r104.getParentFile().mkdirs();
        goto L27
    L21:
        r104.mkdirs();
        goto L10
    L14:
        if (StringsKt.contains$default(r105, "../", false, 2, null) == true) goto L16;
        r106 = true;
        goto L17
    L32:
        if (r100 == null) goto L44;
        Logger.INSTANCE.d("JKL", "[Unzip][B][End][File: " + r100 + "][Suc]");
        return;
    }

    public static void u(String r100, String r101) {
        ContentEncoding r102 = ContentEncoding.Utf8;
        File r103 = new PolarisFileWrapper(r100).getAbsoluteFile();
        if (r103.exists() == true) goto L9;
        File r104 = r103.getParentFile();
        if (r104.exists() == true) goto L7;
        r104.mkdirs();
    L7:
        r103.createNewFile();
    L9:
        if (r102 != ContentEncoding.Base64) goto L16;
        Charset r105 = Charsets.UTF_8;
        if (r101 == null) goto L14;
        r101 = Base64.encodeToString(r101.getBytes(r105), 0);
    L40:
        OutputStreamWriter r106 = new OutputStreamWriter(new PolarisFileOutputStreamWrapper(r103, false));     // Catch: Exception -> L31
        r106.write(r101);     // Catch: Throwable -> L26
        r106.flush();     // Catch: Throwable -> L26
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L24:
        CloseableKt.closeFinally(r106, null);     // Catch: Exception -> L31
        r101.length();     // Catch: Exception -> L31
        return;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);     // Catch: Exception -> L31
        throw th;     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L16:
        if (c.f21788b[r102.ordinal()] != 1) goto L40;
        Charset r108 = Charsets.UTF_8;
        if (r101 == null) goto L35;
        r101 = new String(r101.getBytes(r108), Charsets.US_ASCII);
        goto L40
    L35:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static boolean s(String r110, String r111, Function0 r112) {
        String r100 = g(r110);
        if (r100 == null) goto L5;
        Logger.INSTANCE.d("JKL", "[Unzip][A][Start][File: " + r100 + ']');
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r111);
        if (r101.exists() == false) goto L8;
        o(r101.getAbsolutePath());
    L8:
        boolean r113 = false;
        ZipInputStream r102 = null;
        String r103 = r101.getCanonicalPath();     // Catch: Throwable -> L46 Exception -> L48
        ZipInputStream r104 = new ZipInputStream(new BufferedInputStream(new PolarisFileInputStreamWrapper(r110)));     // Catch: Throwable -> L46 Exception -> L48
        ZipEntry r114 = r104.getNextEntry();     // Catch: Throwable -> L42 Exception -> L44
    L11:
        if (r114 == null) goto L35;
        String r105 = r114.getName();     // Catch: Throwable -> L42 Exception -> L44
        if (StringsKt.contains$default(r105, "../", false, 2, null) == true) goto L14;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r101, r105);     // Catch: Throwable -> L42 Exception -> L44
        if (StringsKt.startsWith$default(r106.getCanonicalPath(), r103, false, 2, null) == false) goto L34;
        if (r114.isDirectory() == true) goto L19;
        File r115 = r106.getParentFile();     // Catch: Throwable -> L42 Exception -> L44
        if (r115 == null) goto L26;
        if (r115.exists() == true) goto L26;
        r115.mkdirs();     // Catch: Throwable -> L42 Exception -> L44
    L28:
        BufferedOutputStream r116 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r106));     // Catch: Throwable -> L42 Exception -> L44
        Ref.IntRef r107 = new Ref.IntRef();     // Catch: Throwable -> L42 Exception -> L44
        byte[] r108 = new byte[8192];     // Catch: Throwable -> L42 Exception -> L44
    L29:
        int r117 = r104.read(r108);     // Catch: Throwable -> L42 Exception -> L44
        r107.element = r117;     // Catch: Throwable -> L42 Exception -> L44
        if (r117 == (-1)) goto L32;
        r116.write(r108, 0, r117);     // Catch: Throwable -> L42 Exception -> L44
        goto L29
    L32:
        r116.flush();     // Catch: Throwable -> L42 Exception -> L44
        r116.close();     // Catch: Throwable -> L42 Exception -> L44
        r104.closeEntry();     // Catch: Throwable -> L42 Exception -> L44
        r114 = r104.getNextEntry();     // Catch: Throwable -> L42 Exception -> L44
    L26:
        if (r106.exists() == false) goto L28;
        r106.delete();     // Catch: Throwable -> L42 Exception -> L44
        goto L28
    L19:
        r106.mkdirs();     // Catch: Throwable -> L42 Exception -> L44
        r114 = r104.getNextEntry();     // Catch: Throwable -> L42 Exception -> L44
        goto L11
    L34:
        throw new UnzipException("Entry is outside of the target dir: " + r114.getName());     // Catch: Throwable -> L42 Exception -> L44
    L14:
        r104.closeEntry();     // Catch: Throwable -> L42 Exception -> L44
        r114 = r104.getNextEntry();     // Catch: Throwable -> L42 Exception -> L44
        goto L11
    L35:
        if (r100 == null) goto L82;
        Logger.INSTANCE.d("JKL", "[Unzip][A][End][File: " + r100 + "][Suc]");     // Catch: Throwable -> L42 Exception -> L44
    L82:
        r104.close();     // Catch: Exception -> L39
    L41:
        return true;
    L39:
        e = move-exception;
        e.printStackTrace();
    L44:
        e = e;
        r102 = r104;
    L49:
        if (r112 == null) goto L68;
        if (r100 != null) goto L80;
    L52:
        r112.invoke();     // Catch: Throwable -> L46 Exception -> L54
        r113 = true;
        goto L68
    L54:
        e = move-exception;
        String r118 = e.getMessage();     // Catch: Throwable -> L46
        if (r118 != null) goto L60;
        r118 = "";
    L60:
        throw new UnzipException(r118);     // Catch: Throwable -> L46
    L80:
        Logger.e$default(Logger.INSTANCE, "JKL", "[Unzip][A][File: " + r100 + "][" + bytekn.foundation.utils.b.a(e, 3) + ']', null, 4, null);     // Catch: Throwable -> L46 Exception -> L54
    L68:
        if (r102 != null) goto L78;
    L73:
        return r113;
    L78:
        r102.close();     // Catch: Exception -> L71
    L71:
        e = move-exception;
        e.printStackTrace();
    L42:
        th = th;
    L62:
        if (r104 != null) goto L76;
    L67:
        throw th;
    L76:
        r104.close();     // Catch: Exception -> L65
    L65:
        e = move-exception;
        e.printStackTrace();
    L48:
        e = e;
    L46:
        th = th;
        r104 = r102;
        goto L62
    }
}
