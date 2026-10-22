package com.bytedance.android.ec.core.monitor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.apt.IECAPTService;
import com.bytedance.android.ec.core.vmsdk.JsWorkerWrapper;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.TextureRenderKeys;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class MonitorService implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<Context, Unit> f45125a = null;

    public static final class a {
    }

    public MonitorService() {
    }

    static {
        f45125a = new WeakHashMap();
    }

    @Override // com.bytedance.android.ec.core.monitor.o
    public final void b(Context r100, String r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("live", TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter("live", "scriptMethod");
        Intrinsics.checkNotNullParameter(r101, "params");
        c(r100, "live", "live", r101, r110, VmSdkSetting.a().g());
    }

    @Override // com.bytedance.android.ec.core.monitor.o
    public final void a(Context r100, String r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r110, "params");
        c(r100, r101, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.ec.core.monitor.o
    public final void c(Context r100, String r101, String r102, String r103, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "scriptMethod");
        Intrinsics.checkNotNullParameter(r103, "params");
        if (ECAppInfoService.f48114e.isLocalTest() == false) goto L5;
    L6:
        ih.a.f489761d.getClass();
        AtomicBoolean r104 = ih.a.f489760c;
        if (r104.compareAndSet(false, true) == false) goto L13;
        int r105 = ECSdk.f48106a;
        IECAPTService r106 = (IECAPTService) ECSdk.a(IECAPTService.class);
        if (r106 == null) goto L11;
        r106.registerPlugin(ih.a.f489759b);
        goto L13
    L11:
        r104.set(false);
    L13:
        if (r101.length() != 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L19;
        return;
    L19:
        if (r111 != null) goto L21;
        r111 = VmSdkSetting.a().g();
    L21:
        if (r111 == null) goto L41;
        int r108 = ECSdk.f48106a;
        com.bytedance.android.ec.core.vmsdk.a r109 = (com.bytedance.android.ec.core.vmsdk.a) ECSdk.a(com.bytedance.android.ec.core.vmsdk.a.class);
        if (r109 == null) goto L41;
        JsWorkerWrapper r112 = r109.b(r100, new com.bytedance.android.ec.core.vmsdk.b(r111, r101, false, 508));
        if (r112 == null) goto L41;
        Intrinsics.checkNotNullParameter("__MonitorJsStartTime__ = new Date().getTime();", "script");
        if (r112.d("script", "__MonitorJsStartTime__ = new Date().getTime();") == true) goto L30;
        r112.a("__MonitorJsStartTime__ = new Date().getTime();");
    L30:
        String r113 = "app." + r102;
        String[] r114 = new String[2];
        r114[0] = r103;
        if (cg4.a.a(r110) == true) goto L34;
        r110 = null;
    L34:
        if (r110 != null) goto L36;
        r110 = "";
    L36:
        r114[1] = r110;
        r112.b(r113, r114);
        String r115 = "app.sendLogV3('livesdk_check_param_time', {duration: (new Date().getTime()) - __MonitorJsStartTime__, scene: '" + r101 + "', action: 1})";
        Intrinsics.checkNotNullParameter(r115, "script");
        if (r112.d("script", r115) == true) goto L41;
        r112.a(r115);
    L41:
        if (f45125a.containsKey(r100) == true) goto L48;
        Looper r116 = Looper.getMainLooper();
        MonitorService$monitorParams$runnable$1 r117 = new MonitorService$monitorParams$runnable$1(r100);
        if ((!Intrinsics.areEqual(r116, Looper.myLooper())) == false) goto L45;
        new Handler(r116).post(r117);
        return;
    L45:
        r117.run();
        return;
    L48:
        return;
    L15:
        r107 = false;
        goto L16
    L5:
        if (ECSettingKeys.l() == true) goto L6;
    }
}
