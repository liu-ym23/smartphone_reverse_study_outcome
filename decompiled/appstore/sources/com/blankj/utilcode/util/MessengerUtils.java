package com.blankj.utilcode.util;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class MessengerUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap f6182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map f6183b;

    public interface MessageCallback {
        void messageCall(Bundle r10);
    }

    public static class ServerService extends Service {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap f6184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f6185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Messenger f6186c;

        public class a extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ServerService f6187a;

            public a(ServerService r10) {
                this.f6187a = r10;
            }

            @Override // android.os.Handler
            public void handleMessage(Message r10) {
                int r11 = r10.what;
                if (r11 != 0) goto L5;
                ServerService.a(this.f6187a).put(Integer.valueOf(r10.arg1), r10.replyTo);
                return;
            L5:
                if (r11 != 1) goto L7;
                ServerService.a(this.f6187a).remove(Integer.valueOf(r10.arg1));
                return;
            L7:
                if (r11 == 2) goto L9;
                super.handleMessage(r10);
                return;
            L9:
                ServerService.b(this.f6187a, r10);
                ServerService.c(this.f6187a, r10);
            }
        }

        public ServerService() {
            this.f6184a = new ConcurrentHashMap();
            a r10 = new a(this);
            this.f6185b = r10;
            this.f6186c = new Messenger(r10);
        }

        public static /* synthetic */ ConcurrentHashMap a(ServerService r10) {
            return r10.f6184a;
        }

        public static /* synthetic */ void b(ServerService r10, Message r11) {
            r10.e(r11);
        }

        public static /* synthetic */ void c(ServerService r10, Message r11) {
            r10.d(r11);
        }

        public final void d(Message r10) {
            Bundle r11 = r10.getData();
            if (r11 == null) goto L10;
            String r12 = r11.getString("MESSENGER_UTILS");
            if (r12 == null) goto L11;
            MessageCallback r13 = (MessageCallback) MessengerUtils.a().get(r12);
            if (r13 == null) goto L12;
            r13.messageCall(r11);
            return;
        L12:
            return;
        L11:
            return;
        }

        public final void e(Message r10) {
            Iterator r11 = this.f6184a.values().iterator();
        L4:
            if (r11.hasNext() == false) goto L11;
            Messenger r12 = (Messenger) r11.next();
            if (r12 == null) goto L4;
            r12.send(r10);     // Catch: RemoteException -> L9
        L9:
            e = move-exception;
            e.printStackTrace();
            goto L4
        }

        @Override // android.app.Service
        public IBinder onBind(Intent r10) {
            return this.f6186c.getBinder();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent r10, int r11, int r12) {
            if (r10 != null) goto L11;
        L10:
            return 2;
        L11:
            Bundle r13 = r10.getExtras();     // Catch: RuntimeException -> L8
            if (r13 == null) goto L10;
            Message r14 = Message.obtain(this.f6185b, 2);     // Catch: RuntimeException -> L8
            r14.replyTo = this.f6186c;     // Catch: RuntimeException -> L8
            r14.setData(r13);     // Catch: RuntimeException -> L8
            e(r14);     // Catch: RuntimeException -> L8
            d(r14);     // Catch: RuntimeException -> L8
        L8:
            e = move-exception;
            LogUtils.H(new Object[]{e});
            goto L10
        }
    }

    static {
        f6182a = new ConcurrentHashMap();
        f6183b = new HashMap();
    }

    public static /* synthetic */ ConcurrentHashMap a() {
        return f6182a;
    }
}
