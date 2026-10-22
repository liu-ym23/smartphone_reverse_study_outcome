package yb;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f26192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f26193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f26194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f26195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f26196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f26197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f26198g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f26199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f26200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f26201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26202d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f26203e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f26204f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f26205g;

        public a() {
            this.f26199a = "";
            this.f26201c = "";
            this.f26203e = "";
            this.f26204f = "";
            this.f26205g = "";
        }

        public final b a() {
            return new b(this.f26199a, this.f26200b, this.f26201c, this.f26202d, this.f26203e, this.f26204f, this.f26205g, null);
        }

        public final a b(String r10) {
            q.g(r10, "clientPkgName");
            this.f26205g = r10;
            return this;
        }

        public final a c(int r10) {
            this.f26202d = r10;
            return this;
        }

        public final a d(String r10) {
            q.g(r10, "pkgName");
            this.f26199a = r10;
            return this;
        }

        public final a e(String r10) {
            q.g(r10, "receiverClassName");
            this.f26203e = r10;
            return this;
        }

        public final a f(int r10) {
            this.f26200b = r10;
            return this;
        }

        public final a g(String r10) {
            q.g(r10, "versionName");
            this.f26201c = r10;
            return this;
        }
    }

    public b(String r10, int r11, String r12, int r13, String r14, String r15, String r16) {
        this.f26192a = r10;
        this.f26193b = r11;
        this.f26194c = r12;
        this.f26195d = r13;
        this.f26196e = r14;
        this.f26197f = r15;
        this.f26198g = r16;
    }

    public final String a() {
        return this.f26198g;
    }

    public final int b() {
        return this.f26195d;
    }

    public final String c() {
        return this.f26197f;
    }

    public final String d() {
        return this.f26192a;
    }

    public final String e() {
        return this.f26196e;
    }

    public String toString() {
        return "DownloadConfig(pkgName='" + this.f26192a + "', versionCode=" + this.f26193b + ", versionName='" + this.f26194c + "', concurrentNum=" + this.f26195d + ", receiverClassName='" + this.f26196e + "',clientPkgName='" + this.f26198g + "')";
    }

    public /* synthetic */ b(String r10, int r11, String r12, int r13, String r14, String r15, String r16, DefaultConstructorMarker r17) {
        this(r10, r11, r12, r13, r14, r15, r16);
    }
}
