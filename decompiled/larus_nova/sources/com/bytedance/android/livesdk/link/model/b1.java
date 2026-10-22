package com.bytedance.android.livesdk.link.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b1 {
    public static final String a(a1 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toSimpleString");
        StringBuilder r101 = new StringBuilder("BattleDataScore{userId=");
        r101.append(r100.getUserId());
        r101.append(", score=");
        r101.append(r100.getScore());
        if (r100.getScoreRelativeText().length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        String r103 = "";
        if (r102 == false) goto L9;
        String r104 = ", scoreRelative='" + r100.getScoreRelativeText() + '\'';
    L10:
        r101.append(r104);
        r101.append(", isHuge=");
        r101.append(r100.isHugeRewardPk());
        r101.append(", battleRank=");
        r101.append(r100.getBattleRank());
        if (r100.getMultiPkTeamScore() == 0) goto L13;
        String r105 = ", teamPkScore=" + r100.getMultiPkTeamScore();
    L14:
        r101.append(r105);
        if (r100.getMultiPkTeamRank() == 0) goto L17;
        r103 = ", teamPkRank=" + r100.getMultiPkTeamRank();
    L17:
        r101.append(r103);
        r101.append('}');
        return r101.toString();
    L13:
        r105 = "";
        goto L14
    L9:
        r104 = "";
        goto L10
    L5:
        r102 = false;
        goto L6
    }
}
