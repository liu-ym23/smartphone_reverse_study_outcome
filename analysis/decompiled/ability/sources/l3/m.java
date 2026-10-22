package l3;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/* loaded from: classes3.dex */
public class m extends SoftReference implements r {

    /* renamed from: a, reason: collision with root package name */
    public final y f5277a;

    public m(ReferenceQueue referenceQueue, Object obj, y yVar) {
        super(obj, referenceQueue);
        this.f5277a = yVar;
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
        return this.f5277a;
    }

    @Override // l3.r
    public r d(ReferenceQueue referenceQueue, Object obj, y yVar) {
        return new m(referenceQueue, obj, yVar);
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
