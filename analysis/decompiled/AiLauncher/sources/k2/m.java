package k2;

import java.util.Iterator;
import java.util.concurrent.Executor;
import l2.InterfaceC4863c;
import m2.InterfaceC4893a;

/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f34626a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC4863c f34627b;

    /* renamed from: c, reason: collision with root package name */
    public final o f34628c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC4893a f34629d;

    public m(Executor executor, InterfaceC4863c interfaceC4863c, o oVar, InterfaceC4893a interfaceC4893a) {
        this.f34626a = executor;
        this.f34627b = interfaceC4863c;
        this.f34628c = oVar;
        this.f34629d = interfaceC4893a;
    }

    public static /* synthetic */ Object b(m mVar) {
        Iterator<e2.m> it = mVar.f34627b.D().iterator();
        while (it.hasNext()) {
            mVar.f34628c.a(it.next(), 1);
        }
        return null;
    }

    public void a() {
        this.f34626a.execute(k.a(this));
    }
}
