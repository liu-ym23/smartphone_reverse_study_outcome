package com.bytedance.android.ec.hybrid.card.cache.template;

import android.net.Uri;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.card.util.ECLynxBuildUtilKt;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.monitor.g;
import com.bytedance.android.ec.hybrid.tools.f;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.lynx.canvas.LynxGroupKryptonConfigs;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f46431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f46433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f46434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f46435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f46436f;

    public a() {
        int r100 = f.f47635a;
        boolean r101 = true;
        Object r102 = 1;
        int r103 = com.bytedance.android.ec.base.settings.c.f42815a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L81
        Object r105 = null;
        Object r106 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_mall_lynx_screen_size_opt");     // Catch: Throwable -> L54
        if (r106 != null) goto L9;
    L51:
        Object r107 = null;
    L52:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L54
    L56:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L81
        if (r109 == null) goto L60;
        EnsureManager.ensureNotReachHere(r109);     // Catch: Throwable -> L81
    L60:
        if (Result.m9455isFailureimpl(r108) == false) goto L63;
        r108 = null;
    L63:
        if ((r108 instanceof Integer) == true) goto L65;
        r108 = null;
    L65:
        Integer r110 = (Integer) r108;     // Catch: Throwable -> L81
        if (r110 == null) goto L68;
        r102 = r110;
    L90:
        if (((Number) r102).intValue() == 1) goto L93;
        r101 = false;
    L93:
        this.f46431a = r101;
        this.f46432b = "share_group";
        this.f46433c = "group";
        this.f46434d = LynxGroupKryptonConfigs.CONFIG_ENABLE_CANVAS;
        this.f46435e = "enable_canvas_optimization";
        this.f46436f = "enable_dynamic_v8";
        return;
    L68:
        IHybridHostService r111 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L81
        if (r111 == null) goto L71;
        Object r112 = r111.getHostABValue("ec_mall_lynx_screen_size_opt", r102);     // Catch: Throwable -> L81
    L72:
        if (r112 == null) goto L90;
        if ((r112 instanceof Integer) == false) goto L77;
        r105 = r112;
    L77:
        Integer r113 = (Integer) r105;     // Catch: Throwable -> L81
        if (r113 == null) goto L90;
        r102 = r113;
        goto L90
    L71:
        r112 = null;
        goto L72
    L9:
        if ((r106 instanceof Integer) == true) goto L11;
        Object r114 = null;
    L12:
        r107 = (Integer) r114;     // Catch: Throwable -> L54
        if (r107 != null) goto L52;
        if ((r106 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r115 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L54
        if ((r115 instanceof Integer) == true) goto L22;
        r115 = null;
    L22:
        r107 = (Integer) r115;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r116 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L54
        if ((r116 instanceof Integer) == true) goto L28;
        r116 = null;
    L28:
        r107 = (Integer) r116;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r107 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r117 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L54
        if ((r117 instanceof Integer) == true) goto L37;
        r117 = null;
    L37:
        r107 = (Integer) r117;     // Catch: Throwable -> L54
    L39:
        if ((r106 instanceof JSONObject) == false) goto L41;
    L95:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L47
        Object r118 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r118 instanceof Integer) == true) goto L45;
        r118 = null;
    L45:
        Object r119 = Result.m9449constructorimpl((Integer) r118);     // Catch: Throwable -> L47
    L49:
        r107 = r119;
        if (Result.m9455isFailureimpl(r107) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L54
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r106 instanceof JSONArray) == false) goto L51;
    L11:
        r114 = r106;
    L54:
        th = move-exception;
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L81
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        Object r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r124 = Result.m9452exceptionOrNullimpl(r123);
        if (r124 == null) goto L86;
        EnsureManager.ensureNotReachHere(r124);
    L86:
        if (Result.m9455isFailureimpl(r123) == true) goto L90;
        r102 = r123;
        goto L90
    }

    @Override // com.bytedance.android.ec.hybrid.card.cache.template.b
    public final com.bytedance.lynx.service.model.a a(c r110, t07.a r111) {
        Intrinsics.checkNotNullParameter(r110, "param");
        Intrinsics.checkNotNullParameter(r111, "lynxKitService");
        com.bytedance.lynx.service.model.a r112 = r111.a();
        if ((r112 instanceof x07.a) == false) goto L5;
        yz6.a r100 = ((x07.a) r112).f562049a;
        int r101 = tj.a.f546378b;
        r100.f569545c = new tj.a(r110.f46447k);
    L5:
        Integer r102 = r110.f46437a;
        if (r102 == null) goto L8;
        r112.l(Integer.valueOf(r102.intValue()));
    L8:
        Integer r103 = r110.f46438b;
        if (r103 == null) goto L11;
        r112.m(Integer.valueOf(r103.intValue()));
    L11:
        r112.o();
        r112.p(r110.f46445i);
        long r104 = System.currentTimeMillis();
        r112.h();
        List<String> r105 = r110.f46440d;
        if (r105 == null) goto L17;
        int r106 = r105.size();
        int r107 = 1;
    L14:
        if (r107 >= r106) goto L17;
        String r108 = (String) ListProtector.get(r105, r107);
        r112.j();
        r107 = r107 + 1;
    L17:
        if (r110.f46441e == null) goto L19;
        r112.n();
    L19:
        xj.b r109 = r110.f46447k;
        if (r109 == null) goto L22;
        r109.onTransDataTime(r104, System.currentTimeMillis());
    L22:
        g.b(r112);
        com.bytedance.android.ec.hybrid.card.util.b r113 = com.bytedance.android.ec.hybrid.card.util.b.f46595c;
        String r114 = r110.f46444h;
        Map<String, Object> r115 = r110.f46442f;
        Map<String, Object> r116 = r110.f46443g;
        r113.getClass();
        com.bytedance.android.ec.hybrid.card.util.b.b(r114, r115, r116);
        r112.d();
        r112.i();
        if (r110.f46448l == null) goto L25;
        r112.f();
    L25:
        Uri r117 = r110.f46445i;
        boolean r118 = r110.f46449m;
        boolean r119 = r110.f46453q;
        boolean r120 = r110.f46454r;
        String r121 = UriProtector.getQueryParameter(r117, "enable_lynx_strict_mode");
        if (r121 == null) goto L28;
        boolean r122 = Boolean.parseBoolean(r121);
    L29:
        String r123 = UriProtector.getQueryParameter(r117, "thread_strategy");
        if (r123 == null) goto L32;
        int r124 = CastIntegerProtector.parseInt(r123);
    L33:
        LinkedHashMap r125 = new LinkedHashMap();
        if (r122 == false) goto L36;
        r125.put("setEnableAirStrictMode", CollectionsKt.listOf(Boolean.TRUE));
    L36:
        if (r118 == false) goto L38;
    L39:
        r125.put("setEnableSyncFlush", CollectionsKt.listOf(Boolean.TRUE));
    L40:
        Boolean r126 = Boolean.TRUE;
        r125.put("setEnablePreUpdateData", CollectionsKt.listOf(r126));
        if (r119 == false) goto L43;
        r125.put("setEnableVSyncAlignedMessageLoop", CollectionsKt.listOf(r126));
    L43:
        r125.put("setEnablePendingJsTask", CollectionsKt.listOf(Boolean.valueOf(r120)));
        Uri r127 = r112.g();
        if (r127 == null) goto L74;
        String r128 = UriProtector.getQueryParameter(r127, this.f46433c);
        if (r128 == null) goto L74;
        String r129 = UriProtector.getQueryParameter(r127, this.f46432b);
        if (r129 == null) goto L74;
        String r130 = UriProtector.getQueryParameter(r127, this.f46434d);
        String r131 = "false";
        if (r130 != null) goto L54;
        r130 = "false";
    L54:
        String r132 = UriProtector.getQueryParameter(r127, this.f46436f);
        if (r132 != null) goto L57;
        r132 = "false";
    L57:
        String r133 = UriProtector.getQueryParameter(r127, this.f46435e);
        if (r133 == null) goto L62;
        r131 = r133;
    L62:
        if ((r112 instanceof x07.a) == false) goto L68;
        uj.c r134 = ECLynxBuildUtilKt.b();
        if (r134 == null) goto L68;
        if (r134.b() != true) goto L68;
        int r135 = lk.a.f509537a;
        Intrinsics.areEqual(r129, "true");
        Intrinsics.areEqual(r130, "true");
        Intrinsics.areEqual(r132, "true");
        Intrinsics.areEqual(r131, "true");
        Intrinsics.checkNotNullParameter(r128, "groupName");
    L68:
        Intrinsics.areEqual(r129, "true");
        Intrinsics.areEqual(r130, "true");
        Intrinsics.areEqual(r132, "true");
        Intrinsics.areEqual(r131, "true");
        r112.k();
        Map<String, Object> r136 = r110.f46443g;
        if (TypeIntrinsics.isMutableMap(r136) == true) goto L71;
        r136 = null;
    L71:
        if (r136 == null) goto L74;
        r136.put("sharedLynxGroupID", r128);
    L74:
        if (this.f46431a == false) goto L77;
        r125.put("setScreenSize", CollectionsKt.listOf(new Integer[]{Integer.valueOf(r110.f46455s), Integer.valueOf(r110.f46456t)}));
    L77:
        if ((!r125.isEmpty()) == false) goto L79;
        r112.e();
    L79:
        return r112;
    L38:
        if (r124 != 3) goto L40;
    L32:
        r124 = 0;
        goto L33
    L28:
        r122 = false;
        goto L29
    }
}
