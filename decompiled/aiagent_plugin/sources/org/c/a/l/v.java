package org.c.a.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Token.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.c.a.c.a f40512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final org.c.a.c.a f40513b;

    /* JADX INFO: compiled from: Token.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f40514a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f40515b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f40516c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f40517d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f40518e = null;
        public static final a f = null;
        public static final a g = null;
        public static final a h = null;
        public static final a i = null;
        public static final a j = null;
        public static final a k = null;
        public static final a l = null;
        public static final a m = null;
        public static final a n = null;
        public static final a o = null;
        public static final a p = null;
        public static final a q = null;
        public static final a r = null;
        public static final a s = null;
        public static final a t = null;
        public static final a u = null;
        public static final a v = null;
        public static final a w = null;
        private static final /* synthetic */ a[] y = null;
        private final String x;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(y.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("Alias", 0, "<alias>");
            f40514a = r0;
            a r1 = new a("Anchor", 1, "<anchor>");
            f40515b = r1;
            a r3 = new a("BlockEnd", 2, "<block end>");
            f40516c = r3;
            a r5 = new a("BlockEntry", 3, "-");
            f40517d = r5;
            a r7 = new a("BlockMappingStart", 4, "<block mapping start>");
            f40518e = r7;
            a r9 = new a("BlockSequenceStart", 5, "<block sequence start>");
            f = r9;
            a r11 = new a("Directive", 6, "<directive>");
            g = r11;
            a r13 = new a("DocumentEnd", 7, "<document end>");
            h = r13;
            a r12 = new a("DocumentStart", 8, "<document start>");
            i = r12;
            a r10 = new a("FlowEntry", 9, ",");
            j = r10;
            a r8 = new a("FlowMappingEnd", 10, "}");
            k = r8;
            a r6 = new a("FlowMappingStart", 11, "{");
            l = r6;
            a r4 = new a("FlowSequenceEnd", 12, "]");
            m = r4;
            a r2 = new a("FlowSequenceStart", 13, "[");
            n = r2;
            a r14 = new a("Key", 14, "?");
            o = r14;
            a r15 = new a("Scalar", 15, "<scalar>");
            p = r15;
            a r16 = new a("StreamEnd", 16, "<stream end>");
            q = r16;
            a r17 = new a("StreamStart", 17, "<stream start>");
            r = r17;
            a r18 = new a("Tag", 18, "<tag>");
            s = r18;
            a r19 = new a("Value", 19, ":");
            t = r19;
            a r20 = new a("Whitespace", 20, "<whitespace>");
            u = r20;
            a r21 = new a("Comment", 21, "#");
            v = r21;
            a r22 = new a("Error", 22, "<error>");
            w = r22;
            y = new a[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2, r14, r15, r16, r17, r18, r19, r20, r21, r22};
        }

        private a(String r1, int r2, String r3) {
            super(r1, r2);
            this.x = r3;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.x;
        }
    }

    public abstract a b();

    public v(org.c.a.c.a r1, org.c.a.c.a r2) {
        if (r1 == null) goto L8;
        if (r2 == null) goto L8;
        this.f40512a = r1;
        this.f40513b = r2;
        return;
    L8:
        throw new org.c.a.c.c("Token requires marks.");
    }

    public org.c.a.c.a e() {
        return this.f40512a;
    }

    public org.c.a.c.a f() {
        return this.f40513b;
    }
}
