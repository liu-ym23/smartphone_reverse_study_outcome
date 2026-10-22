package m5;

import java.io.File;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final File f3908a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3909b;

    public c(File file, List list) {
        this.f3908a = file;
        this.f3909b = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f3908a.equals(cVar.f3908a) && this.f3909b.equals(cVar.f3909b);
    }

    public final int hashCode() {
        return this.f3909b.hashCode() + (this.f3908a.hashCode() * 31);
    }

    public final String toString() {
        return "FilePathComponents(root=" + this.f3908a + ", segments=" + this.f3909b + ')';
    }
}
