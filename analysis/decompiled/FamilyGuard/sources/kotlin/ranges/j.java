package kotlin.ranges;

import W3.D;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class j extends D {

    /* renamed from: a, reason: collision with root package name */
    private final long f17975a;

    /* renamed from: b, reason: collision with root package name */
    private final long f17976b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f17977c;

    /* renamed from: d, reason: collision with root package name */
    private long f17978d;

    public j(long j5, long j6, long j7) {
        this.f17975a = j7;
        this.f17976b = j6;
        boolean z5 = false;
        if (j7 <= 0 ? j5 >= j6 : j5 <= j6) {
            z5 = true;
        }
        this.f17977c = z5;
        this.f17978d = z5 ? j5 : j6;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f17977c;
    }

    @Override // W3.D
    public long nextLong() {
        long j5 = this.f17978d;
        if (j5 != this.f17976b) {
            this.f17978d = this.f17975a + j5;
            return j5;
        }
        if (!this.f17977c) {
            throw new NoSuchElementException();
        }
        this.f17977c = false;
        return j5;
    }
}
