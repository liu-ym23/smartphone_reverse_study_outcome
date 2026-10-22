package com.bytedance.android.live.messagewindow.framework.process.card;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/messagewindow/framework/process/card/CardPsId;", "", "ShowDebounce", "PrepareAbility", "InterceptShow", "Pk", "CardStart", "AttachContainer", "TransitionAnim", "MarkEnd", "DismissDebounce", "DetachContainer", "SuspendDebounce", "HideCard", "NotifyCardShow", "SuspendCard", "LogCardRecordsPs", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardPsId extends Enum<CardPsId> {
    public static final CardPsId AttachContainer = null;
    public static final CardPsId CardStart = null;
    public static final CardPsId DetachContainer = null;
    public static final CardPsId DismissDebounce = null;
    public static final CardPsId HideCard = null;
    public static final CardPsId InterceptShow = null;
    public static final CardPsId LogCardRecordsPs = null;
    public static final CardPsId MarkEnd = null;
    public static final CardPsId NotifyCardShow = null;
    public static final CardPsId Pk = null;
    public static final CardPsId PrepareAbility = null;
    public static final CardPsId ShowDebounce = null;
    public static final CardPsId SuspendCard = null;
    public static final CardPsId SuspendDebounce = null;
    public static final CardPsId TransitionAnim = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardPsId[] f83139a = null;

    public static CardPsId valueOf(String r100) {
        return (CardPsId) r27.a.a(CardPsId.class, r100);
    }

    public static CardPsId[] values() {
        return (CardPsId[]) f83139a.clone();
    }

    static {
        CardPsId r100 = new CardPsId("ShowDebounce", 0);
        ShowDebounce = r100;
        CardPsId r101 = new CardPsId("PrepareAbility", 1);
        PrepareAbility = r101;
        CardPsId r102 = new CardPsId("InterceptShow", 2);
        InterceptShow = r102;
        CardPsId r103 = new CardPsId("Pk", 3);
        Pk = r103;
        CardPsId r104 = new CardPsId("CardStart", 4);
        CardStart = r104;
        CardPsId r105 = new CardPsId("AttachContainer", 5);
        AttachContainer = r105;
        CardPsId r106 = new CardPsId("TransitionAnim", 6);
        TransitionAnim = r106;
        CardPsId r107 = new CardPsId("MarkEnd", 7);
        MarkEnd = r107;
        CardPsId r108 = new CardPsId("DismissDebounce", 8);
        DismissDebounce = r108;
        CardPsId r109 = new CardPsId("DetachContainer", 9);
        DetachContainer = r109;
        CardPsId r110 = new CardPsId("SuspendDebounce", 10);
        SuspendDebounce = r110;
        CardPsId r111 = new CardPsId("HideCard", 11);
        HideCard = r111;
        CardPsId r112 = new CardPsId("NotifyCardShow", 12);
        NotifyCardShow = r112;
        CardPsId r113 = new CardPsId("SuspendCard", 13);
        SuspendCard = r113;
        CardPsId r114 = new CardPsId("LogCardRecordsPs", 14);
        LogCardRecordsPs = r114;
        f83139a = new CardPsId[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114};
    }

    public CardPsId(String r100, int r101) {
        super(r100, r101);
    }
}
