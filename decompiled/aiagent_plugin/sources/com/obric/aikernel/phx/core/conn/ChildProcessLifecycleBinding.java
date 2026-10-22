package com.obric.aikernel.phx.core.conn;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.core.a;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.br;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: ChildProcessLifecycleBinding.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ChildProcessLifecycleBinding {
    private static final long DEFAULT_RELEASE_DELAY_MS = 300000;
    public static final String INFER_LIFECYCLE_SERVICE = "com.obric.aikernel.InferLifeCycleService";
    public static final ChildProcessLifecycleBinding INSTANCE = null;
    public static final String LLM_LIFECYCLE_SERVICE = "com.obric.aikernel.LLMLifeCycleService";
    private static final String TAG = "ChildLifecycleBinding";
    private static final ConcurrentHashMap<String, BindingRecord> activeBindings = null;
    private static final ConcurrentHashMap<String, PendingBinding> pendingBindings = null;
    private static long releaseDelayMsForTest;
    private static final am releaseScope = null;

    /* JADX INFO: compiled from: ChildProcessLifecycleBinding.kt */
    private static final class BindingRecord {
        private int activeCount;
        private final Context appContext;
        private final ServiceConnection connection;
        private ca releaseJob;

        public static /* synthetic */ BindingRecord copy$default(BindingRecord r1, Context r2, ServiceConnection r3, int r4, ca r5, int r6, Object r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            ServiceConnection r9 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.aiagent.plugin");
            ca r10 = (ca) ZeusTransformUtils.wrapperContextForParams(r5, ca.class, "com.obric.aiagent.plugin");
            if ((r6 & 1) == 0) goto L6;
            r8 = r1.appContext;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r9 = r1.connection;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = r1.activeCount;
        L12:
            if ((r6 & 8) == 0) goto L15;
            r10 = r1.releaseJob;
        L15:
            return r1.copy(r8, r9, r4, r10);
        }

        public final Context component1() {
            return this.appContext;
        }

        public final ServiceConnection component2() {
            return this.connection;
        }

        public final int component3() {
            return this.activeCount;
        }

        public final ca component4() {
            return this.releaseJob;
        }

        public final BindingRecord copy(Context r2, ServiceConnection r3, int r4, ca r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            ServiceConnection r6 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.aiagent.plugin");
            ca r7 = (ca) ZeusTransformUtils.wrapperContextForParams(r5, ca.class, "com.obric.aiagent.plugin");
            o.e(r1, "appContext");
            o.e(r6, WsConstants.KEY_CONNECTION);
            return new BindingRecord(r1, r6, r4, r7);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, BindingRecord.class) == true) goto L8;
            return false;
        L8:
            BindingRecord r6 = (BindingRecord) ZeusTransformUtils.preCheckCast(r5, BindingRecord.class, "com.obric.aiagent.plugin");
            if (o.a(this.appContext, r6.appContext) == true) goto L12;
            return false;
        L12:
            if (o.a(this.connection, r6.connection) == true) goto L15;
            return false;
        L15:
            if (this.activeCount == r6.activeCount) goto L18;
            return false;
        L18:
            if (o.a(this.releaseJob, r6.releaseJob) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.appContext.hashCode() * 31) + this.connection.hashCode()) * 31) + Integer.hashCode(this.activeCount)) * 31;
            ca r2 = this.releaseJob;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "BindingRecord(appContext=" + this.appContext + ", connection=" + this.connection + ", activeCount=" + this.activeCount + ", releaseJob=" + this.releaseJob + ')';
        }

        public BindingRecord(Context r3, ServiceConnection r4, int r5, ca r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            ServiceConnection r8 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.aiagent.plugin");
            ca r9 = (ca) ZeusTransformUtils.wrapperContextForParams(r6, ca.class, "com.obric.aiagent.plugin");
            o.e(r7, "appContext");
            o.e(r8, WsConstants.KEY_CONNECTION);
            this.appContext = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            this.connection = r8;
            this.activeCount = r5;
            this.releaseJob = r9;
        }

        public /* synthetic */ BindingRecord(Context r2, ServiceConnection r3, int r4, ca r5, int r6, h r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            ServiceConnection r9 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.aiagent.plugin");
            ca r10 = (ca) ZeusTransformUtils.wrapperContextForParams(r5, ca.class, "com.obric.aiagent.plugin");
            if ((r6 & 8) == 0) goto L5;
            r10 = null;
        L5:
            this(r8, r9, r4, r10);
        }

        public final Context getAppContext() {
            return this.appContext;
        }

        public final ServiceConnection getConnection() {
            return this.connection;
        }

        public final int getActiveCount() {
            return this.activeCount;
        }

        public final void setActiveCount(int r1) {
            this.activeCount = r1;
        }

        public final ca getReleaseJob() {
            return this.releaseJob;
        }

        public final void setReleaseJob(ca r3) {
            this.releaseJob = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ChildProcessLifecycleBinding.kt */
    private static final class LifecycleLease implements ProcessLifecycleHandle {
        private final String bindingKey;
        private final AtomicBoolean closed;

        public LifecycleLease(String r2) {
            o.e(r2, "bindingKey");
            this.bindingKey = r2;
            this.closed = new AtomicBoolean(false);
        }

        @Override // com.obric.aikernel.phx.core.conn.ProcessLifecycleHandle
        public void close() {
            if (this.closed.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            ChildProcessLifecycleBinding.access$release(ChildProcessLifecycleBinding.INSTANCE, this.bindingKey);
        }
    }

    /* JADX INFO: compiled from: ChildProcessLifecycleBinding.kt */
    private static final class PendingBinding {
        private boolean cleared;
        private final ServiceConnection connection;

        public PendingBinding(ServiceConnection r3) {
            ServiceConnection r4 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.aiagent.plugin");
            o.e(r4, WsConstants.KEY_CONNECTION);
            this.connection = r4;
        }

        public final ServiceConnection getConnection() {
            return this.connection;
        }

        public final boolean getCleared() {
            return this.cleared;
        }

        public final void setCleared(boolean r1) {
            this.cleared = r1;
        }
    }

    private ChildProcessLifecycleBinding() {
    }

    public static final /* synthetic */ void access$clearBinding(ChildProcessLifecycleBinding r2, String r3, ServiceConnection r4) {
        r2.clearBinding(r3, (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$release(ChildProcessLifecycleBinding r0, String r1) {
        r0.release(r1);
    }

    public static final /* synthetic */ void access$unbindIfIdle(ChildProcessLifecycleBinding r0, String r1) {
        r0.unbindIfIdle(r1);
    }

    static {
        INSTANCE = new ChildProcessLifecycleBinding();
        activeBindings = new ConcurrentHashMap();
        pendingBindings = new ConcurrentHashMap();
        releaseScope = an.a(bd.c().plus((g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), g.class, "com.obric.aiagent.plugin")));
        releaseDelayMsForTest = DEFAULT_RELEASE_DELAY_MS;
    }

    public final long getReleaseDelayMsForTest$sdk_release() {
        return releaseDelayMsForTest;
    }

    public final void setReleaseDelayMsForTest$sdk_release(long r1) {
        releaseDelayMsForTest = r1;
    }

    public static /* synthetic */ ProcessLifecycleHandle bind$default(ChildProcessLifecycleBinding r1, Context r2, String r3, String r4, boolean r5, int r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L11;
        AIKernelConfig r9 = a.f22349a.a();
        if (r9 != null) goto L7;
    L9:
        r5 = false;
        goto L11
    L7:
        if (r9.getChildProcessImportantBindEnabled() != true) goto L9;
        r5 = true;
    L11:
        return r1.bind(r8, r3, r4, r5);
    }

    public final ProcessLifecycleHandle bind(Context r12, String r13, String r14, boolean r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        o.e(r13, "servicePackage");
        if (r15 == true) goto L7;
        AIKLog.INSTANCE.d(TAG, "skip child lifecycle important bind by config, process=" + r14);
        return (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(NoOpProcessLifecycleHandle.INSTANCE, ProcessLifecycleHandle.class, "com.obric.aiagent.plugin");
    L7:
        if (r16 == null) goto L9;
        Context r17 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r16.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L10:
        if (r17 == null) goto L12;
        ComponentName r0 = resolveComponent$sdk_release(r13, r14);
        if (r0 == null) goto L16;
        final String r18 = resolveBindingKey$sdk_release(r13, r14);
        if (r18 == null) goto L20;
        ServiceConnection r7 = new ChildProcessLifecycleBinding$bind$connection$1(r18);
        Intent r1 = new Intent();
        r1.setComponent(r0);
        monitor-enter(this);
        BindingRecord r2 = (BindingRecord) ZeusTransformUtils.preCheckCast(activeBindings.get(r18), BindingRecord.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
        boolean r8 = true;
        if (r2 == null) goto L31;
        r2.setActiveCount(r2.getActiveCount() + 1);     // Catch: Throwable -> L71
        ca r19 = r2.getReleaseJob();     // Catch: Throwable -> L71
        if (r19 == null) goto L28;
        ca.a.a(r19, null, 1, null);     // Catch: Throwable -> L71
    L28:
        r2.setReleaseJob(null);     // Catch: Throwable -> L71
        ProcessLifecycleHandle r110 = (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(new LifecycleLease(r18), ProcessLifecycleHandle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
        monitor-exit(this);
        return r110;
    L31:
        ConcurrentHashMap<String, PendingBinding> r111 = pendingBindings;     // Catch: Throwable -> L71
        if (r111.containsKey(r18) == false) goto L36;
        AIKLog.INSTANCE.d(TAG, "skip child lifecycle bind, pending process=" + r14);     // Catch: Throwable -> L71
        ProcessLifecycleHandle r112 = (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(NoOpProcessLifecycleHandle.INSTANCE, ProcessLifecycleHandle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L71
        monitor-exit(this);
        return r112;
    L36:
        PendingBinding r3 = new PendingBinding((ServiceConnection) ZeusTransformUtils.preCheckCast(r7, ServiceConnection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L71
        ((Map) ZeusTransformUtils.preCheckCast(r111, Map.class, "com.obric.aiagent.plugin")).put(r18, r3);     // Catch: Throwable -> L71
        monitor-exit(this);
        n.a r113 = n.f38560a;     // Catch: Throwable -> L40
        ChildProcessLifecycleBinding r114 = (ChildProcessLifecycleBinding) ZeusTransformUtils.preCheckCast(this, ChildProcessLifecycleBinding.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        Object r115 = n.f(Boolean.valueOf(ProcessPriorityBindingKt.bindForChildProcessPriority(r17, r1, br.a(bd.c()), (ServiceConnection) ZeusTransformUtils.preCheckCast(r7, ServiceConnection.class, "com.obric.aiagent.plugin"))));     // Catch: Throwable -> L40
    L42:
        Throwable r4 = n.c(r115);
        if (r4 == null) goto L46;
        AIKLog.INSTANCE.w(TAG, "bind child lifecycle service failed, process=" + r14 + ' ' + r4);
    L46:
        if (n.b(r115) == false) goto L48;
        r115 = false;
    L48:
        boolean r116 = ((Boolean) ZeusTransformUtils.preCheckCast(r115, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        monitor-enter(this);
        ConcurrentHashMap<String, PendingBinding> r5 = pendingBindings;     // Catch: Throwable -> L68
        if (o.a(r5.get(r18), r3) == true) goto L53;
    L52:
        r8 = false;
    L59:
        monitor-exit(this);
        if (r8 == true) goto L67;
        if (r116 == true) goto L63;
        AIKLog.INSTANCE.i(TAG, "skip bind child lifecycle service, process=" + r14 + " result=false");
    L65:
        return (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(NoOpProcessLifecycleHandle.INSTANCE, ProcessLifecycleHandle.class, "com.obric.aiagent.plugin");
    L63:
        AIKLog.INSTANCE.i(TAG, "skip bind child lifecycle service, process=" + r14 + " connection cleared");
        unbindUnpublishedBinding(r17, (ServiceConnection) ZeusTransformUtils.preCheckCast(r7, ServiceConnection.class, "com.obric.aiagent.plugin"), r18);
        goto L65
    L67:
        return (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(new LifecycleLease(r18), ProcessLifecycleHandle.class, "com.obric.aiagent.plugin");
    L53:
        r5.remove(r18);     // Catch: Throwable -> L68
        if (r116 == false) goto L52;
        if (r3.getCleared() == true) goto L52;
        ((Map) ZeusTransformUtils.preCheckCast(activeBindings, Map.class, "com.obric.aiagent.plugin")).put(r18, new BindingRecord(r17, (ServiceConnection) ZeusTransformUtils.preCheckCast(r7, ServiceConnection.class, "com.obric.aiagent.plugin"), 1, null, 8, null));     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        throw th;
    L40:
        th = move-exception;
        n.a r6 = n.f38560a;
        r115 = n.f(d.o.a(th));
    L71:
        th = move-exception;
        throw th;
    L20:
        return (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(NoOpProcessLifecycleHandle.INSTANCE, ProcessLifecycleHandle.class, "com.obric.aiagent.plugin");
    L16:
        return (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(NoOpProcessLifecycleHandle.INSTANCE, ProcessLifecycleHandle.class, "com.obric.aiagent.plugin");
    L12:
        return (ProcessLifecycleHandle) ZeusTransformUtils.preCheckCast(NoOpProcessLifecycleHandle.INSTANCE, ProcessLifecycleHandle.class, "com.obric.aiagent.plugin");
    L9:
        r17 = null;
        goto L10
    }

    public final String resolveServiceClassName$sdk_release(String r5) {
        boolean r1 = true;
        if (r5 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        return INFER_LIFECYCLE_SERVICE;
    L10:
        if (r5 != null) goto L12;
    L14:
        r1 = false;
    L15:
        if (r1 == false) goto L19;
        return LLM_LIFECYCLE_SERVICE;
    L19:
        return null;
    L12:
        if (d.o.o.c(r5, ":llm", false, 2, null) != true) goto L14;
    L5:
        if (d.o.o.c(r5, ":infer", false, 2, null) != true) goto L7;
        r3 = true;
        goto L8
    }

    public final ComponentName resolveComponent$sdk_release(String r2, String r3) {
        o.e(r2, "servicePackage");
        String r1 = resolveServiceClassName$sdk_release(r3);
        if (r1 != null) goto L7;
        return null;
    L7:
        return new ComponentName(r2, r1);
    }

    public final String resolveBindingKey$sdk_release(String r2, String r3) {
        o.e(r2, "servicePackage");
        String r1 = resolveServiceClassName$sdk_release(r3);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r2 + '/' + r1;
    }

    public final void resetBindingsForTest$sdk_release() {
        monitor-enter(this);
        Collection<BindingRecord> r0 = activeBindings.values();     // Catch: Throwable -> L12
        o.c(r0, "activeBindings.values");     // Catch: Throwable -> L12
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L12
    L5:
        if (r1.hasNext() == false) goto L9;
        ca r2 = ((BindingRecord) ZeusTransformUtils.preCheckCast(r1.next(), BindingRecord.class, "com.obric.aiagent.plugin")).getReleaseJob();     // Catch: Throwable -> L12
        if (r2 == null) goto L5;
        ca.a.a(r2, null, 1, null);     // Catch: Throwable -> L12
        goto L5
    L9:
        activeBindings.clear();     // Catch: Throwable -> L12
        pendingBindings.clear();     // Catch: Throwable -> L12
        releaseDelayMsForTest = DEFAULT_RELEASE_DELAY_MS;     // Catch: Throwable -> L12
        x r3 = x.f38692a;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private final void clearBinding(String r7, ServiceConnection r8) {
        ServiceConnection r9 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r8, ServiceConnection.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
        PendingBinding r0 = (PendingBinding) ZeusTransformUtils.preCheckCast(pendingBindings.get(r7), PendingBinding.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r0 == null) goto L7;
        ServiceConnection r2 = r0.getConnection();     // Catch: Throwable -> L23
    L9:
        if (o.a(r2, r9) == false) goto L11;
        r0.setCleared(true);     // Catch: Throwable -> L23
    L11:
        ConcurrentHashMap<String, BindingRecord> r1 = activeBindings;     // Catch: Throwable -> L23
        BindingRecord r3 = (BindingRecord) ZeusTransformUtils.preCheckCast(r1.get(r7), BindingRecord.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r3 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        o.c(r3, "activeBindings[bindingKey] ?: return");     // Catch: Throwable -> L23
        if (o.a(r3.getConnection(), r9) == false) goto L20;
        r1.remove(r7);     // Catch: Throwable -> L23
        ca r10 = r3.getReleaseJob();     // Catch: Throwable -> L23
        if (r10 == null) goto L20;
        ca.a.a(r10, null, 1, null);     // Catch: Throwable -> L23
    L20:
        x r11 = x.f38692a;     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L7:
        r2 = null;
    L23:
        th = move-exception;
        throw th;
    }

    private final void release(String r8) {
        monitor-enter(this);
        BindingRecord r0 = (BindingRecord) ZeusTransformUtils.preCheckCast(activeBindings.get(r8), BindingRecord.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r0 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        o.c(r0, "activeBindings[bindingKey] ?: return");     // Catch: Throwable -> L19
        if (r0.getActiveCount() <= 0) goto L11;
        r0.setActiveCount(r0.getActiveCount() - 1);     // Catch: Throwable -> L19
    L11:
        if (r0.getActiveCount() != 0) goto L16;
        ca r1 = r0.getReleaseJob();     // Catch: Throwable -> L19
        if (r1 == null) goto L15;
        ca.a.a(r1, null, 1, null);     // Catch: Throwable -> L19
    L15:
        r0.setReleaseJob(i.a(releaseScope, null, null, (m) ZeusTransformUtils.preCheckCast(new ChildProcessLifecycleBinding$release$1$1(r8, null), m.class, "com.obric.aiagent.plugin"), 3, null));     // Catch: Throwable -> L19
    L16:
        x r9 = x.f38692a;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private final void unbindIfIdle(String r5) {
        monitor-enter(this);
        ConcurrentHashMap<String, BindingRecord> r0 = activeBindings;     // Catch: Throwable -> L21
        BindingRecord r1 = (BindingRecord) ZeusTransformUtils.preCheckCast(r0.get(r5), BindingRecord.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r1 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        o.c(r1, "activeBindings[bindingKey] ?: return");     // Catch: Throwable -> L21
        if (r1.getActiveCount() == 0) goto L11;
        monitor-exit(this);
        return;
    L11:
        r0.remove(r5);     // Catch: Throwable -> L21
        r1.setReleaseJob(null);     // Catch: Throwable -> L21
        monitor-exit(this);
        n.a r2 = n.f38560a;     // Catch: Throwable -> L15
        ChildProcessLifecycleBinding r4 = (ChildProcessLifecycleBinding) ZeusTransformUtils.preCheckCast(this, ChildProcessLifecycleBinding.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        ZeusTransformUtils.unbindService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r1.getConnection(), "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        Object r6 = n.f(x.f38692a);     // Catch: Throwable -> L15
    L17:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L28;
        AIKLog.INSTANCE.w(TAG, "unbind child lifecycle service failed, key=" + r5 + ' ' + r7);
        return;
    L28:
        return;
    L15:
        th = move-exception;
        n.a r3 = n.f38560a;
        r6 = n.f(d.o.a(th));
    L21:
        th = move-exception;
        throw th;
    }

    private final void unbindUnpublishedBinding(Context r3, ServiceConnection r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        ServiceConnection r7 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.aiagent.plugin");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        ChildProcessLifecycleBinding r2 = (ChildProcessLifecycleBinding) ZeusTransformUtils.preCheckCast(this, ChildProcessLifecycleBinding.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        ZeusTransformUtils.unbindService(r6, r7, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r8 = n.f(x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r9 = n.c(r8);
        if (r9 == null) goto L13;
        AIKLog.INSTANCE.w(TAG, "unbind unpublished child lifecycle service failed, key=" + r5 + ' ' + r9);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r10 = n.f38560a;
        r8 = n.f(d.o.a(th));
        goto L7
    }
}
