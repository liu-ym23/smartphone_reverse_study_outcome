package com.bytedance.android.live.room.api.panel;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {
    public static final e a(b r100, ActionType r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$getPanelInfo");
        Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
        int r103 = e.f99048e;
        Intrinsics.checkNotNullParameter(r100, "panelInfoProvider");
        Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
        return new e(r100.getPanelName(), r100.getUnionId(), r101, r102);
    }
}
