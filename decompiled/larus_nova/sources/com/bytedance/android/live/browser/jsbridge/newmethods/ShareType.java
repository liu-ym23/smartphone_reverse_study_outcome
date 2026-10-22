package com.bytedance.android.live.browser.jsbridge.newmethods;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/ShareType;", "", "", "type", "I", "getType", "()I", "Unknown", "Champion", "Prediction", "MatchSituation", "PaidLivePackage", "ReceiveShareTicket", "PaidLiveTicket", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShareType extends Enum<ShareType> {
    public static final ShareType Champion = null;
    public static final ShareType MatchSituation = null;
    public static final ShareType PaidLivePackage = null;
    public static final ShareType PaidLiveTicket = null;
    public static final ShareType Prediction = null;
    public static final ShareType ReceiveShareTicket = null;
    public static final ShareType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShareType[] f63270a = null;
    private final int type;

    static {
        ShareType r100 = new ShareType("Unknown", 0, 0);
        Unknown = r100;
        ShareType r101 = new ShareType("Champion", 1, 1);
        Champion = r101;
        ShareType r102 = new ShareType("Prediction", 2, 2);
        Prediction = r102;
        ShareType r103 = new ShareType("MatchSituation", 3, 3);
        MatchSituation = r103;
        ShareType r104 = new ShareType("PaidLivePackage", 4, 6);
        PaidLivePackage = r104;
        ShareType r105 = new ShareType("ReceiveShareTicket", 5, 8);
        ReceiveShareTicket = r105;
        ShareType r106 = new ShareType("PaidLiveTicket", 6, 9);
        PaidLiveTicket = r106;
        f63270a = new ShareType[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ShareType valueOf(String r100) {
        return (ShareType) r27.a.a(ShareType.class, r100);
    }

    public static ShareType[] values() {
        return (ShareType[]) f63270a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ShareType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
