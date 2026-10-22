package b30;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17121a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f17121a, ((e0) r100).f17121a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f17121a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "StartAnimationEvent(key=" + this.f17121a + ")";
    }

    public e0(String r100) {
        this.f17121a = r100;
    }
}
