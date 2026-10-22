package d4;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.server.WsChannelService;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f19060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static WeakReference f19061e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Messenger f19062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ServiceConnection f19063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedBlockingDeque f19064c;

    /* JADX INFO: renamed from: d4.a$a, reason: collision with other inner class name */
    public static class RunnableC0232a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f19065a;

        public RunnableC0232a(Context r10) {
            this.f19065a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f19065a.startService(new Intent(this.f19065a, WsChannelService.class));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f19066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f19067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f19068c;

        public b(a r10, Context r11, boolean r12) {
            this.f19068c = r10;
            this.f19066a = r11;
            this.f19067b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f19066a != null) goto L6;
            return;
        L6:
            if (a.a() != null) goto L8;
        L9:
            a.b(new WeakReference(this.f19066a.getApplicationContext()));
        L19:
            ComponentName r10 = new ComponentName(this.f19066a, WsChannelService.class);     // Catch: Throwable -> L16
            d r11 = new d();     // Catch: Throwable -> L16
            if (this.f19067b == false) goto L13;
            int r12 = 9;
        L14:
            r11.f19072c = r12;     // Catch: Throwable -> L16
            a.c(this.f19068c).offer(r11);     // Catch: Throwable -> L16
            a.d(this.f19068c, r10);     // Catch: Throwable -> L16
            return;
        L13:
            r12 = 11;
        L16:
            th = move-exception;
            th.printStackTrace();
            return;
        L8:
            if (a.a().get() != null) goto L19;
            goto L9
        }
    }

    public class c implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f19069a;

        public c(a r10) {
            this.f19069a = r10;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            if (r10 == null) goto L15;
            if (r11 != null) goto L6;
            return;
        L6:
            if (Logger.debug() == false) goto L13;
            Logger.d("WsChannelSdk", "onServiceConnected name = " + r10.toString());
        L13:
            Messenger r12 = new Messenger(r11);     // Catch: Throwable -> L10
            a r13 = this.f19069a;     // Catch: Throwable -> L10
            r13.f19062a = r12;     // Catch: Throwable -> L10
            a.d(r13, r10);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            th.printStackTrace();
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L12;
            Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r10.toString());
        L12:
            a r11 = this.f19069a;     // Catch: Throwable -> L9
            r11.f19062a = null;     // Catch: Throwable -> L9
            a.c(r11).clear();     // Catch: Throwable -> L9
            a.e(this.f19069a, r10);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Parcelable f19071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19072c;

        public d() {
        }
    }

    static {
        f19060d = new a();
    }

    public a() {
        this.f19064c = new LinkedBlockingDeque();
    }

    public static /* synthetic */ WeakReference a() {
        return f19061e;
    }

    public static /* synthetic */ WeakReference b(WeakReference r10) {
        f19061e = r10;
        return r10;
    }

    public static /* synthetic */ LinkedBlockingDeque c(a r10) {
        return r10.f19064c;
    }

    public static /* synthetic */ void d(a r10, ComponentName r11) {
        r10.f(r11);
    }

    public static /* synthetic */ void e(a r10, ComponentName r11) {
        r10.k(r11);
    }

    public static void h(Context r10) {
        l(r10, 2);
    }

    public static void i(Context r10) {
        l(r10, 1);
    }

    public static void l(Context r10, int r11) {
        if (r10 == null) goto L25;
        if (r11 > 0) goto L5;
        return;
    L5:
        if (r11 > 3) goto L27;
        WeakReference r12 = f19061e;
        if (r12 != null) goto L10;
    L11:
        f19061e = new WeakReference(r10.getApplicationContext());
    L13:
        if (Logger.debug() == false) goto L16;
        Logger.d("WsChannelSdk", "sendAppState appState = " + r11);
    L16:
        if (com.bytedance.common.wschannel.b.d(r10).e() == true) goto L23;
        return;
    L23:
        ComponentName r13 = new ComponentName(r10, WsChannelService.class);     // Catch: Throwable -> L20
        Intent r14 = new Intent(WsConstants.APP_STATE_ACTION);     // Catch: Throwable -> L20
        r14.setComponent(r13);     // Catch: Throwable -> L20
        r14.putExtra("app_state", r11);     // Catch: Throwable -> L20
        r10.startService(r14);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    L10:
        if (r12.get() != null) goto L13;
    L27:
        return;
    }

    public static void o(Context r10, boolean r11, boolean r12) {
        if (r11 == false) goto L4;
        f19060d.n(r10, r12);
        return;
    L4:
        w3.c.b(new RunnableC0232a(r10));
    }

    public final synchronized void f(ComponentName r10) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f19062a != null) goto L8;
        g(r10);     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);
        return;
    L8:
        j(r10);     // Catch: Throwable -> L6
        goto L9
    }

    public final void g(ComponentName r10) {
        WeakReference r11 = f19061e;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.get() == null) goto L20;
        Context r12 = (Context) r11.get();
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelSdk", "doBindService");
    L10:
        if (r10 != null) goto L17;
        return;
    L17:
        Intent r13 = new Intent();     // Catch: Throwable -> L14
        r13.setComponent(r10);     // Catch: Throwable -> L14
        c r14 = new c(this);     // Catch: Throwable -> L14
        this.f19063b = r14;     // Catch: Throwable -> L14
        r12.bindService(r13, r14, 1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public final void j(ComponentName r10) {
        if (r10 != null) goto L17;
        return;
    L17:
        if (this.f19064c.peek() == null) goto L27;
        d r11 = (d) this.f19064c.poll();     // Catch: Throwable -> L16
        if (r11 == null) goto L8;
        Message r12 = new Message();     // Catch: Throwable -> L16
        r12.what = r11.f19072c;     // Catch: Throwable -> L16
        r12.getData().putParcelable(r11.f19070a, r11.f19071b);     // Catch: Throwable -> L16
        m(r10, r12);     // Catch: Throwable -> L12 DeadObjectException -> L14
    L14:
        this.f19062a = null;     // Catch: Throwable -> L16
        this.f19064c.offerFirst(r11);     // Catch: Throwable -> L16
        return;
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
        goto L17
    L8:
        return;
    L27:
        return;
    }

    public final synchronized void k(ComponentName r10) {
        monitor-enter(this);
        monitor-exit(this);
    }

    public final void m(ComponentName r10, Message r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelSdk", "sendMsg msg = " + r11.toString() + " , + what = " + r11.what);
    L7:
        Messenger r12 = this.f19062a;
        if (r12 != null) goto L10;
        return;
    L10:
        r12.send(r11);
    }

    public final void n(Context r10, boolean r11) {
        w3.c.b(new b(this, r10, r11));
    }
}
