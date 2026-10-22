package com.obric.aiagent.executionengine.capabilitymanager.matcher;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.executionengine.capabilitymanager.matcher.a.d;
import com.obric.aiagent.executionengine.capabilitymanager.matcher.bean.ActionData;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autogui.common.api.app.foundation.AutoActionFoundation;
import com.obric.capabilitykit.common.intent.MatchException;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.aa;
import d.n;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: CapabilityManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "CapabilityManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16453a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList<com.obric.aiagent.executionengine.capabilitymanager.matcher.b> f16454b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f16455c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final am f16456d = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.capabilitymanager.matcher.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CapabilityManager.kt */
    @f(b = "CapabilityManager.kt", c = {160}, d = "buildIndex", e = "com.obric.aiagent.executionengine.capabilitymanager.matcher.CapabilityManager")
    static final class C0333a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f16459c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f16460d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f16461e;
        int f;

        C0333a(a r3, d.c.d<? super C0333a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16461e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16460d = r3;
            this.f |= Integer.MIN_VALUE;
            return a.a(this.f16461e, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CapabilityManager.kt */
    @f(b = "CapabilityManager.kt", c = {149, 152, 153}, d = "queryExecutableIntent", e = "com.obric.aiagent.executionengine.capabilitymanager.matcher.CapabilityManager")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f16464c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f16465d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f16466e;
        int f;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16466e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16465d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f16466e.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CapabilityManager.kt */
    @f(b = "CapabilityManager.kt", c = {100}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.capabilitymanager.matcher.CapabilityManager$registerKDocSourceWhenSettingsReady$1$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f16467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f16468b;

        c(d.c.d<? super c> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16468b;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            long r2 = this.f16467a;
            o.a(r8);
        L12:
            ILogDepend.Companion.i(a.TAG, "register_wait_end waitMs=" + (SystemClock.elapsedRealtime() - r2));
            a.f16453a.a((com.obric.aiagent.executionengine.capabilitymanager.matcher.b) ZeusTransformUtils.preCheckCast(d.f16488a, com.obric.aiagent.executionengine.capabilitymanager.matcher.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            long r5 = SystemClock.elapsedRealtime();
            ILogDepend.Companion.i(a.TAG, "register_wait_begin");
            AutoActionFoundation r9 = AutoActionFoundation.INSTANCE;
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16467a = r5;
            this.f16468b = 1;
            if (r9.suspendUntilReady(r3) != r0) goto L11;
            return r0;
        L11:
            r2 = r5;
            goto L12
        }
    }

    /* JADX INFO: compiled from: CapabilityManager.kt */
    public static final class d extends PluginBroadcastReceiver {
        d() {
        }

        public void onReceive(Context r3, Intent r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            ILogDepend.Companion r5 = ILogDepend.Companion;
            StringBuilder r6 = new StringBuilder().append("package changed: ");
            Uri r0 = null;
            if (r4 == null) goto L5;
            String r1 = r4.getAction();
        L6:
            StringBuilder r7 = r6.append(r1).append(' ');
            if (r4 == null) goto L9;
            r0 = r4.getData();
        L9:
            r5.i(a.TAG, r7.append(r0).append(", refresh capabilities").toString());
            a.f16453a.a();
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: lambda$OfAFvpUUB93Rss32PuYcp8qCN-Y, reason: not valid java name */
    public static /* synthetic */ void m160lambda$OfAFvpUUB93Rss32PuYcp8qCNY(IFlowSettingsIDL r0) {
        a(r0);
    }

    private a() {
    }

    public static final /* synthetic */ Object a(a r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f16453a = new a();
        f16454b = new CopyOnWriteArrayList();
        f16455c = new AtomicBoolean(false);
        f16456d = an.a(cx.a(null, 1, null).plus((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")));
    }

    public final void a(com.obric.aiagent.executionengine.capabilitymanager.matcher.b r2) {
        com.obric.aiagent.executionengine.capabilitymanager.matcher.b r1 = (com.obric.aiagent.executionengine.capabilitymanager.matcher.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.executionengine.capabilitymanager.matcher.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, DBHelper.BATTERY_COL_SOURCE);
        if (f16454b.addIfAbsent(r1) == false) goto L6;
        r1.a();
        return;
    }

    public final void a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        if (f16455c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        a((com.obric.aiagent.executionengine.capabilitymanager.matcher.b) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.capabilitymanager.matcher.a.c.f16481a, com.obric.aiagent.executionengine.capabilitymanager.matcher.b.class, "com.obric.aiagent.plugin"));
        if (Build.VERSION.SDK_INT < 36) goto L8;
        b();
        a((com.obric.aiagent.executionengine.capabilitymanager.matcher.b) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.capabilitymanager.matcher.a.a.f16469a, com.obric.aiagent.executionengine.capabilitymanager.matcher.b.class, "com.obric.aiagent.plugin"));
        a((com.obric.aiagent.executionengine.capabilitymanager.matcher.b) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.capabilitymanager.matcher.a.b.f16475a, com.obric.aiagent.executionengine.capabilitymanager.matcher.b.class, "com.obric.aiagent.plugin"));
    L8:
        d.h.b.o.a(r7);
        b(r7);
        a();
        ILogDepend.Companion.i(TAG, "init done, sdk=" + Build.VERSION.SDK_INT);
    }

    private final void b() {
        at.a(aa.b(IFlowSettingsIDL.class), true, true, $$Lambda$a$OfAFvpUUB93Rss32PuYcp8qCNY.INSTANCE);
    }

    private static final void a(IFlowSettingsIDL r10) {
        d.h.b.o.e((IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r10, IFlowSettingsIDL.class, "com.obric.aiagent.plugin"), "it");
        boolean r11 = com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.a.f16409a.a().a();
        ILogDepend.Companion.d(TAG, "AppFunction settings ready, enableIndex=" + r11);
        if (r11 == false) goto L6;
        i.a(f16456d, null, null, (m) ZeusTransformUtils.preCheckCast(new c(null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }

    public final void a() {
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(f16454b, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.obric.aiagent.executionengine.capabilitymanager.matcher.b) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.aiagent.executionengine.capabilitymanager.matcher.b.class, "com.obric.aiagent.plugin")).b();
        goto L4
    }

    private final void b(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.PACKAGE_ADDED");
        r0.addAction("android.intent.action.PACKAGE_REPLACED");
        r0.addAction("android.intent.action.PACKAGE_REMOVED");
        r0.addDataScheme("package");
        d r2 = new d();
        n.a r3 = n.f38560a;     // Catch: Throwable -> L5
        a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r7 = n.f(ZeusTransformUtils.registerReceiver(r6, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r2, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r0, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
    L7:
        Throwable r8 = n.c(r7);
        if (r8 == null) goto L13;
        ILogDepend.Companion.e(TAG, "registerReceiver failed", r8);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r9 = n.f38560a;
        r7 = n.f(o.a(th));
        goto L7
    }

    public final Object a(ActionData r11, d.c.d<? super com.obric.aiagent.executionengine.capabilitymanager.api.matcher.a> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, b.class) == false) goto L7;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r13, b.class, "com.obric.aiagent.plugin");
        if ((r1.f & Integer.MIN_VALUE) == 0) goto L7;
        r1.f -= Integer.MIN_VALUE;
    L8:
        Object r14 = r1.f16465d;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f;
        if (r4 == 0) goto L21;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        com.obric.aiagent.executionengine.capabilitymanager.matcher.c r10 = (com.obric.aiagent.executionengine.capabilitymanager.matcher.c) ZeusTransformUtils.preCheckCast(r1.f16463b, com.obric.aiagent.executionengine.capabilitymanager.matcher.c.class, "com.obric.aiagent.plugin");
        r11 = (ActionData) ZeusTransformUtils.preCheckCast(r1.f16462a, ActionData.class, "com.obric.aiagent.plugin");
        o.a(r14);
    L48:
        return r10.a((Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.aiagent.plugin"), r11);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ActionData r15 = (ActionData) ZeusTransformUtils.preCheckCast(r1.f16463b, ActionData.class, "com.obric.aiagent.plugin");
        a r16 = (a) ZeusTransformUtils.preCheckCast(r1.f16462a, a.class, "com.obric.aiagent.plugin");
        o.a(r14);
    L42:
        a r9 = r16;
        r11 = r15;
        a this = r9;
    L43:
        com.obric.aiagent.executionengine.capabilitymanager.matcher.c r17 = com.obric.aiagent.executionengine.capabilitymanager.matcher.c.f16514a;
        r1.f16462a = r11;
        r1.f16463b = r17;
        r1.f16464c = null;
        r1.f = 3;
        Object r18 = this.a(r1);
        if (r18 != r3) goto L46;
        return r3;
    L46:
        r14 = r18;
        r10 = r17;
        goto L48
    L17:
        com.obric.aiagent.executionengine.capabilitymanager.matcher.c r19 = (com.obric.aiagent.executionengine.capabilitymanager.matcher.c) ZeusTransformUtils.preCheckCast(r1.f16464c, com.obric.aiagent.executionengine.capabilitymanager.matcher.c.class, "com.obric.aiagent.plugin");
        r11 = (ActionData) ZeusTransformUtils.preCheckCast(r1.f16463b, ActionData.class, "com.obric.aiagent.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(r1.f16462a, a.class, "com.obric.aiagent.plugin");
        o.a(r14);     // Catch: MatchException.NoImplException -> L20
    L28:
        return r19.a((Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.aiagent.plugin"), r11);
    L20:
        this = r0;
    L30:
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(f16454b, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r111 = r110.iterator();
    L32:
        if (r111.hasNext() == false) goto L36;
        Object r5 = r111.next();
        if (ZeusTransformUtils.instanceOf(r5, com.obric.aiagent.executionengine.capabilitymanager.matcher.a.c.class) == false) goto L32;
        r2.add(r5);
        goto L32
    L36:
        com.obric.aiagent.executionengine.capabilitymanager.matcher.a.c r112 = (com.obric.aiagent.executionengine.capabilitymanager.matcher.a.c) ZeusTransformUtils.preCheckCast(p.l((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin")), com.obric.aiagent.executionengine.capabilitymanager.matcher.a.c.class, "com.obric.aiagent.plugin");
        if (r112 == null) goto L43;
        r1.f16462a = this;
        r1.f16463b = r11;
        r1.f16464c = null;
        r1.f = 2;
        if (r112.b(r1) != r3) goto L41;
        return r3;
    L41:
        ActionData r20 = r11;
        r16 = this;
        r15 = r20;
        goto L42
    L21:
        o.a(r14);
        if (r11 != null) goto L50;
        return null;
    L50:
        com.obric.aiagent.executionengine.capabilitymanager.matcher.c r113 = com.obric.aiagent.executionengine.capabilitymanager.matcher.c.f16514a;     // Catch: MatchException.NoImplException -> L49
        r1.f16462a = this;     // Catch: MatchException.NoImplException -> L49
        r1.f16463b = r11;     // Catch: MatchException.NoImplException -> L49
        r1.f16464c = r113;     // Catch: MatchException.NoImplException -> L49
        r1.f = 1;     // Catch: MatchException.NoImplException -> L49
        Object r6 = a(r1);     // Catch: MatchException.NoImplException -> L49
        if (r6 != r3) goto L27;
        return r3;
    L27:
        r0 = this;
        r19 = r113;
        r14 = r6;
    L7:
        r1 = new b(this, r13);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x009c -> B:21:0x009d). Please report as a decompilation issue!!! */
    private final Object a(d.c.d<? super Map<String, ? extends List<com.obric.aiagent.executionengine.capabilitymanager.api.a.b>>> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, C0333a.class) == false) goto L7;
        C0333a r0 = (C0333a) ZeusTransformUtils.preCheckCast(r9, C0333a.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f16460d;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ArrayList r3 = (ArrayList) ZeusTransformUtils.preCheckCast(r0.f16459c, ArrayList.class, "com.obric.aiagent.plugin");
        Iterator r4 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f16458b, Iterator.class, "com.obric.aiagent.plugin");
        ArrayList r5 = (ArrayList) ZeusTransformUtils.preCheckCast(r0.f16457a, ArrayList.class, "com.obric.aiagent.plugin");
        o.a(r7);
    L21:
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin"));
        r3 = r5;
    L16:
        if (r4.hasNext() == false) goto L22;
        com.obric.aiagent.executionengine.capabilitymanager.matcher.b r11 = (com.obric.aiagent.executionengine.capabilitymanager.matcher.b) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.aiagent.executionengine.capabilitymanager.matcher.b.class, "com.obric.aiagent.plugin");
        r0.f16457a = r3;
        r0.f16458b = r4;
        r0.f16459c = r3;
        r0.f = 1;
        r7 = r11.a(r0);
        if (r7 != r10) goto L20;
        return r10;
    L20:
        r5 = r3;
        goto L21
    L22:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
        Map r13 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r14 = r12.iterator();
    L24:
        if (r14.hasNext() == false) goto L29;
        Object r1 = r14.next();
        String r6 = ((com.obric.aiagent.executionengine.capabilitymanager.api.a.b) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.executionengine.capabilitymanager.api.a.b.class, "com.obric.aiagent.plugin")).a();
        Object r15 = r13.get(r6);
        if (r15 != null) goto L28;
        r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r13.put(r6, r15);
    L28:
        ((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin")).add(r1);
        goto L24
    L29:
        return r13;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r7);
        ArrayList r16 = new ArrayList();
        r4 = ((Iterable) ZeusTransformUtils.preCheckCast(f16454b, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        r3 = r16;
    L7:
        r0 = new C0333a(this, r9);
        goto L8
    }
}
