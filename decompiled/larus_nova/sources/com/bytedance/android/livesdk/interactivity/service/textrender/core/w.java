package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.graphics.Color;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.common.utility.Logger;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class w {
    public static yb2.a a() {
        yb2.a r100 = new yb2.a();
        r100.f567063b = com.bytedance.android.live.liveinteract.f.a(R.color.ttlive_text_message_special_color, new s());
        r100.f567062a = com.bytedance.android.live.liveinteract.f.a(R.color.ttlive_text_message_medium_color, new t());
        r100.f567064c = com.bytedance.android.live.liveinteract.f.a(R.color.ttlive_text_message_low_color, new u());
        r100.f567066e = com.bytedance.android.live.liveinteract.f.a(R.color.ttlive_text_message_medium_color, new v());
        r100.f567068g = "";
        r100.f567071j = false;
        return r100;
    }

    public static int b(int r100, b5 r101, b5 r102, yb2.a r103) {
        if (r103 != null) goto L4;
        r103 = new yb2.a();
    L4:
        boolean r104 = true;
        int r105 = 0;
        if (r101 != null) goto L7;
    L9:
        boolean r106 = false;
    L10:
        PieceType r107 = PieceType.STRING;
        if (r100 != r107.getPieceType()) goto L16;
        if (r101 == null) goto L16;
        if (r101.isUseHeighLight() == false) goto L16;
    L18:
        if (r101 != null) goto L20;
    L19:
        int r108 = 0;
    L27:
        int r109 = r103.f567066e;
        if (r100 != r107.getPieceType()) goto L31;
        int r110 = r103.f567065d;
    L40:
        if (r102 == null) goto L49;
        String r111 = r102.getColor();
        if (TextUtils.isEmpty(r111) == true) goto L49;
        r105 = Color.parseColor(r111);     // Catch: Exception -> L47
    L47:
        e = move-exception;
        Logger.e("I18N_MESSAGE", e.getMessage());
    L49:
        if (r106 == false) goto L52;
        if (r108 == 0) goto L52;
        return r108;
    L52:
        if (r104 == false) goto L55;
        if (r109 == 0) goto L55;
        return r109;
    L55:
        if (r105 == 0) goto L60;
        if (r102 == null) goto L60;
        if (r102.isUseRemoteColor() == false) goto L60;
        return r105;
    L60:
        if (r110 == 0) goto L62;
        return r110;
    L62:
        if (r105 == 0) goto L64;
        return r105;
    L64:
        return -1;
    L31:
        if (r100 != PieceType.USER.getPieceType()) goto L34;
        r110 = r103.f567062a;
        goto L40
    L34:
        if (r100 != PieceType.GIFT.getPieceType()) goto L37;
        r110 = r103.f567063b;
        goto L40
    L37:
        if (r100 != PieceType.PATTERN_REF.getPieceType()) goto L39;
        r110 = r103.f567064c;
        goto L40
    L39:
        r110 = r103.f567065d;
        goto L40
    L20:
        String r112 = r101.getColor();
        if (TextUtils.isEmpty(r112) == true) goto L19;
        r108 = Color.parseColor(r112);     // Catch: Exception -> L25
    L25:
        e = move-exception;
        Logger.e("I18N_MESSAGE", e.getMessage());
    L16:
        r104 = false;
        goto L18
    L7:
        if (r101.isUseRemoteColor() == false) goto L9;
        r106 = true;
        goto L10
    }
}
