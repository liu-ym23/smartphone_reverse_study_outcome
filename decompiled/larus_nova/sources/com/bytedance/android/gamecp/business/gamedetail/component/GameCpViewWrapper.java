package com.bytedance.android.gamecp.business.gamedetail.component;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\r\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\r\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0007R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/GameCpViewWrapper;", "", "targetView", "Landroid/view/View;", "(Landroid/view/View;)V", "mTargetView", "getTrueHeight", "", "()Ljava/lang/Integer;", "getTrueWeight", "", "()Ljava/lang/Float;", "getTrueWidth", "setTrueHeight", "", "height", "setTrueWeight", "weight", "setTrueWidth", "width", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameCpViewWrapper {
    private View mTargetView;

    public final Integer getTrueHeight() {
        View r100 = this.mTargetView;
        if (r100 == null) goto L7;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L7;
        return Integer.valueOf(r101.height);
    L7:
        return null;
    }

    public final Float getTrueWeight() {
        View r100 = this.mTargetView;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
    L7:
        if ((r101 instanceof LinearLayout.LayoutParams) == true) goto L9;
        r101 = null;
    L9:
        LinearLayout.LayoutParams r102 = (LinearLayout.LayoutParams) r101;
        if (r102 != null) goto L12;
        return null;
    L12:
        return Float.valueOf(r102.weight);
    L5:
        r101 = null;
        goto L7
    }

    public final Integer getTrueWidth() {
        View r100 = this.mTargetView;
        if (r100 == null) goto L7;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L7;
        return Integer.valueOf(r101.width);
    L7:
        return null;
    }

    public GameCpViewWrapper(View r100) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        this.mTargetView = r100;
    }

    public final void setTrueHeight(int r100) {
        View r101 = this.mTargetView;
        if (r101 == null) goto L7;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L7;
        r102.height = r100;
    L7:
        View r103 = this.mTargetView;
        if (r103 == null) goto L11;
        r103.requestLayout();
        return;
    }

    public final void setTrueWeight(float r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
        View r102 = this.mTargetView;     // Catch: Throwable -> L17
        Unit r103 = null;
        if (r102 == null) goto L5;
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();     // Catch: Throwable -> L17
    L7:
        if ((r104 instanceof LinearLayout.LayoutParams) == true) goto L9;
        r104 = null;
    L9:
        LinearLayout.LayoutParams r105 = (LinearLayout.LayoutParams) r104;     // Catch: Throwable -> L17
        if (r105 == null) goto L12;
        r105.weight = r100;     // Catch: Throwable -> L17
    L12:
        View r106 = this.mTargetView;     // Catch: Throwable -> L17
        if (r106 == null) goto L15;
        r106.requestLayout();     // Catch: Throwable -> L17
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L15:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L17
        return;
    L5:
        r104 = null;
    L17:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void setTrueWidth(int r100) {
        View r101 = this.mTargetView;
        if (r101 == null) goto L7;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L7;
        r102.width = r100;
    L7:
        View r103 = this.mTargetView;
        if (r103 == null) goto L11;
        r103.requestLayout();
        return;
    }
}
