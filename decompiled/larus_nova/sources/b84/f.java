package b84;

import android.text.TextUtils;
import com.bytedance.bdinstall.o0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o0 f18023e;

    public f(o0 r100) {
        super(true, true);
        this.f18023e = r100;
    }

    @Override // b84.d
    public final boolean a(JSONObject r100) throws JSONException, SecurityException {
        String r101 = com.bytedance.bdinstall.n.b(this.f18023e);
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r100.put("cdid", r101);
        return true;
    L6:
        return false;
    }

    @Override // b84.d
    public final void b(JSONObject r100) {
        r100.remove("cdid");
    }
}
