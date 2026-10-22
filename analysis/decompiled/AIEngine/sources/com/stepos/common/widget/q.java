package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final int f7175a;

    /* renamed from: b, reason: collision with root package name */
    public float f7176b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7177c;

    /* renamed from: e, reason: collision with root package name */
    public int f7179e;

    /* renamed from: f, reason: collision with root package name */
    public int f7180f;

    /* renamed from: g, reason: collision with root package name */
    public final int f7181g;
    public final Paint h;

    /* renamed from: i, reason: collision with root package name */
    public final TextPaint f7182i;

    /* renamed from: j, reason: collision with root package name */
    public int f7183j;

    /* renamed from: k, reason: collision with root package name */
    public int f7184k;

    /* renamed from: l, reason: collision with root package name */
    public int f7185l;

    /* renamed from: m, reason: collision with root package name */
    public int f7186m;

    /* renamed from: n, reason: collision with root package name */
    public final int f7187n;

    /* renamed from: o, reason: collision with root package name */
    public final int f7188o;

    /* renamed from: p, reason: collision with root package name */
    public int f7189p;

    /* renamed from: q, reason: collision with root package name */
    public final RectF f7190q;
    public final Rect r;

    /* renamed from: t, reason: collision with root package name */
    public String f7192t;

    /* renamed from: u, reason: collision with root package name */
    public final Context f7193u;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7178d = false;

    /* renamed from: s, reason: collision with root package name */
    public int f7191s = 0;

    public q(Context context) {
        this.f7193u = context;
        this.f7187n = (int) context.getResources().getDimension(R.dimen.mc_new_message_view_layout_max_width);
        this.f7188o = (int) context.getResources().getDimension(R.dimen.mc_new_message_view_layout_max_height);
        Resources resources = context.getResources();
        this.f7175a = context.getResources().getColor(R.color.fd_sys_color_on_error_default);
        this.f7176b = 10.0f;
        this.f7181g = resources.getDimensionPixelSize(R.dimen.fd_sys_radius_corner_smooth_extra_mini);
        int iB = l8.f.b(R.attr.colorError, context);
        this.f7177c = context.getResources().getColor(iB == 0 ? R.color.fd_sys_color_error_default : iB);
        this.f7179e = context.getResources().getColor(R.color.fd_sys_color_on_error_default);
        this.f7180f = resources.getDimensionPixelSize(R.dimen.mc_new_message_view_border_width);
        this.f7189p = resources.getDimensionPixelSize(R.dimen.mc_new_message_view_space_large);
        Paint paint = new Paint();
        this.h = paint;
        paint.setAntiAlias(true);
        this.h.setColor(this.f7177c);
        Paint paint2 = this.h;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        TextPaint textPaint = new TextPaint();
        this.f7182i = textPaint;
        textPaint.setAntiAlias(true);
        this.f7182i.setStyle(style);
        this.f7182i.setTextAlign(Paint.Align.CENTER);
        this.f7182i.setTypeface(Typeface.create("SFPRO-bold", 0));
        this.r = new Rect();
        this.f7190q = new RectF();
    }

    public final void a() {
        int iA;
        int i10;
        if (this.f7191s != 1 || this.f7192t == null) {
            iA = (this.f7178d ? this.f7181g + this.f7180f : this.f7181g) * 2;
            i10 = iA;
        } else {
            float f8 = this.f7176b;
            Context context = this.f7193u;
            this.f7182i.setTextSize((int) ((f8 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f));
            this.f7182i.setColor(this.f7175a);
            String str = this.f7192t;
            this.f7182i.getTextBounds(str, 0, str.length(), this.r);
            this.f7185l = this.r.width() + (this.f7189p * 2);
            iA = (int) l8.f.a(18.0f, context);
            this.f7186m = iA;
            if (this.f7185l < iA) {
                this.f7185l = iA;
            }
            if (this.f7178d) {
                int i11 = this.f7185l;
                int i12 = this.f7180f * 2;
                i10 = i11 + i12;
                iA += i12;
            } else {
                i10 = this.f7185l;
            }
        }
        this.f7183j = i10;
        this.f7184k = iA;
    }
}
