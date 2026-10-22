package b84;

import android.content.Context;
import com.bytedance.bdinstall.c1;
import com.bytedance.common.utility.NetworkUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f18061e;

    public s(Context r100) {
        super(true, true);
        this.f18061e = r100;
    }

    @Override // b84.d
    public final boolean a(JSONObject r100) throws JSONException {
        c1.i(r100, "access", NetworkUtils.getNetworkAccessType(this.f18061e));
        return true;
    }
}
