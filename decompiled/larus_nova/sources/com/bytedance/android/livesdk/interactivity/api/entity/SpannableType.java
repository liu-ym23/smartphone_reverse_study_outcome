package com.bytedance.android.livesdk.interactivity.api.entity;

import com.ss.android.ugc.effectmanager.common.EffectConstants;

/* JADX INFO: loaded from: classes9.dex */
public final enum SpannableType extends Enum<SpannableType> {
    public static final SpannableType DISPLAY_TEXT = null;
    public static final SpannableType GAME = null;
    public static final SpannableType MESSAGE_FILTER = null;
    public static final SpannableType MINI_CARD = null;
    public static final SpannableType NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SpannableType[] f133132a = null;

    static {
        SpannableType r100 = new SpannableType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        SpannableType r101 = new SpannableType("GAME", 1);
        GAME = r101;
        SpannableType r102 = new SpannableType("DISPLAY_TEXT", 2);
        DISPLAY_TEXT = r102;
        SpannableType r103 = new SpannableType("MESSAGE_FILTER", 3);
        MESSAGE_FILTER = r103;
        SpannableType r104 = new SpannableType("MINI_CARD", 4);
        MINI_CARD = r104;
        f133132a = new SpannableType[]{r100, r101, r102, r103, r104};
    }

    public static SpannableType[] values() {
        return (SpannableType[]) f133132a.clone();
    }

    public static SpannableType valueOf(String r100) {
        return (SpannableType) r27.a.a(SpannableType.class, r100);
    }

    public SpannableType(String r100, int r101) {
        super(r100, r101);
    }
}
