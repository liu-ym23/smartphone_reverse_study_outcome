package com.obric.oui.orecyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StableIdStorage.java */
/* JADX INFO: loaded from: classes4.dex */
interface y {

    /* JADX INFO: compiled from: StableIdStorage.java */
    public static class a implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f35844a;

        /* JADX INFO: renamed from: com.obric.oui.orecyclerview.widget.y$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: StableIdStorage.java */
        class C0968a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f35845a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final androidx.b.d<Long> f35846b;

            C0968a(a r1) {
                this.f35845a = r1;
                this.f35846b = new androidx.b.d();
            }

            @Override // com.obric.oui.orecyclerview.widget.y.d
            public long a(long r4) {
                Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.f35846b.a(r4), Long.class, "com.obric.aiagent.plugin");
                if (r0 != null) goto L6;
                r0 = Long.valueOf(this.f35845a.b());
                this.f35846b.b(r4, r0);
            L6:
                return r0.longValue();
            }
        }

        public a() {
            this.f35844a = 0;
        }

        long b() {
            long r0 = this.f35844a;
            this.f35844a = 1 + r0;
            return r0;
        }

        @Override // com.obric.oui.orecyclerview.widget.y
        public d a() {
            return new C0968a(this);
        }
    }

    /* JADX INFO: compiled from: StableIdStorage.java */
    public static class b implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f35847a;

        public b() {
            this.f35847a = new AnonymousClass1(this);
        }

        @Override // com.obric.oui.orecyclerview.widget.y
        public d a() {
            return this.f35847a;
        }
    }

    /* JADX INFO: compiled from: StableIdStorage.java */
    public static class c implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f35849a;

        public c() {
            this.f35849a = new AnonymousClass1(this);
        }

        @Override // com.obric.oui.orecyclerview.widget.y
        public d a() {
            return this.f35849a;
        }
    }

    /* JADX INFO: compiled from: StableIdStorage.java */
    public interface d {
        long a(long r1);
    }

    d a();
}
