package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class Guideline extends View {
    private boolean mFilterRedundantCalls;

    @Override // android.view.View
    public void draw(Canvas r1) {
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
    }

    public Guideline(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    public Guideline(Context r2, AttributeSet r3, int r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"), r4);
        this.mFilterRedundantCalls = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int r4) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (this.mFilterRedundantCalls == true) goto L5;
    L7:
        r0.guideBegin = r4;
        setLayoutParams(r0);
        return;
    L5:
        if (r0.guideBegin != r4) goto L7;
    }

    public void setGuidelineEnd(int r4) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (this.mFilterRedundantCalls == true) goto L5;
    L7:
        r0.guideEnd = r4;
        setLayoutParams(r0);
        return;
    L5:
        if (r0.guideEnd != r4) goto L7;
    }

    public void setGuidelinePercent(float r4) {
        ConstraintLayout.LayoutParams r0 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (this.mFilterRedundantCalls == true) goto L5;
    L7:
        r0.guidePercent = r4;
        setLayoutParams(r0);
        return;
    L5:
        if (r0.guidePercent != r4) goto L7;
    }

    public void setFilterRedundantCalls(boolean r1) {
        this.mFilterRedundantCalls = r1;
    }
}
