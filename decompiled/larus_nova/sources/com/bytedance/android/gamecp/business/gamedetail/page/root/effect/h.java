package com.bytedance.android.gamecp.business.gamedetail.page.root.effect;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f55514b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (this.f55513a == r101.f55513a) goto L8;
        return false;
    L8:
        if (this.f55514b == r101.f55514b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        int r100 = this.f55513a * 31;
        boolean r101 = this.f55514b;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public final String toString() {
        return "ParentFullscreenScrollIntent(direction=" + this.f55513a + ", global=" + this.f55514b + ")";
    }

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return this.f55514b;
    }

    public h(int r100, boolean r101) {
        this.f55513a = r100;
        this.f55514b = r101;
    }
}
