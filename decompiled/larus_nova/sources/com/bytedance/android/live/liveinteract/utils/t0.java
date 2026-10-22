package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f78832a = 0;

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "step");
        Intrinsics.checkNotNullParameter(r101, "content");
        if (vm2.h.S().d() == true) goto L7;
        ALogger.i("ttlive_link", "MultiLinkEnterRoom, printKeyLog: step = " + r100 + ", content = " + r101);
        return;
    }
}
