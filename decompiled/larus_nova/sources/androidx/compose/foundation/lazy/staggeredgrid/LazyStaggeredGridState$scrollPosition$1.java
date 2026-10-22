package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class LazyStaggeredGridState$scrollPosition$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, int[]> {
    public LazyStaggeredGridState$scrollPosition$1(Object r100) {
        super(2, r100, LazyStaggeredGridState.class, "fillNearestIndices", "fillNearestIndices(II)[I", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ int[] invoke(Integer r100, Integer r101) {
        return invoke(r100.intValue(), r101.intValue());
    }

    public final int[] invoke(int r100, int r101) {
        return LazyStaggeredGridState.access$fillNearestIndices((LazyStaggeredGridState) this.receiver, r100, r101);
    }
}
