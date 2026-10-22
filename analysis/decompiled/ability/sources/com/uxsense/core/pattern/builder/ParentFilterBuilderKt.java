package com.uxsense.core.pattern.builder;

import S7.k;
import com.uxsense.core.pattern.ParentFilter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/Function1;", "Lcom/uxsense/core/pattern/builder/ParentFilterBuilder;", "LC7/r;", "block", "Lcom/uxsense/core/pattern/ParentFilter;", "parentFilter", "(LS7/k;)Lcom/uxsense/core/pattern/ParentFilter;", "uxsense_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ParentFilterBuilderKt {
    public static final ParentFilter parentFilter(k block) {
        kotlin.jvm.internal.k.f(block, "block");
        ParentFilterBuilder parentFilterBuilder = new ParentFilterBuilder();
        block.invoke(parentFilterBuilder);
        return parentFilterBuilder.build();
    }
}
