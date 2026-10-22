package ia;

import ia.AbstractC4182b;
import java.util.NoSuchElementException;

/* renamed from: ia.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4181a extends C4186f {

    /* renamed from: d, reason: collision with root package name */
    public final int f33081d;

    /* renamed from: e, reason: collision with root package name */
    public final int f33082e;

    /* renamed from: ia.a$b */
    public class b implements AbstractC4182b.a {

        /* renamed from: a, reason: collision with root package name */
        public int f33083a;

        /* renamed from: b, reason: collision with root package name */
        public final int f33084b;

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f33083a < this.f33084b;
        }

        @Override // ia.AbstractC4182b.a
        public byte nextByte() {
            int i10 = this.f33083a;
            if (i10 >= this.f33084b) {
                throw new NoSuchElementException();
            }
            byte[] bArr = C4181a.this.f33099b;
            this.f33083a = i10 + 1;
            return bArr[i10];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public b() {
            int iH = C4181a.this.H();
            this.f33083a = iH;
            this.f33084b = iH + C4181a.this.size();
        }
    }

    public C4181a(byte[] bArr, int i10, int i11) {
        super(bArr);
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append("Offset too small: ");
            sb2.append(i10);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i11 < 0) {
            StringBuilder sb3 = new StringBuilder(29);
            sb3.append("Length too small: ");
            sb3.append(i10);
            throw new IllegalArgumentException(sb3.toString());
        }
        if (i10 + i11 <= bArr.length) {
            this.f33081d = i10;
            this.f33082e = i11;
            return;
        }
        StringBuilder sb4 = new StringBuilder(48);
        sb4.append("Offset+Length too large: ");
        sb4.append(i10);
        sb4.append("+");
        sb4.append(i11);
        throw new IllegalArgumentException(sb4.toString());
    }

    @Override // ia.C4186f
    public byte D(int i10) {
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(28);
            sb2.append("Index too small: ");
            sb2.append(i10);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        if (i10 < size()) {
            return this.f33099b[this.f33081d + i10];
        }
        int size = size();
        StringBuilder sb3 = new StringBuilder(41);
        sb3.append("Index too large: ");
        sb3.append(i10);
        sb3.append(", ");
        sb3.append(size);
        throw new ArrayIndexOutOfBoundsException(sb3.toString());
    }

    @Override // ia.C4186f
    public int H() {
        return this.f33081d;
    }

    @Override // ia.C4186f, ia.AbstractC4182b
    public void l(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.f33099b, H() + i10, bArr, i11, i12);
    }

    @Override // ia.C4186f, ia.AbstractC4182b, java.lang.Iterable
    /* renamed from: p */
    public AbstractC4182b.a iterator() {
        return new b();
    }

    @Override // ia.C4186f, ia.AbstractC4182b
    public int size() {
        return this.f33082e;
    }
}
