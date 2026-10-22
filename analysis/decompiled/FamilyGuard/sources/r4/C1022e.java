package r4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import k4.InterfaceC0814a;

/* renamed from: r4.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C1022e implements Iterator<String>, InterfaceC0814a {

    /* renamed from: f, reason: collision with root package name */
    private static final a f20099f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f20100a;

    /* renamed from: b, reason: collision with root package name */
    private int f20101b;

    /* renamed from: c, reason: collision with root package name */
    private int f20102c;

    /* renamed from: d, reason: collision with root package name */
    private int f20103d;

    /* renamed from: e, reason: collision with root package name */
    private int f20104e;

    /* renamed from: r4.e$a */
    private static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    public C1022e(CharSequence charSequence) {
        j4.k.g(charSequence, "string");
        this.f20100a = charSequence;
    }

    @Override // java.util.Iterator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f20101b = 0;
        int i5 = this.f20103d;
        int i6 = this.f20102c;
        this.f20102c = this.f20104e + i5;
        return this.f20100a.subSequence(i6, i5).toString();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i5;
        int i6;
        int i7 = this.f20101b;
        if (i7 != 0) {
            return i7 == 1;
        }
        if (this.f20104e < 0) {
            this.f20101b = 2;
            return false;
        }
        int length = this.f20100a.length();
        int length2 = this.f20100a.length();
        for (int i8 = this.f20102c; i8 < length2; i8++) {
            char cCharAt = this.f20100a.charAt(i8);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i5 = (cCharAt == '\r' && (i6 = i8 + 1) < this.f20100a.length() && this.f20100a.charAt(i6) == '\n') ? 2 : 1;
                length = i8;
                this.f20101b = 1;
                this.f20104e = i5;
                this.f20103d = length;
                return true;
            }
        }
        i5 = -1;
        this.f20101b = 1;
        this.f20104e = i5;
        this.f20103d = length;
        return true;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
