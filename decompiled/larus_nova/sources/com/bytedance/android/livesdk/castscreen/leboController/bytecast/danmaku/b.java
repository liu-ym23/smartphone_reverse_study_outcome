package com.bytedance.android.livesdk.castscreen.leboController.bytecast.danmaku;

import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastDanmakuSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final LiveCastDanmakuSetting a(BarrageSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toDanmakuSetting");
        LiveCastDanmakuSetting r101 = new LiveCastDanmakuSetting();
        r101.setFontAlpha(r100.getAlpha());
        BarrageSettingFont r102 = r100.getFontSize();
        int r103 = 0;
        if (r102 == null) goto L8;
        int r104 = a.f104518a[r102.ordinal()];
        if (r104 == 1) goto L10;
        if (r104 != 2) goto L8;
        int r105 = 0;
    L11:
        r101.setFontSize(r105);
        BarrageSettingArea r106 = r100.getBarrageArea();
        if (r106 == null) goto L19;
        int r107 = a.f104519b[r106.ordinal()];
        if (r107 == 1) goto L21;
        if (r107 == 2) goto L20;
        r103 = 3;
        if (r107 == 3) goto L21;
    L20:
        r103 = 1;
    L21:
        r101.setDanmakuArea(r103);
        return r101;
    L19:
        r103 = 2;
        goto L21
    L10:
        r105 = 2;
    L8:
        r105 = 1;
        goto L11
    }
}
