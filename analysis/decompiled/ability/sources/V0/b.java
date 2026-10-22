package V0;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f1300a;

    public final String toString() {
        try {
            return new JSONObject(new String(this.f1300a)).toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
