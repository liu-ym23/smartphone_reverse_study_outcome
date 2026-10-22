package kotlinx.coroutines.sync;

import S7.o;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.k;
import w9.d;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class MutexImpl$onLock$2 extends FunctionReferenceImpl implements o {

    /* renamed from: a, reason: collision with root package name */
    public static final MutexImpl$onLock$2 f5258a = new MutexImpl$onLock$2();

    public MutexImpl$onLock$2() {
        super(3, a.class, "onLockProcessResult", "onLockProcessResult(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        a aVar = (a) obj;
        aVar.getClass();
        if (k.b(obj3, d.b)) {
            throw new IllegalStateException(androidx.compose.foundation.b.r(obj2, "This mutex is already locked by the specified owner: "));
        }
        return aVar;
    }
}
