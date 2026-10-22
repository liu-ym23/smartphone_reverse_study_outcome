package cb0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f22991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<a> f22993c;

    public /* synthetic */ c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f22991a, r101.f22991a) == true) goto L8;
        return false;
    L8:
        if (this.f22992b == r101.f22992b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f22993c, r101.f22993c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        a r100 = this.f22991a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f22992b) * 31;
        List<a> r104 = this.f22993c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MidiSegmentModel(durationModel=" + this.f22991a + ", tone=" + this.f22992b + ", matchedDuration=" + this.f22993c + ")";
    }

    public c(a r100, int r101, List<a> r102) {
        Intrinsics.checkNotNullParameter(r100, "durationModel");
        this.f22991a = r100;
        this.f22992b = r101;
        this.f22993c = r102;
    }
}
