package com.bytedance.android.ec.hybrid.list.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.view.Choreographer;
import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.GsonBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.behavior.LynxContext;
import com.optimize.statistics.FrescoMonitorConst;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import yj.t;

/* JADX INFO: loaded from: classes44.dex */
public final class CommonUtilKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f47290a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f47291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f47292b;

        public a(String r100, boolean r101) {
            this.f47291a = r100;
            this.f47292b = r101;
        }

        public final void a() {
            String r100 = this.f47291a;
            Intrinsics.checkNotNullParameter(r100, "schema");
            String r101 = null;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
            Uri r103 = UriProtector.parse(r100);     // Catch: Throwable -> L13
            if (r103 == null) goto L11;
            String r104 = UriProtector.getQueryParameter(r103, "surl");     // Catch: Throwable -> L13
            if (r104 != null) goto L8;
            r104 = UriProtector.getQueryParameter(r103, "url");     // Catch: Throwable -> L13
        L8:
            Uri r105 = UriProtector.parse(r104);     // Catch: Throwable -> L13
            if (r105 == null) goto L15;
            r101 = r105.getPath();     // Catch: Throwable -> L13
        L15:
            IHybridHostService r106 = com.bytedance.android.ec.hybrid.a.h();
            if (r106 == null) goto L22;
            yj.k r107 = r106.getIHybridHostEventService();
            if (r107 == null) goto L23;
            JSONObject r108 = new JSONObject();
            r108.putOpt("result", Integer.valueOf(this.f47292b ? 1 : 0));
            r108.putOpt("schema", r101);
            Unit r109 = Unit.INSTANCE;
            r107.logV3("mall_image_behavior_monitor", r108);
            return;
        L23:
            return;
        L22:
            return;
        L11:
            Result.m9449constructorimpl(null);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f47293a;

        public b(Function0 r100) {
            this.f47293a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            this.f47293a.invoke();
        }
    }

    static {
        f47290a = LazyKt.lazy(CommonUtilKt$imageBehaviorsMonitorOptEnable$2.INSTANCE);
    }

    public static final com.bytedance.android.ec.hybrid.card.util.h b() {
        com.bytedance.android.ec.hybrid.card.util.i r100 = com.bytedance.android.ec.hybrid.card.util.i.f46607e;
        IHybridHostService r101 = com.bytedance.android.ec.hybrid.a.h();
        if (r101 == null) goto L7;
        yj.i r102 = r101.getIHybridHostAppInfo();
        if (r102 == null) goto L7;
        Context r103 = r102.getApplicationContext();
    L8:
        if (r103 == null) goto L103;
        AtomicInteger r104 = com.bytedance.android.ec.hybrid.card.util.i.f46604b;
        boolean r105 = true;
        if (r104.get() != 0) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == false) goto L82;
        monitor-enter(r100);
    L75:
        th = move-exception;
        throw th;
    L18:
        if (r104.get() != 1) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == false) goto L24;
    L77:
        monitor-exit(r100);
        goto L82
    L24:
        if (r104.get() != 2) goto L26;
        boolean r108 = true;
    L27:
        if (r108 == true) goto L77;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L48
        Object r110 = r103.getSystemService("activity");     // Catch: Throwable -> L48
        if ((r110 instanceof ActivityManager) == true) goto L32;
        r110 = null;
    L32:
        ActivityManager r111 = (ActivityManager) r110;     // Catch: Throwable -> L48
        if (r111 == null) goto L35;
        ConfigurationInfo r112 = r111.getDeviceConfigurationInfo();     // Catch: Throwable -> L48
    L36:
        if (r112 == null) goto L39;
        int r113 = r112.reqGlEsVersion;     // Catch: Throwable -> L48
    L41:
        if (r113 < 196608) goto L43;
        boolean r114 = true;
    L94:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L46
    L51:
        if (r114 == true) goto L92;
        com.bytedance.android.ec.hybrid.card.util.i.f46604b.set(2);     // Catch: Throwable -> L75
        Lazy r115 = ECMallLogUtil.f47441a;     // Catch: Throwable -> L75
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.card.util.i.f46603a, "initAnimaXInstance fail, es version not support");     // Catch: Throwable -> L75
        monitor-exit(r100);
        goto L82
    L92:
        Method r116 = com.bytedance.android.ec.hybrid.card.util.i.a().getMethod("inst", new Class[0]);     // Catch: Exception -> L65 Throwable -> L75
        if (r116 == null) goto L58;
        Object r117 = r116.invoke(null, new Object[0]);     // Catch: Exception -> L65 Throwable -> L75
    L59:
        com.bytedance.android.ec.hybrid.card.util.i.f46605c = r117;     // Catch: Exception -> L65 Throwable -> L75
        if (r117 == null) goto L62;
        Method r118 = r117.getClass().getMethod("createUI", new Class[]{LynxContext.class});     // Catch: Exception -> L65 Throwable -> L75
    L63:
        com.bytedance.android.ec.hybrid.card.util.i.f46606d = r118;     // Catch: Exception -> L65 Throwable -> L75
    L68:
        if (com.bytedance.android.ec.hybrid.card.util.i.f46605c != null) goto L70;
    L72:
        com.bytedance.android.ec.hybrid.card.util.i.f46604b.set(2);     // Catch: Throwable -> L75
        Lazy r119 = ECMallLogUtil.f47441a;     // Catch: Throwable -> L75
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.card.util.i.f46603a, "initAnimaXInstance fail, sAnimaXInstance: " + com.bytedance.android.ec.hybrid.card.util.i.f46605c + ", sCreateUIMethod: " + com.bytedance.android.ec.hybrid.card.util.i.f46606d);     // Catch: Throwable -> L75
    L73:
        monitor-exit(r100);
        goto L82
    L70:
        if (com.bytedance.android.ec.hybrid.card.util.i.f46606d == null) goto L72;
        com.bytedance.android.ec.hybrid.card.util.i.f46604b.set(1);     // Catch: Throwable -> L75
        Lazy r120 = ECMallLogUtil.f47441a;     // Catch: Throwable -> L75
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.card.util.i.f46603a, "initAnimaXInstance success");     // Catch: Throwable -> L75
        goto L73
    L62:
        r118 = null;
        goto L63
    L58:
        r117 = null;
    L65:
        e = move-exception;
        Lazy r121 = ECMallLogUtil.f47441a;     // Catch: Throwable -> L75
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.card.util.i.f46603a, "initAnimaXInstance fail, e: " + e.getMessage());     // Catch: Throwable -> L75
    L46:
        Throwable th10 = th;
    L50:
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L75
        Result.m9449constructorimpl(ResultKt.createFailure(th10));     // Catch: Throwable -> L75
        goto L51
    L43:
        r114 = false;
        goto L94
    L39:
        r113 = 0;
        goto L41
    L35:
        r112 = null;
    L48:
        th = move-exception;
        th10 = th;
        r114 = false;
        goto L50
    L26:
        r108 = false;
        goto L27
    L20:
        r107 = false;
    L82:
        if (com.bytedance.android.ec.hybrid.card.util.i.f46604b.get() == 1) goto L85;
        r105 = false;
    L85:
        if (r105 == true) goto L99;
        Lazy r123 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.card.util.i.f46603a, "mapLottieToAnimaX fail, init not success");
        return null;
    L99:
        return new com.bytedance.android.ec.hybrid.card.util.h();
    L89:
        e = move-exception;
        Lazy r124 = ECMallLogUtil.f47441a;
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.card.util.i.f46603a, "mapLottieToAnimaX fail. e: " + e.getMessage());
        return null;
    L13:
        r106 = false;
        goto L14
    L103:
        return null;
    L7:
        r103 = null;
        goto L8
    }

    public static final List<Object> a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "schema");
        List<Object> r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        Uri r102 = UriProtector.parse(r110);     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L11:
        if (r102 == null) goto L15;
        String r103 = UriProtector.getQueryParameter(r102, FrescoMonitorConst.SCENE_TAG);
        if (r103 == null) goto L15;
    L16:
        String r104 = r103;
        if (r102 == null) goto L21;
        String r105 = UriProtector.getQueryParameter(r102, "biz_tag");
        if (r105 == null) goto L21;
    L22:
        String r106 = r105;
        LinkedHashMap r107 = new LinkedHashMap();
        r107.putAll(com.bytedance.android.ec.hybrid.list.entity.dto.c.a());
        if (r102 == null) goto L48;
        String r108 = UriProtector.getQueryParameter(r102, "ecom_image_log_extra");
        if (r108 == null) goto L48;
        if ((!StringsKt.isBlank(r108)) == true) goto L30;
        r108 = null;
    L30:
        if (r108 == null) goto L48;
        Iterator r109 = ((Map) new GsonBuilder().create().fromJson(r108, HashMap.class)).entrySet().iterator();     // Catch: Throwable -> L45
    L33:
        if (r109.hasNext() == false) goto L43;
        Map.Entry r111 = (Map.Entry) r109.next();     // Catch: Throwable -> L45
        if ((r111.getKey() instanceof String) == false) goto L33;
        if (r111.getValue() == null) goto L33;
        Object r112 = r111.getKey();     // Catch: Throwable -> L45
        if (r112 == null) goto L42;
        r107.put((String) r112, r111.getValue());     // Catch: Throwable -> L45
        goto L33
    L42:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L45
    L43:
        Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L47:
        Result.m9448boximpl(r113);
    L45:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L48:
        IHybridHostService r115 = com.bytedance.android.ec.hybrid.a.h();
        if (r115 == null) goto L53;
        yj.g r116 = r115.getHostAB();
        if (r116 == null) goto L53;
        Integer r117 = (Integer) r116.a("ec_image_async_create", 0);
    L54:
        if (r117 != null) goto L57;
    L59:
        boolean r118 = false;
    L60:
        int r119 = com.bytedance.android.ec.base.settings.c.f42815a;
        Object r120 = 1;
        Object r121 = com.bytedance.android.ec.base.settings.d.f42818c.get("ecom_image_autosize");     // Catch: Throwable -> L110
        if (r121 != null) goto L65;
    L107:
        Object r122 = null;
    L108:
        Object r123 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L110
    L112:
        Throwable r124 = Result.m9452exceptionOrNullimpl(r123);     // Catch: Throwable -> L135
        if (r124 == null) goto L116;
        EnsureManager.ensureNotReachHere(r124);     // Catch: Throwable -> L135
    L116:
        if (Result.m9455isFailureimpl(r123) == false) goto L119;
        r123 = null;
    L119:
        if ((r123 instanceof Integer) == true) goto L121;
        r123 = null;
    L121:
        Object r125 = (Integer) r123;     // Catch: Throwable -> L135
        if (r125 == null) goto L124;
        r120 = r125;
    L144:
        if (((Number) r120).intValue() != 1) goto L146;
        boolean r126 = true;
    L147:
        t r127 = com.bytedance.android.ec.hybrid.a.g();
        if (r127 == null) goto L151;
        List<Object> r128 = r127.getImageBehaviors(r106, r104, r107, String.valueOf(r102), r118, r126);
        if (r128 == null) goto L151;
    L153:
        if (r128.isEmpty() == false) goto L155;
        f(r110, false);
    L156:
        int r129 = com.bytedance.android.ec.hybrid.monitor.g.f47561a;
        Iterator r130 = CollectionsKt.emptyList().iterator();
    L158:
        if (r130.hasNext() == false) goto L160;
        r128.add(r130.next());
        goto L158
    L160:
        t r131 = com.bytedance.android.ec.hybrid.a.g();
        if (r131 == null) goto L163;
        r100 = r131.getBehaviorsFromXelemet();
    L163:
        if (r100 == null) goto L165;
        r128.addAll(r100);
    L165:
        return r128;
    L155:
        f(r110, true);
    L151:
        r128 = new ArrayList();
        goto L153
    L146:
        r126 = false;
        goto L147
    L124:
        IHybridHostService r132 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L135
        if (r132 == null) goto L127;
        Object r133 = r132.getHostABValue("ecom_image_autosize", r120);     // Catch: Throwable -> L135
    L128:
        if (r133 == null) goto L144;
        if ((r133 instanceof Integer) == true) goto L132;
        r133 = null;
    L132:
        Object r134 = (Integer) r133;     // Catch: Throwable -> L135
        if (r134 == null) goto L144;
    L142:
        r120 = r134;
        goto L144
    L127:
        r133 = null;
        goto L128
    L65:
        if ((r121 instanceof Integer) == true) goto L67;
        Object r135 = null;
    L68:
        r122 = (Integer) r135;     // Catch: Throwable -> L110
        if (r122 != null) goto L108;
        if ((r121 instanceof Number) == false) goto L95;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L80;
        Float r136 = Float.valueOf(((Number) r121).floatValue());     // Catch: Throwable -> L110
        if ((r136 instanceof Integer) == true) goto L78;
        r136 = null;
    L78:
        r122 = (Integer) r136;     // Catch: Throwable -> L110
        goto L108
    L80:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L86;
        Double r137 = Double.valueOf(((Number) r121).doubleValue());     // Catch: Throwable -> L110
        if ((r137 instanceof Integer) == true) goto L84;
        r137 = null;
    L84:
        r122 = (Integer) r137;     // Catch: Throwable -> L110
        goto L108
    L86:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L89;
        r122 = Integer.valueOf(((Number) r121).intValue());     // Catch: Throwable -> L110
        goto L108
    L89:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L95;
        Long r138 = Long.valueOf(((Number) r121).longValue());     // Catch: Throwable -> L110
        if ((r138 instanceof Integer) == true) goto L93;
        r138 = null;
    L93:
        r122 = (Integer) r138;     // Catch: Throwable -> L110
    L95:
        if ((r121 instanceof JSONObject) == false) goto L97;
    L174:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L103
        Object r139 = SDKSettingsCacheManager.a().fromJson(r121.toString(), Integer.class);     // Catch: Throwable -> L103
        if ((r139 instanceof Integer) == true) goto L101;
        r139 = null;
    L101:
        Object r140 = Result.m9449constructorimpl((Integer) r139);     // Catch: Throwable -> L103
    L105:
        r122 = r140;
        if (Result.m9455isFailureimpl(r122) == false) goto L108;
    L103:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L110
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L110
        goto L105
    L97:
        if ((r121 instanceof JSONArray) == false) goto L107;
    L67:
        r135 = r121;
    L135:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r143 = Result.m9452exceptionOrNullimpl(r134);
        if (r143 == null) goto L140;
        EnsureManager.ensureNotReachHere(r143);
    L140:
        if (Result.m9455isFailureimpl(r134) == false) goto L142;
    L110:
        th = move-exception;
        Result.Companion r144 = Result.Companion;     // Catch: Throwable -> L135
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L135
        goto L112
    L57:
        if (r117.intValue() != 1) goto L59;
        r118 = true;
    L53:
        r117 = null;
    L21:
        r105 = "ec_na_mall";
    L15:
        r103 = "ec_na_mall_lynx_card";
    L6:
        Throwable th10 = th;
    L10:
        Result.Companion r145 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th10));
    L8:
        th = move-exception;
        th10 = th;
        r102 = null;
        goto L10
    }

    public static final s c(View r210) {
        Intrinsics.checkNotNullParameter(r210, "$this$getExposurePercent");
        Rect r100 = new Rect();
        if (r210.getLocalVisibleRect(r100) == false) goto L23;
        double r101 = r210.getHeight();
        double r102 = r210.getWidth();
        double r103 = r100.left;
        double r104 = r100.top;
        double r110 = r100.right;
        double r105 = r100.bottom;
        double r111 = ((r110 - r103) * (r105 - r104)) / (r102 * r101);
        if (r103 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        boolean r112 = true;
    L9:
        if (r110 >= r102) goto L11;
        boolean r211 = true;
    L13:
        if (r104 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        boolean r212 = true;
    L17:
        if (r105 >= r101) goto L19;
        boolean r213 = true;
    L21:
        return new s(r111, r112, r211, r212, r213);
    L19:
        r213 = false;
        goto L21
    L15:
        r212 = false;
        goto L17
    L11:
        r211 = false;
        goto L13
    L7:
        r112 = false;
        goto L9
    L23:
        return new s(AudioStats.AUDIO_AMPLITUDE_NONE, false, false, false, false);
    }

    public static final void g(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        Choreographer.getInstance().postFrameCallback(new b(r100));
    }

    public static final s d(View r110, RecyclerView r111) {
        Intrinsics.checkNotNullParameter(r110, "$this$getExposurePercentByY");
        Intrinsics.checkNotNullParameter(r111, "recyclerView");
        float r100 = r110.getY();
        int r112 = r110.getMeasuredHeight();
        int r113 = r111.getMeasuredHeight();
        if (r100 >= 0) goto L5;
        boolean r101 = true;
    L6:
        float r102 = r112 + r100;
        float r114 = r113;
        if (r102 <= r114) goto L9;
        boolean r115 = true;
    L10:
        if (r101 == false) goto L13;
        double r103 = r102;
    L12:
        double r104 = r103 / ((double) r112);
    L17:
        return new s(r104, false, false, r101, r115);
    L13:
        if (r115 == false) goto L15;
        r103 = r114 - r100;
        goto L12
    L15:
        r104 = 1.0d;
        goto L17
    L9:
        r115 = false;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    public static final void f(String r100, boolean r101) {
        if (((Boolean) f47290a.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        com.bytedance.android.ec.hybrid.a.d().submit(new a(r100, r101));
    }

    public static final Object e(Map<String, ? extends Object> r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$getOrDefaultValue");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "default");
        if (r100.containsKey(r101) == false) goto L9;
        Object r103 = r100.get(r101);
        if (r103 != null) goto L8;
        return r102;
    L8:
        return r103;
    L9:
        return r102;
    }
}
