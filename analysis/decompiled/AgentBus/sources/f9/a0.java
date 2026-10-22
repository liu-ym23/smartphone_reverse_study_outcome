package f9;

import androidx.datastore.preferences.protobuf.h1;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class a0 extends AbstractMap {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f3524k = 0;

    /* renamed from: f, reason: collision with root package name */
    public final int f3525f;

    /* renamed from: g, reason: collision with root package name */
    public List f3526g = Collections.EMPTY_LIST;

    /* renamed from: h, reason: collision with root package name */
    public Map f3527h = Collections.EMPTY_MAP;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3528i;

    /* renamed from: j, reason: collision with root package name */
    public volatile h1 f3529j;

    public a0(int i2) {
        this.f3525f = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f3526g
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.f3526g
            java.lang.Object r2 = r2.get(r1)
            f9.e0 r2 = (f9.e0) r2
            java.lang.Comparable r2 = r2.f3548f
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L1e
            int r0 = r0 + 1
        L1c:
            int r4 = -r0
            return r4
        L1e:
            if (r2 != 0) goto L21
            return r1
        L21:
            r0 = 0
        L22:
            if (r0 > r1) goto L43
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.f3526g
            java.lang.Object r3 = r3.get(r2)
            f9.e0 r3 = (f9.e0) r3
            java.lang.Comparable r3 = r3.f3548f
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L3c
            int r2 = r2 + (-1)
            r1 = r2
            goto L22
        L3c:
            if (r3 <= 0) goto L42
            int r2 = r2 + 1
            r0 = r2
            goto L22
        L42:
            return r2
        L43:
            int r0 = r0 + 1
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.a0.a(java.lang.Comparable):int");
    }

    public final void b() {
        if (this.f3528i) {
            throw new UnsupportedOperationException();
        }
    }

    public final Iterable c() {
        return this.f3527h.isEmpty() ? d0.f3538b : this.f3527h.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.f3526g.isEmpty()) {
            this.f3526g.clear();
        }
        if (this.f3527h.isEmpty()) {
            return;
        }
        this.f3527h.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f3527h.containsKey(comparable);
    }

    public final SortedMap d() {
        b();
        if (this.f3527h.isEmpty() && !(this.f3527h instanceof TreeMap)) {
            this.f3527h = new TreeMap();
        }
        return (SortedMap) this.f3527h;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        b();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((e0) this.f3526g.get(iA)).setValue(obj);
        }
        b();
        boolean zIsEmpty = this.f3526g.isEmpty();
        int i2 = this.f3525f;
        if (zIsEmpty && !(this.f3526g instanceof ArrayList)) {
            this.f3526g = new ArrayList(i2);
        }
        int i10 = -(iA + 1);
        if (i10 >= i2) {
            return d().put(comparable, obj);
        }
        if (this.f3526g.size() == i2) {
            e0 e0Var = (e0) this.f3526g.remove(i2 - 1);
            d().put(e0Var.f3548f, e0Var.f3549g);
        }
        this.f3526g.add(i10, new e0(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f3529j == null) {
            this.f3529j = new h1(this, 2);
        }
        return this.f3529j;
    }

    public final Object f(int i2) {
        b();
        Object obj = ((e0) this.f3526g.remove(i2)).f3549g;
        if (!this.f3527h.isEmpty()) {
            Iterator it = d().entrySet().iterator();
            List list = this.f3526g;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new e0(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((e0) this.f3526g.get(iA)).f3549g : this.f3527h.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return f(iA);
        }
        if (this.f3527h.isEmpty()) {
            return null;
        }
        return this.f3527h.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f3527h.size() + this.f3526g.size();
    }
}
