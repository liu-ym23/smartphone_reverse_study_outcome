package L4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a/\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "elapsedMs", "periodMs", "", "frameCount", "loop", Const.INTENT_KEY_APIKEY, "(JJII)I", "agentsprite_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class p {
    public static final int a(long j10, long j11, int i10, int i11) {
        if (i10 <= 0) {
            return 0;
        }
        int iG = (int) (j10 / C5685n.g(j11, 1L));
        return i11 < 0 ? iG % i10 : C5685n.j(iG, (i11 * i10) - 1) % i10;
    }
}
