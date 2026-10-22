package ec;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.obric.matrix.platform.sdk.ones.dataanalysis.DeviceInfoListener;
import com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService;
import com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f19371l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static d f19372m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AtomicBoolean f19373n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f19374o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f19375p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ec.a f19377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IDataService f19378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f19379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList f19380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f19381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArrayList f19382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f19383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f19384i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BinderC0245d f19385j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f19386k;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final d a() {
            if (d.e() == null) goto L7;
            d r10 = d.e();
            q.d(r10);
            return r10;
        L7:
            throw new IllegalStateException("MatrixTeaManager还没初始化，请先调用init方法进行初始化~~~");
        }

        public final void b(Context r10, ec.a r11) {
            q.g(r10, "context");
            q.g(r11, "config");
            if (d.e() == null) goto L5;
        L16:
            d r12 = d.e();
            q.d(r12);
            r12.q();
            return;
        L5:
            monitor-enter(d.class);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (d.e() != null) goto L11;
            d.m(new d(r10, r11, null));     // Catch: Throwable -> L9
        L11:
            Unit r13 = Unit.f21064a;     // Catch: Throwable -> L9
            monitor-exit(d.class);
            goto L16
        }

        public final boolean c() {
            return d.i().get();
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f19387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f19388b;

        public b(String r10, JSONObject r11) {
            q.g(r10, "eventName");
            q.g(r11, "jsonObject");
            this.f19387a = r10;
            this.f19388b = r11;
        }

        public final String a() {
            return this.f19387a;
        }

        public final JSONObject b() {
            return this.f19388b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (q.b(this.f19387a, r11.f19387a) == true) goto L12;
            return false;
        L12:
            if (q.b(this.f19388b, r11.f19388b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f19387a.hashCode() * 31) + this.f19388b.hashCode();
        }

        public String toString() {
            return "PendingEvent(eventName=" + this.f19387a + ", jsonObject=" + this.f19388b + ')';
        }
    }

    public static final class c implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f19389a;

        public c(d r10) {
            this.f19389a = r10;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            hc.b.g("MatrixTeaManager", "onServiceConnected: ", null, 4, null);     // Catch: Exception -> L6
            d.d(this.f19389a).removeCallbacksAndMessages(null);     // Catch: Exception -> L6
            d.o(this.f19389a, IDataService.a.a(r11));     // Catch: Exception -> L6
            d.k(this.f19389a, true);     // Catch: Exception -> L6
            IDataService r12 = d.g(this.f19389a);     // Catch: Exception -> L6
            if (r12 == null) goto L8;
            r12.registerDeviceInfoListener(d.c(this.f19389a));     // Catch: Exception -> L6
        L8:
            d.j(this.f19389a);     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            hc.b.c("MatrixTeaManager", "onServiceConnected error", e);
            this.f19389a.B();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            this.f19389a.B();
        }
    }

    /* JADX INFO: renamed from: ec.d$d, reason: collision with other inner class name */
    public static final class BinderC0245d extends IDeviceInfoCallback.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f19390a;

        public BinderC0245d(d r10) {
            this.f19390a = r10;
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback
        public void onDeviceId(String r10) {
            q.g(r10, "deviceId");
            hc.b.g("MatrixTeaManager", "回调deviceId: " + r10 + "， listeners.size = " + d.f(this.f19390a).size(), null, 4, null);
            d.l(r10);
            Iterator r11 = d.f(this.f19390a).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            DeviceInfoListener r12 = (DeviceInfoListener) r11.next();
            hc.b.g("MatrixTeaManager", "回调deviceId了，开始回调listener: " + r10 + " , listener = " + r12, null, 4, null);
            r12.onDeviceIdLoaded(r10);
            goto L4
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback
        public void onInstallId(String r10) {
            q.g(r10, "installId");
            d.n(r10);
            Iterator r11 = d.f(this.f19390a).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((DeviceInfoListener) r11.next()).onInstallIdLoaded(r10);
            goto L4
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f19391a;

        public e(d r10) {
            this.f19391a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.h(this.f19391a) == true) goto L6;
            hc.b.g("MatrixTeaManager", "尝试重新绑定下载服务", null, 4, null);
            this.f19391a.r();
            d.d(this.f19391a).postDelayed(this, PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);
            return;
        }
    }

    static {
        f19371l = new a(null);
        f19373n = new AtomicBoolean(false);
    }

    public /* synthetic */ d(Context r10, ec.a r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    public static final void C(d r10) {
        q.g(r10, "this$0");
        r10.q();
    }

    public static /* synthetic */ void a(d r10, String r11, JSONObject r12, JSONObject r13) {
        z(r10, r11, r12, r13);
    }

    public static /* synthetic */ void b(d r10) {
        C(r10);
    }

    public static final /* synthetic */ BinderC0245d c(d r10) {
        return r10.f19385j;
    }

    public static final /* synthetic */ Handler d(d r10) {
        return r10.f19381f;
    }

    public static final /* synthetic */ d e() {
        return f19372m;
    }

    public static final /* synthetic */ CopyOnWriteArrayList f(d r10) {
        return r10.f19380e;
    }

    public static final /* synthetic */ IDataService g(d r10) {
        return r10.f19378c;
    }

    public static final /* synthetic */ boolean h(d r10) {
        return r10.f19379d;
    }

    public static final /* synthetic */ AtomicBoolean i() {
        return f19373n;
    }

    public static final /* synthetic */ void j(d r10) {
        r10.A();
    }

    public static final /* synthetic */ void k(d r10, boolean r11) {
        r10.f19379d = r11;
    }

    public static final /* synthetic */ void l(String r10) {
        f19374o = r10;
    }

    public static final /* synthetic */ void m(d r10) {
        f19372m = r10;
    }

    public static final /* synthetic */ void n(String r10) {
        f19375p = r10;
    }

    public static final /* synthetic */ void o(d r10, IDataService r11) {
        r10.f19378c = r11;
    }

    public static final void z(d r10, String r11, JSONObject r12, JSONObject r13) {
        q.g(r10, "this$0");
        q.g(r11, "$eventName");
        q.g(r12, "$copyJson");
        q.g(r13, "$jsonObject");
        Result.a r14 = Result.Companion;     // Catch: Throwable -> L6
        IDataService r15 = r10.f19378c;     // Catch: Throwable -> L6
        if (r15 == null) goto L8;
        r15.onEvent(r11, r12.toString());     // Catch: Throwable -> L6
        Unit r16 = Unit.f21064a;     // Catch: Throwable -> L6
    L9:
        Object r17 = Result.m35constructorimpl(r16);     // Catch: Throwable -> L6
    L12:
        Throwable r18 = Result.m38exceptionOrNullimpl(r17);
        if (r18 == null) goto L18;
        r10.f19382g.add(new b(r11, r13));
        hc.b.c("MatrixTeaManager", "onEvent error", r18);
        return;
    L18:
        return;
    L8:
        r16 = null;
    L6:
        th = move-exception;
        Result.a r19 = Result.Companion;
        r17 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L12
    }

    public final void A() {
        if (this.f19382g.isEmpty() == false) goto L6;
        hc.b.g("MatrixTeaManager", "没有暂存的事件需要处理", null, 4, null);
        return;
    L6:
        hc.b.g("MatrixTeaManager", "开始处理 " + this.f19382g.size() + " 个暂存事件", null, 4, null);
        CopyOnWriteArrayList r10 = this.f19382g;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L14;
        Object r13 = r12.next();
        b r14 = (b) r13;
        JSONObject r15 = new JSONObject(r14.b().toString());     // Catch: Exception -> L12
        r15.put("app_package_name", this.f19377b.a());     // Catch: Exception -> L12
        r15.put(DownloadInfoColumns.APP_VERSION_CODE, this.f19377b.b());     // Catch: Exception -> L12
        r15.put("app_version_name", this.f19377b.c());     // Catch: Exception -> L12
        r15.put("app_is_boe", this.f19377b.d() ? 1 : 0);     // Catch: Exception -> L12
        y(r14.a(), r15);     // Catch: Exception -> L12
        hc.b.g("MatrixTeaManager", "成功发送暂存事件: " + r14.a(), null, 4, null);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        hc.b.c("MatrixTeaManager", "发送暂存事件 " + r14.a() + " 失败", e);
        r11.add(r13);
        goto L8
    L14:
        this.f19382g.clear();
        this.f19382g.addAll(r11);
    }

    public final void B() {
        this.f19379d = false;     // Catch: Exception -> L5
        this.f19378c = null;     // Catch: Exception -> L5
        this.f19381f.postDelayed(new ec.b(this), WsConstants.EXIT_DELAY_TIME);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        hc.b.c("MatrixTeaManager", "rebindService error", e);
    }

    public final void p(DeviceInfoListener r10) {
        q.g(r10, "listener");
        hc.b.g("MatrixTeaManager", "addDeviceInfoListener " + r10, null, 4, null);
        if (this.f19380e.contains(r10) == true) goto L5;
        this.f19380e.add(r10);
        hc.b.g("MatrixTeaManager", "addDeviceInfoListener不包含，添加进listeners中,当前size = " + this.f19380e.size(), null, 4, null);
    L5:
        String r11 = f19374o;
        if (r11 != null) goto L8;
    L11:
        String r12 = f19375p;
        if (r12 != null) goto L14;
        return;
    L14:
        if (r12.length() == 0) goto L19;
        hc.b.g("MatrixTeaManager", "注册deviceInfoListener时installId有值，立即回调 " + f19375p, null, 4, null);
        String r13 = f19375p;
        q.d(r13);
        r10.onInstallIdLoaded(r13);
        return;
    L19:
        return;
    L8:
        if (r11.length() == 0) goto L11;
        hc.b.g("MatrixTeaManager", "注册deviceInfoListener时did有值，立即回调 " + f19374o, null, 4, null);
        String r14 = f19374o;
        q.d(r14);
        r10.onDeviceIdLoaded(r14);
        goto L11
    }

    public final void q() {
        if (f19373n.compareAndSet(false, true) == true) goto L6;
        hc.b.e("tea has inited");
        return;
    L6:
        r();
        this.f19381f.postDelayed(this.f19383h, PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);
    }

    public final void r() {
        if (this.f19379d == false) goto L6;
        hc.b.g("MatrixTeaManager", "bindServiceInternal: service is already bound", null, 4, null);
        return;
    L6:
        Intent r10 = new Intent();
        r10.setAction("com.obric.matrix.dataanalysis.service");
        r10.setPackage("com.obric.matrix");
        this.f19376a.bindService(r10, this.f19386k, 1);
    }

    public final JSONObject s(JSONObject r10) {
        LinkedList r11 = new LinkedList();
        Iterator<String> r12 = r10.keys();
    L4:
        if (r12.hasNext() == false) goto L23;
        String r13 = r12.next();
        q.f(r13, "keysIterable.next()");
        r11.add(r13);
        goto L4
    L23:
        Result.a r14 = Result.Companion;     // Catch: Throwable -> L9
        Object[] r15 = r11.toArray(new String[0]);     // Catch: Throwable -> L9
        if (r15 == null) goto L12;
        Object r16 = Result.m35constructorimpl(new JSONObject(r10, (String[]) r15));     // Catch: Throwable -> L9
    L14:
        Throwable r17 = Result.m38exceptionOrNullimpl(r16);
        if (r17 == null) goto L17;
        hc.b.c("MatrixTeaManager", "copyJson error", r17);
    L17:
        Object r18 = r10;
        if (Result.m41isFailureimpl(r16) == true) goto L22;
        r18 = r16;
    L22:
        return (JSONObject) r18;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.a r19 = Result.Companion;
        r16 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L14
    }

    public final String t() {
        String r10 = f19374o;
        if (r10 == null) goto L10;
        if (r10.length() == 0) goto L10;
        hc.b.g("MatrixTeaManager", "getDeviceId 有值，立即回调 " + f19374o, null, 4, null);
        return f19374o;
    L10:
        if (this.f19379d == true) goto L23;
        hc.b.d("MatrixTeaManager", "getDeviceId error,Service not bounded", null, 4, null);
        return null;
    L23:
        IDataService r11 = this.f19378c;     // Catch: Exception -> L14
        if (r11 == null) goto L16;
        String r12 = r11.getDeviceId();     // Catch: Exception -> L14
    L17:
        f19374o = r12;     // Catch: Exception -> L14
        return r12;
    L16:
        r12 = null;
    L14:
        e = move-exception;
        hc.b.c("MatrixTeaManager", "getDeviceId error", e);
        return null;
    }

    public final void u(long r10) {
        JSONObject r11 = new JSONObject();
        r11.put("duration", r10);
        x("apm_event_coldlaunch_first_frame", r11);
    }

    public final void v(long r10, JSONObject r11) {
        q.g(r11, "extraInfo");
        JSONObject r12 = new JSONObject();
        r12.put("duration", r10);
        Iterator<String> r13 = r11.keys();
    L4:
        if (r13.hasNext() == false) goto L6;
        String r14 = r13.next();
        r12.put(r14, r11.get(r14));
        goto L4
    L6:
        x("apm_event_coldlaunch_user_complete", r12);
    }

    public final void w(String r10, float r11, JSONObject r12) {
        q.g(r10, "pageName");
        if (r12 != null) goto L5;
        r12 = new JSONObject();
    L5:
        r12.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, r10);
        r12.put("fps", Float.valueOf(r11));
        x("apm_event_fps", r12);
    }

    public final void x(String r10, JSONObject r11) {
        q.g(r10, "eventName");
        q.g(r11, "jsonObject");
        String r12 = r11.toString();     // Catch: Throwable -> L19
        q.f(r12, "jsonObject.toString()");     // Catch: Throwable -> L19
        byte[] r13 = r12.getBytes(kotlin.text.c.f21252b);     // Catch: Throwable -> L19
        q.f(r13, "this as java.lang.String).getBytes(charset)");     // Catch: Throwable -> L19
        int r14 = r13.length;     // Catch: Throwable -> L19
        if (r14 <= 204800) goto L9;
        hc.b.d("MatrixTeaManager", "事件 " + r10 + " 数据大小 " + r14 + " 字节超过200KB限制，已丢弃", null, 4, null);
        return;
    L9:
        if (this.f19379d == false) goto L24;
        r11.put("app_package_name", this.f19377b.a());     // Catch: Exception -> L12
        r11.put(DownloadInfoColumns.APP_VERSION_CODE, this.f19377b.b());     // Catch: Exception -> L12
        r11.put("app_version_name", this.f19377b.c());     // Catch: Exception -> L12
        r11.put("app_is_boe", this.f19377b.d() ? 1 : 0);     // Catch: Exception -> L12
        y(r10, r11);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        hc.b.c("MatrixTeaManager", "onEvent error", e);
        return;
    L24:
        this.f19382g.add(new b(r10, new JSONObject(r11.toString())));     // Catch: Exception -> L16
        hc.b.g("MatrixTeaManager", "服务未绑定，暂存事件: " + r10 + " 成功，当前暂存数量: " + this.f19382g.size(), null, 4, null);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        hc.b.c("MatrixTeaManager", "服务未绑定，暂存事件 " + r10 + " 失败", e);
        return;
    L19:
        th = move-exception;
        hc.b.c("MatrixTeaManager", "计算事件大小失败，已丢弃事件 " + r10, th);
    }

    public final void y(final String r10, final JSONObject r11) {
        final JSONObject r12 = s(r11);
        this.f19384i.post(new ec.c(this, r10, r12, r11));
    }

    public d(Context r10, ec.a r11) {
        this.f19376a = r10;
        this.f19377b = r11;
        this.f19380e = new CopyOnWriteArrayList();
        this.f19381f = new Handler(Looper.getMainLooper());
        this.f19382g = new CopyOnWriteArrayList();
        this.f19383h = new e(this);
        HandlerThread r12 = new HandlerThread("MatrixTeaBackgroundThread");
        r12.start();
        this.f19384i = new Handler(r12.getLooper());
        this.f19385j = new BinderC0245d(this);
        this.f19386k = new c(this);
    }
}
