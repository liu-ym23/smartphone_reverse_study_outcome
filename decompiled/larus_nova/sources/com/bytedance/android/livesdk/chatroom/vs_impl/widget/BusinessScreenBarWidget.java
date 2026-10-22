package com.bytedance.android.livesdk.chatroom.vs_impl.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessResourceConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessScreenBarConfigure;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import fq1.t;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_impl/widget/BusinessScreenBarWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BusinessScreenBarWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f118356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f118357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f118358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f118359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinkedList<BusinessConfigure> f118360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f118361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CompositeDisposable f118362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ObjectAnimator f118363h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ObjectAnimator f118364i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f118365j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BusinessConfigure f118366k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f118367l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f118368m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f118369n;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BusinessScreenBarWidget f118370a;

        public a(BusinessScreenBarWidget r100) {
            this.f118370a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            this.f118370a.yq();
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BusinessScreenBarWidget f118371a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public b(BusinessScreenBarWidget r100) {
            this.f118371a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f118371a.Aq(1.0f, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f118371a.f118361f = true;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BusinessScreenBarWidget f118372a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public c(BusinessScreenBarWidget r100) {
            this.f118372a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f118372a.Aq(0.0f, 8);
            BusinessScreenBarWidget r101 = this.f118372a;
            r101.f118361f = false;
            HSImageView r102 = r101.f118356a;
            if (r102 == null) goto L5;
            r102.setBackground(null);
        L5:
            this.f118372a.yq();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f118372a.f118361f = true;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BusinessScreenBarWidget f118373a;

        public d(BusinessScreenBarWidget r100) {
            this.f118373a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f118373a.zq();     // Catch: Throwable -> L10
            this.f118373a.yq();     // Catch: Throwable -> L10
            u r100 = r.u(this.f118373a.dataCenter, null, 2);     // Catch: Throwable -> L10
            if (r100 == null) goto L13;
            m<MutableLiveData<Boolean>> r101 = r100.B1();     // Catch: Throwable -> L10
            if (r101 == null) goto L17;
            MutableLiveData<Boolean> r102 = r101.getValue();     // Catch: Throwable -> L10
            if (r102 == null) goto L18;
            r102.observeForever(this.f118373a.f118368m);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BusinessScreenBarWidget f118374a;

        public e(BusinessScreenBarWidget r100) {
            this.f118374a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            BusinessScreenBarWidget r101 = this.f118374a;
            r101.getClass();
            IVSPlayerService r102 = (IVSPlayerService) k.f(IVSPlayerService.class);
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r103 = null;
            if (r102 == null) goto L5;
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r104 = r102.provideVSPlayerViewControlService(r101.dataCenter);
        L6:
            boolean r105 = false;
            if (r104 != null) goto L9;
        L11:
            boolean r106 = false;
        L12:
            if (r106 == false) goto L18;
            IVSPlayerService r107 = (IVSPlayerService) k.f(IVSPlayerService.class);
            if (r107 == null) goto L16;
            r103 = r107.provideVSPlayerViewControlService(r101.dataCenter);
        L16:
            if (r103 == null) goto L26;
            r103.provideContext().getPlayerViewVisible().setValue(Boolean.FALSE);
            return;
        L26:
            return;
        L18:
            String r108 = r101.f118367l;
            if (r108 != null) goto L21;
            return;
        L21:
            if (r108.length() <= 0) goto L23;
            r105 = true;
        L23:
            if (r105 != true) goto L29;
            fq1.d.a().handleSchema(r101.context, UriProtector.parse(r101.f118367l).toString());
            int r109 = sr1.a.f543203a;
            sr1.a.c("activity_ad_click", "video_bottom", r101.f118366k, null);
            return;
        L29:
            return;
        L9:
            if (r104.provideContext().getPlayerViewVisible().getValue().booleanValue() == false) goto L11;
            r106 = true;
            goto L12
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class f extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BusinessConfigure f118375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BusinessScreenBarWidget f118376b;

        public f(BusinessConfigure r100, BusinessScreenBarWidget r101) {
            this.f118375a = r100;
            this.f118376b = r101;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            this.f118376b.Aq(0.0f, 8);
            this.f118376b.yq();
            StringBuilder r102 = new StringBuilder("load dynamic screen bar ");
            BusinessResourceConfigure r103 = this.f118375a.resourceConfig;
            String r104 = null;
            if (r103 == null) goto L7;
            BusinessScreenBarConfigure r105 = r103.screenBarConfigure;
            if (r105 == null) goto L7;
            py.k r106 = r105.getImage();
        L8:
            r102.append(r106);
            r102.append(" fail, reason ");
            if (r101 == null) goto L11;
            r104 = r101.getMessage();
        L11:
            r102.append(r104);
            ALogger.e("BusinessConfigure", r102.toString());
            return;
        L7:
            r106 = null;
            goto L8
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            ImageInfo r103 = (ImageInfo) r101;
            if ((r102 instanceof AnimatedDrawable2) == true) goto L5;
            r102 = null;
        L5:
            AnimatedDrawable2 r104 = (AnimatedDrawable2) r102;
            if (r104 == null) goto L9;
            r104.setAnimationListener(new com.bytedance.android.livesdk.chatroom.vs_impl.widget.a(this));
            return;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BusinessConfigure f118377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BusinessScreenBarWidget f118378b;

        public g(BusinessConfigure r100, BusinessScreenBarWidget r101) {
            this.f118377a = r100;
            this.f118378b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            HSImageView r102 = this.f118378b.f118356a;
            if (r102 == null) goto L5;
            r102.setBackground(new BitmapDrawable(r101));
        L5:
            this.f118378b.Aq(0.0f, 0);
            BusinessScreenBarWidget.xq(this.f118378b, false);
            ObjectAnimator r103 = this.f118378b.f118364i;
            if (r103 == null) goto L8;
            r103.cancel();
        L8:
            ObjectAnimator r104 = this.f118378b.f118363h;
            if (r104 == null) goto L11;
            r104.start();
        L11:
            int r105 = sr1.a.f543203a;
            py.k r106 = null;
            sr1.a.c("activity_ad_show", "video_bottom", this.f118377a, null);
            BusinessScreenBarWidget.wq(this.f118378b, Integer.valueOf(this.f118377a.displaySecond));
            StringBuilder r107 = new StringBuilder("load screen bar picture ");
            BusinessResourceConfigure r108 = this.f118377a.resourceConfig;
            if (r108 == null) goto L16;
            BusinessScreenBarConfigure r109 = r108.screenBarConfigure;
            if (r109 == null) goto L16;
            r106 = r109.getImage();
        L16:
            r107.append(r106);
            r107.append(" success");
            ALogger.i("BusinessConfigure", r107.toString());
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BusinessConfigure f118379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BusinessScreenBarWidget f118380b;

        public h(BusinessConfigure r100, BusinessScreenBarWidget r101) {
            this.f118379a = r100;
            this.f118380b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f118380b.Aq(0.0f, 8);
            this.f118380b.yq();
            StringBuilder r102 = new StringBuilder("load screen bar picture ");
            BusinessResourceConfigure r103 = this.f118379a.resourceConfig;
            String r104 = null;
            if (r103 == null) goto L7;
            BusinessScreenBarConfigure r105 = r103.screenBarConfigure;
            if (r105 == null) goto L7;
            py.k r106 = r105.getImage();
        L8:
            r102.append(r106);
            r102.append(" fail, reason ");
            if (r101 == null) goto L11;
            r104 = r101.getMessage();
        L11:
            r102.append(r104);
            ALogger.e("BusinessConfigure", r102.toString());
            return;
        L7:
            r106 = null;
            goto L8
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_business_screen_bar_layout;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        u r100 = r.u(this.dataCenter, null, 2);
        if (r100 == null) goto L9;
        m<MutableLiveData<Boolean>> r101 = r100.B1();
        if (r101 == null) goto L9;
        MutableLiveData<Boolean> r102 = r101.getValue();
        if (r102 == null) goto L9;
        r102.removeObserver(this.f118368m);
    L9:
        this.f118360e = null;
        HSImageView r103 = this.f118356a;
        if (r103 == null) goto L12;
        r103.setController(null);
    L12:
        HSImageView r104 = this.f118356a;
        if (r104 == null) goto L15;
        r104.setBackground(null);
    L15:
        Aq(0.0f, 8);
        this.f118362g.dispose();
    }

    public final void yq() {
        if (this.f118360e != null) goto L13;
        u r100 = r.u(this.dataCenter, null, 2);
        if (r100 == null) goto L11;
        j<cq1.a> r101 = r100.f0();
        if (r101 == null) goto L11;
        cq1.a r102 = r101.getValue();
        if (r102 == null) goto L11;
        LinkedList<BusinessConfigure> r103 = r102.f464765c;
    L12:
        this.f118360e = r103;
    L11:
        r103 = null;
    L13:
        LinkedList<BusinessConfigure> r104 = this.f118360e;
        if (r104 != null) goto L16;
        return;
    L16:
        if (r104.isEmpty() == false) goto L18;
        return;
    L18:
        if (this.f118361f == true) goto L131;
        LinkedList<BusinessConfigure> r105 = this.f118360e;
        if (r105 == null) goto L123;
        BusinessConfigure r106 = r105.pollFirst();
        if (r106 == null) goto L124;
        BusinessResourceConfigure r107 = r106.resourceConfig;
        if (r107 == null) goto L119;
        BusinessScreenBarConfigure r108 = r107.screenBarConfigure;
        if (r108 == null) goto L119;
        py.k r109 = r108.getImage();
        if (r109 == null) goto L119;
        List<String> r110 = r109.getUrls();
        if (r110 == null) goto L119;
        if (r110.isEmpty() == true) goto L119;
        if (sr1.a.d(r106) == true) goto L119;
        if (sr1.a.a(t.a().getCurrentUserId(), r106) == false) goto L119;
        BusinessResourceConfigure r111 = r106.resourceConfig;
        if (r111 == null) goto L44;
        BusinessScreenBarConfigure r112 = r111.screenBarConfigure;
        if (r112 == null) goto L44;
        String r113 = r112.getSchema();
    L45:
        this.f118367l = r113;
        HSImageView r114 = this.f118356a;
        if (r114 == null) goto L48;
        r114.setController(null);
    L48:
        HSImageView r115 = this.f118356a;
        if (r115 == null) goto L51;
        r115.setBackground(null);
    L51:
        Disposable r116 = this.f118365j;
        if (r116 == null) goto L54;
        r116.dispose();
    L54:
        this.f118365j = null;
        FrameLayout r117 = this.f118357b;
        if (r117 == null) goto L57;
        r117.setVisibility(8);
    L57:
        ViewGroup r118 = this.f118359d;
        if (r118 == null) goto L60;
        r118.setVisibility(8);
    L60:
        BusinessResourceConfigure r119 = r106.resourceConfig;
        if (r119 == null) goto L65;
        BusinessScreenBarConfigure r120 = r119.screenBarConfigure;
        if (r120 == null) goto L65;
        String r121 = r120.getJumpPrompt();
    L66:
        Handler r122 = UtilityKotlinExtentionsKt.f118187a;
        if (r121 != null) goto L69;
    L71:
        boolean r123 = false;
    L72:
        if (r123 == false) goto L97;
        BusinessResourceConfigure r124 = r106.resourceConfig;
        if (r124 == null) goto L78;
        BusinessScreenBarConfigure r125 = r124.screenBarConfigure;
        if (r125 == null) goto L78;
        String r126 = r125.getSchema();
    L79:
        if (r126 != null) goto L81;
    L83:
        boolean r127 = false;
    L84:
        if (r127 == false) goto L97;
        TextView r128 = this.f118358c;
        if (r128 == null) goto L94;
        BusinessResourceConfigure r129 = r106.resourceConfig;
        if (r129 == null) goto L92;
        BusinessScreenBarConfigure r130 = r129.screenBarConfigure;
        if (r130 == null) goto L92;
        String r131 = r130.getJumpPrompt();
    L93:
        r128.setText(r131);
    L92:
        r131 = null;
    L94:
        ViewGroup r132 = this.f118359d;
        if (r132 == null) goto L97;
        r132.setVisibility(0);
        goto L97
    L81:
        if (r126.length() <= 0) goto L83;
        r127 = true;
    L78:
        r126 = null;
    L97:
        BusinessResourceConfigure r133 = r106.resourceConfig;
        if (r133 == null) goto L112;
        BusinessScreenBarConfigure r134 = r133.screenBarConfigure;
        if (r134 == null) goto L112;
        if (r134.getBarType() != 2) goto L112;
        this.f118366k = r106;
        Aq(1.0f, 0);
        HSImageView r135 = this.f118356a;
        if (r135 == null) goto L125;
        PipelineDraweeControllerBuilder r136 = Fresco.newDraweeControllerBuilder();
        BusinessResourceConfigure r137 = r106.resourceConfig;
        if (r137 == null) goto L110;
        BusinessScreenBarConfigure r138 = r137.screenBarConfigure;
        if (r138 == null) goto L110;
        py.k r139 = r138.getImage();
    L111:
        r135.setController(r136.setFirstAvailableImageRequests(ImageLoader.createImageRequests(r139, null, null)).setAutoPlayAnimations(true).setControllerListener(new f(r106, this)).build());
        return;
    L110:
        r139 = null;
        goto L111
    L125:
        return;
    L112:
        BusinessResourceConfigure r140 = r106.resourceConfig;
        if (r140 == null) goto L127;
        BusinessScreenBarConfigure r141 = r140.screenBarConfigure;
        if (r141 == null) goto L128;
        py.k r142 = r141.getImage();
        if (r142 == null) goto L129;
        RxUtilKt.c(a1.k(r142).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(r106, this), new h(r106, this)), this.f118362g);
        return;
    L129:
        return;
    L128:
        return;
    L127:
        return;
    L69:
        if (r121.length() <= 0) goto L71;
        r123 = true;
    L65:
        r121 = null;
    L44:
        r113 = null;
    L119:
        yq();
        return;
    L124:
        return;
    L123:
        return;
    }

    public BusinessScreenBarWidget() {
        this.f118362g = new CompositeDisposable();
        this.f118367l = "";
        this.f118368m = new a(this);
    }

    public final void zq() {
        this.f118369n = PadConfigUtils.c();
        boolean r100 = e5.n();
        Boolean r101 = null;
        if (this.f118369n == false) goto L8;
        if (r100 == false) goto L6;
        int r102 = com.bytedance.android.livesdk.chatroom.vs_base.util.t.e();
    L7:
        Integer r103 = Integer.valueOf(r102);
    L12:
        if (r103 == null) goto L23;
        int r104 = r103.intValue();
        HSImageView r105 = this.f118356a;
        if (r105 == null) goto L23;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L23;
        r106.width = r104;
        r106.height = (int) (r104 * 0.16f);
        StringBuilder r107 = new StringBuilder("initScreenBarSize, screen orientation ");
        DataCenter r108 = this.dataCenter;
        if (r108 == null) goto L20;
        r101 = Boolean.valueOf(com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r108, true));
    L20:
        r107.append(r101);
        r107.append("screen bar width ");
        r107.append(r106.width);
        r107.append(", height ");
        r107.append(r106.height);
        ALogger.i("BusinessConfigure", r107.toString());
        HSImageView r109 = this.f118356a;
        if (r109 == null) goto L23;
        r109.setLayoutParams(r106);
    L23:
        boolean r110 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.c("screenBar", this.containerView, false, true, true, 4);
        return;
    L6:
        r102 = com.bytedance.android.livesdk.chatroom.vs_base.util.t.f();
        goto L7
    L8:
        ViewGroup r111 = this.containerView;
        if (r111 == null) goto L11;
        r103 = Integer.valueOf(r111.getWidth());
        goto L12
    L11:
        r103 = null;
        goto L12
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        ALogger.i("BusinessConfigure", String.valueOf(this.f118369n));
        super.onConfigurationChanged(r100);
        if (this.f118361f == false) goto L5;
        Aq(0.0f, 8);
    L5:
        zq();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this.contentView, "alpha", new float[]{0.0f, 1.0f});
        r101.setDuration(300);
        r101.addListener(new b(this));
        Unit r102 = Unit.INSTANCE;
        this.f118363h = r101;
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.contentView, "alpha", new float[]{1.0f, 0.0f});
        r103.setDuration(300);
        r103.addListener(new c(this));
        this.f118364i = r103;
        ViewGroup r104 = this.containerView;
        ViewGroup r105 = null;
        if (r104 == null) goto L5;
        HSImageView r106 = (HSImageView) r104.findViewById(R.id.business_screen_bar);
    L6:
        this.f118356a = r106;
        ViewGroup r107 = this.containerView;
        if (r107 == null) goto L9;
        FrameLayout r108 = (FrameLayout) r107.findViewById(R.id.screen_bar_tip_container);
    L10:
        this.f118357b = r108;
        ViewGroup r109 = this.containerView;
        if (r109 == null) goto L13;
        TextView r110 = (TextView) r109.findViewById(R.id.tv_business_screen_bar_tip);
    L14:
        this.f118358c = r110;
        ViewGroup r111 = this.containerView;
        if (r111 == null) goto L17;
        r105 = (ViewGroup) r111.findViewById(R.id.screen_bar_action_tip_container);
    L17:
        this.f118359d = r105;
        return;
    L13:
        r110 = null;
        goto L14
    L9:
        r108 = null;
        goto L10
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f118362g = new CompositeDisposable();
        Aq(0.0f, 8);
        ViewGroup r101 = this.containerView;
        if (r101 == null) goto L5;
        r101.post(new d(this));
    L5:
        HSImageView r102 = this.f118356a;
        if (r102 == null) goto L9;
        r102.setOnClickListener(new e(this));
        return;
    }

    public static final void wq(BusinessScreenBarWidget r100, Integer r101) {
        if (r101 == null) goto L6;
        r100.getClass();
        if (r101.intValue() <= 0) goto L6;
        RxUtilKt.c(Observable.timer(r101.intValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new tr1.a(r100)), r100.f118362g);
        return;
    L6:
        ObjectAnimator r102 = r100.f118363h;
        if (r102 == null) goto L9;
        r102.cancel();
    L9:
        ObjectAnimator r103 = r100.f118364i;
        if (r103 == null) goto L14;
        r103.start();
        return;
    }

    public static final void xq(BusinessScreenBarWidget r100, boolean r101) {
        Disposable r102 = r100.f118365j;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        if (r101 == false) goto L7;
        r100.f118365j = Observable.timer(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new tr1.b(r100));
        return;
    L7:
        FrameLayout r103 = r100.f118357b;
        if (r103 == null) goto L12;
        r103.setVisibility(0);
        return;
    }

    public final void Aq(float r100, int r101) {
        View r102 = this.contentView;
        if (r102 == null) goto L5;
        r102.setVisibility(r101);
    L5:
        HSImageView r103 = this.f118356a;
        if (r103 == null) goto L8;
        r103.setVisibility(r101);
    L8:
        View r104 = this.contentView;
        if (r104 == null) goto L11;
        r104.setAlpha(r100);
    L11:
        if (r101 != 0) goto L13;
        boolean r105 = true;
    L14:
        this.f118361f = r105;
        return;
    L13:
        r105 = false;
        goto L14
    }
}
