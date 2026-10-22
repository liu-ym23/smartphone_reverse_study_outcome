package com.stepos.agentframework.chatui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.stepos.agentframework.R$raw;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/chatui/view/LoadingBubbleDotsView;", "Lcom/airbnb/lottie/LottieAnimationView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "isVisible", "LY8/t;", "onVisibilityAggregated", "(Z)V", "onDetachedFromWindow", "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoadingBubbleDotsView extends LottieAnimationView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingBubbleDotsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        setAnimation(R$raw.chat_asr_waiting_dots);
        setRepeatCount(-1);
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setImportantForAccessibility(2);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        cancelAnimation();
        setProgress(0.0f);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        if (!isVisible || !isAttachedToWindow()) {
            cancelAnimation();
            setProgress(0.0f);
        } else {
            if (isAnimating()) {
                return;
            }
            playAnimation();
        }
    }
}
