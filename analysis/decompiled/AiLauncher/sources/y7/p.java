package y7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "rgb", "opacityPct", Const.INTENT_KEY_PKGNAME, "(II)I", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class p {
    public static final int b(int i10, int i11) {
        return (i10 & 16777215) | ((((C5685n.n(i11, 0, 100) * 255) + 50) / 100) << 24);
    }
}
