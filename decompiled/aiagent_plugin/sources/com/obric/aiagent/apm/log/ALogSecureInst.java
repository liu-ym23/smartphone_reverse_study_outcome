package com.obric.aiagent.apm.log;

import android.app.Application;
import android.content.Context;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import com.ss.android.agilelogger.a;
import com.ss.android.agilelogger.b.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: ALogSecureInst.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ALogSecureInst implements LogInst {
    public static final ALogSecureInst INSTANCE = null;
    private static final String INSTANCE_NAME = "SensitiveContent";
    private static final String TAG = "ALogSecureInst";
    private static boolean debug;
    private static volatile boolean inited;
    private static a.b inst;
    private static final LogInst.Pending pending = null;

    private ALogSecureInst() {
    }

    static {
        ALogSecureInst r0 = new ALogSecureInst();
        INSTANCE = r0;
        pending = new LogInst.Pending((ILogDepend) ZeusTransformUtils.preCheckCast(r0, ILogDepend.class, "com.obric.aiagent.plugin"));
    }

    public final void init(com.obric.aiagent.apm.a r6) {
        o.e(r6, "config");
        a.a(false);
        debug = r6.a();
        ISysLogDepend.Companion.i(TAG, "initAlog, isDebug=" + debug + ", logLevel=2, maxALogDirSizeMb=" + r6.c());
        initAlog(debug, 2, r6.c(), (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        inited = true;
        pending.submit();
    }

    private final void initAlog(boolean r9, int r10, int r11, Context r12) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        inst = a.a(INSTANCE_NAME, LogInst.Companion.createConfig$default(LogInst.Companion, r1, r9, r11, r10, null, 16, null));
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void v(String r11, String r12) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(2, r11, r12, null, 0, 16, null));
        return;
    L6:
        a.b r10 = inst;
        if (r10 == null) goto L12;
        if (r12 != null) goto L10;
        r12 = "";
    L10:
        r10.a(r11, r12);
        return;
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void d(String r11, String r12) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(3, r11, r12, null, 0, 16, null));
        return;
    L6:
        a.b r10 = inst;
        if (r10 == null) goto L12;
        if (r12 != null) goto L10;
        r12 = "";
    L10:
        r10.b(r11, r12);
        return;
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void i(String r11, String r12) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(4, r11, r12, null, 0, 16, null));
        return;
    L6:
        a.b r10 = inst;
        if (r10 == null) goto L12;
        if (r12 != null) goto L10;
        r12 = "";
    L10:
        r10.c(r11, r12);
        return;
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void w(String r11, String r12) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(5, r11, r12, null, 0, 16, null));
        return;
    L6:
        a.b r10 = inst;
        if (r10 == null) goto L12;
        if (r12 != null) goto L10;
        r12 = "";
    L10:
        r10.d(r11, r12);
        return;
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void w(String r11, String r12, Throwable r13) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(5, r11, r12, r13, 0, 16, null));
        return;
    L6:
        a.b r10 = inst;
        if (r10 == null) goto L13;
        StringBuilder r0 = new StringBuilder();
        if (r12 != null) goto L11;
        r12 = "";
    L11:
        r10.d(r11, r0.append(r12).append('\n').append(d.a(r13)).toString());
        return;
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void w(String r11, Throwable r12) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(5, r11, null, r12, 0, 16, null));
        return;
    L6:
        a.b r10 = inst;
        if (r10 == null) goto L10;
        r10.d(r11, d.a(r12));
        return;
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void e(String r11, String r12) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(6, r11, r12, null, 0, 16, null));
        return;
    L6:
        a.b r10 = inst;
        if (r10 == null) goto L12;
        if (r12 != null) goto L10;
        r12 = "";
    L10:
        r10.e(r11, r12);
        return;
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void e(String r11, String r12, Throwable r13) {
        o.e(r11, "tag");
        if (inited == true) goto L6;
        pending.add(new LogInst.Pending.LogInfo(6, r11, r12, r13, 0, 16, null));
        return;
    L6:
        a.b r10 = inst;
        if (r10 == null) goto L13;
        StringBuilder r0 = new StringBuilder();
        if (r12 != null) goto L11;
        r12 = "";
    L11:
        r10.e(r11, r0.append(r12).append('\n').append(d.a(r13)).toString());
        return;
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public boolean isDebug() {
        return debug;
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public String getDirPath() {
        String r0 = a.f37047a.f();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void uploadAllLog(String r3, q<? super Boolean, ? super Integer, ? super String, x> r4) {
        q r5 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        o.e(r3, DBHelper.BATTERY_COL_SCENE);
        w(TAG, "uploadALogData is not allow for secure logs");
    }
}
