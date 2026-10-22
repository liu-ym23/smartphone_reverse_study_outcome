package com.bytedance.android.livesdk.interactivity.api.monitor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.settings.config.f;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.d0;

/* JADX INFO: loaded from: classes9.dex */
public final class DanmakuMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f133295a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f133296b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f133297c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f133298d = null;

    static {
        f133295a = d0.f536164a.getValue();
        f133296b = LazyKt.lazy(DanmakuMonitor$receiveList$2.INSTANCE);
        f133297c = LazyKt.lazy(DanmakuMonitor$showList$2.INSTANCE);
        f133298d = LazyKt.lazy(DanmakuMonitor$dropList$2.INSTANCE);
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        if (f133295a.monitorCarnivalModel == true) goto L5;
        return;
    L5:
        c r101 = new c(0, r100, 0, null, 13);
        r101.b(InteractivityTraceMonitor.Event.CarnivalModelDownload);
        ALogger.i("ttlive_danmaku_carnival_model_download", r101.toString());
    }

    @JvmStatic
    public static final void c(boolean r100) {
        if (f133295a.monitorPrivilegeShow == true) goto L5;
        return;
    L5:
        Lazy r101 = f133296b;
        if (((List) r101.getValue()).isEmpty() == false) goto L8;
        return;
    L8:
        int r102 = 0;
        if (r100 == false) goto L11;
        String r103 = "portrait";
    L12:
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("receive", ((List) r101.getValue()).toString());
        r104.put("show", ((List) f133297c.getValue()).toString());
        r104.put("drop", ((List) f133298d.getValue()).toString());
        Unit r105 = Unit.INSTANCE;
        c r106 = new c(r102, r103, 0, r104, 5);
        r106.b(InteractivityTraceMonitor.Event.PrivilegeDanmakuShow);
        d(10086, null);
        ALogger.i("ttlive_danmaku_privilege_message_summary", r106.toString());
        return;
    L11:
        r103 = "landscape";
        goto L12
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "status");
        if (f133295a.monitorOpenContour == true) goto L5;
        return;
    L5:
        int r102 = 0;
        long r103 = 0;
        LinkedHashMap r104 = new LinkedHashMap();
        if (r101 == null) goto L8;
        r104.put("extraInfo", r101);
    L8:
        Unit r105 = Unit.INSTANCE;
        c r106 = new c(r102, r100, r103, r104, 5);
        r106.b(InteractivityTraceMonitor.Event.CarnivalOpenContour);
        ALogger.i("ttlive_danmaku_carnival_open_contour", r106.toString());
    }

    @JvmStatic
    public static final void d(int r100, Long r101) {
        if (f133295a.monitorPrivilegeShow == true) goto L6;
        return;
    L6:
        if (r100 != 1) goto L8;
        if (r101 == null) goto L27;
        long r102 = r101.longValue();
        ((List) f133296b.getValue()).add(Long.valueOf(r102));
        return;
    L27:
        return;
    L8:
        if (r100 != 2) goto L10;
        if (r101 == null) goto L25;
        long r103 = r101.longValue();
        ((List) f133297c.getValue()).add(Long.valueOf(r103));
        return;
    L25:
        return;
    L10:
        if (r100 != 3) goto L12;
        if (r101 == null) goto L23;
        long r104 = r101.longValue();
        ((List) f133298d.getValue()).add(Long.valueOf(r104));
        return;
    L23:
        return;
    L12:
        if (r100 != 10086) goto L28;
        ((List) f133296b.getValue()).clear();
        ((List) f133297c.getValue()).clear();
        ((List) f133298d.getValue()).clear();
        return;
    }
}
