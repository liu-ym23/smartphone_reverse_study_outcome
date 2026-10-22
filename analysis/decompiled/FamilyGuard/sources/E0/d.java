package E0;

import E0.a;
import java.io.File;

/* loaded from: classes.dex */
public class d implements a.InterfaceC0020a {

    /* renamed from: a, reason: collision with root package name */
    private final long f1283a;

    /* renamed from: b, reason: collision with root package name */
    private final a f1284b;

    public interface a {
        File a();
    }

    public d(a aVar, long j5) {
        this.f1283a = j5;
        this.f1284b = aVar;
    }

    @Override // E0.a.InterfaceC0020a
    public E0.a build() {
        File fileA = this.f1284b.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.mkdirs() || (fileA.exists() && fileA.isDirectory())) {
            return e.c(fileA, this.f1283a);
        }
        return null;
    }
}
