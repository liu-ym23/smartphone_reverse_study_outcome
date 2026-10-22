package com.bytedance.platform.godzilla.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9079a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f9080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static e f9081c;

    /* JADX INFO: renamed from: com.bytedance.platform.godzilla.common.g$2, reason: invalid class name */
    /* JADX INFO: compiled from: Logger.java */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9082a = null;

        static {
            int[] r0 = new int[a.values().length];
            f9082a = r0;
            r0[a.f9083a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f9082a[a.f9086d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f9082a[a.f9085c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f9082a[a.f9084b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    /* JADX INFO: compiled from: Logger.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9083a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f9084b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f9085c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f9086d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f9087e = null;
        private static final /* synthetic */ a[] f = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("DEBUG", 0);
            f9083a = r0;
            a r1 = new a("INFO", 1);
            f9084b = r1;
            a r3 = new a("WARNING", 2);
            f9085c = r3;
            a r5 = new a("ERROR", 3);
            f9086d = r5;
            a r7 = new a("NONE", 4);
            f9087e = r7;
            f = new a[]{r0, r1, r3, r5, r7};
        }
    }

    static {
        f9080b = a.f9084b;
        f9081c = new AnonymousClass1();
    }

    public static boolean a() {
        return f9079a;
    }

    public static void a(String r1, String r2) {
        a(r1, r2, a.f9086d);
    }

    public static void b(String r1, String r2) {
        a(r1, r2, a.f9083a);
    }

    public static void a(String r2, String r3, a r4) {
        if (r4.ordinal() < f9080b.ordinal()) goto L6;
        f9081c.a(r2, r3, r4);
        return;
    }
}
