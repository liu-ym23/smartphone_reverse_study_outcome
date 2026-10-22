package ie;

import java.lang.invoke.VarHandle;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class h implements e {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5996c;

    /* renamed from: f, reason: collision with root package name */
    public Type f5997f;

    public /* synthetic */ h(int i) {
        this.f5996c = i;
    }

    @Override // ie.e
    public final Type a() {
        switch (this.f5996c) {
        }
        return this.f5997f;
    }

    @Override // ie.e
    public final Object d(v vVar) {
        switch (this.f5996c) {
            case 0:
                i iVar = new i(vVar);
                g gVar = new g(0);
                gVar.f5994f = iVar;
                VarHandle.storeStoreFence();
                vVar.i(gVar);
                return iVar;
            default:
                i iVar2 = new i(vVar);
                g gVar2 = new g(1);
                gVar2.f5994f = iVar2;
                VarHandle.storeStoreFence();
                vVar.i(gVar2);
                return iVar2;
        }
    }
}
