package com.bytedance.android.livesdk.chatroom.ui;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes8.dex */
public final class n9 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TicketPriceInputDialogFragment f113735a;

    public n9(TicketPriceInputDialogFragment r100) {
        this.f113735a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TicketPriceInputDialogFragment r101 = this.f113735a;
        EditText r102 = r101.f112555f;
        if (r102 == null) goto L7;
        Editable r103 = r102.getText();
        if (r103 == null) goto L7;
        String r104 = r103.toString();
    L8:
        r101.T90(r104, false);
        return;
    L7:
        r104 = null;
        goto L8
    }
}
