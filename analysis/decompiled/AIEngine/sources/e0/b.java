package e0;

import mb.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f8518a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8519b;

    public b(int i10) {
        switch (i10) {
            case 1:
                this.f8519b = new k();
                break;
            default:
                this.f8519b = new Object[256];
                break;
        }
    }

    public void a(androidx.constraintlayout.core.b bVar) {
        int i10 = this.f8518a;
        Object[] objArr = (Object[]) this.f8519b;
        if (i10 < objArr.length) {
            objArr[i10] = bVar;
            this.f8518a = i10 + 1;
        }
    }
}
