package Z1;

import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class b {
    public static long a(int i10, int i11, int i12) {
        int i13 = i10 - (i11 <= 2 ? 1 : 0);
        long j10 = (i13 >= 0 ? i13 : i13 - 399) / Const.I_TILE_TINY;
        long j11 = i13 - (400 * j10);
        return ((j10 * 146097) + ((((365 * j11) + (j11 / 4)) - (j11 / 100)) + ((((((i11 > 2 ? i11 - 3 : i11 + 9) * 153) + 2) / 5) + i12) - 1))) - 719468;
    }
}
