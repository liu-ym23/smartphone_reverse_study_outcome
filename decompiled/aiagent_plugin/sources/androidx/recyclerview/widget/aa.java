package androidx.recyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StableIdStorage.java */
/* JADX INFO: loaded from: classes.dex */
interface aa {

    /* JADX INFO: compiled from: StableIdStorage.java */
    public static class a implements aa {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f2422a;

        /* JADX INFO: renamed from: androidx.recyclerview.widget.aa$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: StableIdStorage.java */
        class C0071a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f2423a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final androidx.b.d<Long> f2424b;

            C0071a(a r1) {
                this.f2423a = r1;
                this.f2424b = new androidx.b.d();
            }

            @Override // androidx.recyclerview.widget.aa.d
            public long a(long r4) {
                Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.f2424b.a(r4), Long.class, "com.obric.aiagent.plugin");
                if (r0 != null) goto L6;
                r0 = Long.valueOf(this.f2423a.b());
                this.f2424b.b(r4, r0);
            L6:
                return r0.longValue();
            }
        }

        public a() {
            this.f2422a = 0;
        }

        long b() {
            long r0 = this.f2422a;
            this.f2422a = 1 + r0;
            return r0;
        }

        @Override // androidx.recyclerview.widget.aa
        public d a() {
            return new C0071a(this);
        }
    }

    /* JADX INFO: compiled from: StableIdStorage.java */
    public static class b implements aa {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f2425a;

        public b() {
            this.f2425a = new AnonymousClass1(this);
        }

        @Override // androidx.recyclerview.widget.aa
        public d a() {
            return this.f2425a;
        }
    }

    /* JADX INFO: compiled from: StableIdStorage.java */
    public static class c implements aa {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f2427a;

        public c() {
            this.f2427a = new AnonymousClass1(this);
        }

        @Override // androidx.recyclerview.widget.aa
        public d a() {
            return this.f2427a;
        }
    }

    /* JADX INFO: compiled from: StableIdStorage.java */
    public interface d {
        long a(long r1);
    }

    d a();
}
