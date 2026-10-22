package u8;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f24897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f24898d;

    public d(int r10, int r11, int r12, int r13) {
        this.f24895a = r10;
        this.f24896b = r11;
        this.f24897c = r12;
        this.f24898d = r13;
    }

    public final int a() {
        return this.f24898d;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (this.f24895a == r11.f24895a) goto L12;
        return false;
    L12:
        if (this.f24896b == r11.f24896b) goto L15;
        return false;
    L15:
        if (this.f24897c == r11.f24897c) goto L18;
        return false;
    L18:
        if (this.f24898d == r11.f24898d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f24895a) * 31) + Integer.hashCode(this.f24896b)) * 31) + Integer.hashCode(this.f24897c)) * 31) + Integer.hashCode(this.f24898d);
    }

    public String toString() {
        return "InitialMargins(left=" + this.f24895a + ", top=" + this.f24896b + ", right=" + this.f24897c + ", bottom=" + this.f24898d + ')';
    }
}
