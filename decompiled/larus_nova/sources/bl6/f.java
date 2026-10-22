package bl6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class f {
    public f() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L14;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L16;
        return false;
    L16:
        return true;
    L14:
        return false;
    L10:
        return false;
    }

    public final int hashCode() {
        return 0 + 0;
    }

    public final String toString() {
        return "MidiSegment(durationModel=null, pitch=0, matchedDuration=null)";
    }
}
