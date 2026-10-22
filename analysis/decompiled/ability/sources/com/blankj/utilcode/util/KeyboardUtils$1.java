package com.blankj.utilcode.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;

/* loaded from: classes2.dex */
class KeyboardUtils$1 extends ResultReceiver {
    public KeyboardUtils$1(Handler handler) {
        super(handler);
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        InputMethodManager inputMethodManager;
        if ((i == 1 || i == 3) && (inputMethodManager = (InputMethodManager) S0.b.X0().getSystemService("input_method")) != null) {
            inputMethodManager.toggleSoftInput(0, 0);
        }
    }
}
