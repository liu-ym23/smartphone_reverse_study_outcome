package gc;

import java.io.File;
import java.lang.invoke.VarHandle;
import java.util.ArrayDeque;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4693a;

    /* renamed from: b, reason: collision with root package name */
    public Object f4694b;

    /* renamed from: c, reason: collision with root package name */
    public Object f4695c;

    public i(CharSequence charSequence, xb.p pVar) {
        this.f4693a = 3;
        charSequence.getClass();
        this.f4694b = charSequence;
        this.f4695c = pVar;
    }

    @Override // gc.k
    public final Iterator iterator() {
        int i = 0;
        switch (this.f4693a) {
            case 0:
                g gVar = new g(1);
                gVar.i = this;
                gVar.f4687f = ((Iterable) ((n) this.f4694b).f4705b).iterator();
                VarHandle.storeStoreFence();
                return gVar;
            case 1:
                j jVar = new j(i);
                jVar.f4699h = this;
                jVar.f4697f = -2;
                VarHandle.storeStoreFence();
                return jVar;
            case 2:
                r rVar = new r(i);
                rVar.f4711g = this;
                rVar.f4710f = ((k) this.f4694b).iterator();
                VarHandle.storeStoreFence();
                return rVar;
            case 3:
                hc.b bVar = new hc.b();
                bVar.i = this;
                bVar.f5451c = -1;
                int iQ = p5.f.q(0, 0, ((CharSequence) this.f4694b).length());
                bVar.f5452f = iQ;
                bVar.f5453g = iQ;
                VarHandle.storeStoreFence();
                return bVar;
            default:
                b bVar2 = new b(1);
                bVar2.i = this;
                ArrayDeque arrayDeque = new ArrayDeque();
                bVar2.f4679h = arrayDeque;
                File file = (File) this.f4694b;
                if (file.isDirectory()) {
                    arrayDeque.push(bVar2.b(file));
                } else if (file.isFile()) {
                    ub.d dVar = new ub.d();
                    dVar.f14297a = file;
                    arrayDeque.push(dVar);
                } else {
                    bVar2.f7379c = 2;
                }
                VarHandle.storeStoreFence();
                return bVar2;
        }
    }

    public /* synthetic */ i(int i) {
        this.f4693a = i;
    }
}
