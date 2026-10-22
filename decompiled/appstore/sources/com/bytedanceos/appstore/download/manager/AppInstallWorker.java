package com.bytedanceos.appstore.download.manager;

import android.content.Context;
import android.content.Intent;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingWorkPolicy;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import androidx.work.c;
import androidx.work.h;
import androidx.work.j;
import com.bytedanceos.appstore.download.receiver.AppInstallReceiver;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.n;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedanceos/appstore/download/manager/AppInstallWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/h$a;", "p", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppInstallWorker extends CoroutineWorker {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f9404h = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final j a(long r10, long r11) {
            j.a r12 = new j.a(AppInstallWorker.class);
            Pair[] r13 = {d.a("download_id", String.valueOf(r10))};
            c.a r14 = new c.a();
            Pair r15 = r13[0];
            r14.b((String) r15.getFirst(), r15.getSecond());
            c r16 = r14.a();
            q.f(r16, "dataBuilder.build()");
            return (j) ((j.a) ((j.a) r12.j(r16)).i(r11, TimeUnit.MILLISECONDS)).a();
        }

        public final void b(Context r10, long r11, long r12) {
            q.g(r10, "context");
            String r13 = c(r11);
            com.bytedanceos.common.toolbox.j.n("[AppStatus][Worker] AppInstallWorker enqueueUniqueWork@" + r13 + ", delay: " + r12 + ", downloadId: " + r11);
            WorkManager.e(r10).c(r13, ExistingWorkPolicy.KEEP, a(r11, r12));
        }

        public final String c(long r10) {
            return "AppInstallWorker@" + r10;
        }

        public a() {
        }
    }

    static {
        f9404h = new a(null);
    }

    public AppInstallWorker(@NotNull Context r10, @NotNull WorkerParameters r11) {
        q.g(r10, "context");
        q.g(r11, "params");
        super(r10, r11);
    }

    public static final void u(Context r10, long r11, long r12) {
        f9404h.b(r10, r11, r12);
    }

    @Override // androidx.work.CoroutineWorker
    public Object p(Continuation r10) {
        com.bytedanceos.common.toolbox.j.n("[AppStatus][Worker] AppInstallWorker doWork param: " + e());
        Context r11 = a();
        q.f(r11, "getApplicationContext(...)");
        String r12 = e().i("download_id");
        if (r12 == null) goto L5;
        Long r13 = n.i(r12);
    L6:
        if (r13 != null) goto L9;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][Worker] AppInstallWorker doWork err: get download_id err: param: " + e());
        h.a r14 = h.a.a();
        q.f(r14, "failure(...)");
        return r14;
    L9:
        Intent r15 = new Intent(r11, AppInstallReceiver.class);
        r15.setAction("com.bytedanceos.check.install.app");
        r15.setPackage(r11.getPackageName());
        r15.putExtra("extra_download_id", r13.longValue());
        r11.sendBroadcast(r15);
        h.a r16 = h.a.c();
        q.f(r16, "success(...)");
        return r16;
    L5:
        r13 = null;
        goto L6
    }
}
