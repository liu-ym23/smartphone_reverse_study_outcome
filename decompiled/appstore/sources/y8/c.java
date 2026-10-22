package y8;

import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.j;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f26141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FetchDataCallBack f26142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f26143c;

    public c(int r10, FetchDataCallBack r11, Object r12) {
        this.f26141a = r10;
        this.f26142b = r11;
        this.f26143c = r12;
    }

    private void e(a.C0414a r10) {
        if (r10 == null) goto L11;
        Map r11 = r10.f26134b;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.size() != 0) goto L8;
        return;
    L8:
        if (r10.f26134b.containsKey("Set-Ticket") == false) goto L14;
        AccountDataCache.b().u(((String) r10.f26134b.get("Set-Ticket")).split(";")[0]);
        return;
    L14:
        return;
    }

    @Override // y8.a
    public void a(a.C0414a r10) {
        e(r10);
        j.n("[ApiCode:" + this.f26141a + "]===========================AppStoreResponse.onError=======================================");
        j.n("[ApiCode:" + this.f26141a + "] StatusCode : " + r10.f26133a);
        j.n("[ApiCode:" + this.f26141a + "] body       : " + r10.f26135c);
        j.n("[ApiCode:" + this.f26141a + "] Error      : " + r10.f26136d);
        StringBuilder r11 = new StringBuilder();
        r11.append("[ApiCode:");
        r11.append(this.f26141a);
        r11.append("]==========================================================================================");
        j.n(r11.toString());
        VolleyError r12 = r10.f26136d;
        if (r12 == null) goto L5;
        j.q("AppStoreResponse.onError", r12);
    L5:
        FetchDataCallBack r13 = this.f26142b;
        if (r13 == null) goto L8;
        r13.onFetchDataFailed(this.f26141a, r10.f26136d, r10.f26135c, this.f26143c);
    L8:
        d();
    }

    @Override // y8.a
    public void b(a.C0414a r10) {
        e(r10);
        j.n("[ApiCode:" + this.f26141a + "]===========================AppStoreResponse.onFailure=====================================");
        j.n("[ApiCode:" + this.f26141a + "] StatusCode : " + r10.f26133a);
        j.n("[ApiCode:" + this.f26141a + "] body       : " + r10.f26135c);
        j.n("[ApiCode:" + this.f26141a + "] Error      : " + r10.f26136d);
        StringBuilder r11 = new StringBuilder();
        r11.append("[ApiCode:");
        r11.append(this.f26141a);
        r11.append("]==========================================================================================");
        j.n(r11.toString());
        VolleyError r12 = r10.f26136d;
        if (r12 == null) goto L5;
        j.q("AppStoreResponse.onFailure", r12);
    L5:
        FetchDataCallBack r13 = this.f26142b;
        if (r13 == null) goto L8;
        r13.onFetchDataFailed(this.f26141a, r10.f26136d, r10.f26135c, this.f26143c);
    L8:
        d();
    }

    @Override // y8.a
    public void c(a.C0414a r12) {
        e(r12);
        j.a("[ApiCode:" + this.f26141a + "]===========================AppStoreResponse.onSuccess=====================================");
        j.a("[ApiCode:" + this.f26141a + "] StatusCode : " + r12.f26133a);
        j.a("[ApiCode:" + this.f26141a + "] body       : " + r12.f26135c);
        j.a("[ApiCode:" + this.f26141a + "] Error      : " + r12.f26136d);
        StringBuilder r10 = new StringBuilder();
        r10.append("[ApiCode:");
        r10.append(this.f26141a);
        r10.append("]==========================================================================================");
        j.a(r10.toString());
        VolleyError r11 = r12.f26136d;
        if (r11 == null) goto L6;
        j.q("AppStoreResponse.onSuccess with error", r11);
    L6:
        if (this.f26142b == null) goto L23;
        int r13 = -1;
        String r14 = r12.f26135c;     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r14) == true) goto L14;
        JSONObject r15 = new JSONObject(r14);     // Catch: Exception -> L25
        if (r15.isNull(ServerElements.HEAD) == true) goto L14;
        r13 = r15.getJSONObject(ServerElements.HEAD).getInt(ServerElements.CODE);     // Catch: Exception -> L25
    L14:
        int r16 = r13;
        if (r16 != 0) goto L17;
        this.f26142b.onFetchDataSuccess(this.f26141a, r12.f26133a, r12.f26135c, this.f26143c, r12.f26137e);
        goto L23
    L17:
        int r17 = this.f26141a;
        if (r17 == 600002) goto L20;
    L22:
        this.f26142b.onFetchDataFailed(r17, r12.f26136d, r12.f26135c, this.f26143c);
        goto L23
    L20:
        if (r16 != 1006007) goto L22;
        this.f26142b.onFetchDataSuccess(r17, r16, r12.f26135c, this.f26143c, r12.f26137e);
    L23:
        d();
    }

    public final void d() {
        this.f26142b = null;
    }
}
