package com.bytedance.android.livesdk.chatroom.ui;

import android.view.ScaleGestureDetector;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h7 implements ScaleGestureDetector.OnScaleGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.pushstream.d f113572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f113573b;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        double r101 = r100.getScaleFactor();
        if (Math.abs(r101 - 1.0d) >= 0.03d) goto L7;
        return false;
    L7:
        if (r101 <= 1.0d) goto L9;
        float r102 = 0.1f;
    L10:
        com.bytedance.android.live.broadcast.api.model.y1 r103 = (com.bytedance.android.live.broadcast.api.model.y1) this.f113573b.get("cmd_anchor_broadcast_start_zoom", new com.bytedance.android.live.broadcast.api.model.y1());
        com.bytedance.android.live.broadcast.api.model.z1 r104 = com.bytedance.android.live.broadcast.api.model.r.f59035a;
        Intrinsics.checkNotNullParameter(r103, "currentRatioEntry");
        boolean r105 = com.bytedance.android.live.broadcast.api.model.r.c();
        if (r105 == false) goto L13;
        float r106 = r103.f59046a;
    L14:
        float r107 = r106 + r102;
        com.bytedance.android.live.broadcast.api.model.a2 r108 = com.bytedance.android.live.broadcast.api.model.r.b(com.bytedance.android.livesdk.sharedpref.b.f158117a.a().intValue());
        if (r108 == null) goto L22;
        float r109 = r108.f59026a;
        if (r107 < r109) goto L19;
        r107 = r109;
    L23:
        ALogger.i("CameraZoomManager", "currentRatio:" + r107);
        if (r105 == false) goto L26;
        r103.f59046a = r107;
    L27:
        r103.f59048c = r107;
        this.f113573b.put("cmd_anchor_broadcast_start_zoom", r103);
        return true;
    L26:
        r103.f59047b = r107;
        goto L27
    L19:
        float r110 = r108.f59027b;
        if (r107 > r110) goto L23;
        r107 = r110;
        goto L23
    L22:
        r107 = 1.0f;
        goto L23
    L13:
        r106 = r103.f59047b;
        goto L14
    L9:
        r102 = -0.1f;
        goto L10
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        com.bytedance.android.live.pushstream.d r101 = this.f113572a;
        if (r101 == null) goto L32;
        com.bytedance.android.live.pushstream.b.C1372b r102 = r101.getStatus();
        if (r102 == null) goto L32;
        int r103 = r102.f89392a;
        if (r103 == 2) goto L11;
        if (r103 == 1) goto L11;
        boolean r104 = false;
    L12:
        if (r104 != true) goto L32;
        Integer r105 = (Integer) this.f113573b.get("data_link_state", 0);
        if (r105 == null) goto L17;
        int r106 = r105.intValue();
    L19:
        if (r106 <= 0) goto L22;
        ALogger.i("LiveFocusScaleGestureListener", "link state not allow scale");
        return false;
    L22:
        com.bytedance.android.live.broadcast.api.model.z1 r107 = com.bytedance.android.live.broadcast.api.model.r.f59035a;
        com.bytedance.android.live.broadcast.api.model.a2 r108 = com.bytedance.android.live.broadcast.api.model.r.b(com.bytedance.android.livesdk.sharedpref.b.f158117a.a().intValue());
        if (r108 != null) goto L25;
    L27:
        boolean r109 = false;
    L28:
        if (r109 == true) goto L31;
        ALogger.i("LiveFocusScaleGestureListener", "not allow zoom");
        return false;
    L31:
        return true;
    L25:
        if (r108.f59026a <= 1.0f) goto L27;
        r109 = true;
        goto L28
    L17:
        r106 = 0;
    L11:
        r104 = true;
    L32:
        return false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        float r101 = r100.getScaleFactor();
        HashMap r102 = new HashMap();
        r102.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_take_detail");
        if (r101 < 1.0d) goto L5;
        String r103 = "zoom_in";
    L6:
        r102.put("zoom_type", r103);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_pinch_zoom", r102, new Object[]{Room.class});
        ALogger.i("LiveFocusScaleGestureListener", "onScaleEnd");
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("zoom_type", r103);
        r104.put(MapBundleKey.OfflineMapKey.OFFLINE_RATION, String.valueOf(r101));
        NewBroadcastMonitor.g(NewBroadcastMonitor.SERVICE.SERVICE_CAMERA_START_ZOOM, r104);
        return;
    L5:
        r103 = "zoom_out";
        goto L6
    }

    public h7(com.bytedance.android.live.pushstream.d r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f113572a = r100;
        this.f113573b = r101;
    }
}
