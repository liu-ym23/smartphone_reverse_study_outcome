package com.obric.autogui.common.api.platform.input;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.a;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: InjectEventContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InjectEventContext {
    public static final InjectEventContext INSTANCE = null;
    private static final String TAG = "InjectEventContext";
    private static final LinkedHashMap<Integer, Context> eventIdToContext = null;
    private static final Object lock = null;
    private static long unresolvedCount;

    /* JADX INFO: compiled from: InjectEventContext.kt */
    public static final class Context {
        private final boolean isOmniSession;
        private final Integer multiStepCount;
        private final Integer multiStepIndex;
        private final String omniActionType;
        private final String sessionId;
        private final String stepId;
        private final Integer stepIndex;
        private final String stepJournalDirPath;
        private final String toolId;

        public static /* synthetic */ Context copy$default(Context r10, String r11, String r12, Integer r13, String r14, String r15, Integer r16, Integer r17, String r18, boolean r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            String r2 = r10.sessionId;
        L7:
            if ((r20 & 2) == 0) goto L9;
            String r3 = r10.stepId;
        L11:
            if ((r20 & 4) == 0) goto L13;
            Integer r4 = r10.stepIndex;
        L15:
            if ((r20 & 8) == 0) goto L17;
            String r5 = r10.toolId;
        L19:
            if ((r20 & 16) == 0) goto L21;
            String r6 = r10.omniActionType;
        L23:
            if ((r20 & 32) == 0) goto L25;
            Integer r7 = r10.multiStepIndex;
        L27:
            if ((r20 & 64) == 0) goto L29;
            Integer r8 = r10.multiStepCount;
        L31:
            if ((r20 & 128) == 0) goto L33;
            String r9 = r10.stepJournalDirPath;
        L35:
            if ((r20 & 256) == 0) goto L37;
            boolean r1 = r10.isOmniSession;
        L39:
            return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
        L37:
            r1 = r19;
            goto L39
        L33:
            r9 = r18;
            goto L35
        L29:
            r8 = r17;
            goto L31
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r4 = r13;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r2 = r11;
            goto L7
        }

        public final String component1() {
            return this.sessionId;
        }

        public final String component2() {
            return this.stepId;
        }

        public final Integer component3() {
            return this.stepIndex;
        }

        public final String component4() {
            return this.toolId;
        }

        public final String component5() {
            return this.omniActionType;
        }

        public final Integer component6() {
            return this.multiStepIndex;
        }

        public final Integer component7() {
            return this.multiStepCount;
        }

        public final String component8() {
            return this.stepJournalDirPath;
        }

        public final boolean component9() {
            return this.isOmniSession;
        }

        public final Context copy(String r12, String r13, Integer r14, String r15, String r16, Integer r17, Integer r18, String r19, boolean r20) {
            o.e(r12, ObricMemoryConstants.KEY_SESSION_ID);
            o.e(r13, "stepId");
            return new Context(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Context.class) == true) goto L8;
            return false;
        L8:
            Context r6 = (Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.aiagent.plugin");
            if (o.a(this.sessionId, r6.sessionId) == true) goto L12;
            return false;
        L12:
            if (o.a(this.stepId, r6.stepId) == true) goto L15;
            return false;
        L15:
            if (o.a(this.stepIndex, r6.stepIndex) == true) goto L18;
            return false;
        L18:
            if (o.a(this.toolId, r6.toolId) == true) goto L21;
            return false;
        L21:
            if (o.a(this.omniActionType, r6.omniActionType) == true) goto L24;
            return false;
        L24:
            if (o.a(this.multiStepIndex, r6.multiStepIndex) == true) goto L27;
            return false;
        L27:
            if (o.a(this.multiStepCount, r6.multiStepCount) == true) goto L30;
            return false;
        L30:
            if (o.a(this.stepJournalDirPath, r6.stepJournalDirPath) == true) goto L33;
            return false;
        L33:
            if (this.isOmniSession == r6.isOmniSession) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.sessionId.hashCode() * 31) + this.stepId.hashCode()) * 31;
            Integer r1 = this.stepIndex;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.toolId;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.omniActionType;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Integer r11 = this.multiStepIndex;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Integer r14 = this.multiStepCount;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.stepJournalDirPath;
            if (r17 == null) goto L27;
            r2 = r17.hashCode();
        L27:
            return ((r16 + r2) * 31) + Boolean.hashCode(this.isOmniSession);
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "Context(sessionId=" + this.sessionId + ", stepId=" + this.stepId + ", stepIndex=" + this.stepIndex + ", toolId=" + this.toolId + ", omniActionType=" + this.omniActionType + ", multiStepIndex=" + this.multiStepIndex + ", multiStepCount=" + this.multiStepCount + ", stepJournalDirPath=" + this.stepJournalDirPath + ", isOmniSession=" + this.isOmniSession + ')';
        }

        public Context(String r2, String r3, Integer r4, String r5, String r6, Integer r7, Integer r8, String r9, boolean r10) {
            o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
            o.e(r3, "stepId");
            this.sessionId = r2;
            this.stepId = r3;
            this.stepIndex = r4;
            this.toolId = r5;
            this.omniActionType = r6;
            this.multiStepIndex = r7;
            this.multiStepCount = r8;
            this.stepJournalDirPath = r9;
            this.isOmniSession = r10;
        }

        public /* synthetic */ Context(String r14, String r15, Integer r16, String r17, String r18, Integer r19, Integer r20, String r21, boolean r22, int r23, h r24) {
            if ((r23 & 4) == 0) goto L5;
            Integer r6 = null;
        L7:
            if ((r23 & 8) == 0) goto L9;
            String r7 = null;
        L11:
            if ((r23 & 16) == 0) goto L13;
            String r8 = null;
        L15:
            if ((r23 & 32) == 0) goto L17;
            Integer r9 = null;
        L19:
            if ((r23 & 64) == 0) goto L21;
            Integer r10 = null;
        L23:
            if ((r23 & 128) == 0) goto L25;
            String r11 = null;
        L27:
            if ((r23 & 256) == 0) goto L29;
            boolean r12 = false;
        L30:
            this(r14, r15, r6, r7, r8, r9, r10, r11, r12);
            return;
        L29:
            r12 = r22;
            goto L30
        L25:
            r11 = r21;
            goto L27
        L21:
            r10 = r20;
            goto L23
        L17:
            r9 = r19;
            goto L19
        L13:
            r8 = r18;
            goto L15
        L9:
            r7 = r17;
            goto L11
        L5:
            r6 = r16;
            goto L7
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getStepId() {
            return this.stepId;
        }

        public final Integer getStepIndex() {
            return this.stepIndex;
        }

        public final String getToolId() {
            return this.toolId;
        }

        public final String getOmniActionType() {
            return this.omniActionType;
        }

        public final Integer getMultiStepIndex() {
            return this.multiStepIndex;
        }

        public final Integer getMultiStepCount() {
            return this.multiStepCount;
        }

        public final String getStepJournalDirPath() {
            return this.stepJournalDirPath;
        }

        public final boolean isOmniSession() {
            return this.isOmniSession;
        }

        public final String logFields() {
            StringBuilder r0 = new StringBuilder().append("sessionId=").append(this.sessionId).append(", stepId=").append(this.stepId).append(", stepIndex=").append(this.stepIndex).append(", toolId=").append(this.toolId).append(", actionType=").append(this.omniActionType).append(", multiStepIndex=").append(this.multiStepIndex).append(", multiStepCount=").append(this.multiStepCount).append(", isOmniSession=").append(this.isOmniSession).append(", hasJournalDir=");
            CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(this.stepJournalDirPath, CharSequence.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L5;
        L8:
            boolean r4 = true;
        L10:
            return r0.append(!r4).toString();
        L5:
            if (d.o.o.d(r3) == true) goto L8;
            r4 = false;
            goto L10
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.platform.input.InjectEventContext$clearSessionDelayed$1, reason: invalid class name */
    /* JADX INFO: compiled from: InjectEventContext.kt */
    @f(b = "InjectEventContext.kt", c = {123}, d = "invokeSuspend", e = "com.obric.autogui.common.api.platform.input.InjectEventContext$clearSessionDelayed$1")
    static final class AnonymousClass1 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ a<x> $onCleared;
        final /* synthetic */ String $sessionId;
        int label;

        AnonymousClass1(String r3, a<x> r4, d<? super AnonymousClass1> r5) {
            a<x> r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.$sessionId = r3;
            this.$onCleared = r6;
            super(2, r7);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$sessionId, this.$onCleared, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L24:
            InjectEventContext.INSTANCE.clearSession(this.$sessionId);     // Catch: Throwable -> L19
            a<x> r7 = this.$onCleared;
            if (r7 == null) goto L18;
            r7.invoke();
        L18:
            return x.f38692a;
        L19:
            th = move-exception;
            a<x> r9 = this.$onCleared;
            if (r9 == null) goto L23;
            r9.invoke();
        L23:
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            long r3 = InjectEventContext.access$clearDelayMillis(InjectEventContext.INSTANCE);
            if (r3 <= 0) goto L24;
            AOThreadingTools r10 = AOThreadingTools.INSTANCE;
            d<? super x> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            if (r10.delayForMillis(r3, r2) != r0) goto L24;
            return r0;
        }
    }

    private InjectEventContext() {
    }

    public static final /* synthetic */ long access$clearDelayMillis(InjectEventContext r2) {
        return r2.clearDelayMillis();
    }

    static {
        INSTANCE = new InjectEventContext();
        lock = new Object();
        eventIdToContext = new LinkedHashMap(16, 0.75f, true);
    }

    public final void registerInjectEvent(int r13, Context r14) {
        o.e(r14, "context");
        if (com.obric.autogui.common.a.h.f28984a.b() == true) goto L9;
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L39;
        Loog.INSTANCE.d(TAG, "registerInjectEvent skipped, feature disabled, inputEventId=" + r13);
        return;
    L39:
        return;
    L9:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14.getSessionId(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L11;
        String r12 = r14.getToolId();
        if (r12 != null) goto L17;
    L19:
        String r4 = null;
    L20:
        String r15 = r14.getOmniActionType();
        if (r15 != null) goto L23;
    L25:
        String r5 = null;
    L26:
        Context r16 = Context.copy$default(r14, null, null, null, r4, r5, null, null, null, false, 487, null);
        Object r17 = lock;
        monitor-enter(r17);
        ((Map) ZeusTransformUtils.preCheckCast(eventIdToContext, Map.class, "com.obric.aiagent.plugin")).put(Integer.valueOf(r13), r16);     // Catch: Throwable -> L34
        INSTANCE.trimToMaxEntriesLocked();     // Catch: Throwable -> L34
        x r0 = x.f38692a;     // Catch: Throwable -> L34
        monitor-exit(r17);
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L41;
        Loog.INSTANCE.i(TAG, "registerInjectEvent inputEventId=" + r13 + ", " + r16.logFields());
        return;
    L41:
        return;
    L34:
        th = move-exception;
        throw th;
    L23:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L25;
        r5 = r15;
        goto L26
    L17:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L19;
        r4 = r12;
        goto L20
    L11:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L40;
        Loog.INSTANCE.w(TAG, "registerInjectEvent skipped, sessionId is blank, stepId=" + r14.getStepId());
        return;
    }

    public final void unregisterInjectEvent(int r5, String r6) {
        o.e(r6, "reason");
        Object r4 = lock;
        monitor-enter(r4);
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(eventIdToContext.remove(Integer.valueOf(r5)), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        monitor-exit(r4);
        if (r0 != null) goto L8;
        return;
    L8:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L17;
        Loog.INSTANCE.i(TAG, "unregisterInjectEvent inputEventId=" + r5 + ", reason=" + r6 + ", " + r0.logFields());
        return;
    L17:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final Context resolve(int r8) {
        Object r7 = lock;
        monitor-enter(r7);
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(eventIdToContext.get(Integer.valueOf(r8)), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        monitor-exit(r7);
        if (r0 != null) goto L17;
        monitor-enter(r7);
        InjectEventContext r1 = INSTANCE;     // Catch: Throwable -> L13
        long r2 = unresolvedCount + 1;     // Catch: Throwable -> L13
        unresolvedCount = r2;     // Catch: Throwable -> L13
        monitor-exit(r7);
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L19;
        Loog.INSTANCE.w(TAG, "resolve miss, inputEventId=" + r8 + ", unresolvedCount=" + r2 + ", mapSize=" + r1.sizeSnapshot());
    L19:
        return r0;
    L13:
        th = move-exception;
        throw th;
    L17:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L19;
        Loog.INSTANCE.i(TAG, "resolve hit, inputEventId=" + r8 + ", " + r0.logFields() + ", mapSize=" + INSTANCE.sizeSnapshot());
    L20:
        th = move-exception;
        throw th;
    }

    public final void clearSession(String r6) {
        o.e(r6, ObricMemoryConstants.KEY_SESSION_ID);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        Object r5 = lock;
        monitor-enter(r5);
        Iterator<Map.Entry<Integer, Context>> r0 = eventIdToContext.entrySet().iterator();     // Catch: Throwable -> L20
        int r1 = 0;
    L9:
        if (r0.hasNext() == false) goto L14;
        if (o.a(((Context) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), Context.class, "com.obric.aiagent.plugin")).getSessionId(), r6) == false) goto L9;
        r0.remove();     // Catch: Throwable -> L20
        r1 = r1 + 1;
        goto L9
    L14:
        monitor-exit(r5);
        if (r1 > 0) goto L17;
        return;
    L17:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L31;
        Loog.INSTANCE.i(TAG, "clearSession sessionId=" + r6 + ", removed=" + r1 + " entries");
        return;
    L31:
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void clearSessionDelayed$default(InjectEventContext r1, String r2, a r3, int r4, Object r5) {
        a<x> r6 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.clearSessionDelayed(r2, r6);
    }

    public final void clearSessionDelayed(String r4, a<x> r5) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        o.e(r4, ObricMemoryConstants.KEY_SESSION_ID);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L7;
        if (r3 == null) goto L9;
        r3.invoke();
        return;
    L9:
        return;
    L7:
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4, r3, null), m.class, "com.obric.aiagent.plugin"));
    }

    private final int sizeSnapshot() {
        Object r1 = lock;
        monitor-enter(r1);
        int r0 = eventIdToContext.size();     // Catch: Throwable -> L7
        monitor-exit(r1);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    private final void trimToMaxEntriesLocked() {
        int r2 = maxEntries();
        Iterator<Map.Entry<Integer, Context>> r0 = eventIdToContext.entrySet().iterator();
    L4:
        if (eventIdToContext.size() <= r2) goto L8;
        if (r0.hasNext() == false) goto L11;
        r0.next();
        r0.remove();
        goto L4
    L11:
        return;
    }

    private final int maxEntries() {
        return com.obric.autogui.common.a.h.f28984a.c();
    }

    private final long clearDelayMillis() {
        return com.obric.autogui.common.a.h.f28984a.d();
    }
}
