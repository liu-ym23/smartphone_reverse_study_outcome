package com.bytedance.android.livesdk.revenue.toolbar;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/toolbar/RevResKeyEnum;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "STATIC_ICON", "GUIDE_ANIM_ICON", "INTRO_CARD_SHOW_ANIM", "INTRO_CARD_HIDE_ANIM", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevResKeyEnum extends Enum<RevResKeyEnum> {
    public static final RevResKeyEnum GUIDE_ANIM_ICON = null;
    public static final RevResKeyEnum INTRO_CARD_HIDE_ANIM = null;
    public static final RevResKeyEnum INTRO_CARD_SHOW_ANIM = null;
    public static final RevResKeyEnum STATIC_ICON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevResKeyEnum[] f157520a = null;
    private final String key;

    static {
        RevResKeyEnum r100 = new RevResKeyEnum("STATIC_ICON", 0, "static");
        STATIC_ICON = r100;
        RevResKeyEnum r101 = new RevResKeyEnum("GUIDE_ANIM_ICON", 1, "guide_anim");
        GUIDE_ANIM_ICON = r101;
        RevResKeyEnum r102 = new RevResKeyEnum("INTRO_CARD_SHOW_ANIM", 2, "intro_card_show_anim");
        INTRO_CARD_SHOW_ANIM = r102;
        RevResKeyEnum r103 = new RevResKeyEnum("INTRO_CARD_HIDE_ANIM", 3, "intro_card_hide_anim");
        INTRO_CARD_HIDE_ANIM = r103;
        f157520a = new RevResKeyEnum[]{r100, r101, r102, r103};
    }

    public static RevResKeyEnum valueOf(String r100) {
        return (RevResKeyEnum) a.a(RevResKeyEnum.class, r100);
    }

    public static RevResKeyEnum[] values() {
        return (RevResKeyEnum[]) f157520a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public RevResKeyEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
