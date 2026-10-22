package kotlin.sequences;

import kotlin.Metadata;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlin/collections/f0;", "it", "invoke", "(Lkotlin/collections/f0;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
final class SequencesKt___SequencesKt$filterIndexed$2 extends Lambda implements Function1<f0, Object> {
    public static final SequencesKt___SequencesKt$filterIndexed$2 INSTANCE = null;

    static {
        INSTANCE = new SequencesKt___SequencesKt$filterIndexed$2();
    }

    public SequencesKt___SequencesKt$filterIndexed$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(f0 r10) {
        return invoke2(r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull f0 r10) {
        q.g(r10, "it");
        return r10.b();
    }
}
