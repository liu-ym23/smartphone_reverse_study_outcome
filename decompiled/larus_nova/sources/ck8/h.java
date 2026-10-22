package ck8;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f24063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f24064b;

    public h() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f24063a, r101.f24063a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f24064b, r101.f24064b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Function0<Unit> r100 = this.f24063a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function0<Unit> r104 = this.f24064b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ComplexTaskColorCapsuleViewOutput(onShow=" + this.f24063a + ", onClick=" + this.f24064b + ')';
    }

    public h(Function0<Unit> r100, Function0<Unit> r101) {
        this.f24063a = r100;
        this.f24064b = r101;
    }
}
