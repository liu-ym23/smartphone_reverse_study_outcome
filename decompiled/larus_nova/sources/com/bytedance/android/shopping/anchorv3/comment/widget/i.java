package com.bytedance.android.shopping.anchorv3.comment.widget;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.ec.model.response.Action;
import com.bytedance.android.ec.sdk.helper.p;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import jd3.n;

/* JADX INFO: loaded from: classes12.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentMoreActionDialog.MoreActionsViewHolder f164715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Action f164716b;

    public i(CommentMoreActionDialog.MoreActionsViewHolder r100, Action r101) {
        this.f164715a = r100;
        this.f164716b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        p.f48130a.openSchema(this.f164715a.f164661b.getContext(), this.f164716b.getSchema());
        CommentMoreActionDialog r101 = this.f164715a.f164661b;
        r101.f164655c = CommentMoreActionDialog.CloseReason.CLICK_ACTION;
        Action r102 = this.f164716b;
        n r103 = new n("comment_action_panel_click");
        Map<String, String> r104 = r101.f164656d.getTrackParams();
        if (r104 == null) goto L5;
        r103.f498389a.putAll(r104);
    L5:
        Map<String, String> r105 = r103.f498389a;
        String r106 = r102.getTitle();
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        r105.put("action", r106);
        r103.post(null, null);
        CommentMoreActionDialog r107 = this.f164715a.f164661b;
        Handler r108 = DialogLancet.resolveDialogHandler(r107);
        if (r108 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r107);
        r107.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r107);
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r109 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r109 == null) goto L22;
        com.bytedance.crash.d.d(r109, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r107);
        throw th;
    L11:
        if (Looper.myLooper() == r108.getLooper()) goto L13;
        r108.post(DialogLancet.createDismissRunnable(r107));
    }
}
