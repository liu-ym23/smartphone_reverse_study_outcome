package hc;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements Iterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public String f5455c;

    /* renamed from: f, reason: collision with root package name */
    public int f5456f;

    /* renamed from: g, reason: collision with root package name */
    public int f5457g;

    /* renamed from: h, reason: collision with root package name */
    public int f5458h;
    public int i;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i3;
        String str = this.f5455c;
        int i10 = this.f5456f;
        if (i10 != 0) {
            return i10 == 1;
        }
        if (this.i < 0) {
            this.f5456f = 2;
            return false;
        }
        int length = str.length();
        int length2 = str.length();
        for (int i11 = this.f5457g; i11 < length2; i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i = (cCharAt == '\r' && (i3 = i11 + 1) < str.length() && str.charAt(i3) == '\n') ? 2 : 1;
                length = i11;
                this.f5456f = 1;
                this.i = i;
                this.f5458h = length;
                return true;
            }
        }
        i = -1;
        this.f5456f = 1;
        this.i = i;
        this.f5458h = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            g5.f.k();
            return null;
        }
        this.f5456f = 0;
        int i = this.f5458h;
        int i3 = this.f5457g;
        this.f5457g = this.i + i;
        return this.f5455c.subSequence(i3, i).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
