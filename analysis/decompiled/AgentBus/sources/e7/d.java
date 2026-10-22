package e7;

import java.util.Iterator;
import java.util.NoSuchElementException;
import q7.k;

/* loaded from: classes.dex */
public final class d extends f implements Iterator, r7.a {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f3090j;

    public d(g gVar, int i2) {
        this.f3090j = i2;
        k.e(gVar, "map");
        this.f3097i = gVar;
        this.f3095g = -1;
        this.f3096h = gVar.f3106m;
        d();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f3090j) {
            case 0:
                c();
                int i2 = this.f3094f;
                g gVar = (g) this.f3097i;
                if (i2 >= gVar.f3104k) {
                    throw new NoSuchElementException();
                }
                this.f3094f = i2 + 1;
                this.f3095g = i2;
                e eVar = new e(gVar, i2);
                d();
                return eVar;
            case 1:
                c();
                int i10 = this.f3094f;
                g gVar2 = (g) this.f3097i;
                if (i10 >= gVar2.f3104k) {
                    throw new NoSuchElementException();
                }
                this.f3094f = i10 + 1;
                this.f3095g = i10;
                Object obj = gVar2.f3099f[i10];
                d();
                return obj;
            default:
                c();
                int i11 = this.f3094f;
                g gVar3 = (g) this.f3097i;
                if (i11 >= gVar3.f3104k) {
                    throw new NoSuchElementException();
                }
                this.f3094f = i11 + 1;
                this.f3095g = i11;
                Object[] objArr = gVar3.f3100g;
                k.b(objArr);
                Object obj2 = objArr[this.f3095g];
                d();
                return obj2;
        }
    }
}
