package H8;

import com.google.protobuf.ByteString;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class q implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f779a = 0;
    public int b = 0;
    public final int c;
    public final /* synthetic */ Iterable d;

    public q(ByteString byteString) {
        this.d = byteString;
        this.c = byteString.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f779a) {
            case 0:
                if (this.b < this.c) {
                }
                break;
            default:
                if (this.b < this.c) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f779a) {
            case 0:
                return Byte.valueOf(nextByte());
            default:
                int i = this.b;
                if (i >= this.c) {
                    throw new NoSuchElementException();
                }
                this.b = i + 1;
                return Byte.valueOf(((ByteString) this.d).h(i));
        }
    }

    public byte nextByte() {
        try {
            byte[] bArr = ((r) this.d).b;
            int i = this.b;
            this.b = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f779a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public q(r rVar) {
        this.d = rVar;
        this.c = rVar.b.length;
    }
}
