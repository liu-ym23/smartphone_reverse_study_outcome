package com.bytedance.frameworks.baselib.network.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IRequest.java */
/* JADX INFO: loaded from: classes.dex */
public interface c {

    /* JADX INFO: compiled from: IRequest.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8010a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8011b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f8012c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f8013d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f8014e = null;
        private static final /* synthetic */ a[] f = null;

        static {
            a r0 = new a("LOWEST", 0);
            f8010a = r0;
            a r1 = new a("LOW", 1);
            f8011b = r1;
            a r3 = new a("NORMAL", 2);
            f8012c = r3;
            a r5 = new a("HIGH", 3);
            f8013d = r5;
            a r7 = new a("IMMEDIATE", 4);
            f8014e = r7;
            f = new a[]{r0, r1, r3, r5, r7};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    a a();

    int b();
}
