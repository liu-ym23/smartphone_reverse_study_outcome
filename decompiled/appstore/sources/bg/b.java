package bg;

import java.util.NoSuchElementException;
import kotlin.collections.g0;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6004d;

    public b(int r10, int r11, int r12) {
        this.f6001a = r12;
        this.f6002b = r11;
        boolean r13 = false;
        if (r12 <= 0) goto L6;
        if (r10 > r11) goto L8;
    L5:
        r13 = true;
    L8:
        this.f6003c = r13;
        if (r13 == true) goto L12;
        r10 = r11;
    L12:
        this.f6004d = r10;
        return;
    L6:
        if (r10 < r11) goto L8;
        goto L8
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f6003c;
    }

    @Override // kotlin.collections.g0
    public int nextInt() {
        int r10 = this.f6004d;
        if (r10 == this.f6002b) goto L5;
        this.f6004d = this.f6001a + r10;
    L10:
        return r10;
    L5:
        if (this.f6003c == false) goto L8;
        this.f6003c = false;
        goto L10
    L8:
        throw new NoSuchElementException();
    }
}
