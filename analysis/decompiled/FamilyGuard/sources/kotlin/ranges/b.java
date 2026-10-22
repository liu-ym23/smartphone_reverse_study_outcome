package kotlin.ranges;

import W3.AbstractC0402m;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b extends AbstractC0402m {

    /* renamed from: a, reason: collision with root package name */
    private final int f17951a;

    /* renamed from: b, reason: collision with root package name */
    private final int f17952b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f17953c;

    /* renamed from: d, reason: collision with root package name */
    private int f17954d;

    public b(char c6, char c7, int i5) {
        this.f17951a = i5;
        this.f17952b = c7;
        boolean z5 = false;
        if (i5 <= 0 ? j4.k.i(c6, c7) >= 0 : j4.k.i(c6, c7) <= 0) {
            z5 = true;
        }
        this.f17953c = z5;
        this.f17954d = z5 ? c6 : c7;
    }

    @Override // W3.AbstractC0402m
    public char b() {
        int i5 = this.f17954d;
        if (i5 != this.f17952b) {
            this.f17954d = this.f17951a + i5;
        } else {
            if (!this.f17953c) {
                throw new NoSuchElementException();
            }
            this.f17953c = false;
        }
        return (char) i5;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f17953c;
    }
}
