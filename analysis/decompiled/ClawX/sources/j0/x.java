package j0;

import java.io.Serializable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class x extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public Object f3455a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3456b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f3457c;
    public kotlin.jvm.internal.y d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3458e;

    /* renamed from: f, reason: collision with root package name */
    public int f3459f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f3460g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c0 f3461h;

    /* renamed from: j, reason: collision with root package name */
    public int f3462j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(c0 c0Var, h5.c cVar) {
        super(cVar);
        this.f3461h = c0Var;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f3460g = obj;
        this.f3462j |= Integer.MIN_VALUE;
        return c0.f(this.f3461h, false, this);
    }
}
