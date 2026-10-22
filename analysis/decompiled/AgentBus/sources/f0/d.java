package f0;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f3330h = 1;

    /* renamed from: i, reason: collision with root package name */
    public final Object f3331i;

    public d(Object[] objArr, int i2, int i10) {
        super(i2, i10);
        this.f3331i = objArr;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f3330h) {
            case 0:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object[] objArr = (Object[]) this.f3331i;
                int i2 = this.f3326f;
                this.f3326f = i2 + 1;
                return objArr[i2];
            default:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.f3326f++;
                return this.f3331i;
        }
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f3330h) {
            case 0:
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                Object[] objArr = (Object[]) this.f3331i;
                int i2 = this.f3326f - 1;
                this.f3326f = i2;
                return objArr[i2];
            default:
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.f3326f--;
                return this.f3331i;
        }
    }

    public d(int i2, Object obj) {
        super(i2, 1);
        this.f3331i = obj;
    }
}
