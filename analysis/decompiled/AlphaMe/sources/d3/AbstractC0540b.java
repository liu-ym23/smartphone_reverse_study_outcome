package d3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;

/* renamed from: d3.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0540b extends r {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12446a = AtomicReferenceFieldUpdater.newUpdater(AbstractC0540b.class, Object.class, "_consensus");

    @Volatile
    @Nullable
    private volatile Object _consensus = AbstractC0539a.f12442a;

    @Override // d3.r
    public final Object a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12446a;
        Object objC = atomicReferenceFieldUpdater.get(this);
        X.r rVar = AbstractC0539a.f12442a;
        if (objC == rVar) {
            objC = c(obj);
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 != rVar) {
                objC = obj2;
            } else if (!atomicReferenceFieldUpdater.compareAndSet(this, rVar, objC)) {
                objC = atomicReferenceFieldUpdater.get(this);
            }
        }
        b(obj, objC);
        return objC;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract X.r c(Object obj);
}
