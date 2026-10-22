package wb;

import java.io.File;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final File f13653a;

    /* renamed from: b, reason: collision with root package name */
    public final List<File> f13654b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(File file, List<? extends File> segments) {
        g.f(segments, "segments");
        this.f13653a = file;
        this.f13654b = segments;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return g.b(this.f13653a, bVar.f13653a) && g.b(this.f13654b, bVar.f13654b);
    }

    public final int hashCode() {
        return this.f13654b.hashCode() + (this.f13653a.hashCode() * 31);
    }

    public final String toString() {
        return "FilePathComponents(root=" + this.f13653a + ", segments=" + this.f13654b + ')';
    }
}
