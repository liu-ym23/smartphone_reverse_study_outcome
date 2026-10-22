package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/reflect/a;", "it", "", "invoke", "(Lkotlin/reflect/a;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
final class TypeReference$asString$args$1 extends Lambda implements Function1<kotlin.reflect.a, CharSequence> {
    final /* synthetic */ z this$0;

    public TypeReference$asString$args$1(z r10) {
        super(1);
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(@NotNull kotlin.reflect.a r10) {
        q.g(r10, "it");
        return z.a(null, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(kotlin.reflect.a r10) {
        androidx.appcompat.widget.p.a(r10);
        return invoke2(null);
    }
}
