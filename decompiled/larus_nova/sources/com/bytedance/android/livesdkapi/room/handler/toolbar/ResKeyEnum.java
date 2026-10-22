package com.bytedance.android.livesdkapi.room.handler.toolbar;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/toolbar/ResKeyEnum;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "STATIC_ICON", "GUIDE_ANIM_ICON", "MULTI_CAMERA", "INTRO_CARD_SHOW_ANIM", "INTRO_CARD_HIDE_ANIM", "IM_MANAGER", "IM_AUDIENCE", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ResKeyEnum extends Enum<ResKeyEnum> {
    private static final /* synthetic */ ResKeyEnum[] $VALUES = null;
    public static final ResKeyEnum GUIDE_ANIM_ICON = null;
    public static final ResKeyEnum IM_AUDIENCE = null;
    public static final ResKeyEnum IM_MANAGER = null;
    public static final ResKeyEnum INTRO_CARD_HIDE_ANIM = null;
    public static final ResKeyEnum INTRO_CARD_SHOW_ANIM = null;
    public static final ResKeyEnum MULTI_CAMERA = null;
    public static final ResKeyEnum STATIC_ICON = null;
    private final String key;

    static {
        ResKeyEnum r100 = new ResKeyEnum("STATIC_ICON", 0, "static");
        STATIC_ICON = r100;
        ResKeyEnum r101 = new ResKeyEnum("GUIDE_ANIM_ICON", 1, "guide_anim");
        GUIDE_ANIM_ICON = r101;
        ResKeyEnum r102 = new ResKeyEnum("MULTI_CAMERA", 2, "multi_camera");
        MULTI_CAMERA = r102;
        ResKeyEnum r103 = new ResKeyEnum("INTRO_CARD_SHOW_ANIM", 3, "intro_card_show_anim");
        INTRO_CARD_SHOW_ANIM = r103;
        ResKeyEnum r104 = new ResKeyEnum("INTRO_CARD_HIDE_ANIM", 4, "intro_card_hide_anim");
        INTRO_CARD_HIDE_ANIM = r104;
        ResKeyEnum r105 = new ResKeyEnum("IM_MANAGER", 5, "im_manager");
        IM_MANAGER = r105;
        ResKeyEnum r106 = new ResKeyEnum("IM_AUDIENCE", 6, "im_audience");
        IM_AUDIENCE = r106;
        $VALUES = new ResKeyEnum[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ResKeyEnum valueOf(String r100) {
        return (ResKeyEnum) a.a(ResKeyEnum.class, r100);
    }

    public static ResKeyEnum[] values() {
        return (ResKeyEnum[]) $VALUES.clone();
    }

    public final String getKey() {
        return this.key;
    }

    private ResKeyEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
