package Z2;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: Z2.c0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0119c0 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final C0119c0 f2210a = new C0119c0(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CoroutineContext.Element element = (CoroutineContext.Element) obj;
        if (element instanceof AbstractC0123e0) {
            return (AbstractC0123e0) element;
        }
        return null;
    }
}
