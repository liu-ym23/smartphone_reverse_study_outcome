package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class SequencesKt___SequencesKt$onEach$1 extends Lambda implements Function1<Object, Object> {
    final /* synthetic */ Function1<Object, Unit> $action;

    public SequencesKt___SequencesKt$onEach$1(Function1<Object, Unit> r10) {
        this.$action = r10;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r10) {
        this.$action.invoke(r10);
        return r10;
    }
}
