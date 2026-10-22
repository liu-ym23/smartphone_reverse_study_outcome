package com.bytedance.common.wschannel.client;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class AbsWsClientService extends Service implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f7025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Messenger f7026b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f7027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbsWsClientService f7028b;

        public a(AbsWsClientService r10, Intent r11) {
            this.f7028b = r10;
            this.f7027a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsWsClientService.a(this.f7028b, this.f7027a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f7029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbsWsClientService f7030b;

        public b(AbsWsClientService r10, Intent r11) {
            this.f7030b = r10;
            this.f7029a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsWsClientService.a(this.f7030b, this.f7029a);
        }
    }

    public AbsWsClientService() {
        this.f7025a = new WeakHandler(this);
    }

    public static /* synthetic */ void a(AbsWsClientService r10, Intent r11) {
        r10.b(r11);
    }

    private void b(Intent r10) {
        if (r10 != null) goto L41;
        return;
    L41:
        String r11 = r10.getAction();     // Catch: Throwable -> L15
        if (WsConstants.RECEIVE_CONNECTION_ACTION.equals(r11) == false) goto L18;
        r10.setExtrasClassLoader(SocketState.class.getClassLoader());     // Catch: Throwable -> L15
        SocketState r12 = (SocketState) r10.getParcelableExtra(WsConstants.KEY_CONNECTION);     // Catch: Throwable -> L15
        ConnectionState r13 = f(r12.getChannelId(), r12.getConnectionState());     // Catch: Throwable -> L13
        OnMessageReceiveListener r14 = WsConstants.getListener(r12.getChannelId());     // Catch: Throwable -> L13
        if (r14 == null) goto L36;
        r14.onReceiveConnectEvent(new com.bytedance.common.wschannel.event.a(r13, r12.getChannelType(), r12.getChannelId()), r12.toJson());     // Catch: Throwable -> L13
    L36:
        if (Logger.debug() == false) goto L47;
        Logger.d("AbsWsClientService", "count = " + r10.getIntExtra(WsConstants.MSG_COUNT, -1));
        return;
    L47:
        return;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
        goto L36
    L18:
        if (WsConstants.SYNC_CONNECT_STATE.equals(r11) == false) goto L27;
        Logger.d("AbsWsClientService", "sync socket state");     // Catch: Throwable -> L15
        r10.setExtrasClassLoader(SocketState.class.getClassLoader());     // Catch: Throwable -> L15
        ArrayList r15 = r10.getParcelableArrayListExtra(WsConstants.KEY_CONNECTION);     // Catch: Throwable -> L15
        if (r15 == null) goto L36;
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L15
    L23:
        if (r16.hasNext() == false) goto L36;
        SocketState r17 = (SocketState) r16.next();     // Catch: Throwable -> L15
        if (r17 == null) goto L23;
        f(r17.getChannelId(), r17.getConnectionState());     // Catch: Throwable -> L15
        goto L23
    L27:
        r10.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L15
        if (WsConstants.RECEIVE_PAYLOAD_ACTION.equals(r11) == false) goto L31;
        WsChannelMsg r18 = (WsChannelMsg) r10.getParcelableExtra(WsConstants.KEY_PAYLOAD);     // Catch: Throwable -> L15
        Message r19 = new Message();     // Catch: Throwable -> L15
        r19.what = 40;     // Catch: Throwable -> L15
        r19.getData().putParcelable(WsConstants.KEY_PAYLOAD, r18);     // Catch: Throwable -> L15
        c(r19);     // Catch: Throwable -> L15
        goto L36
    L31:
        if (WsConstants.SEND_PAYLOAD_ACTION.equals(r11) == false) goto L36;
        String r20 = r10.getStringExtra(WsConstants.KEY_PAYLOAD_MD5);     // Catch: Throwable -> L15
        boolean r21 = r10.getBooleanExtra(WsConstants.KEY_SEND_RESULT, true);     // Catch: Throwable -> L15
        Message r22 = new Message();     // Catch: Throwable -> L15
        r22.what = 41;     // Catch: Throwable -> L15
        r22.getData().putString(WsConstants.KEY_PAYLOAD_MD5, r20);     // Catch: Throwable -> L15
        r22.getData().putBoolean(WsConstants.KEY_SEND_RESULT, r21);     // Catch: Throwable -> L15
        c(r22);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L36
    }

    public final void c(Message r10) {
        if (r10 != null) goto L24;
        return;
    L24:
        r10.getData().setClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L12
        int r11 = r10.what;     // Catch: Throwable -> L12
        if (r11 != 40) goto L16;
        Parcelable r12 = r10.getData().getParcelable(WsConstants.KEY_PAYLOAD);     // Catch: Throwable -> L12
        if ((r12 instanceof WsChannelMsg) == false) goto L25;
        WsChannelMsg r13 = (WsChannelMsg) r12;     // Catch: Throwable -> L12
        if (Logger.debug() == false) goto L14;
        Logger.d("AbsWsClientService", "get wsChannelMsg = " + r13.toString());     // Catch: Throwable -> L12
    L14:
        d(r13);     // Catch: Throwable -> L12
        return;
    L25:
        return;
    L16:
        if (r11 != 41) goto L27;
        String r14 = r10.getData().getString(WsConstants.KEY_PAYLOAD_MD5);     // Catch: Throwable -> L12
        boolean r15 = r10.getData().getBoolean(WsConstants.KEY_SEND_RESULT);     // Catch: Throwable -> L12
        if (Logger.debug() == false) goto L20;
        Logger.d("AbsWsClientService", "get payloadMd5 = " + r14 + " sendResult = " + r15);     // Catch: Throwable -> L12
    L20:
        e(r14, r15);     // Catch: Throwable -> L12
        return;
    L27:
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
    }

    public void d(WsChannelMsg r10) {
    }

    public void e(String r10, boolean r11) {
    }

    public final ConnectionState f(int r10, int r11) {
        ConnectionState r12 = ConnectionState.CONNECTION_UNKNOWN;
        if (r11 == 0) goto L18;
        if (r11 != 1) goto L9;
        r12 = ConnectionState.CONNECTING;
        goto L18
    L9:
        if (r11 != 2) goto L12;
        r12 = ConnectionState.CONNECT_FAILED;
        goto L18
    L12:
        if (r11 != 3) goto L15;
        r12 = ConnectionState.CONNECT_CLOSED;
        goto L18
    L15:
        if (r11 != 4) goto L18;
        r12 = ConnectionState.CONNECTED;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d("AbsWsClientService", "state = " + r11 + " connectionState = " + r12);
    L20:
        WsConstants.setConnectionState(r10, r12);
        return r12;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        if (r10 == null) goto L15;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (r10.what != 10123) goto L16;
        Intent r11 = (Intent) r10.getData().getParcelable(WsConstants.DATA_INTENT);     // Catch: Exception -> L10
        Logger.d("AbsWsClientService", "handleMsg = " + r11);     // Catch: Exception -> L10
        if (r11 == null) goto L17;
        cf.b.b().c(new b(this, r11));     // Catch: Exception -> L10
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        return this.f7026b.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f7026b = new Messenger(this.f7025a);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (Logger.debug() == false) goto L6;
        Logger.d("AbsWsClientService", "onDestroy");
        return;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        if (Logger.debug() == false) goto L9;
        StringBuilder r13 = new StringBuilder();
        r13.append("onStartCommand intent = ");
        if (r10 == null) goto L7;
        String r14 = r10.toString();
    L8:
        r13.append(r14);
        Logger.d("AbsWsClientService", r13.toString());
        goto L9
    L7:
        r14 = "null";
    L9:
        cf.b.b().c(new a(this, r10));
        return 2;
    }
}
