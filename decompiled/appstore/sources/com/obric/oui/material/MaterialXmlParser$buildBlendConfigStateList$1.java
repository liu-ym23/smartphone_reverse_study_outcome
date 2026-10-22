package com.obric.oui.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class MaterialXmlParser$buildBlendConfigStateList$1 extends FunctionReferenceImpl implements Function2<com.obric.oui.color.a[], com.obric.oui.color.a[], Boolean> {
    public static final MaterialXmlParser$buildBlendConfigStateList$1 INSTANCE = null;

    static {
        INSTANCE = new MaterialXmlParser$buildBlendConfigStateList$1();
    }

    public MaterialXmlParser$buildBlendConfigStateList$1() {
        super(2, kotlin.collections.j.class, "contentDeepEquals", "contentDeepEqualsNullable([Ljava/lang/Object;[Ljava/lang/Object;)Z", 1);
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(@NotNull com.obric.oui.color.a[] r10, @Nullable com.obric.oui.color.a[] r11) {
        kotlin.jvm.internal.q.g(r10, "p0");
        return Boolean.valueOf(kotlin.collections.l.c(r10, r11));
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Boolean mo0invoke(com.obric.oui.color.a[] r10, com.obric.oui.color.a[] r11) {
        return invoke2(r10, r11);
    }
}
