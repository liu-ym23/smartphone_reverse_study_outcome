package dc;

import java.util.NoSuchElementException;
import mb.t;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends t {

    /* renamed from: a, reason: collision with root package name */
    public final int f8454a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8455b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8456c;

    /* renamed from: d, reason: collision with root package name */
    public int f8457d;

    public d(int i10, int i11, int i12) {
        this.f8454a = i12;
        this.f8455b = i11;
        boolean z = false;
        if (i12 <= 0 ? i10 >= i11 : i10 <= i11) {
            z = true;
        }
        this.f8456c = z;
        this.f8457d = z ? i10 : i11;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f8456c;
    }

    @Override // mb.t
    public final int nextInt() {
        int i10 = this.f8457d;
        if (i10 != this.f8455b) {
            this.f8457d = this.f8454a + i10;
            return i10;
        }
        if (!this.f8456c) {
            throw new NoSuchElementException();
        }
        this.f8456c = false;
        return i10;
    }
}
