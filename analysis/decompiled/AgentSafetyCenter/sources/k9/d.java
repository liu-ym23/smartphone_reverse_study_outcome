package k9;

import com.stepos.agentsafetycenter.sync.PendingSyncWorker;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f7365c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ PendingSyncWorker f7366f;

    /* renamed from: g, reason: collision with root package name */
    public int f7367g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PendingSyncWorker pendingSyncWorker, pb.c cVar) {
        super(cVar);
        this.f7366f = pendingSyncWorker;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f7365c = obj;
        this.f7367g |= Integer.MIN_VALUE;
        return this.f7366f.b(this);
    }
}
