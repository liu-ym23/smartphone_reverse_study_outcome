package kotlin.io.path;

import java.nio.file.Path;
import java.util.Iterator;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f21145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f21146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f21147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Iterator f21148d;

    public e(Path r10, Object r11, e r12) {
        q.g(r10, "path");
        this.f21145a = r10;
        this.f21146b = r11;
        this.f21147c = r12;
    }

    public final Iterator a() {
        return this.f21148d;
    }

    public final Object b() {
        return this.f21146b;
    }

    public final e c() {
        return this.f21147c;
    }

    public final Path d() {
        return this.f21145a;
    }

    public final void e(Iterator r10) {
        this.f21148d = r10;
    }
}
