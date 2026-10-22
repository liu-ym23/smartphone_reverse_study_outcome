package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.i;
import kotlin.j;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lkotlin/i;", "invoke", "()Ljava/util/Iterator;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
final class UArraysKt___UArraysKt$withIndex$2 extends Lambda implements Function0<Iterator<? extends i>> {
    final /* synthetic */ long[] $this_withIndex;

    public UArraysKt___UArraysKt$withIndex$2(long[] r10) {
        this.$this_withIndex = r10;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Iterator<? extends i> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Iterator<? extends i> invoke2() {
        return j.a(this.$this_withIndex);
    }
}
