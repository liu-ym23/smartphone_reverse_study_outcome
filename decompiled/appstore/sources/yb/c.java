package yb;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.download.AsyncGetDownloadInfoList;
import com.obric.download.BindCallback;
import com.obric.download.DownloadListener;
import com.obric.download.L;
import com.obric.download.NotificationClickListener;
import com.obric.download.aidl.IDownloadCallback;
import com.obric.download.aidl.IDownloadService;
import com.obric.download.aidl.IGetDownloadInfoListCallback;
import com.obric.download.aidl.INotificationClickCallback;
import com.obric.download.base.DownloadInfo;
import com.obric.download.base.DownloadTask;
import com.obric.download.base.TaskOperateResult;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static c f26206q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f26207r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f26208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f26209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IDownloadService f26210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList f26211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList f26212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList f26213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArrayList f26214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BindCallback f26215h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f26216i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h f26217j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f26218k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f f26219l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final BinderC0415c f26220m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f26221n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Context f26222o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final yb.b f26223p;

    public static final class a {
        public a() {
        }

        public final c a() {
            if (c.f() == null) goto L7;
            c r10 = c.f();
            q.d(r10);
            return r10;
        L7:
            throw new IllegalStateException("AppUpgradeManager 还未初始化，请先调用 init 方法。");
        }

        public final void b(Context r10, yb.b r11) {
            q.g(r10, "context");
            q.g(r11, "config");
            if (c.f() == null) goto L5;
            return;
        L5:
            monitor-enter(c.class);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (c.f() != null) goto L11;
            Context r12 = r10.getApplicationContext();     // Catch: Throwable -> L9
            q.f(r12, "context.applicationContext");     // Catch: Throwable -> L9
            c.r(new c(r12, r11, null));     // Catch: Throwable -> L9
            L.c("DownloadManager", "init DownloadManager success");     // Catch: Throwable -> L9
        L11:
            Unit r13 = Unit.f21064a;     // Catch: Throwable -> L9
            monitor-exit(c.class);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f26224a;

        public b(DownloadInfo r10) {
            this.f26224a = r10;
        }

        public final boolean a(DownloadInfo r10) {
            if (r10 == null) goto L4;
            String r11 = r10.getUrl();
        L6:
            return q.b(r11, this.f26224a.getUrl());
        L4:
            r11 = null;
            goto L6
        }

        @Override // java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(Object r10) {
            return a((DownloadInfo) r10);
        }
    }

    /* JADX INFO: renamed from: yb.c$c, reason: collision with other inner class name */
    public static final class BinderC0415c extends IDownloadCallback.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f26225a;

        public BinderC0415c(c r10) {
            this.f26225a = r10;
        }

        @Override // com.obric.download.aidl.IDownloadCallback
        public void onDownloadCancel(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            this.f26225a.E(r10);
            L.c("DownloadManager", "onDownloadCancel " + r10.getId() + TokenParser.SP + r10.getUrl());
            Iterator r11 = c.h(this.f26225a).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((DownloadListener) r11.next()).onDownloadCancel(r10);
            goto L4
        }

        @Override // com.obric.download.aidl.IDownloadCallback
        public void onDownloadFailed(DownloadInfo r10, int r11, String r12) {
            q.g(r10, ServerElements.INFO);
            q.g(r12, "errorMsg");
            this.f26225a.E(r10);
            L.c("DownloadManager", "onDownloadFailed " + r10.getId() + ',' + r11 + " , " + r12 + TokenParser.SP + r10.getUrl());
            Iterator r13 = c.h(this.f26225a).iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            ((DownloadListener) r13.next()).onDownloadFailed(r10, r11, r12);
            goto L4
        }

        @Override // com.obric.download.aidl.IDownloadCallback
        public void onDownloadFinish(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            this.f26225a.E(r10);
            L.c("DownloadManager", "onDownloadFinish " + r10.getId() + TokenParser.SP + r10.getUrl());
            if (c.h(this.f26225a).isEmpty() == false) goto L5;
            L.c("DownloadManager", "没有callback，通过广播通知");
            Intent r11 = new Intent();
            r11.setComponent(new ComponentName(c.c(this.f26225a).d(), c.c(this.f26225a).e()));
            r11.putExtra("extra_downloadinfo", r10);
            r11.setAction("com.obric.downloader.action.DOWNLOAD_COMPLETE");
            c.d(this.f26225a).sendBroadcast(r11);
            return;
        L5:
            Iterator r12 = c.h(this.f26225a).iterator();
        L7:
            if (r12.hasNext() == false) goto L11;
            ((DownloadListener) r12.next()).onDownloadFinish(r10);
            goto L7
        }

        @Override // com.obric.download.aidl.IDownloadCallback
        public void onDownloadPause(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            this.f26225a.t(r10);
            L.c("DownloadManager", "onDownloadPause " + r10.getId() + TokenParser.SP + r10.getUrl());
            Iterator r11 = c.h(this.f26225a).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((DownloadListener) r11.next()).onDownloadPause(r10);
            goto L4
        }

        @Override // com.obric.download.aidl.IDownloadCallback
        public void onDownloadPending(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            this.f26225a.t(r10);
            L.c("DownloadManager", "onDownloadPending " + r10.getId() + TokenParser.SP + r10.getUrl());
            Iterator r11 = c.h(this.f26225a).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((DownloadListener) r11.next()).onDownloadPending(r10);
            goto L4
        }

        @Override // com.obric.download.aidl.IDownloadCallback
        public void onDownloadStart(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            this.f26225a.t(r10);
            L.c("DownloadManager", "onDownloadStart " + r10.getId() + TokenParser.SP + r10.getUrl());
            Iterator r11 = c.h(this.f26225a).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((DownloadListener) r11.next()).onDownloadStart(r10);
            goto L4
        }

        @Override // com.obric.download.aidl.IDownloadCallback
        public void onDownloading(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            this.f26225a.t(r10);
            Iterator r11 = c.h(this.f26225a).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((DownloadListener) r11.next()).onDownloading(r10);
            goto L4
        }

        @Override // com.obric.download.aidl.IDownloadCallback
        public void onExtraInfoUpdate(DownloadInfo r10) {
            if (r10 == null) goto L7;
            L.c("DownloadManager", "onExtraInfoUpdate " + r10.getId() + ',' + r10.getExtraInfo());
            Iterator r11 = c.h(this.f26225a).iterator();
        L5:
            if (r11.hasNext() == false) goto L9;
            ((DownloadListener) r11.next()).onExtraInfoUpdate(r10);
            goto L5
        L9:
            return;
        }

        @Override // com.obric.download.aidl.IDownloadCallback
        public void onFirstStart(DownloadInfo r10) {
        }

        @Override // com.obric.download.aidl.IDownloadCallback
        public void onFirstSuccess(DownloadInfo r10) {
        }

        @Override // com.obric.download.aidl.IDownloadCallback
        public void onRetry(DownloadInfo r10, int r11, String r12) {
        }

        @Override // com.obric.download.aidl.IDownloadCallback
        public void onRetryDelay(DownloadInfo r10, int r11, String r12) {
        }
    }

    public static final class d implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f26226a;

        public d(c r10) {
            this.f26226a = r10;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            L.c("DownloadManager", "下载服务绑定上了 config = " + c.c(this.f26226a).toString());     // Catch: Exception -> L6
            c.e(this.f26226a).removeCallbacksAndMessages(null);     // Catch: Exception -> L6
            c.s(this.f26226a, IDownloadService.a.a(r11));     // Catch: Exception -> L6
            c.p(this.f26226a, true);     // Catch: Exception -> L6
            BindCallback r12 = c.m(this.f26226a);     // Catch: Exception -> L6
            if (r12 == null) goto L8;
            r12.onServiceConnected();     // Catch: Exception -> L6
        L8:
            IDownloadService r13 = c.l(this.f26226a);     // Catch: Exception -> L6
            if (r13 == null) goto L11;
            r13.init(c.c(this.f26226a).d(), c.c(this.f26226a).a(), c.c(this.f26226a).b(), c.c(this.f26226a).e());     // Catch: Exception -> L6
        L11:
            IDownloadService r14 = c.l(this.f26226a);     // Catch: Exception -> L6
            if (r14 == null) goto L14;
            r14.setNotificationClickReceiver(c.c(this.f26226a).d(), c.c(this.f26226a).a(), c.c(this.f26226a).c());     // Catch: Exception -> L6
        L14:
            IDownloadService r15 = c.l(this.f26226a);     // Catch: Exception -> L6
            if (r15 == null) goto L17;
            r15.registerCallback(c.c(this.f26226a).d(), c.c(this.f26226a).a(), c.b(this.f26226a));     // Catch: Exception -> L6
        L17:
            L.c("DownloadManager", "设置noti class " + c.c(this.f26226a).c());     // Catch: Exception -> L6
            IDownloadService r16 = c.l(this.f26226a);     // Catch: Exception -> L6
            if (r16 == null) goto L21;
            r16.registerNotificationClickCallback(c.c(this.f26226a).d(), c.c(this.f26226a).a(), c.k(this.f26226a));     // Catch: Exception -> L6
        L21:
            if (c.o(this.f26226a) == false) goto L25;
            c.q(this.f26226a, false);     // Catch: Exception -> L6
            L.c("DownloadManager", "下载服务断开又自动重连上了，resume所有任务");     // Catch: Exception -> L6
            IDownloadService r17 = c.l(this.f26226a);     // Catch: Exception -> L6
            if (r17 == null) goto L32;
            r17.resumeAllTask(c.c(this.f26226a).d(), true);     // Catch: Exception -> L6
            return;
        L32:
            return;
        L25:
            L.c("DownloadManager", "下载服务连接上了，自动继续所有任务");     // Catch: Exception -> L6
            IDownloadService r18 = c.l(this.f26226a);     // Catch: Exception -> L6
            if (r18 == null) goto L34;
            r18.resumeAllTask(c.c(this.f26226a).d(), false);     // Catch: Exception -> L6
            return;
        L34:
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            L.a("DownloadManager", "onServiceConnected下载服务绑定失败", e);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            c.p(this.f26226a, false);     // Catch: Exception -> L6
            CopyOnWriteArrayList r11 = null;
            c.s(this.f26226a, null);     // Catch: Exception -> L6
            L.c("DownloadManager", "下载服务断开了");     // Catch: Exception -> L6
            BindCallback r12 = c.m(this.f26226a);     // Catch: Exception -> L6
            if (r12 == null) goto L8;
            r12.onServiceDisconnected();     // Catch: Exception -> L6
        L8:
            CopyOnWriteArrayList r13 = c.h(this.f26226a);     // Catch: Exception -> L6
            if (r13.isEmpty() == true) goto L11;
            r11 = r13;
        L11:
            if (r11 == null) goto L19;
            Iterator r14 = r11.iterator();     // Catch: Exception -> L6
        L14:
            if (r14.hasNext() == false) goto L23;
            DownloadListener r15 = (DownloadListener) r14.next();     // Catch: Exception -> L6
            L.c("DownloadManager", "下载服务断开了，通过callback通知异常");     // Catch: Exception -> L6
            Iterator r16 = c.g(this.f26226a).iterator();     // Catch: Exception -> L6
        L17:
            if (r16.hasNext() == false) goto L14;
            DownloadInfo r17 = (DownloadInfo) r16.next();     // Catch: Exception -> L6
            q.f(r17, "downloadInfo");     // Catch: Exception -> L6
            r15.onDownloadFailed(r17, 9000, "下载服务进程断开了");     // Catch: Exception -> L6
        L23:
            c.q(this.f26226a, true);     // Catch: Exception -> L6
            c r18 = this.f26226a;     // Catch: Exception -> L6
            r18.u(c.m(r18));     // Catch: Exception -> L6
            return;
        L19:
            L.c("DownloadManager", "下载服务断开了，使用广播通知");     // Catch: Exception -> L6
            Iterator r19 = c.g(this.f26226a).iterator();     // Catch: Exception -> L6
        L21:
            if (r19.hasNext() == false) goto L23;
            DownloadInfo r20 = (DownloadInfo) r19.next();     // Catch: Exception -> L6
            Intent r21 = new Intent();     // Catch: Exception -> L6
            r21.setComponent(new ComponentName(c.c(this.f26226a).d(), c.c(this.f26226a).e()));     // Catch: Exception -> L6
            r21.putExtra("extra_downloadinfo", r20);     // Catch: Exception -> L6
            r21.setAction("com.obric.downloader.action.DOWNLOAD_CORE_ERROR");     // Catch: Exception -> L6
            c.d(this.f26226a).sendBroadcast(r21);     // Catch: Exception -> L6
        L6:
            e = move-exception;
            e.printStackTrace();
            L.a("DownloadManager", "onServiceDisconnected下载服务绑定失败", e);
        }
    }

    public static final class e extends IGetDownloadInfoListCallback.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f26227a;

        public e(c r10) {
            this.f26227a = r10;
        }

        @Override // com.obric.download.aidl.IGetDownloadInfoListCallback
        public void onDownloadInfoListGet(List r10) {
            Iterator r11 = c.i(this.f26227a).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((AsyncGetDownloadInfoList) r11.next()).getDownloadInfoList(r10);
            goto L4
        L6:
            c.i(this.f26227a).clear();
        }
    }

    public static final class f extends INotificationClickCallback.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f26228a;

        public f(c r10) {
            this.f26228a = r10;
        }

        @Override // com.obric.download.aidl.INotificationClickCallback
        public void onNotificationClicked(int r10) {
            Iterator r11 = c.j(this.f26228a).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((NotificationClickListener) r11.next()).onNotificationClicked(r10);
            goto L4
        }
    }

    public static final class g implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f26229a;

        public g(DownloadInfo r10) {
            this.f26229a = r10;
        }

        public final boolean a(DownloadInfo r10) {
            if (r10 == null) goto L4;
            String r11 = r10.getUrl();
        L6:
            return q.b(r11, this.f26229a.getUrl());
        L4:
            r11 = null;
            goto L6
        }

        @Override // java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(Object r10) {
            return a((DownloadInfo) r10);
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f26230a;

        public h(c r10) {
            this.f26230a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.n(this.f26230a) == true) goto L6;
            L.c("DownloadManager", "尝试重新绑定下载服务");
            c r10 = this.f26230a;
            c.a(r10, c.m(r10));
            c.e(this.f26230a).postDelayed(this, 10000);
            return;
        }
    }

    static {
        f26207r = new a(null);
    }

    public c(Context r10, yb.b r11) {
        this.f26222o = r10;
        this.f26223p = r11;
        this.f26211d = new CopyOnWriteArrayList();
        this.f26212e = new CopyOnWriteArrayList();
        this.f26213f = new CopyOnWriteArrayList();
        this.f26214g = new CopyOnWriteArrayList();
        this.f26216i = new Handler(Looper.getMainLooper());
        this.f26217j = new h(this);
        this.f26218k = new e(this);
        this.f26219l = new f(this);
        this.f26220m = new BinderC0415c(this);
        this.f26221n = new d(this);
    }

    public static final /* synthetic */ void a(c r10, BindCallback r11) {
        r10.v(r11);
    }

    public static final /* synthetic */ BinderC0415c b(c r10) {
        return r10.f26220m;
    }

    public static final /* synthetic */ yb.b c(c r10) {
        return r10.f26223p;
    }

    public static final /* synthetic */ Context d(c r10) {
        return r10.f26222o;
    }

    public static final /* synthetic */ Handler e(c r10) {
        return r10.f26216i;
    }

    public static final /* synthetic */ c f() {
        return f26206q;
    }

    public static final /* synthetic */ CopyOnWriteArrayList g(c r10) {
        return r10.f26214g;
    }

    public static final /* synthetic */ CopyOnWriteArrayList h(c r10) {
        return r10.f26211d;
    }

    public static final /* synthetic */ CopyOnWriteArrayList i(c r10) {
        return r10.f26212e;
    }

    public static final /* synthetic */ CopyOnWriteArrayList j(c r10) {
        return r10.f26213f;
    }

    public static final /* synthetic */ f k(c r10) {
        return r10.f26219l;
    }

    public static final /* synthetic */ IDownloadService l(c r10) {
        return r10.f26210c;
    }

    public static final /* synthetic */ BindCallback m(c r10) {
        return r10.f26215h;
    }

    public static final /* synthetic */ boolean n(c r10) {
        return r10.f26208a;
    }

    public static final /* synthetic */ boolean o(c r10) {
        return r10.f26209b;
    }

    public static final /* synthetic */ void p(c r10, boolean r11) {
        r10.f26208a = r11;
    }

    public static final /* synthetic */ void q(c r10, boolean r11) {
        r10.f26209b = r11;
    }

    public static final /* synthetic */ void r(c r10) {
        f26206q = r10;
    }

    public static final /* synthetic */ void s(c r10, IDownloadService r11) {
        r10.f26210c = r11;
    }

    public final void A(String r10, AsyncGetDownloadInfoList r11) {
        q.g(r10, "hostPkgName");
        q.g(r11, "listener");
        L.c("DownloadManager", "getDownloadInfoList " + r10);
        if (this.f26208a == true) goto L12;
        L.c("DownloadManager", "getDownloadInfoList 失败，服务还未绑定上");
        r11.getDownloadInfoList(null);
        return;
    L12:
        this.f26212e.add(r11);     // Catch: Exception -> L8
        IDownloadService r12 = this.f26210c;     // Catch: Exception -> L8
        if (r12 == null) goto L14;
        r12.getDownloadInfoList(r10, this.f26218k);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        L.a("DownloadManager", "getDownloadInfoList 失败", e);
        r11.getDownloadInfoList(null);
    }

    public final void B(String r10, int[] r11, AsyncGetDownloadInfoList r12) {
        q.g(r10, "hostPkgName");
        q.g(r11, "statusList");
        q.g(r12, "listener");
        L.c("DownloadManager", "getDownloadInfoListByStatusList " + r10);
        if (this.f26208a == true) goto L12;
        L.c("DownloadManager", "getDownloadInfoList 失败，服务还未绑定上");
        r12.getDownloadInfoList(null);
        return;
    L12:
        this.f26212e.add(r12);     // Catch: Exception -> L8
        IDownloadService r13 = this.f26210c;     // Catch: Exception -> L8
        if (r13 == null) goto L14;
        r13.getDownloadInfoListByStatusList(r10, r11, this.f26218k);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        L.a("DownloadManager", "getDownloadInfoList 失败", e);
        r12.getDownloadInfoList(null);
    }

    public final TaskOperateResult C(int r10) {
        L.c("DownloadManager", "pauseTaskById " + r10);
        if (this.f26208a == true) goto L15;
        L.c("DownloadManager", "pauseTaskById " + r10 + " 失败，服务还未绑定上");
        return y(r10, -1, "pauseTaskById " + r10 + " 失败，服务还未绑定上");
    L15:
        IDownloadService r11 = this.f26210c;     // Catch: Exception -> L7
        if (r11 == null) goto L9;
        r11.pauseTaskById(r10);     // Catch: Exception -> L7
    L9:
        return y(r10, 0, "pauseTaskById时成功");
    L7:
        e = move-exception;
        L.a("DownloadManager", "pauseTaskById " + r10 + " 失败", e);
        return y(r10, -1, "pauseTaskById时发生异常");
    }

    public final void D(DownloadListener r10) {
        q.g(r10, "listener");
        if (this.f26211d.contains(r10) == false) goto L6;
        return;
    L6:
        if (this.f26211d.isEmpty() == false) goto L10;
        L.c("DownloadManager", "registerDownloadListener时, mDownloadProgressCallbacks为空，往service中注册callback");
        IDownloadService r11 = this.f26210c;
        if (r11 == null) goto L10;
        r11.registerCallback(this.f26223p.d(), this.f26223p.a(), this.f26220m);
    L10:
        this.f26211d.add(r10);
    }

    public final void E(DownloadInfo r10) {
        q.g(r10, ServerElements.INFO);
        this.f26214g.removeIf(new g(r10));
    }

    public final TaskOperateResult F(int r10) {
        L.c("DownloadManager", "restartTaskById " + r10);
        if (this.f26208a == true) goto L15;
        L.c("DownloadManager", "restartTaskById " + r10 + " 失败，服务还未绑定上");
        return y(r10, -1, "restartTaskById " + r10 + " 失败，服务还未绑定上");
    L15:
        IDownloadService r11 = this.f26210c;     // Catch: Exception -> L7
        if (r11 == null) goto L9;
        r11.restartTaskById(r10);     // Catch: Exception -> L7
    L9:
        return y(r10, 0, "restartTaskById时成功");
    L7:
        e = move-exception;
        L.a("DownloadManager", "restartTaskById " + r10 + " 失败", e);
        return y(r10, -1, "restartTaskById时发生异常");
    }

    public final TaskOperateResult G(int r10) {
        L.c("DownloadManager", "resumeTaskById " + r10);
        if (this.f26208a == true) goto L15;
        L.c("DownloadManager", "resumeTaskById " + r10 + " 失败，服务还未绑定上");
        return y(r10, -1, "resumeTaskById " + r10 + " 失败，服务还未绑定上");
    L15:
        IDownloadService r11 = this.f26210c;     // Catch: Exception -> L7
        if (r11 == null) goto L9;
        r11.resumeTaskById(r10);     // Catch: Exception -> L7
    L9:
        return y(r10, 0, "resumeTaskById时成功");
    L7:
        e = move-exception;
        L.a("DownloadManager", "resumeTaskById " + r10 + " 失败", e);
        return y(r10, -1, "resumeTaskById时发生异常");
    }

    public final void H(int r10, String r11) {
        q.g(r11, "extraInfo");
        if (this.f26208a == true) goto L12;
        L.c("DownloadManager", "setExtraInfo " + r10 + " 失败，服务还未绑定上");
        return;
    L12:
        L.c("DownloadManager", "setExtraInfo " + r10 + TokenParser.SP + r11);     // Catch: Exception -> L8
        IDownloadService r12 = this.f26210c;     // Catch: Exception -> L8
        if (r12 == null) goto L14;
        r12.setExtraInfo(r10, r11);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        L.a("DownloadManager", "setExtraInfo " + r10 + " 失败", e);
    }

    public final void I(DownloadTask r10) {
        q.g(r10, "task");
        String r11 = r10.getHostPkgName();
        if (r11 != null) goto L5;
    L6:
        r10.setHostPkgName(this.f26223p.d());
        return;
    L5:
        if (r11.length() == 0) goto L6;
    }

    public final void J(int r10, boolean r11) {
        if (this.f26208a == true) goto L12;
        L.c("DownloadManager", "setWifiOnly " + r10 + ',' + r11 + " 失败，服务还未绑定上");
        return;
    L12:
        L.c("DownloadManager", "setWifiOnly " + r10 + TokenParser.SP + r11);     // Catch: Exception -> L8
        IDownloadService r12 = this.f26210c;     // Catch: Exception -> L8
        if (r12 == null) goto L14;
        r12.setWifiOnly(r10, r11);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        L.a("DownloadManager", "setWifiOnly " + r10 + " 失败", e);
    }

    public final TaskOperateResult K(DownloadTask r10) {
        q.g(r10, "task");
        I(r10);
        L.c("DownloadManager", "submitTask " + r10);
        if (this.f26208a == true) goto L11;
        L.c("DownloadManager", "submitTask " + r10 + " 失败，服务还未绑定上");
        return z(r10, -1, "提交任务失败，服务还未绑定上");
    L11:
        IDownloadService r11 = this.f26210c;     // Catch: Exception -> L6
        q.d(r11);     // Catch: Exception -> L6
        TaskOperateResult r12 = r11.submitTask(r10);     // Catch: Exception -> L6
        q.f(r12, "this.service!!.submitTask(task)");     // Catch: Exception -> L6
        return r12;
    L6:
        e = move-exception;
        L.a("DownloadManager", "submitTask " + r10 + " 失败", e);
        return z(r10, -1, "提交任务时发生异常");
    }

    public final void t(DownloadInfo r10) {
        q.g(r10, "newInfo");
        this.f26214g.removeIf(new b(r10));
        this.f26214g.add(r10);
    }

    public final void u(BindCallback r10) {
        L.c("DownloadManager", "执行bindService");
        v(r10);
        this.f26216i.postDelayed(this.f26217j, 10000);
    }

    public final void v(BindCallback r10) {
        L.c("DownloadManager", "执行bindServiceInternal");     // Catch: Exception -> L7
        this.f26215h = r10;     // Catch: Exception -> L7
        if (this.f26208a == false) goto L11;
        if (r10 == null) goto L9;
        r10.onServiceConnected();     // Catch: Exception -> L7
    L9:
        this.f26216i.removeCallbacksAndMessages(null);     // Catch: Exception -> L7
        return;
    L11:
        Intent r11 = new Intent();     // Catch: Exception -> L7
        r11.setAction("com.obric.download.DownloadService.action");     // Catch: Exception -> L7
        r11.setComponent(new ComponentName("com.obric.downloadserver", "com.obric.downloadcore.DownloadService"));     // Catch: Exception -> L7
        this.f26222o.bindService(r11, this.f26221n, 1);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        L.a("DownloadManager", "bindServiceInternal下载服务绑定失败", e);
    }

    public final TaskOperateResult w(int r10) {
        L.c("DownloadManager", "cancelTaskById " + r10);
        if (this.f26208a == true) goto L15;
        L.c("DownloadManager", "cancelTaskById " + r10 + " 失败，服务还未绑定上");
        return y(r10, -1, "cancelTaskById " + r10 + " 失败，服务还未绑定上");
    L15:
        IDownloadService r11 = this.f26210c;     // Catch: Exception -> L7
        if (r11 == null) goto L9;
        r11.cancelTaskById(r10);     // Catch: Exception -> L7
    L9:
        return y(r10, 0, "cancelTaskById时成功");
    L7:
        e = move-exception;
        L.a("DownloadManager", "cancelTaskById " + r10 + " 失败", e);
        return y(r10, -1, "cancelTaskById时发生异常");
    }

    public final TaskOperateResult x(int[] r10) {
        q.g(r10, "taskIdList");
        L.c("DownloadManager", "cancelTaskByIdList " + r10);
        if (this.f26208a == true) goto L15;
        L.c("DownloadManager", "cancelTaskByIdList " + r10 + " 失败，服务还未绑定上");
        return y(0, -1, "cancelTaskByIdList " + r10 + " 失败，服务还未绑定上");
    L15:
        IDownloadService r11 = this.f26210c;     // Catch: Exception -> L7
        if (r11 == null) goto L9;
        r11.cancelTaskByIdList(this.f26223p.d(), r10);     // Catch: Exception -> L7
    L9:
        return y(0, 0, "cancelTaskById时成功");
    L7:
        e = move-exception;
        L.a("DownloadManager", "cancelTaskByIdList " + r10 + " 失败", e);
        return y(0, -1, "cancelTaskById时发生异常");
    }

    public final TaskOperateResult y(int r10, int r11, String r12) {
        return new TaskOperateResult(r10, r11, r12);
    }

    public final TaskOperateResult z(DownloadTask r10, int r11, String r12) {
        return new TaskOperateResult(zb.b.f26342a.a(r10.getUrl(), r10.getSavePath()), r11, r12);
    }

    public /* synthetic */ c(Context r10, yb.b r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }
}
