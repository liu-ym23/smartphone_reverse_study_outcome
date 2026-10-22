package com.slardaros.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class SlardarServiceProxy implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Messenger f17828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AtomicBoolean f17829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtomicInteger f17830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BindCallback f17831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f17832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f17833g;

    public interface BindCallback {
        void onTeaServiceConnected();

        void onTeaServiceDisconnected();
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlardarServiceProxy f17834a;

        public a(SlardarServiceProxy r10) {
            this.f17834a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            SlardarServiceProxy.a(this.f17834a);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SlardarServiceProxy f17835a = null;

        static {
            f17835a = new SlardarServiceProxy(null);
        }
    }

    public /* synthetic */ SlardarServiceProxy(a r10) {
        this();
    }

    public static /* synthetic */ boolean a(SlardarServiceProxy r10) {
        return r10.c();
    }

    public static SlardarServiceProxy d(Handler r10) {
        SlardarServiceProxy r11 = b.f17835a;
        if (r11.f17833g != null) goto L10;
        if (r10 == null) goto L9;
        if (r10.getLooper() == Looper.getMainLooper()) goto L9;
        r11.f17833g = r10;
    L9:
        throw new RuntimeException("A handler needed by SlardarServiceProxy and handler should runs in the non-main thread");
    L10:
        return r11;
    }

    public boolean b(Context r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        this.f17827a = r10;
        if (this.f17829c.get() == false) goto L12;
        if (this.f17828b == null) goto L12;
        f(true);
        return true;
    L12:
        if (c() == false) goto L15;
        OLog.f("Slardaros_Agent", "Connecting slardar service");
        return true;
    L15:
        OLog.f("Slardaros_Agent", "Can't connect to slardar service");
        k();
        return false;
    }

    public final boolean c() {
        Intent r10 = new Intent("com.bytedance.os.slardar.ACTION_SLARDAR_SERVICE");
        Context r11 = this.f17827a;
        if (r11 == null) goto L5;
        PackageManager r12 = r11.getPackageManager();
    L7:
        if (r12 != null) goto L10;
        OLog.e("Slardaros_Agent", "Can not resolve slardarosclient app! packageManager is null ");
        return false;
    L10:
        List<ResolveInfo> r13 = r12.queryIntentServices(r10, 0);
        if (r13 != null) goto L14;
        return false;
    L14:
        if (r13.isEmpty() == false) goto L18;
        OLog.e("Slardaros_Agent", "Can not resolve slardarosclient app! We got empty list!");
        return false;
    L18:
        if (r13.size() <= 1) goto L21;
        OLog.e("Slardaros_Agent", "can not resolve slardarosclient app! We got several results!");
        return false;
    L21:
        r10.setPackage(r13.get(0).serviceInfo.packageName);
        return this.f17827a.bindService(r10, this, 1);
    L5:
        r12 = null;
        goto L7
    }

    public boolean e() {
        if (this.f17829c.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f17828b == null) goto L7;
        return true;
    }

    public final void f(boolean r10) {
        BindCallback r11 = this.f17831e;
        if (r11 == null) goto L8;
        if (r10 == false) goto L6;
        r11.onTeaServiceConnected();
        return;
    L6:
        r11.onTeaServiceDisconnected();
        return;
    }

    public void g(Bundle r10) {
    L8:
        e = move-exception;
        OLog.e("Slardaros_Agent", "SlardarServiceProxy onAbResult ex: " + e);
        return;
    L3:
        if (e() == false) goto L13;
        Message r11 = new Message();     // Catch: Exception -> L8
        r11.setData(r10);     // Catch: Exception -> L8
        Messenger r12 = this.f17828b;     // Catch: Exception -> L8
        if (r12 == null) goto L14;
        r11.what = 1006;     // Catch: Exception -> L8
        r12.send(r11);     // Catch: Exception -> L8
        return;
    L14:
        return;
    }

    public boolean h(List r11) {
    L15:
        e = move-exception;
        OLog.e("Slardaros_Agent", "SlardarServiceProxy onEvent ex: " + e);
        return false;
    L4:
        if (e() == false) goto L46;
        ArrayList<? extends Parcelable> r10 = new ArrayList();     // Catch: Exception -> L15
        ArrayList<? extends Parcelable> r12 = new ArrayList();     // Catch: Exception -> L15
        ArrayList<? extends Parcelable> r13 = new ArrayList();     // Catch: Exception -> L15
        ArrayList<? extends Parcelable> r14 = new ArrayList();     // Catch: Exception -> L15
        Iterator r15 = r11.iterator();     // Catch: Exception -> L15
    L7:
        if (r15.hasNext() == false) goto L18;
        com.slardaros.client.a r16 = (com.slardaros.client.a) r15.next();     // Catch: Exception -> L15
        if ((r16 instanceof c) == false) goto L7;
        OLog.d("SlardarAgent", "MetricEvent");     // Catch: Exception -> L15
        c r17 = (c) r16;     // Catch: Exception -> L15
        Bundle r18 = new Bundle();     // Catch: Exception -> L15
        r18.putString("key_event", r17.a());     // Catch: Exception -> L15
        if (r17.b() != null) goto L13;
        String r19 = null;
    L14:
        r18.putString("key_params", r19);     // Catch: Exception -> L15
        r14.add(r18);     // Catch: Exception -> L15
        goto L7
    L13:
        r19 = r17.b().toString();     // Catch: Exception -> L15
        goto L14
    L18:
        if (this.f17828b != null) goto L22;
        com.slardaros.client.b.a().c(r11);     // Catch: Exception -> L15
        return true;
    L22:
        if (r10.size() <= 0) goto L25;
        Message r110 = new Message();     // Catch: Exception -> L15
        Bundle r20 = new Bundle();     // Catch: Exception -> L15
        r110.setData(r20);     // Catch: Exception -> L15
        r110.what = 1001;     // Catch: Exception -> L15
        r20.putParcelableArrayList("key_data", r10);     // Catch: Exception -> L15
        this.f17828b.send(r110);     // Catch: Exception -> L15
    L25:
        if (r12.size() <= 0) goto L28;
        Message r111 = new Message();     // Catch: Exception -> L15
        Bundle r21 = new Bundle();     // Catch: Exception -> L15
        r111.setData(r21);     // Catch: Exception -> L15
        OLog.d("Slardaros_Agent", "errorBundlers : " + r12.toString());     // Catch: Exception -> L15
        r111.what = 1002;     // Catch: Exception -> L15
        r21.putParcelableArrayList("key_data", r12);     // Catch: Exception -> L15
        r111.setData(r21);     // Catch: Exception -> L15
        this.f17828b.send(r111);     // Catch: Exception -> L15
    L28:
        if (r13.size() <= 0) goto L31;
        Message r112 = new Message();     // Catch: Exception -> L15
        Bundle r22 = new Bundle();     // Catch: Exception -> L15
        r112.setData(r22);     // Catch: Exception -> L15
        r112.what = 1003;     // Catch: Exception -> L15
        r22.putParcelableArrayList("key_data", r13);     // Catch: Exception -> L15
        this.f17828b.send(r112);     // Catch: Exception -> L15
    L31:
        if (r14.size() <= 0) goto L45;
        Message r113 = new Message();     // Catch: Exception -> L15
        Bundle r23 = new Bundle();     // Catch: Exception -> L15
        r113.setData(r23);     // Catch: Exception -> L15
        r113.what = 1007;     // Catch: Exception -> L15
        r23.putParcelableArrayList("key_data", r14);     // Catch: Exception -> L15
        this.f17828b.send(r113);     // Catch: Exception -> L15
        return true;
    L45:
        return true;
    L46:
        return false;
    }

    public void i(AppProfile r10, Messenger r11) {
    L8:
        e = move-exception;
        OLog.e("Slardaros_Agent", "SlardarServiceProxy onProfile ex: " + e);
        return;
    L3:
        if (e() == false) goto L13;
        Message r12 = new Message();     // Catch: Exception -> L8
        Bundle r13 = new Bundle();     // Catch: Exception -> L8
        r12.setData(r13);     // Catch: Exception -> L8
        if (this.f17828b == null) goto L14;
        r12.what = 1004;     // Catch: Exception -> L8
        Parcel r14 = Parcel.obtain();     // Catch: Exception -> L8
        OLog.d("SlardarAgent_profle", r10.toString());     // Catch: Exception -> L8
        r10.writeToParcel(r14, 0);     // Catch: Exception -> L8
        r14.setDataPosition(0);     // Catch: Exception -> L8
        r13.putByteArray("key_data", r14.marshall());     // Catch: Exception -> L8
        r12.replyTo = r11;     // Catch: Exception -> L8
        this.f17828b.send(r12);     // Catch: Exception -> L8
        return;
    L14:
        return;
    }

    public void j(BindCallback r10) {
        this.f17831e = r10;
    }

    public void k() {
        this.f17832f = true;
        if (e() == false) goto L11;
        this.f17827a.unbindService(this);     // Catch: Exception -> L6
        this.f17829c.set(false);     // Catch: Exception -> L6
        this.f17828b = null;     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        OLog.e("Slardaros_Agent", "SlardarServiceProxy unbind ex: " + e.getMessage());
        return;
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName r10) {
        onServiceDisconnected(r10);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r10, IBinder r11) {
        this.f17830d.set(0);
        this.f17828b = new Messenger(r11);
        f(true);
        this.f17829c.set(true);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r10) {
        this.f17829c.set(false);
        this.f17828b = null;
        OLog.d("Slardaros_Agent", "onServiceDisconnected");
        if (this.f17832f == true) goto L9;
        OLog.f("Slardaros_Agent", "SlardarServiceProxy retry times: " + this.f17830d.get());
        if (this.f17830d.getAndIncrement() >= 0) goto L7;
        this.f17833g.postDelayed(new a(this), 1000);
        return;
    L7:
        OLog.e("Slardaros_Agent", "SlardarServiceProxy connected to slardar service error with " + this.f17830d.get() + " times retry.");
        return;
    }

    public SlardarServiceProxy() {
        this.f17829c = new AtomicBoolean(false);
        this.f17830d = new AtomicInteger(0);
        this.f17832f = false;
    }
}
