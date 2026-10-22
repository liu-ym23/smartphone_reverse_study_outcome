package com.android.server.autofill.ui;

import android.content.Context;
import android.pico.utils.IExtBase;
import android.view.WindowManager;
import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public interface IExtFillUi extends IExtBase {
    void setFillHeight(WindowManager.LayoutParams r1);

    void setListViewDivider(ListView r1, Context r2);
}
