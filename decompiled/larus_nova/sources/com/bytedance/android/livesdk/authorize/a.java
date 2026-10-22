package com.bytedance.android.livesdk.authorize;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f104200a = 0;

    static {
    }

    public static String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (puc.a.isInstalledApp(r100, "com.ss.android.ugc.aweme") == false) goto L7;
        return "douyin";
    L7:
        if (puc.a.isInstalledApp(r100, "com.ss.android.ugc.aweme.lite") == false) goto L10;
        return "douyinLite";
    L10:
        return "H5";
    }
}
