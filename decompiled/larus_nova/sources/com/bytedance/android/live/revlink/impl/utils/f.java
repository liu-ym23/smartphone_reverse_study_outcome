package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.live.network.annotation.PbRequest;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f97657a = 0;

    public static String a(int r100) {
        if (r100 != 1) goto L5;
        return PbRequest.SwitchType.PK;
    L5:
        if (r100 != 7) goto L7;
        return "manual_link";
    L7:
        if (r100 == 14) goto L9;
        return "";
    L9:
        return "game_anchor_connection";
    }

    static {
    }
}
