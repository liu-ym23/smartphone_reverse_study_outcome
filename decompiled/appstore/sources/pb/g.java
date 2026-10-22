package pb;

import android.graphics.Path;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f23434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f23435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f23436e;

    public g(float r10) {
        this.f23436e = r10;
        this.f23434c = 1.175f;
        this.f23435d = "QuadraticSmoothCornerImpl";
    }

    @Override // pb.d
    public Path a(float r10, float r11, float r12, float r13, float r14) {
        float r15 = Math.min(r12 - r10, r13 - r11);
        if (r14 == 0.0f) goto L10;
        if (r14 >= (this.f23436e * r15)) goto L10;
        float r16 = Math.min(r15 / 2.0f, r14 * this.f23434c);
        float r17 = r11 + r16;
        e r18 = new e(r12, r17);
        float r19 = r13 - r16;
        e r20 = new e(r12, r19);
        e r21 = new e(r12, r13);
        float r22 = r12 - r16;
        e r23 = new e(r22, r13);
        float r24 = r16 + r10;
        e r25 = new e(r24, r13);
        e r26 = new e(r10, r13);
        e r110 = new e(r10, r19);
        e r27 = new e(r10, r17);
        e r28 = new e(r10, r11);
        e r111 = new e(r24, r11);
        e r29 = new e(r22, r11);
        e r30 = new e(r12, r11);
        e r112 = new e(r12, r17);
        Path r113 = new Path();
        r113.moveTo(r18.c(), r18.d());
        r113.lineTo(r20.c(), r20.d());
        r113.quadTo(r21.c(), r21.d(), r23.c(), r23.d());
        r113.lineTo(r25.c(), r25.d());
        r113.quadTo(r26.c(), r26.d(), r110.c(), r110.d());
        r113.lineTo(r27.c(), r27.d());
        r113.quadTo(r28.c(), r28.d(), r111.c(), r111.d());
        r113.lineTo(r29.c(), r29.d());
        r113.quadTo(r30.c(), r30.d(), r112.c(), r112.d());
        r113.close();
        return r113;
    L10:
        return b(r10, r11, r12, r13, r14);
    }

    @Override // pb.d
    public boolean c(float r10, float r11) {
        if (r10 >= (this.f23436e * r11)) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ g(float r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = 0.375f;
    L5:
        this(r10);
    }
}
