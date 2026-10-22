package bl4;

import java.nio.charset.StandardCharsets;
import kotlin.UByte;
import org.json.JSONException;
import org.json.JSONObject;
import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f19432d;

    public final String toString() {
        return "DoraWifiPreConnectEvent{mode=5, ssid='" + this.f19429a + "', frequency=" + this.f19431c + ", gcIp='" + a(this.f19432d) + "'}";
    }

    public static String a(byte[] r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length >= 4) goto L7;
        return "";
    L7:
        return (r100[0] & UByte.MAX_VALUE) + "." + (r100[1] & UByte.MAX_VALUE) + "." + (r100[2] & UByte.MAX_VALUE) + "." + (r100[3] & UByte.MAX_VALUE);
    }

    @Override // qk4.e
    public final byte[] getData(int r100) {
        byte[] r101 = n.u(new byte[]{1, 4}, n.l(r100));
        byte[] r102 = {2, 1, (byte) 5};
        JSONObject r103 = new JSONObject();
        r103.put("ssid", this.f19429a);     // Catch: JSONException -> L6
        r103.put("password", this.f19430b);     // Catch: JSONException -> L6
        r103.put("frequency", this.f19431c);     // Catch: JSONException -> L6
        r103.put("gc_ip", a(this.f19432d));     // Catch: JSONException -> L6
    L4:
        byte[] r104 = r103.toString().getBytes(StandardCharsets.UTF_8);
        byte[] r105 = n.u(n.u(n.u(r101, r102), n.u(n.u(new byte[]{3}, n.s(r104.length)), r104)), new byte[]{4, 1, 1});
        return n.u(n.u(new byte[]{-124}, n.s(r105.length)), r105);
    }

    public e(String r100, String r101, int r102, byte[] r103) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.f19429a = r100;
        this.f19430b = r101;
        this.f19431c = r102;
        this.f19432d = r103;
    }
}
