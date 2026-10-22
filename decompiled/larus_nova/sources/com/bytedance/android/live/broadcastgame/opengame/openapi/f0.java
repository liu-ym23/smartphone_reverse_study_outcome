package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class f0 {
    public static final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isRawIp");
        List r101 = StringsKt.split$default(r100, new String[]{"."}, false, 0, 6, null);
        if (r101.size() == 4) goto L5;
        return false;
    L5:
        Iterator r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L16;
        int r103 = CastIntegerProtector.parseInt((String) r102.next());     // Catch: NumberFormatException -> L18
        if (r103 < 0) goto L15;
        if (255 >= r103) goto L7;
    L15:
        return false;
    L16:
        return true;
    }
}
