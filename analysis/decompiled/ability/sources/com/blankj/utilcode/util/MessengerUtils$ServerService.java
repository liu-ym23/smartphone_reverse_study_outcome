package com.blankj.utilcode.util;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class MessengerUtils$ServerService extends Service {
    public static final /* synthetic */ int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f2197a = new ConcurrentHashMap();
    public final Q5.a b;
    public final Messenger c;

    public MessengerUtils$ServerService() {
        Q5.a aVar = new Q5.a(this);
        this.b = aVar;
        this.c = new Messenger(aVar);
    }

    public final void a(Message message) {
        Message messageObtain = Message.obtain(message);
        for (Messenger messenger : this.f2197a.values()) {
            if (messenger != null) {
                try {
                    messenger.send(Message.obtain(messageObtain));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        messageObtain.recycle();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.c.getBinder();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i6) {
        Bundle extras;
        String string;
        d dVar = d.b;
        ((NotificationManager) S0.b.X0().getSystemService("notification")).createNotificationChannel(dVar.f2204a);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(S0.b.X0());
        builder.setChannelId(dVar.f2204a.getId());
        startForeground(1, builder.build());
        if (intent != null && (extras = intent.getExtras()) != null) {
            Message messageObtain = Message.obtain(this.b, 2);
            messageObtain.replyTo = this.c;
            messageObtain.setData(extras);
            a(messageObtain);
            Bundle data = messageObtain.getData();
            if (data != null && (string = data.getString("MESSENGER_UTILS")) != null && c.f2203a.get(string) != null) {
                throw new ClassCastException();
            }
        }
        return 2;
    }
}
