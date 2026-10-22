package com.bytedance.android.gamecp.common.utils;

import com.bytedance.android.gamecp.host_api.GameCpTargetUtils;

/* JADX INFO: loaded from: classes44.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f57224a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f57225b = null;

    static {
        boolean r100 = true;
        if (GameCpTargetUtils.c() == false) goto L6;
    L14:
        String r101 = "p6-webcast.douyinpic.com";
    L15:
        f57224a = r101;
        if (GameCpTargetUtils.c() == false) goto L19;
    L27:
        String r102 = "lf1-webcastcdn-tos.douyinstatic.com";
    L28:
        f57225b = r102;
        return;
    L19:
        if (GameCpTargetUtils.i() == false) goto L22;
        r102 = "lf1-webcastcdn-tos.bdxiguastatic.com";
        goto L28
    L22:
        if (GameCpTargetUtils.a() == 13) goto L25;
        r100 = false;
    L25:
        if (r100 == false) goto L27;
        r102 = "lf1-webcastcdn-tos.toutiaostatic.com";
        goto L28
    L6:
        if (GameCpTargetUtils.i() == false) goto L9;
        r101 = "p6-webcast.bdxiguaimg.com";
        goto L15
    L9:
        if (GameCpTargetUtils.a() != 13) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        r101 = "p6-webcast.toutiaoimg.com";
        goto L15
    L11:
        r103 = false;
        goto L12
    }
}
