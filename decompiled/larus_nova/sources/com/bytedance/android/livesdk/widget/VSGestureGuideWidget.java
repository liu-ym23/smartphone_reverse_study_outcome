package com.bytedance.android.livesdk.widget;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/widget/VSGestureGuideWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Landroid/view/View$OnTouchListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSGestureGuideWidget extends LiveWidget implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f161374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f161375b;

    public static final class a {
    }

    public static final class b<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f161376a = null;

        static {
            f161376a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Boolean r101 = (Boolean) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (Intrinsics.areEqual(com.bytedance.android.livesdk.sharedpref.b.Q.getValue(), Boolean.TRUE) == true) goto L5;
        L7:
            return false;
        L5:
            if (r101.booleanValue() == true) goto L7;
            return true;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSGestureGuideWidget f161377a;

        public c(VSGestureGuideWidget r100) {
            this.f161377a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            this.f161377a.contentView.setVisibility(0);
            HSImageView r102 = this.f161377a.f161375b;
            if (r102 == null) goto L5;
            r102.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(com.bytedance.android.livesdk.chatroom.utils.i2.c("/replay/ttlive_guide_pinch.webp")).build());
        L5:
            this.f161377a.contentView.postDelayed(new s2(this), KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL);
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_widget_vs_gesture_guide;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        this.f161375b = (HSImageView) this.contentView.findViewById(R.id.guide_animation);
        this.contentView.setOnTouchListener(this);
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r100 = ((IVSPlayerService) jc1.k.n(IVSPlayerService.class)).provideVSPlayerViewControlService(this.dataCenter);
        if (r100 == null) goto L13;
        VSPlayerViewControlContext r101 = r100.provideContext();
        if (r101 == null) goto L13;
        com.bytedance.live.datacontext.m<Boolean> r102 = r101.getPlayerViewVisible();
        if (r102 == null) goto L13;
        Observable<Boolean> r103 = r102.a();
        if (r103 == null) goto L13;
        Observable<Boolean> r104 = r103.filter(b.f161376a);
        if (r104 == null) goto L13;
        Disposable r105 = r104.subscribe(new c(this));
    L14:
        this.f161374a = r105;
        return;
    L13:
        r105 = null;
        goto L14
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        Disposable r100 = this.f161374a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L12;
        Disposable r101 = this.f161374a;
        if (r101 == null) goto L9;
        r101.dispose();
    L9:
        this.f161374a = null;
        return;
    }

    public VSGestureGuideWidget() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (this.contentView.getVisibility() != 0) goto L7;
        this.contentView.setVisibility(8);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = com.bytedance.android.livesdk.sharedpref.b.Q;
        Boolean r103 = Boolean.FALSE;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        return false;
    L7:
        return false;
    }
}
