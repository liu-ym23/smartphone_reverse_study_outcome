package cja;

import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes33.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f23992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f23994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f23995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f23996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f23997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f23998g;

    public e() {
        this.f23998g = 1.0f;
        this.f23992a = Math.sqrt(50.0f);
        this.f23997f = 1.0f;
    }

    public final void a(float r100) {
        double r101 = this.f23992a;
        if (((float) (r101 * r101)) <= 0) goto L7;
        this.f23992a = Math.sqrt(r100);
        this.f23993b = false;
        return;
    L7:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public final d b(float r110, float r111, long r112) {
        if (this.f23993b == false) goto L6;
    L16:
        double r100 = r112 / 1000.0d;
        float r101 = r110 - this.f23998g;
        float r102 = this.f23997f;
        if (r102 <= 1) goto L20;
        double r103 = r101;
        double r104 = this.f23995d;
        double r113 = r111;
        double r114 = this.f23994c;
        double r105 = r103 - (((r104 * r103) - r113) / (r104 - r114));
        double r106 = ((r103 * r104) - r113) / (r104 - r114);
        double r107 = (Math.exp(r104 * r100) * r105) + (Math.exp(this.f23994c * r100) * r106);
        double r115 = this.f23995d;
        double r108 = (r105 * r115) * Math.exp(r115 * r100);
        double r116 = this.f23994c;
        double r109 = r108 + ((r106 * r116) * Math.exp(r116 * r100));
    L23:
        long r117 = Float.floatToRawIntBits((float) (r107 + ((double) this.f23998g)));
        return new d((((long) Float.floatToRawIntBits((float) r109)) & BodyPartID.bodyIdMax) | (r117 << 32));
    L20:
        if (r102 != 1.0f) goto L22;
        double r118 = this.f23992a;
        double r119 = r101;
        double r120 = ((double) r111) + (r118 * r119);
        double r121 = r119 + (r120 * r100);
        double r122 = Math.exp((-r118) * r100) * r121;
        double r123 = r121 * Math.exp((-this.f23992a) * r100);
        double r124 = this.f23992a;
        double r125 = (r123 * (-r124)) + (r120 * Math.exp((-r124) * r100));
        r107 = r122;
        r109 = r125;
        goto L23
    L22:
        double r126 = ((double) 1) / this.f23996e;
        double r127 = this.f23992a;
        double r128 = r101;
        double r129 = r126 * (((((double) r102) * r127) * r128) + ((double) r111));
        double r130 = Math.exp((((double) (-r102)) * r127) * r100) * ((Math.cos(this.f23996e * r100) * r128) + (Math.sin(this.f23996e * r100) * r129));
        double r131 = this.f23992a;
        float r132 = this.f23997f;
        double r133 = ((-r131) * r130) * ((double) r132);
        double r134 = Math.exp((((double) (-r132)) * r131) * r100);
        double r135 = this.f23996e;
        double r136 = ((-r135) * r128) * Math.sin(r135 * r100);
        double r137 = this.f23996e;
        r109 = r133 + (r134 * (r136 + ((r129 * r137) * Math.cos(r137 * r100))));
        r107 = r130;
        goto L23
    L6:
        if (this.f23998g == Float.MAX_VALUE) goto L26;
        float r138 = this.f23997f;
        double r139 = r138;
        double r140 = r139 * r139;
        float r141 = 1;
        if (r138 <= r141) goto L11;
        double r142 = this.f23992a;
        double r143 = r140 - ((double) 1);
        this.f23994c = (((double) (-r138)) * r142) + (r142 * Math.sqrt(r143));
        double r144 = -this.f23997f;
        double r145 = this.f23992a;
        this.f23995d = (r144 * r145) - (r145 * Math.sqrt(r143));
    L15:
        this.f23993b = true;
        goto L16
    L11:
        if (r138 < 0) goto L15;
        if (r138 >= r141) goto L15;
        this.f23996e = this.f23992a * Math.sqrt(((double) 1) - r140);
        goto L15
    L26:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }
}
