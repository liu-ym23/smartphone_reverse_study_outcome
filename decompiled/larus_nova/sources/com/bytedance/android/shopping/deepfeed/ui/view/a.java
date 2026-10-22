package com.bytedance.android.shopping.deepfeed.ui.view;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f173924e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f173925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f173926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f173927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f173928d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.ui.view.a$a, reason: collision with other inner class name */
    public static final class C2600a {
        public static int a(Context r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            DeepFeedFoldHelper.d();
            int r102 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
            return com.bytedance.android.ec.hybrid.list.util.c.c(Integer.valueOf(r101), r100, true);
        }
    }

    static {
    }

    public final void a() {
        DeepFeedFoldHelper.d();
        int r100 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        this.f173925a = com.bytedance.android.ec.hybrid.list.util.c.f(this.f173928d);
    }

    public a(Context r100) {
        this.f173928d = r100;
        int r101 = com.bytedance.android.ec.hybrid.tools.f.f47635a;
        Object r102 = 0;
        int r103 = com.bytedance.android.ec.base.settings.c.f42815a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L81
        Object r105 = null;
        Object r106 = com.bytedance.android.ec.base.settings.d.f42818c.get("mall_deep_feed_ui_adapter");     // Catch: Throwable -> L54
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
    L89:
        this.f173926b = ((Number) r102).intValue();
        this.f173927c = true;
        int r111 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        this.f173925a = com.bytedance.android.ec.hybrid.list.util.c.f(this.f173928d);
        return;
    L68:
        IHybridHostService r112 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L81
        if (r112 == null) goto L71;
        Object r113 = r112.getHostABValue("mall_deep_feed_ui_adapter", r102);     // Catch: Throwable -> L81
    L72:
        if (r113 == null) goto L89;
        if ((r113 instanceof Integer) == false) goto L77;
        r105 = r113;
    L77:
        Integer r114 = (Integer) r105;     // Catch: Throwable -> L81
        if (r114 == null) goto L89;
        r102 = r114;
        goto L89
    L71:
        r113 = null;
        goto L72
    L9:
        if ((r106 instanceof Integer) == true) goto L11;
        Object r115 = null;
    L12:
        r107 = (Integer) r115;     // Catch: Throwable -> L54
        if (r107 != null) goto L52;
        if ((r106 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r116 = Float.valueOf(((Number) r106).floatValue());     // Catch: Throwable -> L54
        if ((r116 instanceof Integer) == true) goto L22;
        r116 = null;
    L22:
        r107 = (Integer) r116;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r117 = Double.valueOf(((Number) r106).doubleValue());     // Catch: Throwable -> L54
        if ((r117 instanceof Integer) == true) goto L28;
        r117 = null;
    L28:
        r107 = (Integer) r117;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r107 = Integer.valueOf(((Number) r106).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r118 = Long.valueOf(((Number) r106).longValue());     // Catch: Throwable -> L54
        if ((r118 instanceof Integer) == true) goto L37;
        r118 = null;
    L37:
        r107 = (Integer) r118;     // Catch: Throwable -> L54
    L39:
        if ((r106 instanceof JSONObject) == false) goto L41;
    L91:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L47
        Object r119 = SDKSettingsCacheManager.a().fromJson(r106.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r119 instanceof Integer) == true) goto L45;
        r119 = null;
    L45:
        Object r120 = Result.m9449constructorimpl((Integer) r119);     // Catch: Throwable -> L47
    L49:
        r107 = r120;
        if (Result.m9455isFailureimpl(r107) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L54
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r106 instanceof JSONArray) == false) goto L51;
    L11:
        r115 = r106;
    L54:
        th = move-exception;
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L81
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        Object r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r125 = Result.m9452exceptionOrNullimpl(r124);
        if (r125 == null) goto L86;
        EnsureManager.ensureNotReachHere(r125);
    L86:
        if (Result.m9455isFailureimpl(r124) == true) goto L89;
        r102 = r124;
        goto L89
    }

    public final Pair<Integer, Integer> b(int r100, int r101) {
        if (this.f173926b == 1) goto L6;
        return null;
    L6:
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        int r104 = View.MeasureSpec.getMode(r100);
        int r105 = View.MeasureSpec.getMode(r101);
        int r106 = Math.round(r102 * this.f173925a);
        int r107 = Math.round(r103 * this.f173925a);
        DeepFeedFoldHelper.d();
        int r108 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r109 = com.bytedance.android.ec.hybrid.list.util.c.e(this.f173928d);
        DeepFeedFoldHelper.d();
        int r110 = com.bytedance.android.ec.hybrid.list.util.c.e(this.f173928d);
        int r111 = View.MeasureSpec.makeMeasureSpec(Math.min(r106, r109), r104);
        int r112 = View.MeasureSpec.makeMeasureSpec(Math.min(r107, r110), r105);
        if (r111 <= 0) goto L12;
        if (r112 <= 0) goto L12;
        return TuplesKt.to(Integer.valueOf(r111), Integer.valueOf(r112));
    L12:
        return TuplesKt.to(Integer.valueOf(r100), Integer.valueOf(r101));
    }
}
