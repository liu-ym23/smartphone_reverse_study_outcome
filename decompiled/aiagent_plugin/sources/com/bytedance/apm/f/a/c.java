package com.bytedance.apm.f.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: LaunchSleepDetector.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f4608a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4609b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f4610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f4611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f4612e;
    private static String f;
    private static long g;
    private static long h;
    private static ExecutorService i;

    /* JADX INFO: compiled from: LaunchSleepDetector.java */
    private static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4613a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f4614b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f4615c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f4616d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f4617e = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f4617e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("NONE", 0);
            f4613a = r0;
            a r1 = new a("SLEEP", 1);
            f4614b = r1;
            a r3 = new a("NOT_SLEEP", 2);
            f4615c = r3;
            a r5 = new a("DISK_SLEEP", 3);
            f4616d = r5;
            f4617e = new a[]{r0, r1, r3, r5};
        }
    }

    static {
        f4610c = a.f4613a;
        f4611d = -1;
        f4612e = 0;
        f = "";
        g = 8000;
        h = 0;
        i = Executors.newSingleThreadExecutor(new AnonymousClass1());
    }

    public static void a() {
        if (f4608a == true) goto L5;
        return;
    L5:
        f4608a = false;
        f4610c = a.f4613a;
        f4611d = -1;
        f4612e = 0;
        f = "";
    }
}
