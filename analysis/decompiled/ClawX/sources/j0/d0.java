package j0;

import java.io.FileInputStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d0 extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public Object f3335a;

    /* renamed from: b, reason: collision with root package name */
    public FileInputStream f3336b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3337c;
    public final /* synthetic */ e0 d;

    /* renamed from: e, reason: collision with root package name */
    public int f3338e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(e0 e0Var, h5.c cVar) {
        super(cVar);
        this.d = e0Var;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f3337c = obj;
        this.f3338e |= Integer.MIN_VALUE;
        return e0.a(this.d, this);
    }
}
