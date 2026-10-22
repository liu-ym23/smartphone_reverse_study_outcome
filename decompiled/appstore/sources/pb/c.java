package pb;

import android.graphics.Path;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f23423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f23424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f23425e;

    public c() {
        this.f23423c = 0.017453292519943295d;
        this.f23424d = 0.6f;
        this.f23425e = "FigmaSmoothCornerImpl";
    }

    @Override // pb.d
    public Path a(float r52, float r53, float r54, float r55, float r56) {
        float r10 = r54 - r52;
        float r11 = Math.min(r10, r55 - r53);
        Path r15 = new Path();
        if (r56 == 0.0f) goto L15;
        if (r56 >= (0.5f * r11)) goto L15;
        float r12 = Math.min(r11 / 2.0f, (this.f23424d + 1.0f) * r56);
        float r13 = r11 / 4.0f;
        if (r56 <= r13) goto L11;
        float r14 = this.f23424d;
        float r16 = 1.0f - ((r56 - r13) / r13);
        float r17 = 90 * (1.0f - (r14 * r16));
        float r18 = 45 * r14;
    L12:
        float r19 = (90 - r17) / 2.0f;
        double r110 = r18 * r16;
        float r20 = (float) Math.tan(this.f23423c * r110);
        float r21 = ((float) Math.tan(((double) (r19 / 2.0f)) * this.f23423c)) * r56;
        float r22 = (float) ((Math.sin(((double) (r17 / 2.0f)) * this.f23423c) * ((double) r56)) * Math.sqrt(2.0d));
        float r23 = r21 * ((float) Math.cos(r110 * this.f23423c));
        float r24 = r23 * r20;
        float r25 = ((r12 - r22) - ((r20 + 1.0f) * r23)) / 3.0f;
        e r26 = new e(r52 + (r10 / 2.0f), r53);
        float r111 = r54 - r12;
        e r27 = new e(r111, r53);
        float r28 = r12 - (r25 * 2.0f);
        float r112 = r54 - r28;
        e r113 = new e(r112, r53);
        float r29 = r28 - r25;
        float r114 = r54 - r29;
        e r115 = new e(r114, r53);
        float r30 = r29 - r23;
        float r31 = r54 - r30;
        float r116 = r53 + r24;
        e r117 = new e(r31, r116);
        float r32 = r54 - r56;
        float r118 = r53 + r56;
        float r119 = r54 - r24;
        float r33 = r53 + r30;
        new e(r119, r33);
        float r34 = r53 + r29;
        e r120 = new e(r54, r34);
        float r35 = r53 + r28;
        e r121 = new e(r54, r35);
        float r36 = r53 + r12;
        e r122 = new e(r54, r36);
        float r37 = r55 - r12;
        e r123 = new e(r54, r37);
        float r38 = r55 - r28;
        e r124 = new e(r54, r38);
        float r39 = r55 - r29;
        e r125 = new e(r54, r39);
        float r126 = r55 - r30;
        e r40 = new e(r119, r126);
        float r41 = r55 - r56;
        float r127 = r55 - r24;
        new e(r31, r127);
        e r42 = new e(r114, r55);
        e r43 = new e(r112, r55);
        e r128 = new e(r111, r55);
        float r129 = r12 + r52;
        e r130 = new e(r129, r55);
        float r44 = r28 + r52;
        e r45 = new e(r44, r55);
        float r46 = r29 + r52;
        e r47 = new e(r46, r55);
        float r48 = r30 + r52;
        e r49 = new e(r48, r127);
        float r50 = r52 + r56;
        float r51 = r24 + r52;
        new e(r51, r126);
        e r57 = new e(r52, r39);
        e r58 = new e(r52, r38);
        e r131 = new e(r52, r37);
        e r59 = new e(r52, r36);
        e r60 = new e(r52, r35);
        e r61 = new e(r52, r34);
        e r62 = new e(r51, r33);
        new e(r48, r116);
        e r63 = new e(r46, r53);
        e r64 = new e(r44, r53);
        e r65 = new e(r129, r53);
        r15.moveTo(r26.c(), r26.d());
        r15.lineTo(r27.c(), r27.d());
        r15.cubicTo(r113.c(), r113.d(), r115.c(), r115.d(), r117.c(), r117.d());
        d.a r210 = d.f23426b;
        r210.a(r15, new e(r32, r118), r56, r19 + 270.0f, 360.0f - r19);
        r15.cubicTo(r120.c(), r120.d(), r121.c(), r121.d(), r122.c(), r122.d());
        r15.lineTo(r123.c(), r123.d());
        r15.cubicTo(r124.c(), r124.d(), r125.c(), r125.d(), r40.c(), r40.d());
        r210.a(r15, new e(r32, r41), r56, r19, 90.0f - r19);
        r15.cubicTo(r42.c(), r42.d(), r43.c(), r43.d(), r128.c(), r128.d());
        r15.lineTo(r130.c(), r130.d());
        r15.cubicTo(r45.c(), r45.d(), r47.c(), r47.d(), r49.c(), r49.d());
        r210.a(r15, new e(r50, r41), r56, r19 + 90.0f, 180.0f - r19);
        r15.cubicTo(r57.c(), r57.d(), r58.c(), r58.d(), r131.c(), r131.d());
        r15.lineTo(r59.c(), r59.d());
        r15.cubicTo(r60.c(), r60.d(), r61.c(), r61.d(), r62.c(), r62.d());
        r210.a(r15, new e(r50, r118), r56, r19 + 180.0f, 270.0f - r19);
        r15.cubicTo(r63.c(), r63.d(), r64.c(), r64.d(), r65.c(), r65.d());
        r15.close();
        return r15;
    L11:
        r16 = this.f23424d;
        r17 = 90 * (1.0f - r16);
        r18 = 45;
    L15:
        return b(r52, r53, r54, r55, r56);
    }

    @Override // pb.d
    public boolean c(float r10, float r11) {
        if (r10 >= (r11 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }
}
