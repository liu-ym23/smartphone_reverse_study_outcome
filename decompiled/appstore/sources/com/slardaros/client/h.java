package com.slardaros.client;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class h extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f17846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Object f17847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Context f17848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static h f17849f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f17851b;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Context f17852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SlardarServiceProxy f17853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f17854c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AtomicBoolean f17855d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List f17856e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SlardarServiceProxy.BindCallback f17857f;

        /* JADX INFO: renamed from: com.slardaros.client.h$a$a, reason: collision with other inner class name */
        public class C0213a implements SlardarServiceProxy.BindCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f17858a;

            public C0213a(a r10) {
                this.f17858a = r10;
            }

            @Override // com.slardaros.client.SlardarServiceProxy.BindCallback
            public void onTeaServiceConnected() {
                OLog.f("Slardaros_Agent", "slardar service connected...");
                this.f17858a.sendEmptyMessage(3);
            }

            @Override // com.slardaros.client.SlardarServiceProxy.BindCallback
            public void onTeaServiceDisconnected() {
                OLog.f("Slardaros_Agent", "slardar service disconnected...");
            }
        }

        public a(Looper r10) {
            super(r10);
            this.f17854c = new ArrayList();
            this.f17855d = new AtomicBoolean(false);
            this.f17856e = new ArrayList();
            this.f17857f = new C0213a(this);
            SlardarServiceProxy r11 = SlardarServiceProxy.d(this);
            this.f17853b = r11;
            r11.j(this.f17857f);
            OLog.d("Slardaros_Agent", "WorkHandler onCreated");
        }

        public static /* synthetic */ void a(a r10, AppProfile r11) {
            r10.f(r11);
        }

        public static /* synthetic */ void b(a r10, AppProfile r11) {
            r10.g(r11);
        }

        public static /* synthetic */ void c(a r10, Bundle r11) {
            r10.h(r11);
        }

        private void onEvent(com.slardaros.client.a r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            if (this.f17855d.get() == true) goto L7;
        L18:
            OLog.f("Slardaros_Agent", "onEvent before Init=" + this.f17855d.get());
            e(r10, false);
            return;
        L7:
            if (hasMessages(3) == true) goto L18;
            if (i.e(this.f17852a) == true) goto L14;
            OLog.f("Slardaros_Agent", "not target device.");
            k();
            return;
        L14:
            if (this.f17853b.e() == false) goto L16;
            e(r10, true);
            j(this.f17854c);
            return;
        L16:
            e(r10, false);
            this.f17853b.b(this.f17852a);
        }

        public final void d(Bundle r10, boolean r11) {
            if (r10 != null) goto L5;
            return;
        L5:
            if (this.f17856e.size() < 100) goto L8;
            if (r11 == true) goto L8;
            this.f17856e.remove(0);
        L8:
            this.f17856e.add(r10);
        }

        public final void e(com.slardaros.client.a r10, boolean r11) {
            if (r10 != null) goto L7;
            OLog.d("Slardaros_Agent", "cachEvent event is null ");
            return;
        L7:
            if (this.f17854c.size() < 100) goto L10;
            if (r11 == true) goto L10;
            this.f17854c.remove(0);
        L10:
            OLog.d("Slardaros_Agent", "cachEvent event:" + r10.toString());
            this.f17854c.add(r10);
        }

        public final /* synthetic */ void f(AppProfile r10) {
            m(r10, new Messenger(this));
        }

        public final /* synthetic */ void g(AppProfile r10) {
            m(r10, new Messenger(this));
        }

        public final /* synthetic */ void h(Bundle r10) {
            i(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            OLog.d("Slardaros_Agent", "WorkHandler handle msg: " + r10.what);
            if (this.f17853b != null) goto L6;
            return;
        L6:
            if (this.f17852a != null) goto L8;
            p(h.d());
        L8:
            int r11 = r10.what;
            if (r11 != 1005) goto L11;
            OLog.d("Slardaros_Agent", "get message from server");
            h.f17846c = r10.arg1;
            return;
        L11:
            switch(r11) {
                case 2: goto L33;
                case 3: goto L32;
                case 4: goto L31;
                case 5: goto L30;
                case 6: goto L29;
                case 7: goto L25;
                case 8: goto L21;
                case 9: goto L13;
                default: goto L51;
            };
        L13:
            final AppProfile r12 = (AppProfile) r10.obj;
            if (i.e(this.f17852a) == true) goto L18;
            h.f17846c = 3;
            return;
        L18:
            if (this.f17853b.e() == false) goto L20;
            m(r12, new Messenger(this));
            return;
        L20:
            l();
            postDelayed(new f(this, r12), 1000);
            return;
        L21:
            final Bundle r13 = r10.getData();
            OLog.d("Slardaros_Agent", "data: " + r13.toString());
            if (this.f17853b.e() == false) goto L24;
            i(r13);
            return;
        L24:
            l();
            postDelayed(new g(this, r13), 1000);
            return;
        L25:
            final AppProfile r14 = (AppProfile) r10.obj;
            if (this.f17853b.e() == false) goto L28;
            m(r14, new Messenger(this));
            return;
        L28:
            l();
            postDelayed(new e(this, r14), 1000);
            return;
        L29:
            o();
            return;
        L30:
            l();
            j((List) r10.obj);
            return;
        L31:
            k();
            return;
        L32:
            n();
            return;
        L33:
            com.slardaros.client.a r15 = (com.slardaros.client.a) r10.obj;
            if (this.f17853b.e() == false) goto L36;
            onEvent(r15);
            return;
        L36:
            l();
            e(r15, true);
            return;
        }

        public final void i(Bundle r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            if (this.f17853b.e() == false) goto L7;
            this.f17853b.g(r10);
            return;
        L7:
            d(r10, false);
            this.f17853b.b(this.f17852a);
        }

        public final void j(List r10) {
            if (r10 != null) goto L5;
        L18:
            OLog.d("Slardaros_Agent", "onEvents list empth");
            return;
        L5:
            if (r10.isEmpty() == true) goto L18;
            if (this.f17853b.e() == true) goto L10;
            OLog.d("Slardaros_Agent", "onEvents add events to cache");
            Iterator r11 = r10.iterator();
        L14:
            if (r11.hasNext() == false) goto L16;
            e((com.slardaros.client.a) r11.next(), true);
            goto L14
        L16:
            this.f17853b.b(this.f17852a);
            return;
        L10:
            if (this.f17853b.h(r10) == false) goto L21;
            OLog.d("Slardaros_Agent", "onEvents done: ");
            r10.clear();
            return;
        }

        public final void k() {
            OLog.f("Slardaros_Agent", "Handler onExit...");
            List r10 = this.f17854c;
            if (r10 == null) goto L5;
            r10.clear();
            this.f17854c = null;
        L5:
            SlardarServiceProxy r11 = this.f17853b;
            if (r11 == null) goto L8;
            r11.k();
            this.f17853b.j(null);
            this.f17853b = null;
        L8:
            this.f17852a = null;
            h.f17849f = null;
        }

        public final void l() {
            OLog.d("Slardaros_Agent", "isTargetDevice: " + i.e(this.f17852a));
            if (i.e(this.f17852a) == true) goto L5;
        L7:
            this.f17855d.set(true);
            return;
        L5:
            if (this.f17853b.e() == true) goto L7;
            OLog.d("Slardaros_Agent", "bindService");
            this.f17853b.b(this.f17852a);
            goto L7
        }

        public final void m(AppProfile r10, Messenger r11) {
            if (r10 != null) goto L7;
            OLog.d("Slardar", "onProfile profile is null");
            h.f17846c = 2;
            return;
        L7:
            if (this.f17853b.e() == false) goto L9;
            OLog.d("Slardar", "onProfile");
            this.f17853b.i(r10, r11);
            return;
        L9:
            boolean r12 = false;
            int r13 = 0;
            boolean r14 = false;
        L11:
            if (r13 >= 5) goto L24;
            Thread.sleep(1000);     // Catch: InterruptedException -> L17
            if (this.f17853b.e() == false) goto L20;
            this.f17853b.i(r10, r11);     // Catch: InterruptedException -> L17
        L25:
            if (r12 == false) goto L36;
            OLog.d("Slardar", "onProfile 2");
            h.f17846c = 2;
            return;
        L36:
            return;
        L20:
            if (r13 != 4) goto L23;
            r14 = true;
        L23:
            r13 = r13 + 1;
        L17:
            e = move-exception;
            e.printStackTrace();
            goto L23
        L24:
            r12 = r14;
            goto L25
        }

        public final void n() {
            if (this.f17854c.isEmpty() == false) goto L6;
            return;
        L6:
            if (this.f17853b.e() == false) goto L16;
            j(this.f17854c);
            if (this.f17856e.size() <= 0) goto L17;
            Iterator r10 = this.f17856e.iterator();
        L11:
            if (r10.hasNext() == false) goto L13;
            Bundle r11 = (Bundle) r10.next();
            this.f17853b.g(r11);
            goto L11
        L13:
            this.f17856e.clear();
            return;
        L17:
            return;
        }

        public final void o() {
            this.f17855d.set(false);
            OLog.d("Slardaros_Agent", "do onUnbind");
            SlardarServiceProxy r10 = this.f17853b;
            if (r10 == null) goto L6;
            r10.k();
            return;
        }

        public void p(Context r10) {
            this.f17852a = r10;
        }
    }

    static {
        f17847d = new Object();
    }

    public h() {
        HandlerThread r10 = new HandlerThread("SlardarHandler");
        r10.start();
        Looper r11 = r10.getLooper();
        Objects.requireNonNull(r11);
        this.f17851b = new a(r11);
    }

    public static /* synthetic */ Context d() {
        return f17848e;
    }

    public static h f() {
        Object r10 = f17847d;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f17849f != null) goto L9;
        OLog.d("Slardaros_Agent", "get new SlardarHandler");     // Catch: Throwable -> L7
        f17849f = new h();     // Catch: Throwable -> L7
    L9:
        h r11 = f17849f;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    }

    @Override // com.slardaros.client.b
    public void b(Context r10) {
        if (r10 == null) goto L10;
        if (r10.getApplicationContext() == null) goto L7;
        r10 = r10.getApplicationContext();
    L7:
        this.f17850a = r10;
        this.f17851b.p(r10);
        f17848e = this.f17850a;
        Message.obtain(this.f17851b, 1).sendToTarget();
        return;
    L10:
        throw new IllegalArgumentException("context can't be null when initing slardar agent.");
    }

    @Override // com.slardaros.client.b
    public void c(List r10) {
        Message.obtain(this.f17851b, 5, r10).sendToTarget();
    }

    public Context e() {
        return this.f17850a;
    }

    @Override // com.slardaros.client.b
    public void onEvent(com.slardaros.client.a r10) {
        Message.obtain(this.f17851b, 2, r10).sendToTarget();
    }
}
