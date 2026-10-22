package g1;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3737a;

    /* renamed from: b, reason: collision with root package name */
    public final h f3738b;

    /* renamed from: c, reason: collision with root package name */
    public final h f3739c;

    /* renamed from: d, reason: collision with root package name */
    public final h f3740d;

    /* renamed from: e, reason: collision with root package name */
    public final h f3741e;

    /* renamed from: f, reason: collision with root package name */
    public final Serializable f3742f;

    public i(String str) {
        this.f3737a = 1;
        this.f3742f = str;
        this.f3738b = new h(null, 1);
        this.f3739c = new h(null, 0);
        this.f3740d = new h(null, 1);
        this.f3741e = new h(null, 0);
    }

    public final h a() {
        switch (this.f3737a) {
        }
        return this.f3741e;
    }

    public final h b() {
        switch (this.f3737a) {
        }
        return this.f3738b;
    }

    public final h c() {
        switch (this.f3737a) {
        }
        return this.f3740d;
    }

    public final h d() {
        switch (this.f3737a) {
        }
        return this.f3739c;
    }

    public final String toString() {
        switch (this.f3737a) {
            case 0:
                return d7.n.o0((i[]) this.f3742f, null, "innermostOf(", ")", null, 57);
            default:
                String str = (String) this.f3742f;
                return str != null ? a1.a.e(')', "RectRulers(", str) : super.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(i[] iVarArr) {
        this.f3737a = 0;
        this.f3742f = iVarArr;
        int length = iVarArr.length;
        h[] hVarArr = new h[length];
        for (int i2 = 0; i2 < length; i2++) {
            hVarArr[i2] = ((i[]) this.f3742f)[i2].b();
        }
        this.f3738b = new h(new a0(hVarArr, 0), 1);
        int length2 = ((i[]) this.f3742f).length;
        h[] hVarArr2 = new h[length2];
        for (int i10 = 0; i10 < length2; i10++) {
            hVarArr2[i10] = ((i[]) this.f3742f)[i10].d();
        }
        this.f3739c = new h(new g(hVarArr2, 0), 0);
        int length3 = ((i[]) this.f3742f).length;
        h[] hVarArr3 = new h[length3];
        for (int i11 = 0; i11 < length3; i11++) {
            hVarArr3[i11] = ((i[]) this.f3742f)[i11].c();
        }
        this.f3740d = new h(new a0(hVarArr3, 1), 1);
        int length4 = ((i[]) this.f3742f).length;
        h[] hVarArr4 = new h[length4];
        for (int i12 = 0; i12 < length4; i12++) {
            hVarArr4[i12] = ((i[]) this.f3742f)[i12].a();
        }
        this.f3741e = new h(new g(hVarArr4, 1), 0);
    }
}
