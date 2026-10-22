package o4;

import b5.a0;
import io.ktor.utils.io.p;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements d6.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4313a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d6.e f4314b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Charset f4315c;
    public final /* synthetic */ w4.a d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ p f4316e;

    public /* synthetic */ c(d6.e eVar, Charset charset, w4.a aVar, p pVar, int i8) {
        this.f4313a = i8;
        this.f4314b = eVar;
        this.f4315c = charset;
        this.d = aVar;
        this.f4316e = pVar;
    }

    @Override // d6.b
    public final Object collect(d6.c cVar, f5.c cVar2) throws Throwable {
        switch (this.f4313a) {
            case 0:
                Object objCollect = this.f4314b.collect(new b(cVar, this.f4315c, this.d, this.f4316e, 0), cVar2);
                if (objCollect != g5.a.f2984a) {
                    break;
                }
                break;
            default:
                Object objCollect2 = this.f4314b.collect(new b(cVar, this.f4315c, this.d, this.f4316e, 1), cVar2);
                if (objCollect2 != g5.a.f2984a) {
                    break;
                }
                break;
        }
        return a0.f883a;
    }
}
