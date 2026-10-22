package aq9;

import com.larus.platform.api.FlowDriveFileType;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowDriveFileType f15972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15973b;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f15972a == r101.f15972a) goto L12;
        return false;
    L12:
        if (this.f15973b == r101.f15973b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        FlowDriveFileType r100 = this.f15972a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f15973b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SelectionFlags(selectedType=" + this.f15972a + ", recentSelectionDisabled=" + this.f15973b + ')';
    }

    public /* synthetic */ e(int r100) {
        this(null, false);
    }

    public e(FlowDriveFileType r100, boolean r101) {
        this.f15972a = r100;
        this.f15973b = r101;
    }
}
