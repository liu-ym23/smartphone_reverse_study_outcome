package androidx.room;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Landroidx/room/a;", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class AmbiguousColumnResolver$resolve$4 extends Lambda implements Function1<List<? extends a>, Unit> {
    final /* synthetic */ Ref$ObjectRef<b> $bestSolution;

    public AmbiguousColumnResolver$resolve$4(Ref$ObjectRef<b> r10) {
        this.$bestSolution = r10;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends a> r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.room.b] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull List<a> r10) {
        kotlin.jvm.internal.q.g(r10, "it");
        ?? r11 = b.f4518d.a(r10);
        if (r11.a(this.$bestSolution.element) >= 0) goto L6;
        this.$bestSolution.element = r11;
        return;
    }
}
