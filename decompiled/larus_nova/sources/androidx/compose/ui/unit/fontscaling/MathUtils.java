package androidx.compose.ui.unit.fontscaling;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005J\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J.\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/unit/fontscaling/MathUtils;", "", "<init>", "()V", "lerp", "", "start", "stop", "amount", "lerpInv", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "value", "constrainedMap", "rangeMin", "rangeMax", "valueMin", "valueMax", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MathUtils {
    public static final int $stable = 0;
    public static final MathUtils INSTANCE = null;

    static {
        INSTANCE = new MathUtils();
    }

    private MathUtils() {
    }

    public final float lerp(float r100, float r101, float r102) {
        return r100 + ((r101 - r100) * r102);
    }

    public final float lerpInv(float r100, float r101, float r102) {
        if (r100 != r101) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        return 0.0f;
    L10:
        return (r102 - r100) / (r101 - r100);
    L5:
        r103 = false;
        goto L6
    }

    public final float constrainedMap(float r100, float r101, float r102, float r103, float r104) {
        return lerp(r100, r101, Math.max(0.0f, Math.min(1.0f, lerpInv(r102, r103, r104))));
    }
}
