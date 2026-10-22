package Nb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import okio.SegmentedByteString;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "", UxipConstants.f30680s, "fromIndex", "toIndex", Const.INTENT_KEY_APIKEY, "([IIII)I", "Lokio/SegmentedByteString;", "pos", Const.INTENT_KEY_PKGNAME, "(Lokio/SegmentedByteString;I)I", "okio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class g {
    public static final int a(int[] iArr, int i10, int i11, int i12) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int i15 = iArr[i14];
            if (i15 < i10) {
                i11 = i14 + 1;
            } else {
                if (i15 <= i10) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return (-i11) - 1;
    }

    public static final int b(SegmentedByteString segmentedByteString, int i10) {
        kotlin.jvm.internal.p.i(segmentedByteString, "<this>");
        int iA = a(segmentedByteString.getDirectory(), i10 + 1, 0, segmentedByteString.getSegments().length);
        return iA >= 0 ? iA : ~iA;
    }
}
