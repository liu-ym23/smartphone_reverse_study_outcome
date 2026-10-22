package com.bytedance.android.live.recharge.exchange.dialog;

import com.bytedance.android.live.recharge.model.ExchangeType;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbsCashExchangeDialog f89855a;

    public final void b() {
        AbsCashExchangeDialog r100 = this.f89855a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L11;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L11:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public e(AbsCashExchangeDialog r100) {
        this.f89855a = r100;
        if (r100 == null) goto L6;
        r100.setCancelable(false);
        r100.setCanceledOnTouchOutside(false);
        r100.setOnDismissListener(new d(this));
        return;
    }

    public final void a(ExchangeType r110, k r111, long r112, String r113, boolean r114, Map<String, String> r115, zv0.e r116) {
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r115, "extraMap");
        AbsCashExchangeDialog r100 = this.f89855a;
        if (r100 == null) goto L6;
        r100.I0(r110, r111, r112, r113, r114, r115, r116);
        return;
    }
}
