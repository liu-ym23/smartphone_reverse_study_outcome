package com.bytedance.common.wschannel.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsMessengerService extends Service implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Messenger f6900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakHandler f6901b;

    public AbsMessengerService() {
    }

    public final void a() {
        a.g(getApplication(), null);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        Logger.d("AbsMessengerService", "onBind " + this);
        return this.f6900a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        a();
        Logger.d("AbsMessengerService", "onCreate " + this);
        this.f6901b = new WeakHandler(this);
        this.f6900a = new Messenger(this.f6901b);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r10) {
        Logger.d("AbsMessengerService", "onUnBind " + this);
        return super.onUnbind(r10);
    }
}
