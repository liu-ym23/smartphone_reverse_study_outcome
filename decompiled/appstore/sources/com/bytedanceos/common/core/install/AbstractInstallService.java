package com.bytedanceos.common.core.install;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractInstallService extends Service implements PackageInstallDispatcher.PackageInstallListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Looper f9610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile c f9611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f9612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinkedBlockingDeque f9613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PackageInstallDispatcher f9614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f9615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9616g;

    public static /* synthetic */ class a {
    }

    public final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractInstallService f9617a;

        public b(AbstractInstallService r10) {
            this.f9617a = r10;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            int r11 = r10.what;
            if (r11 != 89) goto L18;
            this.f9617a.f9612c.removeMessages(79);
            Object r12 = r10.obj;
            if ((r12 instanceof Boolean) == false) goto L17;
            boolean r13 = ((Boolean) r12).booleanValue();
            if (r13 == false) goto L9;
            this.f9617a.f9616g++;
        L11:
            if (this.f9617a.f9616g >= 0) goto L14;
            j.n("AbstractInstallService stop service error:" + this.f9617a.f9616g);
            this.f9617a.f9616g = 0;
        L14:
            if (this.f9617a.f9616g != 0) goto L16;
            Message r14 = Message.obtain();
            r14.what = 79;
            this.f9617a.f9612c.sendMessageDelayed(r14, 360000);
        L16:
            j.n("AbstractInstallService mTaskCount:" + this.f9617a.f9616g + " | " + r13);
            return;
        L9:
            this.f9617a.f9616g--;
            goto L11
        L17:
            j.n("AbstractInstallService mTaskCount:" + this.f9617a.f9616g + " | " + r10.obj);
            return;
        L18:
            if (r11 != 79) goto L23;
            j.n("AbstractInstallService MainHandler stopSelf mTaskCount :" + this.f9617a.f9616g);
            AbstractInstallService r15 = this.f9617a;
            if (r15.f9616g != 0) goto L22;
            r15.stopSelf();
            return;
        L22:
            j.n("AbstractInstallService task is running");
            return;
        L23:
            j.a("AbstractInstallServicewhat:" + r10.what);
        }

        public /* synthetic */ b(AbstractInstallService r10, a r11) {
            this(r10);
        }
    }

    public final class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractInstallService f9618a;

        public c(AbstractInstallService r10, Looper r11) {
            this.f9618a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
        }
    }

    public AbstractInstallService() {
        this.f9613d = new LinkedBlockingDeque();
        this.f9614e = null;
        this.f9615f = new AtomicBoolean();
        this.f9616g = 0;
    }

    public void a(boolean r10) {
        Message r11 = Message.obtain();
        r11.what = 89;
        r11.obj = Boolean.valueOf(r10);
        this.f9612c.sendMessage(r11);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        HandlerThread r10 = new HandlerThread("IntentService[AbstractInstallService]");
        r10.start();
        this.f9610a = r10.getLooper();
        this.f9611b = new c(this, this.f9610a);
        this.f9612c = new b(this, null);
        PackageInstallDispatcher r11 = new PackageInstallDispatcher(this.f9613d, this);
        this.f9614e = r11;
        r11.start();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f9615f.set(false);
        b r10 = this.f9612c;
        if (r10 == null) goto L6;
        r10.removeCallbacksAndMessages(null);
    L6:
        if (this.f9611b == null) goto L9;
        this.f9611b.removeCallbacksAndMessages(null);
    L9:
        if (this.f9610a == null) goto L11;
        this.f9610a.quit();
    L11:
        this.f9614e.c();
        this.f9614e = null;
        j.a("onDestroy!");
    }

    @Override // com.bytedanceos.common.core.install.PackageInstallDispatcher.PackageInstallListener
    public void onInstallFinished(AppInfo r10, int r11) {
        if (r10 == null) goto L4;
        Message r12 = this.f9611b.obtainMessage();
        r12.what = 99;
        r12.arg1 = r11;
        r12.obj = r10;
        this.f9611b.sendMessage(r12);
        return;
    L4:
        j.n("AbstractInstallService unkown appinfo.");
    }

    @Override // android.app.Service
    public void onStart(Intent r10, int r11) {
        if (r10 == null) goto L5;
        Message r12 = this.f9611b.obtainMessage();
        r12.obj = r10;
        r12.what = r10.getIntExtra("message_what", -1);
        this.f9611b.sendMessage(r12);
        return;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        j.a("startId:" + r12);
        this.f9615f.set(true);
        a(true);
        onStart(r10, r12);
        return 2;
    }
}
