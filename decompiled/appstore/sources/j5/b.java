package j5;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import i5.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List f20905a;

    static {
        f20905a = new ArrayList();
    }

    public static File a(Context r10, String r11) {
        String r12 = System.mapLibraryName(r11);
        File r13 = b(r10);
        if (r13 != null) goto L5;
        return null;
    L5:
        return new File(r13, r12);
    }

    public static File b(Context r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.getFilesDir() == null) goto L12;
        File r11 = new File(r10.getFilesDir(), "libso");
        if (r11.exists() == true) goto L9;
        d.a(r11.getAbsolutePath());
    L9:
        return r11;
    L12:
        return null;
    }

    public static synchronized boolean c(Context r10, String r11) {
        monitor-enter(b.class);
    L23:
        th = move-exception;
        throw th;
    L6:
        if (f20905a.contains(r11) == false) goto L40;
        monitor-exit(b.class);
        return true;
    L40:
        System.loadLibrary(r11);     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L14
        f20905a.add(r11);     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L14
    L31:
        monitor-exit(b.class);
        return true;
    L12:
        e = move-exception;
        File r12 = a(r10, r11);     // Catch: Throwable -> L23
        if (r12 != null) goto L21;
        return false;
    L21:
        if (r12.exists() == false) goto L25;
        r12.delete();     // Catch: Throwable -> L23
    L25:
        String r13 = d(r10, r11, r12);     // Catch: Throwable -> L23
        if (r13 == null) goto L37;
        Log.e("loadLibrary", e.getMessage() + "[" + r13 + "]");     // Catch: Throwable -> L23
        return false;
    L37:
        System.load(r12.getAbsolutePath());     // Catch: Throwable -> L33
        f20905a.add(r11);     // Catch: Throwable -> L33
    L34:
        return false;
    L15:
        return false;
    }

    public static String d(Context r10, String r11, File r12) {
        FileOutputStream r13 = null;
        ZipFile r14 = new ZipFile(new File(r10.getApplicationInfo().sourceDir), 1);     // Catch: Throwable -> L33
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L16
        r15.append("lib/");     // Catch: Throwable -> L16
        String r16 = Build.CPU_ABI;     // Catch: Throwable -> L16
        r15.append(r16);     // Catch: Throwable -> L16
        r15.append(LibrarianImpl.Constants.SEPARATOR);     // Catch: Throwable -> L16
        r15.append(System.mapLibraryName(r11));     // Catch: Throwable -> L16
        ZipEntry r17 = r14.getEntry(r15.toString());     // Catch: Throwable -> L16
        if (r17 != null) goto L19;
        int r18 = r16.indexOf(45);     // Catch: Throwable -> L16
        StringBuilder r19 = new StringBuilder();     // Catch: Throwable -> L16
        r19.append("lib/");     // Catch: Throwable -> L16
        if (r18 > 0) goto L10;
        r18 = r16.length();     // Catch: Throwable -> L16
    L10:
        r19.append(r16.substring(0, r18));     // Catch: Throwable -> L16
        r19.append(LibrarianImpl.Constants.SEPARATOR);     // Catch: Throwable -> L16
        r19.append(System.mapLibraryName(r11));     // Catch: Throwable -> L16
        String r20 = r19.toString();     // Catch: Throwable -> L16
        ZipEntry r21 = r14.getEntry(r20);     // Catch: Throwable -> L16
        if (r21 != null) goto L18;
        String r22 = "Library entry not found:" + r20;     // Catch: Throwable -> L16
        d.b(null);
        d.b(null);
    L14:
        d.c(r14);
        return r22;
    L18:
        r17 = r21;
    L19:
        r12.createNewFile();     // Catch: Throwable -> L16
        InputStream r23 = r14.getInputStream(r17);     // Catch: Throwable -> L16
        FileOutputStream r24 = new FileOutputStream(r12);     // Catch: Throwable -> L31
        byte[] r25 = new byte[4096];     // Catch: Throwable -> L26
    L23:
        int r26 = r23.read(r25);     // Catch: Throwable -> L26
        if (r26 <= 0) goto L28;
        r24.write(r25, 0, r26);     // Catch: Throwable -> L26
        goto L23
    L28:
        d.d(r12.getAbsolutePath(), 493);     // Catch: Throwable -> L26
        d.b(r24);
        d.b(r23);
        d.c(r14);
        return null;
    L26:
        th = move-exception;
        r13 = r24;
        InputStream r27 = r23;
        th = th;
    L45:
        r22 = th.getMessage();     // Catch: Throwable -> L37
        d.b(r13);
        d.b(r27);
    L37:
        th = move-exception;
        d.b(r13);
        d.b(r27);
        d.c(r14);
        throw th;
    L31:
        th = move-exception;
        r27 = r23;
        th = th;
    L16:
        th = th;
        r27 = null;
    L33:
        th = th;
        r27 = null;
        r14 = null;
        goto L45
    }
}
