package d.l;

import d.a.al;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i extends al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f38537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f38538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f38539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f38540d;

    public i(int r3, int r4, int r5) {
        this.f38537a = r5;
        this.f38538b = r4;
        boolean r0 = true;
        if (r5 <= 0) goto L6;
        if (r3 <= r4) goto L9;
    L8:
        r0 = false;
    L9:
        this.f38539c = r0;
        if (r0 == true) goto L13;
        r3 = r4;
    L13:
        this.f38540d = r3;
        return;
    L6:
        if (r3 < r4) goto L8;
        goto L8
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f38539c;
    }

    @Override // d.a.al
    public int a() {
        int r0 = this.f38540d;
        if (r0 == this.f38538b) goto L5;
        this.f38540d = this.f38537a + r0;
    L10:
        return r0;
    L5:
        if (this.f38539c == false) goto L8;
        this.f38539c = false;
        goto L10
    L8:
        throw new NoSuchElementException();
    }
}
