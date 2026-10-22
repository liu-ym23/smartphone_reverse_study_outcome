package fb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a+\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\t\u001a\u00020\b*\u00020\u0000H\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lfb/o;", "", "byte", "", "startOffset", "endOffset", Const.INTENT_KEY_APIKEY, "(Lfb/o;BII)I", "", Const.INTENT_KEY_PKGNAME, "(Lfb/o;)Z", "kotlinx-io-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class q {
    public static final int a(o oVar, byte b10, int i10, int i11) {
        kotlin.jvm.internal.p.i(oVar, "<this>");
        if (i10 < 0 || i10 >= oVar.j()) {
            throw new IllegalArgumentException(String.valueOf(i10).toString());
        }
        if (i10 > i11 || i11 > oVar.j()) {
            throw new IllegalArgumentException(String.valueOf(i11).toString());
        }
        int pos = oVar.getPos();
        byte[] bArrB = oVar.b(true);
        while (i10 < i11) {
            if (bArrB[pos + i10] == b10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final boolean b(o oVar) {
        kotlin.jvm.internal.p.i(oVar, "<this>");
        return oVar.j() == 0;
    }
}
