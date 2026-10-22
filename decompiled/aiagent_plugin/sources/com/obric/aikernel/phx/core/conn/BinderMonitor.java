package com.obric.aikernel.phx.core.conn;

import android.os.IBinder;
import com.obric.aikernel.AIKBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.g;
import d.h.a.a;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.an;
import kotlinx.coroutines.b.am;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: BinderMonitor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BinderMonitor {
    public static final BinderMonitor INSTANCE = null;
    private static final String TAG = "BinderMonitor";
    private static final ConcurrentHashMap<Integer, BinderInfo> binderWatcher = null;

    /* JADX INFO: compiled from: BinderMonitor.kt */
    public static final class BinderInfo {
        private final IBinder binder;
        private final IBinder.DeathRecipient recipient;
        private final x<Boolean> stateFlow;

        public static /* synthetic */ BinderInfo copy$default(BinderInfo r1, IBinder r2, x r3, IBinder.DeathRecipient r4, int r5, Object r6) {
            IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
            x<Boolean> r8 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.aiagent.plugin");
            IBinder.DeathRecipient r9 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");
            if ((r5 & 1) == 0) goto L6;
            r7 = r1.binder;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r8 = r1.stateFlow;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r9 = r1.recipient;
        L12:
            return r1.copy(r7, r8, r9);
        }

        public final IBinder component1() {
            return this.binder;
        }

        public final x<Boolean> component2() {
            return this.stateFlow;
        }

        public final IBinder.DeathRecipient component3() {
            return this.recipient;
        }

        public final BinderInfo copy(IBinder r2, x<Boolean> r3, IBinder.DeathRecipient r4) {
            IBinder r1 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
            x r5 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.aiagent.plugin");
            IBinder.DeathRecipient r6 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");
            o.e(r1, "binder");
            o.e(r5, "stateFlow");
            o.e(r6, "recipient");
            return new BinderInfo(r1, r5, r6);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, BinderInfo.class) == true) goto L8;
            return false;
        L8:
            BinderInfo r6 = (BinderInfo) ZeusTransformUtils.preCheckCast(r5, BinderInfo.class, "com.obric.aiagent.plugin");
            if (o.a(this.binder, r6.binder) == true) goto L12;
            return false;
        L12:
            if (o.a(this.stateFlow, r6.stateFlow) == true) goto L15;
            return false;
        L15:
            if (o.a(this.recipient, r6.recipient) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.binder.hashCode() * 31) + this.stateFlow.hashCode()) * 31) + this.recipient.hashCode();
        }

        public String toString() {
            return "BinderInfo(binder=" + this.binder + ", stateFlow=" + this.stateFlow + ", recipient=" + this.recipient + ')';
        }

        public BinderInfo(IBinder r3, x<Boolean> r4, IBinder.DeathRecipient r5) {
            IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            x<Boolean> r7 = (x) ZeusTransformUtils.wrapperContextForParams(r4, x.class, "com.obric.aiagent.plugin");
            IBinder.DeathRecipient r8 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");
            o.e(r6, "binder");
            o.e(r7, "stateFlow");
            o.e(r8, "recipient");
            this.binder = r6;
            this.stateFlow = r7;
            this.recipient = r8;
        }

        public final IBinder getBinder() {
            return this.binder;
        }

        public /* synthetic */ BinderInfo(IBinder r2, x r3, IBinder.DeathRecipient r4, int r5, h r6) {
            final IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
            final x r8 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.aiagent.plugin");
            IBinder.DeathRecipient r9 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");
            if ((r5 & 2) == 0) goto L6;
            r8 = am.a(true);
        L6:
            if ((r5 & 4) == 0) goto L8;
            r9 = (IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7, r8), IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");
        L8:
            this(r7, r8, r9);
        }

        public final x<Boolean> getStateFlow() {
            return this.stateFlow;
        }

        public final IBinder.DeathRecipient getRecipient() {
            return this.recipient;
        }
    }

    private BinderMonitor() {
    }

    public static final /* synthetic */ ConcurrentHashMap access$getBinderWatcher$p() {
        return binderWatcher;
    }

    static {
        INSTANCE = new BinderMonitor();
        binderWatcher = new ConcurrentHashMap();
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [T, com.obric.aikernel.phx.core.conn.BinderMonitor$BinderInfo, java.lang.Object] */
    public final ca monitorTransact(g r11, AIKBinder r12, a<d.x> r13) {
        g r14 = (g) ZeusTransformUtils.wrapperContextForParams(r11, g.class, "com.obric.aiagent.plugin");
        AIKBinder r15 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r12, AIKBinder.class, "com.obric.aiagent.plugin");
        a r16 = (a) ZeusTransformUtils.wrapperContextForParams(r13, a.class, "com.obric.aiagent.plugin");
        o.e(r14, "ctx");
        o.e(r15, "binder");
        o.e(r16, "onDied");
        IBinder r17 = r15.asBinder();
        int r0 = r17.hashCode();
        z.f r7 = new z.f();
        ConcurrentHashMap<Integer, BinderInfo> r8 = binderWatcher;
        r7.f38504a = r8.get(Integer.valueOf(r0));
        if (r7.f38504a != 0) goto L17;
        monitor-enter(this);
        r7.f38504a = r8.get(Integer.valueOf(r0));     // Catch: Throwable -> L13
        if (r17.isBinderAlive() == true) goto L8;
    L10:
        d.x r18 = d.x.f38692a;     // Catch: Throwable -> L13
        monitor-exit(this);
        goto L17
    L8:
        if (r7.f38504a != 0) goto L10;
        o.c(r17, "bd");     // Catch: Throwable -> L13
        ?? r9 = new BinderInfo(r17, null, null, 6, null);     // Catch: Throwable -> L13
        Integer r1 = Integer.valueOf(r0);     // Catch: Throwable -> L13
        ((Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.aiagent.plugin")).put(r1, r9);     // Catch: Throwable -> L13
        r17.linkToDeath(r9.getRecipient(), 0);     // Catch: Throwable -> L13
        r7.f38504a = r9;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        return i.a(an.a(r14), null, null, (m) ZeusTransformUtils.preCheckCast(new BinderMonitor$monitorTransact$job$1(r7, r14, r16, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
