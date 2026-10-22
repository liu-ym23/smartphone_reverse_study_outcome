package com.bytedance.android.livesdk.interactivity.pin.container.v2.utils;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.d;
import g42.h;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class PinContainerAppLogger extends com.bytedance.android.livesdk.interactivity.common.utils.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f138864a = 0;

    static {
    }

    public static void d(final boolean r100, final PinType r101) {
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_pin_popup_window_click", new PinContainerAppLogger$logFirstPinDialogClick$1(r100, r101));
    }

    public static void e(final boolean r100, final PinType r101) {
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_pin_popup_window_show", new PinContainerAppLogger$logFirstPinDialogShow$1(r100, r101));
    }

    @JvmStatic
    public static final void c(final h<?> r100, final boolean r101, final boolean r102, final List<? extends d> r103) {
        Intrinsics.checkNotNullParameter(r100, "pinEvent");
        Intrinsics.checkNotNullParameter(r103, "injectors");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_pin", new PinContainerAppLogger$logClickPin$1(r100, r101, r102, r103));
    }

    public static void g(final HighlightItem r100, final PinType r101, final String r102, final List r103) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "changeType");
        Intrinsics.checkNotNullParameter(r103, "injectors");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_on_wall_change", new PinContainerAppLogger$logPinItemShow$1(r101, r102, r103, r100));
    }

    public static void h(final HighlightItem r110, final PinType r111, final long r112, final boolean r113, final long r114, final List r115) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r115, "injectors");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_on_wall_review_duration", new PinContainerAppLogger$logReviewDuration$1(r111, r112, r113, r114, r115, r110));
    }

    @JvmStatic
    public static final void i(final HighlightItem r100, final PinType r110, final long r111, final String r112, final boolean r113, final List<? extends d> r114) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r112, "commentContent");
        Intrinsics.checkNotNullParameter(r114, "injectors");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_on_wall", new PinContainerAppLogger$logReviewSuccess$1(r110, r111, r112, r113, r114, r100));
    }

    public static void f(final HighlightItem r110, final PinType r111, final long r112, final String r113, final boolean r114, final String r115, final List r116) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r113, "commentContent");
        Intrinsics.checkNotNullParameter(r115, "deleteWay");
        Intrinsics.checkNotNullParameter(r116, "injectors");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_comment_delete_v2", new PinContainerAppLogger$logPinItemDeleted$1(r111, r112, r113, r114, r115, r116, r110));
    }
}
