package com.android.server.am;

import android.content.Context;
import android.pico.utils.IExtBase;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface IExtSystemServerDialogHelper extends IExtBase {
    default View getAppNotRespondingDialog(Context context, String title, View.OnClickListener listener) {
        return null;
    }

    default View getAppErrorDialog(Context context, CharSequence title, View.OnClickListener listener) {
        return null;
    }
}
