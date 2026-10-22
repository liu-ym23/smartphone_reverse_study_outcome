package com.android.contacts.util;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MenuDialogOnClickListener implements View.OnClickListener {
    private final int position;

    public abstract void onItemClick(View r1, int r2);

    public MenuDialogOnClickListener(int r1) {
        this.position = r1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        onItemClick(r2, this.position);
    }
}
