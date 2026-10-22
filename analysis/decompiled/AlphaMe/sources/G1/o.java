package G1;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

/* loaded from: classes.dex */
public final class o extends AbstractMap implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public static final A.f f620i = new A.f(7);

    /* renamed from: a, reason: collision with root package name */
    public final Comparator f621a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f622b;

    /* renamed from: c, reason: collision with root package name */
    public n f623c;

    /* renamed from: d, reason: collision with root package name */
    public int f624d;

    /* renamed from: e, reason: collision with root package name */
    public int f625e;

    /* renamed from: f, reason: collision with root package name */
    public final n f626f;

    /* renamed from: g, reason: collision with root package name */
    public l f627g;

    /* renamed from: h, reason: collision with root package name */
    public l f628h;

    public o(boolean z4) {
        A.f fVar = f620i;
        this.f624d = 0;
        this.f625e = 0;
        this.f621a = fVar;
        this.f622b = z4;
        this.f626f = new n(z4);
    }

    public final n a(Object obj, boolean z4) {
        int iCompareTo;
        n nVar;
        n nVar2 = this.f623c;
        A.f fVar = f620i;
        Comparator comparator = this.f621a;
        if (nVar2 != null) {
            Comparable comparable = comparator == fVar ? (Comparable) obj : null;
            while (true) {
                Object obj2 = nVar2.f616f;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (iCompareTo == 0) {
                    return nVar2;
                }
                n nVar3 = iCompareTo < 0 ? nVar2.f612b : nVar2.f613c;
                if (nVar3 == null) {
                    break;
                }
                nVar2 = nVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z4) {
            return null;
        }
        n nVar4 = this.f626f;
        if (nVar2 != null) {
            nVar = new n(this.f622b, nVar2, obj, nVar4, nVar4.f615e);
            if (iCompareTo < 0) {
                nVar2.f612b = nVar;
            } else {
                nVar2.f613c = nVar;
            }
            b(nVar2, true);
        } else {
            if (comparator == fVar && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            nVar = new n(this.f622b, nVar2, obj, nVar4, nVar4.f615e);
            this.f623c = nVar;
        }
        this.f624d++;
        this.f625e++;
        return nVar;
    }

    public final void b(n nVar, boolean z4) {
        while (nVar != null) {
            n nVar2 = nVar.f612b;
            n nVar3 = nVar.f613c;
            int i4 = nVar2 != null ? nVar2.f619i : 0;
            int i5 = nVar3 != null ? nVar3.f619i : 0;
            int i6 = i4 - i5;
            if (i6 == -2) {
                n nVar4 = nVar3.f612b;
                n nVar5 = nVar3.f613c;
                int i7 = (nVar4 != null ? nVar4.f619i : 0) - (nVar5 != null ? nVar5.f619i : 0);
                if (i7 == -1 || (i7 == 0 && !z4)) {
                    e(nVar);
                } else {
                    f(nVar3);
                    e(nVar);
                }
                if (z4) {
                    return;
                }
            } else if (i6 == 2) {
                n nVar6 = nVar2.f612b;
                n nVar7 = nVar2.f613c;
                int i8 = (nVar6 != null ? nVar6.f619i : 0) - (nVar7 != null ? nVar7.f619i : 0);
                if (i8 == 1 || (i8 == 0 && !z4)) {
                    f(nVar);
                } else {
                    e(nVar2);
                    f(nVar);
                }
                if (z4) {
                    return;
                }
            } else if (i6 == 0) {
                nVar.f619i = i4 + 1;
                if (z4) {
                    return;
                }
            } else {
                nVar.f619i = Math.max(i4, i5) + 1;
                if (!z4) {
                    return;
                }
            }
            nVar = nVar.f611a;
        }
    }

    public final void c(n nVar, boolean z4) {
        n nVar2;
        n nVar3;
        int i4;
        if (z4) {
            n nVar4 = nVar.f615e;
            nVar4.f614d = nVar.f614d;
            nVar.f614d.f615e = nVar4;
        }
        n nVar5 = nVar.f612b;
        n nVar6 = nVar.f613c;
        n nVar7 = nVar.f611a;
        int i5 = 0;
        if (nVar5 == null || nVar6 == null) {
            if (nVar5 != null) {
                d(nVar, nVar5);
                nVar.f612b = null;
            } else if (nVar6 != null) {
                d(nVar, nVar6);
                nVar.f613c = null;
            } else {
                d(nVar, null);
            }
            b(nVar7, false);
            this.f624d--;
            this.f625e++;
            return;
        }
        if (nVar5.f619i > nVar6.f619i) {
            n nVar8 = nVar5.f613c;
            while (true) {
                n nVar9 = nVar8;
                nVar3 = nVar5;
                nVar5 = nVar9;
                if (nVar5 == null) {
                    break;
                } else {
                    nVar8 = nVar5.f613c;
                }
            }
        } else {
            n nVar10 = nVar6.f612b;
            while (true) {
                nVar2 = nVar6;
                nVar6 = nVar10;
                if (nVar6 == null) {
                    break;
                } else {
                    nVar10 = nVar6.f612b;
                }
            }
            nVar3 = nVar2;
        }
        c(nVar3, false);
        n nVar11 = nVar.f612b;
        if (nVar11 != null) {
            i4 = nVar11.f619i;
            nVar3.f612b = nVar11;
            nVar11.f611a = nVar3;
            nVar.f612b = null;
        } else {
            i4 = 0;
        }
        n nVar12 = nVar.f613c;
        if (nVar12 != null) {
            i5 = nVar12.f619i;
            nVar3.f613c = nVar12;
            nVar12.f611a = nVar3;
            nVar.f613c = null;
        }
        nVar3.f619i = Math.max(i4, i5) + 1;
        d(nVar, nVar3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f623c = null;
        this.f624d = 0;
        this.f625e++;
        n nVar = this.f626f;
        nVar.f615e = nVar;
        nVar.f614d = nVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        n nVarA = null;
        if (obj != null) {
            try {
                nVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return nVarA != null;
    }

    public final void d(n nVar, n nVar2) {
        n nVar3 = nVar.f611a;
        nVar.f611a = null;
        if (nVar2 != null) {
            nVar2.f611a = nVar3;
        }
        if (nVar3 == null) {
            this.f623c = nVar2;
        } else if (nVar3.f612b == nVar) {
            nVar3.f612b = nVar2;
        } else {
            nVar3.f613c = nVar2;
        }
    }

    public final void e(n nVar) {
        n nVar2 = nVar.f612b;
        n nVar3 = nVar.f613c;
        n nVar4 = nVar3.f612b;
        n nVar5 = nVar3.f613c;
        nVar.f613c = nVar4;
        if (nVar4 != null) {
            nVar4.f611a = nVar;
        }
        d(nVar, nVar3);
        nVar3.f612b = nVar;
        nVar.f611a = nVar3;
        int iMax = Math.max(nVar2 != null ? nVar2.f619i : 0, nVar4 != null ? nVar4.f619i : 0) + 1;
        nVar.f619i = iMax;
        nVar3.f619i = Math.max(iMax, nVar5 != null ? nVar5.f619i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        l lVar = this.f627g;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this, 0);
        this.f627g = lVar2;
        return lVar2;
    }

    public final void f(n nVar) {
        n nVar2 = nVar.f612b;
        n nVar3 = nVar.f613c;
        n nVar4 = nVar2.f612b;
        n nVar5 = nVar2.f613c;
        nVar.f612b = nVar5;
        if (nVar5 != null) {
            nVar5.f611a = nVar;
        }
        d(nVar, nVar2);
        nVar2.f613c = nVar;
        nVar.f611a = nVar2;
        int iMax = Math.max(nVar3 != null ? nVar3.f619i : 0, nVar5 != null ? nVar5.f619i : 0) + 1;
        nVar.f619i = iMax;
        nVar2.f619i = Math.max(iMax, nVar4 != null ? nVar4.f619i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        n nVarA;
        if (obj != null) {
            try {
                nVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            nVarA = null;
        }
        if (nVarA != null) {
            return nVarA.f618h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        l lVar = this.f628h;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this, 1);
        this.f628h = lVar2;
        return lVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.f622b) {
            throw new NullPointerException("value == null");
        }
        n nVarA = a(obj, true);
        Object obj3 = nVarA.f618h;
        nVarA.f618h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        n nVarA;
        if (obj != null) {
            try {
                nVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            nVarA = null;
        }
        if (nVarA != null) {
            c(nVarA, true);
        }
        if (nVarA != null) {
            return nVarA.f618h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f624d;
    }
}
