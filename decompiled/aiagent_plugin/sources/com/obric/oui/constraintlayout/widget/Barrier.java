package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import com.obric.aiagent.plugin.R;
import com.obric.oui.constraintlayout.a.c.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class Barrier extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;
    private com.obric.oui.constraintlayout.a.c.a mBarrier;
    private int mIndicatedType;
    private int mResolvedType;

    public Barrier(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        super.setVisibility(8);
    }

    public Barrier(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        super.setVisibility(8);
    }

    public Barrier(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
        super.setVisibility(8);
    }

    public int getType() {
        return this.mIndicatedType;
    }

    public void setType(int r1) {
        this.mIndicatedType = r1;
    }

    private void updateType(com.obric.oui.constraintlayout.a.c.e r4, int r5, boolean r6) {
        this.mResolvedType = r5;
        if (r6 == false) goto L9;
        int r7 = this.mIndicatedType;
        if (r7 != 5) goto L7;
        this.mResolvedType = 1;
    L15:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.constraintlayout.a.c.a.class) == false) goto L18;
        ((com.obric.oui.constraintlayout.a.c.a) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.constraintlayout.a.c.a.class, "com.obric.aiagent.plugin")).a(this.mResolvedType);
        return;
    L18:
        return;
    L7:
        if (r7 != 6) goto L15;
        this.mResolvedType = 0;
        goto L15
    L9:
        int r8 = this.mIndicatedType;
        if (r8 != 5) goto L12;
        this.mResolvedType = 0;
        goto L15
    L12:
        if (r8 != 6) goto L15;
        this.mResolvedType = 1;
        goto L15
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(com.obric.oui.constraintlayout.a.c.e r2, boolean r3) {
        updateType(r2, this.mIndicatedType, r3);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r8) {
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        super.init(r9);
        this.mBarrier = new com.obric.oui.constraintlayout.a.c.a();
        if (r9 == null) goto L17;
        TypedArray r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r9, R.styleable.ConstraintLayout_Layout);
        int r0 = r10.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L16;
        int r3 = r10.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_barrierDirection, "styleable", "ConstraintLayout_Layout_barrierDirection")) goto L10;
        setType(r10.getInt(r3, 0));
    L15:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets, "styleable", "ConstraintLayout_Layout_barrierAllowsGoneWidgets")) goto L13;
        this.mBarrier.a(r10.getBoolean(r3, true));
        goto L15
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_barrierMargin, "styleable", "ConstraintLayout_Layout_barrierMargin")) goto L15;
        this.mBarrier.b(r10.getDimensionPixelSize(r3, 0));
        goto L15
    L16:
        r10.recycle();
    L17:
        this.mHelperWidget = this.mBarrier;
        validateParams();
    }

    public void setAllowsGoneWidget(boolean r1) {
        this.mBarrier.a(r1);
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mBarrier.c();
    }

    public boolean getAllowsGoneWidget() {
        return this.mBarrier.c();
    }

    public void setDpMargin(int r2) {
        this.mBarrier.b((int) ((r2 * ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density) + 0.5f));
    }

    public int getMargin() {
        return this.mBarrier.g();
    }

    public void setMargin(int r1) {
        this.mBarrier.b(r1);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void loadParameters(c.a r2, j r3, ConstraintLayout.LayoutParams r4, SparseArray<com.obric.oui.constraintlayout.a.c.e> r5) {
        super.loadParameters(r2, r3, r4, r5);
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.constraintlayout.a.c.a.class) == false) goto L6;
        com.obric.oui.constraintlayout.a.c.a r6 = (com.obric.oui.constraintlayout.a.c.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.constraintlayout.a.c.a.class, "com.obric.aiagent.plugin");
        boolean r7 = ((com.obric.oui.constraintlayout.a.c.f) ZeusTransformUtils.preCheckCast(r3.A(), com.obric.oui.constraintlayout.a.c.f.class, "com.obric.aiagent.plugin")).ag();
        updateType(r6, r2.f34961e.ah, r7);
        r6.a(r2.f34961e.ap);
        r6.b(r2.f34961e.ai);
        return;
    }
}
