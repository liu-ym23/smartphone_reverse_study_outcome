package d5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends f implements Iterator, q5.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f1826e;

    public d(g map, int i8) {
        this.f1826e = i8;
        p.e(map, "map");
        this.d = map;
        this.f1831b = -1;
        this.f1832c = map.f1840h;
        c();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f1826e) {
            case 0:
                b();
                int i8 = this.f1830a;
                g gVar = (g) this.d;
                if (i8 >= gVar.f1838f) {
                    throw new NoSuchElementException();
                }
                this.f1830a = i8 + 1;
                this.f1831b = i8;
                e eVar = new e(gVar, i8);
                c();
                return eVar;
            case 1:
                b();
                int i9 = this.f1830a;
                g gVar2 = (g) this.d;
                if (i9 >= gVar2.f1838f) {
                    throw new NoSuchElementException();
                }
                this.f1830a = i9 + 1;
                this.f1831b = i9;
                Object obj = gVar2.f1834a[i9];
                c();
                return obj;
            default:
                b();
                int i10 = this.f1830a;
                g gVar3 = (g) this.d;
                if (i10 >= gVar3.f1838f) {
                    throw new NoSuchElementException();
                }
                this.f1830a = i10 + 1;
                this.f1831b = i10;
                Object[] objArr = gVar3.f1835b;
                p.b(objArr);
                Object obj2 = objArr[this.f1831b];
                c();
                return obj2;
        }
    }
}
