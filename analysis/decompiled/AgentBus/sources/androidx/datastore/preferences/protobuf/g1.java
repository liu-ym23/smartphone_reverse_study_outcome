package androidx.datastore.preferences.protobuf;

import com.google.protobuf.v3;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class g1 implements Iterator {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f856f;

    /* renamed from: g, reason: collision with root package name */
    public int f857g = -1;

    /* renamed from: h, reason: collision with root package name */
    public boolean f858h;

    /* renamed from: i, reason: collision with root package name */
    public Iterator f859i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ AbstractMap f860j;

    public /* synthetic */ g1(AbstractMap abstractMap, int i2) {
        this.f856f = i2;
        this.f860j = abstractMap;
    }

    public final Iterator a() {
        switch (this.f856f) {
            case 0:
                if (this.f859i == null) {
                    this.f859i = ((b1) this.f860j).f820h.entrySet().iterator();
                }
                break;
            case 1:
                if (this.f859i == null) {
                    this.f859i = ((v3) this.f860j).f2592h.entrySet().iterator();
                }
                break;
            default:
                if (this.f859i == null) {
                    this.f859i = ((f9.a0) this.f860j).f3527h.entrySet().iterator();
                }
                break;
        }
        return this.f859i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f856f) {
            case 0:
                int i2 = this.f857g + 1;
                b1 b1Var = (b1) this.f860j;
                if (i2 >= b1Var.f819g.size()) {
                    if (b1Var.f820h.isEmpty() || !a().hasNext()) {
                    }
                }
                break;
            case 1:
                int i10 = this.f857g + 1;
                v3 v3Var = (v3) this.f860j;
                if (i10 >= v3Var.f2591g) {
                    if (v3Var.f2592h.isEmpty() || !a().hasNext()) {
                    }
                }
                break;
            default:
                if (this.f857g + 1 < ((f9.a0) this.f860j).f3526g.size() || a().hasNext()) {
                }
                break;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f856f) {
            case 0:
                this.f858h = true;
                int i2 = this.f857g + 1;
                this.f857g = i2;
                b1 b1Var = (b1) this.f860j;
                if (i2 >= b1Var.f819g.size()) {
                    break;
                } else {
                    break;
                }
            case 1:
                this.f858h = true;
                int i10 = this.f857g + 1;
                this.f857g = i10;
                v3 v3Var = (v3) this.f860j;
                if (i10 >= v3Var.f2591g) {
                    break;
                } else {
                    break;
                }
            default:
                this.f858h = true;
                int i11 = this.f857g + 1;
                this.f857g = i11;
                f9.a0 a0Var = (f9.a0) this.f860j;
                if (i11 >= a0Var.f3526g.size()) {
                    break;
                } else {
                    break;
                }
        }
        return (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i2 = this.f856f;
        AbstractMap abstractMap = this.f860j;
        switch (i2) {
            case 0:
                b1 b1Var = (b1) abstractMap;
                if (!this.f858h) {
                    throw new IllegalStateException("remove() was called before next()");
                }
                this.f858h = false;
                int i10 = b1.f817l;
                b1Var.b();
                if (this.f857g >= b1Var.f819g.size()) {
                    a().remove();
                    return;
                }
                int i11 = this.f857g;
                this.f857g = i11 - 1;
                b1Var.g(i11);
                return;
            case 1:
                v3 v3Var = (v3) abstractMap;
                if (!this.f858h) {
                    throw new IllegalStateException("remove() was called before next()");
                }
                this.f858h = false;
                int i12 = v3.f2589l;
                v3Var.b();
                int i13 = this.f857g;
                if (i13 >= v3Var.f2591g) {
                    a().remove();
                    return;
                } else {
                    this.f857g = i13 - 1;
                    v3Var.h(i13);
                    return;
                }
            default:
                f9.a0 a0Var = (f9.a0) abstractMap;
                if (!this.f858h) {
                    throw new IllegalStateException("remove() was called before next()");
                }
                this.f858h = false;
                int i14 = f9.a0.f3524k;
                a0Var.b();
                if (this.f857g >= a0Var.f3526g.size()) {
                    a().remove();
                    return;
                }
                int i15 = this.f857g;
                this.f857g = i15 - 1;
                a0Var.f(i15);
                return;
        }
    }
}
