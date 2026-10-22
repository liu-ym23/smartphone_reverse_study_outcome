package com.android.ttcjpaysdk.ttcjpayapi;

import android.app.Activity;

/* JADX INFO: loaded from: classes39.dex */
public interface IBlockDialog {

    public interface IDialogCallback {
        void onClose();
    }

    void showBlockDialog(Activity r100, boolean r101, IDialogCallback r102);
}
