package com.bytedance.android.live.revlink.impl.multianchor.pk.team;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/pk/team/TeamStatus;", "", "LEFT", "RIGHT", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TeamStatus extends Enum<TeamStatus> {
    public static final TeamStatus LEFT = null;
    public static final TeamStatus RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TeamStatus[] f94557a = null;

    static {
        TeamStatus r100 = new TeamStatus("LEFT", 0);
        LEFT = r100;
        TeamStatus r101 = new TeamStatus("RIGHT", 1);
        RIGHT = r101;
        f94557a = new TeamStatus[]{r100, r101};
    }

    public static TeamStatus valueOf(String r100) {
        return (TeamStatus) a.a(TeamStatus.class, r100);
    }

    public static TeamStatus[] values() {
        return (TeamStatus[]) f94557a.clone();
    }

    public TeamStatus(String r100, int r101) {
        super(r100, r101);
    }
}
