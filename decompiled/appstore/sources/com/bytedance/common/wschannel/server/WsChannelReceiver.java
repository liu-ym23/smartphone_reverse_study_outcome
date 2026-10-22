package com.bytedance.common.wschannel.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f7084c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NetworkUtils.NetworkType f7086b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WsChannelReceiver f7088b;

        public a(WsChannelReceiver r10, Context r11) {
            this.f7088b = r10;
            this.f7087a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            WsChannelReceiver.a(this.f7088b, this.f7087a);
            if (WsChannelReceiver.b() == true) goto L11;
            return;
        L11:
            if (Logger.debug() == false) goto L8;
            Logger.d("WsChannelReceiver", "ConnectivityReceiver");     // Catch: Exception -> L10
        L8:
            int r10 = NetworkUtils.a(this.f7087a);     // Catch: Exception -> L10
            Message r11 = Message.obtain();     // Catch: Exception -> L10
            r11.what = 3;     // Catch: Exception -> L10
            r11.arg1 = r10;     // Catch: Exception -> L10
            com.bytedance.common.wschannel.server.a.l(this.f7087a.getApplicationContext()).handleMsg(r11);     // Catch: Exception -> L10
            return;
        }
    }

    static {
    }

    public WsChannelReceiver() {
        this.f7085a = true;
        this.f7086b = NetworkUtils.b(com.bytedance.common.wschannel.a.e());
    }

    public static /* synthetic */ void a(WsChannelReceiver r10, Context r11) {
        r10.c(r11);
    }

    public static /* synthetic */ boolean b() {
        return f7084c;
    }

    public final void c(Context r10) {
        boolean r11 = com.bytedance.common.wschannel.b.d(r10).e();     // Catch: Throwable -> L6
        if (r11 == f7084c) goto L9;
        f7084c = r11;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r10 == null) goto L18;
        if (r11 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r11.getAction()) == false) goto L9;
        return;
    L9:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r11.getAction()) == true) goto L12;
        return;
    L12:
        if (this.f7085a == false) goto L16;
        this.f7085a = false;
        if (NetworkUtils.b(com.bytedance.common.wschannel.a.e()) != this.f7086b) goto L16;
        return;
    L16:
        w3.c.b(new a(this, r10));
        return;
    }
}
