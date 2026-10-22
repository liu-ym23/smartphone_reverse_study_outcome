package com.bytedance.android.livesdk.log.filter;

import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class f0 extends a<am2.s> {
    public f0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.s r102 = (am2.s) r101;
        super.u(r100, r102);
        if (r102 == null) goto L32;
        String r103 = r102.f4335b;
        String r104 = null;
        if ((!StringsKt.isBlank(r103)) == true) goto L8;
        r103 = null;
    L8:
        if (r103 == null) goto L11;
        if (r100 == null) goto L11;
        String r105 = (String) r100.put("action_type", r103);
    L11:
        String r106 = r102.f4334a;
        if ((!StringsKt.isBlank(r106)) == true) goto L15;
        r106 = null;
    L15:
        if (r106 == null) goto L18;
        if (r100 == null) goto L18;
        String r107 = (String) r100.put("game_tab", r106);
    L18:
        String r108 = r102.f4336c;
        if ((!StringsKt.isBlank(r108)) == true) goto L22;
        r108 = null;
    L22:
        if (r108 == null) goto L25;
        if (r100 == null) goto L25;
        String r109 = (String) r100.put("first_game_live_tab", r108);
    L25:
        String r110 = r102.f4337d;
        if ((!StringsKt.isBlank(r110)) == false) goto L28;
        r104 = r110;
    L28:
        if (r104 == null) goto L33;
        if (r100 == null) goto L34;
        String r111 = (String) r100.put("second_game_live_tab", r104);
        return;
    L34:
        return;
    L33:
        return;
    }
}
