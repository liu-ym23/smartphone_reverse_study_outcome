package ec;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f19361d;

    /* JADX INFO: renamed from: ec.a$a, reason: collision with other inner class name */
    public static final class C0244a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f19364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f19365d;

        public C0244a() {
            this.f19362a = "";
            this.f19364c = "";
        }

        public final a a() {
            return new a(this.f19362a, this.f19363b, this.f19364c, this.f19365d, null);
        }

        public final C0244a b(boolean r10) {
            this.f19365d = r10;
            return this;
        }

        public final C0244a c(String r10) {
            q.g(r10, "pkgName");
            this.f19362a = r10;
            return this;
        }

        public final C0244a d(int r10) {
            this.f19363b = r10;
            return this;
        }

        public final C0244a e(String r10) {
            q.g(r10, "versionName");
            this.f19364c = r10;
            return this;
        }
    }

    public /* synthetic */ a(String r10, int r11, String r12, boolean r13, DefaultConstructorMarker r14) {
        this(r10, r11, r12, r13);
    }

    public final String a() {
        return this.f19358a;
    }

    public final int b() {
        return this.f19359b;
    }

    public final String c() {
        return this.f19360c;
    }

    public final boolean d() {
        return this.f19361d;
    }

    public a(String r10, int r11, String r12, boolean r13) {
        this.f19358a = r10;
        this.f19359b = r11;
        this.f19360c = r12;
        this.f19361d = r13;
    }
}
