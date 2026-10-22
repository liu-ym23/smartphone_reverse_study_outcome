package com.bytedance.android.livesdk.user;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b6\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<¨\u0006="}, d2 = {"Lcom/bytedance/android/livesdk/user/LiveFollowScene;", "", "", DownloadHelper.IDENTITY, "I", "getIdentity", "()I", "", "reportFromPre", "Ljava/lang/String;", "getReportFromPre", "()Ljava/lang/String;", "reportFromLabel", "getReportFromLabel", "reportFromAction", "getReportFromAction", "LIVE_DEFAULT", "USER_INFO", "PROFILE_USER_INFO", "PROFILE_PUBLIC_SCREEN", "PROFILE_DEFAULT", "LONG_PRESS", "FOLLOW_GUIDE", "END_PAGE", "REMIND_DIALOG", "FOLLOW_BACK", "MESSAGE_FOLLOW", "MATCH_USER_INFO", "REPLAY_USER_INFO", "FANS_CLUB_MESSAGE", "PK_GUEST_INTERACT_PANEL", "PK_BAN_USER_PANEL", "PK_ANCHOR_WINDOW", "PK_DEFAULT", "OFFICIAL_ROOM_CHANNEL", "OFFICIAL_ROOM_ANCHOR", "OFFICIAL_ROOM_DEFAULT", "TALK_ROOM_GUEST_PANEL", "TALK_ROOM_INTERACT_PANEL", "TALK_ROOM_DEFAULT", "KTV_HOT_PAGE", "KTV_RANK_PAGE", "KTV_DEFAULT", "MULTI_ANCHOR_WINDOW", "MULTI_ANCHOR_PANEL", "FANS_MIC_FOLLOW_GUILD", "MULTI_USER_ROOM_DEFAULT", "MEDIA_USER_INFO", "MEDIA_MULTI_ANCHOR", "MEDIA_ROOM_DEFAULT", "VS_USER_INFO", "VS_LIVE_FANS_MESSAGE", "VS_DANMU", "VS_FOLLOW_GUIDE", "VS_FANS_MESSAGE", "VS_USER_PROFILE", "VS_ROOM_DEFAULT", "RECOMMEND_ANCHOR_CARD", "LIVE_DRAWER", "PROFILE_ONLINE_USER", "RED_ENVELOPE", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveFollowScene extends Enum<LiveFollowScene> {
    public static final LiveFollowScene END_PAGE = null;
    public static final LiveFollowScene FANS_CLUB_MESSAGE = null;
    public static final LiveFollowScene FANS_MIC_FOLLOW_GUILD = null;
    public static final LiveFollowScene FOLLOW_BACK = null;
    public static final LiveFollowScene FOLLOW_GUIDE = null;
    public static final LiveFollowScene KTV_DEFAULT = null;
    public static final LiveFollowScene KTV_HOT_PAGE = null;
    public static final LiveFollowScene KTV_RANK_PAGE = null;
    public static final LiveFollowScene LIVE_DEFAULT = null;
    public static final LiveFollowScene LIVE_DRAWER = null;
    public static final LiveFollowScene LONG_PRESS = null;
    public static final LiveFollowScene MATCH_USER_INFO = null;
    public static final LiveFollowScene MEDIA_MULTI_ANCHOR = null;
    public static final LiveFollowScene MEDIA_ROOM_DEFAULT = null;
    public static final LiveFollowScene MEDIA_USER_INFO = null;
    public static final LiveFollowScene MESSAGE_FOLLOW = null;
    public static final LiveFollowScene MULTI_ANCHOR_PANEL = null;
    public static final LiveFollowScene MULTI_ANCHOR_WINDOW = null;
    public static final LiveFollowScene MULTI_USER_ROOM_DEFAULT = null;
    public static final LiveFollowScene OFFICIAL_ROOM_ANCHOR = null;
    public static final LiveFollowScene OFFICIAL_ROOM_CHANNEL = null;
    public static final LiveFollowScene OFFICIAL_ROOM_DEFAULT = null;
    public static final LiveFollowScene PK_ANCHOR_WINDOW = null;
    public static final LiveFollowScene PK_BAN_USER_PANEL = null;
    public static final LiveFollowScene PK_DEFAULT = null;
    public static final LiveFollowScene PK_GUEST_INTERACT_PANEL = null;
    public static final LiveFollowScene PROFILE_DEFAULT = null;
    public static final LiveFollowScene PROFILE_ONLINE_USER = null;
    public static final LiveFollowScene PROFILE_PUBLIC_SCREEN = null;
    public static final LiveFollowScene PROFILE_USER_INFO = null;
    public static final LiveFollowScene RECOMMEND_ANCHOR_CARD = null;
    public static final LiveFollowScene RED_ENVELOPE = null;
    public static final LiveFollowScene REMIND_DIALOG = null;
    public static final LiveFollowScene REPLAY_USER_INFO = null;
    public static final LiveFollowScene TALK_ROOM_DEFAULT = null;
    public static final LiveFollowScene TALK_ROOM_GUEST_PANEL = null;
    public static final LiveFollowScene TALK_ROOM_INTERACT_PANEL = null;
    public static final LiveFollowScene USER_INFO = null;
    public static final LiveFollowScene VS_DANMU = null;
    public static final LiveFollowScene VS_FANS_MESSAGE = null;
    public static final LiveFollowScene VS_FOLLOW_GUIDE = null;
    public static final LiveFollowScene VS_LIVE_FANS_MESSAGE = null;
    public static final LiveFollowScene VS_ROOM_DEFAULT = null;
    public static final LiveFollowScene VS_USER_INFO = null;
    public static final LiveFollowScene VS_USER_PROFILE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveFollowScene[] f158631a = null;
    private final int identity;
    private final String reportFromAction;
    private final String reportFromLabel;
    private final String reportFromPre;

    public static LiveFollowScene valueOf(String r100) {
        return (LiveFollowScene) r27.a.a(LiveFollowScene.class, r100);
    }

    public static LiveFollowScene[] values() {
        return (LiveFollowScene[]) f158631a.clone();
    }

    static {
        LiveFollowScene r100 = new LiveFollowScene("LIVE_DEFAULT", 0, 1, Constants.VIA_REPORT_TYPE_START_WAP, "0");
        LIVE_DEFAULT = r100;
        LiveFollowScene r101 = new LiveFollowScene("USER_INFO", 1, 2, "16131", "1613101");
        USER_INFO = r101;
        LiveFollowScene r102 = new LiveFollowScene("PROFILE_USER_INFO", 2, 3, "16131", "1613101");
        PROFILE_USER_INFO = r102;
        LiveFollowScene r103 = new LiveFollowScene("PROFILE_PUBLIC_SCREEN", 3, 5, "16131", "1613103");
        PROFILE_PUBLIC_SCREEN = r103;
        LiveFollowScene r104 = new LiveFollowScene("PROFILE_DEFAULT", 4, 6, "16131", "1613104");
        PROFILE_DEFAULT = r104;
        LiveFollowScene r105 = new LiveFollowScene("LONG_PRESS", 5, 7, "16131", "1613105");
        LONG_PRESS = r105;
        LiveFollowScene r106 = new LiveFollowScene("FOLLOW_GUIDE", 6, 8, "16131", "1613106");
        FOLLOW_GUIDE = r106;
        LiveFollowScene r107 = new LiveFollowScene("END_PAGE", 7, 9, "16131", "1613107");
        END_PAGE = r107;
        LiveFollowScene r108 = new LiveFollowScene("REMIND_DIALOG", 8, 10, "16131", "1613108");
        REMIND_DIALOG = r108;
        LiveFollowScene r109 = new LiveFollowScene("FOLLOW_BACK", 9, 11, "16131", "1613109");
        FOLLOW_BACK = r109;
        LiveFollowScene r110 = new LiveFollowScene("MESSAGE_FOLLOW", 10, 12, "16131", "1613110");
        MESSAGE_FOLLOW = r110;
        LiveFollowScene r111 = new LiveFollowScene("MATCH_USER_INFO", 11, 14, "16131", "1613112");
        MATCH_USER_INFO = r111;
        LiveFollowScene r112 = new LiveFollowScene("REPLAY_USER_INFO", 12, 15, "16131", "1613113");
        REPLAY_USER_INFO = r112;
        LiveFollowScene r113 = new LiveFollowScene("FANS_CLUB_MESSAGE", 13, 16, "16131", "1613115");
        FANS_CLUB_MESSAGE = r113;
        LiveFollowScene r114 = new LiveFollowScene("PK_GUEST_INTERACT_PANEL", 14, 17, "16132", "1613201");
        PK_GUEST_INTERACT_PANEL = r114;
        LiveFollowScene r115 = new LiveFollowScene("PK_BAN_USER_PANEL", 15, 18, "16132", "1613202");
        PK_BAN_USER_PANEL = r115;
        LiveFollowScene r116 = new LiveFollowScene("PK_ANCHOR_WINDOW", 16, 19, "16132", "1613203");
        PK_ANCHOR_WINDOW = r116;
        LiveFollowScene r117 = new LiveFollowScene("PK_DEFAULT", 17, 20, BDLocationException.ERROR_CODE_EXCEPTION, "13232");
        PK_DEFAULT = r117;
        LiveFollowScene r118 = new LiveFollowScene("OFFICIAL_ROOM_CHANNEL", 18, 21, "16133", "1613301");
        OFFICIAL_ROOM_CHANNEL = r118;
        LiveFollowScene r119 = new LiveFollowScene("OFFICIAL_ROOM_ANCHOR", 19, 22, "16133", "1613302");
        OFFICIAL_ROOM_ANCHOR = r119;
        LiveFollowScene r120 = new LiveFollowScene("OFFICIAL_ROOM_DEFAULT", 20, 23, "133", "13333");
        OFFICIAL_ROOM_DEFAULT = r120;
        LiveFollowScene r121 = new LiveFollowScene("TALK_ROOM_GUEST_PANEL", 21, 24, "16135", "1613501");
        TALK_ROOM_GUEST_PANEL = r121;
        LiveFollowScene r122 = new LiveFollowScene("TALK_ROOM_INTERACT_PANEL", 22, 25, "16135", "1613502");
        TALK_ROOM_INTERACT_PANEL = r122;
        LiveFollowScene r123 = new LiveFollowScene("TALK_ROOM_DEFAULT", 23, 26, "135", "13535");
        TALK_ROOM_DEFAULT = r123;
        LiveFollowScene r124 = new LiveFollowScene("KTV_HOT_PAGE", 24, 27, "16136", "1613601");
        KTV_HOT_PAGE = r124;
        LiveFollowScene r125 = new LiveFollowScene("KTV_RANK_PAGE", 25, 28, "16136", "1613602");
        KTV_RANK_PAGE = r125;
        LiveFollowScene r126 = new LiveFollowScene("KTV_DEFAULT", 26, 29, BDLocationException.ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED, "13636");
        KTV_DEFAULT = r126;
        LiveFollowScene r127 = new LiveFollowScene("MULTI_ANCHOR_WINDOW", 27, 30, "16137", "1613701");
        MULTI_ANCHOR_WINDOW = r127;
        LiveFollowScene r128 = new LiveFollowScene("MULTI_ANCHOR_PANEL", 28, 31, "16137", "1613702");
        MULTI_ANCHOR_PANEL = r128;
        LiveFollowScene r129 = new LiveFollowScene("FANS_MIC_FOLLOW_GUILD", 29, 32, "16137", "1613703");
        FANS_MIC_FOLLOW_GUILD = r129;
        LiveFollowScene r130 = new LiveFollowScene("MULTI_USER_ROOM_DEFAULT", 30, 33, "137", "13737");
        MULTI_USER_ROOM_DEFAULT = r130;
        LiveFollowScene r131 = new LiveFollowScene("MEDIA_USER_INFO", 31, 34, "16140", "1614001");
        MEDIA_USER_INFO = r131;
        LiveFollowScene r132 = new LiveFollowScene("MEDIA_MULTI_ANCHOR", 32, 35, "16140", "1614002");
        MEDIA_MULTI_ANCHOR = r132;
        LiveFollowScene r133 = new LiveFollowScene("MEDIA_ROOM_DEFAULT", 33, 36, BDLocationException.ERROR_EXTRA_DATA_SCAN_FAILED, "14040");
        MEDIA_ROOM_DEFAULT = r133;
        LiveFollowScene r134 = new LiveFollowScene("VS_USER_INFO", 34, 37, "16134", "1613401");
        VS_USER_INFO = r134;
        LiveFollowScene r135 = new LiveFollowScene("VS_LIVE_FANS_MESSAGE", 35, 38, "16134", "1613402");
        VS_LIVE_FANS_MESSAGE = r135;
        LiveFollowScene r136 = new LiveFollowScene("VS_DANMU", 36, 39, "16134", "1613403");
        VS_DANMU = r136;
        LiveFollowScene r137 = new LiveFollowScene("VS_FOLLOW_GUIDE", 37, 40, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED, "13404");
        VS_FOLLOW_GUIDE = r137;
        LiveFollowScene r138 = new LiveFollowScene("VS_FANS_MESSAGE", 38, 41, "16134", "1613405");
        VS_FANS_MESSAGE = r138;
        LiveFollowScene r139 = new LiveFollowScene("VS_USER_PROFILE", 39, 42, "16134", "1613406");
        VS_USER_PROFILE = r139;
        LiveFollowScene r140 = new LiveFollowScene("VS_ROOM_DEFAULT", 40, 43, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED, "13434");
        VS_ROOM_DEFAULT = r140;
        LiveFollowScene r141 = new LiveFollowScene("RECOMMEND_ANCHOR_CARD", 41, 44, "161316", "0");
        RECOMMEND_ANCHOR_CARD = r141;
        LiveFollowScene r142 = new LiveFollowScene("LIVE_DRAWER", 42, 45, "131", "13116");
        LIVE_DRAWER = r142;
        LiveFollowScene r143 = new LiveFollowScene("PROFILE_ONLINE_USER", 43, 47, "16131", "1613102");
        PROFILE_ONLINE_USER = r143;
        LiveFollowScene r144 = new LiveFollowScene("RED_ENVELOPE", 44, 48, "16131", "1613111");
        RED_ENVELOPE = r144;
        f158631a = new LiveFollowScene[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144};
    }

    public final int getIdentity() {
        return this.identity;
    }

    public final String getReportFromAction() {
        return this.reportFromAction;
    }

    public final String getReportFromLabel() {
        return this.reportFromLabel;
    }

    public final String getReportFromPre() {
        return this.reportFromPre;
    }

    public LiveFollowScene(String r100, int r101, int r102, String r103, String r104) {
        super(r100, r101);
        this.identity = r102;
        this.reportFromPre = Constants.VIA_REPORT_TYPE_START_WAP;
        this.reportFromLabel = r103;
        this.reportFromAction = r104;
    }
}
