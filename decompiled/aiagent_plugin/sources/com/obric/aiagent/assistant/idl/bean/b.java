package com.obric.aiagent.assistant.idl.bean;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ObricStateConst.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16263a = null;

    /* JADX INFO: compiled from: ObricStateConst.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f16264a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f16265b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f16266c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f16267d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f16268e = null;
        private static final /* synthetic */ a[] g = null;
        private static final /* synthetic */ d.d.a h = null;
        private final int f;

        private static final /* synthetic */ a[] b() {
            return new a[]{f16264a, f16265b, f16266c, f16267d, f16268e};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f = r3;
        }

        public final int a() {
            return this.f;
        }

        static {
            f16264a = new a("PLAY_STATE_STOPPED", 0, 1);
            f16265b = new a("PLAY_STATE_PREPARE", 1, 2);
            f16266c = new a("PLAY_STATE_PAUSED", 2, 3);
            f16267d = new a("PLAY_STATE_PLAYING", 3, 4);
            f16268e = new a("PLAY_STATE_FAIL", 4, 5);
            a[] r0 = b();
            g = r0;
            h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(g.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f16263a = new b();
    }

    private b() {
    }
}
