package ea;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class f extends AbstractList implements RandomAccess {

    /* renamed from: f, reason: collision with root package name */
    public int f3233f;

    /* renamed from: g, reason: collision with root package name */
    public Object f3234g;

    public static /* synthetic */ void a(int i2) {
        String str = (i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6 || i2 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : 3];
        switch (i2) {
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
        if (i2 == 2 || i2 == 3) {
            objArr[1] = "iterator";
        } else if (i2 == 5 || i2 == 6 || i2 == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i2) {
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
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 2 && i2 != 3 && i2 != 5 && i2 != 6 && i2 != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        int i2 = this.f3233f;
        if (i2 == 0) {
            this.f3234g = obj;
        } else if (i2 == 1) {
            this.f3234g = new Object[]{this.f3234g, obj};
        } else {
            Object[] objArr = (Object[]) this.f3234g;
            int length = objArr.length;
            if (i2 >= length) {
                int i10 = ((length * 3) / 2) + 1;
                int i11 = i2 + 1;
                if (i10 < i11) {
                    i10 = i11;
                }
                Object[] objArr2 = new Object[i10];
                this.f3234g = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.f3233f] = obj;
        }
        this.f3233f++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f3234g = null;
        this.f3233f = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        int i10;
        if (i2 >= 0 && i2 < (i10 = this.f3233f)) {
            return i10 == 1 ? this.f3234g : ((Object[]) this.f3234g)[i2];
        }
        StringBuilder sbN = a1.a.n(i2, "Index: ", ", Size: ");
        sbN.append(this.f3233f);
        throw new IndexOutOfBoundsException(sbN.toString());
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        int i2 = this.f3233f;
        if (i2 == 0) {
            return d.f3229f;
        }
        if (i2 == 1) {
            return new e(this);
        }
        Iterator it = super.iterator();
        if (it != null) {
            return it;
        }
        a(3);
        throw null;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        int i10;
        Object obj;
        if (i2 < 0 || i2 >= (i10 = this.f3233f)) {
            StringBuilder sbN = a1.a.n(i2, "Index: ", ", Size: ");
            sbN.append(this.f3233f);
            throw new IndexOutOfBoundsException(sbN.toString());
        }
        if (i10 == 1) {
            obj = this.f3234g;
            this.f3234g = null;
        } else {
            Object[] objArr = (Object[]) this.f3234g;
            Object obj2 = objArr[i2];
            if (i10 == 2) {
                this.f3234g = objArr[1 - i2];
            } else {
                int i11 = (i10 - i2) - 1;
                if (i11 > 0) {
                    System.arraycopy(objArr, i2 + 1, objArr, i2, i11);
                }
                objArr[this.f3233f - 1] = null;
            }
            obj = obj2;
        }
        this.f3233f--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        int i10;
        if (i2 < 0 || i2 >= (i10 = this.f3233f)) {
            StringBuilder sbN = a1.a.n(i2, "Index: ", ", Size: ");
            sbN.append(this.f3233f);
            throw new IndexOutOfBoundsException(sbN.toString());
        }
        if (i10 == 1) {
            Object obj2 = this.f3234g;
            this.f3234g = obj;
            return obj2;
        }
        Object[] objArr = (Object[]) this.f3234g;
        Object obj3 = objArr[i2];
        objArr[i2] = obj;
        return obj3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3233f;
    }

    @Override // java.util.List
    public final void sort(Comparator comparator) {
        int i2 = this.f3233f;
        if (i2 >= 2) {
            Arrays.sort((Object[]) this.f3234g, 0, i2, comparator);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        if (objArr == null) {
            a(4);
            throw null;
        }
        int length = objArr.length;
        int i2 = this.f3233f;
        if (i2 == 1) {
            if (length == 0) {
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), 1);
                objArr2[0] = this.f3234g;
                return objArr2;
            }
            objArr[0] = this.f3234g;
        } else {
            if (length < i2) {
                Object[] objArrCopyOf = Arrays.copyOf((Object[]) this.f3234g, i2, objArr.getClass());
                if (objArrCopyOf != null) {
                    return objArrCopyOf;
                }
                a(6);
                throw null;
            }
            if (i2 != 0) {
                System.arraycopy(this.f3234g, 0, objArr, 0, i2);
            }
        }
        int i10 = this.f3233f;
        if (length > i10) {
            objArr[i10] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i10;
        if (i2 >= 0 && i2 <= (i10 = this.f3233f)) {
            if (i10 == 0) {
                this.f3234g = obj;
            } else if (i10 == 1 && i2 == 0) {
                this.f3234g = new Object[]{obj, this.f3234g};
            } else {
                Object[] objArr = new Object[i10 + 1];
                if (i10 == 1) {
                    objArr[0] = this.f3234g;
                } else {
                    Object[] objArr2 = (Object[]) this.f3234g;
                    System.arraycopy(objArr2, 0, objArr, 0, i2);
                    System.arraycopy(objArr2, i2, objArr, i2 + 1, this.f3233f - i2);
                }
                objArr[i2] = obj;
                this.f3234g = objArr;
            }
            this.f3233f++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbN = a1.a.n(i2, "Index: ", ", Size: ");
        sbN.append(this.f3233f);
        throw new IndexOutOfBoundsException(sbN.toString());
    }
}
