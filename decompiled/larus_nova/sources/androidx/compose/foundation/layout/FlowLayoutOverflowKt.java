package androidx.compose.foundation.layout;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"lazyInt", "Lkotlin/Lazy;", "", "errorMessage", "", "initializer", "Lkotlin/Function0;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FlowLayoutOverflowKt {
    public static final Lazy<Integer> lazyInt(String r100, Function0<Integer> r101) {
        return new LazyImpl(r101, r100);
    }

    public static /* synthetic */ Lazy lazyInt$default(String r100, Function0 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "Lazy item is not yet initialized";
    L6:
        return lazyInt(r100, r101);
    }
}
