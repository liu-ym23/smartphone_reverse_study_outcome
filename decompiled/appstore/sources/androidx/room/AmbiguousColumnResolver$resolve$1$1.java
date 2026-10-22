package androidx.room;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "startIndex", "endIndex", "", "", "resultColumnsSublist", "", "invoke", "(IILjava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAmbiguousColumnResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver$resolve$1$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,253:1\n11335#2:254\n11670#2,2:255\n11672#2:259\n288#3,2:257\n*S KotlinDebug\n*F\n+ 1 AmbiguousColumnResolver.kt\nandroidx/room/AmbiguousColumnResolver$resolve$1$1\n*L\n102#1:254\n102#1:255,2\n102#1:259\n103#1:257,2\n*E\n"})
final class AmbiguousColumnResolver$resolve$1$1 extends Lambda implements Function3<Integer, Integer, List<Object>, Unit> {
    final /* synthetic */ String[] $mapping;
    final /* synthetic */ int $mappingIndex;
    final /* synthetic */ List<List<a>> $mappingMatches;

    /* JADX WARN: Multi-variable type inference failed */
    public AmbiguousColumnResolver$resolve$1$1(String[] r10, List<? extends List<a>> r11, int r12) {
        this.$mapping = r10;
        this.$mappingMatches = r11;
        this.$mappingIndex = r12;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer r10, Integer r11, List<Object> r12) {
        invoke(r10.intValue(), r11.intValue(), r12);
        return Unit.f21064a;
    }

    public final void invoke(int r10, int r11, @NotNull List<Object> r12) {
        kotlin.jvm.internal.q.g(r12, "resultColumnsSublist");
        String[] r13 = this.$mapping;
        ArrayList r14 = new ArrayList(r13.length);
        if (r13.length <= 0) goto L10;
        String r15 = r13[0];
        Iterator<T> r16 = r12.iterator();
        if (r16.hasNext() == true) goto L8;
        androidx.appcompat.widget.p.a(null);
        return;
    L8:
        androidx.appcompat.widget.p.a(r16.next());
        throw null;
    L10:
        this.$mappingMatches.get(this.$mappingIndex).add(new a(new bg.c(r10, r11 - 1), r14));
    }
}
