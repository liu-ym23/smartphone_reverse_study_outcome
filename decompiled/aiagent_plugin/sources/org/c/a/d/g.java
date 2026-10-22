package org.c.a.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.c.a.c.a f40396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final org.c.a.c.a f40397b;

    /* JADX INFO: compiled from: Event.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f40398a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f40399b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f40400c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f40401d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f40402e = null;
        public static final a f = null;
        public static final a g = null;
        public static final a h = null;
        public static final a i = null;
        public static final a j = null;
        public static final a k = null;
        private static final /* synthetic */ a[] l = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(l.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("Alias", 0);
            f40398a = r0;
            a r1 = new a("Comment", 1);
            f40399b = r1;
            a r3 = new a("DocumentEnd", 2);
            f40400c = r3;
            a r5 = new a("DocumentStart", 3);
            f40401d = r5;
            a r7 = new a("MappingEnd", 4);
            f40402e = r7;
            a r9 = new a("MappingStart", 5);
            f = r9;
            a r11 = new a("Scalar", 6);
            g = r11;
            a r13 = new a("SequenceEnd", 7);
            h = r13;
            a r15 = new a("SequenceStart", 8);
            i = r15;
            a r14 = new a("StreamEnd", 9);
            j = r14;
            a r12 = new a("StreamStart", 10);
            k = r12;
            l = new a[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        }
    }

    public abstract a a();

    public String d() {
        return "";
    }

    public g(org.c.a.c.a r1, org.c.a.c.a r2) {
        this.f40396a = r1;
        this.f40397b = r2;
    }

    public String toString() {
        return "<" + getClass().getName() + "(" + d() + ")>";
    }

    public org.c.a.c.a f() {
        return this.f40396a;
    }

    public org.c.a.c.a g() {
        return this.f40397b;
    }

    public boolean a(a r1) {
        if (a() != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, g.class) == true) goto L5;
        return false;
    L5:
        return toString().equals(r2.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
