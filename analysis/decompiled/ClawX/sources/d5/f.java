package d5;

import java.nio.ByteBuffer;
import java.util.ConcurrentModificationException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public int f1830a;

    /* renamed from: b, reason: collision with root package name */
    public int f1831b;

    /* renamed from: c, reason: collision with root package name */
    public int f1832c;
    public Object d;

    public f() {
        if (t1.f.f5454b == null) {
            t1.f.f5454b = new t1.f(28);
        }
    }

    public int a(int i8) {
        if (i8 < this.f1832c) {
            return ((ByteBuffer) this.d).getShort(this.f1831b + i8);
        }
        return 0;
    }

    public void b() {
        if (((g) this.d).f1840h != this.f1832c) {
            throw new ConcurrentModificationException();
        }
    }

    public void c() {
        while (true) {
            int i8 = this.f1830a;
            g gVar = (g) this.d;
            if (i8 >= gVar.f1838f || gVar.f1836c[i8] >= 0) {
                return;
            } else {
                this.f1830a = i8 + 1;
            }
        }
    }

    public boolean hasNext() {
        return this.f1830a < ((g) this.d).f1838f;
    }

    public void remove() {
        g gVar = (g) this.d;
        b();
        if (this.f1831b == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        gVar.c();
        gVar.l(this.f1831b);
        this.f1831b = -1;
        this.f1832c = gVar.f1840h;
    }
}
