package ic;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f20550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f20552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f20553f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f20554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f20556c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f20557d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f20558e;

        public a() {
            this.f20554a = "";
            this.f20556c = "";
            this.f20558e = "";
        }

        public final d a() {
            return new d(this.f20554a, this.f20555b, this.f20556c, this.f20557d, this.f20558e, null);
        }

        public final a b(int r10) {
            this.f20555b = r10;
            return this;
        }

        public final a c(String r10) {
            q.g(r10, "appName");
            this.f20554a = r10;
            return this;
        }

        public final a d(String r10) {
            q.g(r10, "did");
            this.f20556c = r10;
            return this;
        }

        public final a e(int r10) {
            this.f20557d = r10;
            return this;
        }

        public final a f(String r10) {
            q.g(r10, "versionName");
            this.f20558e = r10;
            return this;
        }
    }

    public /* synthetic */ d(String r10, int r11, String r12, int r13, String r14, DefaultConstructorMarker r15) {
        this(r10, r11, r12, r13, r14);
    }

    public final int a() {
        return this.f20549b;
    }

    public final String b() {
        return this.f20548a;
    }

    public final String c() {
        return this.f20553f;
    }

    public final String d() {
        return this.f20550c;
    }

    public final int e() {
        return this.f20551d;
    }

    public final String f() {
        return this.f20552e;
    }

    public d(String r10, int r11, String r12, int r13, String r14) {
        this.f20548a = r10;
        this.f20549b = r11;
        this.f20550c = r12;
        this.f20551d = r13;
        this.f20552e = r14;
        this.f20553f = g.f20568a.a();
    }
}
