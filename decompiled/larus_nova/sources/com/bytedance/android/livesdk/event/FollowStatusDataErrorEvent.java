package com.bytedance.android.livesdk.event;

/* JADX INFO: loaded from: classes8.dex */
public final class FollowStatusDataErrorEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.base.model.user.c0 f123305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FollowDataSource f123306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f123307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f123308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f123309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f123310f;

    public static final enum FollowDataSource extends Enum<FollowDataSource> {
        public static final FollowDataSource END_LIVE_FOLLOW = null;
        public static final FollowDataSource ENTER_ROOM_FOLLOW = null;
        public static final FollowDataSource PROFILE_FOLLOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FollowDataSource[] f123311a = null;
        String source;

        static {
            FollowDataSource r100 = new FollowDataSource("ENTER_ROOM_FOLLOW", 0, "enter_room_follow");
            ENTER_ROOM_FOLLOW = r100;
            FollowDataSource r101 = new FollowDataSource("PROFILE_FOLLOW", 1, "profile_follow");
            PROFILE_FOLLOW = r101;
            FollowDataSource r102 = new FollowDataSource("END_LIVE_FOLLOW", 2, "end_live_follow");
            END_LIVE_FOLLOW = r102;
            f123311a = new FollowDataSource[]{r100, r101, r102};
        }

        public static FollowDataSource[] values() {
            return (FollowDataSource[]) f123311a.clone();
        }

        public String getSource() {
            return this.source;
        }

        public static FollowDataSource valueOf(String r100) {
            return (FollowDataSource) r27.a.a(FollowDataSource.class, r100);
        }

        public FollowDataSource(String r100, int r101, String r102) {
            super(r100, r101);
            this.source = r102;
        }
    }

    public FollowStatusDataErrorEvent(com.bytedance.android.live.base.model.user.c0 r100, FollowDataSource r101, String r102, String r103, String r104, String r105) {
        this.f123305a = null;
        this.f123306b = null;
        this.f123307c = "";
        this.f123308d = "";
        this.f123309e = "";
        this.f123310f = "";
        this.f123305a = r100;
        this.f123306b = r101;
        this.f123307c = r102;
        this.f123308d = r103;
        this.f123309e = r104;
        this.f123310f = r105;
    }
}
