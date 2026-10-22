package com.ss.android.message.log;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedanceos.common.toolbox.ServerElements;
import com.ss.android.pushmanager.app.MessageAppHooks;
import df.a;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public class LogService extends Service implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Messenger f18187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f18188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HandlerThread f18189c;

    public LogService() {
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r11) {
        Logger.d("PushLog", "handleMsg msg.what = " + r11.what);     // Catch: Throwable -> L15
        int r10 = r11.what;     // Catch: Throwable -> L15
        int r12 = 0;
        if (r10 == 0) goto L20;
        if (r10 != 1) goto L41;
        Messenger r13 = r11.replyTo;     // Catch: Throwable -> L15
        if (r13 == null) goto L42;
        long[] r14 = ((Bundle) r11.obj).getLongArray("event_ids");     // Catch: Throwable -> L15
        if (r14 == null) goto L43;
        Logger.d("PushLog", "event_ids = " + com.bytedance.common.utility.collection.a.a(r14));     // Catch: Throwable -> L15
        if (this.f18188b != null) goto L17;
        r13.send(Message.obtain(null, 2));     // Catch: Throwable -> L15
        return;
    L17:
        int r15 = r14.length;     // Catch: Throwable -> L15
    L18:
        if (r12 >= r15) goto L46;
        this.f18188b.c(r14[r12]);     // Catch: Throwable -> L15
        r12 = r12 + 1;     // Catch: Throwable -> L15
        goto L18
    L46:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L20:
        Messenger r16 = r11.replyTo;     // Catch: Throwable -> L15
        if (r16 == null) goto L44;
        long r17 = ((Bundle) r11.obj).getLong("start_id", 0);     // Catch: Throwable -> L15
        a r18 = this.f18188b;     // Catch: Throwable -> L15
        if (r18 != null) goto L26;
        r16.send(Message.obtain(null, 2));     // Catch: Throwable -> L15
        return;
    L26:
        JSONArray r19 = r18.d(r17, 5);     // Catch: Throwable -> L15
        if (r19 != null) goto L30;
        r16.send(Message.obtain(null, 2));     // Catch: Throwable -> L15
        return;
    L30:
        Message r20 = Message.obtain(null, 0);     // Catch: Throwable -> L15
        Bundle r21 = new Bundle();     // Catch: Throwable -> L15
        r21.putString("events", r19.toString());     // Catch: Throwable -> L15
        if (r19.length() < 5) goto L34;
        r21.putBoolean(ServerElements.HAS_MORE, true);     // Catch: Throwable -> L15
    L35:
        Logger.d("PushLog", "events = " + r21.get("events") + " has_more = " + r21.get(ServerElements.HAS_MORE));     // Catch: Throwable -> L15
        r20.obj = r21;     // Catch: Throwable -> L15
        r16.send(r20);     // Catch: Throwable -> L15
        return;
    L34:
        r21.putBoolean(ServerElements.HAS_MORE, false);     // Catch: Throwable -> L15
        goto L35
    L44:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        Logger.d("PushLog", "onBind " + this);
        return this.f18187a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Logger.d("PushLog", "onCreate " + this);
        MessageAppHooks.InitHook r10 = MessageAppHooks.a();     // Catch: Throwable -> L9
        if (r10 == null) goto L6;
        r10.tryInit(this);     // Catch: Throwable -> L9
    L6:
        HandlerThread r11 = new HandlerThread("LogService");
        this.f18189c = r11;
        r11.start();
        this.f18187a = new Messenger(new WeakHandler(this.f18189c.getLooper(), this));
        this.f18188b = a.e(this);     // Catch: Throwable -> L10
        return;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a.a();
        HandlerThread r10 = this.f18189c;
        if (r10 == null) goto L6;
        r10.quit();
        return;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        return super.onStartCommand(r10, r11, r12);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r10) {
        Logger.d("PushLog", "onUnBind " + this);
        return super.onUnbind(r10);
    }
}
