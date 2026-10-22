package D7;

import java.util.List;
import java.util.RandomAccess;

/* renamed from: D7.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0213e extends AbstractC0214f implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f401a = 0;
    public int b;
    public int c;
    public final List d;

    public C0213e(AbstractC0214f abstractC0214f, int i, int i6) {
        this.d = abstractC0214f;
        this.b = i;
        C0211c c0211c = AbstractC0214f.Companion;
        int size = abstractC0214f.size();
        c0211c.getClass();
        C0211c.d(i, i6, size);
        this.c = i6 - i;
    }

    @Override // D7.AbstractC0214f, java.util.List
    public final Object get(int i) {
        switch (this.f401a) {
            case 0:
                C0211c c0211c = AbstractC0214f.Companion;
                int i6 = this.c;
                c0211c.getClass();
                C0211c.b(i, i6);
                return ((AbstractC0214f) this.d).get(this.b + i);
            default:
                C0211c c0211c2 = AbstractC0214f.Companion;
                int i10 = this.c;
                c0211c2.getClass();
                C0211c.b(i, i10);
                return this.d.get(this.b + i);
        }
    }

    @Override // D7.AbstractC0214f, D7.AbstractC0209a
    /* renamed from: getSize */
    public final int get_size() {
        switch (this.f401a) {
        }
        return this.c;
    }

    @Override // D7.AbstractC0214f, java.util.List
    public List subList(int i, int i6) {
        switch (this.f401a) {
            case 0:
                C0211c c0211c = AbstractC0214f.Companion;
                int i10 = this.c;
                c0211c.getClass();
                C0211c.d(i, i6, i10);
                AbstractC0214f abstractC0214f = (AbstractC0214f) this.d;
                int i11 = this.b;
                return new C0213e(abstractC0214f, i + i11, i11 + i6);
            default:
                return super.subList(i, i6);
        }
    }

    public C0213e(List list) {
        this.d = list;
    }
}
