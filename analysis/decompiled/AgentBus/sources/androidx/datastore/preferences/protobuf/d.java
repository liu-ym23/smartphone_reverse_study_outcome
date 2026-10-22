package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class d implements Iterator {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f837f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f838g = 0;

    /* renamed from: h, reason: collision with root package name */
    public final int f839h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Iterable f840i;

    public d(com.google.protobuf.k kVar) {
        this.f840i = kVar;
        this.f839h = kVar.size();
    }

    public byte a() {
        try {
            byte[] bArr = ((f9.u) this.f840i).f3600g;
            int i2 = this.f838g;
            this.f838g = i2 + 1;
            return bArr[i2];
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f837f) {
            case 0:
                if (this.f838g < this.f839h) {
                }
                break;
            case 1:
                if (this.f838g < this.f839h) {
                }
                break;
            case 2:
                if (this.f838g < this.f839h) {
                }
                break;
            default:
                if (this.f838g < this.f839h) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f837f) {
            case 0:
                int i2 = this.f838g;
                if (i2 >= this.f839h) {
                    throw new NoSuchElementException();
                }
                this.f838g = i2 + 1;
                return Byte.valueOf(((g) this.f840i).k(i2));
            case 1:
                int i10 = this.f838g;
                if (i10 >= this.f839h) {
                    throw new NoSuchElementException();
                }
                this.f838g = i10 + 1;
                return Byte.valueOf(((com.google.crypto.tink.shaded.protobuf.g) this.f840i).l(i10));
            case 2:
                int i11 = this.f838g;
                if (i11 >= this.f839h) {
                    throw new NoSuchElementException();
                }
                this.f838g = i11 + 1;
                return Byte.valueOf(((com.google.protobuf.k) this.f840i).l(i11));
            default:
                return Byte.valueOf(a());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f837f) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                throw new UnsupportedOperationException();
            case 2:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public d(com.google.crypto.tink.shaded.protobuf.g gVar) {
        this.f840i = gVar;
        this.f839h = gVar.size();
    }

    public d(g gVar) {
        this.f840i = gVar;
        this.f839h = gVar.size();
    }

    public d(f9.u uVar) {
        this.f840i = uVar;
        this.f839h = uVar.f3600g.length;
    }
}
