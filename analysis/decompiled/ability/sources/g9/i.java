package g9;

import D7.AbstractC0220l;
import D7.q;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.p;

/* loaded from: classes4.dex */
public final class i extends AbstractC0220l {
    public static final /* synthetic */ int c = 0;

    /* renamed from: a, reason: collision with root package name */
    public Object f4507a;
    public int b;

    public i(int i) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.util.AbstractCollection, java.util.AbstractSet, java.util.LinkedHashSet] */
    @Override // D7.AbstractC0220l, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        Object[] objArr;
        if (size() == 0) {
            this.f4507a = obj;
        } else if (size() == 1) {
            if (kotlin.jvm.internal.k.b(this.f4507a, obj)) {
                return false;
            }
            this.f4507a = new Object[]{this.f4507a, obj};
        } else if (size() < 5) {
            Object obj2 = this.f4507a;
            kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr2 = (Object[]) obj2;
            if (q.N(obj, objArr2)) {
                return false;
            }
            if (size() == 4) {
                Object[] elements = Arrays.copyOf(objArr2, objArr2.length);
                kotlin.jvm.internal.k.f(elements, "elements");
                ?? linkedHashSet = new LinkedHashSet(kotlin.collections.a.P(elements.length));
                q.F0(elements, linkedHashSet);
                linkedHashSet.add(obj);
                objArr = linkedHashSet;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr2, size() + 1);
                kotlin.jvm.internal.k.e(objArrCopyOf, "copyOf(...)");
                objArrCopyOf[objArrCopyOf.length - 1] = obj;
                objArr = objArrCopyOf;
            }
            this.f4507a = objArr;
        } else {
            Object obj3 = this.f4507a;
            kotlin.jvm.internal.k.d(obj3, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!p.d(obj3).add(obj)) {
                return false;
            }
        }
        this.b = size() + 1;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f4507a = null;
        this.b = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return kotlin.jvm.internal.k.b(this.f4507a, obj);
        }
        if (size() < 5) {
            Object obj2 = this.f4507a;
            kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return q.N(obj, (Object[]) obj2);
        }
        Object obj3 = this.f4507a;
        kotlin.jvm.internal.k.d(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    @Override // D7.AbstractC0220l
    public final int getSize() {
        return this.b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        if (size() == 0) {
            return Collections.EMPTY_SET.iterator();
        }
        if (size() == 1) {
            return new h(this.f4507a, 0);
        }
        if (size() < 5) {
            Object obj = this.f4507a;
            kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new g((Object[]) obj);
        }
        Object obj2 = this.f4507a;
        kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return p.d(obj2).iterator();
    }
}
