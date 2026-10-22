package kotlin;

import C7.f;
import C7.o;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public abstract class a {
    public static f a(S7.a initializer) {
        k.f(initializer, "initializer");
        return new SynchronizedLazyImpl(initializer);
    }

    public static f b(LazyThreadSafetyMode lazyThreadSafetyMode, S7.a initializer) {
        o oVar = o.f314a;
        k.f(initializer, "initializer");
        int iOrdinal = lazyThreadSafetyMode.ordinal();
        if (iOrdinal == 0) {
            return new SynchronizedLazyImpl(initializer);
        }
        if (iOrdinal == 1) {
            SafePublicationLazyImpl safePublicationLazyImpl = new SafePublicationLazyImpl();
            safePublicationLazyImpl.f4889a = initializer;
            safePublicationLazyImpl._value = oVar;
            return safePublicationLazyImpl;
        }
        if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        UnsafeLazyImpl unsafeLazyImpl = new UnsafeLazyImpl();
        unsafeLazyImpl.f4892a = initializer;
        unsafeLazyImpl.b = oVar;
        return unsafeLazyImpl;
    }
}
