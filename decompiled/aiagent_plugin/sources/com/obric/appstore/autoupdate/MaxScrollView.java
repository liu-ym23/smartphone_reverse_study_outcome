package com.obric.appstore.autoupdate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class MaxScrollView extends ScrollView {
    private int mMaxHeight;

    public MaxScrollView(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        this.mMaxHeight = 0;
    }

    public MaxScrollView(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.mMaxHeight = 0;
    }

    public MaxScrollView(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
        this.mMaxHeight = 0;
    }

    public MaxScrollView(Context r3, AttributeSet r4, int r5, int r6) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5, r6);
        this.mMaxHeight = 0;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r2, int r3) {
        int r0 = this.mMaxHeight;
        if (r0 <= 0) goto L5;
        r3 = View.MeasureSpec.makeMeasureSpec(r0, Integer.MIN_VALUE);
    L5:
        super.onMeasure(r2, r3);
    }

    public void setMaxHeight(int r1) {
        this.mMaxHeight = r1;
        requestLayout();
    }
}
