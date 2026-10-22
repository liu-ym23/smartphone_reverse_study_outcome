package x5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f implements Iterator, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f6289a;

    /* renamed from: b, reason: collision with root package name */
    public int f6290b;

    /* renamed from: c, reason: collision with root package name */
    public int f6291c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f6292e;

    public f(CharSequence string) {
        kotlin.jvm.internal.p.e(string, "string");
        this.f6289a = string;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i8;
        int i9;
        int i10 = this.f6290b;
        if (i10 != 0) {
            return i10 == 1;
        }
        if (this.f6292e < 0) {
            this.f6290b = 2;
            return false;
        }
        CharSequence charSequence = this.f6289a;
        int length = charSequence.length();
        int length2 = charSequence.length();
        for (int i11 = this.f6291c; i11 < length2; i11++) {
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i8 = (cCharAt == '\r' && (i9 = i11 + 1) < charSequence.length() && charSequence.charAt(i9) == '\n') ? 2 : 1;
                length = i11;
                this.f6290b = 1;
                this.f6292e = i8;
                this.d = length;
                return true;
            }
        }
        i8 = -1;
        this.f6290b = 1;
        this.f6292e = i8;
        this.d = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f6290b = 0;
        int i8 = this.d;
        int i9 = this.f6291c;
        this.f6291c = this.f6292e + i8;
        return this.f6289a.subSequence(i9, i8).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
