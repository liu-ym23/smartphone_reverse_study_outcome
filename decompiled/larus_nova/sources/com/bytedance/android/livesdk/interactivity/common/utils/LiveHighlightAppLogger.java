package com.bytedance.android.livesdk.interactivity.common.utils;

import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Deprecated(message = "use PinContainerAppLogger")
public final class LiveHighlightAppLogger extends b {
    static {
    }

    @JvmStatic
    public static final void c(final int r100) {
        final String r101 = "auto";
        Intrinsics.checkNotNullParameter("auto", "changeType");
        b.a("livesdk_reply_comment_on_wall_change", new LiveHighlightAppLogger$sendCommentOnWallPagerChange$1(r101, r100));
    }

    @JvmStatic
    public static final void d(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r101, "sendUserType");
        b.a("livesdk_video_comment_pin_success", new LiveHighlightAppLogger$sendPinVideoSuccess$1(r100, r101));
    }
}
