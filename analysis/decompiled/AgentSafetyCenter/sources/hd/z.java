package hd;

import androidx.exifinterface.media.ExifInterface;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public int f5588a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f5589b = new int[10];

    public final int a() {
        return (this.f5588a & 128) != 0 ? this.f5589b[7] : ExifInterface.COLOR_SPACE_UNCALIBRATED;
    }

    public final void b(int i, int i3) {
        if (i >= 0) {
            int[] iArr = this.f5589b;
            if (i >= iArr.length) {
                return;
            }
            this.f5588a = (1 << i) | this.f5588a;
            iArr[i] = i3;
        }
    }
}
