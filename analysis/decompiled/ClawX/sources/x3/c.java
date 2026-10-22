package x3;

import java.net.HttpURLConnection;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public f4.d f6257a;

    /* renamed from: b, reason: collision with root package name */
    public f5.h f6258b;

    /* renamed from: c, reason: collision with root package name */
    public u4.d f6259c;
    public n4.e d;

    /* renamed from: e, reason: collision with root package name */
    public HttpURLConnection f6260e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6261f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ d f6262g;

    /* renamed from: h, reason: collision with root package name */
    public int f6263h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, h5.c cVar) {
        super(cVar);
        this.f6262g = dVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f6261f = obj;
        this.f6263h |= Integer.MIN_VALUE;
        return this.f6262g.a(null, this);
    }
}
