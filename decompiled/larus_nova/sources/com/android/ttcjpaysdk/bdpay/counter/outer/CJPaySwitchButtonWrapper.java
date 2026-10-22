package com.android.ttcjpaysdk.bdpay.counter.outer;

import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012:\b\u0002\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0002J\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0006J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J@\u0010\u001f\u001a\u00020\u000b28\u0010 \u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/CJPaySwitchButtonWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "contentView", "Landroid/view/ViewGroup;", "onStateChange", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "state", "needAnimation", "", "forbidStateChange", "Lkotlin/Function0;", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "isOpen", "signSwitchBtnBg", "Landroid/widget/LinearLayout;", "signSwitchBtnLeftSpaceView", "Landroid/view/View;", "animateSwitchButton", "fromWidth", "", "toWidth", "refreshState", "resetInitState", "initState", "resetPosition", "targetValue", "setOnClick", "toggleSwitchButton", "updateStateChangeListener", "newOnStateChange", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySwitchButtonWrapper extends BaseWrapper {
    private final Function0<Boolean> forbidStateChange;
    private boolean isOpen;
    private Function2<? super Boolean, ? super Boolean, Unit> onStateChange;
    private LinearLayout signSwitchBtnBg;
    private View signSwitchBtnLeftSpaceView;

    private final void setOnClick() {
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.signSwitchBtnBg, new C89461(this));
    }

    private final void toggleSwitchButton() {
        this.isOpen = !this.isOpen;
        refreshState$default(this, false, 1, null);
    }

    public static final /* synthetic */ Function0 access$getForbidStateChange$p(CJPaySwitchButtonWrapper r100) {
        return r100.forbidStateChange;
    }

    public static final /* synthetic */ View access$getSignSwitchBtnLeftSpaceView$p(CJPaySwitchButtonWrapper r100) {
        return r100.signSwitchBtnLeftSpaceView;
    }

    public static final /* synthetic */ void access$toggleSwitchButton(CJPaySwitchButtonWrapper r100) {
        r100.toggleSwitchButton();
    }

    private final void refreshState(boolean r100) {
        if (this.isOpen == false) goto L11;
        int r101 = CJPayBasicExtensionKt.dp(18);
        if (r100 == false) goto L7;
        animateSwitchButton(CJPayBasicExtensionKt.dp(0), r101);
    L8:
        LinearLayout r102 = this.signSwitchBtnBg;
        if (r102 == null) goto L18;
        r102.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.cj_pay_sign_switch_btn_bg));
    L18:
        Function2<? super Boolean, ? super Boolean, Unit> r103 = this.onStateChange;
        if (r103 == null) goto L22;
        r103.invoke(Boolean.valueOf(this.isOpen), Boolean.valueOf(r100));
        return;
    L22:
        return;
    L7:
        resetPosition(r101);
        goto L8
    L11:
        int r104 = CJPayBasicExtensionKt.dp(0);
        if (r100 == false) goto L14;
        animateSwitchButton(CJPayBasicExtensionKt.dp(18), r104);
    L15:
        LinearLayout r105 = this.signSwitchBtnBg;
        if (r105 == null) goto L18;
        r105.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.cj_pay_sign_switch_btn_close_bg));
        goto L18
    L14:
        resetPosition(r104);
        goto L15
    }

    private final void resetPosition(int r100) {
        View r101 = this.signSwitchBtnLeftSpaceView;
        if (r101 == null) goto L5;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
    L6:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r102).width = r100;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void resetInitState(boolean r100) {
        this.isOpen = r100;
        refreshState(false);
    }

    public final void updateStateChangeListener(Function2<? super Boolean, ? super Boolean, Unit> r100) {
        this.onStateChange = r100;
    }

    private final void animateSwitchButton(int r100, int r101) {
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{r100, r101});
        r102.setDuration(320);
        r102.setInterpolator(new DecelerateInterpolator());
        r102.addUpdateListener(new C89451(this));
        r102.start();
    }

    public CJPaySwitchButtonWrapper(ViewGroup r100, Function2<? super Boolean, ? super Boolean, Unit> r101, Function0<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        Intrinsics.checkNotNullParameter(r102, "forbidStateChange");
        super(r100);
        this.onStateChange = r101;
        this.forbidStateChange = r102;
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.cj_pay_switch_button_layout, r100);
        this.signSwitchBtnBg = (LinearLayout) r103.findViewById(R.id.sign_switch_button_bg);
        this.signSwitchBtnLeftSpaceView = r103.findViewById(R.id.sign_switch_btn_left_space_view);
        setOnClick();
    }

    public static /* synthetic */ void refreshState$default(CJPaySwitchButtonWrapper r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = true;
    L5:
        r100.refreshState(r101);
    }

    public /* synthetic */ CJPaySwitchButtonWrapper(ViewGroup r100, Function2 r101, Function0 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = AnonymousClass1.INSTANCE;
    L8:
        this(r100, r101, r102);
    }
}
