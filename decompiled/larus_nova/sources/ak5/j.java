package ak5;

/* JADX INFO: loaded from: classes18.dex */
public interface j {

    public static abstract class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4033b;

        public a() {
        }
    }

    public static class b extends a {
        public b() {
            this.f4032a = "https://internal-api-space.feishu-boe.cn";
        }
    }

    public static class c extends a {
        public c() {
            this.f4032a = "https://internal-api-space.feishu.cn";
        }
    }

    public static class d extends a {
        public d() {
            this.f4032a = "https://internal-api-space.larksuite.com";
        }
    }

    public static class e extends a {
        public e() {
            this.f4032a = "https://internal-api-space.larksuite-staging.com";
        }
    }

    public static class f extends a {
        public f() {
            this.f4032a = "https://internal-api-space.feishu-staging.cn";
        }
    }
}
