package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.base.utils.CJPayLargeScreenUtils;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.m0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends LinearLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f169471e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f169472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f169473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f169474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f169475d;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f169476c;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
        public final boolean a(int r100) {
            return this.f169476c.f169475d.wW("bottom_left_find_same", Integer.valueOf(r100));
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
        public final void b(RectF r100) {
            boolean r101 = false;
            if (r100 == null) goto L8;
            c r102 = this.f169476c;
            r102.f169474c = true;
            int r103 = r102.getChildCount();
            int r104 = 0;
        L5:
            if (r104 >= r103) goto L7;
            r102.getChildAt(r104).setAlpha(1.0f);
            r104 = r104 + 1;
            goto L5
        L7:
            this.f169476c.invalidate();
        L8:
            if (r100 != null) goto L10;
            return;
        L10:
            if (r100.height() <= 0) goto L12;
            r101 = true;
        L12:
            if (r101 == true) goto L15;
            r100 = null;
        L15:
            if (r100 == null) goto L20;
            this.f169476c.setTranslationY(Float.valueOf((r100.bottom - c.f169471e) - com.bytedance.android.shopping.extensions.b.a(12)).floatValue());
            return;
        }

        public b(c r100, View r101, m0 r102) {
            this.f169476c = r100;
            super(r101, r102);
        }
    }

    static {
        f169471e = com.bytedance.android.shopping.extensions.b.a(20);
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b getLayerItem() {
        return new b(this, this, new m0(true, true, true, 1, false, 48));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f169474c == false) goto L5;
        this.f169472a.setColor(CJPayLargeScreenUtils.LARGE_SCREEN_MASK_COLOR);
        float r101 = getHeight() / 2.0f;
        float r102 = q.a(Double.valueOf(0.5d));
        this.f169472a.setStyle(Paint.Style.FILL);
        this.f169473b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f169473b.inset(r102, r102);
        r100.drawRoundRect(this.f169473b, r101, r101, this.f169472a);
        this.f169473b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f169472a.setStrokeWidth(r102);
        this.f169472a.setStyle(Paint.Style.STROKE);
        this.f169472a.setColor(536870911);
        r100.drawRoundRect(this.f169473b, r101, r101, this.f169472a);
    L5:
        super.dispatchDraw(r100);
    }

    public c(FragmentActivity r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f169475d = r101;
        Paint r102 = new Paint(1);
        r102.setColor(CJPayLargeScreenUtils.LARGE_SCREEN_MASK_COLOR);
        r102.setStyle(Paint.Style.FILL);
        Unit r103 = Unit.INSTANCE;
        this.f169472a = r102;
        this.f169473b = new RectF();
        int r104 = 0;
        setOrientation(0);
        setGravity(17);
        int r105 = com.bytedance.android.shopping.extensions.b.a(10);
        setPadding(r105, 0, r105, 0);
        ImageView r106 = new ImageView(r100);
        r106.setImageResource(R.drawable.anchor_v4_gallery_find_similar);
        addView(r106, new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.a(12), com.bytedance.android.shopping.extensions.b.a(12)));
        TextView r107 = new TextView(r100);
        r107.setText("找同款");
        r107.setTextColor(-1);
        r107.setTextSize(1, 10.0f);
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-2, -2);
        r108.leftMargin = com.bytedance.android.shopping.extensions.b.a(2);
        addView(r107, r108);
        if (this.f169474c == false) goto L5;
        float r109 = 1.0f;
    L6:
        int r110 = getChildCount();
    L7:
        if (r104 >= r110) goto L9;
        getChildAt(r104).setAlpha(r109);
        r104 = r104 + 1;
        goto L7
    L9:
        return;
    L5:
        r109 = 0.0f;
        goto L6
    }
}
