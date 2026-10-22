package d5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class l extends k {

    /* renamed from: a, reason: collision with root package name */
    public f3.c[] f3230a;

    /* renamed from: b, reason: collision with root package name */
    public String f3231b;

    /* renamed from: c, reason: collision with root package name */
    public int f3232c;

    public l(l lVar) {
        this.f3230a = null;
        this.f3232c = 0;
        this.f3231b = lVar.f3231b;
        this.f3230a = ac.a.q(lVar.f3230a);
    }

    public f3.c[] getPathData() {
        return this.f3230a;
    }

    public String getPathName() {
        return this.f3231b;
    }

    public void setPathData(f3.c[] cVarArr) {
        f3.c[] cVarArr2 = this.f3230a;
        if (cVarArr2 != null && cVarArr != null && cVarArr2.length == cVarArr.length) {
            for (int i = 0; i < cVarArr2.length; i++) {
                f3.c cVar = cVarArr2[i];
                char c9 = cVar.f3904a;
                f3.c cVar2 = cVarArr[i];
                if (c9 == cVar2.f3904a && cVar.f3905b.length == cVar2.f3905b.length) {
                }
            }
            f3.c[] cVarArr3 = this.f3230a;
            for (int i3 = 0; i3 < cVarArr.length; i3++) {
                cVarArr3[i3].f3904a = cVarArr[i3].f3904a;
                int i10 = 0;
                while (true) {
                    float[] fArr = cVarArr[i3].f3905b;
                    if (i10 < fArr.length) {
                        cVarArr3[i3].f3905b[i10] = fArr[i10];
                        i10++;
                    }
                }
            }
            return;
        }
        this.f3230a = ac.a.q(cVarArr);
    }

    public l() {
        this.f3230a = null;
        this.f3232c = 0;
    }
}
