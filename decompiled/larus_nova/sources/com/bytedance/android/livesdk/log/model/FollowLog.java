package com.bytedance.android.livesdk.log.model;

import r27.a;

/* JADX INFO: loaded from: classes10.dex */
public final class FollowLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f153382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f153383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f153384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f153385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Scene f153386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f153387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f153388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f153389h;

    public static final enum Scene extends Enum<Scene> {
        public static final Scene EndRoomWidget = null;
        public static final Scene JoinFansClubAutoFollow = null;
        public static final Scene LeftTop = null;
        public static final Scene LongPressPanel = null;
        public static final Scene MEDIA_ANCHOR = null;
        public static final Scene MULTI_ANCHOR = null;
        public static final Scene MicRoomLeftTop = null;
        public static final Scene PK = null;
        public static final Scene ProfileCard = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Scene[] f153390a = null;
        private final String description;
        private final String followEntrancePage;

        static {
            Scene r100 = new Scene("LeftTop", 0, "普通直播间左上角关注", "left_up");
            LeftTop = r100;
            Scene r101 = new Scene("ProfileCard", 1, "资料卡关注", "personal_card");
            ProfileCard = r101;
            Scene r102 = new Scene("LongPressPanel", 2, "长按面板关注", "in_room_long_press");
            LongPressPanel = r102;
            Scene r103 = new Scene("EndRoomWidget", 3, "关播页关注主播", "live_end_head");
            EndRoomWidget = r103;
            Scene r104 = new Scene("JoinFansClubAutoFollow", 4, "加入粉丝团自动关注", "fansgroup");
            JoinFansClubAutoFollow = r104;
            Scene r105 = new Scene("MicRoomLeftTop", 5, "麦序房关注当前上麦主播", "mic_on");
            MicRoomLeftTop = r105;
            Scene r106 = new Scene("PK", 6, "pk关注对面主播", "pk_button");
            PK = r106;
            Scene r110 = new Scene("MULTI_ANCHOR", 7, "主播连线关注对面主播", "multi_window");
            MULTI_ANCHOR = r110;
            Scene r111 = new Scene("MEDIA_ANCHOR", 8, "媒体连线关注对面主播", "media_window");
            MEDIA_ANCHOR = r111;
            f153390a = new Scene[]{r100, r101, r102, r103, r104, r105, r106, r110, r111};
        }

        public static Scene[] values() {
            return (Scene[]) f153390a.clone();
        }

        public String getFollowEntrancePage() {
            return this.followEntrancePage;
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        public Scene(String r100, int r101, String r102, String r103) {
            super(r100, r101);
            this.description = r102;
            this.followEntrancePage = r103;
        }
    }

    public FollowLog(int r100) {
        this.f153385d = r100;
    }

    public FollowLog(String r100, String r101) {
        this.f153385d = -1;
        this.f153382a = r100;
        this.f153383b = r101;
    }

    public FollowLog(String r100, String r101, int r102) {
        this.f153385d = -1;
        this.f153382a = r100;
        this.f153383b = String.valueOf(r101);
        this.f153385d = r102;
    }
}
