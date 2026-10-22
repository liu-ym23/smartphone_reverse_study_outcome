package com.obric.oui.tab.optimize;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.obric.common.oui.R;
import com.obric.oui.common.SdkInit;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OBottomTabBar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 #2\u00020\u0001:\u0002#$B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabBar;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_onTabSelectedListener", "Lcom/obric/oui/tab/optimize/OBottomTabBar$OnTabSelectedListener;", "dividerWith", "", "mDividerPaint", "Landroid/graphics/Paint;", "<set-?>", "selectedIndex", "getSelectedIndex", "()I", "topLineVis", "", "addTab", "", "tabItem", "Lcom/obric/oui/tab/optimize/OBottomTabItem;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "removeTab", "index", "selectTab", "setOnTabSelectedListener", "listener", "setShowTopLine", "show", "Companion", "OnTabSelectedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomTabBar extends LinearLayout {
    public static final Companion Companion = null;
    private static final float DIVIDER_WIDTH = 0.6f;
    private static final SdkInit sdkInit = null;
    private OnTabSelectedListener _onTabSelectedListener;
    private float dividerWith;
    private final Paint mDividerPaint;
    private int selectedIndex;
    private boolean topLineVis;

    /* JADX INFO: compiled from: OBottomTabBar.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\b"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabBar$Companion;", "", "()V", "DIVIDER_WIDTH", "", "sdkInit", "Lcom/obric/oui/common/SdkInit;", "getSdkInit$annotations", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private static /* synthetic */ void getSdkInit$annotations() {
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OBottomTabBar.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabBar$OnTabSelectedListener;", "", "onTabSelected", "", "index", "", "item", "Lcom/obric/oui/tab/optimize/OBottomTabItem;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnTabSelectedListener {
        void onTabSelected(int r1, OBottomTabItem r2);
    }

    public static /* synthetic */ void $r8$lambda$R4TtgFYXkk68VkBkBEQmoYOHXjE(OBottomTabBar r0, OBottomTabItem r1, View r2) {
        m717addTab$lambda1(r0, r1, r2);
    }

    public OBottomTabBar(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OBottomTabBar(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OBottomTabBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OBottomTabBar(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.selectedIndex = -1;
        Paint r8 = new Paint();
        r8.setStyle(Paint.Style.FILL);
        r8.setColor(getResources().getColor(R.color.oui_line_2));
        this.mDividerPaint = r8;
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        OBottomTabBar r0 = this;
        setPadding((int) getResources().getDimension(R.dimen.oui_p_container_2), OUnitExtensionKt.vdp(r0, 4.5d), (int) getResources().getDimension(R.dimen.oui_p_container_2), OUnitExtensionKt.vdp(r0, 2));
        float r9 = OUnitExtensionKt.vdp(r0, 0.6f);
        this.dividerWith = r9;
        r8.setStrokeWidth(r9);
        setWillNotDraw(false);
        this.topLineVis = true;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final void addTab(final OBottomTabItem r5) {
        Intrinsics.checkNotNullParameter(r5, "tabItem");
        r5.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        r5.setOnClickListener(new OBottomTabBar$$ExternalSyntheticLambda0(this, r5));
        addView(r5);
    }

    /* JADX INFO: renamed from: addTab$lambda-1, reason: not valid java name */
    private static final void m717addTab$lambda1(OBottomTabBar r0, OBottomTabItem r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$tabItem");
        r0.selectTab(r0.indexOfChild(r1));
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
        if (r2 == false) goto L20;
        int r3 = this.selectedIndex;
        if (r3 == (-1)) goto L12;
        getChildAt(r3).setSelected(false);
    L12:
        getChildAt(r5).setSelected(true);
        this.selectedIndex = r5;
        OnTabSelectedListener r0 = this._onTabSelectedListener;
        if (r0 == null) goto L22;
        View r4 = getChildAt(r5);
        if (r4 == null) goto L19;
        r0.onTabSelected(r5, (OBottomTabItem) r4);
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.tab.optimize.OBottomTabItem");
    L22:
        return;
    L20:
        return;
    L5:
        if (r5 >= getChildCount()) goto L7;
        r2 = true;
        goto L8
    }

    public final void setOnTabSelectedListener(OnTabSelectedListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this._onTabSelectedListener = r2;
    }

    public final void setShowTopLine(boolean r1) {
        this.topLineVis = r1;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas r8) {
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
        Companion = new Companion(null);
        sdkInit = new SdkInit();
    }
}
