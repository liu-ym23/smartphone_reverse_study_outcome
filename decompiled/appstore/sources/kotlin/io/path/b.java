package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends SimpleFileVisitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f21134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kotlin.collections.i f21135c;

    public b(boolean r10) {
        this.f21133a = r10;
        this.f21135c = new kotlin.collections.i();
    }

    public FileVisitResult a(Path r10, BasicFileAttributes r11) {
        q.g(r10, "dir");
        q.g(r11, "attrs");
        e r12 = new e(r10, r11.fileKey(), this.f21134b);
        this.f21135c.add(r12);
        FileVisitResult r13 = super.preVisitDirectory(r10, r11);
        q.f(r13, "preVisitDirectory(...)");
        return r13;
    }

    public final List b(e r10) {
        q.g(r10, "directoryNode");
        this.f21134b = r10;
        Files.walkFileTree(r10.d(), d.f21140a.b(this.f21133a), 1, this);
        this.f21135c.removeFirst();
        kotlin.collections.i r11 = this.f21135c;
        this.f21135c = new kotlin.collections.i();
        return r11;
    }

    public FileVisitResult c(Path r10, BasicFileAttributes r11) {
        q.g(r10, "file");
        q.g(r11, "attrs");
        e r12 = new e(r10, null, this.f21134b);
        this.f21135c.add(r12);
        FileVisitResult r13 = super.visitFile(r10, r11);
        q.f(r13, "visitFile(...)");
        return r13;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object r10, BasicFileAttributes r11) {
        return a((Path) r10, r11);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object r10, BasicFileAttributes r11) {
        return c((Path) r10, r11);
    }
}
