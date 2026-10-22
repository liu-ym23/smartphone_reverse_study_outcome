package com.bytedance.android.live.ktv.common.karaokestation.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f {
    public static final FirstLevelTab a(int r100) {
        FirstLevelTab[] r101 = FirstLevelTab.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        FirstLevelTab r104 = r101[r103];
        if (r104.getValue() != r100) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L12;
        r103 = r103 + 1;
    L12:
        if (r104 == null) goto L14;
        return r104;
    L14:
        return FirstLevelTab.Unknown;
    L7:
        r105 = false;
        goto L8
    L11:
        r104 = null;
        goto L12
    }

    public static final String b(FirstLevelTab r100) {
        Intrinsics.checkNotNullParameter(r100, "firstLevelTab");
        int r101 = r100.getValue();
        if (r101 != FirstLevelTab.MySongTab.getValue()) goto L6;
        return "mine";
    L6:
        if (r101 != FirstLevelTab.OrderedSongTab.getValue()) goto L9;
        return "order";
    L9:
        if (r101 != FirstLevelTab.OrderSongTab.getValue()) goto L12;
        return "request";
    L12:
        if (r101 != FirstLevelTab.WantListenTab.getValue()) goto L15;
        return "listen";
    L15:
        if (r101 != FirstLevelTab.AudienceSingTab.getValue()) goto L18;
        return "user_order";
    L18:
        if (r101 != FirstLevelTab.PersonalKaraokeSungTab.getValue()) goto L20;
        return "history";
    L20:
        return "";
    }
}
