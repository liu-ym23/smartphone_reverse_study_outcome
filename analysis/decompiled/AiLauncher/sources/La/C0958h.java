package La;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: La.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0958h {
    public static final boolean b(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (kotlin.jvm.internal.p.k(cCharAt, 128) >= 0 || Character.isLetter(cCharAt)) {
                return true;
            }
        }
        return false;
    }
}
