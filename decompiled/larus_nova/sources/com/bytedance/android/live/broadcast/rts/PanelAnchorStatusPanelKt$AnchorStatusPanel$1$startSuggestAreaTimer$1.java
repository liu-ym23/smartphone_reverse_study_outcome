package com.bytedance.android.live.broadcast.rts;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.rts.foundation.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<no name provided>", "", "duration", "", "tabKey", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class PanelAnchorStatusPanelKt$AnchorStatusPanel$1$startSuggestAreaTimer$1 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ e $fallbackSuggestArea;
    final /* synthetic */ Function1 $onReceiveBizMessage;
    final /* synthetic */ Ref.ObjectRef $panelSuggestTimer;
    final /* synthetic */ Function1 $setSuggestUIState;

    public PanelAnchorStatusPanelKt$AnchorStatusPanel$1$startSuggestAreaTimer$1(Ref.ObjectRef r100, Function1 r101, e r102, Function1 r103) {
        this.$panelSuggestTimer = r100;
        this.$setSuggestUIState = r101;
        this.$fallbackSuggestArea = r102;
        this.$onReceiveBizMessage = r103;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, String r101) {
        invoke(r100.intValue(), r101);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, com.bytedance.rts.foundation.s] */
    public final void invoke(int r100, final String r101) {
        Intrinsics.checkNotNullParameter(r101, "tabKey");
        T r102 = this.$panelSuggestTimer.element;
        if (r102 == 0) goto L5;
        Intrinsics.checkNotNull(r102);
        u.b(r102);
        this.$panelSuggestTimer.element = null;
    L5:
        Ref.ObjectRef r103 = this.$panelSuggestTimer;
        r103.element = u.d(new AnonymousClass1(this, r101), r100 * 1000);
    }
}
