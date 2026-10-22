package A7;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.fx.material.capability.BlurGradient;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LA7/B;", "", Const.INTENT_KEY_PKGNAME, "(LA7/B;)I", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: A7.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0745m {
    public static final int b(B b10) {
        if ((b10.getStartColor() >>> 24) == 0 && (b10.getMiddleColor() >>> 24) == 0 && (b10.getEndColor() >>> 24) == 0) {
            return 0;
        }
        BlurGradient colorDirection = b10.getColorDirection();
        if (colorDirection == null) {
            colorDirection = b10.getDirection();
        }
        return colorDirection.getMode();
    }
}
