package q4;

import io.ktor.utils.io.d0;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public Object f4859a;

    /* renamed from: b, reason: collision with root package name */
    public Object f4860b;

    /* renamed from: c, reason: collision with root package name */
    public Charset f4861c;
    public d0 d;

    /* renamed from: e, reason: collision with root package name */
    public a f4862e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f4863f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i f4864g;

    /* renamed from: h, reason: collision with root package name */
    public int f4865h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, h5.c cVar) {
        super(cVar);
        this.f4864g = iVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f4863f = obj;
        this.f4865h |= Integer.MIN_VALUE;
        return i.a(this.f4864g, null, null, null, null, this);
    }
}
