package androidx.compose.foundation.lazy.staggeredgrid;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class LazyStaggeredGridDslKt$itemsIndexed$2$1 implements Function1<Integer, Object> {
    final /* synthetic */ List<T> $items;
    final /* synthetic */ Function2<Integer, T, Object> $key;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridDslKt$itemsIndexed$2$1(Function2<? super Integer, ? super T, ? extends Object> r100, List<? extends T> r101) {
        this.$key = r100;
        this.$items = r101;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invoke(int r100) {
        return this.$key.invoke(Integer.valueOf(r100), (T) ListProtector.get(this.$items, r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer r100) {
        return invoke(r100.intValue());
    }
}
