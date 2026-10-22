package com.bytedance.android.livesdk.interactivity.comment.share;

import com.baidu.platform.comapi.map.MapController;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class InteractivityShareAppLogger extends com.bytedance.android.livesdk.interactivity.common.utils.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f136222a = 0;

    static {
    }

    @JvmStatic
    public static final void c(final w22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "shareContent");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_audience_live_message", new InteractivityShareAppLogger$sendShare$2(r100));
    }

    @JvmStatic
    public static final void d(final com.bytedance.android.livesdk.interactivity.comment.share.model.a.C2159a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_room_share_panel_send_click", new InteractivityShareAppLogger$sendSharePanelItemClick$1(r100));
    }

    @JvmStatic
    public static final void e(final com.bytedance.android.livesdk.interactivity.comment.share.model.a.C2159a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_room_share_panel_card_show", new InteractivityShareAppLogger$sendSharePanelItemShow$1(r100));
    }
}
