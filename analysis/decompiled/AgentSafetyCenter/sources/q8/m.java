package q8;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public long f10138c;

    /* renamed from: f, reason: collision with root package name */
    public long f10139f;

    /* renamed from: g, reason: collision with root package name */
    public Collection f10140g;

    /* renamed from: h, reason: collision with root package name */
    public Iterator f10141h;
    public Collection i;

    /* renamed from: j, reason: collision with root package name */
    public int f10142j;

    /* renamed from: k, reason: collision with root package name */
    public int f10143k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f10144l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ t f10145m;

    /* renamed from: n, reason: collision with root package name */
    public int f10146n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(t tVar, pb.c cVar) {
        super(cVar);
        this.f10145m = tVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f10144l = obj;
        this.f10146n |= Integer.MIN_VALUE;
        return this.f10145m.c(0L, 0L, this);
    }
}
