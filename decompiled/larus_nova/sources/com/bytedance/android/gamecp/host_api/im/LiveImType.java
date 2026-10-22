package com.bytedance.android.gamecp.host_api.im;

import kotlin.Metadata;
import r27.a;
import vv.b;
import vv.f;
import vv.g;
import vv.h;
import vv.i;
import vv.k;
import vv.m;
import vv.n;
import vv.o;
import vv.p;
import vv.r;
import vv.s;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/im/LiveImType;", "", "", "wsMethod", "Ljava/lang/String;", "getWsMethod", "()Ljava/lang/String;", "Ljava/lang/Class;", "Lvv/b;", "clz", "Ljava/lang/Class;", "getClz", "()Ljava/lang/Class;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Class;)V", "OPEN_GAME_CLOUD_GAMING_POD_MESSAGE", "TEAM_PLAY_INFO_MESSAGE", "TEAM_PLAY_APPLY_LIST_CHANGE_MESSAGE", "TEAM_PLAY_X_GAME_CLOSE_MESSAGE", "TEAM_PLAY_DEBUG_ENTRANCE_MESSAGE", "INTERACTION_PLAY_OPEN_CLOUD_GAME_MESSAGE", "INTERACTION_PLAY_AUTH_MESSAGE", "INTERACTION_PLAY_TOAST_MESSAGE", "TEAM_PLAY_APPLY_PERMIT_MESSAGE", "INTERACTION_PLAY_BAN_MESSAGE", "TEAM_PLAY_INTERACTIVE_BAR_MESSAGE", "TEAM_PLAY_NEW_APPLY_MESSAGE", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveImType extends Enum<LiveImType> {
    private static final /* synthetic */ LiveImType[] $VALUES = null;
    public static final LiveImType INTERACTION_PLAY_AUTH_MESSAGE = null;
    public static final LiveImType INTERACTION_PLAY_BAN_MESSAGE = null;
    public static final LiveImType INTERACTION_PLAY_OPEN_CLOUD_GAME_MESSAGE = null;
    public static final LiveImType INTERACTION_PLAY_TOAST_MESSAGE = null;
    public static final LiveImType OPEN_GAME_CLOUD_GAMING_POD_MESSAGE = null;
    public static final LiveImType TEAM_PLAY_APPLY_LIST_CHANGE_MESSAGE = null;
    public static final LiveImType TEAM_PLAY_APPLY_PERMIT_MESSAGE = null;
    public static final LiveImType TEAM_PLAY_DEBUG_ENTRANCE_MESSAGE = null;
    public static final LiveImType TEAM_PLAY_INFO_MESSAGE = null;
    public static final LiveImType TEAM_PLAY_INTERACTIVE_BAR_MESSAGE = null;
    public static final LiveImType TEAM_PLAY_NEW_APPLY_MESSAGE = null;
    public static final LiveImType TEAM_PLAY_X_GAME_CLOSE_MESSAGE = null;
    private final Class<? extends b> clz;
    private final String wsMethod;

    public static LiveImType valueOf(String r100) {
        return (LiveImType) a.a(LiveImType.class, r100);
    }

    public static LiveImType[] values() {
        return (LiveImType[]) $VALUES.clone();
    }

    static {
        LiveImType r100 = new LiveImType("OPEN_GAME_CLOUD_GAMING_POD_MESSAGE", 0, "WebcastCloudGamingPodMessage", vv.a.class);
        OPEN_GAME_CLOUD_GAMING_POD_MESSAGE = r100;
        LiveImType r101 = new LiveImType("TEAM_PLAY_INFO_MESSAGE", 1, "WebcastTeamPlayTeamInfoMessage", r.class);
        TEAM_PLAY_INFO_MESSAGE = r101;
        LiveImType r102 = new LiveImType("TEAM_PLAY_APPLY_LIST_CHANGE_MESSAGE", 2, "WebcastTeamPlayApplyListChangeMessage", m.class);
        TEAM_PLAY_APPLY_LIST_CHANGE_MESSAGE = r102;
        LiveImType r103 = new LiveImType("TEAM_PLAY_X_GAME_CLOSE_MESSAGE", 3, "WebcastTeamPlayXGameCloseMessage", s.class);
        TEAM_PLAY_X_GAME_CLOSE_MESSAGE = r103;
        LiveImType r104 = new LiveImType("TEAM_PLAY_DEBUG_ENTRANCE_MESSAGE", 4, "WebcastPlayDebugEntranceMessage", k.class);
        TEAM_PLAY_DEBUG_ENTRANCE_MESSAGE = r104;
        LiveImType r105 = new LiveImType("INTERACTION_PLAY_OPEN_CLOUD_GAME_MESSAGE", 5, "WebcastInteractionPlayOpenCloudGameMessage", g.class);
        INTERACTION_PLAY_OPEN_CLOUD_GAME_MESSAGE = r105;
        LiveImType r106 = new LiveImType("INTERACTION_PLAY_AUTH_MESSAGE", 6, "WebcastInteractionPlayRealNameAuthMessage", h.class);
        INTERACTION_PLAY_AUTH_MESSAGE = r106;
        LiveImType r107 = new LiveImType("INTERACTION_PLAY_TOAST_MESSAGE", 7, "WebcastInteractionPlayToastMessage", i.class);
        INTERACTION_PLAY_TOAST_MESSAGE = r107;
        LiveImType r108 = new LiveImType("TEAM_PLAY_APPLY_PERMIT_MESSAGE", 8, "WebcastTeamPlayApplyPermitMessage", n.class);
        TEAM_PLAY_APPLY_PERMIT_MESSAGE = r108;
        LiveImType r109 = new LiveImType("INTERACTION_PLAY_BAN_MESSAGE", 9, "WebcastInteractionPlayBanMessage", f.class);
        INTERACTION_PLAY_BAN_MESSAGE = r109;
        LiveImType r110 = new LiveImType("TEAM_PLAY_INTERACTIVE_BAR_MESSAGE", 10, "WebcastTeamPlayInteractiveBarMessage", o.class);
        TEAM_PLAY_INTERACTIVE_BAR_MESSAGE = r110;
        LiveImType r111 = new LiveImType("TEAM_PLAY_NEW_APPLY_MESSAGE", 11, "WebcastTeamPlayNewApplyMessage", p.class);
        TEAM_PLAY_NEW_APPLY_MESSAGE = r111;
        $VALUES = new LiveImType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111};
    }

    public final Class<? extends b> getClz() {
        return this.clz;
    }

    public final String getWsMethod() {
        return this.wsMethod;
    }

    private LiveImType(String r100, int r101, String r102, Class r103) {
        super(r100, r101);
        this.wsMethod = r102;
        this.clz = r103;
    }
}
