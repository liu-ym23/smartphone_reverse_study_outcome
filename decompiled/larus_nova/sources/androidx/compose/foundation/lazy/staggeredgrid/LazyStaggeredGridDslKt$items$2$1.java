package androidx.compose.foundation.lazy.staggeredgrid;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class LazyStaggeredGridDslKt$items$2$1 implements Function1<Integer, Object> {
    final /* synthetic */ List<T> $items;
    final /* synthetic */ Function1<T, Object> $key;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridDslKt$items$2$1(Function1<? super T, ? extends Object> r100, List<? extends T> r101) {
        this.$key = r100;
        this.$items = r101;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invoke(int r100) {
        return this.$key.invoke((T) ListProtector.get(this.$items, r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer r100) {
        return invoke(r100.intValue());
    }
}
