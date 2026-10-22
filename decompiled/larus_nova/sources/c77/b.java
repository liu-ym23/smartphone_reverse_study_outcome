package c77;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.support.impl.PushNetworkClient;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.utils.f;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.util.ToolUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import yfc.d;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f22654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f22655b;

    public final void a() {
        Map<String, String> r100 = PushSupporter.get().getCommonParams();
        String r101 = null;
        byte[] r102 = null;
        r102 = null;
        if (TextUtils.equals(this.f22654a, "click") == false) goto L9;
        Set<Integer> r103 = d.f567458a;
        String r104 = ToolUtils.addUrlParam(yfc.a.a("/cloudpush/callback/client_click/"), r100);
        JSONObject r105 = this.f22655b;
        if (r105 == null) goto L7;
        r102 = r105.toString().getBytes();
    L7:
        byte[] r106 = r102;
        r101 = r104;
        byte[] r107 = r106;
    L15:
        if (TextUtils.isEmpty(r101) == false) goto L18;
        f.e("MessageCallbackServiceImpl", "failed callback " + this.f22654a + " because url is null");
        return;
    L18:
        NetworkClient.ReqContext r108 = new NetworkClient.ReqContext();
        r108.addCommonParams = false;
        HashMap r109 = new HashMap();     // Catch: Throwable -> L21
        r109.put("Content-Type", "application/json");     // Catch: Throwable -> L21
        JSONObject r110 = new JSONObject(PushNetworkClient.getDefault().post(r101, r107, ToolUtils.addNetworkTagToHeader(r109), r108));     // Catch: Throwable -> L21
        f.b("MessageCallbackServiceImpl", "finished callback " + this.f22654a + ",code:" + r110.optInt("code") + " reason:" + r110.optString("reason") + " errMsg:" + r110.optString(LocationMonitorConst.ERR_MSG));     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        f.e("MessageCallbackServiceImpl", "error when callback " + this.f22654a + HTTP.HEADER_LINE_DELIM + th.getLocalizedMessage());
        return;
    L9:
        if (TextUtils.equals(this.f22654a, "show") == false) goto L13;
        Set<Integer> r111 = d.f567458a;
        r104 = ToolUtils.addUrlParam(yfc.a.a("/cloudpush/callback/client_show/"), r100);
        if (this.f22655b == null) goto L7;
        JSONArray r112 = new JSONArray();
        r112.put(this.f22655b);
        r102 = r112.toString().getBytes();
        goto L7
    L13:
        r107 = null;
        goto L15
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(String r100, JSONObject r101) {
        this.f22654a = r100;
        this.f22655b = r101;
    }
}
