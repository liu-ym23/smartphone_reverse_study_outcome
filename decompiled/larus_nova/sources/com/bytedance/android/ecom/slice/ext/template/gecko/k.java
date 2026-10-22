package com.bytedance.android.ecom.slice.ext.template.gecko;

/* JADX INFO: loaded from: classes44.dex */
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f51269d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f51270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f51271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f51272c;

    public static final class a {
        public a() {
        }

        public static k a(boolean r100, boolean r101, int r102) {
            int r103 = k.f51269d;
            if ((r102 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r102 & 2) == 0) goto L9;
            r101 = false;
        L9:
            return new k(r100, r101, false);
        }
    }

    static {
        new a();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L12;
        k r101 = (k) r100;
        if (this.f51270a == r101.f51270a) goto L8;
        return false;
    L8:
        if (this.f51271b == r101.f51271b) goto L10;
        return false;
    L10:
        if (this.f51272c == r101.f51272c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r100 = this.f51270a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f51271b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f51272c;
        if (r107 == true) goto L13;
        r101 = r107;
    L13:
        return r106 + r101;
    }

    public final String toString() {
        return "TemplateLoadConfig(disableOffline=" + this.f51270a + ", disableBuiltin=" + this.f51271b + ", disableCdn=" + this.f51272c + ")";
    }

    public k(boolean r100, boolean r101, boolean r102) {
        this.f51270a = r100;
        this.f51271b = r101;
        this.f51272c = r102;
    }
}
