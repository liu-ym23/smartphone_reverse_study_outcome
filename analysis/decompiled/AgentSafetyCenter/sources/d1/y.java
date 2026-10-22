package d1;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends h0 {

    /* renamed from: d, reason: collision with root package name */
    public List f3032d;

    /* renamed from: e, reason: collision with root package name */
    public long f3033e;

    /* renamed from: f, reason: collision with root package name */
    public long f3034f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return yb.k.a(this.f3032d, yVar.f3032d) && c1.b.c(this.f3033e, yVar.f3033e) && c1.b.c(this.f3034f, yVar.f3034f);
    }

    public final int hashCode() {
        return Integer.hashCode(0) + k0.a.i(this.f3034f, k0.a.i(this.f3033e, this.f3032d.hashCode() * 961, 31), 31);
    }

    public final String toString() {
        long j10;
        String str;
        long j11 = this.f3034f;
        long j12 = this.f3033e;
        String str2 = "";
        if (((((j12 & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) == 0) {
            j10 = 9187343241974906880L;
            str = "start=" + ((Object) c1.b.j(j12)) + ", ";
        } else {
            j10 = 9187343241974906880L;
            str = "";
        }
        if (((((j11 & j10) ^ j10) - 4294967297L) & (-9223372034707292160L)) == 0) {
            str2 = "end=" + ((Object) c1.b.j(j11)) + ", ";
        }
        return "LinearGradient(colors=" + this.f3032d + ", stops=null, " + str + str2 + "tileMode=" + ((Object) "Clamp") + ')';
    }

    @Override // d1.h0
    public final Shader x(long j10) {
        long j11 = this.f3034f;
        long j12 = this.f3033e;
        int i = (int) (j12 >> 32);
        if (Float.intBitsToFloat(i) == Float.POSITIVE_INFINITY) {
            i = (int) (j10 >> 32);
        }
        float fIntBitsToFloat = Float.intBitsToFloat(i);
        int i3 = (int) (j12 & 4294967295L);
        if (Float.intBitsToFloat(i3) == Float.POSITIVE_INFINITY) {
            i3 = (int) (j10 & 4294967295L);
        }
        float fIntBitsToFloat2 = Float.intBitsToFloat(i3);
        int i10 = (int) (j11 >> 32);
        if (Float.intBitsToFloat(i10) == Float.POSITIVE_INFINITY) {
            i10 = (int) (j10 >> 32);
        }
        float fIntBitsToFloat3 = Float.intBitsToFloat(i10);
        int i11 = (int) (j11 & 4294967295L);
        if (Float.intBitsToFloat(i11) == Float.POSITIVE_INFINITY) {
            i11 = (int) (j10 & 4294967295L);
        }
        float fIntBitsToFloat4 = Float.intBitsToFloat(i11);
        List list = this.f3032d;
        long jFloatToRawIntBits = (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
        long jFloatToRawIntBits2 = (Float.floatToRawIntBits(fIntBitsToFloat3) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat4) & 4294967295L);
        if (list.size() < 2) {
            g5.f.s("colors must have length of at least 2 if colorStops is omitted.");
            return null;
        }
        float fIntBitsToFloat5 = Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32));
        float fIntBitsToFloat6 = Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L));
        float fIntBitsToFloat7 = Float.intBitsToFloat((int) (jFloatToRawIntBits2 >> 32));
        float fIntBitsToFloat8 = Float.intBitsToFloat((int) (jFloatToRawIntBits2 & 4294967295L));
        int size = list.size();
        int[] iArr = new int[size];
        for (int i12 = 0; i12 < size; i12++) {
            iArr[i12] = f0.r(((p) list.get(i12)).f3026a);
        }
        return new LinearGradient(fIntBitsToFloat5, fIntBitsToFloat6, fIntBitsToFloat7, fIntBitsToFloat8, iArr, (float[]) null, Shader.TileMode.CLAMP);
    }
}
