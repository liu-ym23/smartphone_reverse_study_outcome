package com.obric.aiagent.apm.log;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import d.h.a.q;
import d.h.b.o;
import d.k;
import d.x;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: AndroidLogcatInst.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AndroidLogcatInst implements LogInst {
    public static final AndroidLogcatInst INSTANCE = null;
    private static boolean debug;

    /* JADX INFO: compiled from: AndroidLogcatInst.kt */
    public static final enum Level extends Enum<Level> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ Level[] $VALUES = null;
        public static final Level D = null;
        public static final Level E = null;
        public static final Level I = null;
        public static final Level V = null;
        public static final Level W = null;

        private static final /* synthetic */ Level[] $values() {
            return new Level[]{V, D, I, W, E};
        }

        public static a<Level> getEntries() {
            return $ENTRIES;
        }

        private Level(String r1, int r2) {
            super(r1, r2);
        }

        static {
            V = new Level("V", 0);
            D = new Level("D", 1);
            I = new Level("I", 2);
            W = new Level("W", 3);
            E = new Level("E", 4);
            Level[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static Level valueOf(String r2) {
            return (Level) ZeusTransformUtils.preCheckCast(Enum.valueOf(Level.class, r2), Level.class, "com.obric.aiagent.plugin");
        }

        public static Level[] values() {
            return (Level[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Level[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: AndroidLogcatInst.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Level.values().length];
            r0[Level.V.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[Level.D.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[Level.I.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[Level.W.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[Level.E.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new AndroidLogcatInst();
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    private AndroidLogcatInst() {
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public String getDirPath() {
        return LogInst.DefaultImpls.getDirPath(this);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void uploadAllLog(String r3, q<? super Boolean, ? super Integer, ? super String, x> r4) {
        LogInst.DefaultImpls.uploadAllLog(this, r3, (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin"));
    }

    public final void init(boolean r1) {
        debug = r1;
    }

    public final void sysLogcat(Level r8, String r9, String r10) {
        o.e(r8, "level");
        o.e(r9, "tag");
        Class r0 = ZeusTransformUtils.forName("android.util.Log", "com.obric.aiagent.plugin");     // Catch: Exception -> L25
        int r11 = WhenMappings.$EnumSwitchMapping$0[r8.ordinal()];     // Catch: Exception -> L25
        if (r11 == 1) goto L19;
        if (r11 != 2) goto L8;
        Method r12 = r0.getMethod("d", new Class[]{String.class, String.class});     // Catch: Exception -> L25
        o.c(r12, "getMethod(...)");     // Catch: Exception -> L25
    L20:
        Object[] r1 = new Object[2];     // Catch: Exception -> L25
        r1[0] = r9;     // Catch: Exception -> L25
        if (r10 != null) goto L23;
        r10 = "";
    L23:
        r1[1] = r10;     // Catch: Exception -> L25
        r12.invoke(null, r1);     // Catch: Exception -> L25
        return;
    L8:
        if (r11 != 3) goto L10;
        r12 = r0.getMethod("i", new Class[]{String.class, String.class});     // Catch: Exception -> L25
        o.c(r12, "getMethod(...)");     // Catch: Exception -> L25
        goto L20
    L10:
        if (r11 != 4) goto L12;
        r12 = r0.getMethod(DownloadFileUtils.MODE_WRITE, new Class[]{String.class, String.class});     // Catch: Exception -> L25
        o.c(r12, "getMethod(...)");     // Catch: Exception -> L25
        goto L20
    L12:
        if (r11 != 5) goto L15;
        r12 = r0.getMethod("e", new Class[]{String.class, String.class});     // Catch: Exception -> L25
        o.c(r12, "getMethod(...)");     // Catch: Exception -> L25
        goto L20
    L15:
        throw new k();     // Catch: Exception -> L25
    L19:
        r12 = r0.getMethod("v", new Class[]{String.class, String.class});     // Catch: Exception -> L25
        o.c(r12, "getMethod(...)");     // Catch: Exception -> L25
    L25:
        e = move-exception;
        INVOKESTATIC_com_obric_aiagent_apm_log_AndroidLogcatInst_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("AndroidLogcatInst", "sysLogcat err", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final void sysLogcat(Level r9, String r10, String r11, Throwable r12) {
        o.e(r9, "level");
        o.e(r10, "tag");
        Class r0 = ZeusTransformUtils.forName("android.util.Log", "com.obric.aiagent.plugin");     // Catch: Exception -> L24
        int r13 = WhenMappings.$EnumSwitchMapping$0[r9.ordinal()];     // Catch: Exception -> L24
        if (r13 == 1) goto L18;
        if (r13 == 2) goto L17;
        if (r13 != 3) goto L9;
        Method r14 = r0.getMethod("i", new Class[]{String.class, String.class, Throwable.class});     // Catch: Exception -> L24
        o.c(r14, "getMethod(...)");     // Catch: Exception -> L24
    L19:
        Object[] r1 = new Object[3];     // Catch: Exception -> L24
        r1[0] = r10;     // Catch: Exception -> L24
        if (r11 != null) goto L22;
        r11 = "";
    L22:
        r1[1] = r11;     // Catch: Exception -> L24
        r1[2] = r12;     // Catch: Exception -> L24
        r14.invoke(null, r1);     // Catch: Exception -> L24
        return;
    L9:
        if (r13 != 4) goto L11;
        r14 = r0.getMethod(DownloadFileUtils.MODE_WRITE, new Class[]{String.class, String.class, Throwable.class});     // Catch: Exception -> L24
        o.c(r14, "getMethod(...)");     // Catch: Exception -> L24
        goto L19
    L11:
        if (r13 != 5) goto L14;
        r14 = r0.getMethod("e", new Class[]{String.class, String.class, Throwable.class});     // Catch: Exception -> L24
        o.c(r14, "getMethod(...)");     // Catch: Exception -> L24
        goto L19
    L14:
        throw new k();     // Catch: Exception -> L24
    L17:
        r14 = r0.getMethod("d", new Class[]{String.class, String.class, Throwable.class});     // Catch: Exception -> L24
        o.c(r14, "getMethod(...)");     // Catch: Exception -> L24
        goto L19
    L18:
        r14 = r0.getMethod("v", new Class[]{String.class, String.class, Throwable.class});     // Catch: Exception -> L24
        o.c(r14, "getMethod(...)");     // Catch: Exception -> L24
    L24:
        e = move-exception;
        INVOKESTATIC_com_obric_aiagent_apm_log_AndroidLogcatInst_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("AndroidLogcatInst", "sysLogcat err", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void v(String r2, String r3) {
        o.e(r2, "tag");
        sysLogcat(Level.V, r2, r3);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void d(String r2, String r3) {
        o.e(r2, "tag");
        sysLogcat(Level.D, r2, r3);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void i(String r2, String r3) {
        o.e(r2, "tag");
        sysLogcat(Level.I, r2, r3);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void w(String r2, String r3) {
        o.e(r2, "tag");
        sysLogcat(Level.W, r2, r3);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void w(String r2, String r3, Throwable r4) {
        o.e(r2, "tag");
        sysLogcat(Level.W, r2, r3, r4);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void w(String r3, Throwable r4) {
        o.e(r3, "tag");
        sysLogcat(Level.W, r3, null, r4);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void e(String r2, String r3) {
        o.e(r2, "tag");
        sysLogcat(Level.E, r2, r3);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public void e(String r2, String r3, Throwable r4) {
        o.e(r2, "tag");
        sysLogcat(Level.E, r2, r3, r4);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public boolean isDebug() {
        return debug;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aiagent_apm_log_AndroidLogcatInst_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
