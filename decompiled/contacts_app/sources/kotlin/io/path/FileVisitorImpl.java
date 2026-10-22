package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileVisitorBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bw\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0016R$\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlin/io/path/FileVisitorImpl;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "onPreVisitDirectory", "Lkotlin/Function2;", "Ljava/nio/file/attribute/BasicFileAttributes;", "Ljava/nio/file/FileVisitResult;", "onVisitFile", "onVisitFileFailed", "Ljava/io/IOException;", "onPostVisitDirectory", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "postVisitDirectory", "dir", "exc", "preVisitDirectory", "attrs", "visitFile", "file", "visitFileFailed", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class FileVisitorImpl extends SimpleFileVisitor<Path> {
    private final Function2<Path, IOException, FileVisitResult> onPostVisitDirectory;
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onPreVisitDirectory;
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onVisitFile;
    private final Function2<Path, IOException, FileVisitResult> onVisitFileFailed;

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult postVisitDirectory(Object r1, IOException r2) {
        return postVisitDirectory((Path) r1, r2);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object r1, BasicFileAttributes r2) {
        return preVisitDirectory((Path) r1, r2);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object r1, BasicFileAttributes r2) {
        return visitFile((Path) r1, r2);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFileFailed(Object r1, IOException r2) {
        return visitFileFailed((Path) r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileVisitorImpl(Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> r1, Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> r2, Function2<? super Path, ? super IOException, ? extends FileVisitResult> r3, Function2<? super Path, ? super IOException, ? extends FileVisitResult> r4) {
        this.onPreVisitDirectory = r1;
        this.onVisitFile = r2;
        this.onVisitFileFailed = r3;
        this.onPostVisitDirectory = r4;
    }

    public FileVisitResult preVisitDirectory(Path r2, BasicFileAttributes r3) {
        Intrinsics.checkNotNullParameter(r2, "dir");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        Function2<Path, BasicFileAttributes, FileVisitResult> r0 = this.onPreVisitDirectory;
        if (r0 == null) goto L6;
        FileVisitResult r1 = r0.invoke(r2, r3);
        if (r1 == null) goto L6;
        return r1;
    L6:
        FileVisitResult r4 = super.preVisitDirectory(r2, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "preVisitDirectory(...)");
        return r4;
    }

    public FileVisitResult visitFile(Path r2, BasicFileAttributes r3) {
        Intrinsics.checkNotNullParameter(r2, "file");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        Function2<Path, BasicFileAttributes, FileVisitResult> r0 = this.onVisitFile;
        if (r0 == null) goto L6;
        FileVisitResult r1 = r0.invoke(r2, r3);
        if (r1 == null) goto L6;
        return r1;
    L6:
        FileVisitResult r4 = super.visitFile(r2, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "visitFile(...)");
        return r4;
    }

    public FileVisitResult visitFileFailed(Path r2, IOException r3) {
        Intrinsics.checkNotNullParameter(r2, "file");
        Intrinsics.checkNotNullParameter(r3, "exc");
        Function2<Path, IOException, FileVisitResult> r0 = this.onVisitFileFailed;
        if (r0 == null) goto L6;
        FileVisitResult r1 = r0.invoke(r2, r3);
        if (r1 == null) goto L6;
        return r1;
    L6:
        FileVisitResult r4 = super.visitFileFailed(r2, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "visitFileFailed(...)");
        return r4;
    }

    public FileVisitResult postVisitDirectory(Path r2, IOException r3) {
        Intrinsics.checkNotNullParameter(r2, "dir");
        Function2<Path, IOException, FileVisitResult> r0 = this.onPostVisitDirectory;
        if (r0 == null) goto L6;
        FileVisitResult r1 = r0.invoke(r2, r3);
        if (r1 == null) goto L6;
        return r1;
    L6:
        FileVisitResult r4 = super.postVisitDirectory(r2, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "postVisitDirectory(...)");
        return r4;
    }
}
