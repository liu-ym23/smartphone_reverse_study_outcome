package C3;

import D3.c;
import J3.x;
import J3.y;
import J3.z;
import x3.f;

/* loaded from: classes.dex */
public abstract class a<T> extends f<T> {
    /* JADX WARN: Multi-variable type inference failed */
    private a<T> e0() {
        if (!(this instanceof y)) {
            return this;
        }
        y yVar = (y) this;
        return S3.a.j(new x(yVar.d(), yVar.a()));
    }

    public abstract void d0(c<? super A3.c> cVar);

    public f<T> f0() {
        return S3.a.l(new z(e0()));
    }
}
