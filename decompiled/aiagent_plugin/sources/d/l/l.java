package d.l;

import d.a.am;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l extends am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f38547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f38548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f38549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f38550d;

    public l(long r3, long r5, long r7) {
        this.f38547a = r7;
        this.f38548b = r5;
        boolean r8 = true;
        if (r7 <= 0) goto L8;
        if (r3 <= r5) goto L11;
    L10:
        r8 = false;
    L11:
        this.f38549c = r8;
        if (r8 == true) goto L15;
        r3 = r5;
    L15:
        this.f38550d = r3;
        return;
    L8:
        if (r3 < r5) goto L10;
        goto L10
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f38549c;
    }

    @Override // d.a.am
    public long a() {
        long r0 = this.f38550d;
        if (r0 == this.f38548b) goto L5;
        this.f38550d = this.f38547a + r0;
    L10:
        return r0;
    L5:
        if (this.f38549c == false) goto L8;
        this.f38549c = false;
        goto L10
    L8:
        throw new NoSuchElementException();
    }
}
