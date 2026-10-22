package k9;

import com.stepos.agentsafetycenter.sync.MidnightSyncWorker;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f7362c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ MidnightSyncWorker f7363f;

    /* renamed from: g, reason: collision with root package name */
    public int f7364g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(MidnightSyncWorker midnightSyncWorker, pb.c cVar) {
        super(cVar);
        this.f7363f = midnightSyncWorker;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f7362c = obj;
        this.f7364g |= Integer.MIN_VALUE;
        return this.f7363f.b(this);
    }
}
