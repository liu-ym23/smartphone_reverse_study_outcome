package b84;

import com.bytedance.bdinstall.o0;
import com.bytedance.bdinstall.util.DeviceCategory;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o0 f18035e;

    public l(o0 r100) {
        super(true, true);
        this.f18035e = r100;
    }

    @Override // b84.d
    public final boolean a(JSONObject r100) throws JSONException, SecurityException {
        DeviceCategory r101 = this.f18035e.L;     // Catch: JSONException -> L9
        if (r101 == null) goto L5;
        String r102 = r101.getLower();     // Catch: JSONException -> L9
    L6:
        r100.put("device_category", r102);     // Catch: JSONException -> L9
        return true;
    L5:
        r102 = null;
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
