package com.bytedance.common.wschannel.channel.impl.ok;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements IWsChannelClient, WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f6964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f6965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WsOkClient f6966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f6968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f6969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ContentObserver f6970h;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.channel.impl.ok.a$a, reason: collision with other inner class name */
    public class C0086a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f6971a;

        public C0086a(a r10, Handler r11) {
            this.f6971a = r10;
            super(r11);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r10) {
            super.onChange(r10);
            a r11 = this.f6971a;
            if (a.b(r11, a.a(r11)) == false) goto L5;
            a r12 = this.f6971a;
            r12.openConnection(a.c(r12), a.d(this.f6971a));
            return;
        L5:
            this.f6971a.stopConnection();
        }
    }

    public a(int r10, Handler r11) {
        this.f6968f = new HashMap();
        this.f6970h = new C0086a(this, this.f6965c);
        this.f6963a = r10;
        this.f6965c = r11;
    }

    public static /* synthetic */ Context a(a r10) {
        return r10.f6964b;
    }

    public static /* synthetic */ boolean b(a r10, Context r11) {
        return r10.f(r11);
    }

    public static /* synthetic */ Map c(a r10) {
        return r10.f6968f;
    }

    public static /* synthetic */ List d(a r10) {
        return r10.f6969g;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        Log.d("WsChannelSdk_ok", "destroy() , channelId = " + this.f6963a);
        this.f6966d.B();
        g();
    }

    public final void e(Context r10) {
        r10.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.h(r10, WsConstants.KEY_OK_IMPL_ENABLE, "boolean"), true, this.f6970h);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public final boolean f(Context r10) {
        return com.bytedance.common.wschannel.b.d(r10).f();
    }

    public final void g() {
        Context r10 = this.f6964b;     // Catch: Throwable -> L6
        if (r10 == null) goto L11;
        r10.getContentResolver().unregisterContentObserver(this.f6970h);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r10, IWsChannelClient r11) {
        if (this.f6967e == false) goto L5;
        return;
    L5:
        this.f6967e = true;
        Log.d("WsChannelSdk_ok", "init() , channelId = " + this.f6963a);
        this.f6964b = r10.getApplicationContext();
        WsOkClient r12 = new WsOkClient.h(r10).c(new b4.b(r10)).b(com.bytedance.common.wschannel.a.f(this.f6963a)).a();
        this.f6966d = r12;
        r12.a0(new c(this.f6964b, r12, r11));
        e(r10);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        return this.f6966d.I();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r10) {
        if (f(this.f6964b) == true) goto L5;
        return;
    L5:
        Log.d("WsChannelSdk_ok", "onAppStateChanged(), channelId = " + this.f6963a);
        WsOkClient r11 = this.f6966d;
        boolean r12 = true;
        if (r10 == 1) goto L9;
        r12 = false;
    L9:
        r11.M(r12);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r10) {
        Log.d("WsChannelSdk_ok", "onConnection()");
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r10) {
        Log.d("WsChannelSdk_ok", "onMessage(),channel = " + this.f6963a);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r10) {
        if (f(this.f6964b) == true) goto L5;
        return;
    L5:
        Log.d("WsChannelSdk_ok", "onNetworkStateChanged(), channelId = " + this.f6963a);
        this.f6966d.N(r10);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map r10, List r11) {
        if (r10 == null) goto L4;
        this.f6968f.putAll(r10);
    L4:
        this.f6969g = r11;
        if (f(this.f6964b) == true) goto L7;
        return;
    L7:
        Log.d("WsChannelSdk_ok", "onParameterChange(),channelId = " + this.f6963a);
        this.f6966d.O(r10, r11);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map r10, List r11) {
        if (r10 == null) goto L4;
        this.f6968f.putAll(r10);
    L4:
        this.f6969g = r11;
        if (f(this.f6964b) == true) goto L7;
        return;
    L7:
        this.f6966d.z(r10, r11);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r10) {
        if (f(this.f6964b) == true) goto L6;
        return false;
    L6:
        Log.d("WsChannelSdk_ok", "sendMessage(),channelId = " + this.f6963a);
        return this.f6966d.X(r10);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        Log.d("WsChannelSdk_ok", "stopConnection(),channelId = " + this.f6963a);
        this.f6966d.b0();
    }
}
