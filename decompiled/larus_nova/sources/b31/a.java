package b31;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.revlink.impl.multianchor.constants.GravityDef;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17171e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GravityDef f17172f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (this.f17167a == r101.f17167a) goto L8;
        return false;
    L8:
        if (this.f17168b == r101.f17168b) goto L10;
        return false;
    L10:
        if (this.f17169c == r101.f17169c) goto L12;
        return false;
    L12:
        if (this.f17170d == r101.f17170d) goto L14;
        return false;
    L14:
        if (this.f17171e == r101.f17171e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f17172f, r101.f17172f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f17167a * 31) + this.f17168b) * 31) + this.f17169c) * 31) + this.f17170d) * 31) + this.f17171e) * 31;
        GravityDef r101 = this.f17172f;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "ComponentLayoutData(width=" + this.f17167a + ", height=" + this.f17168b + ", topMargin=" + this.f17169c + ", leftMargin=" + this.f17170d + ", rightMargin=" + this.f17171e + ", gravity=" + this.f17172f + ')';
    }

    public a(int r100, int r101, int r102, int r103, int r104, GravityDef r105) {
        Intrinsics.checkNotNullParameter(r105, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        this.f17167a = r100;
        this.f17168b = r101;
        this.f17169c = r102;
        this.f17170d = r103;
        this.f17171e = r104;
        this.f17172f = r105;
    }
}
