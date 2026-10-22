package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public final class n extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProxyChangeListener f18948a;

    public n(ProxyChangeListener r10) {
        this.f18948a = r10;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r11.getAction().equals("android.intent.action.PROXY_CHANGE") == false) goto L6;
        this.f18948a.n(r11);
        return;
    }
}
