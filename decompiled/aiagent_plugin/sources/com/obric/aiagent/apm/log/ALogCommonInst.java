package com.obric.aiagent.apm.log;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.alog.d;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.crash.Npth;
import com.c.a.b.c;
import com.obric.aiagent.apm.a;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.a.q;
import d.h.b.o;
import d.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: compiled from: ALogCommonInst.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ALogCommonInst implements LogInst {
    public static final ALogCommonInst INSTANCE = null;
    private static final String TAG = "ALogCommonInst";
    private static boolean debug;
    private static volatile boolean inited;
    private static final LogInst.Pending pending = null;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$3igfV2dQ2VC2XIZtiYI-UUvuHdg, reason: not valid java name */
    public static /* synthetic */ void m118lambda$3igfV2dQ2VC2XIZtiYIUUvuHdg() {
        initAlog$lambda$0();
    }

    public static /* synthetic */ void lambda$AviRw53lHx9rCJG1E8MhwQziZvk(b r0, q r1) {
        uploadALogInternal$lambda$1(r0, r1);
    }

    public static /* synthetic */ void lambda$_Q8XAanjY18VKGfCzP_Ok2qLWBY(b r0, q r1, boolean r2, JSONObject r3) {
        uploadALogInternal$lambda$5(r0, r1, r2, r3);
    }

    private ALogCommonInst() {
    }

    static {
        ALogCommonInst r0 = new ALogCommonInst();
        INSTANCE = r0;
        pending = new LogInst.Pending((ILogDepend) ZeusTransformUtils.preCheckCast(r0, ILogDepend.class, "com.obric.aiagent.plugin"));
    }

    public final void init(a r6) {
        o.e(r6, "config");
        com.ss.android.agilelogger.a.a(r6.a());
        boolean r0 = r6.a();
        debug = r0;
        initAlog(r0, r6.b(), r6.c(), (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        inited = true;
        pending.submit();
    }

    private final void initAlog(boolean r10, int r11, int r12, Context r13) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        if (r10 == false) goto L5;
        r11 = 2;
    L5:
        int r5 = r11;
        ISysLogDepend.Companion.i(TAG, "initAlog, isDebug=" + r10 + ", logLevel=" + r5 + ", maxALogDirSizeMb=" + r12);
        com.ss.android.agilelogger.a.a(LogInst.Companion.createConfig$default(LogInst.Companion, r2, r10, r12, r5, null, 16, null));
        d.a(r10);
        com.c.a.a.a((c) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), c.class, "com.obric.aiagent.plugin"));
        if (com.ss.android.agilelogger.a.a() == false) goto L9;
        com.ss.android.agilelogger.a.c(TAG, "alog enableALogCollector");
        Npth.enableALogCollector(com.ss.android.agilelogger.a.f37047a.f(), $$Lambda$ALogCommonInst$3igfV2dQ2VC2XIZtiYIUUvuHdg.INSTANCE, (com.bytedance.crash.alog.d) ZeusTransformUtils.preCheckCast(new com.bytedance.crash.alog.b(), com.bytedance.crash.alog.d.class, "com.obric.aiagent.plugin"));
        return;
    }

    private static final void initAlog$lambda$0() {
        com.ss.android.agilelogger.a.e(TAG, "app happen crash, upload alog");
        com.ss.android.agilelogger.a.c();
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void v(String r11, String r12) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(2, r11, r12, null, 0, 16, null));
        return;
    L6:
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        com.ss.android.agilelogger.a.a(r11, r12);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void d(String r11, String r12) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(3, r11, r12, null, 0, 16, null));
        return;
    L6:
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        com.ss.android.agilelogger.a.b(r11, r12);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void i(String r11, String r12) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(4, r11, r12, null, 0, 16, null));
        return;
    L6:
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        com.ss.android.agilelogger.a.c(r11, r12);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void w(String r11, String r12) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(5, r11, r12, null, 0, 16, null));
        return;
    L6:
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        com.ss.android.agilelogger.a.d(r11, r12);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void w(String r11, String r12, Throwable r13) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(5, r11, r12, r13, 0, 16, null));
        return;
    L6:
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        com.ss.android.agilelogger.a.a(r11, r12, r13);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void w(String r11, Throwable r12) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(5, r11, null, r12, 0, 16, null));
        return;
    L6:
        com.ss.android.agilelogger.a.a(r11, "", r12);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void e(String r11, String r12) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(6, r11, r12, null, 0, 16, null));
        return;
    L6:
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        com.ss.android.agilelogger.a.e(r11, r12);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void e(String r11, String r12, Throwable r13) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(6, r11, r12, r13, 0, 16, null));
        return;
    L6:
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        com.ss.android.agilelogger.a.b(r11, r12, r13);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public boolean isDebug() {
        return debug;
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public String getDirPath() {
        com.ss.android.agilelogger.b r0 = com.ss.android.agilelogger.a.f37047a;
        if (r0 == null) goto L6;
        String r1 = r0.f();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void uploadAllLog(String r11, q<? super Boolean, ? super Integer, ? super String, x> r12) {
        q<? super Boolean, ? super Integer, ? super String, x> r7 = (q) ZeusTransformUtils.wrapperContextForParams(r12, q.class, "com.obric.aiagent.plugin");
        o.e(r11, DBHelper.BATTERY_COL_SCENE);
        d(TAG, "uploadALogData: called");
        long r2 = 1000;
        uploadALogInternal(r11, (System.currentTimeMillis() / r2) - ((long) 10800), System.currentTimeMillis() / r2, null, r7);
    }

    private final void uploadALogInternal(String r9, long r10, long r12, b<? super Boolean, x> r14, q<? super Boolean, ? super Integer, ? super String, x> r15) {
        final b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r14, b.class, "com.obric.aiagent.plugin");
        final q r16 = (q) ZeusTransformUtils.wrapperContextForParams(r15, q.class, "com.obric.aiagent.plugin");
        if (com.ss.android.agilelogger.a.f37047a != null) goto L5;
    L7:
        StringBuilder r11 = new StringBuilder().append("[uploadAlogInternal] Error : ");
        if (com.ss.android.agilelogger.a.f37047a != null) goto L14;
        if (r8 == null) goto L11;
        r8.invoke(false);
    L11:
        if (r16 == null) goto L13;
        r16.invoke(false, 0, "log config is null");
    L13:
        String r13 = "ALog.sConfig is null";
    L19:
        INVOKESTATIC_com_obric_aiagent_apm_log_ALogCommonInst_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, r11.append(r13).toString());
        return;
    L14:
        if (r8 == null) goto L16;
        r8.invoke(false);
    L16:
        if (r16 == null) goto L18;
        r16.invoke(false, 4, "log file is null");
    L18:
        r13 = "Alog logDirPath is empty!";
        goto L19
    L5:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(com.ss.android.agilelogger.a.f37047a.f(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L7;
        com.bytedance.apm.b.a(com.ss.android.agilelogger.a.f37047a.f(), r10, r12, r9, new $$Lambda$ALogCommonInst$AviRw53lHx9rCJG1E8MhwQziZvk(r8, r16), new $$Lambda$ALogCommonInst$_Q8XAanjY18VKGfCzP_Ok2qLWBY(r8, r16));
    }

    private static final void uploadALogInternal$lambda$1(b r4, q r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        q r7 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
        com.ss.android.agilelogger.a.c();     // Catch: Exception -> L5
        Thread.sleep(1000);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        INVOKESTATIC_com_obric_aiagent_apm_log_ALogCommonInst_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "[uploadAlogInternal] Error in flush Alog to file!", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        if (r6 == null) goto L9;
        r6.invoke(false);
    L9:
        if (r7 == null) goto L14;
        r7.invoke(false, 0, "");
        return;
    }

    private static final void uploadALogInternal$lambda$5(b r9, q r10, boolean r11, JSONObject r12) {
        b r13 = (b) ZeusTransformUtils.wrapperContextForParams(r9, b.class, "com.obric.aiagent.plugin");
        q r14 = (q) ZeusTransformUtils.wrapperContextForParams(r10, q.class, "com.obric.aiagent.plugin");
        INVOKESTATIC_com_obric_aiagent_apm_log_ALogCommonInst_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "IALogActiveUploadCallback: onCallback called, success = " + r11 + ", ret = " + r12);
        boolean r2 = true;
        if (r11 == false) goto L37;
        File r15 = new File(com.ss.android.agilelogger.a.f37047a.f());
        if (r15.exists() == true) goto L7;
    L9:
        boolean r16 = false;
    L10:
        if (r16 == true) goto L13;
        r15 = null;
    L13:
        if (r15 == null) goto L33;
        File[] r17 = r15.listFiles();
        if (r17 == null) goto L33;
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r5 = r17.length;
        int r6 = 0;
    L17:
        if (r6 >= r5) goto L27;
        File r7 = r17[r6];
        if (r7.exists() == true) goto L21;
    L23:
        boolean r8 = false;
    L24:
        if (r8 == false) goto L26;
        r18.add(r7);
    L26:
        r6 = r6 + 1;
        goto L17
    L21:
        if (r7.isFile() == false) goto L23;
        r8 = true;
        goto L24
    L27:
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L29:
        if (r19.hasNext() == false) goto L33;
        File r110 = (File) ZeusTransformUtils.preCheckCast(r19.next(), File.class, "com.obric.aiagent.plugin");
        if (r110 == null) goto L29;
        r110.delete();
    L33:
        if (r13 == null) goto L35;
        r13.invoke(true);
    L35:
        if (r14 == null) goto L61;
        r14.invoke(true, -1, "");
        return;
    L61:
        return;
    L7:
        if (r15.listFiles() == null) goto L9;
        r16 = true;
        goto L10
    L37:
        if (r12 == null) goto L48;
        int r111 = r12.optInt(MonitorConstants.CODE, 0);
        if (r111 != (-1)) goto L41;
    L44:
        if (r13 == null) goto L46;
        r13.invoke(Boolean.valueOf(r2));
    L46:
        if (r14 == null) goto L63;
        Boolean r20 = Boolean.valueOf(r2);
        Integer r112 = Integer.valueOf(r111);
        String r113 = r12.toString();
        o.c(r113, "toString(...)");
        r14.invoke(r20, r112, r113);
        return;
    L63:
        return;
    L41:
        if (r111 == 5) goto L44;
        r2 = false;
        goto L44
    L48:
        if (r13 == null) goto L50;
        r13.invoke(false);
    L50:
        if (r14 == null) goto L65;
        r14.invoke(false, 0, "log config is null");
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aiagent_apm_log_ALogCommonInst_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aiagent_apm_log_ALogCommonInst_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
