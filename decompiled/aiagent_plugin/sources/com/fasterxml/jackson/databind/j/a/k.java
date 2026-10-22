package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: PropertySerializerMap.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final boolean f12819a;

    /* JADX INFO: compiled from: PropertySerializerMap.java */
    private static final class a extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<?> f12820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class<?> f12821c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.fasterxml.jackson.databind.p<Object> f12822d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.fasterxml.jackson.databind.p<Object> f12823e;

        public a(k r1, Class<?> r2, com.fasterxml.jackson.databind.p<Object> r3, Class<?> r4, com.fasterxml.jackson.databind.p<Object> r5) {
            super(r1);
            this.f12820b = r2;
            this.f12822d = r3;
            this.f12821c = r4;
            this.f12823e = r5;
        }

        @Override // com.fasterxml.jackson.databind.j.a.k
        public com.fasterxml.jackson.databind.p<Object> a(Class<?> r2) {
            if (r2 != this.f12820b) goto L7;
            return this.f12822d;
        L7:
            if (r2 == this.f12821c) goto L9;
            return null;
        L9:
            return this.f12823e;
        }

        @Override // com.fasterxml.jackson.databind.j.a.k
        public k b(Class<?> r5, com.fasterxml.jackson.databind.p<Object> r6) {
            return new c(this, new f[]{new f(this.f12820b, this.f12822d), new f(this.f12821c, this.f12823e), new f(r5, r6)});
        }
    }

    /* JADX INFO: compiled from: PropertySerializerMap.java */
    private static final class b extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f12824b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f12825c = null;

        @Override // com.fasterxml.jackson.databind.j.a.k
        public com.fasterxml.jackson.databind.p<Object> a(Class<?> r1) {
            return null;
        }

        static {
            f12824b = new b(false);
            f12825c = new b(true);
        }

        public b(boolean r1) {
            super(r1);
        }

        @Override // com.fasterxml.jackson.databind.j.a.k
        public k b(Class<?> r2, com.fasterxml.jackson.databind.p<Object> r3) {
            return new e(this, r2, r3);
        }
    }

    /* JADX INFO: compiled from: PropertySerializerMap.java */
    private static final class c extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f[] f12826b;

        public c(k r1, f[] r2) {
            super(r1);
            this.f12826b = r2;
        }

        @Override // com.fasterxml.jackson.databind.j.a.k
        public com.fasterxml.jackson.databind.p<Object> a(Class<?> r3) {
            f r0 = this.f12826b[0];
            if (r0.f12831a == r3) goto L5;
            f r1 = this.f12826b[1];
            if (r1.f12831a == r3) goto L9;
            f r2 = this.f12826b[2];
            if (r2.f12831a == r3) goto L13;
            f[] r4 = this.f12826b;
            switch(r4.length) {
                case 4: goto L33;
                case 5: goto L29;
                case 6: goto L25;
                case 7: goto L21;
                case 8: goto L17;
                default: goto L39;
            };
        L17:
            f r5 = r4[7];
            if (r5.f12831a != r3) goto L21;
            return r5.f12832b;
        L21:
            f r6 = this.f12826b[6];
            if (r6.f12831a != r3) goto L25;
            return r6.f12832b;
        L25:
            f r7 = this.f12826b[5];
            if (r7.f12831a != r3) goto L29;
            return r7.f12832b;
        L29:
            f r8 = this.f12826b[4];
            if (r8.f12831a != r3) goto L33;
            return r8.f12832b;
        L33:
            f r9 = this.f12826b[3];
            if (r9.f12831a == r3) goto L36;
            return null;
        L36:
            return r9.f12832b;
        L39:
            return null;
        L13:
            return r2.f12832b;
        L9:
            return r1.f12832b;
        L5:
            return r0.f12832b;
        }

        @Override // com.fasterxml.jackson.databind.j.a.k
        public k b(Class<?> r5, com.fasterxml.jackson.databind.p<Object> r6) {
            f[] r0 = this.f12826b;
            int r1 = r0.length;
            if (r1 == 8) goto L5;
            f[] r2 = (f[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r0, r1 + 1), f[].class, "com.obric.aiagent.plugin");
            r2[r1] = new f(r5, r6);
            return new c(this, r2);
        L5:
            if (this.f12819a == true) goto L7;
            return this;
        L7:
            return new e(this, r5, r6);
        }
    }

    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.fasterxml.jackson.databind.p<Object> f12827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k f12828b;

        public d(com.fasterxml.jackson.databind.p<Object> r1, k r2) {
            this.f12827a = r1;
            this.f12828b = r2;
        }
    }

    /* JADX INFO: compiled from: PropertySerializerMap.java */
    private static final class e extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<?> f12829b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.fasterxml.jackson.databind.p<Object> f12830c;

        public e(k r1, Class<?> r2, com.fasterxml.jackson.databind.p<Object> r3) {
            super(r1);
            this.f12829b = r2;
            this.f12830c = r3;
        }

        @Override // com.fasterxml.jackson.databind.j.a.k
        public com.fasterxml.jackson.databind.p<Object> a(Class<?> r2) {
            if (r2 == this.f12829b) goto L5;
            return null;
        L5:
            return this.f12830c;
        }

        @Override // com.fasterxml.jackson.databind.j.a.k
        public k b(Class<?> r8, com.fasterxml.jackson.databind.p<Object> r9) {
            return new a(this, this.f12829b, this.f12830c, r8, r9);
        }
    }

    /* JADX INFO: compiled from: PropertySerializerMap.java */
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<?> f12831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.fasterxml.jackson.databind.p<Object> f12832b;

        public f(Class<?> r1, com.fasterxml.jackson.databind.p<Object> r2) {
            this.f12831a = r1;
            this.f12832b = r2;
        }
    }

    public abstract com.fasterxml.jackson.databind.p<Object> a(Class<?> r1);

    public abstract k b(Class<?> r1, com.fasterxml.jackson.databind.p<Object> r2);

    public k(boolean r1) {
        this.f12819a = r1;
    }

    public k(k r1) {
        this.f12819a = r1.f12819a;
    }

    public final d a(Class<?> r3, ac r4, com.fasterxml.jackson.databind.d r5) {
        com.fasterxml.jackson.databind.p<Object> r6 = r4.b(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
        return new d(r6, b(r3, r6));
    }

    public final d a(com.fasterxml.jackson.databind.k r3, ac r4, com.fasterxml.jackson.databind.d r5) {
        com.fasterxml.jackson.databind.p<Object> r6 = r4.b(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
        return new d(r6, b(r3.e(), r6));
    }

    public final d b(Class<?> r3, ac r4, com.fasterxml.jackson.databind.d r5) {
        com.fasterxml.jackson.databind.p<Object> r6 = r4.c(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
        return new d(r6, b(r3, r6));
    }

    public final d b(com.fasterxml.jackson.databind.k r3, ac r4, com.fasterxml.jackson.databind.d r5) {
        com.fasterxml.jackson.databind.p<Object> r6 = r4.c(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
        return new d(r6, b(r3.e(), r6));
    }

    public final d c(Class<?> r3, ac r4, com.fasterxml.jackson.databind.d r5) {
        com.fasterxml.jackson.databind.p<Object> r6 = r4.d(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
        return new d(r6, b(r3, r6));
    }

    public final d a(Class<?> r2, com.fasterxml.jackson.databind.p<Object> r3) {
        return new d(r3, b(r2, r3));
    }

    public final d a(com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.p<Object> r3) {
        return new d(r3, b(r2.e(), r3));
    }

    public static k a() {
        return b.f12824b;
    }
}
