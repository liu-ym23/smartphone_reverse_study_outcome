package com.bytedance.android.gamecp.host_api.cloudgame;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/cloudgame/TeamPlayJoinMode;", "", "", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "NORMAL_JOIN", "PAY_JOIN", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TeamPlayJoinMode extends Enum<TeamPlayJoinMode> {
    public static final a Companion = null;
    public static final TeamPlayJoinMode NORMAL_JOIN = null;
    public static final TeamPlayJoinMode PAY_JOIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TeamPlayJoinMode[] f57362a = null;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        TeamPlayJoinMode r100 = new TeamPlayJoinMode("NORMAL_JOIN", 0, 0);
        NORMAL_JOIN = r100;
        TeamPlayJoinMode r101 = new TeamPlayJoinMode("PAY_JOIN", 1, 1);
        PAY_JOIN = r101;
        f57362a = new TeamPlayJoinMode[]{r100, r101};
        Companion = new a();
    }

    public static TeamPlayJoinMode valueOf(String r100) {
        return (TeamPlayJoinMode) r27.a.a(TeamPlayJoinMode.class, r100);
    }

    public static TeamPlayJoinMode[] values() {
        return (TeamPlayJoinMode[]) f57362a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public TeamPlayJoinMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
