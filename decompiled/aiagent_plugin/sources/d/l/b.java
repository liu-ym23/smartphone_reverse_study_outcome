package d.l;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends d.a.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f38523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f38524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f38525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f38526d;

    public b(char r3, char r4, int r5) {
        this.f38523a = r5;
        this.f38524b = r4;
        boolean r0 = true;
        if (r5 <= 0) goto L8;
        if (d.h.b.o.a(r3, r4) <= 0) goto L11;
    L10:
        r0 = false;
    L11:
        this.f38525c = r0;
        if (r0 == true) goto L15;
        r3 = r4;
    L15:
        this.f38526d = r3;
        return;
    L8:
        if (d.h.b.o.a(r3, r4) < 0) goto L10;
        goto L10
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f38525c;
    }

    @Override // d.a.o
    public char a() {
        int r0 = this.f38526d;
        if (r0 == this.f38524b) goto L5;
        this.f38526d = this.f38523a + r0;
    L11:
        return (char) r0;
    L5:
        if (this.f38525c == false) goto L8;
        this.f38525c = false;
        goto L11
    L8:
        throw new NoSuchElementException();
    }
}
