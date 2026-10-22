package com.bytedance.apm6.cpu;

import android.os.Process;
import com.bytedance.monitor.collector.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CgroupFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f5217a = 0;

    /* JADX INFO: compiled from: CgroupFetcher.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f5218a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f5219b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f5220c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f5221d = null;
        private static final /* synthetic */ a[] f = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f5222e;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("UNKNOWN", 0, -1);
            f5218a = r0;
            a r1 = new a("TOP_APP", 1, 0);
            f5219b = r1;
            a r3 = new a("FOREGROUND", 2, 1);
            f5220c = r3;
            a r5 = new a("BACKGROUND", 3, 2);
            f5221d = r5;
            f = new a[]{r0, r1, r3, r5};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f5222e = r3;
        }

        public static a a(int r1) {
            if (r1 == (-1)) goto L18;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L14;
            if (r1 == 2) goto L12;
            return f5218a;
        L12:
            return f5221d;
        L14:
            return f5220c;
        L16:
            return f5219b;
        L18:
            return f5218a;
        }
    }

    static {
        f5217a = Process.myPid();
    }

    public static a a() {
        return a.a(k.a().c(f5217a));
    }
}
