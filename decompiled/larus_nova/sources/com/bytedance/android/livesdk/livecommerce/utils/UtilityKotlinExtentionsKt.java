package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class UtilityKotlinExtentionsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f153056a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f153057b = null;

    public static final class a implements com.bytedance.android.ec.opt.asynctask.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f153058a;

        @Override // com.bytedance.android.ec.opt.asynctask.w
        public final com.bytedance.android.ec.opt.asynctask.k r() {
            com.bytedance.android.ec.opt.asynctask.r r100 = new com.bytedance.android.ec.opt.asynctask.r();
            r100.f48047b = true;
            return r100.f48051f;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f153058a.invoke();
        }

        public a(Function0 r100) {
            this.f153058a = r100;
        }
    }

    static {
        f153056a = LazyKt.lazy(UtilityKotlinExtentionsKt$CACHE_DENSITY$2.INSTANCE);
        f153057b = new Handler(Looper.getMainLooper());
    }

    public static final int b(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$ceilDp");
        return (int) Math.ceil(c(r100));
    }

    public static final float c(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dp");
        com.bytedance.android.ec.core.opt.ab.d.a();
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableCacheDensity() == false) goto L5;
        float r101 = ((Number) f153056a.getValue()).floatValue();
    L7:
        return (r101 * r100.floatValue()) + 0.5f;
    L5:
        Resources r102 = Resources.getSystem();
        r101 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        goto L7
    }

    public static final int d(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dpInt");
        return (int) c(r100);
    }

    public static final boolean e(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isTextEllipsis");
        Layout r101 = r100.getLayout();
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.getLineCount() > 0) goto L9;
        return false;
    L9:
        if (r101.getEllipsisCount(r101.getLineCount() - 1) <= 0) goto L12;
        return true;
    L12:
        return false;
    }

    public static final void i(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        com.bytedance.android.ec.opt.asynctask.t.b(new a(r100));
    }

    public static final void h(Object r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        if (r100 != null) goto L6;
        r101.invoke();
        return;
    }

    public static final float a(int r100, Context r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r103 = r101.getResources();
        DisplayMetrics r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics());
        com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        com.bytedance.android.ec.core.opt.ab.d.a();
        int r105 = r104.widthPixels;
        float r106 = r104.density;
        if (r106 <= 0) goto L5;
        float r107 = r105 / r106;
    L7:
        return c(Float.valueOf(r100 * (r107 / 375.0f)));
    L5:
        r107 = 0.0f;
        goto L7
    }

    public static final <T1, T2, R> R f(T1 r100, T2 r101, Function2<? super T1, ? super T2, ? extends R> r102) {
        Intrinsics.checkNotNullParameter(r102, "block");
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        return r102.invoke(r100, r101);
    L6:
        return null;
    }

    public static void j(long r100, Function0 r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 <= 0) goto L8;
        f153057b.postDelayed(new c1(r101), r100);
        return;
    L8:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L10;
        r101.invoke();
        return;
    L10:
        f153057b.post(new c1(r101));
    }

    public static final void g(Object r100, Object r101, Object r102, Function3 r103) {
        Intrinsics.checkNotNullParameter(r103, "block");
        if (r100 == null) goto L8;
        if (r101 == null) goto L9;
        if (r102 == null) goto L10;
        r103.invoke(r100, r101, r102);
        return;
    L10:
        return;
    L9:
        return;
    }
}
