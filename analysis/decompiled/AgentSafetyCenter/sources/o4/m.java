package o4;

import androidx.room.c0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public q f9198c;

    /* renamed from: f, reason: collision with root package name */
    public c0 f9199f;

    /* renamed from: g, reason: collision with root package name */
    public f f9200g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f9201h;
    public final /* synthetic */ q i;

    /* renamed from: j, reason: collision with root package name */
    public int f9202j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(q qVar, pb.c cVar) {
        super(cVar);
        this.i = qVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f9201h = obj;
        this.f9202j |= Integer.MIN_VALUE;
        return this.i.e(null, this);
    }
}
