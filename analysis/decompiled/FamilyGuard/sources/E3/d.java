package E3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class d implements A3.c, a {

    /* renamed from: a, reason: collision with root package name */
    List<A3.c> f1602a;

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f1603b;

    @Override // E3.a
    public boolean a(A3.c cVar) {
        if (!b(cVar)) {
            return false;
        }
        cVar.dispose();
        return true;
    }

    @Override // E3.a
    public boolean b(A3.c cVar) {
        F3.b.d(cVar, "Disposable item is null");
        if (this.f1603b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f1603b) {
                    return false;
                }
                List<A3.c> list = this.f1602a;
                if (list != null && list.remove(cVar)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // E3.a
    public boolean c(A3.c cVar) {
        F3.b.d(cVar, "d is null");
        if (!this.f1603b) {
            synchronized (this) {
                try {
                    if (!this.f1603b) {
                        List linkedList = this.f1602a;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.f1602a = linkedList;
                        }
                        linkedList.add(cVar);
                        return true;
                    }
                } finally {
                }
            }
        }
        cVar.dispose();
        return false;
    }

    void d(List<A3.c> list) {
        if (list == null) {
            return;
        }
        Iterator<A3.c> it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                it.next().dispose();
            } catch (Throwable th) {
                B3.b.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new B3.a(arrayList);
            }
            throw R3.e.d((Throwable) arrayList.get(0));
        }
    }

    @Override // A3.c
    public void dispose() {
        if (this.f1603b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f1603b) {
                    return;
                }
                this.f1603b = true;
                List<A3.c> list = this.f1602a;
                this.f1602a = null;
                d(list);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // A3.c
    public boolean g() {
        return this.f1603b;
    }
}
