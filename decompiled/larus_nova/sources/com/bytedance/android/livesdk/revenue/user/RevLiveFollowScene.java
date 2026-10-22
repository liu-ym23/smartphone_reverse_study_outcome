package com.bytedance.android.livesdk.revenue.user;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/user/RevLiveFollowScene;", "", "RedPacket", "UserInfo", "ProfilePublicScreen", "MultiAnchor", "PK", "PkBanUserPanel", "MultiAnchorPanel", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevLiveFollowScene extends Enum<RevLiveFollowScene> {
    public static final RevLiveFollowScene MultiAnchor = null;
    public static final RevLiveFollowScene MultiAnchorPanel = null;
    public static final RevLiveFollowScene PK = null;
    public static final RevLiveFollowScene PkBanUserPanel = null;
    public static final RevLiveFollowScene ProfilePublicScreen = null;
    public static final RevLiveFollowScene RedPacket = null;
    public static final RevLiveFollowScene UserInfo = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevLiveFollowScene[] f157524a = null;

    static {
        RevLiveFollowScene r100 = new RevLiveFollowScene("RedPacket", 0);
        RedPacket = r100;
        RevLiveFollowScene r101 = new RevLiveFollowScene("UserInfo", 1);
        UserInfo = r101;
        RevLiveFollowScene r102 = new RevLiveFollowScene("ProfilePublicScreen", 2);
        ProfilePublicScreen = r102;
        RevLiveFollowScene r103 = new RevLiveFollowScene("MultiAnchor", 3);
        MultiAnchor = r103;
        RevLiveFollowScene r104 = new RevLiveFollowScene("PK", 4);
        PK = r104;
        RevLiveFollowScene r105 = new RevLiveFollowScene("PkBanUserPanel", 5);
        PkBanUserPanel = r105;
        RevLiveFollowScene r106 = new RevLiveFollowScene("MultiAnchorPanel", 6);
        MultiAnchorPanel = r106;
        f157524a = new RevLiveFollowScene[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static RevLiveFollowScene valueOf(String r100) {
        return (RevLiveFollowScene) a.a(RevLiveFollowScene.class, r100);
    }

    public static RevLiveFollowScene[] values() {
        return (RevLiveFollowScene[]) f157524a.clone();
    }

    public RevLiveFollowScene(String r100, int r101) {
        super(r100, r101);
    }
}
