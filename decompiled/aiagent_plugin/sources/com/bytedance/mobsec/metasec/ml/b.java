package com.bytedance.mobsec.metasec.ml;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class b extends com.bytedance.mobsec.metasec.a.c {
    private final com.bytedance.mobsec.metasec.a.c t;

    public static class a extends com.bytedance.mobsec.metasec.a.c.a<a> {

        /* JADX INFO: renamed from: com.bytedance.mobsec.metasec.ml.b$a$a, reason: collision with other inner class name */
        public interface InterfaceC0200a {
            String a();
        }

        /* JADX INFO: renamed from: com.bytedance.mobsec.metasec.ml.b$a$b, reason: collision with other inner class name */
        public interface InterfaceC0201b {
            boolean isComplianceScene(String r1);
        }

        public interface c {
            String a();
        }

        public a(String r1, String r2, int r3) {
            super(r1, r2, r3);
        }

        public a b(int r1) {
            a(r1);
            return this;
        }

        public a b(InterfaceC0201b r3) {
            a((InterfaceC0201b) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0201b.class, "com.obric.aiagent.plugin"));
            return this;
        }

        public a b(String r1, String r2) {
            a(r1, r2);
            return this;
        }

        public b c() {
            return new b(b(), 0);
        }

        public a f(String r1) {
            c(r1);
            return this;
        }

        public a g(String r1) {
            d(r1);
            return this;
        }

        public a h(String r1) {
            b(r1);
            return this;
        }

        public a i(String r1) {
            e(r1);
            return this;
        }
    }

    private b(com.bytedance.mobsec.metasec.a.c r1) {
        this.t = r1;
    }

    /* synthetic */ b(com.bytedance.mobsec.metasec.a.c r1, int r2) {
        this(r1);
    }

    final com.bytedance.mobsec.metasec.a.c b() {
        return this.t;
    }
}
