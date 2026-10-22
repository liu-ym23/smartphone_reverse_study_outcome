package com.obric.aiagent.apm.log;

import android.content.Context;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.agilelogger.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LogInst.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface LogInst extends ILogDepend {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: LogInst.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public static /* synthetic */ b createConfig$default(Companion r6, Context r7, boolean r8, int r9, int r10, String r11, int r12, Object r13) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
            if ((r12 & 16) == 0) goto L6;
            r11 = "";
        L6:
            return r6.createConfig(r1, r8, r9, r10, r11);
        }

        public final b createConfig(Context r2, boolean r3, int r4, int r5, String r6) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            o.e(r6, "logPath");
            if (r3 == false) goto L5;
            r4 = 50;
        L5:
            b.a r7 = new b.a(r1).a((r4 * 1024) * 1024).b(UiType.FLAG_REMOTE_CARD);
            boolean r8 = true;
            b.a r9 = r7.a(true).b(true).a(1.0f).c(true);
            if (r5 > 0) goto L8;
            r5 = 2;
        L8:
            b.a r10 = r9.c(r5);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L12;
            r8 = false;
        L12:
            if (r8 == false) goto L14;
            r10.a(r6);
        L14:
            b r11 = r10.a();
            o.c(r11, "build(...)");
            return r11;
        }
    }

    /* JADX INFO: compiled from: LogInst.kt */
    public static final class DefaultImpls {
        public static String getDirPath(LogInst r2) {
            return ILogDepend.DefaultImpls.getDirPath((ILogDepend) ZeusTransformUtils.preCheckCast((LogInst) ZeusTransformUtils.wrapperContextForParams(r2, LogInst.class, "com.obric.aiagent.plugin"), ILogDepend.class, "com.obric.aiagent.plugin"));
        }

        public static boolean isDebug(LogInst r2) {
            return ILogDepend.DefaultImpls.isDebug((ILogDepend) ZeusTransformUtils.preCheckCast((LogInst) ZeusTransformUtils.wrapperContextForParams(r2, LogInst.class, "com.obric.aiagent.plugin"), ILogDepend.class, "com.obric.aiagent.plugin"));
        }

        public static void uploadAllLog(LogInst r2, String r3, q<? super Boolean, ? super Integer, ? super String, x> r4) {
            LogInst r5 = (LogInst) ZeusTransformUtils.wrapperContextForParams(r2, LogInst.class, "com.obric.aiagent.plugin");
            q r6 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
            o.e(r3, DBHelper.BATTERY_COL_SCENE);
            ILogDepend.DefaultImpls.uploadAllLog((ILogDepend) ZeusTransformUtils.preCheckCast(r5, ILogDepend.class, "com.obric.aiagent.plugin"), r3, r6);
        }
    }

    /* JADX INFO: compiled from: LogInst.kt */
    public static final class Pending {
        public static final Companion Companion = null;
        private static final int MAX_PENDING_SIZE = 10000;
        private static final int TRIM_PENDING_SIZE = 2000;
        private final ILogDepend inst;
        private final List<LogInfo> pendingLogs;

        /* JADX INFO: compiled from: LogInst.kt */
        public static final class Companion {
            public /* synthetic */ Companion(h r1) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: LogInst.kt */
        public static final class LogInfo {
            private final int level;
            private final String message;
            private final long millis;
            private final String tag;
            private final Throwable th;

            public static /* synthetic */ LogInfo copy$default(LogInfo r4, int r5, String r6, String r7, Throwable r8, long r9, int r11, Object r12) {
                if ((r11 & 1) == 0) goto L6;
                r5 = r4.level;
            L6:
                if ((r11 & 2) == 0) goto L8;
                r6 = r4.tag;
            L8:
                String r13 = r6;
                if ((r11 & 4) == 0) goto L11;
                r7 = r4.message;
            L11:
                String r0 = r7;
                if ((r11 & 8) == 0) goto L14;
                r8 = r4.th;
            L14:
                Throwable r1 = r8;
                if ((r11 & 16) == 0) goto L17;
                r9 = r4.millis;
            L17:
                int r10 = r5;
                return r4.copy(r10, r13, r0, r1, r9);
            }

            public final int component1() {
                return this.level;
            }

            public final String component2() {
                return this.tag;
            }

            public final String component3() {
                return this.message;
            }

            public final Throwable component4() {
                return this.th;
            }

            public final long component5() {
                return this.millis;
            }

            public final LogInfo copy(int r8, String r9, String r10, Throwable r11, long r12) {
                o.e(r9, "tag");
                return new LogInfo(r8, r9, r10, r11, r12);
            }

            public boolean equals(Object r7) {
                if (this != r7) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r7, LogInfo.class) == true) goto L8;
                return false;
            L8:
                LogInfo r8 = (LogInfo) ZeusTransformUtils.preCheckCast(r7, LogInfo.class, "com.obric.aiagent.plugin");
                if (this.level == r8.level) goto L12;
                return false;
            L12:
                if (o.a(this.tag, r8.tag) == true) goto L15;
                return false;
            L15:
                if (o.a(this.message, r8.message) == true) goto L18;
                return false;
            L18:
                if (o.a(this.th, r8.th) == true) goto L21;
                return false;
            L21:
                if (this.millis == r8.millis) goto L23;
                return false;
            L23:
                return true;
            }

            public int hashCode() {
                int r0 = ((Integer.hashCode(this.level) * 31) + this.tag.hashCode()) * 31;
                String r1 = this.message;
                int r2 = 0;
                if (r1 != null) goto L5;
                int r3 = 0;
            L6:
                int r4 = (r0 + r3) * 31;
                Throwable r5 = this.th;
                if (r5 == null) goto L11;
                r2 = r5.hashCode();
            L11:
                return ((r4 + r2) * 31) + Long.hashCode(this.millis);
            L5:
                r3 = r1.hashCode();
                goto L6
            }

            public String toString() {
                return "LogInfo(level=" + this.level + ", tag=" + this.tag + ", message=" + this.message + ", th=" + this.th + ", millis=" + this.millis + ')';
            }

            public LogInfo(int r2, String r3, String r4, Throwable r5, long r6) {
                o.e(r3, "tag");
                this.level = r2;
                this.tag = r3;
                this.message = r4;
                this.th = r5;
                this.millis = r6;
            }

            public final int getLevel() {
                return this.level;
            }

            public final String getTag() {
                return this.tag;
            }

            public final String getMessage() {
                return this.message;
            }

            public final Throwable getTh() {
                return this.th;
            }

            public /* synthetic */ LogInfo(int r8, String r9, String r10, Throwable r11, long r12, int r14, h r15) {
                if ((r14 & 16) == 0) goto L5;
                r12 = System.currentTimeMillis();
            L5:
                this(r8, r9, r10, r11, r12);
            }

            public final long getMillis() {
                return this.millis;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Pending(ILogDepend r3) {
            ILogDepend r4 = (ILogDepend) ZeusTransformUtils.wrapperContextForParams(r3, ILogDepend.class, "com.obric.aiagent.plugin");
            o.e(r4, "inst");
            this.inst = r4;
            this.pendingLogs = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        }

        public final boolean add(LogInfo r5) {
            o.e(r5, "logInfo");
            List<LogInfo> r0 = this.pendingLogs;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.pendingLogs.size() < 10000) goto L7;
            int r1 = Math.min(2000, this.pendingLogs.size());     // Catch: Throwable -> L10
            this.pendingLogs.subList(0, r1).clear();     // Catch: Throwable -> L10
        L7:
            boolean r4 = this.pendingLogs.add(r5);     // Catch: Throwable -> L10
            monitor-exit(r0);
            return r4;
        }

        public final void submit() {
            List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            List<LogInfo> r1 = this.pendingLogs;
            monitor-enter(r1);
            r0.addAll((Collection) ZeusTransformUtils.preCheckCast(this.pendingLogs, Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L27
            this.pendingLogs.clear();     // Catch: Throwable -> L27
            x r2 = x.f38692a;     // Catch: Throwable -> L27
            monitor-exit(r1);
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L8:
            if (r3.hasNext() == false) goto L26;
            LogInfo r4 = (LogInfo) ZeusTransformUtils.preCheckCast(r3.next(), LogInfo.class, "com.obric.aiagent.plugin");
            String r5 = r4.getMessage() + ", <pending:" + (System.currentTimeMillis() - r4.getMillis()) + "ms>";
            int r6 = r4.getLevel();
            if (r6 != 2) goto L12;
            this.inst.v(r4.getTag(), r5);
            goto L8
        L12:
            if (r6 != 3) goto L14;
            this.inst.d(r4.getTag(), r5);
            goto L8
        L14:
            if (r6 != 4) goto L16;
            this.inst.i(r4.getTag(), r5);
            goto L8
        L16:
            if (r6 != 5) goto L18;
            this.inst.w(r4.getTag(), r5, r4.getTh());
            goto L8
        L18:
            if (r6 != 6) goto L21;
            this.inst.e(r4.getTag(), r5, r4.getTh());
            goto L8
        L21:
            throw new IllegalArgumentException(r4.toString());
        L26:
            return;
        L27:
            th = move-exception;
            throw th;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
