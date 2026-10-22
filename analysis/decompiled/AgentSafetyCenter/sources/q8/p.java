package q8;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public long f10155c;

    /* renamed from: f, reason: collision with root package name */
    public long f10156f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f10157g;

    /* renamed from: h, reason: collision with root package name */
    public Iterator f10158h;
    public ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f10159j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ t f10160k;

    /* renamed from: l, reason: collision with root package name */
    public int f10161l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(t tVar, pb.c cVar) {
        super(cVar);
        this.f10160k = tVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f10159j = obj;
        this.f10161l |= Integer.MIN_VALUE;
        return this.f10160k.f(0L, 0L, this);
    }
}
