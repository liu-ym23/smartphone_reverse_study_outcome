package d3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12468a = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_cur");

    @Volatile
    @Nullable
    private volatile Object _cur = new p(8, false);

    public final boolean a(Object obj) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12468a;
            p pVar = (p) atomicReferenceFieldUpdater.get(this);
            int iA = pVar.a(obj);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                atomicReferenceFieldUpdater.compareAndSet(this, pVar, pVar.c());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final int b() {
        p pVar = (p) f12468a.get(this);
        pVar.getClass();
        long j4 = p.f12471f.get(pVar);
        return 1073741823 & (((int) ((j4 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j4)));
    }

    public final Object c() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12468a;
            p pVar = (p) atomicReferenceFieldUpdater.get(this);
            Object objD = pVar.d();
            if (objD != p.f12472g) {
                return objD;
            }
            atomicReferenceFieldUpdater.compareAndSet(this, pVar, pVar.c());
        }
    }
}
