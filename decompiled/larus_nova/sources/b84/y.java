package b84;

import com.bytedance.bdinstall.c1;
import com.bytedance.bdinstall.o0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o0 f18067e;

    public y(o0 r100) {
        super(true, false);
        this.f18067e = r100;
    }

    @Override // b84.d
    public final boolean a(JSONObject r100) throws JSONException {
        o0 r101 = this.f18067e;
        i84.q.a r102 = i84.q.f488632a;
        c1.i(r100, "sim_region", r101.M.q());
        return true;
    }
}
