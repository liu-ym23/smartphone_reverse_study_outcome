package androidx.compose.animation.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u001a8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\u001a8\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"MonoSplineIsExtrapolate", "", "hermiteInterpolate", "", "h", "x", "y1", "y2", "t1", "t2", "hermiteDifferential", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MonoSplineKt {
    private static final boolean MonoSplineIsExtrapolate = true;

    public static final float hermiteDifferential(float r100, float r101, float r102, float r103, float r104, float r105) {
        float r106 = r101 * r101;
        float r107 = 2;
        return (r100 * ((r104 - ((r107 * r101) * ((r107 * r104) + r105))) + ((3 * (r104 + r105)) * r106))) - ((6 * (r101 - r106)) * (r102 - r103));
    }

    public static final float hermiteInterpolate(float r100, float r101, float r102, float r103, float r104, float r105) {
        float r106 = r101 * r101;
        float r107 = r106 * r101;
        float r108 = 2;
        return ((((r104 * r100) * ((r101 - (r108 * r106)) + r107)) + ((r100 * r105) * (r107 - r106))) + r102) - (((3 * r106) - (r108 * r107)) * (r102 - r103));
    }
}
