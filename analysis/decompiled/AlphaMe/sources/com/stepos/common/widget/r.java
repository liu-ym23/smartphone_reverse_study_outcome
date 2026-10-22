package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final int f11944a;

    /* renamed from: b, reason: collision with root package name */
    public float f11945b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11946c;

    /* renamed from: e, reason: collision with root package name */
    public int f11948e;

    /* renamed from: f, reason: collision with root package name */
    public int f11949f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11950g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f11951h;

    /* renamed from: i, reason: collision with root package name */
    public final TextPaint f11952i;

    /* renamed from: j, reason: collision with root package name */
    public int f11953j;

    /* renamed from: k, reason: collision with root package name */
    public int f11954k;

    /* renamed from: l, reason: collision with root package name */
    public int f11955l;

    /* renamed from: m, reason: collision with root package name */
    public int f11956m;

    /* renamed from: n, reason: collision with root package name */
    public final int f11957n;

    /* renamed from: o, reason: collision with root package name */
    public final int f11958o;

    /* renamed from: p, reason: collision with root package name */
    public int f11959p;

    /* renamed from: q, reason: collision with root package name */
    public final RectF f11960q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f11961r;

    /* renamed from: t, reason: collision with root package name */
    public String f11963t;

    /* renamed from: u, reason: collision with root package name */
    public final Context f11964u;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11947d = false;

    /* renamed from: s, reason: collision with root package name */
    public int f11962s = 0;

    public r(Context context) {
        this.f11964u = context;
        this.f11957n = (int) context.getResources().getDimension(R.dimen.mc_new_message_view_layout_max_width);
        this.f11958o = (int) context.getResources().getDimension(R.dimen.mc_new_message_view_layout_max_height);
        Resources resources = context.getResources();
        this.f11944a = context.getResources().getColor(R.color.fd_sys_color_on_error_default);
        this.f11945b = 10.0f;
        this.f11950g = resources.getDimensionPixelSize(R.dimen.fd_sys_radius_corner_smooth_extra_mini);
        int iF = m2.o.f(R.attr.colorError, context);
        this.f11946c = context.getResources().getColor(iF == 0 ? R.color.fd_sys_color_error_default : iF);
        this.f11948e = context.getResources().getColor(R.color.fd_sys_color_on_error_default);
        this.f11949f = resources.getDimensionPixelSize(R.dimen.mc_new_message_view_border_width);
        this.f11959p = resources.getDimensionPixelSize(R.dimen.mc_new_message_view_space_large);
        Paint paint = new Paint();
        this.f11951h = paint;
        paint.setAntiAlias(true);
        this.f11951h.setColor(this.f11946c);
        Paint paint2 = this.f11951h;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        TextPaint textPaint = new TextPaint();
        this.f11952i = textPaint;
        textPaint.setAntiAlias(true);
        this.f11952i.setStyle(style);
        this.f11952i.setTextAlign(Paint.Align.CENTER);
        this.f11952i.setTypeface(Typeface.create("SFPRO-bold", 0));
        this.f11961r = new Rect();
        this.f11960q = new RectF();
    }

    public final void a(Canvas canvas) {
        if (this.f11947d && this.f11949f > 0) {
            this.f11951h.setColor(this.f11948e);
            if (this.f11962s == 1) {
                float f4 = this.f11953j;
                int i4 = this.f11954k;
                float f5 = i4;
                float f6 = i4 >> 1;
                RectF rectF = this.f11960q;
                rectF.left = Property.DEFAULT_FLOAT_VALUE;
                rectF.top = Property.DEFAULT_FLOAT_VALUE;
                rectF.right = f4;
                rectF.bottom = f5;
                canvas.drawRoundRect(rectF, f6, f6, this.f11951h);
            } else {
                canvas.drawCircle(this.f11953j / 2, this.f11954k / 2, this.f11950g + this.f11949f, this.f11951h);
            }
        }
        this.f11951h.setColor(this.f11946c);
        if (this.f11962s != 1) {
            canvas.drawCircle(this.f11953j / 2, this.f11954k / 2, this.f11950g, this.f11951h);
            return;
        }
        int i5 = this.f11949f;
        float f7 = i5;
        float f8 = this.f11953j - i5;
        float f9 = this.f11954k - i5;
        RectF rectF2 = this.f11960q;
        rectF2.left = f7;
        rectF2.top = f7;
        rectF2.right = f8;
        rectF2.bottom = f9;
        float f10 = this.f11956m >> 1;
        canvas.drawRoundRect(rectF2, f10, f10, this.f11951h);
        String str = this.f11963t;
        if (str != null) {
            if (this.f11947d) {
                canvas.drawText(str, this.f11953j / 2, ((this.f11954k - this.f11949f) - ((this.f11956m - this.f11961r.height()) / 2)) - 1, this.f11952i);
            } else {
                canvas.drawText(str, this.f11953j / 2, (this.f11954k - ((this.f11956m - this.f11961r.height()) / 2)) - 1, this.f11952i);
            }
        }
    }

    public final void b() {
        int iC;
        int i4;
        if (this.f11962s != 1 || this.f11963t == null) {
            iC = (this.f11947d ? this.f11950g + this.f11949f : this.f11950g) * 2;
            i4 = iC;
        } else {
            TextPaint textPaint = this.f11952i;
            float f4 = this.f11945b;
            Context context = this.f11964u;
            textPaint.setTextSize((int) ((f4 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f));
            this.f11952i.setColor(this.f11944a);
            TextPaint textPaint2 = this.f11952i;
            String str = this.f11963t;
            textPaint2.getTextBounds(str, 0, str.length(), this.f11961r);
            this.f11955l = this.f11961r.width() + (this.f11959p * 2);
            iC = (int) m2.o.c(context, 18.0f);
            this.f11956m = iC;
            if (this.f11955l < iC) {
                this.f11955l = iC;
            }
            if (this.f11947d) {
                int i5 = this.f11955l;
                int i6 = this.f11949f;
                i4 = (i6 * 2) + i5;
                iC += i6 * 2;
            } else {
                i4 = this.f11955l;
            }
        }
        this.f11953j = i4;
        this.f11954k = iC;
    }
}
