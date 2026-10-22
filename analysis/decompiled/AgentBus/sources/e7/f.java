package e7;

import java.nio.ByteBuffer;
import java.util.ConcurrentModificationException;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: f, reason: collision with root package name */
    public int f3094f;

    /* renamed from: g, reason: collision with root package name */
    public int f3095g;

    /* renamed from: h, reason: collision with root package name */
    public int f3096h;

    /* renamed from: i, reason: collision with root package name */
    public Object f3097i;

    public f() {
        if (w4.a.f10659a == null) {
            w4.a.f10659a = new w4.a();
        }
    }

    public int a(int i2) {
        if (i2 < this.f3096h) {
            return ((ByteBuffer) this.f3097i).getShort(this.f3095g + i2);
        }
        return 0;
    }

    public void c() {
        if (((g) this.f3097i).f3106m != this.f3096h) {
            throw new ConcurrentModificationException();
        }
    }

    public void d() {
        while (true) {
            int i2 = this.f3094f;
            g gVar = (g) this.f3097i;
            if (i2 >= gVar.f3104k || gVar.f3101h[i2] >= 0) {
                return;
            } else {
                this.f3094f = i2 + 1;
            }
        }
    }

    public boolean hasNext() {
        return this.f3094f < ((g) this.f3097i).f3104k;
    }

    public void remove() {
        g gVar = (g) this.f3097i;
        c();
        if (this.f3095g == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        gVar.d();
        gVar.n(this.f3095g);
        this.f3095g = -1;
        this.f3096h = gVar.f3106m;
    }
}
