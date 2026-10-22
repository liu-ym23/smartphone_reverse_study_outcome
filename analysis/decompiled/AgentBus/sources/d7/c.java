package d7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class c implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2948f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f2949g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f2950h;

    public c(Object[] objArr) {
        q7.k.e(objArr, "array");
        this.f2950h = objArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f2948f) {
            case 0:
                if (this.f2949g < ((f) this.f2950h).a()) {
                }
                break;
            default:
                if (this.f2949g < ((Object[]) this.f2950h).length) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f2948f) {
            case 0:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                f fVar = (f) this.f2950h;
                int i2 = this.f2949g;
                this.f2949g = i2 + 1;
                return fVar.get(i2);
            default:
                try {
                    Object[] objArr = (Object[]) this.f2950h;
                    int i10 = this.f2949g;
                    this.f2949g = i10 + 1;
                    return objArr[i10];
                } catch (ArrayIndexOutOfBoundsException e10) {
                    this.f2949g--;
                    throw new NoSuchElementException(e10.getMessage());
                }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f2948f) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public c(f fVar) {
        this.f2950h = fVar;
    }
}
