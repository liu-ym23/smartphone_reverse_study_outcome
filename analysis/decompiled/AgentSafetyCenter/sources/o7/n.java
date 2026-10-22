package o7;

import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends AbstractMap implements Serializable {

    /* renamed from: m, reason: collision with root package name */
    public static final a9.n f9273m = new a9.n(4);

    /* renamed from: f, reason: collision with root package name */
    public final boolean f9275f;

    /* renamed from: g, reason: collision with root package name */
    public m f9276g;

    /* renamed from: j, reason: collision with root package name */
    public final m f9278j;

    /* renamed from: k, reason: collision with root package name */
    public l f9279k;

    /* renamed from: l, reason: collision with root package name */
    public l f9280l;

    /* renamed from: h, reason: collision with root package name */
    public int f9277h = 0;
    public int i = 0;

    /* renamed from: c, reason: collision with root package name */
    public final Comparator f9274c = f9273m;

    public n(boolean z10) {
        this.f9275f = z10;
        m mVar = new m();
        mVar.f9269j = null;
        mVar.f9270k = z10;
        mVar.i = mVar;
        mVar.f9268h = mVar;
        VarHandle.storeStoreFence();
        this.f9278j = mVar;
    }

    public final m a(Object obj, boolean z10) {
        int iCompareTo;
        m mVar;
        m mVar2 = this.f9276g;
        a9.n nVar = f9273m;
        Comparator comparator = this.f9274c;
        if (mVar2 != null) {
            Comparable comparable = comparator == nVar ? (Comparable) obj : null;
            while (true) {
                Object obj2 = mVar2.f9269j;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (iCompareTo == 0) {
                    return mVar2;
                }
                m mVar3 = iCompareTo < 0 ? mVar2.f9266f : mVar2.f9267g;
                if (mVar3 == null) {
                    break;
                }
                mVar2 = mVar3;
            }
        } else {
            iCompareTo = 0;
        }
        m mVar4 = mVar2;
        if (!z10) {
            return null;
        }
        m mVar5 = this.f9278j;
        if (mVar4 != null) {
            mVar = new m(this.f9275f, mVar4, obj, mVar5, mVar5.i);
            if (iCompareTo < 0) {
                mVar4.f9266f = mVar;
            } else {
                mVar4.f9267g = mVar;
            }
            b(mVar4, true);
        } else {
            if (comparator == nVar && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            mVar = new m(this.f9275f, mVar4, obj, mVar5, mVar5.i);
            this.f9276g = mVar;
        }
        this.f9277h++;
        this.i++;
        return mVar;
    }

    public final void b(m mVar, boolean z10) {
        while (mVar != null) {
            m mVar2 = mVar.f9266f;
            m mVar3 = mVar.f9267g;
            int i = mVar2 != null ? mVar2.f9272m : 0;
            int i3 = mVar3 != null ? mVar3.f9272m : 0;
            int i10 = i - i3;
            if (i10 == -2) {
                m mVar4 = mVar3.f9266f;
                m mVar5 = mVar3.f9267g;
                int i11 = (mVar4 != null ? mVar4.f9272m : 0) - (mVar5 != null ? mVar5.f9272m : 0);
                if (i11 == -1 || (i11 == 0 && !z10)) {
                    e(mVar);
                } else {
                    f(mVar3);
                    e(mVar);
                }
                if (z10) {
                    return;
                }
            } else if (i10 == 2) {
                m mVar6 = mVar2.f9266f;
                m mVar7 = mVar2.f9267g;
                int i12 = (mVar6 != null ? mVar6.f9272m : 0) - (mVar7 != null ? mVar7.f9272m : 0);
                if (i12 == 1 || (i12 == 0 && !z10)) {
                    f(mVar);
                } else {
                    e(mVar2);
                    f(mVar);
                }
                if (z10) {
                    return;
                }
            } else if (i10 == 0) {
                mVar.f9272m = i + 1;
                if (z10) {
                    return;
                }
            } else {
                mVar.f9272m = Math.max(i, i3) + 1;
                if (!z10) {
                    return;
                }
            }
            mVar = mVar.f9265c;
        }
    }

    public final void c(m mVar, boolean z10) {
        m mVar2;
        m mVar3;
        int i;
        if (z10) {
            m mVar4 = mVar.i;
            mVar4.f9268h = mVar.f9268h;
            mVar.f9268h.i = mVar4;
        }
        m mVar5 = mVar.f9266f;
        m mVar6 = mVar.f9267g;
        m mVar7 = mVar.f9265c;
        int i3 = 0;
        if (mVar5 == null || mVar6 == null) {
            if (mVar5 != null) {
                d(mVar, mVar5);
                mVar.f9266f = null;
            } else if (mVar6 != null) {
                d(mVar, mVar6);
                mVar.f9267g = null;
            } else {
                d(mVar, null);
            }
            b(mVar7, false);
            this.f9277h--;
            this.i++;
            return;
        }
        if (mVar5.f9272m > mVar6.f9272m) {
            m mVar8 = mVar5.f9267g;
            while (true) {
                m mVar9 = mVar8;
                mVar3 = mVar5;
                mVar5 = mVar9;
                if (mVar5 == null) {
                    break;
                } else {
                    mVar8 = mVar5.f9267g;
                }
            }
        } else {
            m mVar10 = mVar6.f9266f;
            while (true) {
                mVar2 = mVar6;
                mVar6 = mVar10;
                if (mVar6 == null) {
                    break;
                } else {
                    mVar10 = mVar6.f9266f;
                }
            }
            mVar3 = mVar2;
        }
        c(mVar3, false);
        m mVar11 = mVar.f9266f;
        if (mVar11 != null) {
            i = mVar11.f9272m;
            mVar3.f9266f = mVar11;
            mVar11.f9265c = mVar3;
            mVar.f9266f = null;
        } else {
            i = 0;
        }
        m mVar12 = mVar.f9267g;
        if (mVar12 != null) {
            i3 = mVar12.f9272m;
            mVar3.f9267g = mVar12;
            mVar12.f9265c = mVar3;
            mVar.f9267g = null;
        }
        mVar3.f9272m = Math.max(i, i3) + 1;
        d(mVar, mVar3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f9276g = null;
        this.f9277h = 0;
        this.i++;
        m mVar = this.f9278j;
        mVar.i = mVar;
        mVar.f9268h = mVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        m mVarA = null;
        if (obj != null) {
            try {
                mVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return mVarA != null;
    }

    public final void d(m mVar, m mVar2) {
        m mVar3 = mVar.f9265c;
        mVar.f9265c = null;
        if (mVar2 != null) {
            mVar2.f9265c = mVar3;
        }
        if (mVar3 == null) {
            this.f9276g = mVar2;
        } else if (mVar3.f9266f == mVar) {
            mVar3.f9266f = mVar2;
        } else {
            mVar3.f9267g = mVar2;
        }
    }

    public final void e(m mVar) {
        m mVar2 = mVar.f9266f;
        m mVar3 = mVar.f9267g;
        m mVar4 = mVar3.f9266f;
        m mVar5 = mVar3.f9267g;
        mVar.f9267g = mVar4;
        if (mVar4 != null) {
            mVar4.f9265c = mVar;
        }
        d(mVar, mVar3);
        mVar3.f9266f = mVar;
        mVar.f9265c = mVar3;
        int iMax = Math.max(mVar2 != null ? mVar2.f9272m : 0, mVar4 != null ? mVar4.f9272m : 0) + 1;
        mVar.f9272m = iMax;
        mVar3.f9272m = Math.max(iMax, mVar5 != null ? mVar5.f9272m : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        l lVar = this.f9279k;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this, 0);
        this.f9279k = lVar2;
        return lVar2;
    }

    public final void f(m mVar) {
        m mVar2 = mVar.f9266f;
        m mVar3 = mVar.f9267g;
        m mVar4 = mVar2.f9266f;
        m mVar5 = mVar2.f9267g;
        mVar.f9266f = mVar5;
        if (mVar5 != null) {
            mVar5.f9265c = mVar;
        }
        d(mVar, mVar2);
        mVar2.f9267g = mVar;
        mVar.f9265c = mVar2;
        int iMax = Math.max(mVar3 != null ? mVar3.f9272m : 0, mVar5 != null ? mVar5.f9272m : 0) + 1;
        mVar.f9272m = iMax;
        mVar2.f9272m = Math.max(iMax, mVar4 != null ? mVar4.f9272m : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        m mVarA;
        if (obj != null) {
            try {
                mVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            mVarA = null;
        }
        if (mVarA != null) {
            return mVarA.f9271l;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        l lVar = this.f9280l;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this, 1);
        this.f9280l = lVar2;
        return lVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            g5.f.g("key == null");
            return null;
        }
        if (obj2 == null && !this.f9275f) {
            g5.f.g("value == null");
            return null;
        }
        m mVarA = a(obj, true);
        Object obj3 = mVarA.f9271l;
        mVarA.f9271l = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        m mVarA;
        if (obj != null) {
            try {
                mVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            mVarA = null;
        }
        if (mVarA != null) {
            c(mVarA, true);
        }
        if (mVarA != null) {
            return mVarA.f9271l;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f9277h;
    }
}
