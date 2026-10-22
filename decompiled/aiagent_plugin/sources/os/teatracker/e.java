package os.teatracker;

import java.util.Map;

/* JADX INFO: compiled from: TeaConfig.java */
/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f40690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static String f40691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f40692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f40693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f40694e;
    private boolean f;
    private Map<String, Object> g;

    /* JADX INFO: compiled from: TeaConfig.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f40695a;

        public a() {
            this.f40695a = new e();
        }

        public a a(String r2) {
            this.f40695a.a(r2);
            return this;
        }

        public e a() {
            return this.f40695a;
        }
    }

    static {
        f40690a = h.a();
        f40691b = "CommonLog";
    }

    public e() {
    }

    void a(String r1) {
        this.f40692c = r1;
    }

    public String a() {
        return this.f40692c;
    }

    public String b() {
        return this.f40693d;
    }

    public String c() {
        return this.f40694e;
    }

    public Map<String, Object> d() {
        return this.g;
    }

    public String toString() {
        return "TeaConfig{keepTeaServiceConnected=" + this.f + '}';
    }
}
