package com.blankj.utilcode.util;

import android.view.View;
import androidx.annotation.StringRes;

/* JADX INFO: loaded from: classes.dex */
interface ToastUtils$IToast {
    void cancel();

    View getView();

    void setDuration(int r10);

    void setGravity(int r10, int r11, int r12);

    void setText(@StringRes int r10);

    void setText(CharSequence r10);

    void setView(View r10);

    void show();
}
