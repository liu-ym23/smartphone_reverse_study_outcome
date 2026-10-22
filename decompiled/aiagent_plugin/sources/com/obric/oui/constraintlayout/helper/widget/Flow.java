package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.obric.aiagent.plugin.R;
import com.obric.oui.constraintlayout.a.c.e;
import com.obric.oui.constraintlayout.a.c.g;
import com.obric.oui.constraintlayout.a.c.j;
import com.obric.oui.constraintlayout.a.c.m;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import com.obric.oui.constraintlayout.widget.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class Flow extends VirtualLayout {
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    private static final String TAG = "Flow";
    public static final int VERTICAL = 1;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private g mFlow;

    public Flow(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public Flow(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public Flow(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(e r1, boolean r2) {
        this.mFlow.a(r2);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onMeasure(int r2, int r3) {
        onMeasure(this.mFlow, r2, r3);
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout
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

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void loadParameters(c.a r1, j r2, ConstraintLayout.LayoutParams r3, SparseArray<e> r4) {
        super.loadParameters(r1, r2, r3, r4);
        if (ZeusTransformUtils.instanceOf(r2, g.class) == false) goto L8;
        g r0 = (g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin");
        if (r3.orientation == (-1)) goto L9;
        r0.a(r3.orientation);
        return;
    L9:
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r9) {
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin");
        super.init(r10);
        this.mFlow = new g();
        if (r10 == null) goto L86;
        TypedArray r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r10, R.styleable.ConstraintLayout_Layout);
        int r0 = r11.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L85;
        int r3 = r11.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_orientation, "styleable", "ConstraintLayout_Layout_android_orientation")) goto L10;
        this.mFlow.a(r11.getInt(r3, 0));
    L84:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_padding, "styleable", "ConstraintLayout_Layout_android_padding")) goto L13;
        this.mFlow.M(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingStart, "styleable", "ConstraintLayout_Layout_android_paddingStart")) goto L16;
        this.mFlow.N(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L16:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingEnd, "styleable", "ConstraintLayout_Layout_android_paddingEnd")) goto L19;
        this.mFlow.O(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L19:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingLeft, "styleable", "ConstraintLayout_Layout_android_paddingLeft")) goto L22;
        this.mFlow.P(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L22:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingTop, "styleable", "ConstraintLayout_Layout_android_paddingTop")) goto L25;
        this.mFlow.Q(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L25:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingRight, "styleable", "ConstraintLayout_Layout_android_paddingRight")) goto L28;
        this.mFlow.R(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L28:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingBottom, "styleable", "ConstraintLayout_Layout_android_paddingBottom")) goto L31;
        this.mFlow.S(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L31:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_wrapMode, "styleable", "ConstraintLayout_Layout_flow_wrapMode")) goto L34;
        this.mFlow.H(r11.getInt(r3, 0));
        goto L84
    L34:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_horizontalStyle, "styleable", "ConstraintLayout_Layout_flow_horizontalStyle")) goto L37;
        this.mFlow.D(r11.getInt(r3, 0));
        goto L84
    L37:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_verticalStyle, "styleable", "ConstraintLayout_Layout_flow_verticalStyle")) goto L40;
        this.mFlow.E(r11.getInt(r3, 0));
        goto L84
    L40:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle, "styleable", "ConstraintLayout_Layout_flow_firstHorizontalStyle")) goto L43;
        this.mFlow.b(r11.getInt(r3, 0));
        goto L84
    L43:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle, "styleable", "ConstraintLayout_Layout_flow_lastHorizontalStyle")) goto L46;
        this.mFlow.B(r11.getInt(r3, 0));
        goto L84
    L46:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle, "styleable", "ConstraintLayout_Layout_flow_firstVerticalStyle")) goto L49;
        this.mFlow.A(r11.getInt(r3, 0));
        goto L84
    L49:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle, "styleable", "ConstraintLayout_Layout_flow_lastVerticalStyle")) goto L52;
        this.mFlow.C(r11.getInt(r3, 0));
        goto L84
    L52:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_horizontalBias, "styleable", "ConstraintLayout_Layout_flow_horizontalBias")) goto L55;
        this.mFlow.e(r11.getFloat(r3, 0.5f));
        goto L84
    L55:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias, "styleable", "ConstraintLayout_Layout_flow_firstHorizontalBias")) goto L58;
        this.mFlow.g(r11.getFloat(r3, 0.5f));
        goto L84
    L58:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias, "styleable", "ConstraintLayout_Layout_flow_lastHorizontalBias")) goto L61;
        this.mFlow.i(r11.getFloat(r3, 0.5f));
        goto L84
    L61:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias, "styleable", "ConstraintLayout_Layout_flow_firstVerticalBias")) goto L64;
        this.mFlow.h(r11.getFloat(r3, 0.5f));
        goto L84
    L64:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias, "styleable", "ConstraintLayout_Layout_flow_lastVerticalBias")) goto L67;
        this.mFlow.j(r11.getFloat(r3, 0.5f));
        goto L84
    L67:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_verticalBias, "styleable", "ConstraintLayout_Layout_flow_verticalBias")) goto L70;
        this.mFlow.f(r11.getFloat(r3, 0.5f));
        goto L84
    L70:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_horizontalAlign, "styleable", "ConstraintLayout_Layout_flow_horizontalAlign")) goto L73;
        this.mFlow.F(r11.getInt(r3, 2));
        goto L84
    L73:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_verticalAlign, "styleable", "ConstraintLayout_Layout_flow_verticalAlign")) goto L76;
        this.mFlow.G(r11.getInt(r3, 2));
        goto L84
    L76:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_horizontalGap, "styleable", "ConstraintLayout_Layout_flow_horizontalGap")) goto L79;
        this.mFlow.I(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L79:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_verticalGap, "styleable", "ConstraintLayout_Layout_flow_verticalGap")) goto L82;
        this.mFlow.J(r11.getDimensionPixelSize(r3, 0));
        goto L84
    L82:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap, "styleable", "ConstraintLayout_Layout_flow_maxElementsWrap")) goto L84;
        this.mFlow.K(r11.getInt(r3, -1));
        goto L84
    L85:
        r11.recycle();
    L86:
        this.mHelperWidget = this.mFlow;
        validateParams();
    }

    public void setOrientation(int r2) {
        this.mFlow.a(r2);
        requestLayout();
    }

    public void setPadding(int r2) {
        this.mFlow.M(r2);
        requestLayout();
    }

    public void setPaddingLeft(int r2) {
        this.mFlow.P(r2);
        requestLayout();
    }

    public void setPaddingTop(int r2) {
        this.mFlow.Q(r2);
        requestLayout();
    }

    public void setPaddingRight(int r2) {
        this.mFlow.R(r2);
        requestLayout();
    }

    public void setPaddingBottom(int r2) {
        this.mFlow.S(r2);
        requestLayout();
    }

    public void setLastHorizontalStyle(int r2) {
        this.mFlow.B(r2);
        requestLayout();
    }

    public void setLastVerticalStyle(int r2) {
        this.mFlow.C(r2);
        requestLayout();
    }

    public void setLastHorizontalBias(float r2) {
        this.mFlow.i(r2);
        requestLayout();
    }

    public void setLastVerticalBias(float r2) {
        this.mFlow.j(r2);
        requestLayout();
    }

    public void setWrapMode(int r2) {
        this.mFlow.H(r2);
        requestLayout();
    }

    public void setHorizontalStyle(int r2) {
        this.mFlow.D(r2);
        requestLayout();
    }

    public void setVerticalStyle(int r2) {
        this.mFlow.E(r2);
        requestLayout();
    }

    public void setHorizontalBias(float r2) {
        this.mFlow.e(r2);
        requestLayout();
    }

    public void setVerticalBias(float r2) {
        this.mFlow.f(r2);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int r2) {
        this.mFlow.b(r2);
        requestLayout();
    }

    public void setFirstVerticalStyle(int r2) {
        this.mFlow.A(r2);
        requestLayout();
    }

    public void setFirstHorizontalBias(float r2) {
        this.mFlow.g(r2);
        requestLayout();
    }

    public void setFirstVerticalBias(float r2) {
        this.mFlow.h(r2);
        requestLayout();
    }

    public void setHorizontalAlign(int r2) {
        this.mFlow.F(r2);
        requestLayout();
    }

    public void setVerticalAlign(int r2) {
        this.mFlow.G(r2);
        requestLayout();
    }

    public void setHorizontalGap(int r2) {
        this.mFlow.I(r2);
        requestLayout();
    }

    public void setVerticalGap(int r2) {
        this.mFlow.J(r2);
        requestLayout();
    }

    public void setMaxElementsWrap(int r2) {
        this.mFlow.K(r2);
        requestLayout();
    }
}
