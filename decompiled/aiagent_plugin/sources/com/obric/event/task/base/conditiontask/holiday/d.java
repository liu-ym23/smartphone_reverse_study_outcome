package com.obric.event.task.base.conditiontask.holiday;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.g;
import d.h.a.m;
import d.o;
import d.x;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: HolidaysDownloader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private static final String TAG = "HolidaysDownloader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f32721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f32722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.f f32723c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f32724d;

    /* JADX INFO: compiled from: HolidaysDownloader.kt */
    @d.c.b.a.f(b = "HolidaysDownloader.kt", c = {129}, d = "invokeSuspend", e = "com.obric.event.task.base.conditiontask.holiday.HolidaysDownloader$checkUpdate$1")
    static final class a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f32726b;

        a(Context r3, d.c.d<? super a> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32726b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f32726b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f32725a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r12);
        L21:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r12);
            d r13 = d.f32721a;
            Context r2 = this.f32726b;
            monitor-enter(r13);
            long r3 = System.currentTimeMillis();     // Catch: Throwable -> L22
            long r5 = com.obric.event.task.base.conditiontask.holiday.b.f32694a.a(r2, 0);     // Catch: Throwable -> L22
            com.obric.event.task.base.b.b.f32684a.b(d.TAG, "checkUpdate current time = " + r3 + "; last checked time = " + r5);     // Catch: Throwable -> L22
            if (r3 >= (r5 + 86400000)) goto L15;
            x r11 = x.f38692a;     // Catch: Throwable -> L22
            monitor-exit(r13);
            return r11;
        L15:
            com.obric.event.task.base.conditiontask.holiday.b.f32694a.b(r2, r3);     // Catch: Throwable -> L22
            x r4 = x.f38692a;     // Catch: Throwable -> L22
            monitor-exit(r13);
            Context r14 = this.f32726b;
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32725a = 1;
            if (d.a(r14, r6) != r0) goto L21;
            return r0;
        L22:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: HolidaysDownloader.kt */
    @d.c.b.a.f(b = "HolidaysDownloader.kt", c = {103}, d = "getHolidays", e = "com.obric.event.task.base.conditiontask.holiday.HolidaysDownloader")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f32727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f32728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f32729c;

        b(d r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32728b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f32727a = r3;
            this.f32729c |= Integer.MIN_VALUE;
            return d.b(this.f32728b, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: HolidaysDownloader.kt */
    @d.c.b.a.f(b = "HolidaysDownloader.kt", c = {93}, d = "getVersion", e = "com.obric.event.task.base.conditiontask.holiday.HolidaysDownloader")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f32730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f32731b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f32732c;

        c(d r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32731b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f32730a = r3;
            this.f32732c |= Integer.MIN_VALUE;
            return d.a(this.f32731b, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.event.task.base.conditiontask.holiday.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HolidaysDownloader.kt */
    @d.c.b.a.f(b = "HolidaysDownloader.kt", c = {50, 57}, d = "loadHolidaysData", e = "com.obric.event.task.base.conditiontask.holiday.HolidaysDownloader")
    static final class C0899d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f32733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f32734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f32735c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f32736d;

        C0899d(d r3, d.c.d<? super C0899d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32735c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f32734b = r3;
            this.f32736d |= Integer.MIN_VALUE;
            return d.a(this.f32735c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: HolidaysDownloader.kt */
    @d.c.b.a.f(b = "HolidaysDownloader.kt", c = {39, 40}, d = "loadIfNeeded", e = "com.obric.event.task.base.conditiontask.holiday.HolidaysDownloader")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f32737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f32738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f32739c;

        e(d.c.d<? super e> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f32738b = r2;
            this.f32739c |= Integer.MIN_VALUE;
            return d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: HolidaysDownloader.kt */
    @d.c.b.a.f(b = "HolidaysDownloader.kt", c = {}, d = "invokeSuspend", e = "com.obric.event.task.base.conditiontask.holiday.HolidaysDownloader$loadIfNeeded$2")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f32741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f32742c;

        f(Context r3, boolean r4, d.c.d<? super f> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32741b = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            this.f32742c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f32741b, this.f32742c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f32740a != 0) goto L7;
            o.a(r2);
            d.a(d.f32721a, this.f32741b, this.f32742c);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: lambda$HfMdIgC5OoknW8WG7-g9tvIAMmM, reason: not valid java name */
    public static /* synthetic */ HolidaysApi m941lambda$HfMdIgC5OoknW8WG7g9tvIAMmM() {
        return b();
    }

    private d() {
    }

    public static final /* synthetic */ Object a(d r2, Context r3, d.c.d r4) {
        return r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(d r2, Context r3, boolean r4) {
        r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ Object b(d r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f32721a = new d();
        f32723c = g.a($$Lambda$d$HfMdIgC5OoknW8WG7g9tvIAMmM.INSTANCE);
    }

    private final HolidaysApi a() {
        Object r2 = f32723c.b();
        d.h.b.o.c(r2, "getValue(...)");
        return (HolidaysApi) ZeusTransformUtils.preCheckCast(r2, HolidaysApi.class, "com.obric.aiagent.plugin");
    }

    private static final HolidaysApi b() {
        return (HolidaysApi) ZeusTransformUtils.preCheckCast(com.bytedance.ttnet.utils.d.b("https://lf-calendarholidays.oceancloudapi.com/").a(HolidaysApi.class), HolidaysApi.class, "com.obric.aiagent.plugin");
    }

    public static final Object a(Context r7, d.c.d<? super x> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r10, e.class, "com.obric.aiagent.plugin");
        if ((r0.f32739c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f32739c -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f32738b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f32739c;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        o.a(r11);
    L23:
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = (Context) ZeusTransformUtils.preCheckCast(r0.f32737a, Context.class, "com.obric.aiagent.plugin");
        o.a(r11);
    L19:
        boolean r12 = ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        d.c.g r4 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin");
        m r13 = (m) ZeusTransformUtils.preCheckCast(new f(r9, r12, null), m.class, "com.obric.aiagent.plugin");
        r0.f32737a = null;
        r0.f32739c = 2;
        if (i.a(r4, r13, r0) != r2) goto L23;
        return r2;
    L16:
        o.a(r11);
        d r14 = f32721a;
        f32724d = com.obric.event.task.base.conditiontask.holiday.b.f32694a.a(r9, 2023);
        r0.f32737a = r9;
        r0.f32739c = 1;
        r11 = r14.b(r9, r0);
        if (r11 != r2) goto L19;
        return r2;
    L7:
        r0 = new e(r10);
        goto L8
    }

    private final Object b(Context r9, d.c.d<? super Boolean> r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, C0899d.class) == false) goto L7;
        C0899d r1 = (C0899d) ZeusTransformUtils.preCheckCast(r12, C0899d.class, "com.obric.aiagent.plugin");
        if ((r1.f32736d & Integer.MIN_VALUE) == 0) goto L7;
        r1.f32736d -= Integer.MIN_VALUE;
    L8:
        Object r13 = r1.f32734b;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f32736d;
        boolean r5 = false;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        d this = (d) ZeusTransformUtils.preCheckCast(r1.f32733a, d.class, "com.obric.aiagent.plugin");
        o.a(r13);
    L27:
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L31;
        r5 = this.a(r14, f32722b + "holidays.xml");
    L31:
        return d.c.b.a.b.a(r5);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        this = (d) ZeusTransformUtils.preCheckCast(r1.f32733a, d.class, "com.obric.aiagent.plugin");
        o.a(r13);
    L22:
        int r15 = ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r15 <= f32724d) goto L33;
        f32724d = r15;
        r1.f32733a = this;
        r1.f32736d = 2;
        r13 = this.b(r1);
        if (r13 != r3) goto L27;
        return r3;
    L33:
        return d.c.b.a.b.a(false);
    L16:
        o.a(r13);
        if (f32722b != null) goto L19;
        f32722b = r11.getFilesDir().getPath() + File.separator;
    L19:
        r1.f32733a = this;
        r1.f32736d = 1;
        r13 = a(r1);
        if (r13 != r3) goto L22;
        return r3;
    L7:
        r1 = new C0899d(this, r12);
        goto L8
    }

    private final void a(Context r3, boolean r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        com.obric.event.task.base.conditiontask.holiday.b.f32694a.b(r2, f32724d);
        if (r4 == false) goto L5;
        com.obric.event.task.base.b.b.f32684a.b(TAG, "onPostExecute load holidays succeeded for year " + f32724d);
        com.obric.event.task.base.conditiontask.holiday.c.a(r2);
        return;
    L5:
        com.obric.event.task.base.b.b.f32684a.b(TAG, "onPostExecute no need to update holidays.");
    }

    private final boolean a(String r4, String r5) {
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(new File(r5)), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L13
        FileOutputStream r1 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r6, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        byte[] r7 = r4.getBytes(d.o.d.f38623b);     // Catch: Throwable -> L8
        d.h.b.o.c(r7, "getBytes(...)");     // Catch: Throwable -> L8
        r1.write(r7);     // Catch: Throwable -> L8
        r1.flush();     // Catch: Throwable -> L8
        x r8 = x.f38692a;     // Catch: Throwable -> L8
        d.f.c.a(r6, null);     // Catch: Exception -> L13
        return true;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        d.f.c.a(r6, th);     // Catch: Exception -> L13
        throw th;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        com.obric.event.task.base.b.b.f32684a.b(TAG, "loadFile Error saving file", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }

    private final Object a(d.c.d<? super Integer> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin");
        if ((r0.f32732c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f32732c -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f32730a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f32732c;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        o.a(r8);     // Catch: Exception -> L13
    L21:
        return d.c.b.a.b.a(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin")));
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        o.a(r8);
        HolidaysApi r5 = a();     // Catch: Exception -> L13
        r0.f32732c = 1;     // Catch: Exception -> L13
        r8 = r5.getVersion(r0);     // Catch: Exception -> L13
        if (r8 != r2) goto L21;
        return r2;
    L13:
        e = move-exception;
        com.obric.event.task.base.b.b.f32684a.b(TAG, "getVersion Error parsing version", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return d.c.b.a.b.a(0);
    L7:
        r0 = new c(this, r7);
        goto L8
    }

    private final Object b(d.c.d<? super String> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
        if ((r0.f32729c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f32729c -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f32727a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f32729c;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        o.a(r8);     // Catch: Exception -> L13
    L21:
        return (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        o.a(r8);
        HolidaysApi r5 = a();     // Catch: Exception -> L13
        r0.f32729c = 1;     // Catch: Exception -> L13
        r8 = r5.downloadHolidaysXml(r0);     // Catch: Exception -> L13
        if (r8 != r2) goto L21;
        return r2;
    L13:
        e = move-exception;
        com.obric.event.task.base.b.b.f32684a.b(TAG, "Error downloading holidays", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    L7:
        r0 = new b(this, r7);
        goto L8
    }

    public static final void a(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "context");
        i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new a(r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
