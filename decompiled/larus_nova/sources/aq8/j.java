package aq8;

import com.larus.bmhome.actionbar.model.z0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0 f15969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f15970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f15971c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f15969a, r101.f15969a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f15970b, r101.f15970b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f15971c, r101.f15971c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f15969a.hashCode() * 31;
        e r101 = this.f15970b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Function0<Unit> r105 = this.f15971c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "InstructionWithInputData(customActionBarItem=" + this.f15969a + ", extraData=" + this.f15970b + ", onInstructionCallback=" + this.f15971c + ')';
    }

    public j(z0 r100, e r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "customActionBarItem");
        this.f15969a = r100;
        this.f15970b = r101;
        this.f15971c = r102;
    }
}
