package androidx.room;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "indices", "", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAmbiguousColumnResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver$resolve$1$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,253:1\n1#2:254\n*E\n"})
final class AmbiguousColumnResolver$resolve$1$2 extends Lambda implements Function1<List<? extends Integer>, Unit> {
    final /* synthetic */ int $mappingIndex;
    final /* synthetic */ List<List<a>> $mappingMatches;

    /* JADX WARN: Multi-variable type inference failed */
    public AmbiguousColumnResolver$resolve$1$2(List<? extends List<a>> r10, int r11) {
        this.$mappingMatches = r10;
        this.$mappingIndex = r11;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull List<Integer> r10) {
        kotlin.jvm.internal.q.g(r10, "indices");
        Iterator<T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L23;
        int r12 = ((Number) r11.next()).intValue();
    L6:
        if (r11.hasNext() == false) goto L10;
        int r13 = ((Number) r11.next()).intValue();
        if (r12 <= r13) goto L6;
        r12 = r13;
        goto L6
    L10:
        Iterator<T> r14 = r10.iterator();
        if (r14.hasNext() == false) goto L21;
        int r15 = ((Number) r14.next()).intValue();
    L14:
        if (r14.hasNext() == false) goto L18;
        int r16 = ((Number) r14.next()).intValue();
        if (r15 >= r16) goto L14;
        r15 = r16;
        goto L14
    L18:
        this.$mappingMatches.get(this.$mappingIndex).add(new a(new bg.c(r12, r15), r10));
        return;
    L21:
        throw new NoSuchElementException();
    L23:
        throw new NoSuchElementException();
    }
}
