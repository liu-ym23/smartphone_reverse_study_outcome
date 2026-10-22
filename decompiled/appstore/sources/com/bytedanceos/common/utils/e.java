package com.bytedanceos.common.utils;

import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.tangram.style.BannerStyle;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public static BannerStyle a(int r10) {
        BannerStyle r11 = new BannerStyle();
        if (r10 != 0) goto L5;
        r11.f9929h = false;
        r11.f9924c = tc.f.i(235);
        r11.f9925d = tc.f.i(90);
        r11.f9927f[3] = tc.f.i(12);
        r11.f9927f[0] = tc.f.i(8);
        int[] r12 = r11.f9927f;
        r12[1] = 0;
        r12[2] = tc.f.i(8);
        int r13 = r11.f9924c;
        int[] r14 = r11.f9927f;
        r11.f9922a = (r13 + r14[3]) + r14[1];
        r11.f9923b = (r11.f9925d + r14[0]) + r14[2];
        r11.f9931j = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.oui_r_l3_rect);
    L20:
        return r11;
    L5:
        if (r10 == 1) goto L18;
        if (r10 == 2) goto L17;
        if (r10 != 3) goto L9;
        r11.f9929h = false;
        r11.f9924c = tc.f.i(222);
        r11.f9925d = tc.f.i(106);
        int[] r15 = r11.f9927f;
        r15[3] = 0;
        r15[0] = tc.f.i(8);
        int[] r16 = r11.f9927f;
        r16[1] = 0;
        r16[2] = tc.f.i(8);
        int r17 = r11.f9924c;
        int[] r18 = r11.f9927f;
        r11.f9922a = (r17 + r18[3]) + r18[1];
        r11.f9923b = (r11.f9925d + r18[0]) + r18[2];
        r11.f9931j = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.oui_r_l3_rect);
        goto L20
    L9:
        if (r10 != 4) goto L11;
        r11.f9929h = false;
        r11.f9930i = true;
        r11.f9924c = tc.f.i(41);
        int r19 = tc.f.i(41);
        r11.f9925d = r19;
        int[] r20 = r11.f9927f;
        r20[3] = 0;
        r20[0] = 0;
        r20[1] = 0;
        r20[2] = 0;
        r11.f9922a = r11.f9924c;
        r11.f9923b = r19;
        r11.f9931j = tc.f.i(22);
        goto L20
    L11:
        if (r10 != 5) goto L14;
        r11.f9929h = true;
        r11.f9924c = tc.f.i(156);
        r11.f9925d = tc.f.i(64);
        r11.f9927f[3] = tc.f.i(0);
        r11.f9927f[0] = tc.f.i(0);
        r11.f9927f[1] = tc.f.i(0);
        r11.f9927f[2] = tc.f.i(0);
        int r21 = r11.f9924c;
        int[] r22 = r11.f9927f;
        r11.f9922a = (r21 + r22[3]) + r22[1];
        r11.f9923b = (r11.f9925d + r22[0]) + r22[2];
        r11.f9931j = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.oui_r_l1_rect);
        goto L20
    L14:
        throw new IllegalArgumentException("BaseBannerStyleFactory, illegal banner style type=" + r10);
    L17:
        r11.f9929h = false;
        r11.f9924c = tc.f.i(320);
        r11.f9925d = tc.f.i(82);
        r11.f9927f[3] = tc.f.i(20);
        r11.f9927f[0] = tc.f.i(8);
        r11.f9927f[1] = tc.f.i(20);
        r11.f9927f[2] = tc.f.i(8);
        int r23 = r11.f9924c;
        int[] r24 = r11.f9927f;
        r11.f9922a = (r23 + r24[3]) + r24[1];
        r11.f9923b = (r11.f9925d + r24[0]) + r24[2];
        r11.f9931j = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.oui_r_l3_rect);
        goto L20
    L18:
        r11.f9929h = true;
        r11.f9924c = tc.f.i(320);
        r11.f9925d = tc.f.i(122);
        r11.f9927f[3] = tc.f.i(20);
        r11.f9927f[0] = tc.f.i(8);
        r11.f9927f[1] = tc.f.i(12);
        r11.f9927f[2] = tc.f.i(8);
        int r25 = r11.f9924c;
        int[] r26 = r11.f9927f;
        r11.f9922a = (r25 + r26[3]) + r26[1];
        r11.f9923b = (r11.f9925d + r26[0]) + r26[2];
        r11.f9931j = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.oui_r_l1);
        goto L20
    }
}
