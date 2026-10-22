package bs1;

import android.graphics.Bitmap;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f20222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f20223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f20225d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f20222a, r101.f20222a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f20223b, r101.f20223b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f20224c, r101.f20224c) == true) goto L12;
        return false;
    L12:
        if (this.f20225d == r101.f20225d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        View r100 = this.f20222a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Bitmap r104 = this.f20223b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f20224c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        long r109 = this.f20225d;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "QuickShotParam(triggerView=" + this.f20222a + ", shareBitmap=" + this.f20223b + ", localPath=" + this.f20224c + ", clickTime=" + this.f20225d + ")";
    }

    public b(View r100, Bitmap r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r102, "localPath");
        this.f20222a = r100;
        this.f20223b = r101;
        this.f20224c = r102;
        this.f20225d = r103;
    }
}
