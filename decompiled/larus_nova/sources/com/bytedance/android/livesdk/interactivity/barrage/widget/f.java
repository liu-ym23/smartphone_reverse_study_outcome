package com.bytedance.android.livesdk.interactivity.barrage.widget;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f134141a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f134142b = null;

    static {
        int[] r100 = new int[BarrageSettingFont.values().length];
        f134141a = r100;
        r100[BarrageSettingFont.BIG.ordinal()] = 1;
        r100[BarrageSettingFont.MID.ordinal()] = 2;
        r100[BarrageSettingFont.SMALL.ordinal()] = 3;
        int[] r101 = new int[BarrageSettingArea.values().length];
        f134142b = r101;
        r101[BarrageSettingArea.TOP.ordinal()] = 1;
        r101[BarrageSettingArea.HALF.ordinal()] = 2;
        r101[BarrageSettingArea.FULL.ordinal()] = 3;
        r101[BarrageSettingArea.CLOSE.ordinal()] = 4;
    }
}
