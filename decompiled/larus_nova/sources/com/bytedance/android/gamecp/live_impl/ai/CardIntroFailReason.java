package com.bytedance.android.gamecp.live_impl.ai;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/ai/CardIntroFailReason;", "", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "AUTO_INTRO_DISABLED", "CARD_SHOWING", "MANUAL_INTRO_SPAN", "AUTO_INTRO_SPAN", "TIMES_LIMIT", "APP_INSTALLED", "NOT_INTRODUCING_MANUALLY", "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardIntroFailReason extends Enum<CardIntroFailReason> {
    public static final CardIntroFailReason APP_INSTALLED = null;
    public static final CardIntroFailReason AUTO_INTRO_DISABLED = null;
    public static final CardIntroFailReason AUTO_INTRO_SPAN = null;
    public static final CardIntroFailReason CARD_SHOWING = null;
    public static final CardIntroFailReason MANUAL_INTRO_SPAN = null;
    public static final CardIntroFailReason NOT_INTRODUCING_MANUALLY = null;
    public static final CardIntroFailReason TIMES_LIMIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardIntroFailReason[] f57761a = null;
    private final String msg;

    static {
        CardIntroFailReason r100 = new CardIntroFailReason("AUTO_INTRO_DISABLED", 0, "auto_intro_disabled");
        AUTO_INTRO_DISABLED = r100;
        CardIntroFailReason r101 = new CardIntroFailReason("CARD_SHOWING", 1, "card_showing");
        CARD_SHOWING = r101;
        CardIntroFailReason r102 = new CardIntroFailReason("MANUAL_INTRO_SPAN", 2, "manual_intro_span");
        MANUAL_INTRO_SPAN = r102;
        CardIntroFailReason r103 = new CardIntroFailReason("AUTO_INTRO_SPAN", 3, "auto_intro_span");
        AUTO_INTRO_SPAN = r103;
        CardIntroFailReason r104 = new CardIntroFailReason("TIMES_LIMIT", 4, "times_limit");
        TIMES_LIMIT = r104;
        CardIntroFailReason r105 = new CardIntroFailReason("APP_INSTALLED", 5, "app_installed");
        APP_INSTALLED = r105;
        CardIntroFailReason r106 = new CardIntroFailReason("NOT_INTRODUCING_MANUALLY", 6, "not_introducing_manually");
        NOT_INTRODUCING_MANUALLY = r106;
        f57761a = new CardIntroFailReason[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static CardIntroFailReason valueOf(String r100) {
        return (CardIntroFailReason) a.a(CardIntroFailReason.class, r100);
    }

    public static CardIntroFailReason[] values() {
        return (CardIntroFailReason[]) f57761a.clone();
    }

    public final String getMsg() {
        return this.msg;
    }

    public CardIntroFailReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.msg = r102;
    }
}
