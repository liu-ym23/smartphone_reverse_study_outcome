package A3;

import R3.h;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b implements c, E3.a {

    /* renamed from: a, reason: collision with root package name */
    h<c> f164a;

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f165b;

    @Override // E3.a
    public boolean a(c cVar) {
        if (!b(cVar)) {
            return false;
        }
        cVar.dispose();
        return true;
    }

    @Override // E3.a
    public boolean b(c cVar) {
        F3.b.d(cVar, "disposables is null");
        if (this.f165b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f165b) {
                    return false;
                }
                h<c> hVar = this.f164a;
                if (hVar != null && hVar.e(cVar)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // E3.a
    public boolean c(c cVar) {
        F3.b.d(cVar, "disposable is null");
        if (!this.f165b) {
            synchronized (this) {
                try {
                    if (!this.f165b) {
                        h<c> hVar = this.f164a;
                        if (hVar == null) {
                            hVar = new h<>();
                            this.f164a = hVar;
                        }
                        hVar.a(cVar);
                        return true;
                    }
                } finally {
                }
            }
        }
        cVar.dispose();
        return false;
    }

    public void d() {
        if (this.f165b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f165b) {
                    return;
                }
                h<c> hVar = this.f164a;
                this.f164a = null;
                e(hVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // A3.c
    public void dispose() {
        if (this.f165b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f165b) {
                    return;
                }
                this.f165b = true;
                h<c> hVar = this.f164a;
                this.f164a = null;
                e(hVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void e(h<c> hVar) {
        if (hVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : hVar.b()) {
            if (obj instanceof c) {
                try {
                    ((c) obj).dispose();
                } catch (Throwable th) {
                    B3.b.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
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
    public boolean g() {
        return this.f165b;
    }
}
