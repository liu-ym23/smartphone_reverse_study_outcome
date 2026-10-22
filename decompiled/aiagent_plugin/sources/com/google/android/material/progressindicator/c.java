package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CircularDrawingDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
final class c extends f<e> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f13512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f13513e;
    private float f;

    public c(e r1) {
        super(r1);
        this.f13511c = 1;
    }

    @Override // com.google.android.material.progressindicator.f
    public int a() {
        return c();
    }

    @Override // com.google.android.material.progressindicator.f
    public int b() {
        return c();
    }

    @Override // com.google.android.material.progressindicator.f
    public void a(Canvas r7, float r8) {
        float r0 = (((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).g / 2.0f) + ((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).h;
        r7.translate(r0, r0);
        r7.rotate(-90.0f);
        float r3 = -r0;
        r7.clipRect(r3, r3, r0, r0);
        if (((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).i != 0) goto L5;
        int r9 = 1;
    L6:
        this.f13511c = r9;
        this.f13512d = ((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).f13506a * r8;
        this.f13513e = ((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).f13507b * r8;
        this.f = (((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).g - ((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).f13506a) / 2.0f;
        if (this.f13517b.isShowing() == false) goto L11;
        if (((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).f13510e != 2) goto L11;
    L14:
        this.f += ((1.0f - r8) * ((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).f13506a) / 2.0f;
        return;
    L11:
        if (this.f13517b.isHiding() == false) goto L16;
        if (((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).f == 1) goto L14;
    L16:
        if (this.f13517b.isShowing() == false) goto L20;
        if (((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).f13510e != 1) goto L20;
    L23:
        this.f -= ((1.0f - r8) * ((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).f13506a) / 2.0f;
        return;
    L20:
        if (this.f13517b.isHiding() == true) goto L22;
        return;
    L22:
        if (((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).f == 2) goto L23;
        return;
    L5:
        r9 = -1;
        goto L6
    }

    @Override // com.google.android.material.progressindicator.f
    void a(Canvas r12, Paint r13, float r14, float r15, int r16) {
        if (r14 != r15) goto L5;
        return;
    L5:
        r13.setStyle(Paint.Style.STROKE);
        r13.setStrokeCap(Paint.Cap.BUTT);
        r13.setAntiAlias(true);
        r13.setColor(r16);
        r13.setStrokeWidth(this.f13512d);
        int r1 = this.f13511c;
        float r9 = (r14 * 360.0f) * r1;
        if (r15 < r14) goto L8;
        float r0 = r15 - r14;
    L9:
        float r2 = (r0 * 360.0f) * r1;
        float r3 = this.f;
        r12.drawArc(new RectF(-r3, -r3, r3, r3), r9, r2, false, r13);
        if (this.f13513e > 0.0f) goto L12;
        return;
    L12:
        if (Math.abs(r2) >= 360.0f) goto L16;
        r13.setStyle(Paint.Style.FILL);
        a(r12, r13, this.f13512d, this.f13513e, r9);
        a(r12, r13, this.f13512d, this.f13513e, r9 + r2);
        return;
    L16:
        return;
    L8:
        r0 = (1.0f + r15) - r14;
        goto L9
    }

    @Override // com.google.android.material.progressindicator.f
    void a(Canvas r8, Paint r9) {
        int r0 = com.google.android.material.color.b.b(((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).f13509d, this.f13517b.getAlpha());
        r9.setStyle(Paint.Style.STROKE);
        r9.setStrokeCap(Paint.Cap.BUTT);
        r9.setAntiAlias(true);
        r9.setColor(r0);
        r9.setStrokeWidth(this.f13512d);
        float r7 = this.f;
        r8.drawArc(new RectF(-r7, -r7, r7, r7), 0.0f, 360.0f, false, r9);
    }

    private int c() {
        return ((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).g + (((e) ZeusTransformUtils.preCheckCast(this.f13516a, e.class, "com.obric.aiagent.plugin")).h * 2);
    }

    private void a(Canvas r2, Paint r3, float r4, float r5, float r6) {
        r2.save();
        r2.rotate(r6);
        float r1 = this.f;
        float r7 = r4 / 2.0f;
        r2.drawRoundRect(new RectF(r1 - r7, r5, r1 + r7, -r5), r5, r5, r3);
        r2.restore();
    }
}
