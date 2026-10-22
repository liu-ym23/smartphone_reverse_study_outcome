package com.obric.oui.panel.header;

import android.widget.ImageView;
import com.obric.oui.titlebar.ONormalTitleBar;
import com.obric.oui.titlebar.OTitleBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/obric/oui/titlebar/OTitleBar;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class BasicPanelNormalTitleBarHeader$1 extends Lambda implements Function1<OTitleBar, Unit> {
    public static final BasicPanelNormalTitleBarHeader$1 INSTANCE = null;

    static {
        INSTANCE = new BasicPanelNormalTitleBarHeader$1();
    }

    public BasicPanelNormalTitleBarHeader$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(OTitleBar r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull OTitleBar r10) {
        q.g(r10, "$this$initHeader");
        if ((r10 instanceof ONormalTitleBar) == false) goto L13;
        ONormalTitleBar r11 = (ONormalTitleBar) r10;
        ImageView r12 = r11.getStartBtn();
        if (r12 == null) goto L8;
        r12.setPadding(f.r(r12, 10), f.r(r12, 10), f.r(r12, 10), f.r(r12, 10));
    L8:
        ImageView r13 = r11.getEndBtn();
        if (r13 == null) goto L14;
        r13.setPadding(f.r(r13, 10), f.r(r13, 10), f.r(r13, 10), f.r(r13, 10));
        return;
    L14:
        return;
    }
}
