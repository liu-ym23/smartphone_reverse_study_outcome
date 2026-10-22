package d3;

import Z2.F0;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class z extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public static final z f12485a = new z(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        F0 f02 = (F0) obj;
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        if (f02 != null) {
            return f02;
        }
        if (element instanceof F0) {
            return (F0) element;
        }
        return null;
    }
}
