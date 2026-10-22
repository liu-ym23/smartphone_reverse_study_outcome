package cc8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f23319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f23320b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f23319a, r101.f23319a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23320b, r101.f23320b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f23319a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f23320b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "ActionBarImagePrefetchEntry(itemId=" + this.f23319a + ", iconUrls=" + this.f23320b + ')';
    }

    public a(Long r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r101, "iconUrls");
        this.f23319a = r100;
        this.f23320b = r101;
    }
}
