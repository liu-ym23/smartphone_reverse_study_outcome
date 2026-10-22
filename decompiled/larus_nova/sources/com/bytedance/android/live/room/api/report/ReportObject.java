package com.bytedance.android.live.room.api.report;

import kotlin.Deprecated;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/room/api/report/ReportObject;", "", "DHXT_Link_OR_PK", "XT_Anchor_OR_XT_No_Link_PK", "DH_Anchor", "Comment", "ChannelLink", "PPX", "XT", "Hotsoon_Or_Vigo", "User", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReportObject extends Enum<ReportObject> {
    public static final ReportObject ChannelLink = null;
    public static final ReportObject Comment = null;
    public static final ReportObject DHXT_Link_OR_PK = null;
    public static final ReportObject DH_Anchor = null;

    @Deprecated(message = "火山已经融合进抖音")
    public static final ReportObject Hotsoon_Or_Vigo = null;

    @Deprecated(message = "不再支持Ppx")
    public static final ReportObject PPX = null;
    public static final ReportObject User = null;

    @Deprecated(message = "不再支持西头")
    public static final ReportObject XT = null;

    @Deprecated(message = "不再支持西头")
    public static final ReportObject XT_Anchor_OR_XT_No_Link_PK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReportObject[] f99113a = null;

    static {
        ReportObject r100 = new ReportObject("DHXT_Link_OR_PK", 0);
        DHXT_Link_OR_PK = r100;
        ReportObject r101 = new ReportObject("XT_Anchor_OR_XT_No_Link_PK", 1);
        XT_Anchor_OR_XT_No_Link_PK = r101;
        ReportObject r102 = new ReportObject("DH_Anchor", 2);
        DH_Anchor = r102;
        ReportObject r103 = new ReportObject("Comment", 3);
        Comment = r103;
        ReportObject r104 = new ReportObject("ChannelLink", 4);
        ChannelLink = r104;
        ReportObject r105 = new ReportObject("PPX", 5);
        PPX = r105;
        ReportObject r106 = new ReportObject("XT", 6);
        XT = r106;
        ReportObject r107 = new ReportObject("Hotsoon_Or_Vigo", 7);
        Hotsoon_Or_Vigo = r107;
        ReportObject r108 = new ReportObject("User", 8);
        User = r108;
        f99113a = new ReportObject[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public static ReportObject valueOf(String r100) {
        return (ReportObject) a.a(ReportObject.class, r100);
    }

    public static ReportObject[] values() {
        return (ReportObject[]) f99113a.clone();
    }

    public ReportObject(String r100, int r101) {
        super(r100, r101);
    }
}
