package w5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f implements Iterator, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6208a;

    /* renamed from: b, reason: collision with root package name */
    public final Iterator f6209b;

    /* renamed from: c, reason: collision with root package name */
    public int f6210c;
    public Object d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i f6211e;

    public f(g gVar) {
        this.f6208a = 0;
        this.f6211e = gVar;
        this.f6209b = gVar.f6213b.iterator();
        this.f6210c = -1;
    }

    public void a() {
        Object next;
        boolean zBooleanValue;
        g gVar = (g) this.f6211e;
        do {
            Iterator it = this.f6209b;
            if (!it.hasNext()) {
                this.f6210c = 0;
                return;
            } else {
                next = it.next();
                zBooleanValue = ((Boolean) gVar.f6214c.invoke(next)).booleanValue();
                gVar.getClass();
            }
        } while (!zBooleanValue);
        this.d = next;
        this.f6210c = 1;
    }

    public boolean b() {
        Iterator it;
        g gVar = (g) this.f6211e;
        Iterator it2 = (Iterator) this.d;
        if (it2 != null && it2.hasNext()) {
            this.f6210c = 1;
            return true;
        }
        do {
            Iterator it3 = this.f6209b;
            if (!it3.hasNext()) {
                this.f6210c = 2;
                this.d = null;
                return false;
            }
            it = (Iterator) l.f6221a.invoke(((c5.a) gVar.f6214c).invoke(it3.next()));
        } while (!it.hasNext());
        this.d = it;
        this.f6210c = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f6208a) {
            case 0:
                if (this.f6210c == -1) {
                    a();
                }
                return this.f6210c == 1;
            default:
                int i8 = this.f6210c;
                if (i8 == 1) {
                    return true;
                }
                if (i8 == 2) {
                    return false;
                }
                return b();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f6208a) {
            case 0:
                if (this.f6210c == -1) {
                    a();
                }
                if (this.f6210c == 0) {
                    throw new NoSuchElementException();
                }
                Object obj = this.d;
                this.d = null;
                this.f6210c = -1;
                return obj;
            default:
                int i8 = this.f6210c;
                if (i8 == 2) {
                    throw new NoSuchElementException();
                }
                if (i8 == 0 && !b()) {
                    throw new NoSuchElementException();
                }
                this.f6210c = 0;
                Iterator it = (Iterator) this.d;
                p.b(it);
                return it.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f6208a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public f(g gVar, byte b9) {
        this.f6208a = 1;
        this.f6211e = gVar;
        this.f6209b = ((Iterable) ((c5.k) gVar.f6213b).f1090b).iterator();
    }
}
