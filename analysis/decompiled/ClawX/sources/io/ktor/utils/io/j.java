package io.ktor.utils.io;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3207a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f3208b;

    /* renamed from: c, reason: collision with root package name */
    public int f3209c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(m mVar, f5.c cVar) {
        super(cVar);
        this.f3208b = mVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f3207a = obj;
        this.f3209c |= Integer.MIN_VALUE;
        return this.f3208b.h(this);
    }
}
