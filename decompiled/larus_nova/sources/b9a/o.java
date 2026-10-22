package b9a;

import android.text.TextUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class o extends a9a.a {
    @Override // a9a.a
    public final String f() {
        return CloudControlInf.ROUTE;
    }

    public o() {
    }

    @Override // a9a.a
    public final boolean g(z8a.a r100) throws Exception {
        if (TextUtils.isEmpty(new JSONObject(r100.f570965a).optString("schema")) == false) goto L6;
        a9a.a.h("路由scheme为空", r100);
        return true;
    L6:
        return false;
    }
}
