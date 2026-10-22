package com.bytedance.android.livesdk.link.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i3 {
    public static final String a(IBattleUserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toSimpleString");
        StringBuilder r101 = new StringBuilder("BattleUser{pkResult=");
        r101.append(r100.getPkResult());
        if (r100.getMultiPkTeamId() == 0) goto L5;
        String r102 = ", multiPkTeamId=" + r100.getMultiPkTeamId();
    L6:
        r101.append(r102);
        r101.append('}');
        return r101.toString();
    L5:
        r102 = "";
        goto L6
    }
}
