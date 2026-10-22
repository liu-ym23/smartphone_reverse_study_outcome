package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21065a = null;

        static {
            int[] r10 = new int[LazyThreadSafetyMode.values().length];
            r10[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[LazyThreadSafetyMode.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f21065a = r10;
        }
    }

    public static Lazy a(LazyThreadSafetyMode r10, Function0 r11) {
        q.g(r10, "mode");
        q.g(r11, "initializer");
        int r12 = a.f21065a[r10.ordinal()];
        int r13 = 2;
        if (r12 == 1) goto L11;
        if (r12 == 2) goto L14;
        if (r12 != 3) goto L9;
        return new UnsafeLazyImpl(r11);
    L9:
        throw new NoWhenBranchMatchedException();
    L14:
        return new SafePublicationLazyImpl(r11);
    L11:
        DefaultConstructorMarker r14 = null;
        return new SynchronizedLazyImpl(r11, r14, r13, r14);
    }

    public static Lazy b(Function0 r10) {
        q.g(r10, "initializer");
        DefaultConstructorMarker r11 = null;
        return new SynchronizedLazyImpl(r10, r11, 2, r11);
    }
}
