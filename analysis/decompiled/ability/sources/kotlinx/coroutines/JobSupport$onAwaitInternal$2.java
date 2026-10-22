package kotlinx.coroutines;

import S7.o;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import m9.C1727t;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class JobSupport$onAwaitInternal$2 extends FunctionReferenceImpl implements o {

    /* renamed from: a, reason: collision with root package name */
    public static final JobSupport$onAwaitInternal$2 f5180a = new JobSupport$onAwaitInternal$2();

    public JobSupport$onAwaitInternal$2() {
        super(3, c.class, "onAwaitInternalProcessResFunc", "onAwaitInternalProcessResFunc(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) throws Throwable {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.f5183a;
        ((c) obj).getClass();
        if (obj3 instanceof C1727t) {
            throw ((C1727t) obj3).f5333a;
        }
        return obj3;
    }
}
