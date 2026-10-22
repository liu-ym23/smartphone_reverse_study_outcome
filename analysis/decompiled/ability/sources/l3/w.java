package l3;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class w extends WeakReference implements r {

    /* renamed from: a, reason: collision with root package name */
    public final y f5283a;

    public w(ReferenceQueue referenceQueue, Object obj, y yVar) {
        super(obj, referenceQueue);
        this.f5283a = yVar;
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
        return this.f5283a;
    }

    @Override // l3.r
    public r d(ReferenceQueue referenceQueue, Object obj, y yVar) {
        return new w(referenceQueue, obj, yVar);
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
