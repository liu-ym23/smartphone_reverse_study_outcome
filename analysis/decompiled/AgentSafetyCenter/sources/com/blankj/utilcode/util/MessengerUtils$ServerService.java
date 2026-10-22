package com.blankj.utilcode.util;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.activity.b;
import com.stepos.statsrpk.e;
import j6.c;
import j6.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import p5.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class MessengerUtils$ServerService extends Service {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f2285h = 0;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f2286c = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    public final e f2287f;

    /* renamed from: g, reason: collision with root package name */
    public final Messenger f2288g;

    public MessengerUtils$ServerService() {
        e eVar = new e(this);
        this.f2287f = eVar;
        this.f2288g = new Messenger(eVar);
    }

    public final void a(Message message) {
        Message messageObtain = Message.obtain(message);
        for (Messenger messenger : this.f2286c.values()) {
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
    public final IBinder onBind(Intent intent) {
        return this.f2288g.getBinder();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i3) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IOException, SecurityException, IllegalArgumentException {
        Bundle bundle;
        Bundle extras;
        String string;
        d dVar = d.f6599b;
        ((NotificationManager) f.x().getSystemService("notification")).createNotificationChannel(dVar.f6600a);
        Application applicationX = f.x();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Notification notification = new Notification();
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        ArrayList arrayList4 = new ArrayList();
        String id2 = dVar.f6600a.getId();
        Bundle bundle2 = new Bundle();
        Notification.Builder builder = new Notification.Builder(applicationX, id2);
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(null).setContentText(null).setContentInfo(null).setContentIntent(null).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(0).setProgress(0, 0, false);
        builder.setLargeIcon((Icon) null);
        builder.setSubText(null).setUsesChronometer(false).setPriority(0);
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            throw b.g(it);
        }
        builder.setShowWhen(true);
        builder.setLocalOnly(false);
        builder.setGroup(null);
        builder.setSortKey(null);
        builder.setGroupSummary(false);
        builder.setCategory(null);
        builder.setColor(0);
        builder.setVisibility(0);
        builder.setPublicVersion(null);
        builder.setSound(notification.sound, notification.audioAttributes);
        if (!arrayList4.isEmpty()) {
            int size = arrayList4.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList4.get(i10);
                i10++;
                builder.addPerson((String) obj);
            }
        }
        if (arrayList3.size() > 0) {
            bundle = new Bundle();
            Bundle bundle3 = bundle.getBundle("android.car.EXTENSIONS");
            if (bundle3 == null) {
                bundle3 = new Bundle();
            }
            Bundle bundle4 = new Bundle(bundle3);
            Bundle bundle5 = new Bundle();
            if (arrayList3.size() > 0) {
                Integer.toString(0);
                if (arrayList3.get(0) != null) {
                    od.f.j();
                    return 0;
                }
                new Bundle();
                throw null;
            }
            bundle3.putBundle("invisible_actions", bundle5);
            bundle4.putBundle("invisible_actions", bundle5);
            bundle.putBundle("android.car.EXTENSIONS", bundle3);
            bundle2.putBundle("android.car.EXTENSIONS", bundle4);
        } else {
            bundle = null;
        }
        builder.setExtras(bundle);
        builder.setRemoteInputHistory(null);
        builder.setBadgeIconType(0);
        builder.setSettingsText(null);
        builder.setShortcutId(null);
        builder.setTimeoutAfter(0L);
        builder.setGroupAlertBehavior(0);
        if (!TextUtils.isEmpty(id2)) {
            builder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        Iterator it2 = arrayList2.iterator();
        if (it2.hasNext()) {
            throw b.g(it2);
        }
        builder.setAllowSystemGeneratedContextualActions(true);
        builder.setBubbleMetadata(null);
        if (Build.VERSION.SDK_INT >= 36) {
            d3.e.a(builder);
        }
        startForeground(1, builder.build());
        if (intent != null && (extras = intent.getExtras()) != null) {
            Message messageObtain = Message.obtain(this.f2287f, 2);
            messageObtain.replyTo = this.f2288g;
            messageObtain.setData(extras);
            a(messageObtain);
            Bundle data = messageObtain.getData();
            if (data != null && (string = data.getString("MESSENGER_UTILS")) != null && c.f6598a.get(string) != null) {
                od.f.j();
                return 0;
            }
        }
        return 2;
    }
}
