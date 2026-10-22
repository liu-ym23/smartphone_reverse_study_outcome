package fa;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class e implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3618f;

    /* renamed from: g, reason: collision with root package name */
    public final Iterator f3619g;

    /* renamed from: h, reason: collision with root package name */
    public int f3620h;

    /* renamed from: i, reason: collision with root package name */
    public Object f3621i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ j f3622j;

    public e(f fVar) {
        this.f3618f = 0;
        this.f3622j = fVar;
        this.f3619g = fVar.f3623a.iterator();
        this.f3620h = -1;
    }

    public void a() {
        Object next;
        f fVar = (f) this.f3622j;
        do {
            Iterator it = this.f3619g;
            if (!it.hasNext()) {
                this.f3620h = 0;
                return;
            }
            next = it.next();
        } while (((Boolean) fVar.f3625c.invoke(next)).booleanValue() != fVar.f3624b);
        this.f3621i = next;
        this.f3620h = 1;
    }

    public boolean c() {
        Iterator it;
        Iterator it2 = (Iterator) this.f3621i;
        if (it2 != null && it2.hasNext()) {
            this.f3620h = 1;
            return true;
        }
        do {
            Iterator it3 = this.f3619g;
            if (!it3.hasNext()) {
                this.f3620h = 2;
                this.f3621i = null;
                return false;
            }
            Object next = it3.next();
            g gVar = (g) this.f3622j;
            it = (Iterator) gVar.f3628c.invoke(gVar.f3627b.invoke(next));
        } while (!it.hasNext());
        this.f3621i = it;
        this.f3620h = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f3618f) {
            case 0:
                if (this.f3620h == -1) {
                    a();
                }
                return this.f3620h == 1;
            default:
                int i2 = this.f3620h;
                if (i2 == 1) {
                    return true;
                }
                if (i2 == 2) {
                    return false;
                }
                return c();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f3618f) {
            case 0:
                if (this.f3620h == -1) {
                    a();
                }
                if (this.f3620h == 0) {
                    throw new NoSuchElementException();
                }
                Object obj = this.f3621i;
                this.f3621i = null;
                this.f3620h = -1;
                return obj;
            default:
                int i2 = this.f3620h;
                if (i2 == 2) {
                    throw new NoSuchElementException();
                }
                if (i2 == 0 && !c()) {
                    throw new NoSuchElementException();
                }
                this.f3620h = 0;
                Iterator it = (Iterator) this.f3621i;
                q7.k.b(it);
                return it.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f3618f) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(g gVar) {
        this.f3618f = 1;
        this.f3622j = gVar;
        this.f3619g = gVar.f3626a.iterator();
    }
}
