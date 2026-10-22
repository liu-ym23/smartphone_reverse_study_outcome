package com.obric.common.oea.style.scene.common;

import com.obric.common.oea.foundation.animation.builder.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "finished", "", "throwable", "", "invoke", "com/obric/common/oea/style/scene/common/AbstractModeSwitchAnimComposer$startEnterAnim$1$1"}, k = 3, mv = {1, 4, 3})
final class AbstractModeSwitchAnimComposer$startEnterAnim$$inlined$forEach$lambda$1 extends Lambda implements Function2<Boolean, Throwable, Unit> {
    final /* synthetic */ int $animCount$inlined;
    final /* synthetic */ Ref$IntRef $finishedCount$inlined;
    final /* synthetic */ Ref$BooleanRef $finishedSuccess$inlined;
    final /* synthetic */ b.a $it;
    final /* synthetic */ Function1 $onEnd$inlined;
    final /* synthetic */ Function2 $onSingleEnd$inlined;
    final /* synthetic */ a this$0;

    public AbstractModeSwitchAnimComposer$startEnterAnim$$inlined$forEach$lambda$1(b.a r10, a r11, Ref$BooleanRef r12, Ref$IntRef r13, Function2 r14, int r15, Function1 r16) {
        this.$it = r10;
        this.$finishedSuccess$inlined = r12;
        this.$finishedCount$inlined = r13;
        this.$onSingleEnd$inlined = r14;
        this.$animCount$inlined = r15;
        this.$onEnd$inlined = r16;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Unit mo0invoke(Boolean r10, Throwable r11) {
        invoke(r10.booleanValue(), r11);
        return Unit.f21064a;
    }

    public final void invoke(boolean r10, @Nullable Throwable r11) {
        if (r10 == true) goto L4;
        this.$finishedSuccess$inlined.element = false;
    L4:
        this.$finishedCount$inlined.element++;
        this.$onSingleEnd$inlined.mo0invoke(this.$it.c(), Boolean.valueOf(r10));
        if (this.$finishedCount$inlined.element != this.$animCount$inlined) goto L8;
        qb.b.f23627c.a(a.d(null), "startEnterAnim, anim complete, finishedSuccess? " + this.$finishedSuccess$inlined.element + ", time cost: " + (System.currentTimeMillis() - a.a(null)) + " ms");
        this.$onEnd$inlined.invoke(Boolean.valueOf(this.$finishedSuccess$inlined.element));
        a.b(null).clear();
        return;
    }
}
