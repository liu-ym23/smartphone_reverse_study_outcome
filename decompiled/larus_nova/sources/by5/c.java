package by5;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f21405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f21406c;

    public final String toString() {
        return new JSONObject(new String(this.f21406c)).toString();
    L4:
        return "";
    }

    public c(byte[] r100, long r101, long r102) {
        this.f21406c = r100;
        this.f21404a = r102;
        this.f21405b = r101;
    }
}
