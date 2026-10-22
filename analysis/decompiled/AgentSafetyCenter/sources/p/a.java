package p;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Iterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public int f9512c;

    /* renamed from: f, reason: collision with root package name */
    public int f9513f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9514g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f9515h;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(e eVar, int i) {
        this(eVar.f9610g);
        this.f9515h = i;
        switch (i) {
            case 1:
                this.i = eVar;
                this(eVar.f9610g);
                break;
            default:
                this.i = eVar;
                break;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9513f < this.f9512c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object objE;
        if (!hasNext()) {
            g5.f.k();
            return null;
        }
        int i = this.f9513f;
        switch (this.f9515h) {
            case 0:
                objE = ((e) this.i).e(i);
                break;
            case 1:
                objE = ((e) this.i).h(i);
                break;
            default:
                objE = ((f) this.i).f9550f[i];
                break;
        }
        this.f9513f++;
        this.f9514g = true;
        return objE;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f9514g) {
            od.f.e("Call next() before removing an element.");
            return;
        }
        int i = this.f9513f - 1;
        this.f9513f = i;
        switch (this.f9515h) {
            case 0:
                ((e) this.i).f(i);
                break;
            case 1:
                ((e) this.i).f(i);
                break;
            default:
                ((f) this.i).a(i);
                break;
        }
        this.f9512c--;
        this.f9514g = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(f fVar) {
        this(fVar.f9551g);
        this.f9515h = 2;
        this.i = fVar;
    }

    public a(int i) {
        this.f9512c = i;
    }
}
