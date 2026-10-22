package com.bytedance.android.ec.window.base.shop;

import android.content.Context;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f49648a;

    static {
    }

    public static void b(String r100, PostActionType r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(LiveEndPageData.TAG_WINDOW, "pageId");
        int r102 = ECSdk.f48106a;
        IECUserTrackerService r103 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r103 == null) goto L8;
        of.a r104 = r103.getMarketingService();
        if (r104 == null) goto L9;
        r104.a(r100, r101, LiveEndPageData.TAG_WINDOW);
        return;
    L9:
        return;
    }

    public static void a(Context r100, boolean r101, ECWindowDialogFragment r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(LiveEndPageData.TAG_WINDOW, "pageId");
        f49648a = false;
        int r102 = ECSdk.f48106a;
        IECUserTrackerService r103 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r103 == null) goto L6;
        r103.enterPage(new of.b(r100, LiveEndPageData.TAG_WINDOW, r101, r110, 16));
        return;
    }
}
