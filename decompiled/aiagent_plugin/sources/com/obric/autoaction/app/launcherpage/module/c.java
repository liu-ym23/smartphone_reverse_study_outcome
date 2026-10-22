package com.obric.autoaction.app.launcherpage.module;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.autoaction.app.launcherpage.module.a.a.f;
import com.obric.autoaction.app.launcherpage.module.datasource.j;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.IAutoActionSessionManager;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.a.t;
import d.h.b.h;
import d.k;
import d.o;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: TaskListViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends aj {
    private static final String TAG = "TaskViewModel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24088a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f24089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x<List<f>> f24090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final x<String> f24091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.module.datasource.a f24092e;
    private final com.obric.autoaction.app.launcherpage.module.datasource.b f;
    private final x<LocalDate> g;
    private final x<Set<String>> h;
    private final C0552c i;

    /* JADX INFO: compiled from: TaskListViewModel.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: TaskListViewModel.kt */
    @d.c.b.a.f(b = "TaskListViewModel.kt", c = {171}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskListViewModel$init$1")
    static final class b extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f24094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f24095c;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.c$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: TaskListViewModel.kt */
        @d.c.b.a.f(b = "TaskListViewModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskListViewModel$init$1$1")
        static final class AnonymousClass1 extends l implements t<List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>, List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>, List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>, LocalDate, String, d.c.d<? super List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24096a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f24097b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f24098c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f24099d;

            AnonymousClass1(d.c.d<? super AnonymousClass1> r3) {
                super(6, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.h.a.t
            public /* synthetic */ Object a(List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r10, List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r11, List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r12, LocalDate r13, String r14, d.c.d<? super List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>> r15) {
                return a2((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin"), (LocalDate) ZeusTransformUtils.preCheckCast(r13, LocalDate.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r15, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
            public final Object a2(List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r1, List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r2, List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r3, LocalDate r4, String r5, d.c.d<? super List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>> r6) {
                List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.aiagent.plugin");
                List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
                List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r9 = new AnonymousClass1((d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
                r9.f24097b = r0;
                r9.f24098c = r7;
                r9.f24099d = r8;
                return r9.invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f24096a != 0) goto L13;
                o.a(r4);
                List r5 = (List) ZeusTransformUtils.preCheckCast(this.f24097b, List.class, "com.obric.aiagent.plugin");
                List r0 = (List) ZeusTransformUtils.preCheckCast(this.f24098c, List.class, "com.obric.aiagent.plugin");
                List r3 = (List) ZeusTransformUtils.preCheckCast(this.f24099d, List.class, "com.obric.aiagent.plugin");
                if (r0 == null) goto L10;
                if (r5 != null) goto L9;
                return null;
            L9:
                return p.c((Collection) ZeusTransformUtils.preCheckCast(p.c((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"));
            L10:
                return null;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.c$b$2, reason: invalid class name */
        /* JADX INFO: compiled from: TaskListViewModel.kt */
        @d.c.b.a.f(b = "TaskListViewModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskListViewModel$init$1$4")
        static final class AnonymousClass2 extends l implements m<List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24100a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f24101b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ c f24102c;

            AnonymousClass2(c r3, d.c.d<? super AnonymousClass2> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24102c = r3;
                super(2, r5);
            }

            public final Object a(List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass2 r0 = new AnonymousClass2(this.f24102c, r5);
                r0.f24101b = r3;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f> r3, d.c.d<? super d.x> r4) {
                return a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f24100a != 0) goto L7;
                o.a(r3);
                List<com.obric.autoaction.app.launcherpage.module.a.a.f> r4 = (List) ZeusTransformUtils.preCheckCast(this.f24101b, List.class, "com.obric.aiagent.plugin");
                this.f24102c.b().b(r4);
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class a implements kotlinx.coroutines.b.h<List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f24103a;

            /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.c$b$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ i f24104a;

                /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.c$b$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "TaskListViewModel.kt", c = {227, 219}, d = "emit", e = "com.obric.autoaction.app.launcherpage.module.TaskListViewModel$init$1$invokeSuspend$$inlined$map$1$2")
                public static final class C05451 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f24105a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f24106b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f24107c;

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f24108d;

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    Object f24109e;
                    Object f;
                    Object g;

                    public C05451(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f24108d = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f24105a = r3;
                        this.f24106b |= Integer.MIN_VALUE;
                        return this.f24108d.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(i r3) {
                    this.f24104a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                }

                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0113 -> B:31:0x0114). Please report as a decompilation issue!!! */
                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r10, d.c.d r11) {
                    d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r12, C05451.class) == false) goto L7;
                    C05451 r0 = (C05451) ZeusTransformUtils.preCheckCast(r12, C05451.class, "com.obric.aiagent.plugin");
                    if ((r0.f24106b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f24106b -= Integer.MIN_VALUE;
                L8:
                    Object r13 = r0.f24105a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f24106b;
                    if (r3 == 0) goto L16;
                    if (r3 == 1) goto L15;
                    if (r3 != 2) goto L14;
                    o.a(r13);
                L38:
                    return d.x.f38692a;
                L14:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L15:
                    Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r0.g, Collection.class, "com.obric.aiagent.plugin");
                    Iterator<T> r14 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f, Iterator.class, "com.obric.aiagent.plugin");
                    Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r0.f24109e, Collection.class, "com.obric.aiagent.plugin");
                    i r7 = (i) ZeusTransformUtils.preCheckCast(r0.f24107c, i.class, "com.obric.aiagent.plugin");
                    o.a(r13);
                L31:
                    r9.add((com.obric.autoaction.app.launcherpage.module.a.a.f) ZeusTransformUtils.preCheckCast(r13, com.obric.autoaction.app.launcherpage.module.a.a.f.class, "com.obric.aiagent.plugin"));
                    r9 = r4;
                L26:
                    if (r14.hasNext() == false) goto L32;
                    com.obric.autogui.database.entity.a r15 = (com.obric.autogui.database.entity.a) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.autogui.database.entity.a.class, "com.obric.aiagent.plugin");
                    com.obric.autoaction.app.launcherpage.module.a.a.l r5 = com.obric.autoaction.app.launcherpage.module.a.a.l.f24026a;
                    r0.f24107c = r7;
                    r0.f24109e = r9;
                    r0.f = r14;
                    r0.g = r9;
                    r0.f24106b = 1;
                    r13 = r5.a(r15, r0);
                    if (r13 != r2) goto L30;
                    return r2;
                L30:
                    r4 = r9;
                    goto L31
                L32:
                    List r16 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
                    i r17 = r7;
                L34:
                    r0.f24107c = null;
                    r0.f24109e = null;
                    r0.f = null;
                    r0.g = null;
                    r0.f24106b = 2;
                    if (r17.emit(r16, r0) != r2) goto L38;
                    return r2;
                L16:
                    o.a(r13);
                    r17 = this.f24104a;
                    d.c.d r18 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    List r19 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
                    if (r19 == null) goto L33;
                    Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin");
                    Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
                    Iterator<T> r112 = r110.iterator();
                L20:
                    if (r112.hasNext() == false) goto L24;
                    T r6 = r112.next();
                    if (com.obric.autoaction.app.launcherpage.module.a.a.l.f24026a.a((com.obric.autogui.database.entity.a) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.database.entity.a.class, "com.obric.aiagent.plugin")) == false) goto L20;
                    r111.add(r6);
                    goto L20
                L24:
                    Iterable r113 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r111, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
                    Collection r114 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r113, 10)), Collection.class, "com.obric.aiagent.plugin");
                    r14 = r113.iterator();
                    r7 = r17;
                    r9 = r114;
                    goto L26
                L33:
                    r16 = null;
                L7:
                    r0 = new C05451(this, r12);
                    goto L8
                }
            }

            public a(kotlinx.coroutines.b.h r3) {
                this.f24103a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(i<? super List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>> r3, d.c.d r4) {
                i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f24103a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return d.x.f38692a;
            }
        }

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.c$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class C0546b implements kotlinx.coroutines.b.h<List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f24110a;

            /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.c$b$b$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ i f24111a;

                /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.c$b$b$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "TaskListViewModel.kt", c = {219}, d = "emit", e = "com.obric.autoaction.app.launcherpage.module.TaskListViewModel$init$1$invokeSuspend$$inlined$map$2$2")
                public static final class C05471 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f24112a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f24113b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f24114c;

                    public C05471(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f24114c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f24112a = r3;
                        this.f24113b |= Integer.MIN_VALUE;
                        return this.f24114c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(i r3) {
                    this.f24111a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r7, d.c.d r8) {
                    d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r9, C05471.class) == false) goto L7;
                    C05471 r0 = (C05471) ZeusTransformUtils.preCheckCast(r9, C05471.class, "com.obric.aiagent.plugin");
                    if ((r0.f24113b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f24113b -= Integer.MIN_VALUE;
                L8:
                    Object r10 = r0.f24112a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f24113b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    o.a(r10);
                L26:
                    return d.x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    o.a(r10);
                    i r6 = this.f24111a;
                    d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    List r12 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
                    if (r12 == null) goto L21;
                    Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
                    Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r13, 10)), Collection.class, "com.obric.aiagent.plugin");
                    Iterator<T> r15 = r13.iterator();
                L18:
                    if (r15.hasNext() == false) goto L20;
                    r14.add(com.obric.autoaction.app.launcherpage.module.a.a.l.f24026a.a((j) ZeusTransformUtils.preCheckCast(r15.next(), j.class, "com.obric.aiagent.plugin")));
                    goto L18
                L20:
                    List r16 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");
                L22:
                    r0.f24113b = 1;
                    if (r6.emit(r16, r0) != r2) goto L26;
                    return r2;
                L21:
                    r16 = null;
                L7:
                    r0 = new C05471(this, r9);
                    goto L8
                }
            }

            public C0546b(kotlinx.coroutines.b.h r3) {
                this.f24110a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(i<? super List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>> r3, d.c.d r4) {
                i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f24110a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return d.x.f38692a;
            }
        }

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.c$b$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class C0548c implements kotlinx.coroutines.b.h<List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f24115a;

            /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.c$b$c$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ i f24116a;

                /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.c$b$c$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "TaskListViewModel.kt", c = {224, 219}, d = "emit", e = "com.obric.autoaction.app.launcherpage.module.TaskListViewModel$init$1$invokeSuspend$$inlined$map$3$2")
                public static final class C05491 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f24117a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f24118b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f24119c;

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f24120d;

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    Object f24121e;

                    public C05491(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f24120d = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f24117a = r3;
                        this.f24118b |= Integer.MIN_VALUE;
                        return this.f24120d.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(i r3) {
                    this.f24116a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r10, d.c.d r11) {
                    d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r12, C05491.class) == false) goto L7;
                    C05491 r0 = (C05491) ZeusTransformUtils.preCheckCast(r12, C05491.class, "com.obric.aiagent.plugin");
                    if ((r0.f24118b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f24118b -= Integer.MIN_VALUE;
                L8:
                    Object r13 = r0.f24117a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f24118b;
                    if (r3 == 0) goto L16;
                    if (r3 == 1) goto L15;
                    if (r3 != 2) goto L14;
                    o.a(r13);
                L32:
                    return d.x.f38692a;
                L14:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L15:
                    List r9 = (List) ZeusTransformUtils.preCheckCast(r0.f24121e, List.class, "com.obric.aiagent.plugin");
                    i r14 = (i) ZeusTransformUtils.preCheckCast(r0.f24119c, i.class, "com.obric.aiagent.plugin");
                    o.a(r13);
                L23:
                    Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
                    Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r15, 10)), Collection.class, "com.obric.aiagent.plugin");
                    Iterator<T> r17 = r15.iterator();
                L25:
                    if (r17.hasNext() == false) goto L27;
                    r16.add(com.obric.autoaction.app.launcherpage.module.a.a.l.f24026a.a((IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(r17.next(), IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin")));
                    goto L25
                L27:
                    i r8 = r14;
                    List r18 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin");
                    i r19 = r8;
                L28:
                    r0.f24119c = null;
                    r0.f24121e = null;
                    r0.f24118b = 2;
                    if (r19.emit(r18, r0) != r2) goto L32;
                    return r2;
                L16:
                    o.a(r13);
                    r19 = this.f24116a;
                    d.c.d r110 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    List r111 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
                    if (r111.isEmpty() == false) goto L19;
                    r18 = p.b();
                    goto L28
                L19:
                    r0.f24119c = r19;
                    r0.f24121e = r111;
                    r0.f24118b = 1;
                    if (ax.a(300, r0) != r2) goto L22;
                    return r2;
                L22:
                    r14 = r19;
                    r9 = r111;
                L7:
                    r0 = new C05491(this, r12);
                    goto L8
                }
            }

            public C0548c(kotlinx.coroutines.b.h r3) {
                this.f24115a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(i<? super List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>> r3, d.c.d r4) {
                i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f24115a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return d.x.f38692a;
            }
        }

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class d implements kotlinx.coroutines.b.h<List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f24122a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f24123b;

            /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.c$b$d$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ i f24124a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ c f24125b;

                /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.c$b$d$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "TaskListViewModel.kt", c = {219}, d = "emit", e = "com.obric.autoaction.app.launcherpage.module.TaskListViewModel$init$1$invokeSuspend$$inlined$map$4$2")
                public static final class C05501 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f24126a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f24127b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f24128c;

                    public C05501(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f24128c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f24126a = r3;
                        this.f24127b |= Integer.MIN_VALUE;
                        return this.f24128c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(i r3, c r4) {
                    this.f24124a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                    this.f24125b = r4;
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r12, d.c.d r13) {
                    d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r14, C05501.class) == false) goto L7;
                    C05501 r0 = (C05501) ZeusTransformUtils.preCheckCast(r14, C05501.class, "com.obric.aiagent.plugin");
                    if ((r0.f24127b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f24127b -= Integer.MIN_VALUE;
                L8:
                    Object r15 = r0.f24126a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f24127b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    o.a(r15);
                L43:
                    return d.x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    o.a(r15);
                    i r16 = this.f24124a;
                    d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    List r17 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
                    if (r17 != null) goto L17;
                    r17 = null;
                L39:
                    r0.f24127b = 1;
                    if (r16.emit(r17, r0) != r2) goto L43;
                    return r2;
                L17:
                    String r11 = (String) ZeusTransformUtils.preCheckCast(this.f24125b.c().c(), String.class, "com.obric.aiagent.plugin");
                    if (r11 == null) goto L39;
                    Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin");
                    Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
                    Iterator<T> r19 = r18.iterator();
                L22:
                    if (r19.hasNext() == false) goto L38;
                    T r6 = r19.next();
                    com.obric.autoaction.app.launcherpage.module.a.a.f r7 = (com.obric.autoaction.app.launcherpage.module.a.a.f) ZeusTransformUtils.preCheckCast(r6, com.obric.autoaction.app.launcherpage.module.a.a.f.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r7, com.obric.autoaction.app.launcherpage.module.a.a.a.class) == false) goto L27;
                    boolean r8 = d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.autoaction.app.launcherpage.module.a.a.a) ZeusTransformUtils.preCheckCast(r7, com.obric.autoaction.app.launcherpage.module.a.a.a.class, "com.obric.aiagent.plugin")).e(), CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null);
                L36:
                    if (r8 == false) goto L22;
                    r5.add(r6);
                    goto L22
                L27:
                    if (ZeusTransformUtils.instanceOf(r7, com.obric.autoaction.app.launcherpage.module.a.a.b.class) == false) goto L30;
                    r8 = d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.autoaction.app.launcherpage.module.a.a.b) ZeusTransformUtils.preCheckCast(r7, com.obric.autoaction.app.launcherpage.module.a.a.b.class, "com.obric.aiagent.plugin")).c(), CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null);
                    goto L36
                L30:
                    if (ZeusTransformUtils.instanceOf(r7, com.obric.autoaction.app.launcherpage.module.a.a.c.class) == false) goto L33;
                    r8 = d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.autoaction.app.launcherpage.module.a.a.c) ZeusTransformUtils.preCheckCast(r7, com.obric.autoaction.app.launcherpage.module.a.a.c.class, "com.obric.aiagent.plugin")).c(), CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null);
                    goto L36
                L33:
                    if (ZeusTransformUtils.instanceOf(r7, com.obric.autoaction.app.launcherpage.module.a.a.h.class) == false) goto L35;
                    r8 = d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.autoaction.app.launcherpage.module.a.a.h) ZeusTransformUtils.preCheckCast(r7, com.obric.autoaction.app.launcherpage.module.a.a.h.class, "com.obric.aiagent.plugin")).k(), CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null);
                    goto L36
                L35:
                    r8 = true;
                    goto L36
                L38:
                    r17 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
                L7:
                    r0 = new C05501(this, r14);
                    goto L8
                }
            }

            public d(kotlinx.coroutines.b.h r3, c r4) {
                this.f24122a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
                this.f24123b = r4;
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(i<? super List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>> r4, d.c.d r5) {
                i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.aiagent.plugin");
                d.c.d<? super d.x> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                Object r3 = this.f24122a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f24123b), i.class, "com.obric.aiagent.plugin"), r7);
                if (r3 != d.c.a.b.a()) goto L6;
                return r3;
            L6:
                return d.x.f38692a;
            }
        }

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class e implements kotlinx.coroutines.b.h<List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f24129a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f24130b;

            /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.c$b$e$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ i f24131a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ c f24132b;

                /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.c$b$e$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "TaskListViewModel.kt", c = {219}, d = "emit", e = "com.obric.autoaction.app.launcherpage.module.TaskListViewModel$init$1$invokeSuspend$$inlined$map$5$2")
                public static final class C05511 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f24133a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f24134b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f24135c;

                    public C05511(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f24135c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f24133a = r3;
                        this.f24134b |= Integer.MIN_VALUE;
                        return this.f24135c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(i r3, c r4) {
                    this.f24131a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                    this.f24132b = r4;
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C05511.class) == false) goto L7;
                    C05511 r0 = (C05511) ZeusTransformUtils.preCheckCast(r8, C05511.class, "com.obric.aiagent.plugin");
                    if ((r0.f24134b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f24134b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f24133a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f24134b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    o.a(r9);
                L22:
                    return d.x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    o.a(r9);
                    i r10 = this.f24131a;
                    d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    List r11 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
                    if (r11 == null) goto L17;
                    List r5 = c.a(this.f24132b, r11);
                L18:
                    r0.f24134b = 1;
                    if (r10.emit(r5, r0) != r2) goto L22;
                    return r2;
                L17:
                    r5 = null;
                L7:
                    r0 = new C05511(this, r8);
                    goto L8
                }
            }

            public e(kotlinx.coroutines.b.h r3, c r4) {
                this.f24129a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
                this.f24130b = r4;
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(i<? super List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>> r4, d.c.d r5) {
                i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.aiagent.plugin");
                d.c.d<? super d.x> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                Object r3 = this.f24129a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f24130b), i.class, "com.obric.aiagent.plugin"), r7);
                if (r3 != d.c.a.b.a()) goto L6;
                return r3;
            L6:
                return d.x.f38692a;
            }
        }

        /* JADX INFO: compiled from: TaskListViewModel.kt */
        @d.c.b.a.f(b = "TaskListViewModel.kt", c = {112}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskListViewModel$init$1$sessionQueue$1")
        static final class f extends l implements m<i<? super List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>>, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24136a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private /* synthetic */ Object f24137b;

            f(d.c.d<? super f> r3) {
                super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(i<? super List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>> r3, d.c.d<? super d.x> r4) {
                return ((f) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                f r4 = new f((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
                r4.f24137b = r2;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(i<? super List<? extends com.obric.autoaction.app.launcherpage.module.a.a.f>> r3, d.c.d<? super d.x> r4) {
                return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f24136a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r6);
            L12:
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r6);
                i r7 = (i) ZeusTransformUtils.preCheckCast(this.f24137b, i.class, "com.obric.aiagent.plugin");
                List r2 = p.b();
                d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24136a = 1;
                if (r7.emit(r2, r3) != r0) goto L12;
                return r0;
            }
        }

        b(c r3, boolean r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24094b = r3;
            this.f24095c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f24094b, this.f24095c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24093a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L20:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            kotlinx.coroutines.b.h r5 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new a(c.a(this.f24094b).a()), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            if (this.f24095c == false) goto L11;
            x<List<j>> r12 = c.b(this.f24094b).c();
        L12:
            kotlinx.coroutines.b.h r4 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new C0546b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r12, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            if (this.f24095c == false) goto L15;
            kotlinx.coroutines.b.h r13 = kotlinx.coroutines.b.j.a((m) ZeusTransformUtils.preCheckCast(new f(null), m.class, "com.obric.aiagent.plugin"));
        L16:
            kotlinx.coroutines.b.h r14 = kotlinx.coroutines.b.j.a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new e((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new d(kotlinx.coroutines.b.j.a(r4, r5, r13, (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(c.c(this.f24094b), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(this.f24094b.c(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), (t) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), t.class, "com.obric.aiagent.plugin")), this.f24094b), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), this.f24094b), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"));
            m r2 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f24094b, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24093a = 1;
            if (kotlinx.coroutines.b.j.a(r14, r2, r3) != r0) goto L20;
            return r0;
        L15:
            r13 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new C0548c(IAutoActionSessionManager.IMPL.sessionQueue()), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            goto L16
        L11:
            r12 = c.b(this.f24094b).b();
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TaskListViewModel.kt */
    public static final class C0552c extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f24138a;

        C0552c(c r1) {
            this.f24138a = r1;
        }

        public void onReceive(Context r3, Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L5;
            String r6 = r4.getAction();
        L6:
            if (r6 == null) goto L19;
            int r7 = r6.hashCode();
            if (r7 == 505380757) goto L16;
            if (r7 == 1041332296) goto L13;
            return;
        L13:
            if (r6.equals("android.intent.action.DATE_CHANGED") == false) goto L22;
        L17:
            c.c(this.f24138a).b(LocalDate.now());
            return;
        L22:
            return;
        L16:
            if (r6.equals("android.intent.action.TIME_SET") == true) goto L17;
            return;
        L19:
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r7, T r8) {
            f r6 = (f) ZeusTransformUtils.preCheckCast(r7, f.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.a.a.a.class) == false) goto L6;
            Comparable r9 = (Comparable) ZeusTransformUtils.preCheckCast(1, Comparable.class, "com.obric.aiagent.plugin");
        L20:
            f r10 = (f) ZeusTransformUtils.preCheckCast(r8, f.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.app.launcherpage.module.a.a.a.class) == false) goto L24;
            Comparable r11 = (Comparable) ZeusTransformUtils.preCheckCast(1, Comparable.class, "com.obric.aiagent.plugin");
        L39:
            return d.b.a.a(r9, r11);
        L24:
            if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.app.launcherpage.module.a.a.c.class) == false) goto L27;
            r11 = (Comparable) ZeusTransformUtils.preCheckCast(1, Comparable.class, "com.obric.aiagent.plugin");
            goto L39
        L27:
            if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.app.launcherpage.module.a.a.h.class) == false) goto L30;
            r11 = (Comparable) ZeusTransformUtils.preCheckCast(2, Comparable.class, "com.obric.aiagent.plugin");
            goto L39
        L30:
            if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.app.launcherpage.module.a.a.b.class) == false) goto L33;
            r11 = (Comparable) ZeusTransformUtils.preCheckCast(0, Comparable.class, "com.obric.aiagent.plugin");
            goto L39
        L33:
            if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.app.launcherpage.module.a.a.g.class) == false) goto L36;
            r11 = (Comparable) ZeusTransformUtils.preCheckCast(3, Comparable.class, "com.obric.aiagent.plugin");
            goto L39
        L36:
            if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.app.launcherpage.module.a.a.e.class) == false) goto L41;
            r11 = (Comparable) ZeusTransformUtils.preCheckCast(4, Comparable.class, "com.obric.aiagent.plugin");
            goto L39
        L41:
            throw new k();
        L6:
            if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.a.a.c.class) == false) goto L9;
            r9 = (Comparable) ZeusTransformUtils.preCheckCast(1, Comparable.class, "com.obric.aiagent.plugin");
            goto L20
        L9:
            if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.a.a.h.class) == false) goto L12;
            r9 = (Comparable) ZeusTransformUtils.preCheckCast(2, Comparable.class, "com.obric.aiagent.plugin");
            goto L20
        L12:
            if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.a.a.b.class) == false) goto L15;
            r9 = (Comparable) ZeusTransformUtils.preCheckCast(0, Comparable.class, "com.obric.aiagent.plugin");
            goto L20
        L15:
            if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.a.a.g.class) == false) goto L18;
            r9 = (Comparable) ZeusTransformUtils.preCheckCast(3, Comparable.class, "com.obric.aiagent.plugin");
            goto L20
        L18:
            if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.a.a.e.class) == false) goto L43;
            r9 = (Comparable) ZeusTransformUtils.preCheckCast(4, Comparable.class, "com.obric.aiagent.plugin");
            goto L20
        L43:
            throw new k();
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class e<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f24139a;

        public e(Comparator r3) {
            this.f24139a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r5, T r6) {
            int r4 = this.f24139a.compare(r5, r6);
            if (r4 != 0) goto L21;
            f r7 = (f) ZeusTransformUtils.preCheckCast(r6, f.class, "com.obric.aiagent.plugin");
            com.obric.autoaction.app.launcherpage.module.a.a.d r1 = null;
            if (ZeusTransformUtils.instanceOf(r7, com.obric.autoaction.app.launcherpage.module.a.a.d.class) == false) goto L8;
            com.obric.autoaction.app.launcherpage.module.a.a.d r8 = (com.obric.autoaction.app.launcherpage.module.a.a.d) ZeusTransformUtils.preCheckCast(r7, com.obric.autoaction.app.launcherpage.module.a.a.d.class, "com.obric.aiagent.plugin");
        L10:
            if (r8 == null) goto L12;
            Object r9 = Long.valueOf(r8.f());
        L13:
            Comparable r10 = (Comparable) ZeusTransformUtils.preCheckCast(r9, Comparable.class, "com.obric.aiagent.plugin");
            f r11 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r11, com.obric.autoaction.app.launcherpage.module.a.a.d.class) == false) goto L16;
            r1 = (com.obric.autoaction.app.launcherpage.module.a.a.d) ZeusTransformUtils.preCheckCast(r11, com.obric.autoaction.app.launcherpage.module.a.a.d.class, "com.obric.aiagent.plugin");
        L16:
            if (r1 == null) goto L18;
            Object r12 = Long.valueOf(r1.f());
        L20:
            return d.b.a.a(r10, (Comparable) ZeusTransformUtils.preCheckCast(r12, Comparable.class, "com.obric.aiagent.plugin"));
        L18:
            r12 = 0;
            goto L20
        L12:
            r9 = 0;
            goto L13
        L8:
            r8 = null;
            goto L10
        L21:
            return r4;
        }
    }

    static {
        f24088a = new a(null);
    }

    public static /* synthetic */ int lambda$Oyq5Q_bomUjvwuWp5DlgNONM0lk(m r0, Object r1, Object r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$zuz8-TTHpBeuLtqUdjlk8wqNWok, reason: not valid java name */
    public static /* synthetic */ int m548lambda$zuz8TTHpBeuLtqUdjlk8wqNWok(f r0, f r1) {
        return a(r0, r1);
    }

    public c() {
        this.f24090c = kotlinx.coroutines.b.am.a(null);
        this.f24091d = kotlinx.coroutines.b.am.a(null);
        this.f24092e = (com.obric.autoaction.app.launcherpage.module.datasource.a) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.module.datasource.e(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin"))), com.obric.autoaction.app.launcherpage.module.datasource.a.class, "com.obric.aiagent.plugin");
        this.f = (com.obric.autoaction.app.launcherpage.module.datasource.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.module.datasource.i(), com.obric.autoaction.app.launcherpage.module.datasource.b.class, "com.obric.aiagent.plugin");
        this.g = kotlinx.coroutines.b.am.a(LocalDate.now());
        this.h = kotlinx.coroutines.b.am.a(d.a.ax.a(""));
        C0552c r0 = new C0552c(this);
        this.i = r0;
        IntentFilter r4 = new IntentFilter();
        r4.addAction("android.intent.action.DATE_CHANGED");
        r4.addAction("android.intent.action.TIME_SET");
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r0, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r4, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.datasource.a a(c r0) {
        return r0.f24092e;
    }

    public static final /* synthetic */ List a(c r2, List r3) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.datasource.b b(c r0) {
        return r0.f;
    }

    public static final /* synthetic */ x c(c r0) {
        return r0.g;
    }

    public final x<List<f>> b() {
        return this.f24090c;
    }

    public final x<String> c() {
        return this.f24091d;
    }

    @Override // androidx.lifecycle.aj
    public void a() {
        super.a();
        ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.i, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void a(c r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.a(r1);
    }

    public final void a(boolean r10) {
        if (this.f24089b == false) goto L5;
        return;
    L5:
        this.f24089b = true;
        this.f24092e.b();
        this.f.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")));
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(String r2) {
        this.f24092e.a(r2);
        this.f.a(r2);
    }

    public final void e() {
        this.f24092e.c();
    }

    public final List<String> f() {
        return com.obric.autoaction.app.launcherpage.module.datasource.c.f24201a.b();
    }

    public final void a(String r3, boolean r4) {
        d.h.b.o.e(r3, DbHelper.COL_ID);
        if (r4 == false) goto L5;
        x<Set<String>> r2 = this.h;
        r2.b(d.a.ax.b((Set) ZeusTransformUtils.preCheckCast(r2.c(), Set.class, "com.obric.aiagent.plugin"), r3));
        return;
    L5:
        x<Set<String>> r5 = this.h;
        r5.b(d.a.ax.a((Set) ZeusTransformUtils.preCheckCast(r5.c(), Set.class, "com.obric.aiagent.plugin"), r3));
    }

    public final boolean c(String r3) {
        d.h.b.o.e(r3, DbHelper.COL_ID);
        return ((Set) ZeusTransformUtils.preCheckCast(this.h.c(), Set.class, "com.obric.aiagent.plugin")).contains(r3);
    }

    private static final int a(m r2, Object r3, Object r4) {
        return ((Number) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.aiagent.plugin")).invoke(r3, r4), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<f> a(List<? extends f> r11) {
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        final $$Lambda$c$zuz8TTHpBeuLtqUdjlk8wqNWok r12 = $$Lambda$c$zuz8TTHpBeuLtqUdjlk8wqNWok.INSTANCE;
        List r13 = p.a(r10, new $$Lambda$c$Oyq5Q_bomUjvwuWp5DlgNONM0lk(r12));
        List<f> r14 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        int r1 = r13.size();
        if (r1 < 0) goto L47;
        int r2 = 0;
    L5:
        f r3 = null;
        if (r2 != 0) goto L8;
        Object r4 = null;
    L10:
        if (r2 >= r13.size()) goto L12;
        Object r5 = r13.get(r2);
    L13:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        f r7 = (f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L17;
    L40:
        if (r3 == null) goto L43;
        r14.add(r3);
    L43:
        if (r2 >= r13.size()) goto L45;
        r14.add(r13.get(r2));
    L45:
        if (r2 == r1) goto L47;
        r2 = r2 + 1;
        goto L5
    L17:
        if (r7 != null) goto L22;
        if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.a.a.d.class) == false) goto L22;
        LocalDate r8 = com.obric.autogui.util.e.a.a(((com.obric.autoaction.app.launcherpage.module.a.a.d) ZeusTransformUtils.preCheckCast(r6, com.obric.autoaction.app.launcherpage.module.a.a.d.class, "com.obric.aiagent.plugin")).f()).toLocalDate();
        d.h.b.o.c(r8, "toLocalDate(...)");
        r3 = (f) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.module.a.a.g(r8, null, 2, null), f.class, "com.obric.aiagent.plugin");
    L22:
        if (ZeusTransformUtils.instanceOf(r7, com.obric.autoaction.app.launcherpage.module.a.a.d.class) == false) goto L40;
        if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.a.a.d.class) == false) goto L40;
        LocalDate r9 = com.obric.autogui.util.e.a.a(((com.obric.autoaction.app.launcherpage.module.a.a.d) ZeusTransformUtils.preCheckCast(r7, com.obric.autoaction.app.launcherpage.module.a.a.d.class, "com.obric.aiagent.plugin")).f()).toLocalDate();
        LocalDate r15 = com.obric.autogui.util.e.a.a(((com.obric.autoaction.app.launcherpage.module.a.a.d) ZeusTransformUtils.preCheckCast(r6, com.obric.autoaction.app.launcherpage.module.a.a.d.class, "com.obric.aiagent.plugin")).f()).toLocalDate();
        if (ZeusTransformUtils.instanceOf(r7, com.obric.autoaction.app.launcherpage.module.a.a.c.class) == false) goto L31;
        if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.a.a.c.class) == true) goto L40;
    L31:
        if (ZeusTransformUtils.instanceOf(r7, com.obric.autoaction.app.launcherpage.module.a.a.h.class) == true) goto L38;
        if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.a.a.h.class) == false) goto L38;
        if (d.h.b.o.a(r9, r15) == false) goto L38;
        d.h.b.o.a(r15);
        r3 = (f) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.module.a.a.e(r15), f.class, "com.obric.aiagent.plugin");
    L38:
        if (d.h.b.o.a(r9, r15) == true) goto L40;
        d.h.b.o.a(r15);
        r3 = (f) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.module.a.a.g(r15, null, 2, null), f.class, "com.obric.aiagent.plugin");
        goto L40
    L12:
        r5 = null;
        goto L13
    L8:
        r4 = r13.get(r2 - 1);
    L47:
        return r14;
    }

    private static final int a(f r3, f r4) {
        return ((Comparator) ZeusTransformUtils.preCheckCast(new e((Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.aiagent.plugin")), Comparator.class, "com.obric.aiagent.plugin")).compare(r3, r4);
    }
}
