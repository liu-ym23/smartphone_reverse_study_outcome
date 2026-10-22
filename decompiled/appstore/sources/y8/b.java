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
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f26138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FetchDataCallBack f26139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f26140c;

    public b(int r10, FetchDataCallBack r11) {
        this.f26138a = r10;
        this.f26139b = r11;
    }

    @Override // y8.a
    public void a(a.C0414a r10) {
        d(r10);
        j.a("[ApiCode:" + this.f26138a + "]===========================AccountResponse.onError========================================");
        j.a("[ApiCode:" + this.f26138a + "] StatusCode : " + r10.f26133a);
        j.a("[ApiCode:" + this.f26138a + "] body       : " + r10.f26135c);
        j.a("[ApiCode:" + this.f26138a + "] Error      : " + r10.f26136d);
        StringBuilder r11 = new StringBuilder();
        r11.append("[ApiCode:");
        r11.append(this.f26138a);
        r11.append("]==========================================================================================");
        j.a(r11.toString());
        VolleyError r12 = r10.f26136d;
        if (r12 == null) goto L5;
        j.b(r12.getMessage());
        r10.f26136d.printStackTrace();
    L5:
        FetchDataCallBack r13 = this.f26139b;
        if (r13 == null) goto L9;
        r13.onFetchDataFailed(this.f26138a, r10.f26136d, r10.f26135c, this.f26140c);
        return;
    }

    @Override // y8.a
    public void b(a.C0414a r10) {
        d(r10);
        j.a("[ApiCode:" + this.f26138a + "]===========================AccountResponse.onFailure======================================");
        j.a("[ApiCode:" + this.f26138a + "] StatusCode : " + r10.f26133a);
        j.a("[ApiCode:" + this.f26138a + "] body       : " + r10.f26135c);
        j.a("[ApiCode:" + this.f26138a + "] Error      : " + r10.f26136d);
        StringBuilder r11 = new StringBuilder();
        r11.append("[ApiCode:");
        r11.append(this.f26138a);
        r11.append("]==========================================================================================");
        j.a(r11.toString());
        VolleyError r12 = r10.f26136d;
        if (r12 == null) goto L5;
        j.b(r12.getMessage());
        r10.f26136d.printStackTrace();
    L5:
        FetchDataCallBack r13 = this.f26139b;
        if (r13 == null) goto L9;
        r13.onFetchDataFailed(this.f26138a, r10.f26136d, r10.f26135c, this.f26140c);
        return;
    }

    @Override // y8.a
    public void c(a.C0414a r10) {
        d(r10);
        j.a("[ApiCode:" + this.f26138a + "]===========================AccountResponse.onSuccess======================================");
        j.a("[ApiCode:" + this.f26138a + "] StatusCode : " + r10.f26133a);
        j.a("[ApiCode:" + this.f26138a + "] body       : " + r10.f26135c);
        j.a("[ApiCode:" + this.f26138a + "] Error      : " + r10.f26136d);
        StringBuilder r11 = new StringBuilder();
        r11.append("[ApiCode:");
        r11.append(this.f26138a);
        r11.append("]==========================================================================================");
        j.a(r11.toString());
        VolleyError r12 = r10.f26136d;
        if (r12 == null) goto L6;
        j.b(r12.getMessage());
        r10.f26136d.printStackTrace();
    L6:
        if (this.f26139b == null) goto L18;
        int r13 = -1;
        String r14 = r10.f26135c;     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r14) == true) goto L11;
        r13 = new JSONObject(r14).optInt(ServerElements.ERRNO, 0);     // Catch: Exception -> L15
    L11:
        if (r13 != 0) goto L13;
        this.f26139b.onFetchDataSuccess(this.f26138a, r10.f26133a, r10.f26135c, this.f26140c, r10.f26137e);
        return;
    L13:
        this.f26139b.onFetchDataFailed(this.f26138a, r10.f26136d, r10.f26135c, this.f26140c);
        return;
    }

    public final void d(a.C0414a r10) {
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
}
