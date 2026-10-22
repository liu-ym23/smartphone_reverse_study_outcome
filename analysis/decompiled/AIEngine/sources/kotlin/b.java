package kotlin;

import kotlin.jvm.internal.g;
import lb.d;
import lb.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class b {
    public static <T> d<T> a(LazyThreadSafetyMode lazyThreadSafetyMode, zb.a<? extends T> aVar) {
        k kVar = k.f10408a;
        int iOrdinal = lazyThreadSafetyMode.ordinal();
        if (iOrdinal == 0) {
            return new SynchronizedLazyImpl(aVar);
        }
        if (iOrdinal == 1) {
            SafePublicationLazyImpl safePublicationLazyImpl = new SafePublicationLazyImpl();
            safePublicationLazyImpl.f9990a = aVar;
            safePublicationLazyImpl.f9991b = kVar;
            return safePublicationLazyImpl;
        }
        if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        UnsafeLazyImpl unsafeLazyImpl = new UnsafeLazyImpl();
        unsafeLazyImpl.f9998a = aVar;
        unsafeLazyImpl.f9999b = kVar;
        return unsafeLazyImpl;
    }

    public static <T> d<T> b(zb.a<? extends T> initializer) {
        g.f(initializer, "initializer");
        return new SynchronizedLazyImpl(initializer);
    }
}
