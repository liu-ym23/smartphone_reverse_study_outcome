package com.obric.oui.shadow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.style.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OShadowLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OShadowLayout extends FrameLayout {
    public static final a Companion = null;
    private static final String TAG = "ShadowLayout";
    private j firstShadow;
    private j secondShadow;
    private float shadowCornerRadius;

    /* JADX INFO: compiled from: OShadowLayout.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public OShadowLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OShadowLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OShadowLayout(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OShadowLayout(Context r11, AttributeSet r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        super(r14, r15, r13);
        this.firstShadow = j.f34540b.j();
        this.secondShadow = j.f34540b.j();
        TypedArray r16 = r14.obtainStyledAttributes(r15, R.styleable.OShadowLayout, r13, 0);
        o.c(r16, "context.obtainStyledAttr…wLayout, defStyleAttr, 0)");
        b[] r17 = ShadowTokenCore.parse(r16.getString(ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_shadow, "styleable", "OShadowLayout_oui_shadow")));
        float r18 = ZeusTransformUtils.getResources(r14, "com.obric.aiagent.plugin").getDisplayMetrics().density;
        if (r17 != null) goto L5;
        this.firstShadow.a(com.obric.oui.shadow.a.f36179a.a(r16, ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_firstShadowColor, "styleable", "OShadowLayout_oui_firstShadowColor"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_firstShadowRadius, "styleable", "OShadowLayout_oui_firstShadowRadius"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_firstOffsetX, "styleable", "OShadowLayout_oui_firstOffsetX"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_firstOffsetY, "styleable", "OShadowLayout_oui_firstOffsetY"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_firstShadowSpread, "styleable", "OShadowLayout_oui_firstShadowSpread")));
        this.secondShadow.a(com.obric.oui.shadow.a.f36179a.a(r16, ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_secondShadowColor, "styleable", "OShadowLayout_oui_secondShadowColor"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_secondShadowRadius, "styleable", "OShadowLayout_oui_secondShadowRadius"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_secondOffsetX, "styleable", "OShadowLayout_oui_secondOffsetX"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_secondOffsetY, "styleable", "OShadowLayout_oui_secondOffsetY"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_secondShadowSpread, "styleable", "OShadowLayout_oui_secondShadowSpread")));
    L15:
        this.shadowCornerRadius = r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_shadowCornerRadius, "styleable", "OShadowLayout_oui_shadowCornerRadius"), 0.0f);
        r16.recycle();
        setWillNotDraw(false);
        updatePadding();
        return;
    L5:
        if (r17.length != 0) goto L7;
        boolean r1 = true;
    L9:
        if ((!r1) == false) goto L12;
        j r2 = this.firstShadow;
        b r4 = r17[0];
        o.c(r4, "shadowToken[0]");
        r2.a(r4, r18);
    L12:
        if (r17.length <= 1) goto L15;
        j r3 = this.secondShadow;
        b r19 = r17[1];
        o.c(r19, "shadowToken[1]");
        r3.a(r19, r18);
        goto L15
    L7:
        r1 = false;
        goto L9
    }

    private final void updatePadding() {
        Math.max(Math.abs(this.firstShadow.c()) + Math.abs(this.firstShadow.b()), Math.abs(this.secondShadow.c()) + Math.abs(this.secondShadow.b()));
        Math.max(Math.abs(this.firstShadow.d()) + Math.abs(this.firstShadow.b()), Math.abs(this.secondShadow.d()) + Math.abs(this.secondShadow.b()));
    }

    @Override // android.view.View
    public void onDraw(Canvas r12) {
        o.e(r12, "canvas");
        super.onDraw(r12);
        Path r0 = new Path();
        int r1 = getChildCount();
        int r2 = Integer.MIN_VALUE;
        int r5 = Integer.MAX_VALUE;
        int r6 = 0;
        int r3 = Integer.MIN_VALUE;
        int r4 = Integer.MAX_VALUE;
    L3:
        if (r6 >= r1) goto L5;
        int r7 = r6 + 1;
        View r8 = getChildAt(r6);
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r4 = Math.min(r4, r8.getLeft() - r10.leftMargin);
        r5 = Math.min(r5, r8.getTop() - r10.topMargin);
        r2 = Math.max(r2, r8.getRight() + r10.rightMargin);
        r3 = Math.max(r3, r8.getBottom() + r10.bottomMargin);
        r6 = r7;
        goto L3
    L5:
        RectF r11 = new RectF(r4, r5, r2, r3);
        float r13 = this.shadowCornerRadius;
        r0.addRoundRect(r11, r13, r13, Path.Direction.CW);
        RectF r14 = new RectF();
        r0.computeBounds(r14, true);
        drawShadow(r12, r0, r14, this.firstShadow);
        drawShadow(r12, r0, r14, this.secondShadow);
    }

    private final void drawShadow(Canvas r4, Path r5, RectF r6, j r7) {
        int r0 = r4.save();
        RectF r1 = new RectF(r6);
        r1.offset(r7.c(), r7.d());
        r1.inset(-r7.e(), -r7.e());
        r4.clipOutPath(r5);
        float r3 = this.shadowCornerRadius;
        r4.drawRoundRect(r1, r3, r3, r7.f());
        r4.restoreToCount(r0);
    }
}
