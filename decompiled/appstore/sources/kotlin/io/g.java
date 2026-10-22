package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g extends f {
    public static final File a(File r10, File r11, boolean r12, int r13) {
        q.g(r10, "<this>");
        q.g(r11, "target");
        if (r10.exists() == false) goto L43;
        if (r11.exists() == false) goto L15;
        if (r12 == false) goto L13;
        if (r11.delete() == true) goto L15;
        throw new FileAlreadyExistsException(r10, r11, "Tried to overwrite the destination, but failed to delete it.");
    L13:
        throw new FileAlreadyExistsException(r10, r11, "The destination file already exists.");
    L15:
        if (r10.isDirectory() == true) goto L17;
        File r14 = r11.getParentFile();
        if (r14 == null) goto L24;
        r14.mkdirs();
    L24:
        FileInputStream r15 = new FileInputStream(r10);
        FileOutputStream r16 = new FileOutputStream(r11);     // Catch: Throwable -> L31
        a.a(r15, r16, r13);     // Catch: Throwable -> L33
    L28:
        b.a(r16, null);     // Catch: Throwable -> L31
        b.a(r15, null);
    L30:
        return r11;
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        b.a(r16, th);     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        b.a(r15, th);
        throw th;
    L17:
        if (r11.mkdirs() == true) goto L30;
        throw new FileSystemException(r10, r11, "Failed to create target directory.");
    L43:
        throw new NoSuchFileException(r10, null, "The source file doesn't exist.", 2, null);
    }

    public static /* synthetic */ File b(File r10, File r11, boolean r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = false;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = 8192;
    L9:
        return a(r10, r11, r12, r13);
    }

    public static String c(File r10) {
        q.g(r10, "<this>");
        String r11 = r10.getName();
        q.f(r11, "getName(...)");
        return StringsKt__StringsKt.v0(r11, '.', "");
    }
}
