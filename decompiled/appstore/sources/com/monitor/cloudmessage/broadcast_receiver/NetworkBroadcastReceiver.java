package com.monitor.cloudmessage.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.k;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkBroadcastReceiver extends BroadcastReceiver {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f10473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NetworkBroadcastReceiver f10474b;

        public a(NetworkBroadcastReceiver r10, Context r11) {
            this.f10474b = r10;
            this.f10473a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.b(this.f10473a) == false) goto L6;
            v9.a.k().e();
            return;
        }
    }

    public NetworkBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        AsyncEventManager.e().h(new a(this, r10));
    }
}
