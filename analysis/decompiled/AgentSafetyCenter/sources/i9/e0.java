package i9;

import com.stepos.agentsafetycenter.screenperception.ScreenPerceptionThirtyDayExpireWorker;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f5856c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ScreenPerceptionThirtyDayExpireWorker f5857f;

    /* renamed from: g, reason: collision with root package name */
    public int f5858g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(ScreenPerceptionThirtyDayExpireWorker screenPerceptionThirtyDayExpireWorker, pb.c cVar) {
        super(cVar);
        this.f5857f = screenPerceptionThirtyDayExpireWorker;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f5856c = obj;
        this.f5858g |= Integer.MIN_VALUE;
        return this.f5857f.b(this);
    }
}
