package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.a.c.e;
import androidx.constraintlayout.a.c.f;
import androidx.constraintlayout.a.c.i;
import androidx.constraintlayout.a.c.l;
import androidx.constraintlayout.a.c.m;
import androidx.constraintlayout.widget.VirtualLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class MotionPlaceholder extends VirtualLayout {
    private static final String TAG = "MotionPlaceholder";
    l mPlaceholder;

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreLayout(f r1, i r2, SparseArray<e> r3) {
        i r0 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin");
    }

    public MotionPlaceholder(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public MotionPlaceholder(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public MotionPlaceholder(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
    }

    public MotionPlaceholder(Context r2, AttributeSet r3, int r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onMeasure(int r2, int r3) {
        onMeasure(this.mPlaceholder, r2, r3);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void onMeasure(m r3, int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r4);
        int r6 = View.MeasureSpec.getSize(r4);
        int r1 = View.MeasureSpec.getMode(r5);
        int r7 = View.MeasureSpec.getSize(r5);
        if (r3 == null) goto L5;
        r3.b(r0, r6, r1, r7);
        setMeasuredDimension(r3.af(), r3.ag());
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r3) {
        super.init((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.mHelperWidget = new l();
        validateParams();
    }
}
