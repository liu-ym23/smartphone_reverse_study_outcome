package v0;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final c f10300a;

    /* renamed from: b, reason: collision with root package name */
    public final c f10301b;

    /* renamed from: c, reason: collision with root package name */
    public final c f10302c;

    /* renamed from: d, reason: collision with root package name */
    public final float[] f10303d;

    public g(c cVar, c cVar2, c cVar3, float[] fArr) {
        this.f10300a = cVar;
        this.f10301b = cVar2;
        this.f10302c = cVar3;
        this.f10303d = fArr;
    }

    public long a(long j2) {
        float fH = u0.m.h(j2);
        float fG = u0.m.g(j2);
        float fE = u0.m.e(j2);
        float fD = u0.m.d(j2);
        c cVar = this.f10301b;
        long jD = cVar.d(fH, fG, fE);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jD >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jD & 4294967295L));
        float fE2 = cVar.e(fH, fG, fE);
        float[] fArr = this.f10303d;
        if (fArr != null) {
            fIntBitsToFloat *= fArr[0];
            fIntBitsToFloat2 *= fArr[1];
            fE2 *= fArr[2];
        }
        float f10 = fIntBitsToFloat;
        float f11 = fIntBitsToFloat2;
        return this.f10302c.f(f10, f11, fE2, fD, this.f10300a);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g(v0.c r9, v0.c r10, int r11) {
        /*
            r8 = this;
            long r0 = r9.f10270b
            long r2 = v0.b.f10264a
            boolean r0 = v0.b.a(r0, r2)
            if (r0 == 0) goto Lf
            v0.c r0 = v0.j.a(r9)
            goto L10
        Lf:
            r0 = r9
        L10:
            long r4 = r10.f10270b
            boolean r1 = v0.b.a(r4, r2)
            if (r1 == 0) goto L1d
            v0.c r1 = v0.j.a(r10)
            goto L1e
        L1d:
            r1 = r10
        L1e:
            r4 = 3
            if (r11 != r4) goto L69
            long r5 = r9.f10270b
            boolean r11 = v0.b.a(r5, r2)
            long r5 = r10.f10270b
            boolean r2 = v0.b.a(r5, r2)
            if (r11 == 0) goto L32
            if (r2 == 0) goto L32
            goto L69
        L32:
            if (r11 != 0) goto L36
            if (r2 == 0) goto L69
        L36:
            if (r11 == 0) goto L39
            goto L3a
        L39:
            r9 = r10
        L3a:
            v0.q r9 = (v0.q) r9
            v0.s r9 = r9.f10324d
            float[] r3 = v0.j.f10309e
            if (r11 == 0) goto L47
            float[] r11 = r9.a()
            goto L48
        L47:
            r11 = r3
        L48:
            if (r2 == 0) goto L4e
            float[] r3 = r9.a()
        L4e:
            r9 = 0
            r2 = r11[r9]
            r5 = r3[r9]
            float r2 = r2 / r5
            r5 = 1
            r6 = r11[r5]
            r7 = r3[r5]
            float r6 = r6 / r7
            r7 = 2
            r11 = r11[r7]
            r3 = r3[r7]
            float r11 = r11 / r3
            float[] r3 = new float[r4]
            r3[r9] = r2
            r3[r5] = r6
            r3[r7] = r11
            goto L6a
        L69:
            r3 = 0
        L6a:
            r8.<init>(r10, r0, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.g.<init>(v0.c, v0.c, int):void");
    }
}
