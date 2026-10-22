package androidx.core.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: d, reason: collision with root package name */
    public static String f13041d;

    /* renamed from: g, reason: collision with root package name */
    public static d f13044g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f13045a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f13046b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f13040c = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static Set<String> f13042e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public static final Object f13043f = new Object();

    public static class a {
        public static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }
    }

    public static class b implements e {

        /* renamed from: a, reason: collision with root package name */
        public final String f13047a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13048b;

        /* renamed from: c, reason: collision with root package name */
        public final String f13049c;

        /* renamed from: d, reason: collision with root package name */
        public final Notification f13050d;

        public b(String str, int i10, String str2, Notification notification) {
            this.f13047a = str;
            this.f13048b = i10;
            this.f13049c = str2;
            this.f13050d = notification;
        }

        @Override // androidx.core.app.m.e
        public void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.f13047a, this.f13048b, this.f13049c, this.f13050d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f13047a + ", id:" + this.f13048b + ", tag:" + this.f13049c + "]";
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f13051a;

        /* renamed from: b, reason: collision with root package name */
        public final IBinder f13052b;

        public c(ComponentName componentName, IBinder iBinder) {
            this.f13051a = componentName;
            this.f13052b = iBinder;
        }
    }

    public static class d implements Handler.Callback, ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public final Context f13053a;

        /* renamed from: b, reason: collision with root package name */
        public final HandlerThread f13054b;

        /* renamed from: c, reason: collision with root package name */
        public final Handler f13055c;

        /* renamed from: d, reason: collision with root package name */
        public final Map<ComponentName, a> f13056d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        public Set<String> f13057e = new HashSet();

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public final ComponentName f13058a;

            /* renamed from: c, reason: collision with root package name */
            public INotificationSideChannel f13060c;

            /* renamed from: b, reason: collision with root package name */
            public boolean f13059b = false;

            /* renamed from: d, reason: collision with root package name */
            public ArrayDeque<e> f13061d = new ArrayDeque<>();

            /* renamed from: e, reason: collision with root package name */
            public int f13062e = 0;

            public a(ComponentName componentName) {
                this.f13058a = componentName;
            }
        }

        public d(Context context) {
            this.f13053a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f13054b = handlerThread;
            handlerThread.start();
            this.f13055c = new Handler(handlerThread.getLooper(), this);
        }

        public final boolean a(a aVar) {
            if (aVar.f13059b) {
                return true;
            }
            boolean zBindService = this.f13053a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f13058a), this, 33);
            aVar.f13059b = zBindService;
            if (zBindService) {
                aVar.f13062e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f13058a);
                this.f13053a.unbindService(this);
            }
            return aVar.f13059b;
        }

        public final void b(a aVar) {
            if (aVar.f13059b) {
                this.f13053a.unbindService(this);
                aVar.f13059b = false;
            }
            aVar.f13060c = null;
        }

        public final void c(e eVar) {
            j();
            for (a aVar : this.f13056d.values()) {
                aVar.f13061d.add(eVar);
                g(aVar);
            }
        }

        public final void d(ComponentName componentName) {
            a aVar = this.f13056d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        public final void e(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f13056d.get(componentName);
            if (aVar != null) {
                aVar.f13060c = INotificationSideChannel.Stub.asInterface(iBinder);
                aVar.f13062e = 0;
                g(aVar);
            }
        }

        public final void f(ComponentName componentName) {
            a aVar = this.f13056d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        public final void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f13058a + ", " + aVar.f13061d.size() + " queued tasks");
            }
            if (aVar.f13061d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f13060c == null) {
                i(aVar);
                return;
            }
            while (true) {
                e eVarPeek = aVar.f13061d.peek();
                if (eVarPeek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + eVarPeek);
                    }
                    eVarPeek.a(aVar.f13060c);
                    aVar.f13061d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.f13058a);
                    }
                } catch (RemoteException e10) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f13058a, e10);
                }
            }
            if (aVar.f13061d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        public void h(e eVar) {
            this.f13055c.obtainMessage(0, eVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                c((e) message.obj);
                return true;
            }
            if (i10 == 1) {
                c cVar = (c) message.obj;
                e(cVar.f13051a, cVar.f13052b);
                return true;
            }
            if (i10 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i10 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        public final void i(a aVar) {
            if (this.f13055c.hasMessages(3, aVar.f13058a)) {
                return;
            }
            int i10 = aVar.f13062e;
            int i11 = i10 + 1;
            aVar.f13062e = i11;
            if (i11 <= 6) {
                int i12 = (1 << i10) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i12 + " ms");
                }
                this.f13055c.sendMessageDelayed(this.f13055c.obtainMessage(3, aVar.f13058a), i12);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + aVar.f13061d.size() + " tasks to " + aVar.f13058a + " after " + aVar.f13062e + " retries");
            aVar.f13061d.clear();
        }

        public final void j() {
            Set<String> setC = m.c(this.f13053a);
            if (setC.equals(this.f13057e)) {
                return;
            }
            this.f13057e = setC;
            List<ResolveInfo> listQueryIntentServices = this.f13053a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (setC.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f13056d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f13056d.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it = this.f13056d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f13055c.obtainMessage(1, new c(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f13055c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    public interface e {
        void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    public m(Context context) {
        this.f13045a = context;
        this.f13046b = (NotificationManager) context.getSystemService("notification");
    }

    public static m b(Context context) {
        return new m(context);
    }

    public static Set<String> c(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f13040c) {
            if (string != null) {
                try {
                    if (!string.equals(f13041d)) {
                        String[] strArrSplit = string.split(ServerSentEventKt.COLON, -1);
                        HashSet hashSet = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        f13042e = hashSet;
                        f13041d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = f13042e;
        }
        return set;
    }

    public static boolean g(Notification notification) {
        Bundle bundleA = j.a(notification);
        return bundleA != null && bundleA.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        return a.a(this.f13046b);
    }

    public void d(int i10, Notification notification) {
        e(null, i10, notification);
    }

    public void e(String str, int i10, Notification notification) {
        if (!g(notification)) {
            this.f13046b.notify(str, i10, notification);
        } else {
            f(new b(this.f13045a.getPackageName(), i10, str, notification));
            this.f13046b.cancel(str, i10);
        }
    }

    public final void f(e eVar) {
        synchronized (f13043f) {
            try {
                if (f13044g == null) {
                    f13044g = new d(this.f13045a.getApplicationContext());
                }
                f13044g.h(eVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
