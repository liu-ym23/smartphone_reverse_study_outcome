package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class TransitionKt$animateValue$animationSpec$1$1<S> implements Function0<Transition.Segment<S>> {
    final /* synthetic */ Transition<S> $this_animateValue;

    public TransitionKt$animateValue$animationSpec$1$1(Transition<S> r100) {
        this.$this_animateValue = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Transition.Segment<S> invoke() {
        return this.$this_animateValue.getSegment();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        return invoke();
    }
}
