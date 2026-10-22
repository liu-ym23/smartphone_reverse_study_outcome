package com.obric.autoaction.app.launcherpage.module.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: StarStripView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StarStripView extends View {
    private final SparseArray<PorterDuffColorFilter> colorFilterCache;
    private Integer maxLines;
    private int maxStarsToDraw;
    private final Paint paint;
    private int rowsToDraw;
    private Bitmap starBitmap;
    private final int starSize;
    private final int starSpacing;
    private List<d> stars;
    private int starsPerRow;

    public StarStripView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public StarStripView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ StarStripView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public StarStripView(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        super(r8, r9, r7);
        int r10 = d.i.a.a(TypedValue.applyDimension(1, 14, Resources.getSystem().getDisplayMetrics()));
        this.starSize = r10;
        this.starSpacing = d.i.a.a(TypedValue.applyDimension(1, 2, Resources.getSystem().getDisplayMetrics()));
        this.stars = p.b();
        this.paint = new Paint(1);
        this.starsPerRow = 1;
        this.rowsToDraw = 1;
        Drawable r11 = androidx.appcompat.a.a.a.b(r8, ZeusTransformUtils.mapRes(R.drawable.ic_star, "drawable", "ic_star"));
        int r12 = 0;
        if (r11 == null) goto L6;
        Bitmap r13 = Bitmap.createBitmap(r10, r10, Bitmap.Config.ARGB_8888);
        o.c(r13, "createBitmap(...)");
        Canvas r0 = new Canvas(r13);
        r11.setBounds(0, 0, r0.getWidth(), r0.getHeight());
        r11.draw(r0);
        this.starBitmap = r13;
    L6:
        if (isInEditMode() == false) goto L11;
        ArrayList r14 = new ArrayList(20);
    L8:
        if (r12 >= 20) goto L10;
        r14.add(d.f24290a.a());
        r12 = r12 + 1;
        goto L8
    L10:
        updateStars((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin"));
    L11:
        this.colorFilterCache = new SparseArray();
    }

    public final Integer getMaxLines() {
        return this.maxLines;
    }

    public final void setMaxLines(Integer r1) {
        this.maxLines = r1;
        requestLayout();
        invalidate();
    }

    public final void updateStars(List<d> r3) {
        List<d> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "stars");
        this.stars = r4;
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public void onMeasure(int r7, int r8) {
        int r0 = (View.MeasureSpec.getSize(r7) - getPaddingLeft()) - getPaddingRight();
        int r1 = this.starSize + this.starSpacing;
        if (r1 > 0) goto L5;
        int r2 = 1;
    L6:
        this.starsPerRow = r2;
        int r3 = ((this.stars.size() - 1) / this.starsPerRow) + 1;
        Integer r4 = this.maxLines;
        if (r4 == null) goto L9;
        r3 = Math.min(r3, ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue());
    L9:
        this.rowsToDraw = r3;
        Integer r5 = this.maxLines;
        if (r5 == null) goto L12;
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue() * this.starsPerRow;
    L13:
        this.maxStarsToDraw = r6;
        int r9 = (r0 + getPaddingLeft()) + getPaddingRight();
        int r10 = this.rowsToDraw;
        setMeasuredDimension(View.resolveSize(r9, r7), View.resolveSize((((this.starSize * r10) + ((r10 - 1) * this.starSpacing)) + getPaddingTop()) + getPaddingBottom(), r8));
        return;
    L12:
        r6 = this.stars.size();
        goto L13
    L5:
        r2 = Math.max(1, r0 / r1);
        goto L6
    }

    @Override // android.view.View
    public void onDraw(Canvas r20) {
        o.e(r20, "canvas");
        super.onDraw(r20);
        Bitmap r2 = this.starBitmap;
        if (r2 != null) goto L5;
        return;
    L5:
        int r3 = this.starSize + this.starSpacing;
        int r4 = Math.min(this.stars.size(), this.maxStarsToDraw);
        int r5 = this.rowsToDraw;
        int r7 = 0;
        int r8 = 0;
    L6:
        if (r7 >= r5) goto L24;
        boolean r10 = true;
        if (r7 == (this.rowsToDraw - 1)) goto L11;
        r10 = false;
    L11:
        if (r10 == false) goto L13;
        int r9 = r4 - (this.starsPerRow * r7);
    L14:
        int r11 = this.starsPerRow;
        int r12 = 0;
    L15:
        if (r12 >= r11) goto L23;
        if (r12 < r9) goto L19;
    L21:
        int r14 = r8;
        d r13 = d.f24290a.a();
    L22:
        int r15 = getPaddingLeft() + (r12 * r3);
        int r16 = getPaddingTop() + (r7 * r3);
        r20.save();
        float r17 = r15;
        int r6 = this.starSize;
        float r18 = r16;
        int r19 = r4;
        r20.rotate(r13.c(), (r6 / 2.0f) + r17, (r6 / 2.0f) + r18);
        this.paint.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(getColorFilter(r13), ColorFilter.class, "com.obric.aiagent.plugin"));
        r20.drawBitmap(r2, r17, r18, this.paint);
        r20.restore();
        r12 = r12 + 1;
        r8 = r14;
        r3 = r3;
        r4 = r19;
        goto L15
    L19:
        if (r8 >= this.stars.size()) goto L21;
        r14 = r8 + 1;
        r13 = (d) ZeusTransformUtils.preCheckCast(this.stars.get(r8), d.class, "com.obric.aiagent.plugin");
        goto L22
    L23:
        r7 = r7 + 1;
        goto L6
    L13:
        r9 = this.starsPerRow;
        goto L14
    }

    private final PorterDuffColorFilter getColorFilter(d r5) {
        int r0 = r5.hashCode();
        PorterDuffColorFilter r1 = (PorterDuffColorFilter) ZeusTransformUtils.preCheckCast(this.colorFilterCache.get(r0), PorterDuffColorFilter.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        PorterDuffColorFilter r2 = new PorterDuffColorFilter(getColor(r5.a(), r5.b()), PorterDuff.Mode.SRC_IN);
        this.colorFilterCache.put(r0, r2);
        return r2;
    }

    static /* synthetic */ int getColor$default(StarStripView r0, int r1, Float r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getColor(r1, r2);
    }

    private final int getColor(int r3, Float r4) {
        int r2 = androidx.core.content.b.h.b(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin"), r3, null);
        if (r4 != null) goto L6;
        return r2;
    L6:
        return Color.argb((int) (r4.floatValue() * 255), Color.red(r2), Color.green(r2), Color.blue(r2));
    }
}
