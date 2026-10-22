package h4;

import a6.f0;
import androidx.emoji2.text.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public f0 f3030a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3031b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f3032c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(p pVar, h5.c cVar) {
        super(cVar);
        this.f3032c = pVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f3031b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.f3032c.j(this);
    }
}
