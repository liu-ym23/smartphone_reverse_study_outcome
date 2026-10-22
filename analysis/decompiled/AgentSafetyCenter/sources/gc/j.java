package gc;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import p.e0;
import p.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j implements Iterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4696c;

    /* renamed from: f, reason: collision with root package name */
    public int f4697f;

    /* renamed from: g, reason: collision with root package name */
    public Object f4698g;

    /* renamed from: h, reason: collision with root package name */
    public Object f4699h;

    public /* synthetic */ j(int i) {
        this.f4696c = i;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, xb.l] */
    public void a() {
        Object objInvoke;
        int i = this.f4697f;
        i iVar = (i) this.f4699h;
        if (i == -2) {
            objInvoke = ((ab.e) iVar.f4694b).f393f;
        } else {
            ?? r02 = iVar.f4695c;
            Object obj = this.f4698g;
            obj.getClass();
            objInvoke = r02.invoke(obj);
        }
        this.f4698g = objInvoke;
        this.f4697f = objInvoke == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f4696c) {
            case 0:
                if (this.f4697f < 0) {
                    a();
                }
                if (this.f4697f == 1) {
                }
                break;
            case 1:
                break;
            case 2:
                break;
            default:
                if (this.f4697f < ((Map) this.f4699h).size()) {
                }
                break;
        }
        return ((l) this.f4698g).hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f4696c) {
            case 0:
                if (this.f4697f < 0) {
                    a();
                }
                if (this.f4697f == 0) {
                    g5.f.k();
                    return null;
                }
                Object obj = this.f4698g;
                obj.getClass();
                this.f4697f = -1;
                return obj;
            case 1:
                return ((l) this.f4698g).next();
            case 2:
                return ((l) this.f4698g).next();
            default:
                if (!hasNext()) {
                    g5.f.k();
                    return null;
                }
                Object obj2 = this.f4698g;
                this.f4697f++;
                Object obj3 = ((Map) this.f4699h).get(obj2);
                if (obj3 != null) {
                    this.f4698g = ((q0.a) obj3).f10068b;
                    return obj2;
                }
                throw new ConcurrentModificationException("Hash code of an element (" + obj2 + ") has changed after it was added to the persistent set.");
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f4696c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                int i = this.f4697f;
                if (i != -1) {
                    ((e0) this.f4699h).f9548f.h(i);
                    this.f4697f = -1;
                    return;
                }
                return;
            case 2:
                int i3 = this.f4697f;
                if (i3 != -1) {
                    ((i0) this.f4699h).f9579f.l(i3);
                    this.f4697f = -1;
                    return;
                }
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}
