package com.obric.aiagent.apm.impl;

import android.app.Application;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.Npth;
import com.bytedance.crash.ac;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ITraceDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.f.k;
import d.m;
import d.n.j;
import d.o.o;
import d.s;
import d.x;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: NpthImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private static final String TAG = "NpthImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f16113a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f16114b;

    /* JADX INFO: compiled from: NpthImpl.kt */
    public static final class a implements ICommonParams {
        @Override // com.bytedance.crash.ICommonParams
        public List<String> getPatchInfo() {
            return null;
        }

        @Override // com.bytedance.crash.ICommonParams
        public Map<String, Integer> getPluginInfo() {
            return null;
        }

        a() {
        }

        @Override // com.bytedance.crash.ICommonParams
        public Map<String, Object> getCommonParams() {
            return ao.a(new m[]{s.a(WsConstants.KEY_APP_ID, Integer.valueOf(IAppContext.Companion.getAppId())), s.a("version_name", IAppContext.Companion.getVersionName()), s.a("version_code", Integer.valueOf(IAppContext.Companion.getVersionCode())), s.a("update_version_code", Integer.valueOf(IAppContext.Companion.getUpdateVersionCode()))});
        }

        @Override // com.bytedance.crash.ICommonParams
        public String getDeviceId() {
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L5;
            String r3 = r2.getFlowDid();
        L6:
            if (r3 != null) goto L9;
            return "";
        L9:
            return r3;
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.crash.ICommonParams
        public long getUserId() {
            Long r2 = o.e(ITraceDepend.Companion.getUserID());
            if (r2 != null) goto L7;
            return 0;
        L7:
            return r2.longValue();
        }

        @Override // com.bytedance.crash.ICommonParams
        public String getSessionId() {
            return ITraceDepend.Companion.getSessionId();
        }
    }

    static {
        f16113a = new e();
    }

    private static final void a(ApplicationExitInfo r0) {
    }

    public static /* synthetic */ void lambda$5C3Qild_GprsOzF0WVGRD8e3v5w() {
        g();
    }

    /* JADX INFO: renamed from: lambda$ONHYolzG-JuLqcTsThvC9dcfQgU, reason: not valid java name */
    public static /* synthetic */ x m116lambda$ONHYolzGJuLqcTsThvC9dcfQgU(String r0, String r1, String r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$W5nQaDANCuiT2lMMIXC1_zGz6A4(File r0) {
        return b(r0);
    }

    public static /* synthetic */ void lambda$lFqWqIe6oirfrXNN5NBN4kv1Bxs(CrashType r0, String r1, Thread r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$llKdHNaJuJKQ7IMyqaR5HxBc8qs(ApplicationExitInfo r0) {
        a(r0);
    }

    public static /* synthetic */ long lambda$qNWyhUS_1j38LHBCvP3tBf5sW08(File r2) {
        return c(r2);
    }

    private e() {
    }

    public final void a() {
        boolean r1 = false;
        if (IAppContext.Companion.isDebug() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        f16114b = r0;
        Npth.setApplication((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));
        com.bytedance.crash.o.b.a(com.bytedance.apm.c.c());
        Npth.setOpenNewAnrMonitor(true);
        Npth.init((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (ICommonParams) ZeusTransformUtils.preCheckCast(new a(), ICommonParams.class, "com.obric.aiagent.plugin"), true, true, true);
        IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L12;
        String r3 = r2.getFlowDid();
    L13:
        if (r3 != null) goto L16;
        r3 = "";
    L16:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L18;
        r1 = true;
    L18:
        if (r1 == false) goto L20;
        a(r3);
    L21:
        b();
        c();
        e();
        f();
        return;
    L20:
        ITraceDepend.Companion.awaitTraceId($$Lambda$e$ONHYolzGJuLqcTsThvC9dcfQgU.INSTANCE);
        goto L21
    L12:
        r3 = null;
        goto L13
    L5:
        if (IAppContext.Companion.isReleaseChannel() == false) goto L8;
        r0 = false;
        goto L9
    }

    private static final x a(String r1, String r2, String r3) {
        d.h.b.o.e(r1, "d");
        d.h.b.o.e(r2, "<unused var>");
        d.h.b.o.e(r3, "<unused var>");
        f16113a.a(r1);
        return x.f38692a;
    }

    public final void a(String r1, String r2) {
        d.h.b.o.e(r1, "key");
        d.h.b.o.e(r2, "value");
        Npth.addTag(r1, r2);
    }

    private final void a(String r2) {
        if (ac.d().b() == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L7;
        return;
    L7:
        if (d.h.b.o.a("0", r2) == true) goto L12;
        ac.d().a(r2);
        return;
    }

    private final void b() {
        Npth.registerCrashCallback($$Lambda$e$lFqWqIe6oirfrXNN5NBN4kv1Bxs.INSTANCE, CrashType.ALL);
    }

    private static final void a(CrashType r6, String r7, Thread r8) {
        d.h.b.o.e(r6, "type");
        StringBuilder r2 = new StringBuilder("crash occurs!\n").append("crash-time:").append(f16113a.d()).append("\n");     // Catch: Throwable -> L11
        d.h.b.o.c(r2, "append(...)");     // Catch: Throwable -> L11
        if (r8 == null) goto L6;
        r2.append("thread-name:").append(r8.getName()).append("\n").append("thread-id:").append(r8.getId()).append("\n").append("process-name:").append(com.bytedance.apm.c.c()).append("\n");     // Catch: Throwable -> L11
    L6:
        r2.append("crash-type:").append(r6).append("\n");     // Catch: Throwable -> L11
        if (r7 == null) goto L9;
        r2.append(r7).append("\n");     // Catch: Throwable -> L11
    L9:
        ILogDepend.Companion.e("CrashMonitor", r2.toString());     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        ILogDepend.Companion.e("CrashMonitor", "registerCrashCallback error", th);
    }

    private final void c() {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return;
    L5:
        com.bytedance.crash.n.g.a($$Lambda$e$llKdHNaJuJKQ7IMyqaR5HxBc8qs.INSTANCE);
    }

    private final String d() {
        SimpleDateFormat r2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String r3 = r2.format(new Date());     // Catch: Exception -> L5
        d.h.b.o.c(r3, "format(...)");     // Catch: Exception -> L5
        return r3;
    L5:
        return "";
    }

    private final void e() {
        Npth.addAttachUserData((AttachUserData) ZeusTransformUtils.preCheckCast(new d(), AttachUserData.class, "com.obric.aiagent.plugin"), CrashType.ALL);
    }

    private final void f() {
        new Thread($$Lambda$e$5C3Qild_GprsOzF0WVGRD8e3v5w.INSTANCE).start();
    }

    private static final void g() {
        File r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getFilesDir();     // Catch: Exception -> L9
        e r1 = f16113a;     // Catch: Exception -> L9
        r1.a(r0);     // Catch: Exception -> L9
        if (r0 == null) goto L6;
        File r2 = r0.getParentFile();     // Catch: Exception -> L9
    L7:
        r1.a(r2);     // Catch: Exception -> L9
        return;
    L6:
        r2 = null;
    L9:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "checkNpthCrashFile error: " + e);
    }

    private final void a(File r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        File r4 = new File(r5.getAbsolutePath() + "/npth/crash");
        if (r4.exists() == true) goto L7;
        return;
    L7:
        if (r4.isDirectory() == false) goto L17;
        long r0 = d.n.m.m(d.n.m.d(d.n.m.a((j) ZeusTransformUtils.preCheckCast(k.d(r4), j.class, "com.obric.aiagent.plugin"), $$Lambda$e$W5nQaDANCuiT2lMMIXC1_zGz6A4.INSTANCE), $$Lambda$e$qNWyhUS_1j38LHBCvP3tBf5sW08.INSTANCE));
        if (r0 <= 314572800) goto L18;
        ILogDepend.Companion.i(TAG, "clearNpthCrashFileIfTooLarge, crashDir: " + r4.getAbsolutePath() + ", totalSize: " + r0);
        File[] r6 = r4.listFiles();
        if (r6 == null) goto L19;
        int r7 = 0;
        int r1 = r6.length;
    L13:
        if (r7 >= r1) goto L20;
        File r2 = r6[r7];
        d.h.b.o.a(r2);
        k.h(r2);
        r7 = r7 + 1;
        goto L13
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    private static final boolean b(File r1) {
        d.h.b.o.e(r1, "it");
        return r1.isFile();
    }

    private static final long c(File r2) {
        d.h.b.o.e(r2, "it");
        return r2.length();
    }
}
