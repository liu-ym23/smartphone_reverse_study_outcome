package a77;

import android.app.Application;
import android.os.Handler;
import android.os.Message;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.push.utils.f;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import org.json.JSONObject;
import z67.i;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f2043a;

    /* JADX INFO: loaded from: classes21.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f2044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f2045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f2046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f2047d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Application f2048e;

        public final void a() {
            b r100 = new b(this.f2044a, this.f2045b, this.f2046c, this.f2047d);     // Catch: Throwable -> L10
            f.b("PushMultiProcessMonitor", String.format("on child process monitor event,insert to db:%s", new Object[]{r100}));     // Catch: Throwable -> L10
            c r101 = c.c(this.f2048e);     // Catch: Throwable -> L10
            if (r101 == null) goto L13;
            long r102 = r101.d(r100);     // Catch: Throwable -> L10
            if (r102 >= 0) goto L8;
            f.i("PushMultiProcessMonitor", String.format("failed to insert event to monitor db, insert result:%s", new Object[]{Long.valueOf(r102)}));     // Catch: Throwable -> L10
            goto L13
        L8:
            f.b("PushMultiProcessMonitor", String.format("success to insert event to monitor db, insert result:%s", new Object[]{Long.valueOf(r102)}));     // Catch: Throwable -> L10
        L13:
            return;
        L10:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(String r100, JSONObject r101, JSONObject r102, JSONObject r103, Application r104) {
            this.f2044a = r100;
            this.f2045b = r101;
            this.f2046c = r102;
            this.f2047d = r103;
            this.f2048e = r104;
        }
    }

    public static d a() {
        if (f2043a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2043a != null) goto L9;
        f2043a = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f2043a;
    }

    public d() {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        if (r100.what != 4171758) goto L6;
        ThreadPlus.submitRunnable(new e());
        return true;
    L6:
        return false;
    }

    public static void b(String r100, JSONObject r101, JSONObject r102, JSONObject r110) {
        Application r103 = AppProvider.getApp();
        if (ToolUtils.isMainProcess(r103) == false) goto L5;
        f.b("PushMultiProcessMonitor", "on main process monitor event,report now:" + r100);
        i.a(r100, r101, r102, r110);
        return;
    L5:
        ThreadPlus.submitRunnable(new a(r100, r101, r102, r110, r103));
    }
}
