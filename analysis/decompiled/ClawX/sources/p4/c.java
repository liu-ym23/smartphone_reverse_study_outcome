package p4;

import io.ktor.utils.io.p;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public Charset f4733a;

    /* renamed from: b, reason: collision with root package name */
    public Object f4734b;

    /* renamed from: c, reason: collision with root package name */
    public p f4735c;
    public /* synthetic */ Object d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f4736e;

    /* renamed from: f, reason: collision with root package name */
    public int f4737f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(h hVar, h5.c cVar) {
        super(cVar);
        this.f4736e = hVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f4737f |= Integer.MIN_VALUE;
        return this.f4736e.a(null, null, null, this);
    }
}
