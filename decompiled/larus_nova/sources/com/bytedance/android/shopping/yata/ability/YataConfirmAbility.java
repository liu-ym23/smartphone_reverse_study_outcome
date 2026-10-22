package com.bytedance.android.shopping.yata.ability;

import android.content.Context;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class YataConfirmAbility implements v96.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f187472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f187473b;

    @Override // v96.b
    public final void a(final com.bytedance.kmp.ec.yata.event.ability.confirm.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Function1<ECAlertDialog, Unit> r101 = new YataConfirmAbility$showConfirm$1(this, r100);
        ECAlertDialog r102 = new ECAlertDialog(this.f187472a, R.style.YataConfirmDialogStyle);
        r102.enableLargeFont(this.f187473b);
        r101.invoke(r102);
        r102.setCancelable(false);
        r102.setCanceledOnTouchOutside(false);
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r102);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
    }

    public YataConfirmAbility(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f187472a = r100;
        this.f187473b = r101;
    }
}
