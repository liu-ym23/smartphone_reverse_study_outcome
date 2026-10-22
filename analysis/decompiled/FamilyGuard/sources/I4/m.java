package I4;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private int f3150a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f3151b = new int[10];

    void a() {
        this.f3150a = 0;
        Arrays.fill(this.f3151b, 0);
    }

    int b(int i5) {
        return this.f3151b[i5];
    }

    int c() {
        if ((this.f3150a & 2) != 0) {
            return this.f3151b[1];
        }
        return -1;
    }

    int d() {
        return (this.f3150a & 128) != 0 ? this.f3151b[7] : ExifInterface.COLOR_SPACE_UNCALIBRATED;
    }

    int e(int i5) {
        return (this.f3150a & 16) != 0 ? this.f3151b[4] : i5;
    }

    int f(int i5) {
        return (this.f3150a & 32) != 0 ? this.f3151b[5] : i5;
    }

    boolean g(int i5) {
        return (this.f3150a & (1 << i5)) != 0;
    }

    void h(m mVar) {
        for (int i5 = 0; i5 < 10; i5++) {
            if (mVar.g(i5)) {
                i(i5, mVar.b(i5));
            }
        }
    }

    m i(int i5, int i6) {
        if (i5 >= 0) {
            int[] iArr = this.f3151b;
            if (i5 < iArr.length) {
                this.f3150a = (1 << i5) | this.f3150a;
                iArr[i5] = i6;
            }
        }
        return this;
    }

    int j() {
        return Integer.bitCount(this.f3150a);
    }
}
