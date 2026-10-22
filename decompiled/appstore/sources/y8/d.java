package y8;

import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.bytedanceos.common.network.FetchURLDataCallBack;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.j;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f26144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FetchURLDataCallBack f26145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f26146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26147d;

    public d(int r10, String r11, FetchURLDataCallBack r12, Object r13) {
        this.f26147d = r10;
        this.f26144a = r11;
        this.f26145b = r12;
        this.f26146c = r13;
    }

    private void d() {
        this.f26145b = null;
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
        j.n("[ApiURL]===========================AppStoreResponse.onError=====================================");
        j.n("[ApiURL] StatusCode : " + r10.f26133a);
        j.n("[ApiURL] url        : " + this.f26144a);
        j.n("[ApiURL] body       : " + r10.f26135c);
        j.n("[ApiURL] Error      : " + r10.f26136d);
        j.n("[ApiURL]==========================================================================================");
        VolleyError r11 = r10.f26136d;
        if (r11 == null) goto L5;
        j.b(r11.getMessage());
        r10.f26136d.printStackTrace();
    L5:
        FetchURLDataCallBack r12 = this.f26145b;
        if (r12 == null) goto L8;
        r12.OnFetchURLDataFailed(this.f26144a, r10.f26136d, r10.f26135c, this.f26146c);
    L8:
        d();
    }

    @Override // y8.a
    public void b(a.C0414a r10) {
        e(r10);
        j.n("[ApiURL]===========================AppStoreResponse.onFailure=====================================");
        j.n("[ApiURL] StatusCode : " + r10.f26133a);
        j.n("[ApiURL] url        : " + this.f26144a);
        j.n("[ApiURL] body       : " + r10.f26135c);
        j.n("[ApiURL] Error      : " + r10.f26136d);
        j.n("[ApiURL]==========================================================================================");
        VolleyError r11 = r10.f26136d;
        if (r11 == null) goto L5;
        j.b(r11.getMessage());
        r10.f26136d.printStackTrace();
    L5:
        FetchURLDataCallBack r12 = this.f26145b;
        if (r12 == null) goto L8;
        r12.OnFetchURLDataFailed(this.f26144a, r10.f26136d, r10.f26135c, this.f26146c);
    L8:
        d();
    }

    @Override // y8.a
    public void c(a.C0414a r10) {
        e(r10);
        j.a("[ApiURL]===========================AppStoreResponse.onSuccess=====================================");
        j.a("[ApiURL] StatusCode : " + r10.f26133a);
        j.a("[ApiURL] url        : " + this.f26144a);
        j.a("[ApiURL] body       : " + r10.f26135c);
        j.a("[ApiURL] Error      : " + r10.f26136d);
        j.a("[ApiURL]==========================================================================================");
        VolleyError r11 = r10.f26136d;
        if (r11 == null) goto L6;
        j.b(r11.getMessage());
        r10.f26136d.printStackTrace();
    L6:
        if (this.f26145b == null) goto L26;
        int r12 = -1;
        String r13 = r10.f26135c;     // Catch: Exception -> L28
        if (TextUtils.isEmpty(r13) == true) goto L29;
        JSONObject r14 = new JSONObject(r13);     // Catch: Exception -> L28
        if (this.f26147d != 1800000) goto L15;
        r12 = r14.getInt(ServerElements.CODE);     // Catch: Exception -> L28
        goto L29
    L15:
        if (r14.isNull(ServerElements.HEAD) == true) goto L29;
        r12 = r14.getJSONObject(ServerElements.HEAD).getInt(ServerElements.CODE);     // Catch: Exception -> L28
    L29:
    L19:
        if (this.f26147d == 1800000) goto L23;
        if (r12 == 0) goto L23;
        this.f26145b.OnFetchURLDataFailed(this.f26144a, r10.f26136d, r10.f26135c, this.f26146c);
    L23:
        if (r12 == 0) goto L25;
        j.n(r10.f26135c);
    L25:
        this.f26145b.OnFetchURLDataSuccess(this.f26144a, r10.f26133a, r10.f26135c, this.f26146c);
    L26:
        d();
    }
}
