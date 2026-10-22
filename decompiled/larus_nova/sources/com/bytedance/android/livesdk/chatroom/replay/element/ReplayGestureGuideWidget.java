package com.bytedance.android.livesdk.chatroom.replay.element;

import android.view.MotionEvent;
import android.view.View;
import androidx.camera.core.RetryPolicy;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import j40.f4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/element/ReplayGestureGuideWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Landroid/view/View$OnTouchListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayGestureGuideWidget extends LiveWidget implements View.OnTouchListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f108351f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f108352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f108353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f108354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f108355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LottieAnimationView f108356e;

    public static final class a {
    }

    public static final class b<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayGestureGuideWidget f108357a;

        public b(ReplayGestureGuideWidget r100) {
            this.f108357a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Boolean r101 = (Boolean) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            this.f108357a.getClass();
            this.f108357a.getClass();
            if (ReplayGestureGuideWidget.wq() == true) goto L7;
            this.f108357a.getClass();
            if (ReplayGestureGuideWidget.xq() == true) goto L7;
        L9:
            return false;
        L7:
            if (r101.booleanValue() == true) goto L9;
            return true;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayGestureGuideWidget f108358a;

        public c(ReplayGestureGuideWidget r100) {
            this.f108358a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            ReplayGestureGuideWidget r102 = this.f108358a;
            int r103 = ReplayGestureGuideWidget.f108351f;
            r102.getClass();
            Disposable r104 = r102.f108352a;
            if (r104 != null) goto L5;
        L10:
            r102.contentView.setVisibility(0);
            if (ReplayGestureGuideWidget.wq() == false) goto L26;
            HSImageView r105 = r102.f108353b;
            if (r105 == null) goto L15;
            r105.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(i2.c("/replay/ttlive_guide_pinch.webp")).build());
        L15:
            View r106 = r102.f108354c;
            if (r106 == null) goto L18;
            UtilityKotlinExtentionsKt.w(r106);
        L18:
            View r107 = r102.f108355d;
            if (r107 == null) goto L21;
            UtilityKotlinExtentionsKt.t(r107);
        L21:
            LottieAnimationView r108 = r102.f108356e;
            if (r108 == null) goto L24;
            r108.cancelAnimation();
        L24:
            com.bytedance.android.livesdk.sharedpref.e<Boolean> r109 = f4.f497222y;
            Boolean r110 = Boolean.FALSE;
            r109.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r109, r110);
        L37:
            r102.contentView.postDelayed(new e(r102), RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
            return;
        L26:
            if (ReplayGestureGuideWidget.xq() == false) goto L37;
            View r111 = r102.f108355d;
            if (r111 == null) goto L30;
            UtilityKotlinExtentionsKt.w(r111);
        L30:
            LottieAnimationView r112 = r102.f108356e;
            if (r112 == null) goto L33;
            r112.playAnimation();
        L33:
            View r113 = r102.f108354c;
            if (r113 == null) goto L36;
            UtilityKotlinExtentionsKt.t(r113);
        L36:
            com.bytedance.android.livesdk.sharedpref.e<Boolean> r114 = f4.f497223z;
            Boolean r115 = Boolean.FALSE;
            r114.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r114, r115);
            goto L37
        L5:
            if (r104.isDisposed() == true) goto L10;
            Disposable r116 = r102.f108352a;
            if (r116 == null) goto L9;
            r116.dispose();
        L9:
            r102.f108352a = null;
            goto L10
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_replay_widget_gesture_guide;
    }

    public static boolean wq() {
        if (f4.f497222y.getValue().booleanValue() == false) goto L7;
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r100 = ReplayRoomFragmentScopeUtil.f117917a;
        if (((com.bytedance.android.livesdk.chatroom.replay.ui.v) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.v.class)).o(4) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static boolean xq() {
        if (f4.f497223z.getValue().booleanValue() == false) goto L7;
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r100 = ReplayRoomFragmentScopeUtil.f117917a;
        if (((com.bytedance.android.livesdk.chatroom.replay.ui.v) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.v.class)).o(5) == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        this.f108353b = (HSImageView) this.contentView.findViewById(R.id.guide_animation);
        this.f108354c = this.contentView.findViewById(R.id.enlarge_guide_container);
        this.f108355d = this.contentView.findViewById(R.id.fast_forward_guide_container);
        LottieAnimationView r100 = (LottieAnimationView) this.contentView.findViewById(R.id.fast_forward_guide_icon);
        this.f108356e = r100;
        if (r100 == null) goto L5;
        r100.setImageAssetsFolder("vs_gesture/images");
    L5:
        LottieAnimationView r101 = this.f108356e;
        if (r101 == null) goto L8;
        r101.setRepeatCount(-1);
    L8:
        LottieAnimationView r102 = this.f108356e;
        if (r102 == null) goto L11;
        r102.setAnimation("vs_gesture/longPress.json");
    L11:
        this.contentView.setOnTouchListener(this);
        mq1.v r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.e().provideVSPlayerViewControlService(this.dataCenter);
        if (r103 == null) goto L22;
        VSPlayerViewControlContext r104 = r103.provideContext();
        if (r104 == null) goto L22;
        com.bytedance.live.datacontext.m<Boolean> r105 = r104.getPlayerViewVisible();
        if (r105 == null) goto L22;
        Observable<Boolean> r106 = r105.a();
        if (r106 == null) goto L22;
        Observable<Boolean> r107 = r106.filter(new b(this));
        if (r107 == null) goto L22;
        Disposable r108 = r107.subscribe(new c(this));
    L23:
        this.f108352a = r108;
        return;
    L22:
        r108 = null;
        goto L23
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        Disposable r100 = this.f108352a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L12;
        Disposable r101 = this.f108352a;
        if (r101 == null) goto L9;
        r101.dispose();
    L9:
        this.f108352a = null;
        return;
    }

    public ReplayGestureGuideWidget() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (this.contentView.getVisibility() != 0) goto L7;
        this.contentView.setVisibility(8);
        return false;
    L7:
        return false;
    }
}
