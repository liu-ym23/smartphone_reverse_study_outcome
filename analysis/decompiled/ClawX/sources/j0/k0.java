package j0;

import java.io.FileOutputStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k0 extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public FileOutputStream f3384a;

    /* renamed from: b, reason: collision with root package name */
    public FileOutputStream f3385b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3386c;
    public final /* synthetic */ l0 d;

    /* renamed from: e, reason: collision with root package name */
    public int f3387e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(l0 l0Var, h5.c cVar) {
        super(cVar);
        this.d = l0Var;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f3386c = obj;
        this.f3387e |= Integer.MIN_VALUE;
        return this.d.b(null, this);
    }
}
