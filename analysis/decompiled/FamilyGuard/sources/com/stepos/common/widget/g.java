package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private int f14407a;

    /* renamed from: b, reason: collision with root package name */
    private float f14408b;

    /* renamed from: c, reason: collision with root package name */
    private int f14409c;

    /* renamed from: e, reason: collision with root package name */
    private int f14411e;

    /* renamed from: f, reason: collision with root package name */
    private int f14412f;

    /* renamed from: g, reason: collision with root package name */
    private int f14413g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f14414h;

    /* renamed from: i, reason: collision with root package name */
    private TextPaint f14415i;

    /* renamed from: j, reason: collision with root package name */
    private int f14416j;

    /* renamed from: k, reason: collision with root package name */
    private int f14417k;

    /* renamed from: l, reason: collision with root package name */
    private int f14418l;

    /* renamed from: m, reason: collision with root package name */
    private int f14419m;

    /* renamed from: n, reason: collision with root package name */
    private int f14420n;

    /* renamed from: o, reason: collision with root package name */
    private int f14421o;

    /* renamed from: p, reason: collision with root package name */
    private int f14422p;

    /* renamed from: q, reason: collision with root package name */
    private RectF f14423q;

    /* renamed from: r, reason: collision with root package name */
    private Rect f14424r;

    /* renamed from: t, reason: collision with root package name */
    private String f14426t;

    /* renamed from: u, reason: collision with root package name */
    private Context f14427u;

    /* renamed from: d, reason: collision with root package name */
    private boolean f14410d = false;

    /* renamed from: s, reason: collision with root package name */
    private int f14425s = 0;

    public g(Context context) {
        this.f14427u = context;
        j(context);
    }

    private void j(Context context) {
        this.f14420n = (int) context.getResources().getDimension(H1.f.f2163y);
        this.f14421o = (int) context.getResources().getDimension(H1.f.f2162x);
        k(context);
        n();
        m();
        l();
    }

    private void k(Context context) {
        Resources resources = context.getResources();
        Resources resources2 = context.getResources();
        int i5 = H1.e.f2080b;
        this.f14407a = resources2.getColor(i5);
        this.f14408b = 10.0f;
        this.f14413g = resources.getDimensionPixelSize(H1.f.f2137d);
        int iD = N1.i.d(H1.c.f2065l, context);
        if (iD == 0) {
            iD = H1.e.f2079a;
        }
        this.f14409c = context.getResources().getColor(iD);
        this.f14411e = context.getResources().getColor(i5);
        this.f14412f = resources.getDimensionPixelSize(H1.f.f2161w);
        this.f14422p = resources.getDimensionPixelSize(H1.f.f2105A);
    }

    private void l() {
        this.f14423q = new RectF();
    }

    private void m() {
        TextPaint textPaint = new TextPaint();
        this.f14415i = textPaint;
        textPaint.setAntiAlias(true);
        this.f14415i.setStyle(Paint.Style.FILL);
        this.f14415i.setTextAlign(Paint.Align.CENTER);
        this.f14415i.setTypeface(Typeface.create("SFPRO-bold", 0));
        this.f14424r = new Rect();
    }

    private void n() {
        Paint paint = new Paint();
        this.f14414h = paint;
        paint.setAntiAlias(true);
        this.f14414h.setColor(this.f14409c);
        this.f14414h.setStyle(Paint.Style.FILL);
    }

    private void w(float f5, float f6, float f7, float f8) {
        RectF rectF = this.f14423q;
        rectF.left = f5;
        rectF.top = f6;
        rectF.right = f7;
        rectF.bottom = f8;
    }

    public void a(Canvas canvas) {
        if (this.f14410d && this.f14412f > 0) {
            this.f14414h.setColor(this.f14411e);
            if (this.f14425s == 1) {
                float f5 = this.f14416j;
                int i5 = this.f14417k;
                float f6 = i5;
                float f7 = i5 >> 1;
                w(0.0f, 0.0f, f5, f6);
                canvas.drawRoundRect(this.f14423q, f7, f7, this.f14414h);
            } else {
                canvas.drawCircle(this.f14416j / 2, this.f14417k / 2, this.f14413g + this.f14412f, this.f14414h);
            }
        }
        this.f14414h.setColor(this.f14409c);
        if (this.f14425s != 1) {
            canvas.drawCircle(this.f14416j / 2, this.f14417k / 2, this.f14413g, this.f14414h);
            return;
        }
        int i6 = this.f14412f;
        w(i6, i6, this.f14416j - i6, this.f14417k - i6);
        float f8 = this.f14419m >> 1;
        canvas.drawRoundRect(this.f14423q, f8, f8, this.f14414h);
        String str = this.f14426t;
        if (str != null) {
            if (this.f14410d) {
                canvas.drawText(str, this.f14416j / 2, ((this.f14417k - this.f14412f) - ((this.f14419m - this.f14424r.height()) / 2)) - 1, this.f14415i);
            } else {
                canvas.drawText(str, this.f14416j / 2, (this.f14417k - ((this.f14419m - this.f14424r.height()) / 2)) - 1, this.f14415i);
            }
        }
    }

    public int b() {
        return this.f14412f;
    }

    public int c() {
        return this.f14417k;
    }

    public Integer d() {
        String str = this.f14426t;
        if (str == null) {
            return 0;
        }
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public int e() {
        return this.f14425s;
    }

    public String f() {
        return this.f14426t;
    }

    public int g() {
        return this.f14421o;
    }

    public int h() {
        return this.f14420n;
    }

    public int i() {
        return this.f14416j;
    }

    public void o() {
        int iA;
        int i5;
        if (this.f14425s != 1 || this.f14426t == null) {
            iA = (this.f14410d ? this.f14413g + this.f14412f : this.f14413g) * 2;
            i5 = iA;
        } else {
            this.f14415i.setTextSize(N1.i.k(this.f14408b, this.f14427u));
            this.f14415i.setColor(this.f14407a);
            TextPaint textPaint = this.f14415i;
            String str = this.f14426t;
            textPaint.getTextBounds(str, 0, str.length(), this.f14424r);
            this.f14418l = this.f14424r.width() + (this.f14422p * 2);
            iA = (int) N1.i.a(18.0f, this.f14427u);
            this.f14419m = iA;
            if (this.f14418l < iA) {
                this.f14418l = iA;
            }
            if (this.f14410d) {
                int i6 = this.f14418l;
                int i7 = this.f14412f;
                i5 = i6 + (i7 * 2);
                iA += i7 * 2;
            } else {
                i5 = this.f14418l;
            }
        }
        this.f14416j = i5;
        this.f14417k = iA;
    }

    public void p(int i5) {
        this.f14414h.setAlpha(i5);
        this.f14415i.setAlpha(i5);
    }

    public void q(int i5) {
        this.f14414h.setColor(i5);
    }

    public void r(int i5) {
        this.f14411e = i5;
    }

    public void s(int i5) {
        this.f14412f = i5;
    }

    public void t(int i5) {
        this.f14425s = i5;
    }

    public void u(int i5) {
        this.f14425s = 1;
        if (i5 >= 999) {
            i5 = 999;
        } else if (i5 <= 0) {
            i5 = 0;
        }
        y(String.valueOf(i5));
    }

    public void v(int i5) {
        this.f14422p = i5;
    }

    public void x(boolean z5) {
        this.f14410d = z5;
    }

    public void y(String str) {
        this.f14426t = str;
    }

    public void z(float f5) {
        this.f14408b = f5;
    }
}
