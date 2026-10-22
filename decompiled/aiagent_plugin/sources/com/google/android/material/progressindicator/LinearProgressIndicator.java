package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator<k> {
    public static final int DEF_STYLE_RES = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_CONTIGUOUS = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_DISJOINT = 1;
    public static final int INDICATOR_DIRECTION_END_TO_START = 3;
    public static final int INDICATOR_DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int INDICATOR_DIRECTION_RIGHT_TO_LEFT = 1;
    public static final int INDICATOR_DIRECTION_START_TO_END = 2;

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* synthetic */ b createSpec(Context r3, AttributeSet r4) {
        return createSpec((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_LinearProgressIndicator, "style", "Widget_MaterialComponents_LinearProgressIndicator");
    }

    public LinearProgressIndicator(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public LinearProgressIndicator(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.linearProgressIndicatorStyle, "attr", "linearProgressIndicatorStyle"));
    }

    public LinearProgressIndicator(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5, DEF_STYLE_RES);
        initializeDrawables();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    k createSpec(Context r2, AttributeSet r3) {
        return new k((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        k r6 = (k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin");
        boolean r7 = true;
        if (((k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")).h != 1) goto L5;
    L14:
        r6.i = r7;
        return;
    L5:
        if (ViewCompat.i(this) != 1) goto L9;
        if (((k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")).h == 2) goto L14;
    L9:
        if (ViewCompat.i(this) == 0) goto L11;
    L13:
        r7 = false;
        goto L14
    L11:
        if (((k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")).h != 3) goto L13;
        goto L13
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        int r5 = r1 - (getPaddingLeft() + getPaddingRight());
        int r6 = r2 - (getPaddingTop() + getPaddingBottom());
        IndeterminateDrawable r7 = getIndeterminateDrawable();
        if (r7 == null) goto L5;
        r7.setBounds(0, 0, r5, r6);
    L5:
        DeterminateDrawable r0 = getProgressDrawable();
        if (r0 == null) goto L9;
        r0.setBounds(0, 0, r5, r6);
        return;
    }

    private void initializeDrawables() {
        setIndeterminateDrawable(IndeterminateDrawable.createLinearDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")));
        setProgressDrawable(DeterminateDrawable.createLinearDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")));
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(int... r2) {
        super.setIndicatorColor(r2);
        ((k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")).c();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int r3) {
        super.setTrackCornerRadius(r3);
        ((k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")).c();
        invalidate();
    }

    public int getIndeterminateAnimationType() {
        return ((k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")).g;
    }

    public void setIndeterminateAnimationType(int r6) {
        if (((k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")).g != r6) goto L6;
        return;
    L6:
        if (visibleToUser() == true) goto L8;
    L12:
        ((k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")).g = r6;
        ((k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")).c();
        if (r6 != 0) goto L15;
        getIndeterminateDrawable().setAnimatorDelegate(new i((k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")));
    L16:
        invalidate();
        return;
    L15:
        getIndeterminateDrawable().setAnimatorDelegate(new j((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")));
        goto L16
    L8:
        if (isIndeterminate() == false) goto L12;
        throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
    }

    public int getIndicatorDirection() {
        return ((k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")).h;
    }

    public void setIndicatorDirection(int r6) {
        ((k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")).h = r6;
        k r0 = (k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin");
        boolean r1 = true;
        if (r6 != 1) goto L5;
    L14:
        r0.i = r1;
        invalidate();
        return;
    L5:
        if (ViewCompat.i(this) != 1) goto L9;
        if (((k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")).h == 2) goto L14;
    L9:
        if (ViewCompat.i(this) == 0) goto L11;
    L13:
        r1 = false;
        goto L14
    L11:
        if (r6 != 3) goto L13;
        goto L13
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setProgressCompat(int r4, boolean r5) {
        if (this.spec != 0) goto L5;
    L9:
        super.setProgressCompat(r4, r5);
        return;
    L5:
        if (((k) ZeusTransformUtils.preCheckCast(this.spec, k.class, "com.obric.aiagent.plugin")).g != 0) goto L9;
        if (isIndeterminate() == false) goto L9;
    }
}
