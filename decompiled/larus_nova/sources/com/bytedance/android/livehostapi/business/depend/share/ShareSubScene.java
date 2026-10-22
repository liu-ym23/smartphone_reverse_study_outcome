package com.bytedance.android.livehostapi.business.depend.share;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/ShareSubScene;", "", "scene", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "Unknown", "LiveQuickShot", "LiveQuickRecord", "LiveMatchMoment", "LiveMatchTicket", "ReceivePaidTicket", "LivePaidTicket", "LiveTabMatchSituation", "LiveTabMatchMember", "LiveMatchPrediction", "LiveMatchChampionWho", "LiveAfterMatch", "LivePaidPackage", "LiveAnnouncement", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShareSubScene extends Enum<ShareSubScene> {
    private static final /* synthetic */ ShareSubScene[] $VALUES = null;
    public static final ShareSubScene LiveAfterMatch = null;
    public static final ShareSubScene LiveAnnouncement = null;
    public static final ShareSubScene LiveMatchChampionWho = null;
    public static final ShareSubScene LiveMatchMoment = null;
    public static final ShareSubScene LiveMatchPrediction = null;
    public static final ShareSubScene LiveMatchTicket = null;
    public static final ShareSubScene LivePaidPackage = null;
    public static final ShareSubScene LivePaidTicket = null;
    public static final ShareSubScene LiveQuickRecord = null;
    public static final ShareSubScene LiveQuickShot = null;
    public static final ShareSubScene LiveTabMatchMember = null;
    public static final ShareSubScene LiveTabMatchSituation = null;
    public static final ShareSubScene ReceivePaidTicket = null;
    public static final ShareSubScene Unknown = null;
    private final String scene;

    public static ShareSubScene valueOf(String r100) {
        return (ShareSubScene) a.a(ShareSubScene.class, r100);
    }

    public static ShareSubScene[] values() {
        return (ShareSubScene[]) $VALUES.clone();
    }

    static {
        ShareSubScene r100 = new ShareSubScene("Unknown", 0, "unknown");
        Unknown = r100;
        ShareSubScene r101 = new ShareSubScene("LiveQuickShot", 1, "live_screen_shot");
        LiveQuickShot = r101;
        ShareSubScene r102 = new ShareSubScene("LiveQuickRecord", 2, "live_screen_record");
        LiveQuickRecord = r102;
        ShareSubScene r103 = new ShareSubScene("LiveMatchMoment", 3, "live_match_moment");
        LiveMatchMoment = r103;
        ShareSubScene r104 = new ShareSubScene("LiveMatchTicket", 4, "live_match_ticket");
        LiveMatchTicket = r104;
        ShareSubScene r105 = new ShareSubScene("ReceivePaidTicket", 5, "receive_paid_ticket");
        ReceivePaidTicket = r105;
        ShareSubScene r106 = new ShareSubScene("LivePaidTicket", 6, "live_paid_ticket");
        LivePaidTicket = r106;
        ShareSubScene r107 = new ShareSubScene("LiveTabMatchSituation", 7, "live_tab_match_situation");
        LiveTabMatchSituation = r107;
        ShareSubScene r108 = new ShareSubScene("LiveTabMatchMember", 8, "live_tab_match_member");
        LiveTabMatchMember = r108;
        ShareSubScene r109 = new ShareSubScene("LiveMatchPrediction", 9, "live_match_prediction");
        LiveMatchPrediction = r109;
        ShareSubScene r110 = new ShareSubScene("LiveMatchChampionWho", 10, "live_match_champion_who");
        LiveMatchChampionWho = r110;
        ShareSubScene r111 = new ShareSubScene("LiveAfterMatch", 11, "live_after_match");
        LiveAfterMatch = r111;
        ShareSubScene r112 = new ShareSubScene("LivePaidPackage", 12, "live_paid_package");
        LivePaidPackage = r112;
        ShareSubScene r113 = new ShareSubScene("LiveAnnouncement", 13, "live_announcement");
        LiveAnnouncement = r113;
        $VALUES = new ShareSubScene[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113};
    }

    public final String getScene() {
        return this.scene;
    }

    private ShareSubScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
