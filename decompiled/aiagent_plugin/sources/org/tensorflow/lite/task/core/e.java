package org.tensorflow.lite.task.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ComputeSettings.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f40640a = null;

    /* JADX INFO: compiled from: ComputeSettings.java */
    public static abstract class a {
        public abstract e a();

        public a() {
        }
    }

    /* JADX INFO: compiled from: ComputeSettings.java */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f40641a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f40642b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f40643c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ b[] f40644e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f40645d;

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f40644e.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("NONE", 0, 0);
            f40641a = r0;
            b r1 = new b("NNAPI", 1, 1);
            f40642b = r1;
            b r3 = new b("GPU", 2, 2);
            f40643c = r3;
            f40644e = new b[]{r0, r1, r3};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f40645d = r3;
        }

        public int a() {
            return this.f40645d;
        }
    }

    public abstract b a();

    public e() {
    }

    public static a b() {
        return new org.tensorflow.lite.task.core.b.a().a(f40640a);
    }

    static {
        f40640a = b.f40641a;
    }
}
