package com.bytedance.android.livesdk.revenue.service.experience;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/experience/RevLiveShareType;", "", "SHARE_IM", "SHARE_THIRD", "SHARE_DIALOG", "SHARE_VIDEO2FANSGROUP", "SHARE_TEXT2FANSGROUP", "SHARE_ACTIVITY", "SHARE_DIRECT", "REPORT_DIALOG", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevLiveShareType extends Enum<RevLiveShareType> {
    public static final RevLiveShareType REPORT_DIALOG = null;
    public static final RevLiveShareType SHARE_ACTIVITY = null;
    public static final RevLiveShareType SHARE_DIALOG = null;
    public static final RevLiveShareType SHARE_DIRECT = null;
    public static final RevLiveShareType SHARE_IM = null;
    public static final RevLiveShareType SHARE_TEXT2FANSGROUP = null;
    public static final RevLiveShareType SHARE_THIRD = null;
    public static final RevLiveShareType SHARE_VIDEO2FANSGROUP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevLiveShareType[] f157310a = null;

    static {
        RevLiveShareType r100 = new RevLiveShareType("SHARE_IM", 0);
        SHARE_IM = r100;
        RevLiveShareType r101 = new RevLiveShareType("SHARE_THIRD", 1);
        SHARE_THIRD = r101;
        RevLiveShareType r102 = new RevLiveShareType("SHARE_DIALOG", 2);
        SHARE_DIALOG = r102;
        RevLiveShareType r103 = new RevLiveShareType("SHARE_VIDEO2FANSGROUP", 3);
        SHARE_VIDEO2FANSGROUP = r103;
        RevLiveShareType r104 = new RevLiveShareType("SHARE_TEXT2FANSGROUP", 4);
        SHARE_TEXT2FANSGROUP = r104;
        RevLiveShareType r105 = new RevLiveShareType("SHARE_ACTIVITY", 5);
        SHARE_ACTIVITY = r105;
        RevLiveShareType r106 = new RevLiveShareType("SHARE_DIRECT", 6);
        SHARE_DIRECT = r106;
        RevLiveShareType r107 = new RevLiveShareType("REPORT_DIALOG", 7);
        REPORT_DIALOG = r107;
        f157310a = new RevLiveShareType[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public static RevLiveShareType valueOf(String r100) {
        return (RevLiveShareType) r27.a.a(RevLiveShareType.class, r100);
    }

    public static RevLiveShareType[] values() {
        return (RevLiveShareType[]) f157310a.clone();
    }

    public RevLiveShareType(String r100, int r101) {
        super(r100, r101);
    }
}
