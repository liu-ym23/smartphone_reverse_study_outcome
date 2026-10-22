package p0;

import i1.f0;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends k {

    /* renamed from: h, reason: collision with root package name */
    public f0 f9680h;

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f9678g;
        this.f9678g = i + 2;
        f0 f0Var = this.f9680h;
        Object[] objArr = this.f9676c;
        Object obj = objArr[i];
        Object obj2 = objArr[i + 1];
        a aVar = new a(obj, obj2);
        aVar.f9656h = f0Var;
        aVar.i = obj2;
        VarHandle.storeStoreFence();
        return aVar;
    }
}
