package com.obric.oui.swipeaction;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "finished", "", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OSwipeDeleteAnimator$startOeaAnimation$2 extends Lambda implements Function2<Boolean, Throwable, Unit> {
    final /* synthetic */ Function0<Unit> $onEnd;

    public OSwipeDeleteAnimator$startOeaAnimation$2(Function0<Unit> r10) {
        this.$onEnd = r10;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Unit mo0invoke(Boolean r10, Throwable r11) {
        invoke(r10.booleanValue(), r11);
        return Unit.f21064a;
    }

    public final void invoke(boolean r10, @Nullable Throwable r11) {
        if (r10 == false) goto L5;
        this.$onEnd.invoke();
        return;
    }
}
