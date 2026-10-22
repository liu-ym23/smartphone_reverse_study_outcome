package com.google.android.material.h;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.core.graphics.e;

/* JADX INFO: compiled from: ShadowRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final int[] g = null;
    private static final float[] h = null;
    private static final int[] i = null;
    private static final float[] j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f13421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f13422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f13423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13425e;
    private int f;
    private final Path k;
    private Paint l;

    static {
        g = new int[3];
        h = new float[]{0.0f, 0.5f, 1.0f};
        i = new int[4];
        j = new float[]{0.0f, 0.0f, 0.5f, 1.0f};
    }

    public a() {
        this(-16777216);
    }

    public a(int r2) {
        this.k = new Path();
        this.l = new Paint();
        this.f13421a = new Paint();
        a(r2);
        this.l.setColor(0);
        Paint r3 = new Paint(4);
        this.f13422b = r3;
        r3.setStyle(Paint.Style.FILL);
        this.f13423c = new Paint(r3);
    }

    public void a(int r2) {
        this.f13424d = e.b(r2, 68);
        this.f13425e = e.b(r2, 20);
        this.f = e.b(r2, 0);
        this.f13421a.setColor(this.f13424d);
    }

    public void a(Canvas r10, Matrix r11, RectF r12, int r13) {
        r12.bottom += r13;
        r12.offset(0.0f, -r13);
        int[] r6 = g;
        r6[0] = this.f;
        r6[1] = this.f13425e;
        r6[2] = this.f13424d;
        this.f13423c.setShader(new LinearGradient(r12.left, r12.top, r12.left, r12.bottom, r6, h, Shader.TileMode.CLAMP));
        r10.save();
        r10.concat(r11);
        r10.drawRect(r12, this.f13423c);
        r10.restore();
    }

    public void a(Canvas r21, Matrix r22, RectF r23, int r24, float r25, float r26) {
        if (r26 >= 0.0f) goto L5;
        boolean r5 = true;
    L6:
        Path r9 = this.k;
        if (r5 == false) goto L9;
        int[] r12 = i;
        r12[0] = 0;
        r12[1] = this.f;
        r12[2] = this.f13425e;
        r12[3] = this.f13424d;
    L10:
        float r16 = r23.width() / 2.0f;
        if (r16 > 0.0f) goto L13;
        return;
    L13:
        float r2 = 1.0f - (r24 / r16);
        float[] r18 = j;
        r18[1] = r2;
        r18[2] = ((1.0f - r2) / 2.0f) + r2;
        this.f13422b.setShader(new RadialGradient(r23.centerX(), r23.centerY(), r16, i, r18, Shader.TileMode.CLAMP));
        r21.save();
        r21.concat(r22);
        r21.scale(1.0f, r23.height() / r23.width());
        if (r5 == true) goto L16;
        r21.clipPath(r9, Region.Op.DIFFERENCE);
        r21.drawPath(r9, this.l);
    L16:
        r21.drawArc(r23, r25, r26, true, this.f13422b);
        r21.restore();
        return;
    L9:
        r9.rewind();
        r9.moveTo(r23.centerX(), r23.centerY());
        r9.arcTo(r23, r25, r26);
        r9.close();
        float r13 = -r24;
        r23.inset(r13, r13);
        int[] r14 = i;
        r14[0] = 0;
        r14[1] = this.f13424d;
        r14[2] = this.f13425e;
        r14[3] = this.f;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    public Paint a() {
        return this.f13421a;
    }
}
