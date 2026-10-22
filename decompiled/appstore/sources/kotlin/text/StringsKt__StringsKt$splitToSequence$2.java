package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lbg/c;", "it", "", "invoke", "(Lbg/c;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
final class StringsKt__StringsKt$splitToSequence$2 extends Lambda implements Function1<bg.c, String> {
    final /* synthetic */ CharSequence $this_splitToSequence;

    public StringsKt__StringsKt$splitToSequence$2(CharSequence r10) {
        this.$this_splitToSequence = r10;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(bg.c r10) {
        return invoke2(r10);
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(@NotNull bg.c r10) {
        kotlin.jvm.internal.q.g(r10, "it");
        return StringsKt__StringsKt.q0(this.$this_splitToSequence, r10);
    }
}
