package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.os.SystemClock;
import com.bytedance.android.livesdkapi.performance.IStallCallback;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class w1 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f131822g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f131823h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f131824i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f131825j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.performance.c f131826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f131827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f131828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y1 f131829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f131830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f131831f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f131832a = null;

        static {
            f131832a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "ENABLE_OPEN_GIFT_PANEL_FPS_MONITOR", "getENABLE_OPEN_GIFT_PANEL_FPS_MONITOR()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "OPEN_GIFT_PANEL_FPS_MONITOR_DURATION", "getOPEN_GIFT_PANEL_FPS_MONITOR_DURATION()J", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "ENABLE_GIFT_PANEL_MONITOR_WINDOW_FPS", "getENABLE_GIFT_PANEL_MONITOR_WINDOW_FPS()Z", 0))};
        }

        public a() {
        }
    }

    public static final class b implements IStallCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w1 f131833a;

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onBlockReady(long r100, int r101, long r102) {
        }

        public b(w1 r100) {
            this.f131833a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onFpsReady(double r210, JSONObject r211) {
            JSONObject r100 = r211;
            long r101 = SystemClock.uptimeMillis() - this.f131833a.f131827b;
            y1 r102 = new y1(0);
            r102.f131844a = (float) r210;
            float r103 = 0.0f;
            if (r100 == null) goto L24;
            float r110 = ((com.bytedance.android.livesdk.revenue.service.performance.c) vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class)).getFrameIntervalMillis();
            Iterator<String> r111 = r211.keys();
            long r112 = 0;
            long r113 = 0;
            long r114 = 0;
            float r104 = 0.0f;
            float r105 = 0.0f;
        L6:
            if (r111.hasNext() == false) goto L23;
            Iterator<String> r115 = r111;
            String r116 = r111.next();
            int r106 = CastIntegerProtector.parseInt(r116);
            int r107 = r100.optInt(r116);
            if (3 <= r106) goto L11;
        L13:
            long r212 = r101;
            if (7 > r106) goto L20;
            if (13 < r106) goto L20;
            r112 = r112 + ((long) r107);
            r104 = r104 + ((r106 * r107) * r110);
        L22:
            r100 = r211;
            r111 = r115;
            r101 = r212;
        L20:
            if (r106 < 14) goto L22;
            r113 = r113 + ((long) r107);
            r105 = r105 + ((r106 * r107) * r110);
            goto L22
        L11:
            if (6 < r106) goto L13;
            r212 = r101;
            r114 = r114 + ((long) r107);
            r103 = r103 + ((r106 * r107) * r110);
            goto L22
        L23:
            long r213 = r101;
            long r108 = r114;
        L25:
            r102.f131850g = r108;
            r102.f131851h = r103;
            r102.f131853j = r112;
            r102.f131854k = r104;
            r102.f131856m = r113;
            r102.f131857n = r105;
            r102.f131847d = (r108 + r112) + r113;
            float r109 = (r103 + r104) + r105;
            r102.f131848e = r109;
            long r117 = r213;
            r102.f131846c = ((double) r109) / r117;
            float r118 = r117;
            r102.f131849f = r103 / r118;
            r102.f131852i = r104 / r118;
            r102.f131855l = r105 / r118;
            r102.f131845b = r117;
            this.f131833a.f131829d = r102;
            jy0.b.d("ttlive_gift_panel_metrics", "open_gift_panel duration=" + r117 + " fps=" + r210 + " dropFrame=" + r211 + " data=" + r102);
            return;
        L24:
            r213 = r101;
            r108 = 0;
            r112 = 0;
            r113 = 0;
            r104 = 0.0f;
            r105 = 0.0f;
            goto L25
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    static {
        f131825j = new a();
        Boolean r100 = Boolean.TRUE;
        Class r101 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_open_gift_panel_fps_monitor", r100, r101, false);
        KProperty<?>[] r103 = a.f131832a;
        KProperty<?> r110 = r103[0];
        f131822g = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r110);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("open_gift_panel_fps_monitor_duration", 2500L, Long.TYPE, false);
        KProperty<?> r111 = r103[1];
        f131823h = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r111);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_gift_panel_monitor_window_fps", Boolean.FALSE, r101, false);
        KProperty<?> r106 = r103[2];
        f131824i = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r106);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        if (this.f131830e == true) goto L5;
        this.f131826a.stopMonitorFps("open_gift_panel", this.f131831f);
        this.f131826a.releaseFpsMonitor("open_gift_panel");
    L5:
        Disposable r100 = this.f131828c;
        if (r100 == null) goto L9;
        r100.dispose();
        return;
    }

    public w1() {
        this.f131826a = (com.bytedance.android.livesdk.revenue.service.performance.c) vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class);
        this.f131827b = -1;
        this.f131831f = new b(this);
    }
}
