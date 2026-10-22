package com.obric.oui.popover.menu;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "R", "it", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "kotlin/sequences/SequencesKt___SequencesKt$filterIsInstance$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OPopoverEntranceMenuView$getItemView$$inlined$filterIsInstance$1 extends Lambda implements Function1<Object, Boolean> {
    public static final OPopoverEntranceMenuView$getItemView$$inlined$filterIsInstance$1 INSTANCE = null;

    static {
        INSTANCE = new OPopoverEntranceMenuView$getItemView$$inlined$filterIsInstance$1();
    }

    public OPopoverEntranceMenuView$getItemView$$inlined$filterIsInstance$1() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(@Nullable Object r10) {
        return Boolean.valueOf(r10 instanceof PopoverMenuLinearLayout);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object r10) {
        return invoke(r10);
    }
}
