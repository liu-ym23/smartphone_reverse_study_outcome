package com.bytedance.android.ec.hybrid.tools;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.view.MallLynxTaskBanner;
import com.bytedance.android.ec.hybrid.ui.ECMediaType;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import yj.t;

/* JADX INFO: loaded from: classes44.dex */
public final class TransitionAnimationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f47620a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f47621b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function4<? super String, ? super Integer, ? super String, ? super String, ? extends View> f47622c;

    public static final class a implements PixelCopy.OnPixelCopyFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f47623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f47624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f47625c;

        public a(Bitmap r100, View r101, String r102) {
            this.f47623a = r100;
            this.f47624b = r101;
            this.f47625c = r102;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public final void onPixelCopyFinished(int r100) {
            if (r100 != 0) goto L9;
            IHybridHostService r101 = com.bytedance.android.ec.hybrid.a.h();
            if (r101 == null) goto L10;
            t r102 = r101.getHybridLynxHostService();
            if (r102 == null) goto L11;
            r102.setGylActivityBitmap(this.f47623a, this.f47625c);
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    public static final class b implements PixelCopy.OnPixelCopyFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f47626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f47627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f47628c;

        public b(Bitmap r100, View r101, String r102) {
            this.f47626a = r100;
            this.f47627b = r101;
            this.f47628c = r102;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public final void onPixelCopyFinished(int r100) {
            if (r100 != 0) goto L9;
            IHybridHostService r101 = com.bytedance.android.ec.hybrid.a.h();
            if (r101 == null) goto L10;
            t r102 = r101.getHybridLynxHostService();
            if (r102 == null) goto L11;
            r102.setGylItemViewBitmap(this.f47626a, this.f47628c);
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    public static final class c extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f47629a;

        public c(float r100) {
            this.f47629a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), this.f47629a);
        }
    }

    static {
        f47620a = LazyKt.lazy(TransitionAnimationHelper$cardCoverFlashOpt$2.INSTANCE);
        f47621b = LazyKt.lazy(TransitionAnimationHelper$asyncSaveFrame$2.INSTANCE);
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void b(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r101 == true) goto L8;
        if (e.f47634b.getType().b() == 1) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r100, ECMediaType.PRODUCT.getType()) == false) goto L10;
    L18:
        IHybridHostService r102 = com.bytedance.android.ec.hybrid.a.h();
        if (r102 == null) goto L27;
        t r103 = r102.getHybridLynxHostService();
        if (r103 == null) goto L28;
        r103.forbidExitAnima(r100);
        return;
    L28:
        return;
    L27:
        return;
    L10:
        if (Intrinsics.areEqual(r100, ECMediaType.VIDEO.getType()) == true) goto L18;
        if (Intrinsics.areEqual(r100, ECMediaType.LIVE.getType()) == false) goto L16;
        Lazy r104 = MallFeedAndLiveAnimExtension.f47619a;
        return;
    L16:
        if (Intrinsics.areEqual(r100, ECMediaType.DEEP_FEED.getType()) == false) goto L25;
        Lazy r105 = MallAndDeepFeedAnimExtension.f47618a;
        return;
    }

    public static void d(View r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "mainContainerView");
        Intrinsics.checkNotNullParameter(r111, "type");
        if (Build.VERSION.SDK_INT < 26) goto L21;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L13
        if (((Boolean) f47620a.getValue()).booleanValue() == false) goto L7;
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.event.mallCardClickAnimation", System.currentTimeMillis(), "", true, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enable", Boolean.TRUE), TuplesKt.to("async", Boolean.valueOf(((Boolean) f47621b.getValue()).booleanValue()))}), false, 32));     // Catch: Throwable -> L13
    L7:
        Rect r101 = new Rect();     // Catch: Throwable -> L13
        boolean r102 = r110.getGlobalVisibleRect(r101);     // Catch: Throwable -> L13
        Activity r103 = MallLynxTaskBanner.f47420b.getActivity(r110.getContext());     // Catch: Throwable -> L13
        if (r102 == false) goto L11;
        if (r103 == null) goto L11;
        Bitmap r104 = Bitmap.createBitmap(a(r103.getWindow()).getWidth(), a(r103.getWindow()).getHeight(), Bitmap.Config.RGB_565);     // Catch: Throwable -> L13
        PixelCopy.request(r103.getWindow(), r104, new a(r104, r110, r111), new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L13
        Bitmap r105 = Bitmap.createBitmap(r101.width(), r101.height(), Bitmap.Config.RGB_565);     // Catch: Throwable -> L13
        PixelCopy.request(r103.getWindow(), r101, r105, new b(r105, r110, r111), new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L13
    L11:
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L22;
        EnsureManager.ensureNotReachHere(r113);
        return;
    L22:
        return;
    L13:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static ImageView c(Activity r100, Bitmap r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (r101 != null) goto L6;
        return null;
    L6:
        ImageView r103 = new ImageView(r100);
        r103.setImageBitmap(r101);
        r103.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        if (r102 == false) goto L9;
        e(r103, 12.0f, false);
    L9:
        return r103;
    }

    public static void e(View r100, float r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$setRadius");
        r100.setOutlineProvider(new c(UIUtils.dip2Px(r100.getContext(), r101)));
        r100.setClipToOutline(true);
        if (r101 != 0.0f) goto L7;
        if (r102 == false) goto L8;
        r100.setClipToOutline(false);
        return;
    L8:
        return;
    }
}
