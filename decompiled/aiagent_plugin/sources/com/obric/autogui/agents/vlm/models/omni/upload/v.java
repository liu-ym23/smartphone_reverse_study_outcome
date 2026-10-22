package com.obric.autogui.agents.vlm.models.omni.upload;

import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: OmniUploadTaskLifecycle.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    private static final String TAG = "OmniUploadLifecycle";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f28855a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f28856b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final y f28857c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, c> f28858d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, d> f28859e = null;
    private static final Set<String> f = null;
    private static boolean g;

    /* JADX INFO: compiled from: OmniUploadTaskLifecycle.kt */
    private static final class a implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f28860a = null;

        static {
            f28860a = new a();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OmniUploadTaskLifecycle.kt */
    private static final class b implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f28862b;

        public b(String r2) {
            d.h.b.o.e(r2, DBDefinition.TASK_ID);
            this.f28861a = r2;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (this.f28862b == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f28862b = true;     // Catch: Throwable -> L12
            d.x r0 = d.x.f38692a;     // Catch: Throwable -> L12
            monitor-exit(this);
            v.a(v.f28855a, this.f28861a);
        }
    }

    /* JADX INFO: compiled from: OmniUploadTaskLifecycle.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f28863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f28864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f28865c;

        public c() {
            this(0, false, false, 7, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f28863a == r6.f28863a) goto L12;
            return false;
        L12:
            if (this.f28864b == r6.f28864b) goto L15;
            return false;
        L15:
            if (this.f28865c == r6.f28865c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f28863a) * 31) + Boolean.hashCode(this.f28864b)) * 31) + Boolean.hashCode(this.f28865c);
        }

        public String toString() {
            return "RuntimeState(pendingProducers=" + this.f28863a + ", sessionEnded=" + this.f28864b + ", producerWindowClosed=" + this.f28865c + ')';
        }

        public c(int r1, boolean r2, boolean r3) {
            this.f28863a = r1;
            this.f28864b = r2;
            this.f28865c = r3;
        }

        public /* synthetic */ c(int r2, boolean r3, boolean r4, int r5, d.h.b.h r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = false;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = false;
        L11:
            this(r2, r3, r4);
        }

        public final int a() {
            return this.f28863a;
        }

        public final void a(int r1) {
            this.f28863a = r1;
        }

        public final void a(boolean r1) {
            this.f28864b = r1;
        }

        public final boolean b() {
            return this.f28864b;
        }

        public final void b(boolean r1) {
            this.f28865c = r1;
        }

        public final boolean c() {
            return this.f28865c;
        }
    }

    /* JADX INFO: compiled from: OmniUploadTaskLifecycle.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlinx.coroutines.f.a f28866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f28867b;

        /* JADX WARN: Multi-variable type inference failed */
        public d() {
            this(null, 0, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f28866a, r6.f28866a) == true) goto L12;
            return false;
        L12:
            if (this.f28867b == r6.f28867b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f28866a.hashCode() * 31) + Integer.hashCode(this.f28867b);
        }

        public String toString() {
            return "TaskMutexEntry(mutex=" + this.f28866a + ", users=" + this.f28867b + ')';
        }

        public d(kotlinx.coroutines.f.a r3, int r4) {
            kotlinx.coroutines.f.a r5 = (kotlinx.coroutines.f.a) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "mutex");
            this.f28866a = r5;
            this.f28867b = r4;
        }

        public /* synthetic */ d(kotlinx.coroutines.f.a r2, int r3, int r4, d.h.b.h r5) {
            kotlinx.coroutines.f.a r6 = (kotlinx.coroutines.f.a) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r6 = kotlinx.coroutines.f.c.a(false, 1, null);
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = 0;
        L8:
            this(r6, r3);
        }

        public final kotlinx.coroutines.f.a a() {
            return this.f28866a;
        }

        public final void a(int r1) {
            this.f28867b = r1;
        }

        public final int b() {
            return this.f28867b;
        }
    }

    /* JADX INFO: compiled from: OmniUploadTaskLifecycle.kt */
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28868a = null;

        static {
            int[] r0 = new int[x.values().length];
            r0[x.f28882c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[x.f28881b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[x.f28880a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[x.f28883d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f28868a = r0;
        }
    }

    /* JADX INFO: compiled from: OmniUploadTaskLifecycle.kt */
    @d.c.b.a.f(b = "OmniUploadTaskLifecycle.kt", c = {210}, d = "withTaskFileLock$operator_release", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniUploadTaskLifecycle")
    static final class f<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28872d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f28873e;
        /* synthetic */ Object f;
        final /* synthetic */ v g;
        int h;

        f(v r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniUploadTaskLifecycle.kt */
    @d.c.b.a.f(b = "OmniUploadTaskLifecycle.kt", c = {224, 226}, d = "withTaskUploadLock$operator_release", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniUploadTaskLifecycle")
    static final class g<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28877d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f28878e;
        /* synthetic */ Object f;
        final /* synthetic */ v g;
        int h;

        g(v r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private v() {
    }

    public static final /* synthetic */ void a(v r0, String r1) {
        r0.i(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f28855a = new v();
        f28856b = new Object();
        f28857c = new y(null, 1, 0 == true ? 1 : 0);
        f28858d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        f28859e = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        f = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
    }

    public final void a(String r10) {
        d.h.b.o.e(r10, DBDefinition.TASK_ID);
        String r11 = l(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        b();
        Object r9 = f28856b;
        monitor-enter(r9);
        f.remove(r11);     // Catch: Throwable -> L17
        boolean r0 = com.obric.autogui.common.a.d.f28974a.D();     // Catch: Throwable -> L17
        if (r0 == false) goto L10;
        f28857c.a(r11, x.f28881b);     // Catch: Throwable -> L17
        f28858d.put(r11, new c(0, false, false, 7, null));     // Catch: Throwable -> L17
    L12:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L14;
        Loog.INSTANCE.i(TAG, "task created, taskId=" + r11 + ", streamingIdleEnabled=" + r0);     // Catch: Throwable -> L17
    L14:
        d.x r12 = d.x.f38692a;     // Catch: Throwable -> L17
        monitor-exit(r9);
        return;
    L10:
        f28857c.b(r11);     // Catch: Throwable -> L17
        f28858d.remove(r11);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final void b(String r9) {
        d.h.b.o.e(r9, DBDefinition.TASK_ID);
        String r10 = l(r9);
        if (r10 != null) goto L5;
        return;
    L5:
        b();
        Object r8 = f28856b;
        monitor-enter(r8);
        y r0 = f28857c;     // Catch: Throwable -> L18
        if (r0.a(r10) != x.f28881b) goto L15;
        r0.a(r10, x.f28882c);     // Catch: Throwable -> L18
        Map<String, c> r1 = f28858d;     // Catch: Throwable -> L18
        if (r1.get(r10) != null) goto L13;
        r1.put(r10, new c(0, false, false, 7, null));     // Catch: Throwable -> L18
    L13:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L15;
        Loog.INSTANCE.i(TAG, "finish requested, taskId=" + r10);     // Catch: Throwable -> L18
    L15:
        d.x r11 = d.x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(r8);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final void c(String r12) {
        d.h.b.o.e(r12, DBDefinition.TASK_ID);
        String r13 = l(r12);
        if (r13 != null) goto L5;
        return;
    L5:
        b();
        Object r0 = f28856b;
        monitor-enter(r0);
        y r1 = f28857c;     // Catch: Throwable -> L21
        x r2 = r1.a(r13);     // Catch: Throwable -> L21
        int r3 = e.f28868a[r2.ordinal()];     // Catch: Throwable -> L21
        boolean r4 = false;
        if (r3 != 1) goto L10;
        Map<String, c> r5 = f28858d;     // Catch: Throwable -> L21
        c r6 = r5.get(r13);     // Catch: Throwable -> L21
        if (r6 != null) goto L16;
        r6 = new c(0, false, false, 7, null);     // Catch: Throwable -> L21
        r5.put(r13, r6);     // Catch: Throwable -> L21
    L16:
        ((c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.aiagent.plugin")).a(true);     // Catch: Throwable -> L21
        r4 = f28855a.j(r13);     // Catch: Throwable -> L21
    L17:
        monitor-exit(r0);
        if (r4 == false) goto L25;
        k(r13);
        return;
    L25:
        return;
    L10:
        if (r3 != 2) goto L17;
        r1.b(r13);     // Catch: Throwable -> L21
        f28858d.remove(r13);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public final void d(String r10) {
        d.h.b.o.e(r10, DBDefinition.TASK_ID);
        String r11 = l(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        b();
        Object r0 = f28856b;
        monitor-enter(r0);
        x r1 = f28857c.a(r11);     // Catch: Throwable -> L20
        if (r1 != x.f28881b) goto L10;
    L12:
        Map<String, c> r2 = f28858d;     // Catch: Throwable -> L20
        c r3 = r2.get(r11);     // Catch: Throwable -> L20
        if (r3 != null) goto L15;
        r3 = new c(0, false, false, 7, null);     // Catch: Throwable -> L20
        r2.put(r11, r3);     // Catch: Throwable -> L20
    L15:
        ((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin")).b(true);     // Catch: Throwable -> L20
        boolean r4 = f28855a.j(r11);     // Catch: Throwable -> L20
    L16:
        monitor-exit(r0);
        if (r4 == false) goto L25;
        k(r11);
        return;
    L25:
        return;
    L10:
        if (r1 == x.f28882c) goto L12;
        r4 = false;
    L20:
        th = move-exception;
        throw th;
    }

    public final Closeable e(String r11) {
        d.h.b.o.e(r11, DBDefinition.TASK_ID);
        String r12 = l(r11);
        if (r12 == null) goto L5;
        b();
        Object r10 = f28856b;
        monitor-enter(r10);
    L35:
        th = move-exception;
        throw th;
    L9:
        Closeable r1 = null;
        if (f.contains(r12) == false) goto L13;
        monitor-exit(r10);
        return null;
    L13:
        x r0 = f28857c.a(r12);     // Catch: Throwable -> L35
        int r2 = e.f28868a[r0.ordinal()];     // Catch: Throwable -> L35
        if (r2 != 1) goto L16;
    L25:
        Map<String, c> r3 = f28858d;     // Catch: Throwable -> L35
        c r4 = r3.get(r12);     // Catch: Throwable -> L35
        if (r4 != null) goto L28;
        r4 = new c(0, false, false, 7, null);     // Catch: Throwable -> L35
        r3.put(r12, r4);     // Catch: Throwable -> L35
    L28:
        c r5 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        if (r5.c() == true) goto L32;
        r5.a(r5.a() + 1);     // Catch: Throwable -> L35
        r1 = new b(r12);     // Catch: Throwable -> L35
    L32:
        r1 = (Closeable) ZeusTransformUtils.preCheckCast(r1, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
    L33:
        monitor-exit(r10);
        return r1;
    L16:
        if (r2 == 2) goto L25;
        if (r2 != 3) goto L20;
        r1 = (Closeable) ZeusTransformUtils.preCheckCast(a.f28860a, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        goto L33
    L20:
        if (r2 == 4) goto L33;
        throw new d.k();     // Catch: Throwable -> L35
    L5:
        return (Closeable) ZeusTransformUtils.preCheckCast(a.f28860a, Closeable.class, "com.obric.aiagent.plugin");
    }

    public final x f(String r2) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        String r3 = l(r2);
        if (r3 == null) goto L5;
        b();
        Object r1 = f28856b;
        monitor-enter(r1);
        x r4 = f28857c.a(r3);     // Catch: Throwable -> L11
        monitor-exit(r1);
        return r4;
    L11:
        th = move-exception;
        throw th;
    L5:
        return x.f28880a;
    }

    public final Set<String> a() {
        b();
        Object r1 = f28856b;
        monitor-enter(r1);
        Set<String> r0 = f28857c.a();     // Catch: Throwable -> L7
        monitor-exit(r1);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public final void g(String r5) {
        d.h.b.o.e(r5, DBDefinition.TASK_ID);
        String r6 = l(r5);
        if (r6 != null) goto L5;
        return;
    L5:
        b();
        Object r4 = f28856b;
        monitor-enter(r4);
        y r0 = f28857c;     // Catch: Throwable -> L15
        if (r0.a(r6) != x.f28883d) goto L12;
        r0.b(r6);     // Catch: Throwable -> L15
        f28858d.remove(r6);     // Catch: Throwable -> L15
        f.add(r6);     // Catch: Throwable -> L15
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L12;
        Loog.INSTANCE.i(TAG, "terminal upload acknowledged, taskId=" + r6);     // Catch: Throwable -> L15
    L12:
        d.x r7 = d.x.f38692a;     // Catch: Throwable -> L15
        monitor-exit(r4);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final <T> Object a(String r8, d.h.a.a<? extends T> r9, d.c.d<? super T> r10) {
        d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r12, f.class, "com.obric.aiagent.plugin");
        if ((r0.h & Integer.MIN_VALUE) == 0) goto L7;
        r0.h -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f;
        Object r2 = d.c.a.b.a();
        int r3 = r0.h;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        int r7 = r0.f28873e;
        d r14 = (d) ZeusTransformUtils.preCheckCast(r0.f28872d, d.class, "com.obric.aiagent.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r0.f28871c, String.class, "com.obric.aiagent.plugin");
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.preCheckCast(r0.f28870b, d.h.a.a.class, "com.obric.aiagent.plugin");
        v r1 = (v) ZeusTransformUtils.preCheckCast(r0.f28869a, v.class, "com.obric.aiagent.plugin");
        d.o.a(r13);     // Catch: Throwable -> L14
        String r16 = r15;
        v this = r1;
        r11 = r4;
    L40:
        Object r17 = r11.invoke();     // Catch: Throwable -> L30
        kotlinx.coroutines.f.a.C1058a.b(r14.a(), null, 1, null);
        this.a(r16, r14);
        return r17;
    L30:
        th = move-exception;
        r1 = this;
        r7 = 1;
        String r6 = r16;
        Throwable th = th;
        r15 = r6;
    L34:
        if (r7 == 0) goto L36;
        kotlinx.coroutines.f.a.C1058a.b(r14.a(), null, 1, null);
    L36:
        r1.a(r15, r14);
        throw th;
    L14:
        th = th;
        goto L34
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r13);
        String r18 = l(r8);
        if (r18 == null) goto L22;
        r8 = r18;
    L22:
        d r19 = h(r8);
        kotlinx.coroutines.f.a r5 = r19.a();     // Catch: Throwable -> L32
        r0.f28869a = this;     // Catch: Throwable -> L32
        r0.f28870b = r11;     // Catch: Throwable -> L32
        r0.f28871c = r8;     // Catch: Throwable -> L32
        r0.f28872d = r19;     // Catch: Throwable -> L32
        r0.f28873e = 0;     // Catch: Throwable -> L32
        r0.h = 1;     // Catch: Throwable -> L32
        if (kotlinx.coroutines.f.a.C1058a.a(r5, null, r0, 1, null) != r2) goto L26;
        return r2;
    L26:
        r16 = r8;
        r14 = r19;
    L32:
        th = move-exception;
        r1 = this;
        r7 = 0;
        r15 = r8;
        r14 = r19;
        th = th;
    L7:
        r0 = new f(this, r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Class, java.lang.Class<com.obric.autogui.agents.vlm.models.omni.upload.v>] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.autogui.agents.vlm.models.omni.upload.v] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.autogui.agents.vlm.models.omni.upload.v] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.obric.autogui.agents.vlm.models.omni.upload.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v11, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v8, types: [com.obric.autogui.agents.vlm.models.omni.upload.v$d] */
    /* JADX WARN: Type inference failed for: r12v9, types: [com.obric.autogui.agents.vlm.models.omni.upload.v$d] */
    /* JADX WARN: Type inference failed for: r13v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v14, types: [d.h.a.b] */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v2, types: [d.h.a.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    public final <T> Object a(String r12, d.h.a.b<? super d.c.d<? super T>, ? extends Object> r13, d.c.d<? super T> r14) {
        ?? r0 = v.class;
        ?? r15 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, g.class) == false) goto L7;
        g r1 = (g) ZeusTransformUtils.preCheckCast(r16, g.class, "com.obric.aiagent.plugin");
        if ((r1.h & Integer.MIN_VALUE) == 0) goto L7;
        r1.h -= Integer.MIN_VALUE;
    L8:
        Object r17 = r1.f;
        Object r3 = d.c.a.b.a();
        int r4 = r1.h;
        if (r4 != 0) goto L47;
        d.o.a(r17);
        String r18 = l(r12);
        ?? r19 = r12;
        if (r18 == null) goto L26;
        r19 = r18;
    L26:
        d r110 = h(r19);
        kotlinx.coroutines.f.a r2 = r110.a();     // Catch: Throwable -> L41
        r1.f28874a = this;     // Catch: Throwable -> L41
        r1.f28875b = r15;     // Catch: Throwable -> L41
        r1.f28876c = r19;     // Catch: Throwable -> L41
        r1.f28877d = r110;     // Catch: Throwable -> L41
        r1.f28878e = 0;     // Catch: Throwable -> L41
        r1.h = 1;     // Catch: Throwable -> L41
        if (kotlinx.coroutines.f.a.C1058a.a(r2, null, r1, 1, null) != r3) goto L30;
        return r3;
    L30:
        ?? r111 = r19;
        r12 = r110;
        ?? r11 = this;
        ?? r112 = r15;
    L48:
        r1.f28874a = r11;     // Catch: Throwable -> L39
        r1.f28875b = r111;     // Catch: Throwable -> L39
        r1.f28876c = r12;     // Catch: Throwable -> L39
        r1.f28877d = null;     // Catch: Throwable -> L39
        r1.f28878e = 1;     // Catch: Throwable -> L39
        r1.h = 2;     // Catch: Throwable -> L39
        Object r113 = r112.invoke(r1);     // Catch: Throwable -> L39
        if (r113 != r3) goto L34;
        return r3;
    L34:
        ?? r5 = r11;
        int r114 = 1;
        ?? r9 = r111;
        r17 = r113;
        ?? r115 = r9;
        ?? r116 = r12;
    L35:
        if (r114 == 0) goto L37;
        kotlinx.coroutines.f.a.C1058a.b(r116.a(), null, 1, null);
    L37:
        r5.a(r115, r116);
        return r17;
    L39:
        th = move-exception;
        r0 = r11;
        v this = 1;
        ?? r10 = r111;
        th = th;
        r15 = r10;
    L43:
        if (this == 0) goto L45;
        kotlinx.coroutines.f.a.C1058a.b(r12.a(), null, 1, null);
    L45:
        r0.a(r15, r12);
        throw th;
    L41:
        th = move-exception;
        r0 = this;
        this = 0;
        r15 = r19;
        r12 = r110;
        th = th;
        goto L43
    L47:
        if (r4 == 1) goto L17;
        if (r4 != 2) goto L16;
        r114 = r1.f28878e;
        d r117 = (d) ZeusTransformUtils.preCheckCast(r1.f28876c, d.class, "com.obric.aiagent.plugin");
        String r118 = (String) ZeusTransformUtils.preCheckCast(r1.f28875b, String.class, "com.obric.aiagent.plugin");
        v r6 = (v) ZeusTransformUtils.preCheckCast(r1.f28874a, r0, "com.obric.aiagent.plugin");
        d.o.a(r17);     // Catch: Throwable -> L20
        r5 = r6;
        r116 = r117;
        r115 = r118;
        goto L35
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r119 = r1.f28878e;
        d r120 = (d) ZeusTransformUtils.preCheckCast(r1.f28877d, d.class, "com.obric.aiagent.plugin");
        String r121 = (String) ZeusTransformUtils.preCheckCast(r1.f28876c, String.class, "com.obric.aiagent.plugin");
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r1.f28875b, d.h.a.b.class, "com.obric.aiagent.plugin");
        v r8 = (v) ZeusTransformUtils.preCheckCast(r1.f28874a, r0, "com.obric.aiagent.plugin");
        d.o.a(r17);     // Catch: Throwable -> L20
        r111 = r121;
        r11 = r8;
        r112 = r7;
        r12 = r120;
    L20:
        th = th;
    L7:
        r1 = new g(this, r16);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final d h(String r6) {
        Object r5 = f28856b;
        monitor-enter(r5);
        Map<String, d> r0 = f28859e;     // Catch: Throwable -> L10
        d r1 = r0.get(r6);     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        kotlinx.coroutines.f.a r4 = null;
        r1 = new d(r4, 0, 3, 0 == true ? 1 : 0);     // Catch: Throwable -> L10
        r0.put(r6, r1);     // Catch: Throwable -> L10
    L7:
        d r7 = (d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        r7.a(r7.b() + 1);     // Catch: Throwable -> L10
        d r8 = (d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        monitor-exit(r5);
        return r8;
    L10:
        th = move-exception;
        throw th;
    }

    private final void a(String r3, d r4) {
        Object r2 = f28856b;
        monitor-enter(r2);
        r4.a(r4.b() - 1);     // Catch: Throwable -> L12
        if (r4.b() != 0) goto L9;
        Map<String, d> r0 = f28859e;     // Catch: Throwable -> L12
        if (r0.get(r3) != r4) goto L9;
        r0.remove(r3);     // Catch: Throwable -> L12
    L9:
        d.x r5 = d.x.f38692a;     // Catch: Throwable -> L12
        monitor-exit(r2);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private final void i(String r5) {
        Object r0 = f28856b;
        monitor-enter(r0);
        c r1 = (c) ZeusTransformUtils.preCheckCast(f28858d.get(r5), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        boolean r2 = false;
        if (r1 == null) goto L8;
        r1.a(d.l.n.c(r1.a() - 1, 0));     // Catch: Throwable -> L12
        r2 = f28855a.j(r5);     // Catch: Throwable -> L12
    L8:
        monitor-exit(r0);
        if (r2 == false) goto L17;
        k(r5);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private final boolean j(String r6) {
        c r5 = (c) ZeusTransformUtils.preCheckCast(f28858d.get(r6), c.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return false;
    L5:
        y r1 = f28857c;
        if (w.a(r1.a(r6), r5.b(), r5.c(), r5.a()) == true) goto L8;
        return false;
    L8:
        r1.a(r6, x.f28883d);
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L13;
        Loog.INSTANCE.i(TAG, "producer barrier closed, task finished, taskId=" + r6);
        return true;
    L13:
        return true;
    }

    private final void k(String r1) {
        com.obric.autogui.agents.vlm.models.omni.upload.e.f28643a.a(r1);
    }

    private final void b() {
        if (g == false) goto L5;
        return;
    L5:
        Object r1 = f28856b;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (g == false) goto L11;
        monitor-exit(r1);
        return;
    L11:
        f28857c.b();     // Catch: Throwable -> L14
        g = true;     // Catch: Throwable -> L14
        d.x r0 = d.x.f38692a;     // Catch: Throwable -> L14
        monitor-exit(r1);
    }

    private final String l(String r1) {
        return w.a(r1);
    }
}
