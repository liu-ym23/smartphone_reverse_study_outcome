package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public class LivingView extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f112384c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f112385d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f112386e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f112387f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f112388g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f112389h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f112390i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f112391j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f112392k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f112393l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f112394m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f112395n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f112396o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f112397p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f112398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RotateHeadView f112399b;

    static {
        f112384c = com.bytedance.android.live.core.utils.s1.f(32.0f);
        f112385d = com.bytedance.android.live.core.utils.s1.f(40.0f);
        f112386e = com.bytedance.android.live.core.utils.s1.f(48.0f);
        f112387f = com.bytedance.android.live.core.utils.s1.f(56.0f);
        f112388g = com.bytedance.android.live.core.utils.s1.f(68.0f);
        f112389h = com.bytedance.android.live.core.utils.s1.f(72.0f);
        f112390i = com.bytedance.android.live.core.utils.s1.f(80.0f);
        f112391j = com.bytedance.android.live.core.utils.s1.f(13.0f);
        f112392k = com.bytedance.android.live.core.utils.s1.f(33.0f);
        f112393l = com.bytedance.android.live.core.utils.s1.f(14.0f);
        f112394m = com.bytedance.android.live.core.utils.s1.f(50.0f);
        f112395n = com.bytedance.android.live.core.utils.s1.f(20.0f);
        f112396o = com.bytedance.android.live.core.utils.s1.f(49.5f);
        f112397p = com.bytedance.android.live.core.utils.s1.f(21.0f);
    }

    public LivingView(Context r100) {
        this(r100, null);
    }

    public LivingView(Context r100, AttributeSet r101) {
        this(r100, r101, -1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        this.f112398a.setTextColor(com.bytedance.android.live.core.utils.s1.h(R.color.ttlive_hs_s13));
        this.f112398a.setBackgroundResource(R.drawable.ttlive_bg_profile_head_living);
        this.f112398a.setText(R.string.ttlive_core_is_living_head);
        this.f112398a.setGravity(17);
        ViewGroup.LayoutParams r102 = getLayoutParams();
        int r103 = r102.width;
        int r104 = r102.height;
        float r105 = 8.0f;
        if (r103 != f112384c) goto L6;
        int r106 = com.bytedance.android.live.core.utils.s1.f(5.0f);
        int r107 = r103 - (r106 * 2);
        int r108 = f112391j;
    L25:
        this.f112399b.getLayoutParams().width = r103;
        this.f112399b.getLayoutParams().height = r104;
        this.f112398a.setTextSize(1, r105);
        this.f112398a.getLayoutParams().width = r107;
        this.f112398a.getLayoutParams().height = r108;
        if ((this.f112398a.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L28;
        int r109 = r104 - r108;
        ((FrameLayout.LayoutParams) this.f112398a.getLayoutParams()).topMargin = r109;
        ((FrameLayout.LayoutParams) this.f112398a.getLayoutParams()).leftMargin = r106;
        ((FrameLayout.LayoutParams) this.f112398a.getLayoutParams()).rightMargin = r106;
    L28:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r103, 1073741824), View.MeasureSpec.makeMeasureSpec(r104, 1073741824));
        return;
    L6:
        if (r103 != f112385d) goto L10;
        int r110 = f112392k;
        r108 = f112393l;
        int r111 = (r103 - r110) / 2;
    L8:
        r107 = r110;
        r106 = r111;
        r105 = 9.0f;
        goto L25
    L10:
        if (r103 != f112386e) goto L13;
        r106 = com.bytedance.android.live.core.utils.s1.f(8.0f);
        int r112 = com.bytedance.android.live.core.utils.s1.f(6.0f);
        r108 = com.bytedance.android.live.core.utils.s1.f(10.0f) + r112;
        r107 = r103 - (r106 * 2);
        r105 = 10.0f;
        goto L25
    L13:
        if (r103 != f112387f) goto L15;
        r110 = f112392k;
        r108 = f112393l;
        r111 = (r103 - r110) / 2;
        goto L8
    L15:
        r108 = 0;
        if (r103 != f112388g) goto L20;
        r103 = r103 + com.bytedance.android.live.core.utils.s1.f(8.0f);
        r104 = r104 + com.bytedance.android.live.core.utils.s1.f(8.0f);
    L18:
        r106 = 0;
        r105 = 0.0f;
        r107 = 0;
        goto L25
    L20:
        if (r103 != f112389h) goto L23;
        r107 = f112394m;
        r108 = f112395n;
        r106 = (r103 - r107) / 2;
        r105 = 12.0f;
        goto L25
    L23:
        if (r103 != f112390i) goto L18;
        r103 = r103 + com.bytedance.android.live.core.utils.s1.f(8.0f);
        r104 = r104 + com.bytedance.android.live.core.utils.s1.f(8.0f);
        r107 = f112396o;
        r108 = f112397p;
        r106 = (r103 - r107) / 2;
        r105 = 13.5f;
        goto L25
    }

    public LivingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f112398a = new TextView(r100);
        RotateHeadView r103 = new RotateHeadView(r100);
        this.f112399b = r103;
        addView(r103);
        addView(this.f112398a);
        this.f112398a.setVisibility(8);
        this.f112399b.setVisibility(8);
    }
}
