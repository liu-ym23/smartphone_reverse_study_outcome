package com.bytedance.android.livesdk.interactivity.pin.utils;

import com.bytedance.android.livesdk.interactivity.common.utils.b;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class PinAppLogger extends b {
    static {
    }

    @JvmStatic
    public static final void c(final String r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "audienceId");
        b.a("livesdk_anchor_audience_link_popup_click", new PinAppLogger$sendInteractPinClick$1(r101, r100));
    }

    @JvmStatic
    public static final void d(final String r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "audienceId");
        b.a("livesdk_anchor_audience_link_popup_show", new PinAppLogger$sendInteractPinShow$1(r101, r100));
    }

    @JvmStatic
    public static final void e(final long r100, final String r101) {
        Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
        b.a("livesdk_anchor_comment_popup_click", new PinAppLogger$sendPinPopupClickVideoEvent$1(r101, r100));
    }

    @JvmStatic
    public static final void f(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "videoId");
        Intrinsics.checkNotNullParameter(r101, "userType");
        b.a("livesdk_video_comment_pin_click", new PinAppLogger$sendVideoCommentPinClick$1(r100, r101));
    }

    @JvmStatic
    public static final void g(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "videoId");
        Intrinsics.checkNotNullParameter(r101, "userType");
        b.a("livesdk_video_comment_pin_show", new PinAppLogger$sendVideoCommentPinShow$1(r100, r101));
    }
}
