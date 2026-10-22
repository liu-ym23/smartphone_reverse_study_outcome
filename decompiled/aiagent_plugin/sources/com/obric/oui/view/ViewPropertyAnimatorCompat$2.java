package com.obric.oui.view;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.ah;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class ViewPropertyAnimatorCompat$2 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ d this$0;
    final /* synthetic */ ah val$listener;
    final /* synthetic */ View val$view;

    ViewPropertyAnimatorCompat$2(d r3, ah r4, View r5) {
        ah r6 = (ah) ZeusTransformUtils.wrapperContextForParams(r4, ah.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        this.val$listener = r6;
        this.val$view = r5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r1) {
        this.val$listener.a(this.val$view);
    }
}
