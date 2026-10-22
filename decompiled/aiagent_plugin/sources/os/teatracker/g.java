package os.teatracker;

import org.json.JSONObject;

/* JADX INFO: compiled from: TeaEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f40700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f40701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f40702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f40703d;

    public g(String r2, JSONObject r3) {
        this(r2, r3, false);
    }

    public g(String r7, JSONObject r8, boolean r9) {
        this(r7, r8, r9, System.currentTimeMillis());
    }

    public g(String r2, JSONObject r3, boolean r4, long r5) {
        this.f40703d = false;
        this.f40700a = r2;
        this.f40701b = r3;
        this.f40703d = r4;
        this.f40702c = r5;
    }

    public void a(JSONObject r1) {
        this.f40701b = r1;
    }

    public String a() {
        return this.f40700a;
    }

    public JSONObject b() {
        return this.f40701b;
    }

    public boolean c() {
        return this.f40703d;
    }

    public long d() {
        return this.f40702c;
    }

    public String toString() {
        return "Event{isInstant = '" + this.f40703d + "', event = '" + this.f40700a + "', jsonParams = '" + this.f40701b + "'}";
    }
}
