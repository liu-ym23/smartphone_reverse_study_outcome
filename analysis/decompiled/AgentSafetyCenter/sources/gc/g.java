package gc;

import d2.y;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g implements Iterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4686c;

    /* renamed from: f, reason: collision with root package name */
    public Iterator f4687f;

    /* renamed from: g, reason: collision with root package name */
    public int f4688g;

    /* renamed from: h, reason: collision with root package name */
    public Object f4689h;
    public /* synthetic */ k i;

    public void a() {
        h hVar = (h) this.i;
        Iterator it = this.f4687f;
        while (it.hasNext()) {
            Object next = it.next();
            if (((Boolean) hVar.f4692c.invoke(next)).booleanValue() == hVar.f4691b) {
                this.f4689h = next;
                this.f4688g = 1;
                return;
            }
        }
        this.f4688g = 0;
    }

    public boolean b() {
        Iterator it = this.f4687f;
        Iterator it2 = (Iterator) this.f4689h;
        if (it2 != null && it2.hasNext()) {
            this.f4688g = 1;
            return true;
        }
        while (it.hasNext()) {
            Iterator it3 = (Iterator) q.f4708m.invoke(((y) ((i) this.i).f4695c).invoke(it.next()));
            if (it3.hasNext()) {
                this.f4689h = it3;
                this.f4688g = 1;
                return true;
            }
        }
        this.f4688g = 2;
        this.f4689h = null;
        return false;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f4686c) {
            case 0:
                if (this.f4688g == -1) {
                    a();
                }
                return this.f4688g == 1;
            default:
                int i = this.f4688g;
                if (i == 1) {
                    return true;
                }
                if (i == 2) {
                    return false;
                }
                return b();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f4686c) {
            case 0:
                if (this.f4688g == -1) {
                    a();
                }
                if (this.f4688g == 0) {
                    g5.f.k();
                    return null;
                }
                Object obj = this.f4689h;
                this.f4689h = null;
                this.f4688g = -1;
                return obj;
            default:
                int i = this.f4688g;
                if (i == 2) {
                    g5.f.k();
                } else {
                    if (i != 0 || b()) {
                        this.f4688g = 0;
                        Iterator it = (Iterator) this.f4689h;
                        it.getClass();
                        return it.next();
                    }
                    g5.f.k();
                }
                return null;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f4686c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}
