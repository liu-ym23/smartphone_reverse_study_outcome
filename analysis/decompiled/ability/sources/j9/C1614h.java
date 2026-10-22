package j9;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: j9.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1614h implements Iterator, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f4785a;
    public int b;
    public int c;
    public int d;
    public int e;

    public C1614h(CharSequence string) {
        kotlin.jvm.internal.k.f(string, "string");
        this.f4785a = string;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i6;
        int i10 = this.b;
        if (i10 != 0) {
            return i10 == 1;
        }
        if (this.e < 0) {
            this.b = 2;
            return false;
        }
        CharSequence charSequence = this.f4785a;
        int length = charSequence.length();
        int length2 = charSequence.length();
        for (int i11 = this.c; i11 < length2; i11++) {
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i = (cCharAt == '\r' && (i6 = i11 + 1) < charSequence.length() && charSequence.charAt(i6) == '\n') ? 2 : 1;
                length = i11;
                this.b = 1;
                this.e = i;
                this.d = length;
                return true;
            }
        }
        i = -1;
        this.b = 1;
        this.e = i;
        this.d = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.b = 0;
        int i = this.d;
        int i6 = this.c;
        this.c = this.e + i;
        return this.f4785a.subSequence(i6, i).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
