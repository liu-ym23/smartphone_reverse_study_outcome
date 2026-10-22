package x8;

import g0.f;

/* loaded from: classes.dex */
public final class b extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f15592c;

    /* renamed from: f, reason: collision with root package name */
    public int f15593f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ f f15594g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, nb.c cVar) {
        super(cVar);
        this.f15594g = fVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f15592c = obj;
        this.f15593f |= Integer.MIN_VALUE;
        return this.f15594g.emit(null, this);
    }
}
