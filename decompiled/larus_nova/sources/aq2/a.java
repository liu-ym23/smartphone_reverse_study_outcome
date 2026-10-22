package aq2;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f15880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f15881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f15883d;

    public a() {
        this(null, false, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f15880a, r101.f15880a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f15881b, r101.f15881b) == true) goto L10;
        return false;
    L10:
        if (this.f15882c == r101.f15882c) goto L12;
        return false;
    L12:
        if (this.f15883d == r101.f15883d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        c r100 = this.f15880a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        b r104 = this.f15881b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f15882c;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.f15883d;
        if (r110 == true) goto L17;
        r107 = r110;
    L17:
        return r109 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RevCardConfig(size=" + this.f15880a + ", margin=" + this.f15881b + ", supportLandscape=" + this.f15882c + ", needStoring=" + this.f15883d + ")";
    }

    public a(b r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        c r103 = new c(0);
    L7:
        if ((r102 & 2) == 0) goto L10;
        r100 = new b(0, 0, 0, 0);
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = false;
    L12:
        Intrinsics.checkNotNullParameter(r103, "size");
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.FLEXBOX_MARGIN);
        this.f15880a = r103;
        this.f15881b = r100;
        this.f15882c = r101;
        this.f15883d = false;
        return;
    L5:
        r103 = null;
        goto L7
    }
}
