package com.obric.oui.panel.header;

import com.obric.oui.titlebar.OTitleBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/obric/oui/titlebar/OTitleBar;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class BasicPanelHeaderKt$initHeader$1 extends Lambda implements Function1<OTitleBar, Unit> {
    public static final BasicPanelHeaderKt$initHeader$1 INSTANCE = null;

    static {
        INSTANCE = new BasicPanelHeaderKt$initHeader$1();
    }

    public BasicPanelHeaderKt$initHeader$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull OTitleBar r10) {
        q.g(r10, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(OTitleBar r10) {
        invoke2(r10);
        return Unit.f21064a;
    }
}
