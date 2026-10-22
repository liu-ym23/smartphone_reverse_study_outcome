package com.bytedance.android.live.liveinteract.plantform.multiroom;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.l;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f77303a = 0;

    static {
    }

    public static a a(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        return (a) r100.get("data_mic_seat_data_service");
    }

    public static ih0.b b(DataCenter r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (ih0.b) r100.get("data_multi_link_dynamic_widget_service");
    }

    public static com.bytedance.android.live.liveinteract.bgComponent.platform.a c(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        return (com.bytedance.android.live.liveinteract.bgComponent.platform.a) r100.get("data_multi_link_theme_bg_service");
    }

    public static l d(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        return (l) r100.get("data_multi_link_ui_service");
    }

    public static void e(DataCenter r100, ih0.b r101, WidgetManager r102) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        r100.put("data_multi_link_dynamic_widget_service", r101);
        if (r102 == null) goto L6;
        r100.put("data_multi_link_dynamic_widget_manager", r102);
        return;
    }
}
