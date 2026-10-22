package com.obric.aiagent.skill.ovirt.impl.ui;

import android.content.Context;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.ovirt.api.IOVirtService;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.f.k;
import d.h.b.ad;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.x;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: ShellManagementRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "SkRt/ShellMgmt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f21521a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f21522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f21523c;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.ui.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShellManagementRepository.kt */
    public static abstract class AbstractC0451a {

        /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.ui.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ShellManagementRepository.kt */
        public static final class C0452a extends AbstractC0451a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0452a f21524a = null;

            static {
                f21524a = new C0452a();
            }

            private C0452a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.ui.a$a$b */
        /* JADX INFO: compiled from: ShellManagementRepository.kt */
        public static final class b extends AbstractC0451a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f21525a = null;

            static {
                f21525a = new b();
            }

            private b() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.ui.a$a$c */
        /* JADX INFO: compiled from: ShellManagementRepository.kt */
        public static final class c extends AbstractC0451a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f21526a = null;

            static {
                f21526a = new c();
            }

            private c() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.ui.a$a$d */
        /* JADX INFO: compiled from: ShellManagementRepository.kt */
        public static final class d extends AbstractC0451a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f21527a = null;

            static {
                f21527a = new d();
            }

            private d() {
                super(null);
            }
        }

        public /* synthetic */ AbstractC0451a(h r1) {
            this();
        }

        private AbstractC0451a() {
        }
    }

    /* JADX INFO: compiled from: ShellManagementRepository.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }

        public final String a(long r8) {
            if (r8 >= 1048576) goto L6;
            return n.a(d.i.a.b(r8 / 1024), 0) + " KB";
        L6:
            if (r8 >= DownloadConstants.GB) goto L9;
            return a(r8, 1048576, "MB");
        L9:
            return a(r8, DownloadConstants.GB, "GB");
        }

        private final String a(long r3, long r5, String r7) {
            double r2 = r3 / r5;
            if (r2 < 10.0d) goto L5;
            String r4 = "%.0f %s";
        L6:
            ad r6 = ad.f38485a;
            String r8 = String.format(Locale.US, r4, Arrays.copyOf(new Object[]{Double.valueOf(r2), r7}, 2));
            o.c(r8, "format(...)");
            return r8;
        L5:
            r4 = "%.1f %s";
            goto L6
        }
    }

    /* JADX INFO: compiled from: ShellManagementRepository.kt */
    public static abstract class c {

        /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.ui.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ShellManagementRepository.kt */
        public static final class C0453a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0453a f21528a = null;

            static {
                f21528a = new C0453a();
            }

            private C0453a() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ShellManagementRepository.kt */
        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f21529a = null;

            static {
                f21529a = new b();
            }

            private b() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.ui.a$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ShellManagementRepository.kt */
        public static final class C0454c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f21530a;

            public boolean equals(Object r7) {
                if (this != r7) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r7, C0454c.class) == true) goto L8;
                return false;
            L8:
                C0454c r8 = (C0454c) ZeusTransformUtils.preCheckCast(r7, C0454c.class, "com.obric.aiagent.plugin");
                if (this.f21530a == r8.f21530a) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return Long.hashCode(this.f21530a);
            }

            public String toString() {
                return "Success(bytes=" + this.f21530a + ')';
            }

            public C0454c(long r2) {
                super(null);
                this.f21530a = r2;
            }

            public final long a() {
                return this.f21530a;
            }
        }

        /* JADX INFO: compiled from: ShellManagementRepository.kt */
        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f21531a = null;

            static {
                f21531a = new d();
            }

            private d() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ShellManagementRepository.kt */
        public static final class e extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f21532a = null;

            static {
                f21532a = new e();
            }

            private e() {
                super(null);
            }
        }

        public /* synthetic */ c(h r1) {
            this();
        }

        private c() {
        }
    }

    /* JADX INFO: compiled from: ShellManagementRepository.kt */
    @f(b = "ShellManagementRepository.kt", c = {46}, d = "calculateHomeUsageBytes", e = "com.obric.aiagent.skill.ovirt.impl.ui.ShellManagementRepository")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f21535c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f21536d;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21535c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21534b = r3;
            this.f21536d |= Integer.MIN_VALUE;
            return this.f21535c.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShellManagementRepository.kt */
    @f(b = "ShellManagementRepository.kt", c = {63}, d = "clearHome", e = "com.obric.aiagent.skill.ovirt.impl.ui.ShellManagementRepository")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f21538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f21539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f21540d;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f21539c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f21538b = r3;
            this.f21540d |= Integer.MIN_VALUE;
            return this.f21539c.b((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f21521a = new b(null);
    }

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        Context r5 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f21522b = r5;
        this.f21523c = new File(r5.getFilesDir(), "skillruntime/shell-management/home-size.json");
    }

    public static /* synthetic */ Long a(a r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = System.currentTimeMillis();
    L6:
        return r0.a(r1);
    }

    public final Long a(long r9) {
        boolean r1 = true;
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r8 = d.n.f(new JSONObject(k.a(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f21523c, null, 1, null)));     // Catch: Throwable -> L5
    L8:
        if (d.n.b(r8) == false) goto L10;
        r8 = null;
    L10:
        JSONObject r10 = (JSONObject) ZeusTransformUtils.preCheckCast(r8, JSONObject.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L13;
        return null;
    L13:
        long r6 = r10.optLong("cached_at_ms", 0);
        if (r6 > 0) goto L16;
        return null;
    L16:
        if ((r9 - r6) > 600000) goto L29;
        Long r11 = Long.valueOf(r10.optLong("bytes", -1));
        if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).longValue() >= 0) goto L22;
        r1 = false;
    L22:
        if (r1 == true) goto L24;
        return null;
    L24:
        return r11;
    L29:
        return null;
    L5:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L8
    }

    public final Object a(d.c.d<? super c> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.aiagent.plugin");
        if ((r0.f21536d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21536d -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f21534b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21536d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        a this = (a) ZeusTransformUtils.preCheckCast(r0.f21533a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
    L21:
        com.obric.aiagent.skill.ovirt.api.a r9 = (com.obric.aiagent.skill.ovirt.api.a) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.ovirt.api.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, com.obric.aiagent.skill.ovirt.api.a.c.class) == false) goto L25;
        this.b(((Number) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.ovirt.api.a.c) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.ovirt.api.a.c.class, "com.obric.aiagent.plugin")).a(), Number.class, "com.obric.aiagent.plugin")).longValue());
        return (c) ZeusTransformUtils.preCheckCast(new c.C0454c(((Number) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.ovirt.api.a.c) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.ovirt.api.a.c.class, "com.obric.aiagent.plugin")).a(), Number.class, "com.obric.aiagent.plugin")).longValue()), c.class, "com.obric.aiagent.plugin");
    L25:
        if (o.a(r9, com.obric.aiagent.skill.ovirt.api.a.C0438a.f20940a) == false) goto L28;
        return (c) ZeusTransformUtils.preCheckCast(c.C0453a.f21528a, c.class, "com.obric.aiagent.plugin");
    L28:
        if (o.a(r9, com.obric.aiagent.skill.ovirt.api.a.d.f20943a) == false) goto L31;
        return (c) ZeusTransformUtils.preCheckCast(c.d.f21531a, c.class, "com.obric.aiagent.plugin");
    L31:
        if (o.a(r9, com.obric.aiagent.skill.ovirt.api.a.e.f20944a) == false) goto L34;
        return (c) ZeusTransformUtils.preCheckCast(c.e.f21532a, c.class, "com.obric.aiagent.plugin");
    L34:
        if (ZeusTransformUtils.instanceOf(r9, com.obric.aiagent.skill.ovirt.api.a.b.class) == false) goto L38;
        this.a("calculateHomeUsageBytes failed", ((com.obric.aiagent.skill.ovirt.api.a.b) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.ovirt.api.a.b.class, "com.obric.aiagent.plugin")).a());
        return (c) ZeusTransformUtils.preCheckCast(c.b.f21529a, c.class, "com.obric.aiagent.plugin");
    L38:
        throw new d.k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        IOVirtService r10 = IOVirtService.Companion.a();
        if (r10 == null) goto L17;
        IOVirtService.c r11 = r10.getMaintenance();
        r0.f21533a = this;
        r0.f21536d = 1;
        r8 = r11.a(r0);
        if (r8 != r2) goto L21;
        return r2;
    L17:
        return c.e.f21532a;
    L7:
        r0 = new d(this, r7);
        goto L8
    }

    public final Object b(d.c.d<? super AbstractC0451a> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.aiagent.plugin");
        if ((r0.f21540d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f21540d -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f21538b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f21540d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        a this = (a) ZeusTransformUtils.preCheckCast(r0.f21537a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
    L21:
        com.obric.aiagent.skill.ovirt.api.a r9 = (com.obric.aiagent.skill.ovirt.api.a) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.ovirt.api.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, com.obric.aiagent.skill.ovirt.api.a.c.class) == false) goto L25;
        this.a();
        return (AbstractC0451a) ZeusTransformUtils.preCheckCast(AbstractC0451a.c.f21526a, AbstractC0451a.class, "com.obric.aiagent.plugin");
    L25:
        if (o.a(r9, com.obric.aiagent.skill.ovirt.api.a.C0438a.f20940a) == false) goto L28;
        return (AbstractC0451a) ZeusTransformUtils.preCheckCast(AbstractC0451a.C0452a.f21524a, AbstractC0451a.class, "com.obric.aiagent.plugin");
    L28:
        if (o.a(r9, com.obric.aiagent.skill.ovirt.api.a.d.f20943a) == false) goto L31;
        return (AbstractC0451a) ZeusTransformUtils.preCheckCast(AbstractC0451a.b.f21525a, AbstractC0451a.class, "com.obric.aiagent.plugin");
    L31:
        if (o.a(r9, com.obric.aiagent.skill.ovirt.api.a.e.f20944a) == false) goto L34;
        return (AbstractC0451a) ZeusTransformUtils.preCheckCast(AbstractC0451a.d.f21527a, AbstractC0451a.class, "com.obric.aiagent.plugin");
    L34:
        if (ZeusTransformUtils.instanceOf(r9, com.obric.aiagent.skill.ovirt.api.a.b.class) == false) goto L38;
        this.a("clearHome failed", ((com.obric.aiagent.skill.ovirt.api.a.b) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.ovirt.api.a.b.class, "com.obric.aiagent.plugin")).a());
        return (AbstractC0451a) ZeusTransformUtils.preCheckCast(AbstractC0451a.b.f21525a, AbstractC0451a.class, "com.obric.aiagent.plugin");
    L38:
        throw new d.k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        IOVirtService r10 = IOVirtService.Companion.a();
        if (r10 == null) goto L17;
        IOVirtService.c r11 = r10.getMaintenance();
        r0.f21537a = this;
        r0.f21540d = 1;
        r8 = r11.b(r0);
        if (r8 != r2) goto L21;
        return r2;
    L17:
        return AbstractC0451a.d.f21527a;
    L7:
        r0 = new e(this, r7);
        goto L8
    }

    public final void a() {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L4
        Object r1 = d.n.f(Boolean.valueOf(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f21523c.delete()));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = d.n.c(r1);
        if (r2 == null) goto L12;
        a("invalidateUsageCache failed", r2);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r1 = d.n.f(d.o.a(th));
        goto L6
    }

    private final void b(long r4) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L7
        a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        File r2 = r1.f21523c.getParentFile();     // Catch: Throwable -> L7
        if (r2 == null) goto L5;
        r2.mkdirs();     // Catch: Throwable -> L7
    L5:
        File r3 = r1.f21523c;     // Catch: Throwable -> L7
        String r5 = new JSONObject().put("bytes", r4).put("cached_at_ms", System.currentTimeMillis()).toString();     // Catch: Throwable -> L7
        o.c(r5, "toString(...)");     // Catch: Throwable -> L7
        k.a(r3, r5, null, 2, null);     // Catch: Throwable -> L7
        Object r6 = d.n.f(x.f38692a);     // Catch: Throwable -> L7
    L9:
        Throwable r7 = d.n.c(r6);
        if (r7 == null) goto L15;
        a("writeUsageCache failed", r7);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L9
    }

    private final void a(String r2, Throwable r3) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e(TAG, r2, r3);
        return;
    L5:
        ILogDepend.Companion.w(TAG, r2);
    }
}
