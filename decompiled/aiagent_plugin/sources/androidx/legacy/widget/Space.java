package androidx.legacy.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class Space extends View {
    @Override // android.view.View
    @Deprecated
    public void draw(Canvas r1) {
    }

    @Deprecated
    public Space(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
        if (getVisibility() != 0) goto L6;
        setVisibility(4);
        return;
    }

    @Deprecated
    public Space(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    @Deprecated
    public Space(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    private static int getDefaultSize2(int r2, int r3) {
        int r0 = View.MeasureSpec.getMode(r3);
        int r4 = View.MeasureSpec.getSize(r3);
        if (r0 == Integer.MIN_VALUE) goto L9;
        if (r0 == 1073741824) goto L10;
        return r2;
    L10:
        return r4;
    L9:
        return Math.min(r2, r4);
    }

    @Override // android.view.View
    @Deprecated
    public void onMeasure(int r2, int r3) {
        setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), r2), getDefaultSize2(getSuggestedMinimumHeight(), r3));
    }
}
