package com.bytedance.android.annie.debug.ui;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UrlFormAdapter f39468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UrlFormViewHolder f39469b;

    public f(UrlFormAdapter r100, UrlFormViewHolder r101) {
        this.f39468a = r100;
        this.f39469b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = this.f39468a.f39446a.size();
        int r102 = this.f39469b.getAdapterPosition();
        boolean r103 = false;
        if (r102 < 0) goto L6;
        if (r102 >= r101) goto L6;
        r103 = true;
    L6:
        if (r103 == false) goto L16;
        g r104 = (g) ListProtector.get(this.f39468a.f39446a, this.f39469b.getAdapterPosition());
        UrlFormDialog r105 = new UrlFormDialog(this.f39468a.f39447b, r104.f39471b);
        if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r105);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r105);
        r105.show();
        DialogLancet.afterDialogShow(r105);
        return;
    }
}
