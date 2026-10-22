package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final int f3816a;
    public float b;
    public final int c;
    public int e;
    public int f;
    public final int g;
    public final Paint h;
    public final TextPaint i;

    /* renamed from: j, reason: collision with root package name */
    public int f3817j;
    public int k;
    public int l;
    public int m;
    public final int n;
    public final int o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public final RectF f3818q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f3819r;

    /* renamed from: t, reason: collision with root package name */
    public String f3821t;
    public final Context u;
    public boolean d = false;

    /* renamed from: s, reason: collision with root package name */
    public int f3820s = 0;

    public x(Context context) {
        this.u = context;
        this.n = (int) context.getResources().getDimension(R.dimen.mc_new_message_view_layout_max_width);
        this.o = (int) context.getResources().getDimension(R.dimen.mc_new_message_view_layout_max_height);
        Resources resources = context.getResources();
        this.f3816a = context.getResources().getColor(R.color.fd_sys_color_on_error_default);
        this.b = 10.0f;
        this.g = resources.getDimensionPixelSize(R.dimen.fd_sys_radius_corner_smooth_extra_mini);
        int iE = a5.l.e(R.attr.colorError, context);
        this.c = context.getResources().getColor(iE == 0 ? R.color.fd_sys_color_error_default : iE);
        this.e = context.getResources().getColor(R.color.fd_sys_color_on_error_default);
        this.f = resources.getDimensionPixelSize(R.dimen.mc_new_message_view_border_width);
        this.p = resources.getDimensionPixelSize(R.dimen.mc_new_message_view_space_large);
        Paint paint = new Paint();
        this.h = paint;
        paint.setAntiAlias(true);
        this.h.setColor(this.c);
        Paint paint2 = this.h;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        TextPaint textPaint = new TextPaint();
        this.i = textPaint;
        textPaint.setAntiAlias(true);
        this.i.setStyle(style);
        this.i.setTextAlign(Paint.Align.CENTER);
        this.i.setTypeface(Typeface.create("SFPRO-bold", 0));
        this.f3819r = new Rect();
        this.f3818q = new RectF();
    }

    public final void a() {
        int iC;
        int i;
        if (this.f3820s != 1 || this.f3821t == null) {
            iC = (this.d ? this.g + this.f : this.g) * 2;
            i = iC;
        } else {
            float f = this.b;
            Context context = this.u;
            this.i.setTextSize((int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f));
            this.i.setColor(this.f3816a);
            String str = this.f3821t;
            this.i.getTextBounds(str, 0, str.length(), this.f3819r);
            this.l = this.f3819r.width() + (this.p * 2);
            iC = (int) a5.l.c(18.0f, context);
            this.m = iC;
            if (this.l < iC) {
                this.l = iC;
            }
            if (this.d) {
                int i6 = this.l;
                int i10 = this.f;
                i = (i10 * 2) + i6;
                iC += i10 * 2;
            } else {
                i = this.l;
            }
        }
        this.f3817j = i;
        this.k = iC;
    }
}
