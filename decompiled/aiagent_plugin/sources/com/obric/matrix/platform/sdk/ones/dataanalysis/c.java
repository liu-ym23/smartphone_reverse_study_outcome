package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.o.d;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: MatrixTeaManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static final String TAG = "MatrixTeaManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33671a = null;
    private static c p;
    private static final AtomicBoolean q = null;
    private static String r;
    private static String s;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f33672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.matrix.platform.sdk.ones.dataanalysis.b f33673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private IDataService f33674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private IBinder f33675e;
    private boolean f;
    private final CopyOnWriteArrayList<com.obric.matrix.platform.sdk.ones.dataanalysis.a> g;
    private final Handler h;
    private final CopyOnWriteArrayList<b> i;
    private final Runnable j;
    private final MatrixTeaManager$binderDeathRecipient$1 k;
    private final RunnableC0909c l;
    private final Handler m;
    private final MatrixTeaManager$deviceInfoCallback$1 n;
    private final MatrixTeaManager$connection$1 o;

    /* JADX INFO: compiled from: MatrixTeaManager.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final void a(Context r3, com.obric.matrix.platform.sdk.ones.dataanalysis.b r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r2, "context");
            o.e(r4, "config");
            if (c.d() == null) goto L5;
        L15:
            c r5 = c.d();
            o.a(r5);
            r5.bindService();
            return;
        L5:
            monitor-enter(c.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (c.d() != null) goto L9;
            a r0 = c.f33671a;     // Catch: Throwable -> L12
            c.a(new c(r2, r4, null));     // Catch: Throwable -> L12
        L9:
            x r6 = x.f38692a;     // Catch: Throwable -> L12
            monitor-exit(c.class);
            goto L15
        }

        public final c a() {
            if (c.d() == null) goto L7;
            c r1 = c.d();
            o.a(r1);
            return r1;
        L7:
            throw new IllegalStateException("MatrixTeaManager还没初始化，请先调用init方法进行初始化~~~".toString());
        }
    }

    /* JADX INFO: compiled from: MatrixTeaManager.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f33676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JSONObject f33677b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f33676a, r6.f33676a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f33677b, r6.f33677b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f33676a.hashCode() * 31) + this.f33677b.hashCode();
        }

        public String toString() {
            return "PendingEvent(eventName=" + this.f33676a + ", jsonObject=" + this.f33677b + ')';
        }

        public b(String r2, JSONObject r3) {
            o.e(r2, "eventName");
            o.e(r3, "jsonObject");
            this.f33676a = r2;
            this.f33677b = r3;
        }

        public final String a() {
            return this.f33676a;
        }

        public final JSONObject b() {
            return this.f33677b;
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.dataanalysis.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MatrixTeaManager.kt */
    public static final class RunnableC0909c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f33678a;

        RunnableC0909c(c r1) {
            this.f33678a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.b(this.f33678a) == true) goto L6;
            com.obric.matrix.platform.sdk.ones.internal.b.b.c(c.TAG, "尝试重新绑定下载服务", null, 4, null);
            this.f33678a.b();
            c.c(this.f33678a).postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.aiagent.plugin"), 5000);
            return;
        }
    }

    public /* synthetic */ c(Context r2, com.obric.matrix.platform.sdk.ones.dataanalysis.b r3, h r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    }

    public static /* synthetic */ void lambda$UpmKQdv0ZMLc4nlPck15_gPLiKU(c r0, String r1, JSONObject r2, JSONObject r3) {
        a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$hl2An6Y7wlJAqRWYLrk6-1rmW9w, reason: not valid java name */
    public static /* synthetic */ void m949lambda$hl2An6Y7wlJAqRWYLrk61rmW9w(c r0) {
        i(r0);
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager$deviceInfoCallback$1] */
    /* JADX WARN: Type inference failed for: r3v13, types: [com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager$connection$1] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager$binderDeathRecipient$1] */
    private c(Context r3, com.obric.matrix.platform.sdk.ones.dataanalysis.b r4) {
        this.f33672b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f33673c = r4;
        this.g = new CopyOnWriteArrayList();
        this.h = new Handler(Looper.getMainLooper());
        this.i = new CopyOnWriteArrayList();
        this.j = new $$Lambda$c$hl2An6Y7wlJAqRWYLrk61rmW9w(this);
        this.k = new MatrixTeaManager$binderDeathRecipient$1(this);
        this.l = new RunnableC0909c(this);
        HandlerThread r5 = new HandlerThread("MatrixTeaBackgroundThread");
        r5.start();
        this.m = new Handler(r5.getLooper());
        this.n = new MatrixTeaManager$deviceInfoCallback$1(this);
        this.o = new MatrixTeaManager$connection$1(this);
    }

    public static final /* synthetic */ void a(c r0) {
        p = r0;
    }

    public static final /* synthetic */ void a(c r2, IBinder r3) {
        r2.f33675e = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(c r2, IDataService r3) {
        r2.f33674d = (IDataService) ZeusTransformUtils.wrapperContextForParams(r3, IDataService.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(c r0, boolean r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(String r0) {
        r = r0;
    }

    public static final /* synthetic */ void b(c r0, boolean r1) {
        r0.f = r1;
    }

    public static final /* synthetic */ void b(String r0) {
        s = r0;
    }

    public static final /* synthetic */ boolean b(c r0) {
        return r0.f;
    }

    public static final /* synthetic */ Handler c(c r0) {
        return r0.h;
    }

    public static final /* synthetic */ c d() {
        return p;
    }

    public static final /* synthetic */ CopyOnWriteArrayList d(c r0) {
        return r0.g;
    }

    public static final /* synthetic */ MatrixTeaManager$binderDeathRecipient$1 e(c r0) {
        return r0.k;
    }

    public static final /* synthetic */ IDataService f(c r0) {
        return r0.f33674d;
    }

    public static final /* synthetic */ MatrixTeaManager$deviceInfoCallback$1 g(c r0) {
        return r0.n;
    }

    public static final /* synthetic */ void h(c r0) {
        r0.e();
    }

    private static final void i(c r4) {
        o.e(r4, "this$0");
        r4.b();
        r4.h.removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(r4.l, Runnable.class, "com.obric.aiagent.plugin"));
        r4.h.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(r4.l, Runnable.class, "com.obric.aiagent.plugin"), 5000);
    }

    static {
        f33671a = new a(null);
        q = new AtomicBoolean(false);
    }

    static /* synthetic */ void a(c r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.a(r1);
    }

    private final void a(boolean r6) {
        if (r6 == false) goto L13;
        IBinder r7 = this.f33675e;
        if (r7 == null) goto L13;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L8
        Object r8 = n.f(Boolean.valueOf(r7.unlinkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin")).k, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0)));     // Catch: Throwable -> L8
    L10:
        Throwable r9 = n.c(r8);
        if (r9 == null) goto L13;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "unlinkToDeath skipped: " + r9.getMessage(), null, 4, null);
    L8:
        th = move-exception;
        n.a r0 = n.f38560a;
        r8 = n.f(d.o.a(th));
    L13:
        this.f33675e = null;
        this.f33674d = null;
        this.f = false;
    }

    private final void e() {
        if (this.i.isEmpty() == false) goto L6;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "没有暂存的事件需要处理", null, 4, null);
        return;
    L6:
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "开始处理 " + this.i.size() + " 个暂存事件", null, 4, null);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.i, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L20;
        Object r6 = r1.next();
        b r7 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin");
        boolean r8 = false;
        JSONObject r10 = new JSONObject(r7.b().toString());     // Catch: Exception -> L16
        r10.put("app_package_name", this.f33673c.a());     // Catch: Exception -> L16
        r10.put("app_version_code", this.f33673c.b());     // Catch: Exception -> L16
        r10.put("app_version_name", this.f33673c.c());     // Catch: Exception -> L16
        if (this.f33673c.d() == false) goto L13;
        int r12 = 1;
    L14:
        r10.put("app_is_boe", r12);     // Catch: Exception -> L16
        b(r7.a(), r10);     // Catch: Exception -> L16
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "成功发送暂存事件: " + r7.a(), null, 4, null);     // Catch: Exception -> L16
    L18:
        if (r8 == false) goto L8;
        r4.add(r6);
        goto L8
    L13:
        r12 = 0;
    L16:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "发送暂存事件 " + r7.a() + " 失败", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r8 = true;
        goto L18
    L20:
        List r2 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        this.i.clear();
        this.i.addAll((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin"));
    }

    public final void a() {
        a(this, false, 1, null);     // Catch: Exception -> L5
        this.h.removeCallbacks(this.j);     // Catch: Exception -> L5
        this.h.postDelayed(this.j, WsConstants.EXIT_DELAY_TIME);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "rebindService error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final void bindService() {
        if (q.compareAndSet(false, true) == true) goto L6;
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("tea has inited");
        return;
    L6:
        b();
        this.h.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this.l, Runnable.class, "com.obric.aiagent.plugin"), 5000);
    }

    public final void b() {
        if (this.f == false) goto L6;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "bindServiceInternal: service is already bound", null, 4, null);
        return;
    L6:
        Intent r0 = new Intent();
        r0.setAction("com.obric.matrix.dataanalysis.service");
        r0.setPackage("com.obric.matrix");
        ZeusTransformUtils.bindService(this.f33672b, r0, (ServiceConnection) ZeusTransformUtils.preCheckCast(this.o, ServiceConnection.class, "com.obric.aiagent.plugin"), 1, "com.obric.aiagent.plugin");
    }

    public final String c() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L14;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "getDeviceId 有值，立即回调 " + r, null, 4, null);
        return r;
    L14:
        if (this.f == true) goto L26;
        com.obric.matrix.platform.sdk.ones.internal.b.b.e(TAG, "getDeviceId error,Service not bounded", null, 4, null);
        return null;
    L26:
        IDataService r5 = this.f33674d;     // Catch: Exception -> L21
        if (r5 == null) goto L18;
        String r6 = r5.getDeviceId();     // Catch: Exception -> L21
    L19:
        r = r6;     // Catch: Exception -> L21
        return r6;
    L18:
        r6 = null;
    L21:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "getDeviceId error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public final void a(String r7, JSONObject r8) {
        o.e(r7, "eventName");
        o.e(r8, "jsonObject");
        String r1 = r8.toString();     // Catch: Throwable -> L23
        o.c(r1, "jsonObject.toString()");     // Catch: Throwable -> L23
        byte[] r2 = r1.getBytes(d.f38623b);     // Catch: Throwable -> L23
        o.c(r2, "this as java.lang.String).getBytes(charset)");     // Catch: Throwable -> L23
        int r3 = r2.length;     // Catch: Throwable -> L23
        if (r3 <= 204800) goto L9;
        com.obric.matrix.platform.sdk.ones.internal.b.b.e(TAG, "事件 " + r7 + " 数据大小 " + r3 + " 字节超过200KB限制，已丢弃", null, 4, null);
        return;
    L9:
        if (this.f == false) goto L30;
        r8.put("app_package_name", this.f33673c.a());     // Catch: Exception -> L16
        r8.put("app_version_code", this.f33673c.b());     // Catch: Exception -> L16
        r8.put("app_version_name", this.f33673c.c());     // Catch: Exception -> L16
        if (this.f33673c.d() == false) goto L13;
        int r4 = 1;
    L14:
        r8.put("app_is_boe", r4);     // Catch: Exception -> L16
        b(r7, r8);     // Catch: Exception -> L16
        return;
    L13:
        r4 = 0;
    L16:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "onEvent error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L30:
        this.i.add(new b(r7, new JSONObject(r8.toString())));     // Catch: Exception -> L20
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "服务未绑定，暂存事件: " + r7 + " 成功，当前暂存数量: " + this.i.size(), null, 4, null);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "服务未绑定，暂存事件 " + r7 + " 失败", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L23:
        th = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "计算事件大小失败，已丢弃事件 " + r7, th);
    }

    private final void b(final String r4, final JSONObject r5) {
        final JSONObject r0 = a(r5);
        this.m.post(new $$Lambda$c$UpmKQdv0ZMLc4nlPck15_gPLiKU(this, r4, r0, r5));
    }

    private static final void a(c r1, String r2, JSONObject r3, JSONObject r4) {
        o.e(r1, "this$0");
        o.e(r2, "$eventName");
        o.e(r3, "$copyJson");
        o.e(r4, "$jsonObject");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L9
        IDataService r5 = r1.f33674d;     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        r5.onEvent(r2, r3.toString());     // Catch: Throwable -> L9
        x r6 = x.f38692a;     // Catch: Throwable -> L9
    L7:
        Object r7 = n.f(r6);     // Catch: Throwable -> L9
    L11:
        Throwable r8 = n.c(r7);
        if (r8 == null) goto L17;
        r1.i.add(new b(r2, r4));
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "onEvent error", r8);
        return;
    L17:
        return;
    L6:
        r6 = null;
    L9:
        th = move-exception;
        n.a r9 = n.f38560a;
        r7 = n.f(d.o.a(th));
        goto L11
    }

    private final JSONObject a(JSONObject r5) {
        List r4 = (List) ZeusTransformUtils.preCheckCast(new LinkedList(), List.class, "com.obric.aiagent.plugin");
        Iterator<String> r0 = r5.keys();
    L4:
        if (r0.hasNext() == false) goto L22;
        String r2 = r0.next();
        o.c(r2, "keysIterable.next()");
        r4.add(r2);
        goto L4
    L22:
        n.a r1 = n.f38560a;     // Catch: Throwable -> L11
        Object[] r6 = ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]);     // Catch: Throwable -> L11
        if (r6 == null) goto L10;
        Object r7 = n.f(new JSONObject(r5, (String[]) ZeusTransformUtils.preCheckCast(r6, String[].class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L11
    L13:
        Throwable r3 = n.c(r7);
        if (r3 == null) goto L16;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "copyJson error", r3);
    L16:
        Object r8 = r5;
        if (n.b(r7) == true) goto L21;
        r8 = r7;
    L21:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r8, JSONObject.class, "com.obric.aiagent.plugin");
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        n.a r9 = n.f38560a;
        r7 = n.f(d.o.a(th));
        goto L13
    }

    public final void a(long r3) {
        JSONObject r0 = new JSONObject();
        r0.put("duration", r3);
        a("apm_event_coldlaunch_first_frame", r0);
    }

    public final void a(com.obric.matrix.platform.sdk.ones.dataanalysis.a r8) {
        com.obric.matrix.platform.sdk.ones.dataanalysis.a r9 = (com.obric.matrix.platform.sdk.ones.dataanalysis.a) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.matrix.platform.sdk.ones.dataanalysis.a.class, "com.obric.aiagent.plugin");
        o.e(r9, "listener");
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "addDeviceInfoListener " + r9, null, 4, null);
        if (this.g.contains(r9) == true) goto L5;
        this.g.add(r9);
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "addDeviceInfoListener不包含，添加进listeners中,当前size = " + this.g.size(), null, 4, null);
    L5:
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r0 = false;
        if (r7 != null) goto L8;
    L11:
        boolean r10 = true;
    L12:
        if (r10 == true) goto L14;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "注册deviceInfoListener时did有值，立即回调 " + r, null, 4, null);
        String r11 = r;
        o.a(r11);
        r9.a(r11);
    L14:
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(s, CharSequence.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L17;
    L18:
        r0 = true;
    L19:
        if (r0 == true) goto L22;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "注册deviceInfoListener时installId有值，立即回调 " + s, null, 4, null);
        String r13 = s;
        o.a(r13);
        r9.b(r13);
        return;
    L22:
        return;
    L17:
        if (r12.length() != 0) goto L19;
    L8:
        if (r7.length() == 0) goto L11;
        r10 = false;
        goto L12
    }

    public final void b(com.obric.matrix.platform.sdk.ones.dataanalysis.a r5) {
        com.obric.matrix.platform.sdk.ones.dataanalysis.a r6 = (com.obric.matrix.platform.sdk.ones.dataanalysis.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.matrix.platform.sdk.ones.dataanalysis.a.class, "com.obric.aiagent.plugin");
        o.e(r6, "listener");
        this.g.remove(r6);     // Catch: Exception -> L5
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "removeDeviceInfoListener " + r6 + ", size = " + this.g.size(), null, 4, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "removeDeviceInfoListener error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
