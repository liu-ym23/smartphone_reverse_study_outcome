package br9;

import com.heytap.mcssdk.constant.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f20158d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f20155a == r101.f20155a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20156b, r101.f20156b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20157c, r101.f20157c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f20158d, r101.f20158d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f20155a * 31) + this.f20156b.hashCode()) * 31) + this.f20157c.hashCode()) * 31) + this.f20158d.hashCode();
    }

    public final String toString() {
        return "SdkFrontierConfig(productId=" + this.f20155a + ", appKey=" + this.f20156b + ", did=" + this.f20157c + ", url=" + this.f20158d + ')';
    }

    public a(int r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, b.f276376z);
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r103, "url");
        this.f20155a = r100;
        this.f20156b = r101;
        this.f20157c = r102;
        this.f20158d = r103;
    }
}
