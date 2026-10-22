package q2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f23505a;

    public b(byte[] r10) {
        this.f23505a = r10;
    }

    public byte[] a() {
        return this.f23505a;
    }

    public String toString() {
        return new JSONObject(new String(this.f23505a)).toString();
    L4:
        return "";
    }
}
