package com.bytedance.android.livesdk.link.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d3 {
    public static final String a(c3 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toSimpleString");
        StringBuilder r101 = new StringBuilder("BattleStatsMeta{channelId=");
        r101.append(r100.getChannelId());
        r101.append(", battleSetting=");
        c1 r102 = r100.getBattleSetting();
        ArrayList r103 = null;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNullParameter(r102, "$this$toSimpleString");
        String r104 = "BattleSettings{battleId=" + r102.getBattleId() + ", battleType=" + r102.getBattleType() + ", mode=" + r102.getMode() + ", finished=" + r102.getFinished() + ", duration=" + r102.getDuration() + ", startTimeMs=" + r102.getStartTimeMs() + ", punishDuration=" + r102.getPunishDuration() + ", punishStartTimeMs=" + r102.getPunishStartTimeMs() + '}';
    L6:
        r101.append(r104);
        r101.append(", battleScores=");
        List<a1> r105 = r100.getBattleScorePairList();
        if (r105 == null) goto L12;
        List<a1> r106 = r105;
        r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r107 = r106.iterator();
    L10:
        if (r107.hasNext() == false) goto L12;
        r103.add(b1.a((a1) r107.next()));
    L12:
        r101.append(r103);
        r101.append(", multiPkTeam=");
        r101.append(r100.getMultiPkTeam());
        r101.append('}');
        return r101.toString();
    L5:
        r104 = null;
        goto L6
    }
}
