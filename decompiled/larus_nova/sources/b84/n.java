package b84;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdinstall.c1;
import com.bytedance.bdinstall.o0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o0 f18056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.bdinstall.u f18057f;

    @Override // b84.d
    public final boolean a(JSONObject r100) throws JSONException, SecurityException {
        o0 r101 = this.f18056e;
        i84.q.a r102 = i84.q.f488632a;
        c1.i(r100, Constants.OperatorKey.KEY_CARRIER, r101.M.n());
        c1.i(r100, "mcc_mnc", this.f18056e.M.m());
        g84.a r103 = (g84.a) g84.e.a(g84.a.class, String.valueOf(this.f18056e.f199728a));
        c1.i(r100, "clientudid", r103.c());
        if (this.f18057f.f199613a == true) goto L7;
        c1.i(r100, "openudid", r103.getOpenUdid());
        return true;
    L7:
        return true;
    }

    @Override // b84.d
    public final void b(JSONObject r100) {
        r100.remove(Constants.OperatorKey.KEY_CARRIER);
        r100.remove("mcc_mnc");
        r100.remove("clientudid");
        r100.remove("openudid");
    }

    public n(o0 r100, com.bytedance.bdinstall.u r101) {
        super(false, true);
        this.f18056e = r100;
        this.f18057f = r101;
    }
}
