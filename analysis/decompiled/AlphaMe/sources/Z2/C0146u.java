package Z2;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* renamed from: Z2.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0146u extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public static final C0146u f2244a = new C0146u(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((CoroutineContext) obj).plus((CoroutineContext.Element) obj2);
    }
}
