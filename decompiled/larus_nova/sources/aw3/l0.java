package aw3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q0 f16443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0 f16444b;

    public /* synthetic */ l0() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.f16443a, r101.f16443a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16444b, r101.f16444b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f16443a.hashCode() * 31;
        m0 r101 = this.f16444b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "BackgroundAudioCommandResult(state=" + this.f16443a + ", error=" + this.f16444b + ')';
    }

    public l0(q0 r100, m0 r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f16443a = r100;
        this.f16444b = r101;
    }
}
