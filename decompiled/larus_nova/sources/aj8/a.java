package aj8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3947d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f3944a == r101.f3944a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3945b, r101.f3945b) == true) goto L15;
        return false;
    L15:
        if (this.f3946c == r101.f3946c) goto L18;
        return false;
    L18:
        if (this.f3947d == r101.f3947d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f3944a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f3945b.hashCode()) * 31;
        if (this.f3946c == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.f3947d;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "BotReferenceTextViewInput(isShow=" + this.f3944a + ", text=" + this.f3945b + ", isImmerse=" + this.f3946c + ", hintResId=" + this.f3947d + ')';
    }

    public a(boolean r100, String r101, boolean r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f3944a = r100;
        this.f3945b = r101;
        this.f3946c = r102;
        this.f3947d = r103;
    }
}
