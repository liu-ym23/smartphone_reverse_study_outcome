package q8;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public androidx.room.u f10119a;

    /* renamed from: b, reason: collision with root package name */
    public g f10120b;

    public final Object a(long j10, pb.c cVar) throws Throwable {
        androidx.room.u uVar = this.f10119a;
        e eVar = new e(1);
        eVar.f10115f = j10;
        VarHandle.storeStoreFence();
        Object objB = td.h.B(uVar, cVar, eVar, false, true);
        return objB == ob.a.f9351c ? objB : jb.v.f6774a;
    }
}
