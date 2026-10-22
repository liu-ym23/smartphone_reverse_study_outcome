package ea;

import ba.r;
import d7.e0;
import d7.n;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import q7.z;

/* loaded from: classes.dex */
public final class h extends AbstractSet {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f3237h = 0;

    /* renamed from: f, reason: collision with root package name */
    public Object f3238f;

    /* renamed from: g, reason: collision with root package name */
    public int f3239g;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        Object[] objArr;
        int i2 = this.f3239g;
        if (i2 == 0) {
            this.f3238f = obj;
        } else if (i2 == 1) {
            if (q7.k.a(this.f3238f, obj)) {
                return false;
            }
            this.f3238f = new Object[]{this.f3238f, obj};
        } else if (i2 < 5) {
            Object obj2 = this.f3238f;
            q7.k.c(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr2 = (Object[]) obj2;
            if (n.U(objArr2, obj)) {
                return false;
            }
            int i10 = this.f3239g;
            if (i10 == 4) {
                Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
                q7.k.e(objArrCopyOf, "elements");
                LinkedHashSet linkedHashSet = new LinkedHashSet(e0.S(objArrCopyOf.length));
                n.v0(objArrCopyOf, linkedHashSet);
                linkedHashSet.add(obj);
                objArr = linkedHashSet;
            } else {
                Object[] objArrCopyOf2 = Arrays.copyOf(objArr2, i10 + 1);
                q7.k.d(objArrCopyOf2, "copyOf(this, newSize)");
                objArrCopyOf2[objArrCopyOf2.length - 1] = obj;
                objArr = objArrCopyOf2;
            }
            this.f3238f = objArr;
        } else {
            Object obj3 = this.f3238f;
            q7.k.c(obj3, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!z.b(obj3).add(obj)) {
                return false;
            }
        }
        this.f3239g++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f3238f = null;
        this.f3239g = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        int i2 = this.f3239g;
        if (i2 == 0) {
            return false;
        }
        if (i2 == 1) {
            return q7.k.a(this.f3238f, obj);
        }
        if (i2 < 5) {
            Object obj2 = this.f3238f;
            q7.k.c(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return n.U((Object[]) obj2, obj);
        }
        Object obj3 = this.f3238f;
        q7.k.c(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        int i2 = this.f3239g;
        if (i2 == 0) {
            return Collections.EMPTY_SET.iterator();
        }
        if (i2 == 1) {
            return new r(1, this.f3238f);
        }
        if (i2 < 5) {
            Object obj = this.f3238f;
            q7.k.c(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new g((Object[]) obj);
        }
        Object obj2 = this.f3238f;
        q7.k.c(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return z.b(obj2).iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f3239g;
    }
}
