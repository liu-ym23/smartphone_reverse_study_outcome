package com.obric.aiagent.skill.credentials.impl.d;

import android.util.EventsUtils;
import com.obric.aiagent.skill.credentials.api.ISkillCredentialService;
import com.obric.aiagent.skill.credentials.api.h;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.l;
import d.n;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: TaskSessionCapability.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements ISkillCredentialService.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ISkillCredentialService.d f19045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlinx.coroutines.f.a f19046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedHashMap<String, com.obric.aiagent.skill.credentials.impl.d.c> f19047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile com.obric.aiagent.skill.credentials.impl.d.c f19048d;

    /* JADX INFO: compiled from: TaskSessionCapability.kt */
    @d.c.b.a.f(b = "TaskSessionCapability.kt", c = {127}, d = "endQuietly", e = "com.obric.aiagent.skill.credentials.impl.session.TaskSessionCapability")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19050b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f19051c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f19052d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f19053e;

        a(b r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19052d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19051c = r3;
            this.f19053e |= Integer.MIN_VALUE;
            return b.a(this.f19052d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.skill.credentials.impl.d.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TaskSessionCapability.kt */
    @d.c.b.a.f(b = "TaskSessionCapability.kt", c = {26}, d = "prepare-0E7RQCE", e = "com.obric.aiagent.skill.credentials.impl.session.TaskSessionCapability")
    static final class C0420b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f19055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f19056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f19057d;

        C0420b(b r3, d.c.d<? super C0420b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19056c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19055b = r3;
            this.f19057d |= Integer.MIN_VALUE;
            Object r2 = this.f19056c.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return n.g(r2);
        }
    }

    /* JADX INFO: compiled from: TaskSessionCapability.kt */
    @d.c.b.a.f(b = "TaskSessionCapability.kt", c = {158, 111, OCardListItem.DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP, 123}, d = "prepareSession", e = "com.obric.aiagent.skill.credentials.impl.session.TaskSessionCapability")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f19060c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f19061d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f19062e;
        int f;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19062e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19061d = r3;
            this.f |= Integer.MIN_VALUE;
            return b.a(this.f19062e, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskSessionCapability.kt */
    @d.c.b.a.f(b = "TaskSessionCapability.kt", c = {31}, d = "provideEnvironment-gIAlu-s", e = "com.obric.aiagent.skill.credentials.impl.session.TaskSessionCapability")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f19063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f19064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19065c;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19064b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19063a = r3;
            this.f19065c |= Integer.MIN_VALUE;
            Object r2 = this.f19064b.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return n.g(r2);
        }
    }

    /* JADX INFO: compiled from: TaskSessionCapability.kt */
    @d.c.b.a.f(b = "TaskSessionCapability.kt", c = {159, ITaskManager.Stub.TRANSACTION_removeEventTaskExecutionDetailRecordsBySessionId}, d = "invokeSuspend", e = "com.obric.aiagent.skill.credentials.impl.session.TaskSessionCapability$provideEnvironment$2")
    static final class e extends l implements d.h.a.b<d.c.d<? super Map<String, ? extends String>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f19068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f19069d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f19070e;
        final /* synthetic */ String f;
        final /* synthetic */ b g;

        e(String r3, b r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            this.g = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super Map<String, String>> r3) {
            return ((e) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f, this.g, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super Map<String, ? extends String>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f19070e;
            Map<String, String> r4 = null;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.f19068c, Iterator.class, "com.obric.aiagent.plugin");
            b r3 = (b) ZeusTransformUtils.preCheckCast(this.f19067b, b.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.skill.credentials.impl.d.c r6 = (com.obric.aiagent.skill.credentials.impl.d.c) ZeusTransformUtils.preCheckCast(this.f19066a, com.obric.aiagent.skill.credentials.impl.d.c.class, "com.obric.aiagent.plugin");
            o.a(r13);
        L38:
            if (r2.hasNext() == false) goto L42;
            com.obric.aiagent.skill.credentials.impl.d.c r14 = (com.obric.aiagent.skill.credentials.impl.d.c) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.aiagent.skill.credentials.impl.d.c.class, "com.obric.aiagent.plugin");
            this.f19066a = r6;
            this.f19067b = r3;
            this.f19068c = r2;
            this.f19069d = null;
            this.f19070e = 2;
            if (b.a(r3, r14, "replace task session", this) != r0) goto L38;
            return r0;
        L42:
            if (r6 == null) goto L46;
            com.obric.aiagent.skill.credentials.api.g r12 = r6.a();
            if (r12 == null) goto L46;
            r4 = r12.b();
        L46:
            if (r4 == null) goto L48;
            return r4;
        L48:
            return ao.b();
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f19069d, String.class, "com.obric.aiagent.plugin");
            b r7 = (b) ZeusTransformUtils.preCheckCast(this.f19068c, b.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.f.a r8 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(this.f19067b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
            ArrayList r9 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f19066a, ArrayList.class, "com.obric.aiagent.plugin");
            o.a(r13);
        L54:
            com.obric.aiagent.skill.credentials.impl.d.c r15 = b.b(r7);     // Catch: Throwable -> L49
            if (r15 != null) goto L20;
        L25:
            if (r15 == null) goto L27;
            d.c.b.a.b.a(r9.add(r15));     // Catch: Throwable -> L49
        L27:
            b.b(r7, null);     // Catch: Throwable -> L49
            r15 = (com.obric.aiagent.skill.credentials.impl.d.c) ZeusTransformUtils.preCheckCast(b.c(r7).get(r5), com.obric.aiagent.skill.credentials.impl.d.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L49
            if (r15 != null) goto L30;
        L32:
            if (r15 == null) goto L34;
            d.c.b.a.b.a(r9.add(r15));     // Catch: Throwable -> L49
        L34:
            com.obric.aiagent.skill.credentials.impl.c.c.a("provideTaskSessionEnvironment: no prepared session", "provideTaskSessionEnvironment: no prepared session uniqueId=" + r5);     // Catch: Throwable -> L49
            r15 = null;
        L36:
            r8.b(null);
            Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
            r3 = this.g;
            r2 = r10.iterator();
            r6 = r15;
            goto L38
        L30:
            if (b.a(r7, r15) == false) goto L32;
            com.obric.aiagent.skill.credentials.impl.c.c.a("provideTaskSessionEnvironment: reuse session envKeyCount=" + r15.a().b().size(), "provideTaskSessionEnvironment: reuse session uniqueId=" + r5 + " envKeys=" + r15.a().b().keySet() + " expiresAt=" + r15.a().e());     // Catch: Throwable -> L49
            goto L36
        L20:
            if (b.a(r7, r15) == false) goto L25;
            b.b(r7, null);     // Catch: Throwable -> L49
            com.obric.aiagent.skill.credentials.impl.d.c r11 = (com.obric.aiagent.skill.credentials.impl.d.c) ZeusTransformUtils.preCheckCast(b.c(r7).remove(r5), com.obric.aiagent.skill.credentials.impl.d.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L49
            if (r11 == null) goto L24;
            d.c.b.a.b.a(r9.add(r11));     // Catch: Throwable -> L49
        L24:
            ((Map) ZeusTransformUtils.preCheckCast(b.c(r7), Map.class, "com.obric.aiagent.plugin")).put(r5, r15);     // Catch: Throwable -> L49
            com.obric.aiagent.skill.credentials.impl.c.c.a("provideTaskSessionEnvironment: adopted prepared session envKeyCount=" + r15.a().b().size(), "provideTaskSessionEnvironment: adopted prepared session uniqueId=" + r5 + " envKeys=" + r15.a().b().keySet() + " expiresAt=" + r15.a().e());     // Catch: Throwable -> L49
        L49:
            th = move-exception;
            r8.b(null);
            throw th;
        L10:
            o.a(r13);
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(this.f, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L53;
            r9 = new ArrayList();
            r8 = b.a(this.g);
            b r16 = this.g;
            r5 = this.f;
            d.c.d<? super x> r17 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19066a = r9;
            this.f19067b = r8;
            this.f19068c = r16;
            this.f19069d = r5;
            this.f19070e = 1;
            if (r8.a(null, r17) != r0) goto L15;
            return r0;
        L15:
            r7 = r16;
            goto L54
        L53:
            throw new IllegalArgumentException("uniqueId is blank".toString());
        }
    }

    /* JADX INFO: compiled from: TaskSessionCapability.kt */
    @d.c.b.a.f(b = "TaskSessionCapability.kt", c = {76}, d = "release-gIAlu-s", e = "com.obric.aiagent.skill.credentials.impl.session.TaskSessionCapability")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f19071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f19072b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19073c;

        f(b r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19072b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19071a = r3;
            this.f19073c |= Integer.MIN_VALUE;
            Object r2 = this.f19072b.b(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return n.g(r2);
        }
    }

    /* JADX INFO: compiled from: TaskSessionCapability.kt */
    @d.c.b.a.f(b = "TaskSessionCapability.kt", c = {158, EventsUtils.FEAT_TYPE_PROC_FREQUENT_RESTART}, d = "invokeSuspend", e = "com.obric.aiagent.skill.credentials.impl.session.TaskSessionCapability$release$2")
    static final class g extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f19076c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f19077d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f19078e;
        final /* synthetic */ b f;

        g(String r3, b r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19078e = r3;
            this.f = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((g) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f19078e, this.f, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0122 -> B:32:0x0125). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f19077d;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.f19076c, Iterator.class, "com.obric.aiagent.plugin");
            b r3 = (b) ZeusTransformUtils.preCheckCast(this.f19075b, b.class, "com.obric.aiagent.plugin");
            List r4 = (List) ZeusTransformUtils.preCheckCast(this.f19074a, List.class, "com.obric.aiagent.plugin");
            o.a(r9);
            Object r10 = ((n) ZeusTransformUtils.preCheckCast(r9, n.class, "com.obric.aiagent.plugin")).a();
        L32:
            o.a(r10);
        L28:
            if (r2.hasNext() == false) goto L33;
            com.obric.aiagent.skill.credentials.impl.d.c r11 = (com.obric.aiagent.skill.credentials.impl.d.c) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.aiagent.skill.credentials.impl.d.c.class, "com.obric.aiagent.plugin");
            ISkillCredentialService.d r6 = b.d(r3);
            String r12 = r11.a().a();
            this.f19074a = r4;
            this.f19075b = r3;
            this.f19076c = r2;
            this.f19077d = 2;
            r10 = r6.a(r12, this);
            if (r10 != r0) goto L32;
            return r0;
        L33:
            com.obric.aiagent.skill.credentials.impl.c.c.a("releaseTaskSession: sessions ended count=" + r4.size(), "releaseTaskSession: sessions ended uniqueId=" + this.f19078e + " count=" + r4.size());
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f19076c, String.class, "com.obric.aiagent.plugin");
            b r7 = (b) ZeusTransformUtils.preCheckCast(this.f19075b, b.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.f.a r8 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(this.f19074a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
            o.a(r9);
        L38:
            List r13 = p.a();     // Catch: Throwable -> L35
            com.obric.aiagent.skill.credentials.impl.d.c r14 = (com.obric.aiagent.skill.credentials.impl.d.c) ZeusTransformUtils.preCheckCast(b.c(r7).remove(r5), com.obric.aiagent.skill.credentials.impl.d.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
            if (r14 == null) goto L21;
            d.c.b.a.b.a(r13.add(r14));     // Catch: Throwable -> L35
        L21:
            List r15 = p.a(r13);     // Catch: Throwable -> L35
            r8.b(null);
            if (r15.isEmpty() == false) goto L26;
            com.obric.aiagent.skill.credentials.impl.c.c.a("releaseTaskSession: no session", "releaseTaskSession: no session uniqueId=" + this.f19078e);
            return x.f38692a;
        L26:
            Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin");
            r3 = this.f;
            r2 = r16.iterator();
            r4 = r15;
        L35:
            th = move-exception;
            r8.b(null);
            throw th;
        L10:
            o.a(r9);
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(this.f19078e, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L13;
            r8 = b.a(this.f);
            b r17 = this.f;
            r5 = this.f19078e;
            d.c.d<? super x> r18 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19074a = r8;
            this.f19075b = r17;
            this.f19076c = r5;
            this.f19077d = 1;
            if (r8.a(null, r18) != r0) goto L17;
            return r0;
        L17:
            r7 = r17;
            goto L38
        L13:
            return x.f38692a;
        }
    }

    public b(ISkillCredentialService.d r3) {
        ISkillCredentialService.d r4 = (ISkillCredentialService.d) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.d.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "sessions");
        this.f19045a = r4;
        this.f19046b = kotlinx.coroutines.f.c.a(false, 1, null);
        this.f19047c = new LinkedHashMap();
    }

    public static final /* synthetic */ Object a(b r2, com.obric.aiagent.skill.credentials.impl.d.c r3, String r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, String r3, d.c.d r4) {
        return r2.c(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ kotlinx.coroutines.f.a a(b r0) {
        return r0.f19046b;
    }

    public static final /* synthetic */ boolean a(b r0, com.obric.aiagent.skill.credentials.impl.d.c r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ com.obric.aiagent.skill.credentials.impl.d.c b(b r0) {
        return r0.f19048d;
    }

    public static final /* synthetic */ void b(b r0, com.obric.aiagent.skill.credentials.impl.d.c r1) {
        r0.f19048d = r1;
    }

    public static final /* synthetic */ LinkedHashMap c(b r0) {
        return r0.f19047c;
    }

    public static final /* synthetic */ ISkillCredentialService.d d(b r0) {
        return r0.f19045a;
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService.e
    public Object a(com.obric.aiagent.skill.credentials.api.f r6, String r7, d.c.d<? super n<x>> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, C0420b.class) == false) goto L7;
        C0420b r0 = (C0420b) ZeusTransformUtils.preCheckCast(r9, C0420b.class, "com.obric.aiagent.plugin");
        if ((r0.f19057d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19057d -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f19055b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19057d;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r0.f19054a, String.class, "com.obric.aiagent.plugin");
        o.a(r10);     // Catch: Throwable -> L14 CancellationException -> L16
    L27:
    L40:
        return n.f(x.f38692a);
    L14:
        th = th;
    L31:
        n.a r11 = n.f38560a;
        return n.f(o.a((Throwable) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.credentials.api.e(com.obric.aiagent.skill.credentials.impl.c.c.a(th, r5)), Throwable.class, "com.obric.aiagent.plugin")));
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        o.a(r10);
        h r12 = com.obric.aiagent.skill.credentials.impl.c.c.a(r6, "prepareTaskSession");
        if (r12 == null) goto L34;
        n.a r13 = n.f38560a;
        return n.f(o.a((Throwable) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.credentials.api.e(r12), Throwable.class, "com.obric.aiagent.plugin")));
    L34:
        n.a r14 = n.f38560a;     // Catch: CancellationException -> L16 Throwable -> L29
        d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L16 Throwable -> L29
        r0.f19054a = "prepareTaskSession";     // Catch: CancellationException -> L16 Throwable -> L29
        r0.f19057d = 1;     // Catch: CancellationException -> L16 Throwable -> L29
        if (a(this, r7, r0) != r2) goto L27;
        return r2;
    L29:
        th = th;
        r5 = "prepareTaskSession";
    L16:
        e = move-exception;
        throw e;
    L7:
        r0 = new C0420b(this, r9);
        goto L8
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService.e
    public Object a(String r6, d.c.d<? super n<? extends Map<String, String>>> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r8, d.class, "com.obric.aiagent.plugin");
        if ((r0.f19065c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19065c -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f19063a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19065c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r9);
        return ((n) ZeusTransformUtils.preCheckCast(r9, n.class, "com.obric.aiagent.plugin")).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r9);
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new e(r6, this, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r0.f19065c = 1;
        Object r10 = com.obric.aiagent.skill.credentials.impl.c.c.a(r5, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new d(this, r8);
        goto L8
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService.e
    public Object b(String r6, d.c.d<? super n<x>> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r8, f.class, "com.obric.aiagent.plugin");
        if ((r0.f19073c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19073c -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f19071a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19073c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r9);
        return ((n) ZeusTransformUtils.preCheckCast(r9, n.class, "com.obric.aiagent.plugin")).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r9);
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new g(r6, this, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r0.f19073c = 1;
        Object r10 = com.obric.aiagent.skill.credentials.impl.c.c.a(r5, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new f(this, r8);
        goto L8
    }

    private final Object c(String r14, d.c.d<? super x> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, c.class) == false) goto L7;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r16, c.class, "com.obric.aiagent.plugin");
        if ((r1.f & Integer.MIN_VALUE) == 0) goto L7;
        r1.f -= Integer.MIN_VALUE;
    L8:
        Object r17 = r1.f19061d;
        Object r9 = d.c.a.b.a();
        int r3 = r1.f;
        boolean r5 = true;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        o.a(r17);
    L53:
        return x.f38692a;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        kotlinx.coroutines.f.a r13 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r1.f19060c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.credentials.impl.d.c r18 = (com.obric.aiagent.skill.credentials.impl.d.c) ZeusTransformUtils.preCheckCast(r1.f19059b, com.obric.aiagent.skill.credentials.impl.d.c.class, "com.obric.aiagent.plugin");
        b r0 = (b) ZeusTransformUtils.preCheckCast(r1.f19058a, b.class, "com.obric.aiagent.plugin");
        o.a(r17);
    L62:
        com.obric.aiagent.skill.credentials.impl.d.c r19 = r0.f19048d;     // Catch: Throwable -> L54
        r0.f19048d = r18;     // Catch: Throwable -> L54
        r13.b(null);
        if (r19 == null) goto L53;
        r1.f19058a = null;
        r1.f19059b = null;
        r1.f19060c = null;
        r1.f = 4;
        if (r0.a(r19, "replace prepared session", r1) != r9) goto L53;
        return r9;
    L54:
        th = move-exception;
        r13.b(null);
        throw th;
    L18:
        String r110 = (String) ZeusTransformUtils.preCheckCast(r1.f19059b, String.class, "com.obric.aiagent.plugin");
        b r111 = (b) ZeusTransformUtils.preCheckCast(r1.f19058a, b.class, "com.obric.aiagent.plugin");
        o.a(r17);
        Object r112 = ((n) ZeusTransformUtils.preCheckCast(r17, n.class, "com.obric.aiagent.plugin")).a();
        r0 = r111;
    L42:
        o.a(r112);
        com.obric.aiagent.skill.credentials.impl.d.c r113 = new com.obric.aiagent.skill.credentials.impl.d.c((com.obric.aiagent.skill.credentials.api.g) ZeusTransformUtils.preCheckCast(r112, com.obric.aiagent.skill.credentials.api.g.class, "com.obric.aiagent.plugin"), r110);
        r13 = r0.f19046b;
        r1.f19058a = r0;
        r1.f19059b = r113;
        r1.f19060c = r13;
        r1.f = 3;
        if (r13.a(null, r1) != r9) goto L45;
        return r9;
    L45:
        r18 = r113;
        goto L62
    L19:
        kotlinx.coroutines.f.a r114 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r1.f19060c, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        r14 = (String) ZeusTransformUtils.preCheckCast(r1.f19059b, String.class, "com.obric.aiagent.plugin");
        b r2 = (b) ZeusTransformUtils.preCheckCast(r1.f19058a, b.class, "com.obric.aiagent.plugin");
        o.a(r17);
        kotlinx.coroutines.f.a r115 = r114;
        b this = r2;
    L60:
        com.obric.aiagent.skill.credentials.impl.d.c r4 = this.f19048d;     // Catch: Throwable -> L57
        if (r4 != null) goto L26;
    L33:
        r4 = null;
    L34:
        r115.b(null);
        if (r4 == null) goto L38;
        com.obric.aiagent.skill.credentials.impl.c.c.a("prepareTaskSession: reuse prepared session envKeyCount=" + r4.a().b().size(), "prepareTaskSession: reuse prepared session envKeys=" + r4.a().b().keySet() + " expiresAt=" + r4.a().e());
        return x.f38692a;
    L38:
        ISkillCredentialService.d r6 = this.f19045a;
        com.obric.aiagent.skill.credentials.api.f r116 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        r1.f19058a = this;
        r1.f19059b = r14;
        r1.f19060c = null;
        r1.f = 2;
        r112 = r6.a(r116, r14, 1800, r1);
        if (r112 != r9) goto L41;
        return r9;
    L41:
        r0 = this;
        r110 = r14;
        goto L42
    L26:
        if (d.h.b.o.a(r4.b(), r14) == false) goto L30;
        if (this.a(r4) == false) goto L30;
    L31:
        if (r5 == false) goto L33;
    L30:
        r5 = false;
    L57:
        th = move-exception;
        r115.b(null);
        throw th;
    L20:
        o.a(r17);
        r115 = this.f19046b;
        r1.f19058a = this;
        r1.f19059b = r14;
        r1.f19060c = r115;
        r1.f = 1;
        if (r115.a(null, r1) != r9) goto L60;
        return r9;
    L7:
        r1 = new c(this, r16);
        goto L8
    }

    private final Object a(com.obric.aiagent.skill.credentials.impl.d.c r6, String r7, d.c.d<? super x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if ((r0.f19053e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19053e -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f19051c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19053e;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r7 = (String) ZeusTransformUtils.preCheckCast(r0.f19050b, String.class, "com.obric.aiagent.plugin");
        r6 = (com.obric.aiagent.skill.credentials.impl.d.c) ZeusTransformUtils.preCheckCast(r0.f19049a, com.obric.aiagent.skill.credentials.impl.d.c.class, "com.obric.aiagent.plugin");
        o.a(r10);     // Catch: Throwable -> L22
        Object r5 = ((n) ZeusTransformUtils.preCheckCast(r10, n.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L22
    L20:
        o.a(r5);     // Catch: Throwable -> L22
        Object r11 = n.f(x.f38692a);     // Catch: Throwable -> L22
    L24:
        Throwable r12 = n.c(r11);
        if (r12 == null) goto L28;
        com.obric.aiagent.skill.credentials.impl.c.c.a("endTaskSessionQuietly: failed reason=" + r7, "endTaskSessionQuietly: failed reason=" + r7 + " sessionIdPresent=" + (!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6.a().a(), CharSequence.class, "com.obric.aiagent.plugin"))), r12);
    L28:
        return x.f38692a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        o.a(r10);
        n.a r13 = n.f38560a;     // Catch: Throwable -> L22
        ISkillCredentialService.d r14 = ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).f19045a;     // Catch: Throwable -> L22
        String r15 = r6.a().a();     // Catch: Throwable -> L22
        r0.f19049a = r6;     // Catch: Throwable -> L22
        r0.f19050b = r7;     // Catch: Throwable -> L22
        r0.f19053e = 1;     // Catch: Throwable -> L22
        r5 = r14.a(r15, r0);     // Catch: Throwable -> L22
        if (r5 != r2) goto L20;
        return r2;
    L22:
        th = move-exception;
        n.a r16 = n.f38560a;
        r11 = n.f(o.a(th));
    L7:
        r0 = new a(this, r9);
        goto L8
    }

    private final boolean a(com.obric.aiagent.skill.credentials.impl.d.c r6) {
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6.a().a(), CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L5;
    L9:
        return false;
    L5:
        if ((!r6.a().b().isEmpty()) == false) goto L9;
        if ((System.currentTimeMillis() + 60000) >= r6.a().e()) goto L9;
        return true;
    }
}
