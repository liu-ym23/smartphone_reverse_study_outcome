package bl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Integer, Boolean> f19402d;

    public a() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f19399a, r101.f19399a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f19400b, r101.f19400b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f19401c, r101.f19401c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19402d, r101.f19402d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f19399a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f19400b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f19401c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Function1<Integer, Boolean> r110 = this.f19402d;
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
        return "EcomLiveBizWindowAbilityEnv(roomId=" + this.f19399a + ", requestId=" + this.f19400b + ", anchorId=" + this.f19401c + ", isShowingOnToolbar=" + this.f19402d + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, String r101, String r102, Function1<? super Integer, Boolean> r103) {
        this.f19399a = r100;
        this.f19400b = r101;
        this.f19401c = r102;
        this.f19402d = r103;
    }
}
