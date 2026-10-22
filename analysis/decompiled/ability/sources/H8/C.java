package H8;

import com.google.protobuf.C0990s2;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public final class C implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f762a;
    public int b = -1;
    public boolean c;
    public Iterator d;
    public final /* synthetic */ AbstractMap e;

    public /* synthetic */ C(AbstractMap abstractMap, int i) {
        this.f762a = i;
        this.e = abstractMap;
    }

    public final Iterator a() {
        switch (this.f762a) {
            case 0:
                if (this.d == null) {
                    this.d = ((x) this.e).c.entrySet().iterator();
                }
                break;
            default:
                if (this.d == null) {
                    this.d = ((C0990s2) this.e).c.entrySet().iterator();
                }
                break;
        }
        return this.d;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f762a) {
            case 0:
                if (this.b + 1 < ((x) this.e).b.size() || a().hasNext()) {
                }
                break;
            default:
                int i = this.b + 1;
                C0990s2 c0990s2 = (C0990s2) this.e;
                if (i >= c0990s2.b.size()) {
                    if (c0990s2.c.isEmpty() || !a().hasNext()) {
                    }
                }
                break;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f762a) {
            case 0:
                this.c = true;
                int i = this.b + 1;
                this.b = i;
                x xVar = (x) this.e;
                if (i >= xVar.b.size()) {
                    break;
                } else {
                    break;
                }
            default:
                this.c = true;
                int i6 = this.b + 1;
                this.b = i6;
                C0990s2 c0990s2 = (C0990s2) this.e;
                if (i6 >= c0990s2.b.size()) {
                    break;
                } else {
                    break;
                }
        }
        return (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i = this.f762a;
        AbstractMap abstractMap = this.e;
        switch (i) {
            case 0:
                x xVar = (x) abstractMap;
                if (!this.c) {
                    throw new IllegalStateException("remove() was called before next()");
                }
                this.c = false;
                int i6 = x.f;
                xVar.b();
                if (this.b >= xVar.b.size()) {
                    a().remove();
                    return;
                }
                int i10 = this.b;
                this.b = i10 - 1;
                xVar.g(i10);
                return;
            default:
                C0990s2 c0990s2 = (C0990s2) abstractMap;
                if (!this.c) {
                    throw new IllegalStateException("remove() was called before next()");
                }
                this.c = false;
                int i11 = C0990s2.g;
                c0990s2.b();
                if (this.b >= c0990s2.b.size()) {
                    a().remove();
                    return;
                }
                int i12 = this.b;
                this.b = i12 - 1;
                c0990s2.i(i12);
                return;
        }
    }
}
