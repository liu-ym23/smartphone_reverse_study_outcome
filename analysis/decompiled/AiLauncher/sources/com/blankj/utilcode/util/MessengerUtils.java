package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.blankj.utilcode.util.i;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class MessengerUtils {

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap<String, a> f19166a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, Object> f19167b = new HashMap();

    public static class ServerService extends Service {

        /* renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<Integer, Messenger> f19168a = new ConcurrentHashMap<>();

        /* renamed from: b, reason: collision with root package name */
        @SuppressLint({"HandlerLeak"})
        public final Handler f19169b;

        /* renamed from: c, reason: collision with root package name */
        public final Messenger f19170c;

        public class a extends Handler {
            public a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) throws RemoteException {
                int i10 = message.what;
                if (i10 == 0) {
                    ServerService.this.f19168a.put(Integer.valueOf(message.arg1), message.replyTo);
                    return;
                }
                if (i10 == 1) {
                    ServerService.this.f19168a.remove(Integer.valueOf(message.arg1));
                } else if (i10 != 2) {
                    super.handleMessage(message);
                } else {
                    ServerService.this.e(message);
                    ServerService.this.d(message);
                }
            }
        }

        public ServerService() {
            a aVar = new a();
            this.f19169b = aVar;
            this.f19170c = new Messenger(aVar);
        }

        public final void d(Message message) {
            String string;
            a aVar;
            Bundle data = message.getData();
            if (data == null || (string = data.getString("MESSENGER_UTILS")) == null || (aVar = (a) MessengerUtils.f19166a.get(string)) == null) {
                return;
            }
            aVar.a(data);
        }

        public final void e(Message message) throws RemoteException {
            Message messageObtain = Message.obtain(message);
            for (Messenger messenger : this.f19168a.values()) {
                if (messenger != null) {
                    try {
                        messenger.send(Message.obtain(messageObtain));
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                }
            }
            messageObtain.recycle();
        }

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            return this.f19170c.getBinder();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i10, int i11) throws RemoteException {
            Bundle extras;
            startForeground(1, r.k(i.a.f19234b, null));
            if (intent != null && (extras = intent.getExtras()) != null) {
                Message messageObtain = Message.obtain(this.f19169b, 2);
                messageObtain.replyTo = this.f19170c;
                messageObtain.setData(extras);
                e(messageObtain);
                d(messageObtain);
            }
            return 2;
        }
    }

    public interface a {
        void a(Bundle bundle);
    }
}
