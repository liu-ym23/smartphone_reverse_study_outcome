package io.ktor.utils.io;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public int f3197a;

    /* renamed from: b, reason: collision with root package name */
    public m f3198b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3199c;
    public final /* synthetic */ m d;

    /* renamed from: e, reason: collision with root package name */
    public int f3200e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(m mVar, h5.c cVar) {
        super(cVar);
        this.d = mVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f3199c = obj;
        this.f3200e |= Integer.MIN_VALUE;
        return this.d.d(0, this);
    }
}
