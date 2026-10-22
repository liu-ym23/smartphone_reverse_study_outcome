package com.bytedance.android.livesdk.livecommerce.room.widgets.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContextContainer;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "height", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class BottomRightAnim$showLinkedAnimation$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ RoomContextController $contextController;
    final /* synthetic */ boolean $ignoreLinkedAnim;
    final /* synthetic */ Function0 $onAnimEnd;
    final /* synthetic */ Function0 $onAnimStart;
    final /* synthetic */ View $view;

    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f151957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BottomRightAnim$showLinkedAnimation$1 f151958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f151959c;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.anim.BottomRightAnim$showLinkedAnimation$1$a$a, reason: collision with other inner class name */
        public static final class C2338a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f151960a;

            public C2338a(a r100) {
                this.f151960a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                this.f151960a.f151958b.$onAnimEnd.invoke();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                a r101 = this.f151960a;
                if (r101.f151957a == true) goto L6;
                r101.f151957a = true;
                r101.f151958b.$onAnimStart.invoke();
                return;
            }
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
        public final void c(int r100) {
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
        public final void a() {
            View r100 = this.f151958b.$view;
            r100.setAlpha(0.05f);
            r100.setScaleX(0.5f);
            r100.setScaleY(0.5f);
            if (this.f151958b.$contextController.v() == false) goto L5;
            float r101 = r100.getWidth();
        L6:
            r100.setPivotX(r101);
            r100.setPivotY(this.f151959c);
            ViewPropertyAnimator r102 = r100.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f);
            r102.setDuration(160);
            int r103 = BottomRightAnim.f151951a;
            r102.setInterpolator(new d());
            r102.setListener(new C2338a(this)).start();
            return;
        L5:
            r101 = 0.0f;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
        public final void b() {
            if (this.f151957a == true) goto L6;
            this.f151957a = true;
            this.f151958b.$onAnimStart.invoke();
            return;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
        public final void onCanceled() {
            a();
        }

        public a(BottomRightAnim$showLinkedAnimation$1 r100, int r101) {
            this.f151958b = r100;
            this.f151959c = r101;
        }
    }

    public BottomRightAnim$showLinkedAnimation$1(View r100, RoomContextController r101, Function0 r102, Function0 r103, boolean r104) {
        this.$view = r100;
        this.$contextController = r101;
        this.$onAnimEnd = r102;
        this.$onAnimStart = r103;
        this.$ignoreLinkedAnim = r104;
        super(1);
    }

    public final void invoke(int r100) {
        this.$view.setAlpha(0.0f);
        a r101 = new a(this, r100);
        if (this.$ignoreLinkedAnim == false) goto L6;
        r101.a();
        return;
    L6:
        if (this.$contextController.v() == false) goto L8;
        RoomContextController r102 = this.$contextController;
    L9:
        ECContext r103 = r102.r();
        if (r103 == null) goto L42;
        i<CartCardLinkedAnimController> r104 = r103.getLinkedAnimController();
        if (r104 == null) goto L42;
        CartCardLinkedAnimController r105 = r104.getValue();
        if (r105 == null) goto L42;
        View r106 = this.$view;
        Intrinsics.checkNotNullParameter(r106, "cardView");
        if (r105.d() == true) goto L18;
    L41:
        r101.a();
        return;
    L18:
        if (r105.f151980b == true) goto L41;
        if (r105.a(r106) == false) goto L41;
        if (r105.f151982d == null) goto L41;
        int r107 = ECContextContainer.f151896b;
        ECContext r108 = ECContextContainer.a.a(r105.f151984f, Integer.valueOf(r105.f151985g));
        if (r108 == null) goto L30;
        m<Boolean> r109 = r108.isPromotionListShow();
        if (r109 == null) goto L30;
        if (r109.getValue().booleanValue() == true) goto L41;
    L30:
        yk2.c r110 = r105.f151982d;
        if (r110 == null) goto L34;
        r110.b(true, CartCardLinkedAnimController.c(true), r105.b(true));
    L34:
        if (r105.f151981c != null) goto L36;
    L40:
        r105.f151981c = r101;
        UtilityKotlinExtentionsKt.f153057b.postDelayed(r105.f151983e, 1000);
        return;
    L36:
        if (ECLiveABUtils.INSTANCE.getENABLE_KMP_POP_CARD() == false) goto L40;
        g r111 = r105.f151981c;
        if (r111 == null) goto L40;
        r111.onCanceled();
    L42:
        int r112 = BottomRightAnim.f151951a;
        BottomRightAnim.d(r102.v(), this.$view, this.$onAnimEnd);
        return;
    L8:
        int r113 = RoomContextController.f151593h;
        r102 = RoomContextController.a.a();
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100) {
        invoke(r100.intValue());
        return Unit.INSTANCE;
    }
}
