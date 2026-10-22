package com.obric.oui.dialog.base;

import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator;", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class AbstractDialogModal$performEnterAnimation$1$1 extends Lambda implements Function1<ViewPropertySpringAnimator, Unit> {
    final /* synthetic */ AbstractDialogModal this$0;

    public AbstractDialogModal$performEnterAnimation$1$1(AbstractDialogModal r10) {
        this.this$0 = r10;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ViewPropertySpringAnimator r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ViewPropertySpringAnimator r10) {
        q.g(r10, "it");
        if (this.this$0.getDialogRootView().getAlpha() != 0.0f) goto L6;
        this.this$0.getDialogRootView().setAlpha(1.0f);
        return;
    }
}
