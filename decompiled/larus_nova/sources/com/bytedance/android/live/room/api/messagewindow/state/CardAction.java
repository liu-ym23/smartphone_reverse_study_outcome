package com.bytedance.android.live.room.api.messagewindow.state;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/state/CardAction;", "", "REFRESH", "HIDE", "DESTROY", "DESTROY_WITHOUT_DESTROY", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardAction extends Enum<CardAction> {
    public static final CardAction DESTROY = null;
    public static final CardAction DESTROY_WITHOUT_DESTROY = null;
    public static final CardAction HIDE = null;
    public static final CardAction REFRESH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardAction[] f99036a = null;

    static {
        CardAction r100 = new CardAction("REFRESH", 0);
        REFRESH = r100;
        CardAction r101 = new CardAction("HIDE", 1);
        HIDE = r101;
        CardAction r102 = new CardAction("DESTROY", 2);
        DESTROY = r102;
        CardAction r103 = new CardAction("DESTROY_WITHOUT_DESTROY", 3);
        DESTROY_WITHOUT_DESTROY = r103;
        f99036a = new CardAction[]{r100, r101, r102, r103};
    }

    public static CardAction valueOf(String r100) {
        return (CardAction) a.a(CardAction.class, r100);
    }

    public static CardAction[] values() {
        return (CardAction[]) f99036a.clone();
    }

    public CardAction(String r100, int r101) {
        super(r100, r101);
    }
}
