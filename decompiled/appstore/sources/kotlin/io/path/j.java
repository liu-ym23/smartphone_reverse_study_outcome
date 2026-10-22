package kotlin.io.path;

import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j extends i {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21152a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f21153b = null;

        static {
            int[] r10 = new int[CopyActionResult.values().length];
            r10[CopyActionResult.CONTINUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r10[CopyActionResult.TERMINATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r10[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            f21152a = r10;
            int[] r11 = new int[OnErrorResult.values().length];
            r11[OnErrorResult.TERMINATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r11[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            f21153b = r11;
        }
    }

    public static final /* synthetic */ FileVisitResult a(Function3 r10, Path r11, Path r12, Function3 r13, Path r14, BasicFileAttributes r15) {
        return c(r10, r11, r12, r13, r14, r15);
    }

    public static final /* synthetic */ FileVisitResult b(Function3 r10, Path r11, Path r12, Path r13, Exception r14) {
        return e(r10, r11, r12, r13, r14);
    }

    public static final FileVisitResult c(Function3 r10, Path r11, Path r12, Function3 r13, Path r14, BasicFileAttributes r15) {
        return m((CopyActionResult) r10.invoke(kotlin.io.path.a.f21132a, r14, d(r11, r12, r14)));
    L4:
        e = move-exception;
        return e(r13, r11, r12, r14, e);
    }

    public static final Path d(Path r10, Path r11, Path r12) {
        Path r13 = r11.resolve(k.o(r12, r10).toString());
        q.f(r13, "resolve(...)");
        return r13;
    }

    public static final FileVisitResult e(Function3 r10, Path r11, Path r12, Path r13, Exception r14) {
        return n((OnErrorResult) r10.invoke(r13, d(r11, r12, r13), r14));
    }

    public static final void f(Path r10) {
        q.g(r10, "<this>");
        List r11 = g(r10);
        if (r11.isEmpty() == true) goto L9;
        FileSystemException r12 = new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
        Iterator r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        kotlin.a.a(r12, (Exception) r13.next());
        goto L6
    L8:
        throw r12;
    }

    public static final List g(Path r10) {
        boolean r11 = false;
        boolean r12 = true;
        c r13 = new c(0, 1, null);
        Path r14 = r10.getParent();
        if (r14 != null) goto L24;
    L20:
        if (r12 == false) goto L23;
        k(r10, r13);
    L23:
        return r13.d();
    L24:
        DirectoryStream<Path> r15 = Files.newDirectoryStream(r14);     // Catch: Throwable -> L6
    L7:
        if (r15 == null) goto L20;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        kotlin.io.b.a(r15, th);
        throw th;
    L9:
        if ((r15 instanceof SecureDirectoryStream) == false) goto L13;
        r13.f(r14);     // Catch: Throwable -> L11
        Path r16 = r10.getFileName();     // Catch: Throwable -> L11
        q.f(r16, "getFileName(...)");     // Catch: Throwable -> L11
        i((SecureDirectoryStream) r15, r16, r13);     // Catch: Throwable -> L11
    L14:
        Unit r17 = Unit.f21064a;     // Catch: Throwable -> L11
        kotlin.io.b.a(r15, null);
        r12 = r11;
        goto L20
    L13:
        r11 = true;
    L6:
        r15 = null;
        goto L7
    }

    public static final void h(SecureDirectoryStream r10, Path r11, c r12) {
        SecureDirectoryStream r13 = r10.newDirectoryStream(r11, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});     // Catch: Exception -> L5 NoSuchFileException -> L7
    L8:
        if (r13 == null) goto L31;
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L13
    L11:
        if (r14.hasNext() == false) goto L15;
        Path r15 = ((Path) r14.next()).getFileName();     // Catch: Throwable -> L13
        q.f(r15, "getFileName(...)");     // Catch: Throwable -> L13
        i(r13, r15, r12);     // Catch: Throwable -> L13
        goto L11
    L15:
        Unit r16 = Unit.f21064a;     // Catch: Throwable -> L13
        kotlin.io.b.a(r13, null);     // Catch: Exception -> L5
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        kotlin.io.b.a(r13, th);     // Catch: Exception -> L5
        throw th;     // Catch: Exception -> L5
    L31:
        return;
    L5:
        e = move-exception;
        r12.a(e);
        return;
    L7:
        r13 = null;
        goto L8
    }

    public static final void i(SecureDirectoryStream r10, Path r11, c r12) {
        r12.b(r11);
    L8:
        e = move-exception;
        r12.a(e);
    L13:
        r12.c(r11);
        return;
    L17:
        if (l(r10, r11, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}) == false) goto L10;
        int r13 = r12.e();     // Catch: Exception -> L8
        h(r10, r11, r12);     // Catch: Exception -> L8
        if (r13 != r12.e()) goto L19;
        r10.deleteDirectory(r11);     // Catch: Exception -> L8 NoSuchFileException -> L15
        Unit r14 = Unit.f21064a;     // Catch: Exception -> L8 NoSuchFileException -> L15
    L16:
    L19:
        goto L13
    L10:
        r10.deleteFile(r11);     // Catch: Exception -> L8 NoSuchFileException -> L15
        Unit r15 = Unit.f21064a;     // Catch: Exception -> L8 NoSuchFileException -> L15
        goto L16
    }

    public static final void j(Path r10, c r11) {
        DirectoryStream<Path> r12 = Files.newDirectoryStream(r10);     // Catch: Exception -> L5 NoSuchFileException -> L7
    L8:
        if (r12 == null) goto L31;
        Iterator<Path> r13 = r12.iterator();     // Catch: Throwable -> L13
    L11:
        if (r13.hasNext() == false) goto L15;
        Path r14 = r13.next();     // Catch: Throwable -> L13
        q.d(r14);     // Catch: Throwable -> L13
        k(r14, r11);     // Catch: Throwable -> L13
        goto L11
    L15:
        Unit r15 = Unit.f21064a;     // Catch: Throwable -> L13
        kotlin.io.b.a(r12, null);     // Catch: Exception -> L5
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        kotlin.io.b.a(r12, th);     // Catch: Exception -> L5
        throw th;     // Catch: Exception -> L5
    L31:
        return;
    L5:
        e = move-exception;
        r11.a(e);
        return;
    L7:
        r12 = null;
        goto L8
    }

    public static final void k(Path r10, c r11) {
    L7:
        e = move-exception;
        r11.a(e);
        return;
    L3:
        if (Files.isDirectory(r10, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L9;
        int r12 = r11.e();     // Catch: Exception -> L7
        j(r10, r11);     // Catch: Exception -> L7
        if (r12 != r11.e()) goto L13;
        Files.deleteIfExists(r10);     // Catch: Exception -> L7
    L13:
        return;
    L9:
        Files.deleteIfExists(r10);     // Catch: Exception -> L7
        goto L13
    }

    public static final boolean l(SecureDirectoryStream r10, Path r11, LinkOption... r12) {
        Boolean r13 = Boolean.valueOf(((BasicFileAttributeView) r10.getFileAttributeView(r11, BasicFileAttributeView.class, (LinkOption[]) Arrays.copyOf(r12, r12.length))).readAttributes().isDirectory());     // Catch: NoSuchFileException -> L4
    L5:
        if (r13 != null) goto L11;
        return false;
    L11:
        return r13.booleanValue();
    L4:
        r13 = null;
        goto L5
    }

    public static final FileVisitResult m(CopyActionResult r10) {
        int r11 = a.f21152a[r10.ordinal()];
        if (r11 == 1) goto L13;
        if (r11 == 2) goto L15;
        if (r11 != 3) goto L10;
        return FileVisitResult.SKIP_SUBTREE;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return FileVisitResult.TERMINATE;
    L13:
        return FileVisitResult.CONTINUE;
    }

    public static final FileVisitResult n(OnErrorResult r10) {
        int r11 = a.f21153b[r10.ordinal()];
        if (r11 == 1) goto L10;
        if (r11 != 2) goto L8;
        return FileVisitResult.SKIP_SUBTREE;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return FileVisitResult.TERMINATE;
    }
}
