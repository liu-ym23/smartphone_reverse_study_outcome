package G1;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class l extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f605a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f606b;

    public /* synthetic */ l(o oVar, int i4) {
        this.f605a = i4;
        this.f606b = oVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        int i4 = this.f605a;
        o oVar = this.f606b;
        switch (i4) {
            case 0:
                oVar.clear();
                break;
            default:
                oVar.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        n nVarA;
        int i4 = this.f605a;
        o oVar = this.f606b;
        switch (i4) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                oVar.getClass();
                Object key = entry.getKey();
                n nVar = null;
                if (key != null) {
                    try {
                        nVarA = oVar.a(key, false);
                    } catch (ClassCastException unused) {
                    }
                } else {
                    nVarA = null;
                }
                if (nVarA != null && Objects.equals(nVarA.f618h, entry.getValue())) {
                    nVar = nVarA;
                }
                return nVar != null;
            default:
                return oVar.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f605a) {
            case 0:
                return new k(this);
            default:
                return new k(this, 0);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        n nVarA;
        n nVarA2 = null;
        int i4 = this.f605a;
        o oVar = this.f606b;
        switch (i4) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    oVar.getClass();
                    Object key = entry.getKey();
                    if (key != null) {
                        try {
                            nVarA = oVar.a(key, false);
                        } catch (ClassCastException unused) {
                        }
                    } else {
                        nVarA = null;
                    }
                    if (nVarA != null && Objects.equals(nVarA.f618h, entry.getValue())) {
                        nVarA2 = nVarA;
                    }
                    if (nVarA2 != null) {
                        oVar.c(nVarA2, true);
                        break;
                    }
                }
                break;
            default:
                oVar.getClass();
                if (obj != null) {
                    try {
                        nVarA2 = oVar.a(obj, false);
                    } catch (ClassCastException unused2) {
                    }
                }
                if (nVarA2 != null) {
                    oVar.c(nVarA2, true);
                }
                if (nVarA2 != null) {
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        int i4 = this.f605a;
        o oVar = this.f606b;
        switch (i4) {
        }
        return oVar.f624d;
    }
}
