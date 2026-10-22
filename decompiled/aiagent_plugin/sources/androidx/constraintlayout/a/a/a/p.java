package androidx.constraintlayout.a.a.a;

/* JADX INFO: compiled from: VelocityMatrix.java */
/* JADX INFO: loaded from: classes.dex */
public class p {
    private static String g = "VelocityMatrix";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    float f676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f678e;
    float f;

    static {
    }

    public p() {
    }

    public void a() {
        this.f678e = 0.0f;
        this.f677d = 0.0f;
        this.f676c = 0.0f;
        this.f675b = 0.0f;
        this.f674a = 0.0f;
    }

    public void a(j r2, float r3) {
        if (r2 == null) goto L5;
        this.f678e = r2.b(r3);
        this.f = r2.a(r3);
        return;
    }

    public void a(j r1, j r2, float r3) {
        if (r1 == null) goto L4;
        this.f676c = r1.b(r3);
    L4:
        if (r2 == null) goto L7;
        this.f677d = r2.b(r3);
        return;
    }

    public void b(j r1, j r2, float r3) {
        if (r1 == null) goto L4;
        this.f674a = r1.b(r3);
    L4:
        if (r2 == null) goto L7;
        this.f675b = r2.b(r3);
        return;
    }

    public void a(e r1, float r2) {
        if (r1 == null) goto L5;
        this.f678e = r1.b(r2);
        return;
    }

    public void a(e r1, e r2, float r3) {
        if (r1 == null) goto L4;
        this.f676c = r1.b(r3);
    L4:
        if (r2 == null) goto L7;
        this.f677d = r2.b(r3);
        return;
    }

    public void b(e r1, e r2, float r3) {
        if (r1 == null) goto L4;
        this.f674a = r1.b(r3);
    L4:
        if (r2 == null) goto L7;
        this.f675b = r2.b(r3);
        return;
    }

    public void a(float r18, float r19, int r20, int r21, float[] r22) {
        float r3 = r22[0];
        float r5 = r22[1];
        float r7 = (r18 - 0.5f) * 2.0f;
        float r6 = (r19 - 0.5f) * 2.0f;
        float r4 = r3 + this.f676c;
        float r8 = r5 + this.f677d;
        float r9 = r4 + (this.f674a * r7);
        float r10 = r8 + (this.f675b * r6);
        float r11 = (float) Math.toRadians(this.f);
        float r0 = (float) Math.toRadians(this.f678e);
        double r12 = r11;
        double r13 = r21 * r6;
        float r14 = r9 + (((float) ((((double) ((-r20) * r7)) * Math.sin(r12)) - (Math.cos(r12) * r13))) * r0);
        float r15 = r10 + (r0 * ((float) ((((double) (r20 * r7)) * Math.cos(r12)) - (r13 * Math.sin(r12)))));
        r22[0] = r14;
        r22[1] = r15;
    }
}
