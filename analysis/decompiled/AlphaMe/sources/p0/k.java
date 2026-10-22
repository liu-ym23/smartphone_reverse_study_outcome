package p0;

import t0.J;

/* loaded from: classes.dex */
public abstract class k extends j {

    /* renamed from: a, reason: collision with root package name */
    public D.f[] f13881a;

    /* renamed from: b, reason: collision with root package name */
    public String f13882b;

    /* renamed from: c, reason: collision with root package name */
    public int f13883c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13884d;

    public k() {
        this.f13881a = null;
        this.f13883c = 0;
    }

    public D.f[] getPathData() {
        return this.f13881a;
    }

    public String getPathName() {
        return this.f13882b;
    }

    public void setPathData(D.f[] fVarArr) {
        if (!J.f(this.f13881a, fVarArr)) {
            this.f13881a = J.t(fVarArr);
            return;
        }
        D.f[] fVarArr2 = this.f13881a;
        for (int i4 = 0; i4 < fVarArr.length; i4++) {
            fVarArr2[i4].f362a = fVarArr[i4].f362a;
            int i5 = 0;
            while (true) {
                float[] fArr = fVarArr[i4].f363b;
                if (i5 < fArr.length) {
                    fVarArr2[i4].f363b[i5] = fArr[i5];
                    i5++;
                }
            }
        }
    }

    public k(k kVar) {
        this.f13881a = null;
        this.f13883c = 0;
        this.f13882b = kVar.f13882b;
        this.f13884d = kVar.f13884d;
        this.f13881a = J.t(kVar.f13881a);
    }
}
