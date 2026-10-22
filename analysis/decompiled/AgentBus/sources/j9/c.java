package j9;

import f8.z;

/* loaded from: classes.dex */
public final class c extends g {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5405b = 1;

    public /* synthetic */ c(Object obj) {
        super(obj);
    }

    @Override // j9.g
    public final v9.v a(z zVar) {
        switch (this.f5405b) {
            case 0:
                q7.k.e(zVar, "module");
                c8.h hVarN = zVar.n();
                hVarN.getClass();
                return hVarN.s(c8.j.BOOLEAN);
            case 1:
                q7.k.e(zVar, "module");
                c8.h hVarN2 = zVar.n();
                hVarN2.getClass();
                return hVarN2.s(c8.j.DOUBLE);
            default:
                q7.k.e(zVar, "module");
                c8.h hVarN3 = zVar.n();
                hVarN3.getClass();
                return hVarN3.s(c8.j.FLOAT);
        }
    }

    @Override // j9.g
    public String toString() {
        switch (this.f5405b) {
            case 1:
                return ((Number) this.f5408a).doubleValue() + ".toDouble()";
            case 2:
                return ((Number) this.f5408a).floatValue() + ".toFloat()";
            default:
                return super.toString();
        }
    }

    public c(double d6) {
        super(Double.valueOf(d6));
    }

    public c(float f10) {
        super(Float.valueOf(f10));
    }
}
