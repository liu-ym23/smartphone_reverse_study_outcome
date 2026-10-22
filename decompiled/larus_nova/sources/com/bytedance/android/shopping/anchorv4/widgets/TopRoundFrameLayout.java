package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.bytedance.android.shopping.anchorv3.compat.UserInteractFrameLayout;
import com.bytedance.android.shopping.anchorv4.components.TopGuideGaussComponent;
import com.larus.nova.R;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes13.dex */
public class TopRoundFrameLayout extends UserInteractFrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f170171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f170172d;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TopRoundFrameLayout f170173a;

        public a(TopRoundFrameLayout r100) {
            this.f170173a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            r101.setRoundRect(0, 0, this.f170173a.getWidth(), this.f170173a.getHeight(), this.f170173a.f170171c);
        }
    }

    public float getRadius() {
        return this.f170171c;
    }

    public TopRoundFrameLayout(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.android.shopping.anchorv3.compat.UserInteractFrameLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        int r101 = this.f170171c;
        super.dispatchDraw(r100);
    }

    public void setBorderRadius(int r100) {
        this.f170171c = r100;
        a(getWidth(), getHeight());
        invalidate();
    }

    public TopRoundFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void a(int r100, int r101) {
        Lazy r102 = TopGuideGaussComponent.f166030e;
        if (TopGuideGaussComponent.a.a() == false) goto L6;
        setOutlineProvider(new a(this));
        setClipToOutline(true);
    L9:
        d r103 = this.f170172d;
        if (r103 == null) goto L13;
        r103.update(this.f170171c, r100, r101);
        return;
    L13:
        return;
    L6:
        if (this.f170172d != null) goto L8;
        this.f170172d = new d();
    L8:
        setClipToOutline(true);
        this.f170172d.update(this.f170171c, r100, r101);
        setOutlineProvider(this.f170172d);
        goto L9
    }

    public TopRoundFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f170171c = 0;
        this.f170172d = null;
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.left_rounded_radius, R.attr.rounded_radius}, r102, 0);
        if (r103.hasValue(1) == false) goto L5;
        this.f170171c = r103.getDimensionPixelOffset(1, 0);
    L5:
        r103.recycle();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = this.f170171c;
        a(r100, r101);
    }
}
