package bg;

import java.util.NoSuchElementException;
import kotlin.collections.h0;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f6014d;

    public e(long r10, long r11, long r12) {
        this.f6011a = r12;
        this.f6012b = r11;
        boolean r13 = false;
        if (r12 <= 0) goto L8;
        if (r10 > r11) goto L10;
    L6:
        r13 = true;
    L10:
        this.f6013c = r13;
        if (r13 == true) goto L14;
        r10 = r11;
    L14:
        this.f6014d = r10;
        return;
    L8:
        if (r10 < r11) goto L10;
        goto L10
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f6013c;
    }

    @Override // kotlin.collections.h0
    public long nextLong() {
        long r10 = this.f6014d;
        if (r10 == this.f6012b) goto L5;
        this.f6014d = this.f6011a + r10;
    L10:
        return r10;
    L5:
        if (this.f6013c == false) goto L8;
        this.f6013c = false;
        goto L10
    L8:
        throw new NoSuchElementException();
    }
}
