package cc4;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f23286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f23288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f23289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f23290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f23291f;

    public h() {
    }

    public final h a() {
        h r100 = new h();
        r100.f23286a = this.f23286a;
        r100.f23287b = this.f23287b;
        r100.f23288c = this.f23288c;
        r100.f23289d = this.f23289d;
        r100.f23290e = this.f23290e;
        r100.f23291f = this.f23291f;
        return r100;
    }

    public final JSONObject b() {
        JSONObject r100 = new JSONObject();
        r100.put("t", this.f23286a);     // Catch: Exception -> L5
        r100.put("p", this.f23287b);     // Catch: Exception -> L5
        r100.put("x", this.f23288c);     // Catch: Exception -> L5
        r100.put("y", this.f23289d);     // Catch: Exception -> L5
        r100.put("r", this.f23290e);     // Catch: Exception -> L5
        r100.put("f", this.f23291f);     // Catch: Exception -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
