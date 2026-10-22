package b19;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Intent f16950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16951d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f16948a == r101.f16948a) goto L12;
        return false;
    L12:
        if (this.f16949b == r101.f16949b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f16950c, r101.f16950c) == true) goto L18;
        return false;
    L18:
        if (this.f16951d == r101.f16951d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f16948a * 31) + this.f16949b) * 31;
        Intent r101 = this.f16950c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f16951d == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowActivityResultBean(requestCode=" + this.f16948a + ", resultCode=" + this.f16949b + ", data=" + this.f16950c + ", used=" + this.f16951d + ')';
    }

    public a(int r100, int r101, Intent r102) {
        this.f16948a = r100;
        this.f16949b = r101;
        this.f16950c = r102;
        this.f16951d = false;
    }
}
