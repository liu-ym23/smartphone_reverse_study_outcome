package com.bytedance.android.livesdk.lottie;

import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.livesdk.utils.h3;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/lottie/CommonLottieAnimationWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonLottieAnimationWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LottieAnimationView f153462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f153463b;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonLottieAnimationWidget f153464a;

        public a(CommonLottieAnimationWidget r100) {
            this.f153464a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            final k r101 = (k) r100;
            CommonLottieAnimationWidget r102 = this.f153464a;
            r102.getClass();
            Function0<Long> r103 = new CommonLottieAnimationWidget$onEvent$rootPath$1(r101);
            Intrinsics.checkNotNullParameter(r103, "getAssetId");
            ((SingleSubscribeProxy) Single.create(new h3(new AtomicReference(), r103)).flatMap(new com.bytedance.android.livesdk.lottie.b(new e())).flatMap(new c(r102)).observeOn(AndroidSchedulers.mainThread()).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(r102))).subscribe(new g(r102, r101), new h(r101));
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonLottieAnimationWidget f153465a;

        public b(CommonLottieAnimationWidget r100) {
            this.f153465a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            CommonLottieAnimationWidget r101 = this.f153465a;
            r101.getClass();
            if (((i) r100).f153475a == false) goto L18;
            Disposable r102 = r101.f153463b;
            if (r102 != null) goto L7;
        L11:
            LottieAnimationView r103 = r101.f153462a;
            if (r103 == null) goto L14;
            r103.cancelAnimation();
        L14:
            LottieAnimationView r104 = r101.f153462a;
            if (r104 == null) goto L19;
            r104.setVisibility(8);
            return;
        L19:
            return;
        L7:
            if (r102.isDisposed() == true) goto L11;
            Disposable r105 = r101.f153463b;
            if (r105 == null) goto L11;
            r105.dispose();
            goto L11
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_common_lottie_animation_widget;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        Disposable r100 = this.f153463b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f153463b;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    public CommonLottieAnimationWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f153462a = (LottieAnimationView) this.contentView.findViewById(R.id.lottie_animation_view);
        ((ObservableSubscribeProxy) xs2.b.a().b(k.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new a(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(i.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new b(this));
    }

    public static final void wq(CommonLottieAnimationWidget r100, k r101) {
        r100.getClass();
        ((LottieService.a) r101.f153478c).f153466a.onNext(2);
        if (r101.f153477b == false) goto L7;
        LottieAnimationView r102 = r100.f153462a;
        if (r102 == null) goto L9;
        r102.setVisibility(8);
        return;
    L9:
        return;
    L7:
        r100.f153463b = Observable.timer(4000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.lottie.a(r100));
    }
}
