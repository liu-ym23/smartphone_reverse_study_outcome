package p4;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public k4.g f4749a;

    /* renamed from: b, reason: collision with root package name */
    public Charset f4750b;

    /* renamed from: c, reason: collision with root package name */
    public w4.a f4751c;
    public Object d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f4752e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h f4753f;

    /* renamed from: g, reason: collision with root package name */
    public int f4754g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, h5.c cVar) {
        super(cVar);
        this.f4753f = hVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f4752e = obj;
        this.f4754g |= Integer.MIN_VALUE;
        return this.f4753f.b(null, null, null, null, this);
    }
}
