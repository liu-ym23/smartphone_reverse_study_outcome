package com.obric.common.oea.foundation.animation.easy;

import androidx.appcompat.widget.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "Landroid/view/View;", "it", "Lcom/obric/common/oea/foundation/animation/easy/ViewPropertySpringAnimator;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ViewPropertySpringAnimator$setListener$2 extends Lambda implements Function1<ViewPropertySpringAnimator, Unit> {
    public static final ViewPropertySpringAnimator$setListener$2 INSTANCE = null;

    static {
        INSTANCE = new ViewPropertySpringAnimator$setListener$2();
    }

    public ViewPropertySpringAnimator$setListener$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ViewPropertySpringAnimator r10) {
        q.g(r10, "it");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ViewPropertySpringAnimator r10) {
        p.a(r10);
        invoke2(null);
        return Unit.f21064a;
    }
}
