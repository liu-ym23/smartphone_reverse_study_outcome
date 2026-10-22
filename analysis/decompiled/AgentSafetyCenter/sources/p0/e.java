package p0;

import i1.f0;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends kb.g {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9666c;

    /* renamed from: f, reason: collision with root package name */
    public final s0.f f9667f;

    public /* synthetic */ e(int i, s0.f fVar) {
        this.f9666c = i;
        this.f9667f = fVar;
    }

    @Override // kb.g
    public final int a() {
        switch (this.f9666c) {
        }
        return this.f9667f.i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f9666c) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f9666c) {
            case 0:
                this.f9667f.clear();
                break;
            default:
                this.f9667f.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f9666c) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                s0.f fVar = this.f9667f;
                Object obj2 = fVar.get(key);
                return obj2 != null ? obj2.equals(entry.getValue()) : entry.getValue() == null && fVar.containsKey(entry.getKey());
            default:
                return this.f9667f.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        int i = this.f9666c;
        int i3 = 0;
        s0.f fVar = this.f9667f;
        switch (i) {
            case 0:
                f0 f0Var = new f0(1);
                k[] kVarArr = new k[8];
                while (i3 < 8) {
                    m mVar = new m();
                    mVar.f9680h = f0Var;
                    VarHandle.storeStoreFence();
                    kVarArr[i3] = mVar;
                    i3++;
                }
                f0Var.f5669f = new d(fVar, kVarArr);
                VarHandle.storeStoreFence();
                return f0Var;
            default:
                k[] kVarArr2 = new k[8];
                while (i3 < 8) {
                    kVarArr2[i3] = new l(1);
                    i3++;
                }
                return new f(fVar, kVarArr2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f9666c) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return this.f9667f.remove(entry.getKey(), entry.getValue());
            default:
                s0.f fVar = this.f9667f;
                if (!fVar.containsKey(obj)) {
                    return false;
                }
                fVar.remove(obj);
                return true;
        }
    }
}
