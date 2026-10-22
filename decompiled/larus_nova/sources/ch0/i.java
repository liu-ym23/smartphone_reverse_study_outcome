package ch0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<tf0.d> f23741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<tf0.d> f23742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<tf0.d> f23743d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f23740a, r101.f23740a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f23741b, r101.f23741b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f23742c, r101.f23742c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23743d, r101.f23743d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f23740a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<tf0.d> r104 = this.f23741b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<tf0.d> r107 = this.f23742c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<tf0.d> r110 = this.f23743d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SeatDynamicData(bizId=" + this.f23740a + ", updateByUidList=" + this.f23741b + ", updateByPosList=" + this.f23742c + ", updateAllList=" + this.f23743d + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(String r100, List<? extends tf0.d> r101, List<? extends tf0.d> r102, List<? extends tf0.d> r103) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        Intrinsics.checkNotNullParameter(r101, "updateByUidList");
        Intrinsics.checkNotNullParameter(r102, "updateByPosList");
        Intrinsics.checkNotNullParameter(r103, "updateAllList");
        this.f23740a = r100;
        this.f23741b = r101;
        this.f23742c = r102;
        this.f23743d = r103;
    }
}
