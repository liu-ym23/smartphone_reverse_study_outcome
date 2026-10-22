package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/PortraitQuickShotLayerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PortraitQuickShotLayerWidget extends LiveRecyclableWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f118671j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f118672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f118673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f118674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VideoViewParams f118675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f118676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IRoom f118677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ValueAnimator f118678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ValueAnimator f118679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ValueAnimator f118680i;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PortraitQuickShotLayerWidget f118681a;

        public b(PortraitQuickShotLayerWidget r100) {
            this.f118681a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PortraitQuickShotLayerWidget r100 = this.f118681a;     // Catch: Throwable -> L9
            DataCenter r101 = r100.dataCenter;     // Catch: Throwable -> L9
            if (r101 == null) goto L6;
            VideoViewParams r102 = (VideoViewParams) r101.get("live_render_view_params");     // Catch: Throwable -> L9
            if (r102 == null) goto L6;
        L7:
            r100.f118675d = r102;     // Catch: Throwable -> L9
            return;
        L6:
            r102 = new VideoViewParams(0, 0, 0, 0.0f);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        int r100 = bs1.a.f20221a;
        return R.layout.ttlive_vs_dialog_quick_screenshot_portrait_v2;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        List r100 = CollectionsKt.mutableListOf(new String[]{"data_live_quick_shot_bitmap", "data_live_quick_shot_path", "data_live_quick_record_start", "data_live_quick_record_finish"});
        if (r100 == null) goto L8;
        Iterator r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        String r102 = (String) r101.next();
        this.dataCenter.removeObserver(r102, this);
        goto L6
    L10:
        return;
    }

    public final void yq() {
        ValueAnimator r100 = this.f118678g;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ValueAnimator r101 = this.f118679h;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        ValueAnimator r102 = this.f118680i;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        View r103 = this.contentView;
        if (r103 == null) goto L14;
        r103.setAlpha(1.0f);
    L14:
        View r104 = this.contentView;
        if (r104 == null) goto L17;
        UtilityKotlinExtentionsKt.t(r104);
    L17:
        View r105 = this.f118672a;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContentView");
    L20:
        if (r105 == null) goto L22;
        UtilityKotlinExtentionsKt.t(r105);
    L22:
        ImageView r106 = this.f118673b;
        if (r106 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L25:
        if (r106 == null) goto L27;
        UtilityKotlinExtentionsKt.t(r106);
    L27:
        View r107 = this.f118674c;
        if (r107 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("btnShareView");
    L30:
        if (r107 == null) goto L32;
        UtilityKotlinExtentionsKt.t(r107);
    L32:
        View r108 = this.contentView;
        if (r108 == null) goto L36;
        r108.setOnClickListener(null);
        return;
    }

    public PortraitQuickShotLayerWidget() {
        this.f118678g = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
        this.f118679h = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
        this.f118680i = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(150);
    }

    public static View wq(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r210) {
        KVData r100 = (KVData) r210;
        if (r100 == null) goto L119;
        String r101 = r100.getKey();
        switch(r101.hashCode()) {
            case -1956533084: goto L116;
            case -1210674534: goto L97;
            case -904942447: goto L94;
            case 84498020: goto L8;
            default: goto L132;
        };
    L132:
        return;
    L8:
        if (r101.equals("data_live_quick_shot_bitmap") == false) goto L120;
        DataCenter r102 = this.dataCenter;
        if (r102 == null) goto L13;
        VideoViewParams r103 = (VideoViewParams) r102.get("live_render_view_params");
        if (r103 == null) goto L13;
    L14:
        this.f118675d = r103;
        this.dataCenter.put("data_live_quick_shot_layer_show", Boolean.TRUE);
        bs1.b r104 = (bs1.b) r100.getData();
        if (r104 == null) goto L17;
        Bitmap r105 = r104.f20223b;
    L18:
        if (r105 == null) goto L121;
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.m().logQuickShotShareDialogShow(r104.f20225d);
        yq();
        Bitmap r106 = r104.f20223b;
        this.f118676e = r106;
        if (r106 == null) goto L122;
        UtilityKotlinExtentionsKt.w(this.contentView);
        View r107 = this.f118672a;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContentView");
    L24:
        UtilityKotlinExtentionsKt.w(r107);
        ImageView r108 = this.f118673b;
        if (r108 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L27:
        UtilityKotlinExtentionsKt.w(r108);
        ImageView r109 = this.f118673b;
        if (r109 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L30:
        RoundedBitmapDrawable r110 = new RoundedBitmapDrawable(com.bytedance.android.live.core.utils.s1.getResources(), r106);
        int r111 = bs1.a.f20221a;
        float r112 = UtilityKotlinExtentionsKt.h(6);
        r110.setRadii(new float[]{r112, r112, r112, r112, r112, r112, r112, r112});
        Unit r113 = Unit.INSTANCE;
        r109.setImageDrawable(r110);
        Ref.IntRef r114 = new Ref.IntRef();
        VideoViewParams r115 = this.f118675d;
        if (r115 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L33:
        r114.element = r115.f112569a;
        Ref.IntRef r116 = new Ref.IntRef();
        VideoViewParams r117 = this.f118675d;
        if (r117 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("videoParam");
    L36:
        r116.element = r117.f112570b;
        Ref.IntRef r118 = new Ref.IntRef();
        vr1.u r119 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(null, this, 1);
        if (r119 == null) goto L43;
        com.bytedance.live.datacontext.n<Rect> r120 = r119.d();
        if (r120 == null) goto L43;
        Rect r121 = r120.getValue();
        if (r121 == null) goto L43;
        int r122 = r121.left;
    L44:
        r118.element = r122;
        Ref.IntRef r123 = new Ref.IntRef();
        vr1.u r124 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(null, this, 1);
        if (r124 == null) goto L51;
        com.bytedance.live.datacontext.n<Rect> r125 = r124.d();
        if (r125 == null) goto L51;
        Rect r126 = r125.getValue();
        if (r126 == null) goto L51;
        int r127 = r126.top;
    L52:
        r123.element = r127;
        if (r114.element > 0) goto L55;
    L56:
        r114.element = com.bytedance.android.live.core.utils.s1.t();
        r116.element = com.bytedance.android.live.core.utils.s1.r();
        r118.element = 0;
        r123.element = 0;
    L57:
        int r128 = r114.element;
        int r129 = r116.element;
        if (r128 < r129) goto L60;
        int r130 = r128;
    L61:
        if (r128 < r129) goto L63;
        int r131 = 100;
    L64:
        float r132 = UtilityKotlinExtentionsKt.h(r131);
        ValueAnimator r133 = ValueAnimator.ofInt(new int[]{1, 0}).setDuration(300);
        float r134 = r132 / r130;
        float r135 = 12;
        float r136 = UtilityKotlinExtentionsKt.h(r135);
        int r137 = this.containerView.getBottom() - ((int) ((r116.element * r134) + UtilityKotlinExtentionsKt.h(60)));
        float r138 = r136 - r118.element;
        int r139 = r137 - r123.element;
        Ref.IntRef r140 = new Ref.IntRef();
        r140.element = 0;
        Ref.IntRef r141 = new Ref.IntRef();
        r141.element = 0;
        Ref.FloatRef r142 = new Ref.FloatRef();
        r142.element = 0.0f;
        Ref.IntRef r143 = new Ref.IntRef();
        r143.element = 0;
        Ref.IntRef r144 = new Ref.IntRef();
        r144.element = 0;
        float r145 = r137;
        float r146 = (r114.element * r134) + UtilityKotlinExtentionsKt.h(r135);
        float r147 = (r116.element * r134) + UtilityKotlinExtentionsKt.h(44);
        Context r148 = this.context;
        if ((r148 instanceof Activity) == true) goto L67;
    L88:
        float r211 = r138;
    L89:
        Bitmap r149 = null;
    L90:
        if (r149 == null) goto L92;
        View r150 = this.contentView;
        RoundedBitmapDrawable r151 = new RoundedBitmapDrawable(com.bytedance.android.live.core.utils.s1.getResources(), r149);
        r151.setBorder(ColorProtector.parseColor("#1AFFFFFF"), 1.0f);
        float r152 = UtilityKotlinExtentionsKt.h(r135);
        r151.setRadii(new float[]{r152, r152, r152, r152, r152, r152, r152, r152});
        r150.setBackground(r151);
    L92:
        r133.addUpdateListener(new c2(this, r142, r134, r143, r114, r144, r116, r140, r118, r211, r141, r123, r139));
        r133.setInterpolator(new AccelerateDecelerateInterpolator());
        r133.start();
        return;
    L67:
        if (r148 == null) goto L87;
        if (((Activity) r148).getWindow() == null) goto L88;
        Context r153 = this.context;
        if (r153 == null) goto L85;
        if (wq(((Activity) r153).getWindow()) == null) goto L88;
        r211 = r138;
        float r154 = 0;
        if (r146 <= r154) goto L89;
        if (r147 <= r154) goto L89;
        Bitmap r155 = Bitmap.createBitmap((int) r146, (int) r147, Bitmap.Config.ARGB_8888);
        Canvas r156 = new Canvas(r155);
        r156.translate(-r136, (-r145) - StatusBarUtil.getStatusBarHeight(this.context));
        Context r157 = this.context;
        if (r157 == null) goto L83;
        wq(((Activity) r157).getWindow()).draw(r156);
        r149 = Bitmap.createBitmap(r155.getWidth(), r155.getHeight(), Bitmap.Config.ARGB_8888);
        com.bytedance.android.livesdk.utils.e0.a(r155, r149, 150);
        r155.recycle();
        goto L90
    L83:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L85:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L87:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L63:
        r131 = 178;
        goto L64
    L60:
        r130 = r129;
        goto L61
    L55:
        if (r116.element > 0) goto L57;
    L51:
        r127 = 0;
    L43:
        r122 = 0;
        goto L44
    L122:
        return;
    L121:
        return;
    L17:
        r105 = null;
    L13:
        r103 = new VideoViewParams(0, 0, 0, 0.0f);
        goto L14
    L120:
        return;
    L94:
        if (r101.equals("data_live_quick_record_finish") == false) goto L124;
        yq();
        return;
    L124:
        return;
    L97:
        if (r101.equals("data_live_quick_shot_path") == false) goto L126;
        bs1.b r158 = (bs1.b) r100.getData();
        if (r158 == null) goto L127;
        String r159 = r158.f20224c;
        if (r159 == null) goto L128;
        Bitmap r160 = r158.f20223b;
        IRoom r161 = this.f118677f;
        if (r161 == null) goto L110;
        IRoomAuthStatus r162 = r161.getRoomAuthStatus();
        if (r162 == null) goto L110;
        if (r162.enableVerticalScreenShare() != true) goto L110;
        this.contentView.post(new b2(this, r160, r159));
        return;
    L110:
        if (r160 == null) goto L114;
        View r163 = this.contentView;
        if (r163 == null) goto L114;
        r163.setOnClickListener(new y1(r160, this));
    L114:
        Observable.timer(1500, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new z1(this, r160), a2.f118746a);
        return;
    L128:
        return;
    L127:
        return;
    L126:
        return;
    L116:
        if (r101.equals("data_live_quick_record_start") == false) goto L131;
        yq();
        return;
    L131:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f118672a = findViewById(R.id.ttlive_vs_dialog_content);
        this.f118673b = (ImageView) findViewById(R.id.ttlive_vs_quick_screenshot_img);
        this.f118674c = findViewById(R.id.btn_share);
        this.contentView.post(new b(this));
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L10;
        List r102 = CollectionsKt.mutableListOf(new String[]{"data_live_quick_shot_bitmap", "data_live_quick_shot_path", "data_live_quick_record_start", "data_live_quick_record_finish"});
        if (r102 == null) goto L10;
        Iterator r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r101.observe((String) r103.next(), this);
    L10:
        com.bytedance.android.livesdk.f.d().f123392a.observe(this, new AnonymousClass3(this));
        this.f118677f = (IRoom) this.dataCenter.get("data_room");
        yq();
    }

    public static final void xq(PortraitQuickShotLayerWidget r100, Bitmap r101) {
        r100.dataCenter.put("data_live_quick_shot_layer_hide", Boolean.TRUE);
        int[] r102 = new int[2];
        View r103 = r100.contentView;
        if (r103 == null) goto L5;
        r103.getLocationOnScreen(r102);
    L5:
        r100.f118680i.addUpdateListener(new x1(r100, r101));
        r100.f118680i.start();
    }
}
