package com.android.baselib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import o0.a;
import o0.b;

/* JADX INFO: loaded from: classes.dex */
public class MediaSDKReceiver extends BroadcastReceiver {
    public MediaSDKReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        a.d("Current Network:" + b.b(r10));
    }
}
