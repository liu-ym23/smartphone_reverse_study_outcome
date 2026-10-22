package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Duration;

/* JADX INFO: compiled from: CronetLogger.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h {

    /* JADX INFO: compiled from: CronetLogger.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f38125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f38126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f38127c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f38128d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f38129e;
        private final boolean f;
        private final int g;
        private final String h;
        private final boolean i;
        private final int j;

        public a(CronetEngineBuilderImpl r2) {
            this.f38125a = r2.V();
            this.f38126b = r2.d();
            this.f38127c = r2.e();
            this.f38128d = r2.g();
            this.f38129e = r2.i();
            this.f = r2.O();
            this.g = r2.S();
            this.h = r2.W();
            this.i = r2.Y();
            this.j = r2.e(10);
        }
    }

    /* JADX INFO: compiled from: CronetLogger.java */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f38130a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f38131b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f38132c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f38133d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ b[] f38134e = null;

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f38134e.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("CRONET_SOURCE_UNSPECIFIED", 0);
            f38130a = r0;
            b r1 = new b("CRONET_SOURCE_STATICALLY_LINKED", 1);
            f38131b = r1;
            b r3 = new b("CRONET_SOURCE_PLAY_SERVICES", 2);
            f38132c = r3;
            b r5 = new b("CRONET_SOURCE_FALLBACK", 3);
            f38133d = r5;
            f38134e = new b[]{r0, r1, r3, r5};
        }
    }

    /* JADX INFO: compiled from: CronetLogger.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f38135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f38136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f38137c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f38138d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f38139e;
        private final Duration f;
        private final Duration g;
        private final String h;
        private final boolean i;
        private final boolean j;

        public c(long r1, long r3, long r5, long r7, int r9, Duration r10, Duration r11, String r12, boolean r13, boolean r14) {
            this.f38135a = r1;
            this.f38136b = r3;
            this.f38137c = r5;
            this.f38138d = r7;
            this.f38139e = r9;
            this.f = r10;
            this.g = r11;
            this.h = r12;
            this.i = r13;
            this.j = r14;
        }
    }

    /* JADX INFO: compiled from: CronetLogger.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f38140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f38141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f38142c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f38143d;

        public d(String r2) {
            String[] r3 = r2.split("\\.");
            this.f38140a = Integer.parseInt(r3[0]);
            this.f38141b = Integer.parseInt(r3[1]);
            this.f38142c = Integer.parseInt(r3[2]);
            this.f38143d = Integer.parseInt(r3[3]);
        }

        public String toString() {
            return "" + this.f38140a + "." + this.f38141b + "." + this.f38142c + "." + this.f38143d;
        }
    }

    public abstract void a(int r1, a r2, d r3, b r4);

    public abstract void a(int r1, c r2);

    public h() {
    }
}
