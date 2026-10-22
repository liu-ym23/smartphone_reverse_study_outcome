package com.obric.aiagent.executionengine.eventstaskmanager;

import android.content.Context;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.autoaction.app.launcherpage.api.IAutoTaskApi;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskAction;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.h.b.z;
import d.n;
import d.o;
import d.x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SemanticTaskIconBackFillHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "SemanticTaskIconBackFill";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16607a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f16608b = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SemanticTaskIconBackFillHelper.kt */
    @f(b = "SemanticTaskIconBackFillHelper.kt", c = {ApWakeEvent.OTHER_END, 145}, d = "backFillConditionTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.SemanticTaskIconBackFillHelper")
    static final class C0338a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16610b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f16611c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f16612d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f16613e;

        C0338a(a r3, d.c.d<? super C0338a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16612d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16611c = r3;
            this.f16613e |= Integer.MIN_VALUE;
            return a.a(this.f16612d, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SemanticTaskIconBackFillHelper.kt */
    @f(b = "SemanticTaskIconBackFillHelper.kt", c = {118}, d = "backFillConditionTasks", e = "com.obric.aiagent.executionengine.eventstaskmanager.SemanticTaskIconBackFillHelper")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f16616c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f16617d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f16618e;
        Object f;
        int g;
        /* synthetic */ Object h;
        final /* synthetic */ a i;
        int j;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return a.b(this.i, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SemanticTaskIconBackFillHelper.kt */
    @f(b = "SemanticTaskIconBackFillHelper.kt", c = {93, 97}, d = "backFillShortcutTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.SemanticTaskIconBackFillHelper")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f16621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f16622d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f16623e;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16622d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16621c = r3;
            this.f16623e |= Integer.MIN_VALUE;
            return a.a(this.f16622d, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SemanticTaskIconBackFillHelper.kt */
    @f(b = "SemanticTaskIconBackFillHelper.kt", c = {70}, d = "backFillShortcutTasks", e = "com.obric.aiagent.executionengine.eventstaskmanager.SemanticTaskIconBackFillHelper")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f16626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f16627d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f16628e;
        Object f;
        int g;
        /* synthetic */ Object h;
        final /* synthetic */ a i;
        int j;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return a.a(this.i, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SemanticTaskIconBackFillHelper.kt */
    @f(b = "SemanticTaskIconBackFillHelper.kt", c = {39, 44}, d = "run", e = "com.obric.aiagent.executionengine.eventstaskmanager.SemanticTaskIconBackFillHelper")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f16631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f16632d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f16633e;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16632d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16631c = r3;
            this.f16633e |= Integer.MIN_VALUE;
            return this.f16632d.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private a() {
    }

    public static final /* synthetic */ Object a(a r2, IAutoTaskApi r3, d.c.d r4) {
        return r2.a((IAutoTaskApi) ZeusTransformUtils.wrapperContextForParams(r3, IAutoTaskApi.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, ConditionTask r3, IAutoTaskApi r4, String r5, d.c.d r6) {
        return r2.a(r3, (IAutoTaskApi) ZeusTransformUtils.wrapperContextForParams(r4, IAutoTaskApi.class, "com.obric.aiagent.plugin"), r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(a r2, ShortcutTask r3, IAutoTaskApi r4, String r5, d.c.d r6) {
        return r2.a(r3, (IAutoTaskApi) ZeusTransformUtils.wrapperContextForParams(r4, IAutoTaskApi.class, "com.obric.aiagent.plugin"), r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(a r2, IAutoTaskApi r3, d.c.d r4) {
        return r2.b((IAutoTaskApi) ZeusTransformUtils.wrapperContextForParams(r3, IAutoTaskApi.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f16607a = new a();
        f16608b = new AtomicBoolean(false);
    }

    public final Object a(d.c.d<? super x> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r12, e.class, "com.obric.aiagent.plugin");
        if ((r0.f16633e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16633e -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f16631c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16633e;
        if (r3 == 0) goto L23;
        if (r3 != 1) goto L58;
        IAutoTaskApi r10 = (IAutoTaskApi) ZeusTransformUtils.preCheckCast(r0.f16630b, IAutoTaskApi.class, "com.obric.aiagent.plugin");
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0.f16629a, a.class, "com.obric.aiagent.plugin");
        o.a(r13);     // Catch: Throwable -> L14 CancellationException -> L16
        IAutoTaskApi r4 = r10;
        a this = r1;
    L41:
        if (this.a() == false) goto L46;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "stop before condition backFill, OAuto is active");     // Catch: Throwable -> L14 CancellationException -> L16
        x r14 = x.f38692a;     // Catch: Throwable -> L14 CancellationException -> L16
        f16608b.set(false);
        return r14;
    L46:
        r0.f16629a = null;     // Catch: Throwable -> L14 CancellationException -> L16
        r0.f16630b = null;     // Catch: Throwable -> L14 CancellationException -> L16
        r0.f16633e = 2;     // Catch: Throwable -> L14 CancellationException -> L16
        if (this.b(r4, r0) != r2) goto L49;
        return r2;
    L49:
        f16608b.set(false);
        return x.f38692a;
    L58:
        if (r3 != 2) goto L19;
        o.a(r13);     // Catch: Throwable -> L14 CancellationException -> L16
        goto L49
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L55:
        th = move-exception;
        f16608b.set(false);
        throw th;
    L23:
        o.a(r13);
        AtomicBoolean r15 = f16608b;
        if (r15.compareAndSet(false, true) == true) goto L28;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "backFill already running");
        return x.f38692a;
    L28:
        if (a() == false) goto L32;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "skip backFill, OAuto is active");     // Catch: Throwable -> L14 CancellationException -> L16
        x r16 = x.f38692a;     // Catch: Throwable -> L14 CancellationException -> L16
        r15.set(false);
        return r16;
    L32:
        r4 = (IAutoTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoTaskApi.class), IAutoTaskApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14 CancellationException -> L16
        if (r4 != null) goto L37;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "skip backFill, IAutoTaskApi unavailable");     // Catch: Throwable -> L14 CancellationException -> L16
        x r17 = x.f38692a;     // Catch: Throwable -> L14 CancellationException -> L16
        r15.set(false);
        return r17;
    L37:
        r0.f16629a = this;     // Catch: Throwable -> L14 CancellationException -> L16
        r0.f16630b = r4;     // Catch: Throwable -> L14 CancellationException -> L16
        r0.f16633e = 1;     // Catch: Throwable -> L14 CancellationException -> L16
        if (a(r4, r0) != r2) goto L41;
        return r2;
    L16:
        e = move-exception;
        throw e;     // Catch: Throwable -> L55
    L14:
        th = move-exception;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "backFill failed: " + th.getMessage(), th);     // Catch: Throwable -> L55
    L7:
        r0 = new e(this, r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00e5 -> B:29:0x0120). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x015b -> B:12:0x0095). Please report as a decompilation issue!!! */
    private final Object a(IAutoTaskApi r18, d.c.d<? super x> r19) {
        IAutoTaskApi r0 = (IAutoTaskApi) ZeusTransformUtils.wrapperContextForParams(r18, IAutoTaskApi.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L7;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin");
        if ((r3.j & Integer.MIN_VALUE) == 0) goto L7;
        r3.j -= Integer.MIN_VALUE;
        a r4 = this;
    L8:
        Object r5 = r3.h;
        Object r6 = d.c.a.b.a();
        int r7 = r3.j;
        if (r7 == 0) goto L15;
        if (r7 != 1) goto L14;
        int r1 = r3.g;
        Iterator r8 = (Iterator) ZeusTransformUtils.preCheckCast(r3.f, Iterator.class, "com.obric.aiagent.plugin");
        List<ShortcutTask> r9 = (List) ZeusTransformUtils.preCheckCast(r3.f16628e, List.class, "com.obric.aiagent.plugin");
        z.d r10 = (z.d) ZeusTransformUtils.preCheckCast(r3.f16627d, z.d.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r3.f16626c, String.class, "com.obric.aiagent.plugin");
        IAutoTaskApi r12 = (IAutoTaskApi) ZeusTransformUtils.preCheckCast(r3.f16625b, IAutoTaskApi.class, "com.obric.aiagent.plugin");
        a r13 = (a) ZeusTransformUtils.preCheckCast(r3.f16624a, a.class, "com.obric.aiagent.plugin");
        o.a(r5);
        Iterator r16 = r8;
        d r14 = r3;
        String r15 = r11;
        List<ShortcutTask> r17 = r9;
        Object r20 = r6;
        a r21 = r13;
    L12:
        Iterator r110 = r16;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L42;
        r10.f38502a++;
    L42:
        IAutoTaskApi r22 = r12;
        Iterator r111 = r110;
    L30:
        if (r111.hasNext() == false) goto L44;
        ShortcutTask r112 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r111.next(), ShortcutTask.class, "com.obric.aiagent.plugin");
        a r113 = f16607a;
        if (r113.a() == false) goto L35;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "stop shortcut backFill, OAuto is active");
        return x.f38692a;
    L35:
        r14.f16624a = r21;
        r14.f16625b = r22;
        r14.f16626c = r15;
        r14.f16627d = r10;
        r14.f16628e = r17;
        r14.f = r111;
        r14.g = r1;
        r14.j = 1;
        Object r114 = r113.a(r112, r22, r15, r14);
        if (r114 != r20) goto L38;
        return r20;
    L38:
        r16 = r111;
        r12 = r22;
        r5 = r114;
        goto L12
    L44:
        if (r17.size() < 50) goto L47;
        Object r115 = r20;
        int r23 = r1 + 50;
        r0 = r22;
        String r24 = r15;
        r3 = r14;
        r4 = r21;
        r6 = r115;
    L21:
        if (r4.a() == true) goto L47;
        r17 = com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a.a(r24, r23, 50);
        if (r17 != null) goto L26;
        r17 = p.b();
    L26:
        if (r17.isEmpty() == true) goto L47;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "shortcut page offset=" + r23 + ", size=" + r17.size());
        r111 = ((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        String r116 = r24;
        r22 = r0;
        r1 = r23;
        r20 = r6;
        r21 = r4;
        r14 = r3;
        r15 = r116;
    L47:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "shortcut backFill finish, updated=" + r10.f38502a);
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        o.a(r5);
        r24 = b();
        if (r24 == null) goto L18;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "start shortcut backFill, packageName=" + r24);
        r23 = 0;
        r10 = new z.d();
        goto L21
    L18:
        return x.f38692a;
    L7:
        r4 = this;
        r3 = new d(r4, r2);
        goto L8
    }

    private final Object a(ShortcutTask r16, IAutoTaskApi r17, String r18, d.c.d<? super Boolean> r19) {
        IAutoTaskApi r0 = (IAutoTaskApi) ZeusTransformUtils.wrapperContextForParams(r17, IAutoTaskApi.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L7;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin");
        if ((r3.f16623e & Integer.MIN_VALUE) == 0) goto L7;
        r3.f16623e -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.f16621c;
        Object r5 = d.c.a.b.a();
        int r6 = r3.f16623e;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r3.f16619a, String.class, "com.obric.aiagent.plugin");
        o.a(r4);
    L44:
        boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "update shortcut icon ext, taskId=" + r1 + ", success=" + r7);
        return d.c.b.a.b.a(r7);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r1 = (String) ZeusTransformUtils.preCheckCast(r3.f16620b, String.class, "com.obric.aiagent.plugin");
        ShortcutTask r8 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r3.f16619a, ShortcutTask.class, "com.obric.aiagent.plugin");
        o.a(r4);
        ShortcutTask r12 = r8;
    L33:
        Map<String, String> r9 = (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L38;
        return d.c.b.a.b.a(false);
    L38:
        if (d.h.b.o.a(r9, r12.getExt()) == true) goto L40;
        com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a r10 = com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a.f17459a;
        r3.f16619a = r1;
        r3.f16620b = null;
        r3.f16623e = 2;
        r4 = r10.a(r1, r9, r3);
        if (r4 != r5) goto L44;
        return r5;
    L40:
        return d.c.b.a.b.a(false);
    L16:
        o.a(r4);
        String r11 = r16.getId();
        if (r11 == null) goto L49;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L22;
        r11 = null;
    L22:
        if (r11 == null) goto L49;
        String r13 = a(r16);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L47;
        if (r0.hasSemanticIconExt(r16.getExt()) == true) goto L47;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "start request shortcut semantic icon, packageName=" + r18 + ", taskId=" + r11);
        Map<String, String> r14 = r16.getExt();
        r12 = r16;
        r3.f16619a = r12;
        r3.f16620b = r11;
        r3.f16623e = 1;
        Object r15 = r0.appendSemanticIconExt(r13, r14, r3);
        if (r15 != r5) goto L32;
        return r5;
    L32:
        String r110 = r11;
        r4 = r15;
        r1 = r110;
    L47:
        return d.c.b.a.b.a(false);
    L49:
        return d.c.b.a.b.a(false);
    L7:
        r3 = new c(this, r2);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00e5 -> B:29:0x0120). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x015b -> B:12:0x0095). Please report as a decompilation issue!!! */
    private final Object b(IAutoTaskApi r18, d.c.d<? super x> r19) {
        IAutoTaskApi r0 = (IAutoTaskApi) ZeusTransformUtils.wrapperContextForParams(r18, IAutoTaskApi.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L7;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
        if ((r3.j & Integer.MIN_VALUE) == 0) goto L7;
        r3.j -= Integer.MIN_VALUE;
        a r4 = this;
    L8:
        Object r5 = r3.h;
        Object r6 = d.c.a.b.a();
        int r7 = r3.j;
        if (r7 == 0) goto L15;
        if (r7 != 1) goto L14;
        int r1 = r3.g;
        Iterator r8 = (Iterator) ZeusTransformUtils.preCheckCast(r3.f, Iterator.class, "com.obric.aiagent.plugin");
        List<ConditionTask> r9 = (List) ZeusTransformUtils.preCheckCast(r3.f16618e, List.class, "com.obric.aiagent.plugin");
        z.d r10 = (z.d) ZeusTransformUtils.preCheckCast(r3.f16617d, z.d.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r3.f16616c, String.class, "com.obric.aiagent.plugin");
        IAutoTaskApi r12 = (IAutoTaskApi) ZeusTransformUtils.preCheckCast(r3.f16615b, IAutoTaskApi.class, "com.obric.aiagent.plugin");
        a r13 = (a) ZeusTransformUtils.preCheckCast(r3.f16614a, a.class, "com.obric.aiagent.plugin");
        o.a(r5);
        Iterator r16 = r8;
        b r14 = r3;
        String r15 = r11;
        List<ConditionTask> r17 = r9;
        Object r20 = r6;
        a r21 = r13;
    L12:
        Iterator r110 = r16;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L42;
        r10.f38502a++;
    L42:
        IAutoTaskApi r22 = r12;
        Iterator r111 = r110;
    L30:
        if (r111.hasNext() == false) goto L44;
        ConditionTask r112 = (ConditionTask) ZeusTransformUtils.preCheckCast(r111.next(), ConditionTask.class, "com.obric.aiagent.plugin");
        a r113 = f16607a;
        if (r113.a() == false) goto L35;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "stop condition backFill, OAuto is active");
        return x.f38692a;
    L35:
        r14.f16614a = r21;
        r14.f16615b = r22;
        r14.f16616c = r15;
        r14.f16617d = r10;
        r14.f16618e = r17;
        r14.f = r111;
        r14.g = r1;
        r14.j = 1;
        Object r114 = r113.a(r112, r22, r15, r14);
        if (r114 != r20) goto L38;
        return r20;
    L38:
        r16 = r111;
        r12 = r22;
        r5 = r114;
        goto L12
    L44:
        if (r17.size() < 50) goto L47;
        Object r115 = r20;
        int r23 = r1 + 50;
        r0 = r22;
        String r24 = r15;
        r3 = r14;
        r4 = r21;
        r6 = r115;
    L21:
        if (r4.a() == true) goto L47;
        r17 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r24, r23, 50);
        if (r17 != null) goto L26;
        r17 = p.b();
    L26:
        if (r17.isEmpty() == true) goto L47;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "condition page offset=" + r23 + ", size=" + r17.size());
        r111 = ((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        String r116 = r24;
        r22 = r0;
        r1 = r23;
        r20 = r6;
        r21 = r4;
        r14 = r3;
        r15 = r116;
    L47:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "condition backFill finish, updated=" + r10.f38502a);
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        o.a(r5);
        r24 = b();
        if (r24 == null) goto L18;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "start condition backFill, packageName=" + r24);
        r23 = 0;
        r10 = new z.d();
        goto L21
    L18:
        return x.f38692a;
    L7:
        r4 = this;
        r3 = new b(r4, r2);
        goto L8
    }

    private final Object a(ConditionTask r16, IAutoTaskApi r17, String r18, d.c.d<? super Boolean> r19) {
        IAutoTaskApi r0 = (IAutoTaskApi) ZeusTransformUtils.wrapperContextForParams(r17, IAutoTaskApi.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C0338a.class) == false) goto L7;
        C0338a r3 = (C0338a) ZeusTransformUtils.preCheckCast(r2, C0338a.class, "com.obric.aiagent.plugin");
        if ((r3.f16613e & Integer.MIN_VALUE) == 0) goto L7;
        r3.f16613e -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.f16611c;
        Object r5 = d.c.a.b.a();
        int r6 = r3.f16613e;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r3.f16609a, String.class, "com.obric.aiagent.plugin");
        o.a(r4);
    L44:
        boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "update condition icon ext, taskId=" + r1 + ", success=" + r7);
        return d.c.b.a.b.a(r7);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r1 = (String) ZeusTransformUtils.preCheckCast(r3.f16610b, String.class, "com.obric.aiagent.plugin");
        ConditionTask r8 = (ConditionTask) ZeusTransformUtils.preCheckCast(r3.f16609a, ConditionTask.class, "com.obric.aiagent.plugin");
        o.a(r4);
        ConditionTask r12 = r8;
    L33:
        Map<String, String> r9 = (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L38;
        return d.c.b.a.b.a(false);
    L38:
        if (d.h.b.o.a(r9, r12.getExt()) == true) goto L40;
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b r10 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a;
        r3.f16609a = r1;
        r3.f16610b = null;
        r3.f16613e = 2;
        r4 = r10.a(r1, r9, r3);
        if (r4 != r5) goto L44;
        return r5;
    L40:
        return d.c.b.a.b.a(false);
    L16:
        o.a(r4);
        String r11 = r16.getId();
        if (r11 == null) goto L49;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L22;
        r11 = null;
    L22:
        if (r11 == null) goto L49;
        String r13 = a(r16);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L47;
        if (r0.hasSemanticIconExt(r16.getExt()) == true) goto L47;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "start request condition semantic icon, packageName=" + r18 + ", taskId=" + r11);
        Map<String, String> r14 = r16.getExt();
        r12 = r16;
        r3.f16609a = r12;
        r3.f16610b = r11;
        r3.f16613e = 1;
        Object r15 = r0.appendSemanticIconExt(r13, r14, r3);
        if (r15 != r5) goto L32;
        return r5;
    L32:
        String r110 = r11;
        r4 = r15;
        r1 = r110;
    L47:
        return d.c.b.a.b.a(false);
    L49:
        return d.c.b.a.b.a(false);
    L7:
        r3 = new C0338a(this, r2);
        goto L8
    }

    private final String a(ShortcutTask r3) {
        ShortcutTaskAction r2 = (ShortcutTaskAction) ZeusTransformUtils.preCheckCast(p.l(r3.getActions()), ShortcutTaskAction.class, "com.obric.aiagent.plugin");
        String r4 = null;
        if (r2 == null) goto L5;
        IntentParams r5 = r2.getParams();
    L7:
        if (ZeusTransformUtils.instanceOf(r5, SystemAutoActionParams.class) == false) goto L9;
        SystemAutoActionParams r6 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r5, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L10:
        if (r6 == null) goto L12;
        r4 = r6.getInstruction();
    L12:
        if (r4 != null) goto L15;
        return "";
    L15:
        return r4;
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L7
    }

    private final String a(ConditionTask r3) {
        ConditionTaskAction r2 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(p.l(r3.getActions()), ConditionTaskAction.class, "com.obric.aiagent.plugin");
        String r4 = null;
        if (r2 == null) goto L5;
        IntentParams r5 = r2.getParams();
    L7:
        if (ZeusTransformUtils.instanceOf(r5, SystemAutoActionParams.class) == false) goto L9;
        SystemAutoActionParams r6 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r5, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L10:
        if (r6 == null) goto L12;
        r4 = r6.getInstruction();
    L12:
        if (r4 != null) goto L15;
        return "";
    L15:
        return r4;
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L7
    }

    private final boolean a() {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r6 = n.f(Boolean.valueOf(SharedState.INSTANCE.getBoolean("oauto_active_state", false)));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = n.c(r6);
        if (r3 == null) goto L12;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "query OAuto active state failed: " + r3.getMessage());
        r6 = false;
    L12:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        th = move-exception;
        n.a r4 = n.f38560a;
        r6 = n.f(o.a(th));
        goto L7
    }

    private final String b() {
        String r3 = com.obric.aiagent.executionengine.eventstaskmanager.timertask.a.a.f17874a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "skip backFill, calling packageName is empty");
        return null;
    L12:
        return r3;
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}
