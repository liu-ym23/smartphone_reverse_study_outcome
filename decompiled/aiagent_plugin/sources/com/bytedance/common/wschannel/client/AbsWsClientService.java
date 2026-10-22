package com.bytedance.common.wschannel.client;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsWsClientService extends PluginService implements WeakHandler.IHandler, b.a {
    public static final String TAG = "AbsWsClientService";
    private final Handler mHandler;
    private Messenger mMessenger;
    private final b parser;

    @Override // com.bytedance.common.wschannel.client.b.a
    public void onReceive(WsChannelMsg r1) {
    }

    @Override // com.bytedance.common.wschannel.client.b.a
    public void onSendResult(String r1, boolean r2) {
    }

    public AbsWsClientService() {
        this.mHandler = new WeakHandler(this);
        this.parser = new b(this);
    }

    static /* synthetic */ void access$000(AbsWsClientService r2, Intent r3, long r4) {
        ((AbsWsClientService) ZeusTransformUtils.wrapperContextForParams(r2, AbsWsClientService.class, "com.obric.aiagent.plugin")).handleIntent(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        this.mMessenger = new Messenger(this.mHandler);
    }

    public int onStartCommand(final Intent r3, int r4, int r5) {
        if (Logger.debug() == false) goto L9;
        StringBuilder r6 = new StringBuilder().append("onStartCommand intent = ");
        if (r3 == null) goto L7;
        String r7 = r3.toString();
    L8:
        Logger.d(TAG, r6.append(r7).toString());
        goto L9
    L7:
        r7 = "null";
    L9:
        final long r8 = com.bytedance.common.wschannel.e.b.a();
        com.bytedance.common.wschannel.g.a().a(new AnonymousClass1(this, r3, r8));
        return 2;
    }

    public IBinder onBind(Intent r1) {
        return this.mMessenger.getBinder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Service*/.onDestroy();
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onDestroy");
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r6) {
        final long r0 = com.bytedance.common.wschannel.e.b.a();     // Catch: Exception -> L14
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.what != 10123) goto L19;
        final Intent r7 = (Intent) ZeusTransformUtils.preCheckCast(r6.getData().getParcelable(WsConstants.DATA_INTENT), Intent.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "handleMsg = " + r7);     // Catch: Exception -> L14
    L10:
        if (r7 == null) goto L12;
        com.bytedance.common.wschannel.g.a().a(new AnonymousClass2(this, r7, r0));     // Catch: Exception -> L14
        return;
    L12:
        Logger.e(TAG, "handleMsg but intent isnull");     // Catch: Exception -> L14
        return;
    L19:
        return;
    L14:
        e = move-exception;
        Logger.e(e.toString());
    }

    private void handleIntent(Intent r2, long r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        com.bytedance.common.wschannel.model.a r0 = new com.bytedance.common.wschannel.model.a(r3);
        this.parser.a(r2, r0);
    }
}
