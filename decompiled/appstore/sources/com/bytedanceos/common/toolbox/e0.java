package com.bytedanceos.common.toolbox;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.bytedanceos.common.BaseApplication;
import com.obric.oui.toast.OToast;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Toast f10029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Object f10030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Handler f10031c;

    public class a extends Handler {
        public a(Looper r10) {
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            if (r10.what == 1) goto L6;
            return;
        L6:
            if (e0.a() == null) goto L14;
            e0.a().show();     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f10032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f10033b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f10034a;

            public a(b r10) {
                this.f10034a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object r10 = e0.b();
                monitor-enter(r10);
                b r11 = this.f10034a;     // Catch: Throwable -> L7
                e0.c(r11.f10032a, r11.f10033b);     // Catch: Throwable -> L7
                monitor-exit(r10);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        public b(String r10, int r11) {
            this.f10032a = r10;
            this.f10033b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.d().post(new a(this));
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f10035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f10036b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f10037a;

            public a(c r10) {
                this.f10037a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object r10 = e0.b();
                monitor-enter(r10);
                e0.c(BaseApplication.c().getString(this.f10037a.f10035a), this.f10037a.f10036b);     // Catch: Throwable -> L7
                monitor-exit(r10);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        public c(int r10, int r11) {
            this.f10035a = r10;
            this.f10036b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.d().post(new a(this));
        }
    }

    static {
        f10030b = new Object();
        f10031c = new a(Looper.getMainLooper());
    }

    public static /* synthetic */ Toast a() {
        return f10029a;
    }

    public static /* synthetic */ Object b() {
        return f10030b;
    }

    public static /* synthetic */ void c(String r10, int r11) {
        i(r10, r11);
    }

    public static /* synthetic */ Handler d() {
        return f10031c;
    }

    public static void e(int r10) {
        f(r10, 0);
    }

    public static void f(int r10, int r11) {
        new Thread(new c(r10, r11)).start();
    }

    public static void g(String r10) {
        h(r10, 0);
    }

    public static void h(String r10, int r11) {
        new Thread(new b(r10, r11)).start();
    }

    public static void i(String r10, int r11) {
        Toast r12 = f10029a;
        if (r12 == null) goto L8;
        r12.cancel();
        f10029a.setText(r10);
        f10029a.setDuration(r11);
        if (f10031c.hasMessages(1) == false) goto L7;
        f10031c.removeMessages(1);
    L7:
        f10031c.sendEmptyMessageDelayed(1, 50);
        return;
    L8:
        Activity r13 = BaseApplication.c().d();
        if (r13 != null) goto L11;
    L20:
        Toast.makeText(BaseApplication.c(), r10, r11).show();     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        if (r13.isFinishing() == true) goto L20;
        if (r13.isFinishing() == true) goto L20;
        new OToast(r13, r10, 80, false).l();
    }
}
