package com.stepos.taskrobot.llmapi.stepfun.view;

import C7.r;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.motionkit.MotionKit;
import com.stepos.motionkit.fx.material.MaterialHandle;
import com.stepos.motionkit.fx.material.Materials;
import com.stepos.motionkit.fx.material.MotionMaterialExtKt;
import com.stepos.motionkit.fx.material.capability.BlurParams;
import com.stepos.taskrobot.llmapi.stepfun.R;
import com.stepos.taskrobot.llmapi.stepfun.g;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\b\b\u0001\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001b\u0010\fR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/AntiMistouchBubbleView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LC7/r;", "commitBlurIfNeeded", "()V", "", "value", "dp", "(F)I", "resId", RequestInfo.FUNCTION_SET_TEXT, "(I)V", "touchX", "touchY", "parent", "show", "(FFLandroid/widget/FrameLayout;)V", "dismiss", "onAttachedToWindow", "onDetachedFromWindow", "Landroidx/constraintlayout/widget/ConstraintLayout;", "bubbleContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/TextView;", "bubbleText", "Landroid/widget/TextView;", "blurRadiusPx", "I", "cornerRadiusPx", "F", "Lcom/stepos/motionkit/fx/material/MaterialHandle;", "motionHandle", "Lcom/stepos/motionkit/fx/material/MaterialHandle;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AntiMistouchBubbleView extends FrameLayout {
    private final int blurRadiusPx;
    private final ConstraintLayout bubbleContainer;
    private final TextView bubbleText;
    private final float cornerRadiusPx;
    private MaterialHandle motionHandle;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AntiMistouchBubbleView(Context context) {
        this(context, null, 0, 6, null);
        k.f(context, "context");
    }

    private final void commitBlurIfNeeded() {
        if (this.motionHandle != null) {
            return;
        }
        this.motionHandle = MotionMaterialExtKt.material(MotionKit.INSTANCE, this.bubbleContainer).crossWindow(true).cornerRadius(this.cornerRadiusPx).apply(Materials.INSTANCE.getBlur(), new g(this, 1)).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r commitBlurIfNeeded$lambda$0(AntiMistouchBubbleView antiMistouchBubbleView, BlurParams apply) {
        k.f(apply, "$this$apply");
        apply.setRadius(antiMistouchBubbleView.blurRadiusPx);
        return r.f317a;
    }

    private final int dp(float value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    public final void dismiss() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        commitBlurIfNeeded();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MaterialHandle materialHandle = this.motionHandle;
        if (materialHandle != null) {
            try {
                materialHandle.release();
            } catch (Throwable th) {
                kotlin.b.a(th);
            }
        }
        this.motionHandle = null;
    }

    public final void setText(@StringRes int resId) {
        this.bubbleText.setText(resId);
    }

    public final void show(float touchX, float touchY, FrameLayout parent) {
        k.f(parent, "parent");
        ViewParent parent2 = getParent();
        ViewGroup viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388659;
        parent.addView(this, layoutParams);
        int iDp = dp(10.0f);
        int width = parent.getWidth();
        int height = parent.getHeight();
        int i = width - (iDp * 2);
        if (i < 0) {
            i = 0;
        }
        measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i6 = (int) (touchX - (measuredWidth / 2.0f));
        float f = iDp;
        int i10 = (int) ((touchY - measuredHeight) - f);
        int i11 = (width - measuredWidth) - iDp;
        if (i11 < iDp) {
            i11 = iDp;
        }
        int iU = AbstractC1451a.u(i6, iDp, i11);
        if (i10 < iDp) {
            i10 = (int) (touchY + f);
        }
        int i12 = (height - measuredHeight) - iDp;
        if (i12 < iDp) {
            i12 = iDp;
        }
        int iU2 = AbstractC1451a.u(i10, iDp, i12);
        setTranslationX(iU);
        setTranslationY(iU2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AntiMistouchBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AntiMistouchBubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k.f(context, "context");
        this.blurRadiusPx = getResources().getDimensionPixelSize(R.dimen.anti_mistouch_bubble_blur_radius);
        this.cornerRadiusPx = getResources().getDimension(R.dimen.anti_mistouch_bubble_corner_radius);
        setElevation(getResources().getDimension(R.dimen.anti_mistouch_bubble_elevation));
        setClipChildren(false);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_anti_mistouch_bubble, (ViewGroup) this, false);
        View viewFindViewById = viewInflate.findViewById(R.id.anti_mistouch_bubble_container);
        k.e(viewFindViewById, "findViewById(...)");
        this.bubbleContainer = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.anti_mistouch_bubble_text);
        k.e(viewFindViewById2, "findViewById(...)");
        this.bubbleText = (TextView) viewFindViewById2;
        addView(viewInflate);
    }

    public /* synthetic */ AntiMistouchBubbleView(Context context, AttributeSet attributeSet, int i, int i6, e eVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 0 : i);
    }
}
