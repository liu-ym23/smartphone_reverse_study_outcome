package y9;

import android.text.TextUtils;
import com.monitor.cloudmessage.callback.IRouteConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class o extends x9.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IRouteConsumer f26186b;

    public o() {
        this.f26186b = null;
    }

    @Override // x9.a
    public String d() {
        return CloudControlInf.ROUTE;
    }

    @Override // x9.a
    public boolean e(w9.a r10) {
        String r11 = new JSONObject(r10.c()).optString("schema");
        if (TextUtils.isEmpty(r11) == false) goto L6;
        i("路由scheme为空", r10);
        return true;
    L6:
        IRouteConsumer r12 = this.f26186b;
        if (r12 == null) goto L13;
        r12.handleRouteUrl(r11);
        w9.b r13 = this.f26186b.getConsumerResult();
        if (r13.d() == false) goto L11;
        j(r10);
    L12:
        return true;
    L11:
        h(r13.b(), r13.c(), r10);
        goto L12
    L13:
        return false;
    }

    public void k(IRouteConsumer r10) {
        this.f26186b = r10;
    }
}
