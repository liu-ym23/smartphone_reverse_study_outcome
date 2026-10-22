package cn.com.chinatelecom.account;

import android.net.Network;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Network f24455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f24457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f24458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f24459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f24460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f24461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f24462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, String> f24463k;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f24464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f24465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Network f24466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f24467d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f24468e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f24469f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f24470g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f24471h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f24472i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f24473j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Map<String, String> f24474k;

        public a() {
        }

        public static /* synthetic */ int a(a r100) {
            return r100.f24464a;
        }

        public static /* synthetic */ int b(a r100) {
            return r100.f24465b;
        }

        public static /* synthetic */ Map c(a r100) {
            return r100.f24474k;
        }

        public static /* synthetic */ Network d(a r100) {
            return r100.f24466c;
        }

        public static /* synthetic */ int e(a r100) {
            return r100.f24467d;
        }

        public static /* synthetic */ String f(a r100) {
            return r100.f24468e;
        }

        public static /* synthetic */ String g(a r100) {
            return r100.f24469f;
        }

        public static /* synthetic */ boolean h(a r100) {
            return r100.f24470g;
        }

        public static /* synthetic */ boolean i(a r100) {
            return r100.f24471h;
        }

        public static /* synthetic */ String j(a r100) {
            return r100.f24472i;
        }

        public static /* synthetic */ String k(a r100) {
            return r100.f24473j;
        }

        public a a(int r100) {
            this.f24464a = r100;
            return this;
        }

        public a a(Network r100) {
            this.f24466c = r100;
            return this;
        }

        public a a(String r100) {
            this.f24468e = r100;
            return this;
        }

        public a a(boolean r100) {
            this.f24470g = r100;
            return this;
        }

        public a a(boolean r100, String r101, String r102) {
            this.f24471h = r100;
            this.f24472i = r101;
            this.f24473j = r102;
            return this;
        }

        public w a() {
            return new w(this);
        }

        public a b(int r100) {
            this.f24465b = r100;
            return this;
        }

        public a b(String r100) {
            this.f24469f = r100;
            return this;
        }
    }

    public w(a r100) {
        this.f24453a = a.a(r100);
        this.f24454b = a.b(r100);
        this.f24455c = a.d(r100);
        this.f24456d = a.e(r100);
        this.f24457e = a.f(r100);
        this.f24458f = a.g(r100);
        this.f24459g = a.h(r100);
        this.f24460h = a.i(r100);
        this.f24461i = a.j(r100);
        this.f24462j = a.k(r100);
        this.f24463k = a.c(r100);
    }

    public int a() {
        int r100 = this.f24453a;
        if (r100 > 0) goto L7;
        return 3000;
    L7:
        return r100;
    }

    public int b() {
        int r100 = this.f24454b;
        if (r100 > 0) goto L7;
        return 3000;
    L7:
        return r100;
    }
}
