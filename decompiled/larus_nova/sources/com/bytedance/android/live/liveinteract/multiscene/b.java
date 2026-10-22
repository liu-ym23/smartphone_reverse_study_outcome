package com.bytedance.android.live.liveinteract.multiscene;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {
    public static final List<f> a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$fightPlayers");
        ArrayList r101 = new ArrayList();
        if (r100.getTeamInfos() == null) goto L21;
        List<j> r102 = r100.getTeamInfos();
        Intrinsics.checkNotNull(r102);
        if (r102.isEmpty() == true) goto L21;
        List<j> r103 = r100.getTeamInfos();
        Intrinsics.checkNotNull(r103);
        Iterator<j> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L21;
        j r105 = r104.next();
        if (r105 == null) goto L9;
        List<f> r106 = r105.getPlayers();
        Intrinsics.checkNotNull(r106);
        Iterator<f> r107 = r106.iterator();
    L14:
        if (r107.hasNext() == false) goto L16;
        f r108 = r107.next();
        Intrinsics.checkNotNull(r108);
        r108.setServerTeamId(r105.getTeamId());
        goto L14
    L16:
        List r109 = r105.getPlayers();
        if (r109 == null) goto L19;
        List r110 = r109;
    L20:
        r101.addAll(r110);
        goto L9
    L19:
        r110 = new ArrayList();
    L21:
        return r101;
    }

    public static final f b(a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getPlayerByUserId");
        Intrinsics.checkNotNullParameter(r101, "userId");
        Iterator r102 = ((ArrayList) a(r100)).iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        f r103 = (f) r102.next();
        if (r103 == null) goto L4;
        if (Intrinsics.areEqual(r103.getUserIdString(), r101) == false) goto L4;
        return r103;
    L10:
        return null;
    }

    public static final int c(a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getUserTeamId");
        Intrinsics.checkNotNullParameter(r101, "userId");
        if (r100.getTeamInfos() == null) goto L16;
        List<j> r102 = r100.getTeamInfos();
        Intrinsics.checkNotNull(r102);
        if (r102.isEmpty() == true) goto L24;
        List<j> r103 = r100.getTeamInfos();
        Intrinsics.checkNotNull(r103);
        Iterator<j> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L25;
        j r105 = r104.next();
        if (r105 == null) goto L9;
        if (k.a(r105, r101) == null) goto L9;
        return (int) r105.getTeamId();
    L25:
        return 0;
    L24:
        return 0;
    L16:
        return 0;
    }
}
