package com.obric.aiagent.skill.manager.impl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import com.obric.aiagent.assistant.idl.IAgentSkillManagerIDLSPI;
import com.obric.aiagent.assistant.idl.IAgentSkillManagerObserverIDL;
import com.obric.aiagent.assistant.idl.bean.OSkill;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SkillManagerIDLSPIImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SkillManagerIDLSPIImpl implements IAgentSkillManagerIDLSPI {
    private static final a Companion = null;
    private static final int FIELD_SEPARATOR_CODE = 31;
    private static final int LOG_SKILL_LIMIT = 20;
    private static final long SKILL_LIST_VERSION_MULTIPLIER = 31;
    private static final long SKILL_LIST_VERSION_SEED = 1125899906842597L;
    private static final int SKILL_SEPARATOR_CODE = 29;
    private final RemoteCallbackList<IAgentSkillManagerObserverIDL> observerList;
    private final kotlinx.coroutines.am observerScope;
    private final AtomicBoolean observerStarted;
    private final AtomicLong skillListVersion;

    /* JADX INFO: compiled from: SkillManagerIDLSPIImpl.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillManagerIDLSPIImpl.kt */
    @d.c.b.a.f(b = "SkillManagerIDLSPIImpl.kt", c = {125}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillManagerIDLSPIImpl$ensureSkillObserverStarted$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> f19412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SkillManagerIDLSPIImpl f19413c;

        c(kotlinx.coroutines.b.ak<? extends List<com.obric.aiagent.skill.manager.api.e>> r3, SkillManagerIDLSPIImpl r4, d.c.d<? super c> r5) {
            kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> r6 = (kotlinx.coroutines.b.ak) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.ak.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19412b = r6;
            this.f19413c = r4;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f19412b, this.f19413c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f19411a;
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L6;
            d.o.a(r11);     // Catch: Exception -> L9 CancellationException -> L11
        L18:
            throw new d.d();     // Catch: Exception -> L9 CancellationException -> L11
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            d.o.a(r11);
            kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> r12 = this.f19412b;     // Catch: Exception -> L9 CancellationException -> L11
            final SkillManagerIDLSPIImpl r4 = this.f19413c;     // Catch: Exception -> L9 CancellationException -> L11
            kotlinx.coroutines.b.i<? super List<com.obric.aiagent.skill.manager.api.e>> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9 CancellationException -> L11
            d.c.d<?> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9 CancellationException -> L11
            this.f19411a = 1;     // Catch: Exception -> L9 CancellationException -> L11
            if (r12.collect(r2, r5) != r0) goto L18;
            return r0;
        L11:
            e = move-exception;
            throw e;
        L9:
            e = move-exception;
            SkillManagerIDLSPIImpl.access$getObserverStarted$p(this.f19413c).set(false);
            SkillManagerIDLSPIImpl.logFailure$default(this.f19413c, "observe skill list failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), null, 4, null);
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(az.d((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(az.d((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class e<T> implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$jgU-RSejiXYzYAfaW5SZTNotY0A, reason: not valid java name */
    public static /* synthetic */ CharSequence m269lambda$jgURSejiXYzYAfaW5SZTNotY0A(com.obric.aiagent.skill.manager.api.e r0) {
        return toLogSummary$lambda$13(r0);
    }

    public SkillManagerIDLSPIImpl() {
        this.observerList = new RemoteCallbackList();
        this.observerScope = kotlinx.coroutines.an.a(kotlinx.coroutines.cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
        this.observerStarted = new AtomicBoolean(false);
        this.skillListVersion = new AtomicLong(0);
    }

    public static final /* synthetic */ long access$computeSkillListVersion(SkillManagerIDLSPIImpl r2, List r3, boolean r4) {
        return r2.computeSkillListVersion((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ AtomicBoolean access$getObserverStarted$p(SkillManagerIDLSPIImpl r0) {
        return r0.observerStarted;
    }

    public static final /* synthetic */ AtomicLong access$getSkillListVersion$p(SkillManagerIDLSPIImpl r0) {
        return r0.skillListVersion;
    }

    public static final /* synthetic */ void access$notifySkillListChanged(SkillManagerIDLSPIImpl r0, long r1) {
        r0.notifySkillListChanged(r1);
    }

    public static final /* synthetic */ String access$toLogSummary(SkillManagerIDLSPIImpl r2, List r3) {
        return r2.toLogSummary((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return IAgentSkillManagerIDLSPI.b.a(this);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public List<OSkill> listSkills() {
        List r1 = d.a.p.b();
        List<com.obric.aiagent.skill.manager.api.e> r2 = installedSkillsOrNull();     // Catch: Exception -> L12
        if (r2 != null) goto L6;
        r1 = d.a.p.b();     // Catch: Exception -> L12
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L6:
        com.obric.aiagent.skill.manager.api.al r3 = com.obric.aiagent.skill.manager.api.al.f19195a.a();     // Catch: Exception -> L12
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(bs.f19588a.a(r2, r3), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r4, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        Iterator r6 = r4.iterator();     // Catch: Exception -> L12
    L8:
        if (r6.hasNext() == false) goto L11;
        r5.add(toOSkill((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"), r3.w()));     // Catch: Exception -> L12
        goto L8
    L11:
        r1 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        logFailure("Skill manager IPC operation failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "listSkills failed");
        goto L15
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public long getSkillListVersion() {
        long r0 = this.skillListVersion.get();
        ensureSkillObserverStarted();     // Catch: Exception -> L5
        return currentSkillListVersion();
    L5:
        e = move-exception;
        logFailure("Skill manager IPC operation failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "getSkillListVersion failed");
        return r0;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public void registerSkillObserver(IAgentSkillManagerObserverIDL r8) {
        IAgentSkillManagerObserverIDL r9 = (IAgentSkillManagerObserverIDL) ZeusTransformUtils.wrapperContextForParams(r8, IAgentSkillManagerObserverIDL.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L6;
        ILogDepend.Companion.w("SkillManager", "registerSkillObserver ignored null observer");
        return;
    L6:
        d.x r2 = d.x.f38692a;
        ensureSkillObserverStarted();     // Catch: Exception -> L13
        this.observerList.register((IInterface) ZeusTransformUtils.preCheckCast(r9, IInterface.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L13
        long r3 = currentSkillListVersion();     // Catch: Exception -> L13
        if (IAppContext.Companion.isDebug() == false) goto L10;
        ILogDepend.Companion.i("SkillManager", "registerSkillObserver success, version=" + r3);     // Catch: Exception -> L13
    L11:
        r9.onSkillListChanged(r3);     // Catch: Exception -> L13
        d.x r7 = d.x.f38692a;     // Catch: Exception -> L13
        return;
    L10:
        ILogDepend.Companion.i("SkillManager", "registerSkillObserver success");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        logFailure("Skill manager IPC operation failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "registerSkillObserver failed");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public OSkillManagerConfig getSkillManagerConfig() {
        OSkillManagerConfig r1 = new OSkillManagerConfig(null, 1, null);
        r1 = cw.f19708a.a();     // Catch: Exception -> L5
    L8:
        return (OSkillManagerConfig) ZeusTransformUtils.preCheckCast(r1, OSkillManagerConfig.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        logFailure("Skill manager IPC operation failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "getSkillManagerConfig failed");
        goto L8
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public boolean setSkillManagerConfigValues(Bundle r4) {
        if (r4 != null) goto L11;
        ILogDepend.Companion.w("SkillManager", "setSkillManagerConfigValues ignored null values");
        return false;
    L11:
        return cw.f19708a.a(r4);
    L8:
        e = move-exception;
        logFailure("Skill manager IPC operation failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "setSkillManagerConfigValues failed");
        return false;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
    public String getSkillManagerStatus(String r5) {
        String r0 = "";
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L9;
        ILogDepend.Companion.w("SkillManager", "getSkillManagerStatus ignored blank key");
        return "";
    L9:
        String r1 = "getSkillManagerStatus failed, key=" + r6;
        r0 = br.f19586a.a(r6);     // Catch: Exception -> L12
    L15:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    L12:
        e = move-exception;
        logFailure("Skill manager IPC operation failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), r1);
        goto L15
    }

    private final void ensureSkillObserverStarted() {
        ISkillManagerService r0 = ISkillManagerService.Companion.a();
        if (r0 != null) goto L6;
        ILogDepend.Companion.w("SkillManager", "observe skill list skipped: manager unavailable");
        return;
    L6:
        com.obric.aiagent.skill.manager.api.u<kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>>> r1 = r0.observeInstalledSkills();
        if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L14;
        kotlinx.coroutines.b.ak r2 = (kotlinx.coroutines.b.ak) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), kotlinx.coroutines.b.ak.class, "com.obric.aiagent.plugin");
        if (this.observerStarted.compareAndSet(false, true) == true) goto L11;
        return;
    L11:
        kotlinx.coroutines.i.a(this.observerScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r2, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L14:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L18;
        ILogDepend.Companion.w("SkillManager", "observe skill list skipped: manager initialization failed, code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());
        return;
    L18:
        throw new d.k();
    }

    private final long currentSkillListVersion() {
        List<com.obric.aiagent.skill.manager.api.e> r0 = installedSkillsOrNull();
        if (r0 != null) goto L5;
        r0 = d.a.p.b();
    L5:
        com.obric.aiagent.skill.manager.api.al r1 = com.obric.aiagent.skill.manager.api.al.f19195a.a();
        return computeSkillListVersion(bs.f19588a.a(r0, r1), r1.w());
    }

    private final void notifySkillListChanged(long r8) {
        int r1 = this.observerList.beginBroadcast();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        ((IAgentSkillManagerObserverIDL) ZeusTransformUtils.preCheckCast(this.observerList.getBroadcastItem(r2), IAgentSkillManagerObserverIDL.class, "com.obric.aiagent.plugin")).onSkillListChanged(r8);     // Catch: Exception -> L6 Throwable -> L16
    L8:
        r2 = r2 + 1;     // Catch: Throwable -> L16
    L6:
        e = move-exception;
        logFailure("notifySkillListChanged failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), "notifySkillListChanged failed, index=" + r2 + ", version=" + r8);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.observerList.finishBroadcast();
        throw th;
    L11:
        if (IAppContext.Companion.isDebug() == false) goto L13;
        ILogDepend.Companion.i("SkillManager", "notifySkillListChanged finish, version=" + r8 + ", observerCount=" + r1);     // Catch: Throwable -> L16
    L14:
        this.observerList.finishBroadcast();
        return;
    L13:
        ILogDepend.Companion.i("SkillManager", "notifySkillListChanged finish observerCount=" + r1);     // Catch: Throwable -> L16
        goto L14
    }

    private final List<com.obric.aiagent.skill.manager.api.e> installedSkillsOrNull() {
        ISkillManagerService r5 = ISkillManagerService.Companion.a();
        if (r5 != null) goto L5;
        return null;
    L5:
        com.obric.aiagent.skill.manager.api.u<List<com.obric.aiagent.skill.manager.api.e>> r6 = r5.getInstalledSkills();
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L9;
        return (List) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), List.class, "com.obric.aiagent.plugin");
    L9:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L13;
        ILogDepend.Companion.w("SkillManager", "read skill list skipped: manager initialization failed, code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());
        return null;
    L13:
        throw new d.k();
    }

    private final <T> T idlBoundary(T r3, String r4, d.h.a.a<? extends T> r5) {
        return (T) ((d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
    L5:
        e = move-exception;
        logFailure("Skill manager IPC operation failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), r4);
        return r3;
    }

    static /* synthetic */ void logFailure$default(SkillManagerIDLSPIImpl r0, String r1, Throwable r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = r1;
    L5:
        r0.logFailure(r1, r2, r3);
    }

    private final void logFailure(String r2, Throwable r3, String r4) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e("SkillManager", r4, r3);
        return;
    L5:
        ILogDepend.Companion.e("SkillManager", r2);
    }

    private final long computeSkillListVersion(List<com.obric.aiagent.skill.manager.api.e> r11, boolean r12) {
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r2 = SKILL_LIST_VERSION_SEED;
    L4:
        if (r13.hasNext() == false) goto L14;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(stableVersionFields(toOSkill((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"), r12)), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin");
        int r7 = 0;
    L10:
        if (r7 >= r4.length()) goto L12;
        char r8 = r4.charAt(r7);
        r2 = (r2 * SKILL_LIST_VERSION_MULTIPLIER) + ((long) r8);
        r7 = r7 + 1;
        goto L10
    L12:
        r2 = (r2 * SKILL_LIST_VERSION_MULTIPLIER) + ((long) 31);
        goto L7
    L13:
        r2 = (r2 * SKILL_LIST_VERSION_MULTIPLIER) + ((long) 29);
        goto L4
    L14:
        return r2;
    }

    private final String toLogSummary(List<com.obric.aiagent.skill.manager.api.e> r10) {
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new e(), Comparator.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 20, null, $$Lambda$SkillManagerIDLSPIImpl$jgURSejiXYzYAfaW5SZTNotY0A.INSTANCE, 23, null);
    }

    private static final CharSequence toLogSummary$lambda$13(com.obric.aiagent.skill.manager.api.e r2) {
        d.h.b.o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast("slug=" + r2.a() + ",displayName=" + r2.b() + ",enabled=" + r2.l(), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final OSkill toOSkill(com.obric.aiagent.skill.manager.api.e r10, boolean r11) {
        return new OSkill(r10.a(), r10.b(), r10.f(), r10.l(), ZeusTransformUtils.instanceOf(com.obric.aiagent.skill.manager.api.g.f19256a.a(r10, r11), com.obric.aiagent.skill.manager.api.f.a.class), r10.n(), r10.o(), r10.p());
    }

    private final List<String> stableVersionFields(OSkill r5) {
        String[] r4 = new String[8];
        r4[0] = r5.getSlug();
        r4[1] = r5.getDisplayName();
        r4[2] = r5.getCoverUrl();
        r4[3] = String.valueOf(r5.getEnabled());
        r4[4] = String.valueOf(r5.getAvailable());
        Long r0 = r5.getCreatedAt();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.toString();
    L6:
        String r3 = "";
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        r4[5] = r2;
        Long r6 = r5.getLastUsedAt();
        if (r6 == null) goto L12;
        String r7 = r6.toString();
    L13:
        if (r7 != null) goto L15;
        r7 = "";
    L15:
        r4[6] = r7;
        Long r8 = r5.getLastUpdatedAt();
        if (r8 == null) goto L18;
        r1 = r8.toString();
    L18:
        if (r1 == null) goto L21;
        r3 = r1;
    L21:
        r4[7] = r3;
        return d.a.p.b(r4);
    L12:
        r7 = null;
        goto L13
    L5:
        r2 = null;
        goto L6
    }
}
