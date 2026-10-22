package com.bytedance.common.wschannel.app;

import android.app.Application;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.k;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsMessengerService extends PluginService implements WeakHandler.IHandler {
    protected WeakHandler mHandler;
    private Messenger mMessenger;

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }

    static /* synthetic */ void access$000(AbsMessengerService r2) {
        ((AbsMessengerService) ZeusTransformUtils.wrapperContextForParams(r2, AbsMessengerService.class, "com.obric.aiagent.plugin")).tryInitInPushProcess();
    }

    public AbsMessengerService() {
    }

    public void onCreate() {
        com.bytedance.common.utility.a.c.a(new AnonymousClass1(this));
        Logger.d("AbsMessengerService", "onCreate " + this);
        this.mHandler = new WeakHandler(this);
        this.mMessenger = new Messenger(this.mHandler);
    }

    private void tryInitInPushProcess() {
        k.a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Service*/.onDestroy();
    }

    public IBinder onBind(Intent r2) {
        Logger.d("AbsMessengerService", "onBind " + this);
        return this.mMessenger.getBinder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onUnbind(Intent r3) {
        Logger.d("AbsMessengerService", "onUnBind " + this);
        return super/*android.app.Service*/.onUnbind(r3);
    }
}
