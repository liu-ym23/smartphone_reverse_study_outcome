package W3;

import C7.r;
import S7.o;
import w9.C2109b;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1487a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ c(int i, Object obj, Object obj2) {
        this.f1487a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f1487a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                ((kotlinx.coroutines.sync.a) this.b).unlock(this.c);
                break;
            default:
                kotlinx.coroutines.sync.a aVar = (kotlinx.coroutines.sync.a) this.b;
                C2109b c2109b = (C2109b) this.c;
                kotlinx.coroutines.sync.a.i.set(aVar, c2109b.b);
                aVar.unlock(c2109b.b);
                break;
        }
        return r.f317a;
    }
}
