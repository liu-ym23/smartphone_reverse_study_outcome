package kotlin;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\t"}, d2 = {"lazy", "Lkotlin/Lazy;", ExifInterface.GPS_DIRECTION_TRUE, "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/LazyKt")
class LazyKt__LazyJVMKt {

    /* JADX INFO: compiled from: LazyJVM.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[LazyThreadSafetyMode.values().length];
            r0[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[LazyThreadSafetyMode.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public LazyKt__LazyJVMKt() {
    }

    public static final <T> Lazy<T> lazy(Function0<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r3, "initializer");
        DefaultConstructorMarker r1 = null;
        return new SynchronizedLazyImpl(r3, r1, 2, r1);
    }

    public static final <T> Lazy<T> lazy(LazyThreadSafetyMode r2, Function0<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        Intrinsics.checkNotNullParameter(r3, "initializer");
        int r4 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        int r1 = 2;
        if (r4 == 1) goto L11;
        if (r4 == 2) goto L14;
        if (r4 != 3) goto L9;
        return new UnsafeLazyImpl(r3);
    L9:
        throw new NoWhenBranchMatchedException();
    L14:
        return new SafePublicationLazyImpl(r3);
    L11:
        DefaultConstructorMarker r0 = null;
        return new SynchronizedLazyImpl(r3, r0, r1, r0);
    }

    public static final <T> Lazy<T> lazy(Object r1, Function0<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "initializer");
        return new SynchronizedLazyImpl(r2, r1);
    }
}
