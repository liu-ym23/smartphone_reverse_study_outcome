package com.obric.autogui.operator;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AOStepResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f29918b = null;

    /* JADX INFO: compiled from: AOStepResult.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f29919a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final g f29920b = null;

        /* JADX INFO: renamed from: com.obric.autogui.operator.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AOStepResult.kt */
        public static final class C0781a implements g, k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f29921a;

            @Override // com.obric.autogui.operator.g
            public boolean a() {
                return true;
            }

            C0781a(int r1) {
                this.f29921a = r1;
            }

            @Override // com.obric.autogui.operator.g
            public String c() {
                return b.a(this);
            }

            @Override // com.obric.autogui.operator.g
            public int d() {
                return b.b(this);
            }

            @Override // com.obric.autogui.operator.g
            public e e() {
                return b.c(this);
            }

            @Override // com.obric.autogui.operator.g
            public Object f() {
                return b.d(this);
            }

            @Override // com.obric.autogui.operator.g
            public f g() {
                return b.e(this);
            }

            @Override // com.obric.autogui.operator.g
            public c b() {
                return c.f29925d;
            }

            @Override // com.obric.autogui.operator.k
            public String a(Context r3) {
                Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "context");
                String r2 = r4.getString(this.f29921a);
                d.h.b.o.c(r2, "getString(...)");
                return r2;
            }
        }

        /* JADX INFO: compiled from: AOStepResult.kt */
        public static final class b implements g {
            @Override // com.obric.autogui.operator.g
            public boolean a() {
                return false;
            }

            b() {
            }

            @Override // com.obric.autogui.operator.g
            public String c() {
                return b.a(this);
            }

            @Override // com.obric.autogui.operator.g
            public int d() {
                return b.b(this);
            }

            @Override // com.obric.autogui.operator.g
            public e e() {
                return b.c(this);
            }

            @Override // com.obric.autogui.operator.g
            public Object f() {
                return b.d(this);
            }

            @Override // com.obric.autogui.operator.g
            public f g() {
                return b.e(this);
            }

            @Override // com.obric.autogui.operator.g
            public c b() {
                return c.f29922a;
            }
        }

        private a() {
        }

        static {
            f29919a = new a();
            f29920b = (g) ZeusTransformUtils.preCheckCast(new b(), g.class, "com.obric.aiagent.plugin");
        }

        public final g a(int r2) {
            return (g) ZeusTransformUtils.preCheckCast(new C0781a(r2), g.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: AOStepResult.kt */
    public static final class b {
        public static String a(g r2) {
            g r3 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static Object d(g r2) {
            g r3 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static f e(g r2) {
            g r3 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static int b(g r2) {
            if (((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin")).a() == false) goto L5;
            return -1;
        L5:
            return 0;
        }

        public static e c(g r2) {
            g r3 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin");
            return e.f29929b;
        }
    }

    /* JADX INFO: compiled from: AOStepResult.kt */
    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f29922a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f29923b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f29924c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f29925d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ c[] f29926e = null;
        private static final /* synthetic */ d.d.a f = null;

        private static final /* synthetic */ c[] a() {
            return new c[]{f29922a, f29923b, f29924c, f29925d};
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f29922a = new c("NotExecuted", 0);
            f29923b = new c("Preparing", 1);
            f29924c = new c("Executing", 2);
            f29925d = new c("Done", 3);
            c[] r0 = a();
            f29926e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f29926e.clone(), c[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: AOStepResult.kt */
    public static final class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29927a;

        /* JADX WARN: Multi-variable type inference failed */
        public d() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.obric.autogui.operator.g
        public boolean a() {
            return false;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f29927a, r6.f29927a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            String r0 = this.f29927a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "OK(thought=" + this.f29927a + ')';
        }

        public d(String r1) {
            this.f29927a = r1;
        }

        public /* synthetic */ d(String r1, int r2, d.h.b.h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }

        @Override // com.obric.autogui.operator.g
        public int d() {
            return b.b(this);
        }

        @Override // com.obric.autogui.operator.g
        public e e() {
            return b.c(this);
        }

        @Override // com.obric.autogui.operator.g
        public Object f() {
            return b.d(this);
        }

        @Override // com.obric.autogui.operator.g
        public f g() {
            return b.e(this);
        }

        @Override // com.obric.autogui.operator.g
        public String c() {
            return this.f29927a;
        }

        @Override // com.obric.autogui.operator.g
        public c b() {
            return c.f29925d;
        }
    }

    /* JADX INFO: compiled from: AOStepResult.kt */
    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f29928a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f29929b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f29930c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ e[] f29931d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f29932e = null;

        private static final /* synthetic */ e[] a() {
            return new e[]{f29928a, f29929b, f29930c};
        }

        private e(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f29928a = new e("RetryStep", 0);
            f29929b = new e("Proceed", 1);
            f29930c = new e("AbortTask", 2);
            e[] r0 = a();
            f29931d = r0;
            f29932e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static e valueOf(String r2) {
            return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
        }

        public static e[] values() {
            return (e[]) ZeusTransformUtils.preCheckCast(f29931d.clone(), e[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f29918b = a.f29919a;
    }

    boolean a();

    c b();

    String c();

    int d();

    e e();

    Object f();

    f g();
}
