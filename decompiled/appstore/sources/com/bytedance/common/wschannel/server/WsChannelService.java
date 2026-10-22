package com.bytedance.common.wschannel.server;

import android.content.Intent;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.AbsMessengerService;
import com.bytedance.common.wschannel.app.IWsApp;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelService extends AbsMessengerService {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f7090b;

        public a() {
        }
    }

    public WsChannelService() {
    }

    public static int b(IWsApp r10) {
        if (r10 != null) goto L6;
        return Integer.MIN_VALUE;
    L6:
        return r10.getChannelId();
    }

    public final void c(Intent r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r11 = r10.getAction();
        if (WsConstants.APP_STATE_ACTION.equals(r11) == false) goto L8;
        int r12 = r10.getIntExtra("app_state", -1);
        Message r13 = new Message();
        r13.what = 2;
        r13.arg1 = r12;
        handleMsg(r13);
        return;
    L8:
        if (WsConstants.NETWORK_STATE_ACTION.equals(r11) == false) goto L12;
        int r14 = r10.getIntExtra(WsConstants.KEY_NETWORK_STATE, -1);
        Message r15 = new Message();
        r15.what = 3;
        r15.arg1 = r14;
        handleMsg(r15);
        return;
    }

    @Override // com.bytedance.common.wschannel.app.AbsMessengerService, com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        super.handleMsg(r10);
        if (r10 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("WsChannelService", "handleMsg msg.what = " + r10.what);
    L8:
        com.bytedance.common.wschannel.server.a.l(this).handleMsg(r10);
    }

    @Override // com.bytedance.common.wschannel.app.AbsMessengerService, android.app.Service
    public void onCreate() {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onCreate");
    L5:
        super.onCreate();
        com.bytedance.common.wschannel.server.a.l(this);
    }

    @Override // com.bytedance.common.wschannel.app.AbsMessengerService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onStartCommand");
    L5:
        c(r10);
        return 1;
    }
}
