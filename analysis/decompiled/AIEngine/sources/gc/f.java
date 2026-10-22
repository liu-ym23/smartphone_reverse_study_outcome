package gc;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements Iterator<String>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f9129a;

    /* renamed from: b, reason: collision with root package name */
    public int f9130b;

    /* renamed from: c, reason: collision with root package name */
    public int f9131c;

    /* renamed from: d, reason: collision with root package name */
    public int f9132d;

    /* renamed from: e, reason: collision with root package name */
    public int f9133e;

    public f(CharSequence string) {
        kotlin.jvm.internal.g.f(string, "string");
        this.f9129a = string;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i10;
        int i11;
        int i12 = this.f9130b;
        if (i12 != 0) {
            return i12 == 1;
        }
        if (this.f9133e < 0) {
            this.f9130b = 2;
            return false;
        }
        CharSequence charSequence = this.f9129a;
        int length = charSequence.length();
        int length2 = charSequence.length();
        for (int i13 = this.f9131c; i13 < length2; i13++) {
            char cCharAt = charSequence.charAt(i13);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i10 = (cCharAt == '\r' && (i11 = i13 + 1) < charSequence.length() && charSequence.charAt(i11) == '\n') ? 2 : 1;
                length = i13;
                this.f9130b = 1;
                this.f9133e = i10;
                this.f9132d = length;
                return true;
            }
        }
        i10 = -1;
        this.f9130b = 1;
        this.f9133e = i10;
        this.f9132d = length;
        return true;
    }

    @Override // java.util.Iterator
    public final String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f9130b = 0;
        int i10 = this.f9132d;
        int i11 = this.f9131c;
        this.f9131c = this.f9133e + i10;
        return this.f9129a.subSequence(i11, i10).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
