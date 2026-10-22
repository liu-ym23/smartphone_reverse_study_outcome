package com.bytedance.android.live.broadcastgame.openplatform.miniapp.card;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import com.bytedance.android.live.broadcastgame.opengame.GameIntroCard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class IntroduceCardWidget<T> implements IExternalWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f61742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f61743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GameIntroCard f61744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f61745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f61746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f61747f;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f61748a;

        public a(Function0 r100) {
            this.f61748a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f61748a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onHide() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onLoad() {
        this.f61742a = true;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onShow() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onUnload() {
        this.f61742a = false;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewAttached(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewDetached() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillAttach(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillDetach() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final View getView() {
        GameIntroCard r100 = this.f61744c;
        if (r100 == null) goto L26;
        if (r100.getParent() == null) goto L19;
        GameIntroCard r101 = this.f61744c;
        if (r101 == null) goto L18;
        ViewParent r102 = r101.getParent();
        if (r102 == null) goto L16;
        ViewGroup r103 = (ViewGroup) r102;
        GameIntroCard r104 = this.f61744c;
        if (r104 == null) goto L14;
        r103.removeView(r104);
        goto L19
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L19:
        GameIntroCard r105 = this.f61744c;
        if (r105 == null) goto L24;
        r105.setAlpha(0.0f);
        return r105;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        GameIntroCard r101 = this.f61744c;
        if (r101 == null) goto L23;
        if (r101.getParent() != null) goto L8;
        r100.invoke();
        return;
    L8:
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = r100;
        GameIntroCard r103 = this.f61744c;
        if (r103 == null) goto L21;
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r103, "ScaleX", new float[]{1.0f, 0.0f});
        r104.setDuration(280);
        r104.setInterpolator(new AccelerateInterpolator());
        GameIntroCard r105 = this.f61744c;
        if (r105 == null) goto L19;
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r105, "ScaleY", new float[]{1.0f, 0.0f});
        r106.setDuration(280);
        r106.setInterpolator(new AccelerateInterpolator());
        GameIntroCard r107 = this.f61744c;
        if (r107 == null) goto L17;
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r107, "alpha", new float[]{1.0f, 0.0f});
        r108.setDuration(280);
        final AnimatorSet r109 = new AnimatorSet();
        r109.play(r104).with(r106).with(r108);
        j(200, new IntroduceCardWidget$hideCard$1(r102));
        j(0, new IntroduceCardWidget$hideCard$2(this, r109, r102));
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    public final void q(final View.OnClickListener r100) {
        GameIntroCard r101 = this.f61744c;
        if (r101 == null) goto L6;
        r101.setOnClickBlock(new IntroduceCardWidget$setClickListener$1(this, r100));
        return;
    }

    public final void t(final View.OnClickListener r100) {
        GameIntroCard r101 = this.f61744c;
        if (r101 == null) goto L6;
        r101.setOnCloseBlock(new IntroduceCardWidget$setCloseClickListener$1(this, r100));
        return;
    }

    public IntroduceCardWidget(Context r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f61746e = r100;
        this.f61747f = r101;
        this.f61745d = LazyKt.lazy(new IntroduceCardWidget$viewHandler$2(this));
    }

    public final void j(long r100, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "block");
        GameIntroCard r101 = this.f61744c;
        if (r101 == null) goto L21;
        if (r101.getParent() != null) goto L8;
        UtilityKotlinExtentionsKt.s(r100, false, false, r110, 6);
        return;
    L8:
        if (r100 > 0) goto L14;
        GameIntroCard r102 = this.f61744c;
        if (r102 == null) goto L13;
        r102.post(new a(r110));
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L14:
        GameIntroCard r103 = this.f61744c;
        if (r103 == null) goto L19;
        r103.postDelayed(new a(r110), r100);
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }
}
