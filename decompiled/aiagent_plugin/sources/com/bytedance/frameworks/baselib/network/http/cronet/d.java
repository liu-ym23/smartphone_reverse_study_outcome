package com.bytedance.frameworks.baselib.network.http.cronet;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TTNetThreadConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f8255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8257c;

    /* JADX INFO: compiled from: TTNetThreadConfig.java */
    public interface a {
        void a(int r1);

        void b(int r1);

        void c(int r1);
    }

    /* JADX INFO: compiled from: TTNetThreadConfig.java */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8258a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f8259b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f8260c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f8261d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f8262e = null;
        public static final b f = null;
        public static final b g = null;
        private static final /* synthetic */ b[] h = null;

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(h.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("CALLED_MULIT_TIMES", 0);
            f8258a = r0;
            b r1 = new b("PROCESS_NAME_NULL", 1);
            f8259b = r1;
            b r3 = new b("TNC_DISABLED", 2);
            f8260c = r3;
            b r5 = new b("CRASH_HAPPENED", 3);
            f8261d = r5;
            b r7 = new b("OPT_EFFECTIVE", 4);
            f8262e = r7;
            b r9 = new b("FALLBACK_FIX", 5);
            f = r9;
            b r11 = new b("HAS_EXCEPTION", 6);
            g = r11;
            h = new b[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    /* JADX INFO: compiled from: TTNetThreadConfig.java */
    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f8263a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f8264b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f8265c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f8266d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f8267e = null;
        private static final /* synthetic */ c[] f = null;

        private c(String r1, int r2) {
            super(r1, r2);
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f.clone(), c[].class, "com.obric.aiagent.plugin");
        }

        static {
            c r0 = new c("INIT_THREAD", 0);
            f8263a = r0;
            c r1 = new c("NETWORK_THREAD", 1);
            f8264b = r1;
            c r3 = new c("FILE_THREAD", 2);
            f8265c = r3;
            c r5 = new c("THREAD_POOL_SERVICE_THREAD", 3);
            f8266d = r5;
            c r7 = new c("WORKER_THREAD", 4);
            f8267e = r7;
            f = new c[]{r0, r1, r3, r5, r7};
        }
    }

    public d() {
        this.f8256b = 20;
        this.f8257c = 0;
    }
}
