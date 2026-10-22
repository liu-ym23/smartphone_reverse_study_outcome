package com.blankj.utilcode.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class KeyboardUtils {

    /* JADX INFO: renamed from: com.blankj.utilcode.util.KeyboardUtils$1, reason: invalid class name */
    class AnonymousClass1 extends ResultReceiver {
        public AnonymousClass1(Handler r10) {
            super(r10);
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int r10, Bundle r11) {
            if (r10 != 1) goto L5;
        L6:
            KeyboardUtils.a();
            return;
        L5:
            if (r10 == 3) goto L6;
        }
    }

    public interface OnSoftInputChangedListener {
        void onSoftInputChanged(int r10);
    }

    static {
    }

    public static void a() {
        InputMethodManager r10 = (InputMethodManager) Utils.c().getSystemService("input_method");
        if (r10 != null) goto L5;
        return;
    L5:
        r10.toggleSoftInput(0, 0);
    }
}
