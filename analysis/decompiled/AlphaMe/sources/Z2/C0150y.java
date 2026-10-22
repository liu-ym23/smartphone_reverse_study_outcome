package Z2;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: Z2.y, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0150y extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final C0150y f2260a = new C0150y(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CoroutineContext.Element element = (CoroutineContext.Element) obj;
        if (element instanceof A) {
            return (A) element;
        }
        return null;
    }
}
