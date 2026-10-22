package b84;

import android.content.SharedPreferences;
import com.bytedance.bdinstall.c1;
import com.bytedance.bdinstall.o0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o0 f18064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.bdinstall.u f18065f;

    @Override // b84.d
    public final boolean a(JSONObject r110) throws JSONException {
        SharedPreferences r100 = this.f18065f.a(this.f18064e);
        String r101 = ((g84.a) g84.e.a(g84.a.class, String.valueOf(this.f18064e.f199728a))).getDeviceId();
        String r102 = r100.getString("bd_did", null);
        String r103 = r100.getString("install_id", null);
        String r104 = r100.getString("ssid", null);
        String r111 = r100.getString("klink_edi", null);
        String r112 = r100.getString("klink_eii", null);
        String r105 = r100.getString("klink_egdi", null);
        int r106 = com.bytedance.bdinstall.t.f199790a;
        c1.i(r110, "install_id", r103);
        c1.i(r110, "device_id", r101);
        c1.i(r110, "ssid", r104);
        c1.i(r110, "bd_did", r102);
        c1.i(r110, "klink_edi", r111);
        c1.i(r110, "klink_eii", r112);
        c1.i(r110, "klink_egdi", r105);
        return true;
    }

    @Override // b84.d
    public final void b(JSONObject r100) throws SecurityException {
        r100.remove("bd_did");
        r100.remove("install_id");
        r100.remove("ssid");
        r100.remove("device_id");
        r100.remove("klink_edi");
        r100.remove("klink_eii");
    }

    public w(o0 r100, com.bytedance.bdinstall.u r101) {
        this.f18064e = r100;
        this.f18065f = r101;
    }
}
