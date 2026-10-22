package l3;

import java.lang.ref.ReferenceQueue;

/* loaded from: classes3.dex */
public class q implements r {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5280a;

    public q(Object obj) {
        this.f5280a = obj;
    }

    @Override // l3.r
    public final void a(Object obj) {
    }

    @Override // l3.r
    public final boolean b() {
        return false;
    }

    @Override // l3.r
    public final y c() {
        return null;
    }

    @Override // l3.r
    public final r d(ReferenceQueue referenceQueue, Object obj, y yVar) {
        return this;
    }

    @Override // l3.r
    public final Object get() {
        return this.f5280a;
    }

    @Override // l3.r
    public int getWeight() {
        return 1;
    }

    @Override // l3.r
    public final boolean isActive() {
        return true;
    }
}
