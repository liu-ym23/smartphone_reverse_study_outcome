package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: classes8.dex */
public class RotateHeadView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f112501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f112502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f112503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f112504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f112505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f112506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f112507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f112508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f112509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f112510j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f112511k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RectF f112512l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f112513m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a f112514n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PathEffect f112515o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f112516p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f112517q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f112518r;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f112519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f112520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RotateHeadView f112521c;

        public a(RotateHeadView r100) {
            this.f112521c = r100;
            a(0);
        }

        public final void a(int r100) {
            RotateHeadView r101 = this.f112521c;
            float r102 = (r101.f112503c - UIUtils.dip2Px(r101.f112507g, 2.0f)) / 2.0f;
            double r103 = (r100 * 3.141592653589793d) / 180.0d;
            this.f112519a = (this.f112521c.f112503c / 2.0f) + (((float) Math.cos(r103)) * r102);
            this.f112520b = (this.f112521c.f112504d / 2.0f) + (((float) Math.sin(r103)) * r102);
        }
    }

    public RotateHeadView(Context r100) {
        super(r100);
        this.f112502b = new Paint();
        this.f112510j = 12;
        a(r100);
    }

    public final void a(Context r100) {
        this.f112507g = r100;
        this.f112505e = 0;
        this.f112506f = 0;
        this.f112512l = new RectF();
        this.f112513m = new a(this);
        this.f112514n = new a(this);
        this.f112515o = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        this.f112516p = UIUtils.dip2Px(this.f112507g, 1.9f);
        this.f112517q = UIUtils.dip2Px(this.f112507g, 2.0f);
        this.f112518r = UIUtils.dip2Px(this.f112507g, 2.0f) / 2.0f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f112501a != null) goto L5;
        Paint r100 = new Paint();
        this.f112501a = r100;
        r100.setAntiAlias(true);
        this.f112501a.setStyle(Paint.Style.STROKE);
    L5:
        this.f112501a.setColor(this.f112511k);
        this.f112501a.setPathEffect(this.f112515o);
        this.f112501a.setStrokeWidth(this.f112516p);
        r110.drawArc(this.f112512l, this.f112505e / 4.0f, 359.0f, false, this.f112501a);
        this.f112501a.setPathEffect(null);
        int r101 = this.f112505e;
        int r102 = (int) ((Math.sin((((double) r101) * 3.141592653589793d) / 90.0d) * 345.0d) * (-1.0d));
        if (r101 < 0) goto L9;
        if (r101 >= 45) goto L9;
    L15:
        r102 = -r102;
    L17:
        if ((this.f112505e % 90) != 45) goto L19;
        int r103 = this.f112506f;
        int r104 = this.f112508h;
        this.f112509i = (r103 - r104) - 1;
        this.f112506f = r104 + 1;
    L19:
        if (r102 != 0) goto L21;
        this.f112506f += this.f112509i;
    L21:
        this.f112501a.setStrokeWidth(this.f112517q);
        r110.drawArc(this.f112512l, this.f112506f - this.f112510j, r102, false, this.f112501a);
        this.f112513m.a(this.f112506f - this.f112510j);
        this.f112514n.a((this.f112506f - this.f112510j) + r102);
        this.f112502b.setColor(this.f112511k);
        a r105 = this.f112513m;
        r110.drawCircle(r105.f112519a, r105.f112520b, this.f112518r, this.f112502b);
        a r106 = this.f112514n;
        r110.drawCircle(r106.f112519a, r106.f112520b, this.f112518r, this.f112502b);
        int r111 = this.f112506f;
        this.f112508h = r102 + r111;
        this.f112505e = (this.f112505e + 1) % 360;
        this.f112506f = (r111 + 1) % 360;
        postInvalidateDelayed(15);
        return;
    L9:
        if (135 > r101) goto L13;
        if (r101 < 225) goto L15;
    L13:
        if (315 > r101) goto L17;
        if (r101 >= 360) goto L17;
        goto L15
    }

    public void setColor(int r100) {
        this.f112511k = r100;
    }

    public RotateHeadView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f112502b = new Paint();
        this.f112510j = 12;
        a(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f112503c = View.MeasureSpec.getSize(r100);
        this.f112504d = View.MeasureSpec.getSize(r101);
        float r102 = UIUtils.dip2Px(this.f112507g, 1.0f);
        this.f112512l.set(r102, r102, this.f112503c - r102, this.f112504d - r102);
    }

    public RotateHeadView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f112502b = new Paint();
        this.f112510j = 12;
        a(r100);
    }
}
