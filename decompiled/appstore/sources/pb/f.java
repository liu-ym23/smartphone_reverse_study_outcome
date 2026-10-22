package pb;

import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f23431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f23432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f23433f;

    public f() {
        this.f23430c = "QuadraticSmoothCornerExImpl";
        this.f23431d = 0.585786f;
        this.f23432e = 0.292893f;
        this.f23433f = 1.175f;
    }

    @Override // pb.d
    public Path a(float r10, float r11, float r12, float r13, float r14) {
        float r15 = r12 - r10;
        float r16 = r13 - r11;
        float r17 = Math.min(r15, r16);
        float r18 = Math.max(r15, r16);
        if (r14 == 0.0f) goto L22;
        float r19 = r17 * 0.5f;
        if (r14 != r19) goto L22;
        if (r14 != r19) goto L13;
        if (r15 != r16) goto L13;
        return b(r10, r11, r12, r13, r14);
    L13:
        if (r15 <= r16) goto L15;
        boolean r20 = true;
    L16:
        float r21 = bg.h.f(r14, r19);
        float r22 = Math.min(this.f23433f * r21, r18 * 0.5f);
        if (r20 == false) goto L20;
        return g(r10, r11, r12, r13, r21, r22);
    L20:
        return h(r10, r11, r12, r13, r21, r22);
    L15:
        r20 = false;
    L22:
        return b(r10, r11, r12, r13, r14);
    }

    @Override // pb.d
    public boolean c(float r10, float r11) {
        if (r10 != (r11 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }

    public final Path g(float r17, float r18, float r19, float r20, float r21, float r22) {
        float r10 = this.f23431d * r21;
        float r11 = this.f23432e * r21;
        float r12 = r17 + r22;
        e r13 = new e(r12, r18);
        float r14 = 2.0f * r21;
        RectF r15 = new RectF(r17, r18, r17 + r14, r20);
        RectF r16 = new RectF(r19 - r14, r18, r19, r20);
        float r110 = r19 - r22;
        e r23 = new e(r110, r18);
        float r111 = r19 - r10;
        e r112 = new e(r111, r18);
        float r24 = r19 - r11;
        float r113 = r18 + r11;
        e r114 = new e(r24, r113);
        float r115 = r20 - r11;
        new e(r24, r115);
        e r25 = new e(r111, r20);
        e r26 = new e(r110, r20);
        e r116 = new e(r12, r20);
        float r27 = r10 + r17;
        e r117 = new e(r27, r20);
        float r28 = r11 + r17;
        e r29 = new e(r28, r115);
        new e(r28, r113);
        e r30 = new e(r27, r18);
        e r31 = new e(r12, r18);
        Path r32 = new Path();
        r32.moveTo(r13.c(), r13.d());
        r32.lineTo(r23.c(), r23.d());
        r32.quadTo(r112.c(), r112.d(), r114.c(), r114.d());
        r32.arcTo(r16, -45.0f, 90.0f);
        r32.quadTo(r25.c(), r25.d(), r26.c(), r26.d());
        r32.lineTo(r116.c(), r116.d());
        r32.quadTo(r117.c(), r117.d(), r29.c(), r29.d());
        r32.arcTo(r15, 135.0f, 90.0f);
        r32.quadTo(r30.c(), r30.d(), r31.c(), r31.d());
        r32.close();
        return r32;
    }

    public final Path h(float r17, float r18, float r19, float r20, float r21, float r22) {
        float r10 = this.f23431d * r21;
        float r11 = this.f23432e * r21;
        float r12 = r18 + r22;
        e r13 = new e(r19, r12);
        float r14 = 2.0f * r21;
        RectF r15 = new RectF(r17, r18, r19, r18 + r14);
        RectF r16 = new RectF(r17, r20 - r14, r19, r20);
        float r110 = r20 - r22;
        e r23 = new e(r19, r110);
        float r111 = r20 - r10;
        e r112 = new e(r19, r111);
        float r113 = r19 - r11;
        float r24 = r20 - r11;
        e r114 = new e(r113, r24);
        float r115 = r17 + r11;
        new e(r115, r24);
        e r25 = new e(r17, r111);
        e r26 = new e(r17, r110);
        e r116 = new e(r17, r12);
        float r27 = r10 + r18;
        e r117 = new e(r17, r27);
        float r28 = r11 + r18;
        e r29 = new e(r115, r28);
        new e(r113, r28);
        e r30 = new e(r19, r27);
        e r31 = new e(r19, r12);
        Path r32 = new Path();
        r32.moveTo(r13.c(), r13.d());
        r32.lineTo(r23.c(), r23.d());
        r32.quadTo(r112.c(), r112.d(), r114.c(), r114.d());
        r32.arcTo(r16, 45.0f, 90.0f);
        r32.quadTo(r25.c(), r25.d(), r26.c(), r26.d());
        r32.lineTo(r116.c(), r116.d());
        r32.quadTo(r117.c(), r117.d(), r29.c(), r29.d());
        r32.arcTo(r15, 225.0f, 90.0f);
        r32.quadTo(r30.c(), r30.d(), r31.c(), r31.d());
        r32.close();
        return r32;
    }
}
