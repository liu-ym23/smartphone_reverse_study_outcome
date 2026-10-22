package g9;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public final class f extends AbstractList implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public int f4504a;
    public Object b;

    public static /* synthetic */ void b(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i == 2 || i == 3) {
            objArr[1] = "iterator";
        } else if (i == 5 || i == 6 || i == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        int i = this.f4504a;
        if (i == 0) {
            this.b = obj;
        } else if (i == 1) {
            this.b = new Object[]{this.b, obj};
        } else {
            Object[] objArr = (Object[]) this.b;
            int length = objArr.length;
            if (i >= length) {
                int iB = androidx.constraintlayout.core.dsl.a.b(length, 3, 2, 1);
                int i6 = i + 1;
                if (iB < i6) {
                    iB = i6;
                }
                Object[] objArr2 = new Object[iB];
                this.b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.f4504a] = obj;
        }
        this.f4504a++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.b = null;
        this.f4504a = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i6;
        if (i >= 0 && i < (i6 = this.f4504a)) {
            return i6 == 1 ? this.b : ((Object[]) this.b)[i];
        }
        StringBuilder sbU = B7.a.u(i, "Index: ", ", Size: ");
        sbU.append(this.f4504a);
        throw new IndexOutOfBoundsException(sbU.toString());
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        int i = this.f4504a;
        if (i == 0) {
            return d.f4502a;
        }
        if (i == 1) {
            return new e(this);
        }
        Iterator it = super.iterator();
        if (it != null) {
            return it;
        }
        b(3);
        throw null;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        int i6;
        Object obj;
        if (i < 0 || i >= (i6 = this.f4504a)) {
            StringBuilder sbU = B7.a.u(i, "Index: ", ", Size: ");
            sbU.append(this.f4504a);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        if (i6 == 1) {
            obj = this.b;
            this.b = null;
        } else {
            Object[] objArr = (Object[]) this.b;
            Object obj2 = objArr[i];
            if (i6 == 2) {
                this.b = objArr[1 - i];
            } else {
                int i10 = (i6 - i) - 1;
                if (i10 > 0) {
                    System.arraycopy(objArr, i + 1, objArr, i, i10);
                }
                objArr[this.f4504a - 1] = null;
            }
            obj = obj2;
        }
        this.f4504a--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int i6;
        if (i < 0 || i >= (i6 = this.f4504a)) {
            StringBuilder sbU = B7.a.u(i, "Index: ", ", Size: ");
            sbU.append(this.f4504a);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        if (i6 == 1) {
            Object obj2 = this.b;
            this.b = obj;
            return obj2;
        }
        Object[] objArr = (Object[]) this.b;
        Object obj3 = objArr[i];
        objArr[i] = obj;
        return obj3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4504a;
    }

    @Override // java.util.List
    public final void sort(Comparator comparator) {
        int i = this.f4504a;
        if (i >= 2) {
            Arrays.sort((Object[]) this.b, 0, i, comparator);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        if (objArr == null) {
            b(4);
            throw null;
        }
        int length = objArr.length;
        int i = this.f4504a;
        if (i == 1) {
            if (length == 0) {
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), 1);
                objArr2[0] = this.b;
                return objArr2;
            }
            objArr[0] = this.b;
        } else {
            if (length < i) {
                Object[] objArrCopyOf = Arrays.copyOf((Object[]) this.b, i, objArr.getClass());
                if (objArrCopyOf != null) {
                    return objArrCopyOf;
                }
                b(6);
                throw null;
            }
            if (i != 0) {
                System.arraycopy(this.b, 0, objArr, 0, i);
            }
        }
        int i6 = this.f4504a;
        if (length > i6) {
            objArr[i6] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i6;
        if (i >= 0 && i <= (i6 = this.f4504a)) {
            if (i6 == 0) {
                this.b = obj;
            } else if (i6 == 1 && i == 0) {
                this.b = new Object[]{obj, this.b};
            } else {
                Object[] objArr = new Object[i6 + 1];
                if (i6 == 1) {
                    objArr[0] = this.b;
                } else {
                    Object[] objArr2 = (Object[]) this.b;
                    System.arraycopy(objArr2, 0, objArr, 0, i);
                    System.arraycopy(objArr2, i, objArr, i + 1, this.f4504a - i);
                }
                objArr[i] = obj;
                this.b = objArr;
            }
            this.f4504a++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbU = B7.a.u(i, "Index: ", ", Size: ");
        sbU.append(this.f4504a);
        throw new IndexOutOfBoundsException(sbU.toString());
    }
}
