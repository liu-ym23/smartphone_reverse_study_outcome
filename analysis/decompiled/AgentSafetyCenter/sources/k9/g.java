package k9;

import android.content.Context;
import jb.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Context f7374c;

    /* renamed from: f, reason: collision with root package name */
    public String f7375f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f7376g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h f7377h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, pb.c cVar) {
        super(cVar);
        this.f7377h = hVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f7376g = obj;
        this.i |= Integer.MIN_VALUE;
        Object objC = this.f7377h.c(null, this);
        return objC == ob.a.f9351c ? objC : i.a(objC);
    }
}
