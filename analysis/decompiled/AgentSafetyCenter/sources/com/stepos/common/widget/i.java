package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.stepos.agentsafetycenter.R;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f2699a;

    /* renamed from: b, reason: collision with root package name */
    public float f2700b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2701c;

    /* renamed from: e, reason: collision with root package name */
    public int f2703e;

    /* renamed from: f, reason: collision with root package name */
    public int f2704f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2705g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f2706h;
    public final TextPaint i;

    /* renamed from: j, reason: collision with root package name */
    public int f2707j;

    /* renamed from: k, reason: collision with root package name */
    public int f2708k;

    /* renamed from: l, reason: collision with root package name */
    public int f2709l;

    /* renamed from: m, reason: collision with root package name */
    public int f2710m;

    /* renamed from: n, reason: collision with root package name */
    public final int f2711n;

    /* renamed from: o, reason: collision with root package name */
    public final int f2712o;

    /* renamed from: p, reason: collision with root package name */
    public int f2713p;

    /* renamed from: q, reason: collision with root package name */
    public final RectF f2714q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f2715r;

    /* renamed from: t, reason: collision with root package name */
    public String f2717t;

    /* renamed from: u, reason: collision with root package name */
    public final Context f2718u;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2702d = false;

    /* renamed from: s, reason: collision with root package name */
    public int f2716s = 0;

    public i(Context context) {
        this.f2718u = context;
        this.f2711n = (int) context.getResources().getDimension(R.dimen.mc_new_message_view_layout_max_width);
        this.f2712o = (int) context.getResources().getDimension(R.dimen.mc_new_message_view_layout_max_height);
        Resources resources = context.getResources();
        this.f2699a = context.getResources().getColor(R.color.fd_sys_color_on_error_default);
        this.f2700b = 10.0f;
        this.f2705g = resources.getDimensionPixelSize(R.dimen.fd_sys_radius_corner_smooth_extra_mini);
        int iJ = t1.e.j(R.attr.colorError, context);
        this.f2701c = context.getResources().getColor(iJ == 0 ? R.color.fd_sys_color_error_default : iJ);
        this.f2703e = context.getResources().getColor(R.color.fd_sys_color_on_error_default);
        this.f2704f = resources.getDimensionPixelSize(R.dimen.mc_new_message_view_border_width);
        this.f2713p = resources.getDimensionPixelSize(R.dimen.mc_new_message_view_space_large);
        Paint paint = new Paint();
        this.f2706h = paint;
        paint.setAntiAlias(true);
        this.f2706h.setColor(this.f2701c);
        Paint paint2 = this.f2706h;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        TextPaint textPaint = new TextPaint();
        this.i = textPaint;
        textPaint.setAntiAlias(true);
        this.i.setStyle(style);
        this.i.setTextAlign(Paint.Align.CENTER);
        this.i.setTypeface(Typeface.create("SFPRO-bold", 0));
        this.f2715r = new Rect();
        this.f2714q = new RectF();
    }
}
