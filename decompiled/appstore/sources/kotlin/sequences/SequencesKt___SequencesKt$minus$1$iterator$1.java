package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class SequencesKt___SequencesKt$minus$1$iterator$1 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ Object $element;
    final /* synthetic */ Ref$BooleanRef $removed;

    public SequencesKt___SequencesKt$minus$1$iterator$1(Ref$BooleanRef r10, Object r11) {
        this.$removed = r10;
        this.$element = r11;
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(Object r10) {
        boolean r11 = true;
        if (this.$removed.element == true) goto L8;
        if (q.b(r10, this.$element) == false) goto L8;
        this.$removed.element = true;
        r11 = false;
    L8:
        return Boolean.valueOf(r11);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object r10) {
        return invoke(r10);
    }
}
