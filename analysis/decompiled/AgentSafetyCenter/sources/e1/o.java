package e1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3388a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ r f3389b;

    public /* synthetic */ o(int i) {
        this.f3388a = i;
    }

    @Override // e1.i
    public final double b(double d7) {
        switch (this.f3388a) {
            case 0:
                r rVar = this.f3389b;
                float[] fArr = d.f3342a;
                return d.a(rVar, d7);
            case 1:
                r rVar2 = this.f3389b;
                float[] fArr2 = d.f3342a;
                return d.c(rVar2, d7);
            case 2:
                r rVar3 = this.f3389b;
                double d10 = rVar3.f3407b;
                return d7 >= rVar3.f3410e ? Math.pow((d10 * d7) + rVar3.f3408c, rVar3.f3406a) : rVar3.f3409d * d7;
            case 3:
                r rVar4 = this.f3389b;
                double d11 = rVar4.f3407b;
                double d12 = rVar4.f3408c;
                double d13 = rVar4.f3409d;
                return d7 >= rVar4.f3410e ? Math.pow((d11 * d7) + d12, rVar4.f3406a) + rVar4.f3411f : (d13 * d7) + rVar4.f3412g;
            case 4:
                r rVar5 = this.f3389b;
                float[] fArr3 = d.f3342a;
                return d.b(rVar5, d7);
            case 5:
                r rVar6 = this.f3389b;
                float[] fArr4 = d.f3342a;
                return d.d(rVar6, d7);
            case 6:
                r rVar7 = this.f3389b;
                double d14 = rVar7.f3407b;
                double d15 = rVar7.f3408c;
                double d16 = rVar7.f3409d;
                return d7 >= rVar7.f3410e * d16 ? (Math.pow(d7, 1.0d / rVar7.f3406a) - d15) / d14 : d7 / d16;
            default:
                r rVar8 = this.f3389b;
                double d17 = rVar8.f3407b;
                double d18 = rVar8.f3408c;
                double d19 = rVar8.f3409d;
                return d7 >= rVar8.f3410e * d19 ? (Math.pow(d7 - rVar8.f3411f, 1.0d / rVar8.f3406a) - d18) / d17 : (d7 - rVar8.f3412g) / d19;
        }
    }
}
