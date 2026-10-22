package k;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class a implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public int f5441f;

    /* renamed from: g, reason: collision with root package name */
    public int f5442g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5443h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5444i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f5445j;

    public a(int i2) {
        this.f5441f = i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5442g < this.f5441f;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object objG;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f5442g;
        switch (this.f5444i) {
            case 0:
                objG = ((e) this.f5445j).g(i2);
                break;
            case 1:
                objG = ((e) this.f5445j).k(i2);
                break;
            default:
                objG = ((f) this.f5445j).f5485g[i2];
                break;
        }
        this.f5442g++;
        this.f5443h = true;
        return objG;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f5443h) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i2 = this.f5442g - 1;
        this.f5442g = i2;
        switch (this.f5444i) {
            case 0:
                ((e) this.f5445j).i(i2);
                break;
            case 1:
                ((e) this.f5445j).i(i2);
                break;
            default:
                ((f) this.f5445j).a(i2);
                break;
        }
        this.f5441f--;
        this.f5443h = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(f fVar) {
        this(fVar.f5486h);
        this.f5444i = 2;
        this.f5445j = fVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(e eVar, int i2) {
        this(eVar.f5479h);
        this.f5444i = i2;
        switch (i2) {
            case 1:
                this.f5445j = eVar;
                this(eVar.f5479h);
                break;
            default:
                this.f5445j = eVar;
                break;
        }
    }
}
