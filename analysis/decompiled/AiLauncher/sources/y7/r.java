package y7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"LA7/B;", "Ly7/q;", "tier", "LY8/t;", "c", "(LA7/B;Ly7/q;)V", "", "rgb", "opacityPct", Const.INTENT_KEY_PKGNAME, "(II)I", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class r {
    public static final int b(int i10, int i11) {
        return (i10 & 16777215) | ((((C5685n.n(i11, 0, 100) * 255) + 50) / 100) << 24);
    }

    public static final void c(A7.B b10, q tier) {
        kotlin.jvm.internal.p.i(b10, "<this>");
        kotlin.jvm.internal.p.i(tier, "tier");
        tier.d(b10);
    }
}
