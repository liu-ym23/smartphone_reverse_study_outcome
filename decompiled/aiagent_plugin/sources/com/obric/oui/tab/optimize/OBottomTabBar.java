package com.obric.oui.tab.optimize;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OBottomTabBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBottomTabBar extends LinearLayout {
    public static final a Companion = null;
    private static final float DIVIDER_WIDTH = 0.6f;
    private static final com.obric.oui.common.a sdkInit = null;
    private b _onTabSelectedListener;
    private float dividerWith;
    private final Paint mDividerPaint;
    private int selectedIndex;
    private boolean topLineVis;

    /* JADX INFO: compiled from: OBottomTabBar.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OBottomTabBar.kt */
    public interface b {
        void a(int r1, OBottomTabItem r2);
    }

    public OBottomTabBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBottomTabBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$R4TtgFYXkk68VkBkBEQmoYOHXjE(OBottomTabBar r0, OBottomTabItem r1, View r2) {
        m1194addTab$lambda1(r0, r1, r2);
    }

    public /* synthetic */ OBottomTabBar(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OBottomTabBar(Context r7, AttributeSet r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        super(r10, r11, r9);
        this.selectedIndex = -1;
        Paint r12 = new Paint();
        r12.setStyle(Paint.Style.FILL);
        r12.setColor(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_line_2, "color", "oui_line_2")));
        this.mDividerPaint = r12;
        setOrientation(0);
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        setPadding((int) ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_2, "dimen", "oui_p_container_2")), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4.5d), (int) ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_2, "dimen", "oui_p_container_2")), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 2));
        float r13 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), DIVIDER_WIDTH);
        this.dividerWith = r13;
        r12.setStrokeWidth(r13);
        setWillNotDraw(false);
        this.topLineVis = true;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final void addTab(final OBottomTabItem r5) {
        o.e(r5, "tabItem");
        r5.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(0, -2, 1.0f), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r5.setOnClickListener(new $$Lambda$OBottomTabBar$R4TtgFYXkk68VkBkBEQmoYOHXjE(this, r5));
        addView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: addTab$lambda-1, reason: not valid java name */
    private static final void m1194addTab$lambda1(OBottomTabBar r1, OBottomTabItem r2, View r3) {
        o.e(r1, "this$0");
        o.e(r2, "$tabItem");
        r1.selectTab(r1.indexOfChild((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin")));
    }

    public final void removeTab(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == false) goto L10;
        removeViewAt(r3);
        return;
    L10:
        return;
    L5:
        if (r3 >= getChildCount()) goto L7;
        r0 = true;
        goto L7
    }

    public final void selectTab(int r5) {
        if (r5 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L17;
        int r3 = this.selectedIndex;
        if (r3 == (-1)) goto L12;
        getChildAt(r3).setSelected(false);
    L12:
        getChildAt(r5).setSelected(true);
        this.selectedIndex = r5;
        b r0 = this._onTabSelectedListener;
        if (r0 == null) goto L18;
        View r4 = getChildAt(r5);
        Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.tab.optimize.OBottomTabItem");
        r0.a(r5, (OBottomTabItem) ZeusTransformUtils.preCheckCast(r4, OBottomTabItem.class, "com.obric.aiagent.plugin"));
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if (r5 >= getChildCount()) goto L7;
        r2 = true;
        goto L8
    }

    public final void setOnTabSelectedListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this._onTabSelectedListener = r4;
    }

    public final void setShowTopLine(boolean r1) {
        this.topLineVis = r1;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r8) {
        super.onDraw(r8);
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.topLineVis == false) goto L10;
        r8.save();
        r8.drawLine(0.0f, this.dividerWith / 2.0f, getWidth(), this.dividerWith, this.mDividerPaint);
        r8.restore();
        return;
    }

    static {
        Companion = new a(null);
        sdkInit = new com.obric.oui.common.a();
    }
}
