package hd;

import com.stepos.core.common.util.TraceIdKeys;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public int f9426a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f9427b = new int[10];

    public final int a() {
        if ((this.f9426a & TraceIdKeys.MAX_LENGTH) != 0) {
            return this.f9427b[7];
        }
        return 65535;
    }

    public final void b(e other) {
        g.f(other, "other");
        for (int i10 = 0; i10 < 10; i10++) {
            if (((1 << i10) & other.f9426a) != 0) {
                c(i10, other.f9427b[i10]);
            }
        }
    }

    public final void c(int i10, int i11) {
        if (i10 >= 0) {
            int[] iArr = this.f9427b;
            if (i10 >= iArr.length) {
                return;
            }
            this.f9426a = (1 << i10) | this.f9426a;
            iArr[i10] = i11;
        }
    }
}
