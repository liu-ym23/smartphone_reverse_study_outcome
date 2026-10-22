package hc;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements Iterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public int f5451c;

    /* renamed from: f, reason: collision with root package name */
    public int f5452f;

    /* renamed from: g, reason: collision with root package name */
    public int f5453g;

    /* renamed from: h, reason: collision with root package name */
    public ec.g f5454h;
    public /* synthetic */ gc.i i;

    public final void a() {
        gc.i iVar = this.i;
        CharSequence charSequence = (CharSequence) iVar.f4694b;
        int i = this.f5453g;
        if (i < 0) {
            this.f5451c = 0;
            this.f5454h = null;
            return;
        }
        if (i > charSequence.length()) {
            int i3 = this.f5452f;
            charSequence.getClass();
            this.f5454h = new ec.g(i3, charSequence.length() - 1, 1);
            this.f5453g = -1;
        } else {
            jb.g gVar = (jb.g) ((xb.p) iVar.f4695c).invoke(charSequence, Integer.valueOf(this.f5453g));
            if (gVar == null) {
                int i10 = this.f5452f;
                charSequence.getClass();
                this.f5454h = new ec.g(i10, charSequence.length() - 1, 1);
                this.f5453g = -1;
            } else {
                int iIntValue = ((Number) gVar.f6759c).intValue();
                int iIntValue2 = ((Number) gVar.f6760f).intValue();
                this.f5454h = p5.f.O(this.f5452f, iIntValue);
                int i11 = iIntValue + iIntValue2;
                this.f5452f = i11;
                this.f5453g = i11 + (iIntValue2 == 0 ? 1 : 0);
            }
        }
        this.f5451c = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f5451c == -1) {
            a();
        }
        return this.f5451c == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f5451c == -1) {
            a();
        }
        if (this.f5451c == 0) {
            g5.f.k();
            return null;
        }
        ec.g gVar = this.f5454h;
        gVar.getClass();
        this.f5454h = null;
        this.f5451c = -1;
        return gVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
