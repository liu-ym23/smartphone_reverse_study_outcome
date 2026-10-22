package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.l;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LinearProgressIndicatorSpec.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends b {
    public int g;
    public int h;
    boolean i;

    public k(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.linearProgressIndicatorStyle, "attr", "linearProgressIndicatorStyle"));
    }

    public k(Context r3, AttributeSet r4, int r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5, LinearProgressIndicator.DEF_STYLE_RES);
    }

    public k(Context r9, AttributeSet r10, int r11, int r12) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r2, r3, r11, r12);
        boolean r13 = false;
        TypedArray r14 = l.a(r2, r3, R.styleable.LinearProgressIndicator, ZeusTransformUtils.mapRes(R.attr.linearProgressIndicatorStyle, "attr", "linearProgressIndicatorStyle"), LinearProgressIndicator.DEF_STYLE_RES, new int[0]);
        this.g = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.LinearProgressIndicator_indeterminateAnimationType, "styleable", "LinearProgressIndicator_indeterminateAnimationType"), 1);
        this.h = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.LinearProgressIndicator_indicatorDirectionLinear, "styleable", "LinearProgressIndicator_indicatorDirectionLinear"), 0);
        r14.recycle();
        c();
        if (this.h != 1) goto L5;
        r13 = true;
    L5:
        this.i = r13;
    }

    @Override // com.google.android.material.progressindicator.b
    void c() {
        if (this.g == 0) goto L5;
        return;
    L5:
        if (this.f13507b > 0) goto L12;
        if (this.f13508c.length < 3) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
    L12:
        throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
    }
}
