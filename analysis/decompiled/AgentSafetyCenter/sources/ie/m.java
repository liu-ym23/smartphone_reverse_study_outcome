package ie;

import java.lang.invoke.VarHandle;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class m implements c {

    /* renamed from: c, reason: collision with root package name */
    public final Executor f6017c;

    /* renamed from: f, reason: collision with root package name */
    public final c f6018f;

    public m(Executor executor, c cVar) {
        this.f6017c = executor;
        this.f6018f = cVar;
    }

    @Override // ie.c
    public final void cancel() {
        this.f6018f.cancel();
    }

    @Override // ie.c
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final c m3clone() {
        return new m(this.f6017c, this.f6018f.m3clone());
    }

    @Override // ie.c
    public final boolean g() {
        return this.f6018f.g();
    }

    @Override // ie.c
    public final void i(f fVar) {
        p5.u uVar = new p5.u(6);
        uVar.f9808g = this;
        uVar.f9807f = fVar;
        VarHandle.storeStoreFence();
        this.f6018f.i(uVar);
    }

    @Override // ie.c
    public final ad.z o() {
        return this.f6018f.o();
    }
}
