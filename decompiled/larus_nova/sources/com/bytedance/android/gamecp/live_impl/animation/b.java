package com.bytedance.android.gamecp.live_impl.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.gamecp.common.setting.config.k1;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.live_impl.GamePromoteDataContext;
import com.bytedance.android.gamecp.live_impl.RoomContext;
import com.bytedance.android.gamecp.live_impl.preview.CardAnimationControllerPreView;
import com.bytedance.android.gamecp.live_impl.utils.g;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import wu.k2;
import wu.k3;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f57787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f57788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f57789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f57790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GamePromoteDataContext f57791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CardAnimationControllerPreView f57792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f57793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f57794h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f57795i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f57796j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ILiveRoomControllerProvider.ProviderSource f57797k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f57798l;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f57799a;

        public a(b r100) {
            this.f57799a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            GamePromoteDataContext r102 = this.f57799a.f57791e;
            if (r102 != null) goto L5;
        L11:
            this.f57799a.c();
            return;
        L5:
            if (r102.isCleared() == true) goto L11;
            GamePromoteDataContext r103 = this.f57799a.f57791e;
            if (r103 == null) goto L11;
            m<Boolean> r104 = r103.getGamePadEnterAnimShow();
            if (r104 == null) goto L11;
            r104.setValue(Boolean.TRUE);
            goto L11
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.live_impl.animation.b$b, reason: collision with other inner class name */
    public static final class AnimationAnimationListenerC0921b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f57800a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public AnimationAnimationListenerC0921b(b r100) {
            this.f57800a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            GamePromoteDataContext r101 = this.f57800a.f57791e;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.isCleared() == true) goto L13;
            GamePromoteDataContext r102 = this.f57800a.f57791e;
            if (r102 == null) goto L14;
            m<Boolean> r103 = r102.getGamePadEnterAnimShow();
            if (r103 == null) goto L15;
            r103.setValue(Boolean.FALSE);
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            GamePromoteDataContext r101 = this.f57800a.f57791e;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.isCleared() == true) goto L13;
            GamePromoteDataContext r102 = this.f57800a.f57791e;
            if (r102 == null) goto L14;
            m<Boolean> r103 = r102.getGamePadEnterAnimShow();
            if (r103 == null) goto L15;
            r103.setValue(Boolean.TRUE);
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f57801a;

        public c(b r100) {
            this.f57801a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            this.f57801a.getClass();
            if (b.a() == false) goto L5;
            return;
        L5:
            if (g.a() == true) goto L7;
            return;
        L7:
            if (r101.booleanValue() == false) goto L9;
            return;
        L9:
            if (y0.getContext().getResources().getConfiguration().orientation != 1) goto L15;
            this.f57801a.b();
            return;
        }
    }

    public static boolean a() {
        if (k2.f561338a.getValue().b() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void d() {
        TranslateAnimation r100 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -8.0f);
        r100.setDuration(200);
        r100.setFillAfter(true);
        RotateAnimation r110 = new RotateAnimation(0.0f, -8.0f, 1, 0.5f, 1, 0.5f);
        r110.setDuration(434);
        r110.setStartOffset(150);
        r110.setInterpolator(com.bytedance.android.gamecp.live_impl.animation.a.f57786a);
        r110.setFillAfter(true);
        TranslateAnimation r101 = new TranslateAnimation(0.0f, 0.0f, 0.0f, 8.0f);
        r101.setDuration(183);
        r101.setStartOffset(500);
        r101.setFillAfter(true);
        AnimationSet r102 = new AnimationSet(false);
        r102.addAnimation(r100);
        r102.addAnimation(r110);
        r102.addAnimation(r101);
        r102.setAnimationListener(new AnimationAnimationListenerC0921b(this));
        ImageView r103 = this.f57787a;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIvStatic");
    L5:
        r103.startAnimation(r102);
    }

    public final void b() {
        if (com.bytedance.android.gamecp.host_api.a.b().getLiveService().shouldRegisterAnimationListener(this.f57796j, this.f57797k.name()) == true) goto L6;
        Disposable r100 = Observable.timer(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        this.f57794h.add(r100);
        return;
    }

    public final void c() {
        if (a() == true) goto L6;
        d();
        return;
    L6:
        RoomContext.a r100 = RoomContext.Companion;
        String r101 = this.f57798l;
        String r102 = this.f57796j;
        String r103 = this.f57797k.name();
        r100.getClass();
        RoomContext r104 = RoomContext.a.b(r101, r102, r103);
        if (r104 == null) goto L9;
        Boolean r105 = Boolean.valueOf(r104.getExecutedEnterAnim());
    L10:
        Boolean r106 = Boolean.FALSE;
        if (Intrinsics.areEqual(r105, r106) == false) goto L13;
        r104.setExecutedEnterAnim(true);
    L13:
        k1 r107 = k3.f561339a.getValue();
        ALogger.d("degrade_opt", "startEnterAnimaInterval config:" + r107);
        if (r107.b() == false) goto L28;
        int r108 = k2.f561338a.getValue().a();
        if (r107.c() <= 0) goto L20;
        r108 = r107.c();
    L20:
        if (Intrinsics.areEqual(r105, r106) == false) goto L22;
        long r109 = r107.a();
    L23:
        ALogger.d("degrade_opt", "startEnterAnimaInterval initialDelay:" + r109 + ",timeSpan:" + r108);
        if (this.f57793g != null) goto L29;
        this.f57793g = Observable.interval(r109, r108, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).filter(new com.bytedance.android.gamecp.live_impl.animation.c(this)).subscribe(new d(this), e.f57804a);
        return;
    L29:
        return;
    L22:
        r109 = r108;
        goto L23
    L28:
        return;
    L9:
        r105 = null;
        goto L10
    }

    public final void e() {
        if (a() == true) goto L5;
    L7:
        GamePromoteDataContext r100 = this.f57791e;
        if (r100 == null) goto L17;
        m<Boolean> r101 = r100.getHasIntroduceCard();
        if (r101 == null) goto L18;
        Observable<Boolean> r102 = r101.a();
        if (r102 == null) goto L19;
        Disposable r103 = r102.subscribe(new c(this));
        if (r103 == null) goto L20;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r103, this.f57794h);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if (g.a() == false) goto L7;
        b();
        goto L7
    }

    public b(View r100, String r101, ILiveRoomControllerProvider.ProviderSource r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r103, "roomId");
        this.f57795i = r100;
        this.f57796j = r101;
        this.f57797k = r102;
        this.f57798l = r103;
        this.f57792f = com.bytedance.android.gamecp.live_impl.preview.a.f57923b.a(this.f57798l, this.f57796j, this.f57797k);
        this.f57794h = new CompositeDisposable();
    }
}
