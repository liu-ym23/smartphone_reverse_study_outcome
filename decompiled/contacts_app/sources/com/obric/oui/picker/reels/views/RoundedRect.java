package com.obric.oui.picker.reels.views;

import android.graphics.Path;

/* JADX INFO: loaded from: classes3.dex */
class RoundedRect {
    RoundedRect() {
    }

    public static Path getRect(float r5, float r6, float r7, float r8, float r9, float r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        Path r0 = new Path();
        if (r9 >= 0.0f) goto L6;
        r9 = 0.0f;
    L6:
        if (r10 >= 0.0f) goto L8;
        r10 = 0.0f;
    L8:
        float r15 = r7 - r5;
        float r16 = r8 - r6;
        float r3 = r15 / 2.0f;
        if (r9 <= r3) goto L11;
        r9 = r3;
    L11:
        float r4 = r16 / 2.0f;
        if (r10 <= r4) goto L14;
        r10 = r4;
    L14:
        float r17 = r15 - (r9 * 2.0f);
        float r18 = r16 - (2.0f * r10);
        r0.moveTo(r7, r6 + r10);
        if (r12 == false) goto L17;
        float r19 = -r10;
        r0.rQuadTo(0.0f, r19, -r9, r19);
    L18:
        r0.rLineTo(-r17, 0.0f);
        if (r11 == false) goto L21;
        float r20 = -r9;
        r0.rQuadTo(r20, 0.0f, r20, r10);
    L22:
        r0.rLineTo(0.0f, r18);
        if (r14 == false) goto L25;
        r0.rQuadTo(0.0f, r10, r9, r10);
    L26:
        r0.rLineTo(r17, 0.0f);
        if (r13 == false) goto L29;
        r0.rQuadTo(r9, 0.0f, r9, -r10);
    L30:
        r0.rLineTo(0.0f, -r18);
        r0.close();
        return r0;
    L29:
        r0.rLineTo(r9, 0.0f);
        r0.rLineTo(0.0f, -r10);
        goto L30
    L25:
        r0.rLineTo(0.0f, r10);
        r0.rLineTo(r9, 0.0f);
        goto L26
    L21:
        r0.rLineTo(-r9, 0.0f);
        r0.rLineTo(0.0f, r10);
        goto L22
    L17:
        r0.rLineTo(0.0f, -r10);
        r0.rLineTo(-r9, 0.0f);
        goto L18
    }
}
