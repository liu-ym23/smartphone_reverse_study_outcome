package o7;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends AbstractSet {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9263c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ n f9264f;

    public /* synthetic */ l(n nVar, int i) {
        this.f9263c = i;
        this.f9264f = nVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f9263c) {
            case 0:
                this.f9264f.clear();
                break;
            default:
                this.f9264f.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        m mVarA;
        switch (this.f9263c) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                n nVar = this.f9264f;
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                m mVar = null;
                if (key != null) {
                    try {
                        mVarA = nVar.a(key, false);
                    } catch (ClassCastException unused) {
                    }
                } else {
                    mVarA = null;
                }
                if (mVarA != null && Objects.equals(mVarA.f9271l, entry.getValue())) {
                    mVar = mVarA;
                }
                return mVar != null;
            default:
                return this.f9264f.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f9263c) {
            case 0:
                return new k(this.f9264f, 0);
            default:
                return new k(this.f9264f, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        m mVarA;
        switch (this.f9263c) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    n nVar = this.f9264f;
                    m mVar = null;
                    if (key != null) {
                        try {
                            mVarA = nVar.a(key, false);
                        } catch (ClassCastException unused) {
                        }
                    } else {
                        mVarA = null;
                    }
                    if (mVarA != null && Objects.equals(mVarA.f9271l, entry.getValue())) {
                        mVar = mVarA;
                    }
                    if (mVar != null) {
                        nVar.c(mVar, true);
                        break;
                    }
                }
                break;
            default:
                n nVar2 = this.f9264f;
                m mVarA2 = null;
                if (obj != null) {
                    try {
                        mVarA2 = nVar2.a(obj, false);
                    } catch (ClassCastException unused2) {
                    }
                }
                if (mVarA2 != null) {
                    nVar2.c(mVarA2, true);
                }
                if (mVarA2 != null) {
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f9263c) {
        }
        return this.f9264f.f9277h;
    }
}
