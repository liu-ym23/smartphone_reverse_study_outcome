package androidx.constraintlayout.a.a.a;

/* JADX INFO: compiled from: StopLogicEngine.java */
/* JADX INFO: loaded from: classes.dex */
public class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f668e;
    private float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private String k;
    private boolean l;
    private float m;
    private float n;
    private boolean o;

    public n() {
        this.l = false;
        this.o = false;
    }

    @Override // androidx.constraintlayout.a.a.a.m
    public String a(String r9, float r10) {
        StringBuilder r0 = new StringBuilder().append(r9 + " ===== " + this.k + "\n").append(r9);
        if (this.l == false) goto L5;
        String r2 = "backwards";
    L6:
        String r1 = r0.append(r2).append(" time = ").append(r10).append("  stages ").append(this.j).append("\n").toString() + r9 + " dur " + this.f667d + " vel " + this.f664a + " pos " + this.g + "\n";
        if (this.j <= 1) goto L10;
        r1 = r1 + r9 + " dur " + this.f668e + " vel " + this.f665b + " pos " + this.h + "\n";
    L10:
        if (this.j <= 2) goto L12;
        r1 = r1 + r9 + " dur " + this.f + " vel " + this.f666c + " pos " + this.i + "\n";
    L12:
        float r3 = this.f667d;
        if (r10 <= r3) goto L15;
        int r4 = this.j;
        if (r4 == 1) goto L19;
        float r11 = r10 - r3;
        float r5 = this.f668e;
        if (r11 < r5) goto L23;
        if (r4 != 2) goto L28;
        return r1 + r9 + "end stage 1\n";
    L28:
        if ((r11 - r5) >= this.f) goto L32;
        return r1 + r9 + " stage 2\n";
    L32:
        return r1 + r9 + " end stage 2\n";
    L23:
        return r1 + r9 + " stage 1\n";
    L19:
        return r1 + r9 + "end stage 0\n";
    L15:
        return r1 + r9 + "stage 0\n";
    L5:
        r2 = "forward ";
        goto L6
    }

    @Override // androidx.constraintlayout.a.a.a.m
    public float a(float r4) {
        float r0 = this.f667d;
        if (r4 > r0) goto L7;
        float r1 = this.f664a;
        float r3 = this.f665b;
    L6:
        return r1 + (((r3 - r1) * r4) / r0);
    L7:
        int r2 = this.j;
        if (r2 != 1) goto L11;
        return 0.0f;
    L11:
        r4 = r4 - r0;
        r0 = this.f668e;
        if (r4 >= r0) goto L15;
        r1 = this.f665b;
        r3 = this.f666c;
        goto L6
    L15:
        if (r2 == 2) goto L17;
        float r5 = r4 - r0;
        float r6 = this.f;
        if (r5 >= r6) goto L23;
        float r7 = this.f666c;
        return r7 - ((r5 * r7) / r6);
    L23:
        return this.i;
    L17:
        return this.h;
    }

    private float c(float r6) {
        this.o = false;
        float r0 = this.f667d;
        if (r6 > r0) goto L6;
        float r1 = this.f664a;
        return (r1 * r6) + ((((this.f665b - r1) * r6) * r6) / (r0 * 2.0f));
    L6:
        int r2 = this.j;
        if (r2 == 1) goto L9;
        float r7 = r6 - r0;
        float r3 = this.f668e;
        if (r7 >= r3) goto L15;
        float r4 = this.g;
        float r5 = this.f665b;
        return (r4 + (r5 * r7)) + ((((this.f666c - r5) * r7) * r7) / (r3 * 2.0f));
    L15:
        if (r2 == 2) goto L17;
        float r8 = r7 - r3;
        float r9 = this.f;
        if (r8 > r9) goto L22;
        float r10 = this.h;
        float r11 = this.f666c;
        return (r10 + (r11 * r8)) - (((r11 * r8) * r8) / (r9 * 2.0f));
    L22:
        this.o = true;
        return this.i;
    L17:
        return this.h;
    L9:
        return this.g;
    }

    public void a(float r7, float r8, float r9, float r10, float r11, float r12) {
        boolean r2 = false;
        this.o = false;
        this.m = r7;
        if (r7 <= r8) goto L5;
        r2 = true;
    L5:
        this.l = r2;
        if (r2 == false) goto L8;
        a(-r9, r7 - r8, r11, r12, r10);
        return;
    L8:
        a(r9, r8 - r7, r11, r12, r10);
    }

    @Override // androidx.constraintlayout.a.a.a.m
    public float b(float r2) {
        float r0 = c(r2);
        this.n = r2;
        boolean r3 = this.l;
        float r1 = this.m;
        if (r3 == false) goto L6;
        return r1 - r0;
    L6:
        return r1 + r0;
    }

    @Override // androidx.constraintlayout.a.a.a.m
    public float a() {
        if (this.l == false) goto L6;
        return -a(this.n);
    L6:
        return a(this.n);
    }

    @Override // androidx.constraintlayout.a.a.a.m
    public boolean b() {
        if (a() < 1.0E-5f) goto L5;
    L7:
        return false;
    L5:
        if (Math.abs(this.i - this.n) >= 1.0E-5f) goto L7;
        return true;
    }

    private void a(float r9, float r10, float r11, float r12, float r13) {
        this.o = false;
        if (r9 != 0.0f) goto L5;
        r9 = 1.0E-4f;
    L5:
        this.f664a = r9;
        float r1 = r9 / r11;
        float r2 = (r1 * r9) / 2.0f;
        if (r9 >= 0.0f) goto L14;
        float r14 = (float) Math.sqrt((r10 - ((((-r9) / r11) * r9) / 2.0f)) * r11);
        if (r14 >= r12) goto L11;
        this.k = "backward accelerate, decelerate";
        this.j = 2;
        this.f664a = r9;
        this.f665b = r14;
        this.f666c = 0.0f;
        float r15 = (r14 - r9) / r11;
        this.f667d = r15;
        this.f668e = r14 / r11;
        this.g = ((r9 + r14) * r15) / 2.0f;
        this.h = r10;
        this.i = r10;
        return;
    L11:
        this.k = "backward accelerate cruse decelerate";
        this.j = 3;
        this.f664a = r9;
        this.f665b = r12;
        this.f666c = r12;
        float r16 = (r12 - r9) / r11;
        this.f667d = r16;
        float r17 = r12 / r11;
        this.f = r17;
        float r18 = ((r9 + r12) * r16) / 2.0f;
        float r19 = (r17 * r12) / 2.0f;
        this.f668e = ((r10 - r18) - r19) / r12;
        this.g = r18;
        this.h = r10 - r19;
        this.i = r10;
        return;
    L14:
        if (r2 < r10) goto L17;
        this.k = "hard stop";
        this.j = 1;
        this.f664a = r9;
        this.f665b = 0.0f;
        this.g = r10;
        this.f667d = (2.0f * r10) / r9;
        return;
    L17:
        float r3 = r10 - r2;
        float r4 = r3 / r9;
        if ((r4 + r1) >= r13) goto L21;
        this.k = "cruse decelerate";
        this.j = 2;
        this.f664a = r9;
        this.f665b = r9;
        this.f666c = 0.0f;
        this.g = r3;
        this.h = r10;
        this.f667d = r4;
        this.f668e = r1;
        return;
    L21:
        float r110 = (float) Math.sqrt((r11 * r10) + ((r9 * r9) / 2.0f));
        float r5 = (r110 - r9) / r11;
        this.f667d = r5;
        float r6 = r110 / r11;
        this.f668e = r6;
        if (r110 >= r12) goto L25;
        this.k = "accelerate decelerate";
        this.j = 2;
        this.f664a = r9;
        this.f665b = r110;
        this.f666c = 0.0f;
        this.f667d = r5;
        this.f668e = r6;
        this.g = ((r9 + r110) * r5) / 2.0f;
        this.h = r10;
        return;
    L25:
        this.k = "accelerate cruse decelerate";
        this.j = 3;
        this.f664a = r9;
        this.f665b = r12;
        this.f666c = r12;
        float r111 = (r12 - r9) / r11;
        this.f667d = r111;
        float r112 = r12 / r11;
        this.f = r112;
        float r20 = ((r9 + r12) * r111) / 2.0f;
        float r113 = (r112 * r12) / 2.0f;
        this.f668e = ((r10 - r20) - r113) / r12;
        this.g = r20;
        this.h = r10 - r113;
        this.i = r10;
    }
}
