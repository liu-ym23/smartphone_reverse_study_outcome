package com.bytedance.android.live.liveinteract.plantform.multiroom;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f77300a = 0;

    static {
    }

    public static void b(DataCenter r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        if (MultiLinkLoadWidgetUtils.b() == true) goto L5;
        return;
    L5:
        MultiLinkLoadWidgetUtils.n(r100, "LogFallBackHelper#clearFlag", "source:" + r101);
        if (r100 == null) goto L9;
        r100.put("data_multi_link_log_last_function", null);
        return;
    }

    public static boolean a(DataCenter r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "source");
        if (MultiLinkLoadWidgetUtils.b() == true) goto L6;
        return false;
    L6:
        Object r103 = null;
        if (r100 == null) goto L9;
        r103 = (Void) r100.get("data_multi_link_log_last_function", null);
    L9:
        String r104 = (String) r103;
        boolean r105 = !Intrinsics.areEqual(r104, r101);
        MultiLinkLoadWidgetUtils.n(r100, "FallBackLogHelper#checkShouldLogFallBack", "shouldLog:" + r105 + ", lastFunction:" + r104 + ", functionType2:" + r101 + ", source:" + r102);
        if (r105 == false) goto L12;
        LiveTracingMonitor.a("FallBackLogHelper", new Throwable("FallBackLogHelper"), "FallBackLogHelper#lastFunction:" + r104 + ", functionType2:" + r101);
    L12:
        return r105;
    }

    public static void c(DataCenter r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "source");
        if (MultiLinkLoadWidgetUtils.b() == true) goto L5;
        return;
    L5:
        MultiLinkLoadWidgetUtils.n(r100, "FallBackLogHelper#recordVoiceRoomShow", "functionType2:" + r101 + ", source:" + r102);
        if (r100 == null) goto L9;
        r100.put("data_multi_link_log_last_function", r101);
        return;
    }
}
