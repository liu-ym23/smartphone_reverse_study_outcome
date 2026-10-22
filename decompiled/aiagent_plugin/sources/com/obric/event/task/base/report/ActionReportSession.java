package com.obric.event.task.base.report;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.IAppContext;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.Iterator;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;
import org.json.JSONObject;

/* JADX INFO: compiled from: ActionReportSession.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ActionReportSession implements androidx.lifecycle.m {
    private static final String TAG = "ActionReportSession";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32743a = null;
    private static final am f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f32744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JSONObject f32745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ca f32746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f32747e;

    /* JADX INFO: compiled from: ActionReportSession.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ActionReportSession.kt */
    @d.c.b.a.f(b = "ActionReportSession.kt", c = {65}, d = "invokeSuspend", e = "com.obric.event.task.base.report.ActionReportSession$start$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f32749b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<x> f32750c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionReportSession f32751d;

        b(long r3, d.h.a.a<x> r5, ActionReportSession r6, d.c.d<? super b> r7) {
            d.h.a.a<x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32749b = r3;
            this.f32750c = r8;
            this.f32751d = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f32749b, this.f32750c, this.f32751d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f32748a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L19:
            d.h.a.a<x> r7 = this.f32750c;     // Catch: Throwable -> L16
            if (r7 == null) goto L14;
            r7.invoke();     // Catch: Throwable -> L16
        L14:
            ActionReportSession.a(this.f32751d);
            return x.f38692a;
        L16:
            th = move-exception;
            ActionReportSession.a(this.f32751d);
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            long r3 = this.f32749b;
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32748a = 1;
            if (ax.a(r3, r8) != r0) goto L19;
            return r0;
        }
    }

    public ActionReportSession(String r2, JSONObject r3) {
        d.h.b.o.e(r2, "eventName");
        this.f32744b = r2;
        this.f32745c = r3;
    }

    public static final /* synthetic */ void a(ActionReportSession r0) {
        r0.a();
    }

    static {
        f32743a = new a(null);
        f = an.a(bd.c().plus((d.c.g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), d.c.g.class, "com.obric.aiagent.plugin")));
    }

    public static /* synthetic */ void a(ActionReportSession r1, androidx.lifecycle.p r2, long r3, d.h.a.a r5, int r6, Object r7) {
        androidx.lifecycle.p r4 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r2, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 5000;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r8 = null;
    L11:
        r1.a(r4, r3, r8);
    }

    public final synchronized void a(androidx.lifecycle.p r11, long r12, d.h.a.a<x> r14) {
        monitor-enter(this);
        androidx.lifecycle.p r13 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r11, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        a(this, null, 1, null);     // Catch: Throwable -> L11
        if (r13 == null) goto L8;
        androidx.lifecycle.i r15 = r13.getLifecycle();     // Catch: Throwable -> L11
        if (r15 == null) goto L8;
        r15.a((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
    L8:
        this.f32747e = System.currentTimeMillis();     // Catch: Throwable -> L11
        this.f32746d = kotlinx.coroutines.i.a(f, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r12, r3, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void a(ActionReportSession r0, JSONObject r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.a(r1);
    }

    public final synchronized void a(JSONObject r5) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f32747e != 0) goto L9;
        monitor-exit(this);
        return;
    L9:
        JSONObject r6 = b(0, "success", r5);     // Catch: Throwable -> L15
        IAppLog r0 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r0 == null) goto L12;
        r0.reportToFlow(this.f32744b, r6);     // Catch: Throwable -> L15
    L12:
        a(this.f32744b, r6);     // Catch: Throwable -> L15
        a(this, null, 1, null);     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    public static /* synthetic */ void a(ActionReportSession r0, int r1, String r2, JSONObject r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    public final synchronized void a(int r5, String r6, JSONObject r7) {
        monitor-enter(this);
        d.h.b.o.e(r6, "errorMsg");     // Catch: Throwable -> L25
        if (this.f32747e != 0) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (r5 != (-102)) goto L11;
    L19:
        com.obric.event.task.base.b.b.f32684a.d(TAG, "fail, errorCode cannot be -101 or 0 or -102");     // Catch: Throwable -> L25
        if (IAppContext.Companion.isTestChannel() == true) goto L24;
        monitor-exit(this);
        return;
    L24:
        throw new IllegalArgumentException("errorCode cannot be -101 or 0 or -102 in test channel");     // Catch: Throwable -> L25
    L11:
        if (r5 == (-101)) goto L19;
        if (r5 == 0) goto L19;
        JSONObject r8 = b(r5, r6, r7);     // Catch: Throwable -> L25
        IAppLog r9 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r9 == null) goto L16;
        r9.reportToFlow(this.f32744b, r8);     // Catch: Throwable -> L25
    L16:
        a(this.f32744b, r8);     // Catch: Throwable -> L25
        a(this, null, 1, null);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    private final synchronized void a() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f32747e != 0) goto L9;
        monitor-exit(this);
        return;
    L9:
        JSONObject r0 = b(this, -101, "timeout", null, 4, null);     // Catch: Throwable -> L15
        IAppLog r1 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        r1.reportToFlow(this.f32744b, r0);     // Catch: Throwable -> L15
    L12:
        a(this.f32744b, r0);     // Catch: Throwable -> L15
        a(this, null, 1, null);     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    public static /* synthetic */ void a(ActionReportSession r1, androidx.lifecycle.p r2, int r3, Object r4) {
        androidx.lifecycle.p r5 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r2, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        r1.a(r5);
    }

    public final synchronized void a(androidx.lifecycle.p r3) {
        monitor-enter(this);
        androidx.lifecycle.p r4 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r3, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r4 == null) goto L8;
        androidx.lifecycle.i r5 = r4.getLifecycle();     // Catch: Throwable -> L14
        if (r5 == null) goto L8;
        r5.b((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
    L8:
        ca r6 = this.f32746d;     // Catch: Throwable -> L14
        if (r6 == null) goto L11;
        ca.a.a(r6, null, 1, null);     // Catch: Throwable -> L14
    L11:
        this.f32746d = null;     // Catch: Throwable -> L14
        this.f32747e = 0;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private final synchronized void b(androidx.lifecycle.p r8) {
        monitor-enter(this);
        androidx.lifecycle.p r9 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r8, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (this.f32747e != 0) goto L9;
        monitor-exit(this);
        return;
    L9:
        JSONObject r0 = b(this, -102, "cancel", null, 4, null);     // Catch: Throwable -> L15
        IAppLog r1 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        r1.reportToFlow(this.f32744b, r0);     // Catch: Throwable -> L15
    L12:
        a(this.f32744b, r0);     // Catch: Throwable -> L15
        a(r9);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ JSONObject b(ActionReportSession r0, int r1, String r2, JSONObject r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.b(r1, r2, r3);
    }

    private final JSONObject b(int r6, String r7, JSONObject r8) {
        JSONObject r0 = this.f32745c;
        if (r0 != null) goto L5;
        r0 = new JSONObject();
    L5:
        a(r0, r8);
        r0.put("duration_ms", System.currentTimeMillis() - this.f32747e);
        r0.put("error_code", r6);
        r0.put("error_msg", r7);
        return r0;
    }

    private final void a(JSONObject r4, JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Iterator<String> r3 = r5.keys();
    L6:
        if (r3.hasNext() == false) goto L8;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        r4.put(r0, r5.opt(r0));
        goto L6
    }

    @Override // androidx.lifecycle.m
    public void onStateChanged(androidx.lifecycle.p r3, androidx.lifecycle.i.a r4) {
        androidx.lifecycle.p r5 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r3, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r4, "event");
        if (r4 != androidx.lifecycle.i.a.ON_PAUSE) goto L6;
        b(r5);
        return;
    }

    private final void a(String r3, JSONObject r4) {
        com.obric.event.task.base.b.b.f32684a.a(TAG, "ActionReportSession " + r3 + ' ' + r4);
    }
}
