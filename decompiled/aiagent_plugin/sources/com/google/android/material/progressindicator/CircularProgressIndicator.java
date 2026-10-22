package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<e> {
    public static final int DEF_STYLE_RES = 0;
    public static final int INDICATOR_DIRECTION_CLOCKWISE = 0;
    public static final int INDICATOR_DIRECTION_COUNTERCLOCKWISE = 1;

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* synthetic */ b createSpec(Context r3, AttributeSet r4) {
        return createSpec((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_CircularProgressIndicator, "style", "Widget_MaterialComponents_CircularProgressIndicator");
    }

    public CircularProgressIndicator(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public CircularProgressIndicator(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.circularProgressIndicatorStyle, "attr", "circularProgressIndicatorStyle"));
    }

    public CircularProgressIndicator(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5, DEF_STYLE_RES);
        initializeDrawables();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    e createSpec(Context r2, AttributeSet r3) {
        return new e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    private void initializeDrawables() {
        setIndeterminateDrawable(IndeterminateDrawable.createCircularDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (e) ZeusTransformUtils.preCheckCast(this.spec, e.class, "com.obric.aiagent.plugin")));
        setProgressDrawable(DeterminateDrawable.createCircularDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (e) ZeusTransformUtils.preCheckCast(this.spec, e.class, "com.obric.aiagent.plugin")));
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int r2) {
        super.setTrackThickness(r2);
        ((e) ZeusTransformUtils.preCheckCast(this.spec, e.class, "com.obric.aiagent.plugin")).c();
    }

    public int getIndicatorInset() {
        return ((e) ZeusTransformUtils.preCheckCast(this.spec, e.class, "com.obric.aiagent.plugin")).h;
    }

    public void setIndicatorInset(int r4) {
        if (((e) ZeusTransformUtils.preCheckCast(this.spec, e.class, "com.obric.aiagent.plugin")).h == r4) goto L6;
        ((e) ZeusTransformUtils.preCheckCast(this.spec, e.class, "com.obric.aiagent.plugin")).h = r4;
        invalidate();
        return;
    }

    public int getIndicatorSize() {
        return ((e) ZeusTransformUtils.preCheckCast(this.spec, e.class, "com.obric.aiagent.plugin")).g;
    }

    public void setIndicatorSize(int r4) {
        int r5 = Math.max(r4, getTrackThickness() * 2);
        if (((e) ZeusTransformUtils.preCheckCast(this.spec, e.class, "com.obric.aiagent.plugin")).g == r5) goto L6;
        ((e) ZeusTransformUtils.preCheckCast(this.spec, e.class, "com.obric.aiagent.plugin")).g = r5;
        ((e) ZeusTransformUtils.preCheckCast(this.spec, e.class, "com.obric.aiagent.plugin")).c();
        invalidate();
        return;
    }

    public int getIndicatorDirection() {
        return ((e) ZeusTransformUtils.preCheckCast(this.spec, e.class, "com.obric.aiagent.plugin")).i;
    }

    public void setIndicatorDirection(int r4) {
        ((e) ZeusTransformUtils.preCheckCast(this.spec, e.class, "com.obric.aiagent.plugin")).i = r4;
        invalidate();
    }
}
