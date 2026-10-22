package c22;

import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static final boolean a(NormalGiftMessage r100, NormalGiftMessage r101) {
        Intrinsics.checkNotNullParameter(r101, "newMsg");
        if (r100 != null) goto L5;
        return false;
    L5:
        String r102 = r100.u();
        if (r102 == null) goto L11;
        if (r102.equals(r101.u()) == true) goto L11;
        return false;
    L11:
        if (r100.f129786p == false) goto L13;
    L17:
        return false;
    L13:
        if (r101.f129786p == true) goto L17;
        return true;
    }
}
