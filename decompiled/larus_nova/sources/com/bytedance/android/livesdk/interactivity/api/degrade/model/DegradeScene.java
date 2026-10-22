package com.bytedance.android.livesdk.interactivity.api.degrade.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeScene;", "", "PERFORMANCE_FRAME", "ECOM", "GAME", "LOW_PERFORMANCE_PHONE", "STRATEGY_PLATFORM_FLOW_LIKE_DEGRADE", "STRATEGY_PLATFORM_TAP_LIKE_DEGRADE", "ENTER_ROOM_DURATION", "AUDIENCE_EXP_HIGH_LEVEL_ENTER_ANIM", "AUDIENCE_EXP_HIGH_LEVEL_ECOM_ANIM", "AUDIENCE_EXP_DISABLE_HIGH_LEVEL_ENTER", "AUDIENCE_EXP_HOT_COMMENT_TRAY", "AUDIENCE_EXP_PORTRAIT_DANMAKU", "AUDIENCE_EXP_LIKE_FLOW", "AUDIENCE_EXP_COMMENT_CARNIVAL", "AUDIENCE_EXP_PUBLIC_SCREEN_ANIM", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DegradeScene extends Enum<DegradeScene> {
    public static final DegradeScene AUDIENCE_EXP_COMMENT_CARNIVAL = null;
    public static final DegradeScene AUDIENCE_EXP_DISABLE_HIGH_LEVEL_ENTER = null;
    public static final DegradeScene AUDIENCE_EXP_HIGH_LEVEL_ECOM_ANIM = null;
    public static final DegradeScene AUDIENCE_EXP_HIGH_LEVEL_ENTER_ANIM = null;
    public static final DegradeScene AUDIENCE_EXP_HOT_COMMENT_TRAY = null;
    public static final DegradeScene AUDIENCE_EXP_LIKE_FLOW = null;
    public static final DegradeScene AUDIENCE_EXP_PORTRAIT_DANMAKU = null;
    public static final DegradeScene AUDIENCE_EXP_PUBLIC_SCREEN_ANIM = null;
    public static final DegradeScene ECOM = null;
    public static final DegradeScene ENTER_ROOM_DURATION = null;
    public static final DegradeScene GAME = null;
    public static final DegradeScene LOW_PERFORMANCE_PHONE = null;
    public static final DegradeScene PERFORMANCE_FRAME = null;
    public static final DegradeScene STRATEGY_PLATFORM_FLOW_LIKE_DEGRADE = null;
    public static final DegradeScene STRATEGY_PLATFORM_TAP_LIKE_DEGRADE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DegradeScene[] f133100a = null;

    static {
        DegradeScene r100 = new DegradeScene("PERFORMANCE_FRAME", 0);
        PERFORMANCE_FRAME = r100;
        DegradeScene r101 = new DegradeScene("ECOM", 1);
        ECOM = r101;
        DegradeScene r102 = new DegradeScene("GAME", 2);
        GAME = r102;
        DegradeScene r103 = new DegradeScene("LOW_PERFORMANCE_PHONE", 3);
        LOW_PERFORMANCE_PHONE = r103;
        DegradeScene r104 = new DegradeScene("STRATEGY_PLATFORM_FLOW_LIKE_DEGRADE", 4);
        STRATEGY_PLATFORM_FLOW_LIKE_DEGRADE = r104;
        DegradeScene r105 = new DegradeScene("STRATEGY_PLATFORM_TAP_LIKE_DEGRADE", 5);
        STRATEGY_PLATFORM_TAP_LIKE_DEGRADE = r105;
        DegradeScene r106 = new DegradeScene("ENTER_ROOM_DURATION", 6);
        ENTER_ROOM_DURATION = r106;
        DegradeScene r107 = new DegradeScene("AUDIENCE_EXP_HIGH_LEVEL_ENTER_ANIM", 7);
        AUDIENCE_EXP_HIGH_LEVEL_ENTER_ANIM = r107;
        DegradeScene r108 = new DegradeScene("AUDIENCE_EXP_HIGH_LEVEL_ECOM_ANIM", 8);
        AUDIENCE_EXP_HIGH_LEVEL_ECOM_ANIM = r108;
        DegradeScene r109 = new DegradeScene("AUDIENCE_EXP_DISABLE_HIGH_LEVEL_ENTER", 9);
        AUDIENCE_EXP_DISABLE_HIGH_LEVEL_ENTER = r109;
        DegradeScene r110 = new DegradeScene("AUDIENCE_EXP_HOT_COMMENT_TRAY", 10);
        AUDIENCE_EXP_HOT_COMMENT_TRAY = r110;
        DegradeScene r111 = new DegradeScene("AUDIENCE_EXP_PORTRAIT_DANMAKU", 11);
        AUDIENCE_EXP_PORTRAIT_DANMAKU = r111;
        DegradeScene r112 = new DegradeScene("AUDIENCE_EXP_LIKE_FLOW", 12);
        AUDIENCE_EXP_LIKE_FLOW = r112;
        DegradeScene r113 = new DegradeScene("AUDIENCE_EXP_COMMENT_CARNIVAL", 13);
        AUDIENCE_EXP_COMMENT_CARNIVAL = r113;
        DegradeScene r114 = new DegradeScene("AUDIENCE_EXP_PUBLIC_SCREEN_ANIM", 14);
        AUDIENCE_EXP_PUBLIC_SCREEN_ANIM = r114;
        f133100a = new DegradeScene[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114};
    }

    public static DegradeScene valueOf(String r100) {
        return (DegradeScene) a.a(DegradeScene.class, r100);
    }

    public static DegradeScene[] values() {
        return (DegradeScene[]) f133100a.clone();
    }

    public DegradeScene(String r100, int r101) {
        super(r100, r101);
    }
}
