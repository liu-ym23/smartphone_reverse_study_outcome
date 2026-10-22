package com.stepos.stepclaw.memory.utils;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m0.f;
import p5.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJC\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\fR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"Lcom/stepos/stepclaw/memory/utils/PerfTrace;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "T", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "tag", "label", "sessionId", "Lkotlin/Function0;", "block", "trace", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp5/a;)Ljava/lang/Object;", "traceWithResult", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ExtensionCallContract.ENABLED, "Z", "getEnabled", "()Z", "setEnabled", "(Z)V", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "getLogger", "()Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "setLogger", "(Lcom/stepos/stepclaw/memory/utils/MemoryLogger;)V", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PerfTrace {
    public static final PerfTrace INSTANCE = new PerfTrace();
    private static boolean enabled = true;
    private static MemoryLogger logger;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: com.stepos.stepclaw.memory.utils.PerfTrace$trace$1, reason: invalid class name */
    public static final class AnonymousClass1 implements a {
        final /* synthetic */ String $label;
        final /* synthetic */ long $start;
        final /* synthetic */ String $traceSuffix;

        public AnonymousClass1(String str, long j4, String str2) {
            this.$label = str;
            this.$start = j4;
            this.$traceSuffix = str2;
        }

        @Override // p5.a
        public final String invoke() {
            String str = this.$label;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.$start;
            String str2 = this.$traceSuffix;
            StringBuilder sb = new StringBuilder("[PERF] ");
            sb.append(str);
            sb.append(": cost=");
            sb.append(jCurrentTimeMillis);
            return f.f(sb, "ms", str2);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: com.stepos.stepclaw.memory.utils.PerfTrace$traceWithResult$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00721 implements a {
        final /* synthetic */ long $elapsed;
        final /* synthetic */ String $extra;
        final /* synthetic */ String $label;
        final /* synthetic */ String $traceSuffix;

        public C00721(String str, long j4, String str2, String str3) {
            this.$label = str;
            this.$elapsed = j4;
            this.$extra = str2;
            this.$traceSuffix = str3;
        }

        @Override // p5.a
        public final String invoke() {
            return "[PERF] " + this.$label + ": cost=" + this.$elapsed + "ms" + this.$extra + this.$traceSuffix;
        }
    }

    private PerfTrace() {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object traceWithResult$default(com.stepos.stepclaw.memory.utils.PerfTrace r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, p5.a r12, int r13, java.lang.Object r14) {
        /*
            r13 = r13 & 4
            if (r13 == 0) goto L5
            r11 = 0
        L5:
            java.lang.String r13 = "tag"
            kotlin.jvm.internal.p.e(r9, r13)
            java.lang.String r13 = "label"
            kotlin.jvm.internal.p.e(r10, r13)
            java.lang.String r13 = "block"
            kotlin.jvm.internal.p.e(r12, r13)
            boolean r13 = r8.getEnabled()
            if (r13 != 0) goto L1f
            java.lang.Object r8 = r12.invoke()
            return r8
        L1f:
            long r13 = java.lang.System.currentTimeMillis()
            java.lang.Object r12 = r12.invoke()
            long r0 = java.lang.System.currentTimeMillis()
            long r4 = r0 - r13
            boolean r13 = r12 instanceof java.lang.Integer
            java.lang.String r14 = ""
            if (r13 == 0) goto L3b
            java.lang.String r13 = ", count="
            java.lang.String r13 = a8.b.m(r12, r13)
        L39:
            r6 = r13
            goto L47
        L3b:
            boolean r13 = r12 instanceof java.lang.Boolean
            if (r13 == 0) goto L46
            java.lang.String r13 = ", success="
            java.lang.String r13 = a8.b.m(r12, r13)
            goto L39
        L46:
            r6 = r14
        L47:
            if (r11 == 0) goto L4f
            java.lang.String r13 = " | traceId="
            java.lang.String r14 = r13.concat(r11)
        L4f:
            r7 = r14
            com.stepos.stepclaw.memory.utils.MemoryLogger r8 = r8.getLogger()
            if (r8 == 0) goto L5f
            com.stepos.stepclaw.memory.utils.PerfTrace$traceWithResult$1 r2 = new com.stepos.stepclaw.memory.utils.PerfTrace$traceWithResult$1
            r3 = r10
            r2.<init>(r3, r4, r6, r7)
            r8.logD(r9, r11, r2)
        L5f:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.utils.PerfTrace.traceWithResult$default(com.stepos.stepclaw.memory.utils.PerfTrace, java.lang.String, java.lang.String, java.lang.String, p5.a, int, java.lang.Object):java.lang.Object");
    }

    public final boolean getEnabled() {
        return enabled;
    }

    public final MemoryLogger getLogger() {
        return logger;
    }

    public final void setEnabled(boolean z) {
        enabled = z;
    }

    public final void setLogger(MemoryLogger memoryLogger) {
        logger = memoryLogger;
    }

    public final <T> T trace(String tag, String label, String sessionId, a block) {
        p.e(tag, "tag");
        p.e(label, "label");
        p.e(block, "block");
        if (!getEnabled()) {
            return (T) block.invoke();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        T t8 = (T) block.invoke();
        String strConcat = sessionId != null ? " | traceId=".concat(sessionId) : SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        MemoryLogger logger2 = getLogger();
        if (logger2 != null) {
            logger2.logD(tag, sessionId, new AnonymousClass1(label, jCurrentTimeMillis, strConcat));
        }
        return t8;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> T traceWithResult(java.lang.String r11, java.lang.String r12, java.lang.String r13, p5.a r14) {
        /*
            r10 = this;
            java.lang.String r0 = "tag"
            kotlin.jvm.internal.p.e(r11, r0)
            java.lang.String r0 = "label"
            kotlin.jvm.internal.p.e(r12, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.p.e(r14, r0)
            boolean r0 = r10.getEnabled()
            if (r0 != 0) goto L1a
            java.lang.Object r10 = r14.invoke()
            return r10
        L1a:
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Object r14 = r14.invoke()
            long r2 = java.lang.System.currentTimeMillis()
            long r6 = r2 - r0
            boolean r0 = r14 instanceof java.lang.Integer
            java.lang.String r1 = ""
            if (r0 == 0) goto L36
            java.lang.String r0 = ", count="
            java.lang.String r0 = a8.b.m(r14, r0)
        L34:
            r8 = r0
            goto L42
        L36:
            boolean r0 = r14 instanceof java.lang.Boolean
            if (r0 == 0) goto L41
            java.lang.String r0 = ", success="
            java.lang.String r0 = a8.b.m(r14, r0)
            goto L34
        L41:
            r8 = r1
        L42:
            if (r13 == 0) goto L4a
            java.lang.String r0 = " | traceId="
            java.lang.String r1 = r0.concat(r13)
        L4a:
            r9 = r1
            com.stepos.stepclaw.memory.utils.MemoryLogger r10 = r10.getLogger()
            if (r10 == 0) goto L5a
            com.stepos.stepclaw.memory.utils.PerfTrace$traceWithResult$1 r4 = new com.stepos.stepclaw.memory.utils.PerfTrace$traceWithResult$1
            r5 = r12
            r4.<init>(r5, r6, r8, r9)
            r10.logD(r11, r13, r4)
        L5a:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.utils.PerfTrace.traceWithResult(java.lang.String, java.lang.String, java.lang.String, p5.a):java.lang.Object");
    }
}
