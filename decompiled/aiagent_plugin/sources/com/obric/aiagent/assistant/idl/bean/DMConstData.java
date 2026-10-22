package com.obric.aiagent.assistant.idl.bean;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DMConstData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DMConstData {
    public static final DMConstData INSTANCE = null;

    /* JADX INFO: compiled from: DMConstData.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f16243a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f16244b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f16245c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f16246d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f16247e = null;
        public static final a f = null;
        public static final a g = null;
        public static final a h = null;
        public static final a i = null;
        public static final a j = null;
        private static final /* synthetic */ a[] k = null;
        private static final /* synthetic */ d.d.a l = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f16243a, f16244b, f16245c, f16246d, f16247e, f, g, h, i, j};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f16243a = new a("Idle", 0);
            f16244b = new a("Queueing", 1);
            f16245c = new a("Thinking", 2);
            f16246d = new a("CallUser", 3);
            f16247e = new a("Clarify", 4);
            f = new a("ClarifyAck", 5);
            g = new a("TakingOver", 6);
            h = new a("ThinkingCompleted", 7);
            i = new a("Terminated", 8);
            j = new a("TTS", 9);
            a[] r0 = a();
            k = r0;
            l = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(k.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: DMConstData.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f16248a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f16249b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f16250c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f16251d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f16252e = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f16248a, f16249b, f16250c};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f16248a = new b("Idle", 0);
            f16249b = new b("Processing", 1);
            f16250c = new b("Clarify", 2);
            b[] r0 = a();
            f16251d = r0;
            f16252e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f16251d.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: DMConstData.kt */
    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f16253a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f16254b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ c[] f16255c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f16256d = null;

        private static final /* synthetic */ c[] a() {
            return new c[]{f16253a, f16254b};
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f16253a = new c("Idle", 0);
            f16254b = new c("Processing", 1);
            c[] r0 = a();
            f16255c = r0;
            f16256d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f16255c.clone(), c[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
        INSTANCE = new DMConstData();
    }

    private DMConstData() {
    }
}
