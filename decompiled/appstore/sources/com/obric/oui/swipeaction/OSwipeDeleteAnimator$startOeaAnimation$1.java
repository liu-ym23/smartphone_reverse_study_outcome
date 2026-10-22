package com.obric.oui.swipeaction;

import com.bytedance.apm.constant.CommonKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", CommonKey.KEY_VALUE, "", "<anonymous parameter 2>", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OSwipeDeleteAnimator$startOeaAnimation$1 extends Lambda implements Function3<String, Object, Object, Unit> {
    final /* synthetic */ Function1<Float, Unit> $onUpdate;

    /* JADX WARN: Multi-variable type inference failed */
    public OSwipeDeleteAnimator$startOeaAnimation$1(Function1<? super Float, Unit> r10) {
        this.$onUpdate = r10;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String r10, Object r11, Object r12) {
        invoke2(r10, r11, r12);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull String r10, @NotNull Object r11, @NotNull Object r12) {
        q.g(r10, "$noName_0");
        q.g(r11, CommonKey.KEY_VALUE);
        q.g(r12, "$noName_2");
        this.$onUpdate.invoke((Float) r11);
    }
}
