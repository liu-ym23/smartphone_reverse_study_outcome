package ga;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class d implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final CharSequence f4017f;

    /* renamed from: g, reason: collision with root package name */
    public int f4018g;

    /* renamed from: h, reason: collision with root package name */
    public int f4019h;

    /* renamed from: i, reason: collision with root package name */
    public int f4020i;

    /* renamed from: j, reason: collision with root package name */
    public int f4021j;

    public d(CharSequence charSequence) {
        q7.k.e(charSequence, "string");
        this.f4017f = charSequence;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2;
        int i10;
        int i11 = this.f4018g;
        if (i11 != 0) {
            return i11 == 1;
        }
        if (this.f4021j < 0) {
            this.f4018g = 2;
            return false;
        }
        CharSequence charSequence = this.f4017f;
        int length = charSequence.length();
        int length2 = charSequence.length();
        for (int i12 = this.f4019h; i12 < length2; i12++) {
            char cCharAt = charSequence.charAt(i12);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i2 = (cCharAt == '\r' && (i10 = i12 + 1) < charSequence.length() && charSequence.charAt(i10) == '\n') ? 2 : 1;
                length = i12;
                this.f4018g = 1;
                this.f4021j = i2;
                this.f4020i = length;
                return true;
            }
        }
        i2 = -1;
        this.f4018g = 1;
        this.f4021j = i2;
        this.f4020i = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f4018g = 0;
        int i2 = this.f4020i;
        int i10 = this.f4019h;
        this.f4019h = this.f4021j + i2;
        return this.f4017f.subSequence(i10, i2).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
