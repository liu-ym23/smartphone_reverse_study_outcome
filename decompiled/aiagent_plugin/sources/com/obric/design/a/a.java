package com.obric.design.a;

import android.graphics.Path;
import android.graphics.RectF;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: CanvasSmoothRoundRectExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final void a(Path r9, RectF r10, float r11, float r12, float r13, float r14, float r15) {
        o.e(r9, "<this>");
        o.e(r10, "rect");
        r9.reset();
        float r2 = r10.width();
        float r3 = r10.height();
        if (r2 > 0.0f) goto L5;
        return;
    L5:
        if (r3 <= 0.0f) goto L10;
        a(r9, r2, r3, r11, r12, r13, r14, r15);
        r9.offset(r10.left, r10.top);
        return;
    }

    private static final void a(Path r28, float r29, float r30, float r31, float r32, float r33, float r34, float r35) {
        float r2 = r29 / 2.0f;
        float r1 = r30 / 2.0f;
        float r3 = Math.min(r2, r1);
        float r11 = n.a(r31, 0.0f, r3);
        float r12 = n.a(r32, 0.0f, r3);
        float r13 = n.a(r33, 0.0f, r3);
        float r14 = n.a(r34, 0.0f, r3);
        boolean r4 = true;
        if (r11 != 0.0f) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == true) goto L8;
    L24:
        float r15 = a(r11, r2, r35);
        float r16 = a(r11, r1, r35);
        float r17 = a(r12, r2, r35);
        float r6 = a(r12, r1, r35);
        float r18 = a(r13, r2, r35);
        float r7 = a(r13, r1, r35);
        float r19 = a(r14, r2, r35);
        float r20 = a(r14, r1, r35);
        float r8 = (r30 - r13) - r7;
        r28.moveTo(r29, r8);
        r28.lineTo(r29, r6 + r12);
        if (r12 <= 0.0f) goto L27;
        float r24 = r12 * 0.95000005f;
        float r25 = r12 * 0.58578646f;
        float r26 = r12 * 0.29289323f;
        r28.cubicTo(r29, r24, r29, r25, r29 - r26, r26);
        r28.cubicTo(r29 - r25, 0.0f, r29 - r24, 0.0f, (r29 - r12) - r17, 0.0f);
    L28:
        r28.lineTo(r15 + r11, 0.0f);
        if (r11 <= 0.0f) goto L31;
        float r110 = r11 * 0.95000005f;
        float r111 = r11 * 0.58578646f;
        float r9 = r11 * 0.29289323f;
        r28.cubicTo(r110, 0.0f, r111, 0.0f, r9, r9);
        r28.cubicTo(0.0f, r111, 0.0f, r110, 0.0f, r11 + r16);
    L32:
        r28.lineTo(0.0f, (r30 - r14) - r20);
        if (r14 <= 0.0f) goto L35;
        float r112 = r14 * 0.95000005f;
        float r113 = r14 * 0.58578646f;
        float r10 = r14 * 0.29289323f;
        r28.cubicTo(0.0f, r30 - r112, 0.0f, r30 - r113, r10, r30 - r10);
        r28.cubicTo(r113, r30, r112, r30, r14 + r19, r30);
    L36:
        r28.lineTo((r29 - r13) - r18, r30);
        if (r13 <= 0.0f) goto L39;
        float r23 = 0.95000005f * r13;
        float r22 = 0.58578646f * r13;
        float r114 = r13 * 0.29289323f;
        r28.cubicTo(r29 - r23, r30, r29 - r22, r30, r29 - r114, r30 - r114);
        r28.cubicTo(r29, r30 - r22, r29, r30 - r23, r29, r8);
    L40:
        r28.close();
        return;
    L39:
        r28.lineTo(r29, r30);
        goto L40
    L35:
        r28.lineTo(0.0f, r30);
        goto L36
    L31:
        r28.lineTo(0.0f, 0.0f);
        goto L32
    L27:
        r28.lineTo(r29, 0.0f);
        goto L28
    L8:
        if (r12 != 0.0f) goto L10;
        boolean r21 = true;
    L11:
        if (r21 == false) goto L24;
        if (r13 != 0.0f) goto L15;
        boolean r27 = true;
    L16:
        if (r27 == false) goto L24;
        if (r14 == 0.0f) goto L21;
        r4 = false;
    L21:
        if (r4 == false) goto L24;
        r28.addRect(0.0f, 0.0f, r29, r30, Path.Direction.CW);
        return;
    L15:
        r27 = false;
        goto L16
    L10:
        r21 = false;
        goto L11
    L5:
        r5 = false;
        goto L6
    }

    private static final float a(float r0, float r1, float r2) {
        return n.b(r2 * r0, r1 - r0);
    }
}
