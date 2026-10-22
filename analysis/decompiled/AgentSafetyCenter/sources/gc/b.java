package gc;

import java.io.File;
import java.lang.invoke.VarHandle;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends kb.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4678g;

    /* renamed from: h, reason: collision with root package name */
    public Object f4679h;
    public Object i;

    @Override // kb.a
    public final void a() {
        File file;
        File fileA;
        switch (this.f4678g) {
            case 0:
                Iterator it = (Iterator) this.f4679h;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (((HashSet) this.i).add(((i9.c) next).f5844a)) {
                        this.f7380f = next;
                        this.f7379c = 1;
                        break;
                    }
                }
                this.f7379c = 2;
                break;
            default:
                ArrayDeque arrayDeque = (ArrayDeque) this.f4679h;
                while (true) {
                    ub.f fVar = (ub.f) arrayDeque.peek();
                    if (fVar == null) {
                        file = null;
                    } else {
                        fileA = fVar.a();
                        if (fileA == null) {
                            arrayDeque.pop();
                        } else if (!fileA.equals(fVar.f14297a) && fileA.isDirectory() && arrayDeque.size() < Integer.MAX_VALUE) {
                            arrayDeque.push(b(fileA));
                        }
                    }
                }
                file = fileA;
                if (file == null) {
                    this.f7379c = 2;
                    break;
                } else {
                    this.f7380f = file;
                    this.f7379c = 1;
                    break;
                }
                break;
        }
    }

    public ub.b b(File file) {
        int iOrdinal = ((ub.g) ((i) this.i).f4695c).ordinal();
        if (iOrdinal == 0) {
            ub.e eVar = new ub.e();
            eVar.f14297a = file;
            VarHandle.storeStoreFence();
            return eVar;
        }
        if (iOrdinal != 1) {
            g5.f.a();
            return null;
        }
        ub.c cVar = new ub.c();
        cVar.f14297a = file;
        VarHandle.storeStoreFence();
        return cVar;
    }
}
