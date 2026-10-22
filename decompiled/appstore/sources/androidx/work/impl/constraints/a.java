package androidx.work.impl.constraints;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5518d;

    public a(boolean r10, boolean r11, boolean r12, boolean r13) {
        this.f5515a = r10;
        this.f5516b = r11;
        this.f5517c = r12;
        this.f5518d = r13;
    }

    public final boolean a() {
        return this.f5515a;
    }

    public final boolean b() {
        return this.f5517c;
    }

    public final boolean c() {
        return this.f5518d;
    }

    public final boolean d() {
        return this.f5516b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.f5515a == r11.f5515a) goto L12;
        return false;
    L12:
        if (this.f5516b == r11.f5516b) goto L15;
        return false;
    L15:
        if (this.f5517c == r11.f5517c) goto L18;
        return false;
    L18:
        if (this.f5518d == r11.f5518d) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public int hashCode() {
        boolean r10 = this.f5515a;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L5;
        r12 = 1;
    L5:
        int r13 = r12 * 31;
        boolean r14 = this.f5516b;
        ?? r15 = r14;
        if (r14 == false) goto L8;
        r15 = 1;
    L8:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.f5517c;
        ?? r18 = r17;
        if (r17 == false) goto L11;
        r18 = 1;
    L11:
        int r19 = (r16 + r18) * 31;
        boolean r20 = this.f5518d;
        if (r20 == true) goto L16;
        r11 = r20;
    L16:
        return r19 + r11;
    }

    public String toString() {
        return "NetworkState(isConnected=" + this.f5515a + ", isValidated=" + this.f5516b + ", isMetered=" + this.f5517c + ", isNotRoaming=" + this.f5518d + ')';
    }
}
