package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContextContainer;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.CartCardLinkedAnimController;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "height", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class BottomRightAnim$showLinkedAnimation$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Function3 $animatorCallback;
    final /* synthetic */ RoomContextController $contextController;
    final /* synthetic */ boolean $ignoreLinkedAnim;
    final /* synthetic */ Function0 $onAnimEnd;
    final /* synthetic */ Function0 $onAnimStart;
    final /* synthetic */ View $view;

    public BottomRightAnim$showLinkedAnimation$1(View r100, Function0 r101, Function3 r102, RoomContextController r103, Function0 r104, boolean r105) {
        this.$view = r100;
        this.$onAnimEnd = r101;
        this.$animatorCallback = r102;
        this.$contextController = r103;
        this.$onAnimStart = r104;
        this.$ignoreLinkedAnim = r105;
        super(1);
    }

    public final void invoke(int r100) {
        this.$view.setAlpha(0.0f);
        BottomRightAnim$showLinkedAnimation$1$animRequest$1 r101 = new BottomRightAnim$showLinkedAnimation$1$animRequest$1(this, r100);
        if (this.$ignoreLinkedAnim == false) goto L5;
        r101.a();
        return;
    L5:
        ECContext r102 = this.$contextController.r();
        if (r102 == null) goto L38;
        com.bytedance.live.datacontext.i<CartCardLinkedAnimController> r103 = r102.getLinkedAnimController();
        if (r103 == null) goto L38;
        CartCardLinkedAnimController r104 = r103.getValue();
        if (r104 == null) goto L38;
        View r105 = this.$view;
        Intrinsics.checkNotNullParameter(r105, "cardView");
        if (r104.d() == true) goto L14;
    L37:
        r101.a();
        return;
    L14:
        if (r104.f151980b == true) goto L37;
        if (r104.a(r105) == false) goto L37;
        if (r104.f151982d == null) goto L37;
        int r106 = ECContextContainer.f151896b;
        ECContext r107 = ECContextContainer.a.a(r104.f151984f, Integer.valueOf(r104.f151985g));
        if (r107 == null) goto L26;
        com.bytedance.live.datacontext.m<Boolean> r108 = r107.isPromotionListShow();
        if (r108 == null) goto L26;
        if (r108.getValue().booleanValue() == true) goto L37;
    L26:
        yk2.c r109 = r104.f151982d;
        if (r109 == null) goto L30;
        r109.a(true, r104.b(true));
    L30:
        if (r104.f151981c != null) goto L32;
    L36:
        r104.f151981c = r101;
        UtilityKotlinExtentionsKt.f153057b.postDelayed(r104.f151983e, 1000);
        return;
    L32:
        if (ECLiveABUtils.INSTANCE.getENABLE_KMP_POP_CARD() == false) goto L36;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g r110 = r104.f151981c;
        if (r110 == null) goto L36;
        r110.onCanceled();
    L38:
        BottomRightAnim r111 = BottomRightAnim.f148302a;
        final RoomContextController r112 = this.$contextController;
        final View r113 = this.$view;
        final Function3 r114 = this.$animatorCallback;
        final Function0 r115 = this.$onAnimEnd;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, "contextController");
        Intrinsics.checkNotNullParameter(r113, "view");
        Intrinsics.checkNotNullParameter(r115, "onAnimEnd");
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] showSwitchAnimation");
        final Function0<Integer> r116 = new BottomRightAnim$showSwitchAnimation$getViewHeight$1(r113);
        BottomRightAnim.i(r113, new BottomRightAnim$showSwitchAnimation$1(r113, r112, r115, r114, r116));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100) {
        invoke(r100.intValue());
        return Unit.INSTANCE;
    }
}
