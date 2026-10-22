package androidx.compose.foundation.lazy;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1 implements Function1<Integer, Object> {
    final /* synthetic */ List $items;

    public LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(List r100) {
        this.$items = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer r100) {
        return invoke(r100.intValue());
    }

    public final Object invoke(int r100) {
        ListProtector.get(this.$items, r100);
        return null;
    }
}
