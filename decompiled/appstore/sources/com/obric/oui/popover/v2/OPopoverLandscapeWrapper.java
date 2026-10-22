package com.obric.oui.popover.v2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0019\u0010\u001aR*\u0010#\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0017\u0010(\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverLandscapeWrapper;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/view/View;", "child", "", SlideCard.KEY_INDEX, "Landroid/view/ViewGroup$LayoutParams;", "params", "", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "", CommonKey.KEY_VALUE, "a", "F", "getOrientationAngle", "()F", "setOrientationAngle", "(F)V", "orientationAngle", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "getRotationLayer", "()Landroid/widget/FrameLayout;", "rotationLayer", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverLandscapeWrapper extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f16247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f16248b;

    public OPopoverLandscapeWrapper(@NotNull Context r10) {
        q.g(r10, "context");
        super(r10);
        FrameLayout r11 = new FrameLayout(r10);
        r11.setClipChildren(false);
        r11.setClipToPadding(false);
        this.f16248b = r11;
        setClipChildren(false);
        setClipToPadding(false);
        super.addView(r11, -1, new ViewGroup.LayoutParams(-2, -2));
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        q.g(r10, "child");
        this.f16248b.addView(r10, r11, r12);
    }

    public final float getOrientationAngle() {
        return this.f16247a;
    }

    @NotNull
    public final FrameLayout getRotationLayer() {
        return this.f16248b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = r13 - r11;
        int r16 = this.f16248b.getMeasuredWidth();
        int r17 = this.f16248b.getMeasuredHeight();
        int r18 = (r15 - r16) / 2;
        int r19 = ((r14 - r12) - r17) / 2;
        this.f16248b.layout(r18, r19, r18 + r16, r19 + r17);
        this.f16248b.setPivotX(r16 / 2.0f);
        this.f16248b.setPivotY(r17 / 2.0f);
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        if ((this.f16247a % AnimationConstants.DURATION_180) != 0.0f) goto L5;
        measureChild(this.f16248b, r10, r11);
        setMeasuredDimension(this.f16248b.getMeasuredWidth(), this.f16248b.getMeasuredHeight());
        return;
    L5:
        measureChild(this.f16248b, r11, r10);
        setMeasuredDimension(this.f16248b.getMeasuredHeight(), this.f16248b.getMeasuredWidth());
    }

    public final void setOrientationAngle(float r10) {
        this.f16247a = r10;
        this.f16248b.setRotation(r10);
        requestLayout();
    }
}
