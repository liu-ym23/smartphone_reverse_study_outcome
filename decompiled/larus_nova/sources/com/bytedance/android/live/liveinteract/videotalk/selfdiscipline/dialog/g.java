package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelfDisciplineManagerDialogV2 f79719a;

    public g(SelfDisciplineManagerDialogV2 r100) {
        this.f79719a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SelfDisciplineManagerDialogV2 r101 = this.f79719a;
        int r102 = SelfDisciplineManagerDialogV2.f79688o;
        r101.getClass();
        SelfDisciplineDurationSelectDialog r103 = new SelfDisciplineDurationSelectDialog(r101.getContext(), r101, (int) r101.f79701m);
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r103);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
    }
}
