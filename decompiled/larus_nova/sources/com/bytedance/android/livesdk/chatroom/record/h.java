package com.bytedance.android.livesdk.chatroom.record;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: classes7.dex */
public interface h {
    void dismissAllowingStateLoss();

    boolean p();

    void setOnDismissListener(DialogInterface.OnDismissListener r100);

    void show(FragmentManager r100, String r101);
}
