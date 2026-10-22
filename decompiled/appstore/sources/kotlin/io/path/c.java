package kotlin.io.path;

import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f21138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Path f21139d;

    public c(int r10) {
        this.f21136a = r10;
        this.f21138c = new ArrayList();
    }

    public final void a(Exception r10) {
        q.g(r10, "exception");
        this.f21137b++;
        if (this.f21138c.size() < this.f21136a) goto L5;
        return;
    L5:
        if (this.f21139d == null) goto L7;
        Throwable r11 = new FileSystemException(String.valueOf(this.f21139d)).initCause(r10);
        q.e(r11, "null cannot be cast to non-null type java.nio.file.FileSystemException");
        r10 = (FileSystemException) r11;
    L7:
        this.f21138c.add(r10);
    }

    public final void b(Path r10) {
        q.g(r10, "name");
        Path r11 = this.f21139d;
        if (r11 == null) goto L5;
        Path r12 = r11.resolve(r10);
    L6:
        this.f21139d = r12;
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void c(Path r10) {
        q.g(r10, "name");
        Path r11 = this.f21139d;
        Path r12 = null;
        if (r11 == null) goto L5;
        Path r13 = r11.getFileName();
    L7:
        if (q.b(r10, r13) == false) goto L14;
        Path r14 = this.f21139d;
        if (r14 == null) goto L11;
        r12 = r14.getParent();
    L11:
        this.f21139d = r12;
        return;
    L14:
        throw new IllegalArgumentException("Failed requirement.");
    L5:
        r13 = null;
        goto L7
    }

    public final List d() {
        return this.f21138c;
    }

    public final int e() {
        return this.f21137b;
    }

    public final void f(Path r10) {
        this.f21139d = r10;
    }

    public /* synthetic */ c(int r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = 64;
    L5:
        this(r10);
    }
}
