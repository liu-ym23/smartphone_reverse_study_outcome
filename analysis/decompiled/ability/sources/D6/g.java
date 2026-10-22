package D6;

import android.content.res.TypedArray;
import com.stepos.motionkit.fx.material.GlassEffect;

/* loaded from: classes3.dex */
public abstract class g {
    public static GlassEffect a(TypedArray typedArray, int i) {
        int i6;
        if (!typedArray.hasValue(i) || (i6 = typedArray.getInt(i, -1)) == -1) {
            return null;
        }
        if (i6 == 0) {
            return GlassEffect.INSTANCE.getCLEAR();
        }
        if (i6 == 1) {
            return GlassEffect.INSTANCE.getLIGHT_SMALL();
        }
        if (i6 == 2) {
            return GlassEffect.INSTANCE.getLIGHT_MEDIUM();
        }
        if (i6 == 3) {
            return GlassEffect.INSTANCE.getDARK_SMALL();
        }
        if (i6 == 4) {
            return GlassEffect.INSTANCE.getDARK_MEDIUM();
        }
        throw new IllegalArgumentException(B7.a.h(i6, "steposGlassEffect must be clear(0), light_small(1), light_medium(2), dark_small(3), or dark_medium(4) but was "));
    }
}
