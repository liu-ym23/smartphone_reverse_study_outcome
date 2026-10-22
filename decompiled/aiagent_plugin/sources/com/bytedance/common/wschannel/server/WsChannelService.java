package com.bytedance.common.wschannel.server;

import android.content.Intent;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.AbsMessengerService;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelService extends AbsMessengerService {

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f7027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final byte[] f7028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f7029c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final WsChannelMsg f7030d;

        a(int r1, byte[] r2, long r3) {
            this.f7027a = r1;
            this.f7028b = r2;
            this.f7029c = r3;
            this.f7030d = null;
        }

        a(int r1, WsChannelMsg r2, long r3) {
            this.f7027a = r1;
            this.f7030d = r2;
            this.f7029c = r3;
            this.f7028b = null;
        }
    }

    static /* synthetic */ void access$000(WsChannelService r2, Intent r3) {
        ((WsChannelService) ZeusTransformUtils.wrapperContextForParams(r2, WsChannelService.class, "com.obric.aiagent.plugin")).handleIntent(r3);
    }

    public WsChannelService() {
    }

    static int getClientKey(IWsApp r2) {
        IWsApp r3 = (IWsApp) ZeusTransformUtils.wrapperContextForParams(r2, IWsApp.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return Integer.MIN_VALUE;
    L7:
        return r3.getChannelId();
    }

    @Override // com.bytedance.common.wschannel.app.AbsMessengerService
    public void onCreate() {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onCreate");
    L5:
        super.onCreate();
    }

    @Override // com.bytedance.common.wschannel.app.AbsMessengerService
    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(final Intent r1, int r2, int r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "onStartCommand");
    L5:
        com.bytedance.common.utility.a.c.a(new AnonymousClass1(this, r1));
        return 2;
    }

    private void handleIntent(Intent r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        String r0 = r4.getAction();
        if (WsConstants.APP_STATE_ACTION.equals(r0) == false) goto L8;
        int r5 = r4.getIntExtra(WsConstants.KEY_APP_STATE, -1);
        Message r1 = new Message();
        r1.what = 2;
        r1.arg1 = r5;
        handleMsg(r1);
        return;
    L8:
        if (WsConstants.NETWORK_STATE_ACTION.equals(r0) == false) goto L11;
        int r6 = r4.getIntExtra(WsConstants.KEY_NETWORK_STATE, -1);
        Message r2 = new Message();
        r2.what = 3;
        r2.arg1 = r6;
        handleMsg(r2);
        return;
    L11:
        if (WsConstants.MEM_TRIM_ACTION.equals(r0) == false) goto L18;
        int r3 = r4.getIntExtra(WsConstants.KEY_MEM_TRIM, -1);
        com.bytedance.common.wschannel.e r7 = com.bytedance.common.wschannel.k.a();
        if (r7 == null) goto L19;
        r7.a(r3);
        return;
    L19:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.common.wschannel.app.AbsMessengerService, com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r3) {
        super.handleMsg(r3);
        if (r3 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("WsChannelService", "handleMsg msg.what = " + r3.what);
    L8:
        j.a(this).handleMsg(r3);
    }
}
