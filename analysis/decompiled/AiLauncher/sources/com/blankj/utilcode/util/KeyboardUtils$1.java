package com.blankj.utilcode.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/* loaded from: classes.dex */
class KeyboardUtils$1 extends ResultReceiver {
    public KeyboardUtils$1(Handler handler) {
        super(handler);
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i10, Bundle bundle) {
        if (i10 == 1 || i10 == 3) {
            g.c();
        }
    }
}
