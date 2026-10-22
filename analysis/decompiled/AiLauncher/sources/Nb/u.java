package Nb;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "high", "low", Const.INTENT_KEY_APIKEY, "(II)I", "okio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class u {
    public static final int a(int i10, int i11) {
        return (((i10 & FastDoubleMath.DOUBLE_EXPONENT_BIAS) << 10) | (i11 & FastDoubleMath.DOUBLE_EXPONENT_BIAS)) + 65536;
    }
}
