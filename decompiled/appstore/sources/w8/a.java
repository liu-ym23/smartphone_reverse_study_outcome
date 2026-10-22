package w8;

import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.network.api.BaseAPIHelper;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends CommonAPIHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f25385b;

    public a() {
    }

    public static synchronized a j0() {
        monitor-enter(a.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f25385b != null) goto L9;
        f25385b = new a();     // Catch: Throwable -> L7
    L9:
        a r10 = f25385b;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r10;
    }

    public static void l0(int r10, int r11, Object[] r12, Map r13, String r14, FetchDataCallBack r15) {
        BaseAPIHelper.e(4, r10, r11, r12, r13, r14, new y8.b(r11, r15));
    }

    public void h0(FetchDataCallBack r10) {
        l0(1, 1000005, new Object[]{""}, null, null, r10);
    }

    public void i0(FetchDataCallBack r10) {
        HashMap r11 = new HashMap();
        r11.put("access_token", AccountDataCache.b().j());
        l0(1, 1000008, new Object[]{""}, r11, null, r10);
    }

    public void k0(String r10, FetchDataCallBack r11) {
        l0(4, 1000002, new Object[]{r10}, null, null, r11);
    }

    public void m0(Object r10, FetchDataCallBack r11) {
        JSONObject r12 = new JSONObject();
        JSONObject r13 = new JSONObject();
        r13.put(ServerElements.NICKNAME, r10);     // Catch: Exception -> L7
        r12.put("user", r13);     // Catch: Exception -> L7
        if (r12.length() == 0) goto L9;
        String r14 = r12.toString();     // Catch: Exception -> L7
    L10:
        l0(3, 1000007, null, null, r14, r11);     // Catch: Exception -> L7
        return;
    L9:
        r14 = null;
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
