package com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantLynx;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import k73.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: classes12.dex */
public final class VideoCtrlContainerComponent {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f166794g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, e> f166795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f166796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f166797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f166798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k73.b f166799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f166800f;

    public static final class a {
    }

    static {
    }

    public final FrameLayout b() {
        return (FrameLayout) this.f166796b.getValue();
    }

    public final void a(k73.b r210) {
        View r100 = null;
        if (r210.f501993d != null) goto L6;
        dm.a.a("VideoCtrlContainerComponent").b("HeaderLynxContainer is null", null);
        return;
    L6:
        HeaderPendantLynx r101 = k73.c.c(r210);
        if (r101 == null) goto L9;
        String r102 = r101.getLynxUrl();
    L11:
        if (a2.b(r102) == true) goto L14;
        r102 = null;
    L14:
        if (r102 != null) goto L17;
        dm.a.a("VideoCtrlContainerComponent").b("HeaderLynxContainer lynxUrl is null or empty", null);
        return;
    L17:
        e r103 = this.f166795a.get(r102);
        if (r103 == null) goto L24;
        dm.a.a("VideoCtrlContainerComponent").i("componentCache load success lynxUrl = ".concat(r102));
        View r104 = r103.f501998a;
        FrameLayout r105 = b();
        if (r105 == null) goto L55;
        if (r104 == null) goto L56;
        r105.addView(r104, new FrameLayout.LayoutParams(-1, -1));
        return;
    L56:
        return;
    L55:
        return;
    L24:
        dm.a.a("VideoCtrlContainerComponent").i("start createAndCacheLynx lynxUrl = ".concat(r102));
        HeaderPendantLynx r106 = k73.c.c(r210);
        if (r106 == null) goto L29;
        JsonObject r107 = r106.getLynxData();
        if (r107 == null) goto L29;
        JSONObject r108 = k.b(r107);
        r108.put(LocationMonitorConst.IDENTIFIER, AnchorV4DataManager.f166338d);
    L30:
        Uri.Builder r109 = UriProtector.parse(r102).buildUpon();
        r109.appendQueryParameter(LocationMonitorConst.IDENTIFIER, r210.f501990a);
        r109.appendQueryParameter("video_id", r210.f501991b);
        HeaderPendantLynx r110 = k73.c.c(r210);
        if (r110 != null) goto L33;
    L35:
        Map<String, String> r111 = r210.f501995f;
        if (r111 == null) goto L42;
        Iterator<Map.Entry<String, String>> r112 = r111.entrySet().iterator();
    L39:
        if (r112.hasNext() == false) goto L42;
        Map.Entry<String, String> r113 = r112.next();
        r109.appendQueryParameter(r113.getKey(), r113.getValue());
    L42:
        if (r210.f501997h == false) goto L44;
        r109.appendQueryParameter("disable_center_control_icon", "1");
    L44:
        String r114 = r109.build().toString();
        dm.a.a("VideoCtrlContainerComponent").i("start createAndCacheLynx fullUrl = " + r114);
        l r115 = ECLiveHybridUtil.b(this.f166797c, r114, null, null, new com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.a(this, r102), null, null, false, null, null, false, 4076);
        if (r115 == null) goto L57;
        ConcurrentHashMap<String, e> r116 = this.f166795a;
        View r117 = r115.getHybridView();
        if (r117 == null) goto L52;
        FrameLayout r118 = b();
        if (r118 == null) goto L51;
        r118.addView(r117, new FrameLayout.LayoutParams(-1, -1));
    L51:
        Unit r119 = Unit.INSTANCE;
        r100 = r117;
    L52:
        Intrinsics.checkNotNullParameter(r210, "$this$generateLynxId");
        r116.put(r102, new e(r100, r115, r210.f501990a + '_' + r210.f501991b));
        return;
    L57:
        return;
    L33:
        if (r110.getLynxData() == null) goto L35;
        String r120 = UUID.randomUUID().toString();
        r109.appendQueryParameter("mega_object_id", r120);
        HashMap<String, JSONObject> r121 = j.f44312a;
        j.h(r120, r108);
    L29:
        r108 = null;
        goto L30
    L9:
        r102 = null;
        goto L11
    }

    public final void c(int r100) {
        dm.a.a("VideoCtrlContainerComponent").i("updatePlayOrAudioState source = " + r100);
        k73.a r101 = new k73.a(k73.c.b(this.f166799e), k73.c.a(this.f166799e));
        Map<String, k73.a> r102 = com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.utils.a.f166808a;
        String r103 = this.f166799e.f501991b;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.utils.a.a(r103, r101, new VideoCtrlContainerComponent$updatePlayOrAudioState$1(this), VideoCtrlContainerComponent$updatePlayOrAudioState$2.INSTANCE);
    }

    public VideoCtrlContainerComponent(Context r100, ViewGroup r101, k73.b r102, c r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "videoComponentInfo");
        Intrinsics.checkNotNullParameter(r103, "lynxCallback");
        this.f166797c = r100;
        this.f166798d = r101;
        this.f166799e = r102;
        this.f166800f = r103;
        this.f166795a = new ConcurrentHashMap();
        this.f166796b = LazyKt.lazy(new VideoCtrlContainerComponent$videoCtrlContainerFrameLayout$2(this));
    }
}
