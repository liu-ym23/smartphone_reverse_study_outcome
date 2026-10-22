package com.obric.oui.swipeaction;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "progress", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OSwipeDeleteAnimator$animateMoveImpl$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ b.a $moveInfo;
    final /* synthetic */ View $view;
    final /* synthetic */ b this$0;

    public OSwipeDeleteAnimator$animateMoveImpl$1(b r10, b.a r11, View r12) {
        this.$view = r12;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Float r10) {
        invoke(r10.floatValue());
        return Unit.f21064a;
    }

    public final void invoke(float r10) {
        if (b.j0(null).contains(null) == true) goto L5;
        return;
    L5:
        throw null;
    }
}
