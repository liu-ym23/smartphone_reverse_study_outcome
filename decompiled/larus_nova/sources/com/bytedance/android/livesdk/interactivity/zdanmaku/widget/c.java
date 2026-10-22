package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f141999a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f142000b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f142001c = null;

    static {
        int[] r100 = new int[DanmakuType.values().length];
        f141999a = r100;
        r100[DanmakuType.Chat.ordinal()] = 1;
        r100[DanmakuType.Gift.ordinal()] = 2;
        int[] r101 = new int[BarrageSettingFont.values().length];
        f142000b = r101;
        BarrageSettingFont r102 = BarrageSettingFont.BIG;
        r101[r102.ordinal()] = 1;
        BarrageSettingFont r103 = BarrageSettingFont.MID;
        r101[r103.ordinal()] = 2;
        BarrageSettingFont r104 = BarrageSettingFont.SMALL;
        r101[r104.ordinal()] = 3;
        int[] r105 = new int[BarrageSettingFont.values().length];
        f142001c = r105;
        r105[r102.ordinal()] = 1;
        r105[r103.ordinal()] = 2;
        r105[r104.ordinal()] = 3;
    }
}
