package com.bytedance.android.annie.debug.ui;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes43.dex */
public final class i extends DialogItem {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Uri f39474g;

    @Override // com.bytedance.android.annie.debug.ui.DialogItem
    public final void a(Context r100) {
        Uri r101 = this.f39474g;
        if (r101 == null) goto L11;
        if (r100 == null) goto L11;
        UrlFormDialog r102 = new UrlFormDialog(r100, r101);
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r102);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L10:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
        return;
    L11:
        super.a(r100);
    }

    public i(String r100, String r101) {
        super(r100, r101, null);
        this.f39474g = UriProtector.parse(r101);
    }
}
