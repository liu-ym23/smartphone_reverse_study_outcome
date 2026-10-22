package p4;

import b5.a0;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f implements d6.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d6.e f4745a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k4.g f4746b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Charset f4747c;
    public final /* synthetic */ w4.a d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f4748e;

    public f(d6.e eVar, k4.g gVar, Charset charset, w4.a aVar, Object obj) {
        this.f4745a = eVar;
        this.f4746b = gVar;
        this.f4747c = charset;
        this.d = aVar;
        this.f4748e = obj;
    }

    @Override // d6.b
    public final Object collect(d6.c cVar, f5.c cVar2) throws Throwable {
        Object objCollect = this.f4745a.collect(new e(cVar, this.f4746b, this.f4747c, this.d, this.f4748e), cVar2);
        return objCollect == g5.a.f2984a ? objCollect : a0.f883a;
    }
}
