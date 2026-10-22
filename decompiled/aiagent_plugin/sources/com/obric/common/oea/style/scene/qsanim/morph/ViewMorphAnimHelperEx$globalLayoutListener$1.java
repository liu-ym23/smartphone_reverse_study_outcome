package com.obric.common.oea.style.scene.qsanim.morph;

import android.view.ViewTreeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ViewMorphAnimHelperEx.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ViewMorphAnimHelperEx$globalLayoutListener$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ d this$0;

    ViewMorphAnimHelperEx$globalLayoutListener$1(d r1) {
        this.this$0 = r1;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (d.b(this.this$0) == false) goto L6;
        this.this$0.a().getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.aiagent.plugin"));
        return;
    }
}
