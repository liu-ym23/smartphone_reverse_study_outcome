package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.h;
import com.bytedance.android.live.core.utils.s;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IWidgetType;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class AudienceExplainCardWidget<T> implements IExternalWidget, IWidgetType, com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILiveRoomViewHandler f84837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f84838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f84839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Animator f84840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Animator f84841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f84842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f<T> f84843g;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f84844a;

        public a(Function0 r100) {
            this.f84844a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f84844a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final View getExplainCardView() {
        return this.f84843g.getExplainCardView();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final Function0<Unit> getOnBtnClickBlock() {
        return this.f84843g.getOnBtnClickBlock();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final Function0<Unit> getOnClickBlock() {
        return this.f84843g.getOnClickBlock();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final Function0<Unit> getOnCloseBlock() {
        return this.f84843g.getOnCloseBlock();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onHide() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onLoad() {
        this.f84838b = true;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onShow() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onUnload() {
        this.f84838b = false;
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

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final void setData(T r100) {
        this.f84843g.setData(r100);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final void setOnBtnClickBlock(Function0<Unit> r100) {
        this.f84843g.setOnBtnClickBlock(r100);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final void setOnClickBlock(Function0<Unit> r100) {
        this.f84843g.setOnClickBlock(r100);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final void setOnCloseBlock(Function0<Unit> r100) {
        this.f84843g.setOnCloseBlock(r100);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final void setSupplementInfo(com.bytedance.android.livesdk.wrds.syncdata.openplatform.a r100) {
        this.f84843g.setSupplementInfo(r100);
    }

    public final void g() {
        Animator r100 = this.f84840d;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f84840d = null;
        Animator r101 = this.f84841e;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f84841e = null;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final View getView() {
        if (this.f84843g.getParent() == null) goto L9;
        ViewParent r100 = this.f84843g.getParent();
        if (r100 == null) goto L8;
        ((ViewGroup) r100).removeView(this.f84843g);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        f<T> r101 = this.f84843g;
        r101.setAlpha(0.0f);
        return r101;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IWidgetType
    public final IWidgetType.ExternalWidgetType getWidgetType() {
        return IWidgetType.ExternalWidgetType.MINI_APP_POP_CARD;
    }

    public final void t(final s r100) {
        if (de0.f120026a.getValue().h() == true) goto L8;
        this.f84843g.setPivotX(0.0f);
        if (this.f84843g.getHeight() != 0) goto L7;
        qo0.a.c("Perf", "prepare exec card anim, but height is 0");
        this.f84843g.measure(View.MeasureSpec.makeMeasureSpec(s1.y(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(s1.y(), Integer.MIN_VALUE));
        f<T> r101 = this.f84843g;
        r101.setPivotY(r101.getMeasuredHeight());
        goto L8
    L7:
        f<T> r102 = this.f84843g;
        r102.setPivotY(r102.getHeight());
    L8:
        Animator r103 = this.f84840d;
        if (r103 == null) goto L15;
        h.a(r103, new AudienceExplainCardWidget$startShowCardAnim$$inlined$run$lambda$1(this, r100));
        if (r100 == null) goto L13;
        r103.addListener(r100);
    L13:
        r103.start();
        return;
    }

    public final void q(long r100, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "block");
        if (this.f84843g.getParent() != null) goto L6;
        UtilityKotlinExtentionsKt.s(r100, false, false, r110, 6);
        return;
    L6:
        if (r100 > 0) goto L8;
        this.f84843g.post(new a(r110));
        return;
    L8:
        this.f84843g.postDelayed(new a(r110), r100);
    }

    public AudienceExplainCardWidget(Context r100, long r101, f<T> r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r102, "cardView");
        this.f84842f = r101;
        this.f84843g = r102;
    }

    public final Animator j(long r110, Pair<Float, Float> r111, long r112, Pair<Float, Float> r113) {
        AnimatorSet r100 = new AnimatorSet();
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this.f84843g, "ScaleX", new float[]{r111.getFirst().floatValue(), r111.getSecond().floatValue()});
        r101.setDuration(r110);
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f84843g, "ScaleY", new float[]{r111.getFirst().floatValue(), r111.getSecond().floatValue()});
        r102.setDuration(r110);
        ObjectAnimator r114 = ObjectAnimator.ofFloat(this.f84843g, "ScaleX", new float[]{r113.getFirst().floatValue(), r113.getSecond().floatValue()});
        r114.setDuration(r112);
        ObjectAnimator r115 = ObjectAnimator.ofFloat(this.f84843g, "ScaleY", new float[]{r113.getFirst().floatValue(), r113.getSecond().floatValue()});
        r115.setDuration(r112);
        r100.play(r101).with(r102).before(r114).before(r115);
        return r100;
    }
}
