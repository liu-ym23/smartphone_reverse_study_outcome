package com.obric.autogui.operator;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AOOperationResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29874a = null;

    /* JADX INFO: compiled from: AOOperationResult.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f29875a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final c f29876b = null;

        /* JADX INFO: renamed from: com.obric.autogui.operator.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AOOperationResult.kt */
        public static final class C0778a implements c {
            @Override // com.obric.autogui.operator.c
            public boolean a() {
                return false;
            }

            C0778a() {
            }

            @Override // com.obric.autogui.operator.c
            public int b() {
                return b.a(this);
            }

            @Override // com.obric.autogui.operator.c
            public EnumC0779c c() {
                return b.b(this);
            }

            @Override // com.obric.autogui.operator.c
            public String d() {
                return b.c(this);
            }

            @Override // com.obric.autogui.operator.c
            public String e() {
                return b.d(this);
            }
        }

        private a() {
        }

        static {
            f29875a = new a();
            f29876b = (c) ZeusTransformUtils.preCheckCast(new C0778a(), c.class, "com.obric.aiagent.plugin");
        }

        public final c a() {
            return f29876b;
        }
    }

    /* JADX INFO: compiled from: AOOperationResult.kt */
    public static final class b {
        public static String c(c r2) {
            c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static String d(c r2) {
            c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static int a(c r2) {
            if (((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin")).a() == false) goto L5;
            return -1;
        L5:
            return 0;
        }

        public static EnumC0779c b(c r2) {
            c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
            return EnumC0779c.f29878b;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.operator.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOOperationResult.kt */
    public static final enum EnumC0779c extends Enum<EnumC0779c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0779c f29877a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0779c f29878b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0779c f29879c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumC0779c[] f29880d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f29881e = null;

        private static final /* synthetic */ EnumC0779c[] a() {
            return new EnumC0779c[]{f29877a, f29878b, f29879c};
        }

        private EnumC0779c(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f29877a = new EnumC0779c("Proceed", 0);
            f29878b = new EnumC0779c("AbortStep", 1);
            f29879c = new EnumC0779c("RetryStep", 2);
            EnumC0779c[] r0 = a();
            f29880d = r0;
            f29881e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static EnumC0779c valueOf(String r2) {
            return (EnumC0779c) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0779c.class, r2), EnumC0779c.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0779c[] values() {
            return (EnumC0779c[]) ZeusTransformUtils.preCheckCast(f29880d.clone(), EnumC0779c[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f29874a = a.f29875a;
    }

    boolean a();

    int b();

    EnumC0779c c();

    String d();

    String e();
}
