package io.ktor.utils.io;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public m f3203a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3204b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f3205c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(m mVar, h5.c cVar) {
        super(cVar);
        this.f3205c = mVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f3204b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.f3205c.g(this);
    }
}
