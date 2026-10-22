package com.bytedance.android.live.profit.taskcenter;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes47.dex */
public interface b extends DialogInterface.OnDismissListener {
    @Override // android.content.DialogInterface.OnDismissListener
    void onDismiss(DialogInterface r100);

    void readyToShow();

    void showing(DialogInterface r100);

    void waiting();
}
