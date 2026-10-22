package v9;

import S7.o;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1693K;
import s9.p;

/* renamed from: v9.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2074c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6795a;
    public final o b;
    public final o c;
    public final Object d;
    public final SuspendLambda e;
    public final o f;
    public Object g;
    public int h = -1;
    public final /* synthetic */ kotlinx.coroutines.selects.b i;

    public C2074c(kotlinx.coroutines.selects.b bVar, Object obj, o oVar, o oVar2, a5.d dVar, SuspendLambda suspendLambda, o oVar3) {
        this.i = bVar;
        this.f6795a = obj;
        this.b = oVar;
        this.c = oVar2;
        this.d = dVar;
        this.e = suspendLambda;
        this.f = oVar3;
    }

    public final void a() {
        Object obj = this.g;
        if (obj instanceof p) {
            ((p) obj).h(this.h, this.i.f5256a);
            return;
        }
        InterfaceC1693K interfaceC1693K = obj instanceof InterfaceC1693K ? (InterfaceC1693K) obj : null;
        if (interfaceC1693K != null) {
            interfaceC1693K.dispose();
        }
    }
}
