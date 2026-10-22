package j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements Iterator, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public int f3279a;

    /* renamed from: b, reason: collision with root package name */
    public int f3280b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3281c;
    public final /* synthetic */ int d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f3282e;

    public a(int i8) {
        this.f3279a = i8;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3280b < this.f3279a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object objF;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f3280b;
        switch (this.d) {
            case 0:
                objF = ((e) this.f3282e).f(i8);
                break;
            case 1:
                objF = ((e) this.f3282e).i(i8);
                break;
            default:
                objF = ((f) this.f3282e).f3291b[i8];
                break;
        }
        this.f3280b++;
        this.f3281c = true;
        return objF;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f3281c) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i8 = this.f3280b - 1;
        this.f3280b = i8;
        switch (this.d) {
            case 0:
                ((e) this.f3282e).g(i8);
                break;
            case 1:
                ((e) this.f3282e).g(i8);
                break;
            default:
                ((f) this.f3282e).f(i8);
                break;
        }
        this.f3279a--;
        this.f3281c = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(f fVar) {
        this(fVar.f3292c);
        this.d = 2;
        this.f3282e = fVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(e eVar, int i8) {
        this(eVar.f3306c);
        this.d = i8;
        switch (i8) {
            case 1:
                this.f3282e = eVar;
                this(eVar.f3306c);
                break;
            default:
                this.f3282e = eVar;
                break;
        }
    }
}
