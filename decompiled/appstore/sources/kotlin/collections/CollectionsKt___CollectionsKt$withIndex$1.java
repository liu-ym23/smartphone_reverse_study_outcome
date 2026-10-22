package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class CollectionsKt___CollectionsKt$withIndex$1 extends Lambda implements Function0<Iterator<Object>> {
    final /* synthetic */ Iterable<Object> $this_withIndex;

    public CollectionsKt___CollectionsKt$withIndex$1(Iterable<Object> r10) {
        this.$this_withIndex = r10;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Iterator<Object> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Iterator<Object> invoke2() {
        return this.$this_withIndex.iterator();
    }
}
