package d3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function2;

/* renamed from: d3.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0542d {

    /* renamed from: a, reason: collision with root package name */
    public static final X.r f12448a = new X.r("CLOSED", 4);

    public static final Object a(v vVar, long j4, Function2 function2) {
        while (true) {
            if (vVar.f12481c >= j4 && !vVar.c()) {
                return vVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e.f12449a;
            Object obj = atomicReferenceFieldUpdater.get(vVar);
            X.r rVar = f12448a;
            if (obj == rVar) {
                return rVar;
            }
            v vVar2 = (v) ((e) obj);
            if (vVar2 == null) {
                vVar2 = (v) function2.invoke(Long.valueOf(vVar.f12481c + 1), vVar);
                if (atomicReferenceFieldUpdater.compareAndSet(vVar, null, vVar2)) {
                    if (vVar.c()) {
                        vVar.d();
                    }
                }
            }
            vVar = vVar2;
        }
    }
}
