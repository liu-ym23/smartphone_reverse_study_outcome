package com.bytedance.android.shopping.anchorv3.comment.widget;

import android.view.View;
import com.bytedance.android.ec.model.response.MoreActions;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentHeaderView f164685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MoreActions f164686b;

    public d(CommentHeaderView r100, MoreActions r101) {
        this.f164685a = r100;
        this.f164686b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CommentMoreActionDialog r101 = new CommentMoreActionDialog(this.f164685a.getContext(), this.f164686b);
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r101);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
    }
}
