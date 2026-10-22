package com.bytedance.android.annie.api.card;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/api/card/CardCustomMonitorKey;", "", "IsPrerender", "IsContainerPreload", "IsUserOpen", "RealOpenTime", "HasReload", "HintSecLink", "UserOpenTime", "LoadScene", "DidAppear", "annie-api_release"}, k = 1, mv = {1, 4, 3})
public final enum CardCustomMonitorKey extends Enum<CardCustomMonitorKey> {
    public static final CardCustomMonitorKey DidAppear = null;
    public static final CardCustomMonitorKey HasReload = null;
    public static final CardCustomMonitorKey HintSecLink = null;
    public static final CardCustomMonitorKey IsContainerPreload = null;
    public static final CardCustomMonitorKey IsPrerender = null;
    public static final CardCustomMonitorKey IsUserOpen = null;
    public static final CardCustomMonitorKey LoadScene = null;
    public static final CardCustomMonitorKey RealOpenTime = null;
    public static final CardCustomMonitorKey UserOpenTime = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardCustomMonitorKey[] f38391a = null;

    public static CardCustomMonitorKey valueOf(String r100) {
        return (CardCustomMonitorKey) a.a(CardCustomMonitorKey.class, r100);
    }

    public static CardCustomMonitorKey[] values() {
        return (CardCustomMonitorKey[]) f38391a.clone();
    }

    static {
        CardCustomMonitorKey r100 = new CardCustomMonitorKey("IsPrerender", 0);
        IsPrerender = r100;
        CardCustomMonitorKey r101 = new CardCustomMonitorKey("IsContainerPreload", 1);
        IsContainerPreload = r101;
        CardCustomMonitorKey r102 = new CardCustomMonitorKey("IsUserOpen", 2);
        IsUserOpen = r102;
        CardCustomMonitorKey r103 = new CardCustomMonitorKey("RealOpenTime", 3);
        RealOpenTime = r103;
        CardCustomMonitorKey r104 = new CardCustomMonitorKey("HasReload", 4);
        HasReload = r104;
        CardCustomMonitorKey r105 = new CardCustomMonitorKey("HintSecLink", 5);
        HintSecLink = r105;
        CardCustomMonitorKey r110 = new CardCustomMonitorKey("UserOpenTime", 6);
        UserOpenTime = r110;
        CardCustomMonitorKey r111 = new CardCustomMonitorKey("LoadScene", 7);
        LoadScene = r111;
        CardCustomMonitorKey r112 = new CardCustomMonitorKey("DidAppear", 8);
        DidAppear = r112;
        f38391a = new CardCustomMonitorKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public CardCustomMonitorKey(String r100, int r101) {
        super(r100, r101);
    }
}
