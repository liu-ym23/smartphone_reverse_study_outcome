package com.bytedance.android.live.liveinteract.plantform.model;

/* JADX INFO: loaded from: classes46.dex */
public final class q1 implements am3.c<TeamFightJoinTeamInfo> {
    public q1() {
    }

    public static TeamFightJoinTeamInfo a(am3.g r100) throws Exception {
        TeamFightJoinTeamInfo r101 = new TeamFightJoinTeamInfo();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        r101.teamId = r100.j();
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L9:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    @Override // am3.c
    public final TeamFightJoinTeamInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
