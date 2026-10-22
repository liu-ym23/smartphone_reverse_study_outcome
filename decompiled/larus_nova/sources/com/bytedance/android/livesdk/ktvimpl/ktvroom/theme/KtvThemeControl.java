package com.bytedance.android.livesdk.ktvimpl.ktvroom.theme;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdk.config.d9;
import com.bytedance.android.livesdk.config.y0;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.frame.RecycleWidgetHelper;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;
import vm2.k;
import zg1.v0;

/* JADX INFO: loaded from: classes10.dex */
public final class KtvThemeControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f144869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CompositeDisposable f144870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f144871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f144872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HSImageView f144873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f144874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DataCenter f144875g;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvThemeControl f144876a;

        public a(KtvThemeControl r100) {
            this.f144876a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Integer r101 = (Integer) r100;
            KtvThemeControl.a(this.f144876a);
            this.f144876a.d();
        }
    }

    public static final class b extends ScalingUtils.AbstractScaleType {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f144877e = null;

        static {
            f144877e = new b();
        }

        public b() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public final void getTransformImpl(Matrix r100, Rect r101, int r102, int r103, float r104, float r105, float r106, float r107) {
            Intrinsics.checkNotNullParameter(r100, "outTransform");
            Intrinsics.checkNotNullParameter(r101, "parentRect");
            float r108 = r101.left;
            float r109 = r101.top;
            r100.setScale(r106, r107);
            r100.postTranslate(r108 + 0.5f, r109 + 0.5f);
        }
    }

    public static final class c extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvThemeControl f144878a;

        public c(KtvThemeControl r100) {
            this.f144878a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            super.onFinalImageSet(r100, (ImageInfo) r101, r102);
            this.f144878a.c();
        }
    }

    public static final class d extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvThemeControl f144879a;

        public d(KtvThemeControl r100) {
            this.f144879a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            super.onFinalImageSet(r100, (ImageInfo) r101, r102);
            this.f144879a.c();
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f144880a = null;

        static {
            f144880a = new e();
        }

        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ALogger.i("KtvThemeControl", "KTV房间背景已加载好并展示");     // Catch: Throwable -> L4
            xs2.b.a().post(new v0());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void b() {
        this.f144874f.setBackgroundColor(ColorProtector.parseColor("#100b5c"));     // Catch: Exception -> L5
        this.f144873e.setBackgroundColor(Color.parseColor("#100b5c"));     // Catch: Exception -> L5
        this.f144872d.setBackgroundColor(Color.parseColor("#08002a"));     // Catch: Exception -> L5
    L7:
        this.f144873e.getHierarchy().setActualImageScaleType(b.f144877e);
        d9 r100 = k.a();
        if (TextUtils.isEmpty(r100.ktvStageStaticBg) == false) goto L10;
        r100.ktvStageStaticBg = d9.f120008a;
    L10:
        String r101 = r100.ktvStageStaticBg;
        d9 r102 = k.a();
        boolean r103 = this.f144869a;
        r102.getClass();
        boolean r104 = false;
        if (r103 == false) goto L16;
        if (z0.b(true) <= r102.ktvBgDegradeAnchorLimit) goto L17;
    L18:
        if (r104 == false) goto L20;
        this.f144873e.setController(Fresco.newDraweeControllerBuilder().setUri(r101).setOldController(this.f144873e.getController()).setControllerListener(new c(this)).build());
        return;
    L20:
        d9 r105 = k.a();
        if (TextUtils.isEmpty(r105.ktvStageAnimatedBg) == false) goto L23;
        r105.ktvStageAnimatedBg = d9.f120009b;
    L23:
        this.f144873e.setController(Fresco.newDraweeControllerBuilder().setLowResImageRequest(ImageRequest.fromUri(r101)).setImageRequest(ImageRequest.fromUri(r105.ktvStageAnimatedBg)).setOldController(this.f144873e.getController()).setAutoPlayAnimations(true).setControllerListener(new d(this)).build());
        return;
    L17:
        r104 = true;
        goto L18
    L16:
        if (z0.b(false) > r102.ktvBgDegradeAudienceLimit) goto L18;
    L5:
        e = move-exception;
        ALogger.e("KtvThemeControl", "loadDefaultKtvBackground exception: " + e.getMessage());
        goto L7
    }

    public final void c() {
        long r100 = ((Number) h.T3.getValue(null, h.f556082a[252(0xfc, float:3.53E-43)])).longValue();
        this.f144873e.postDelayed(this.f144871c, r100);
        d();
    }

    public final void d() {
        ALogger.d("KtvThemeControl", "[smoothEnterRoom] on complete load background success");
        int r100 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        MultiSceneEnterRoomStatisticsUtils r101 = MultiSceneEnterRoomStatisticsUtils.a.a(this.f144875g, 0L);
        if (r101 == null) goto L6;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r101, "background_Load", 0, 2, null);
        return;
    }

    public static final void a(KtvThemeControl r100) {
        r100.getClass();
        if (vm2.d.q0().isOpenSmoothViewMock() == true) goto L5;
        return;
    L5:
        if (r100.f144869a == true) goto L11;
        ALogger.d("KtvThemeControl", "handleKtvStageVisibleAlpha");
        r100.f144873e.setAlpha(1.0f);
        r100.f144874f.setAlpha(1.0f);
        DataCenter r101 = r100.f144875g;
        if (r101 == null) goto L12;
        r101.put("cmd_multi_enter_room_remove_view_mock", Boolean.TRUE);
        return;
    L12:
        return;
    }

    public KtvThemeControl(View r100, HSImageView r101, ViewGroup r102, HSImageView r103, Context r104, DataCenter r105) {
        Intrinsics.checkNotNullParameter(r100, "ktvTopBar");
        Intrinsics.checkNotNullParameter(r101, "ktvBackground");
        Intrinsics.checkNotNullParameter(r102, "ktvLayout");
        Intrinsics.checkNotNullParameter(r103, "fullScreenThemeBackground");
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f144872d = r100;
        this.f144873e = r101;
        this.f144874f = r102;
        this.f144875g = r105;
        Drawable r106 = null;
        if (r105 == null) goto L5;
        Boolean r107 = (Boolean) r105.get("data_is_anchor", Boolean.FALSE);
    L6:
        this.f144869a = Intrinsics.areEqual(r107, Boolean.TRUE);
        y0.a r108 = new y0.a();
        r108.e();
        r108.f();
        r108.g();
        Unit r109 = Unit.INSTANCE;
        com.bytedance.android.livesdk.a r110 = new com.bytedance.android.livesdk.a(r108);
        Function2<Integer, Boolean, Unit> r111 = new KtvThemeControl$$special$$inlined$apply$lambda$1(this);
        Intrinsics.checkNotNullParameter(r111, "cb");
        r110.f102983a = r111;
        this.f144870b = new CompositeDisposable();
        KtvContext.Companion.getClass();
        lb0.b r112 = KtvContext.a.g().getKtvMvBackRound();
        ((IInteractService) jc1.k.n(IInteractService.class)).addBusinessDegradeStrategy(r110);
        if (r105 == null) goto L9;
        int r113 = RecycleWidgetHelper.f142499a;
        Drawable r114 = (Drawable) r105.get("recycle_key_of_mv_bg");
    L11:
        if ((r114 instanceof lb0.b) == false) goto L14;
        r106 = r114;
    L14:
        lb0.b r115 = (lb0.b) r106;
        if (r115 == null) goto L17;
        r112.f508303c = r115.f508303c;
        r112.f508304d = r115.f508304d;
    L17:
        this.f144870b.add(KtvContext.a.g().getKtvStageReadyEvent().onEvent().subscribe(new a(this)));
        this.f144871c = e.f144880a;
        return;
    L9:
        r114 = null;
        goto L11
    L5:
        r107 = null;
        goto L6
    }
}
