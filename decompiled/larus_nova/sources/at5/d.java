package at5;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.log.Log;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f16253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f16255d;

    @Override // at5.j
    public final void a(Status r100, Object r110) {
        Intrinsics.checkNotNullParameter(r100, "status");
        String r101 = this.f16252a;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        int r103 = h.f16256a;
        h.b(this.f16253b.f16231a, 10005, this.f16254c + " 's callbackId isNullOrEmpty!", this.f16254c);
        return;
    L11:
        this.f16253b.f16239i.getClass();
        l r104 = this.f16253b.f16239i.a(r100, this.f16252a, r110, this.f16255d);
        HashMap r105 = new HashMap();
        if (r104 == null) goto L15;
        String r106 = r104.f16259b;
        if (r106 == null) goto L15;
    L16:
        r105.put("callbackID", r106);
        if (r104 == null) goto L22;
        Object r107 = r104.f16260c;
        if (r107 == null) goto L22;
        r110 = r107;
    L22:
        r105.put("data", r110);
        if (r104 == null) goto L28;
        Status r108 = r104.f16258a;
        if (r108 == null) goto L28;
        String r109 = r108.getStatus();
        if (r109 == null) goto L28;
    L29:
        r105.put("callbackType", r109);
        a r111 = this.f16253b;
        if (r104 == null) goto L32;
        Object r112 = r104.f16261d;
    L33:
        String r113 = this.f16255d;
        r111.getClass();
    L49:
        e = move-exception;
        Log.e("JSBridge", e);
        JSONObject r114 = new JSONObject();
    L52:
        if ((r110 instanceof JSONObject) == false) goto L58;
        JSONObject r115 = (JSONObject) ((ConcurrentHashMap) this.f16253b.f16238h).get(this.f16254c);
        if (r115 == null) goto L57;
        r114 = r115;
    L57:
        r105.put("extra", r114);
        StringCompanionObject r116 = StringCompanionObject.INSTANCE;
        String r117 = String.format(Bridge.CALLBACK_FUN, Arrays.copyOf(new Object[]{new JSONObject(r105).toString()}, 1));
    L75:
        Log.d("JSBridge", "evaluateJavascript for jsapi callback, script = " + r117);
        this.f16253b.f16231a.evaluateJavascript(r117, null);
        return;
    L58:
        Object r118 = (JSONObject) ((ConcurrentHashMap) this.f16253b.f16238h).get(this.f16254c);
        if (r118 != null) goto L65;
        if (r114 == null) goto L63;
        String r119 = r114.toString();
        if (r119 == null) goto L63;
    L64:
        r118 = JSON.parseObject(r119);
    L63:
        r119 = "";
    L65:
        r105.put("extra", r118);
        String r120 = new com.alibaba.fastjson.JSONObject(r105).toJSONString();
        g r121 = this.f16253b.f16235e;
        Intrinsics.checkNotNull(r120);
        r121.getClass();
        Intrinsics.checkNotNullParameter(r105, "params");
        Intrinsics.checkNotNullParameter(r120, "result");
    L72:
        th = move-exception;
        Log.e("BridgeInfoPrinter", "Failed to printLengthInfo, ", th);
    L74:
        StringCompanionObject r122 = StringCompanionObject.INSTANCE;
        r117 = String.format(Bridge.CALLBACK_FUN, Arrays.copyOf(new Object[]{r120}, 1));
        goto L75
    L67:
        if (TextUtils.isEmpty(r120) == true) goto L74;
        if (r120.length() <= 2097152) goto L74;
        g.a(r105, "param before serialize ");     // Catch: Throwable -> L72
        g.a(r120, "param after serialize ");     // Catch: Throwable -> L72
        goto L74
    L35:
        if ((r112 instanceof JSONObject) == false) goto L38;
        Log.d("JSBridge", "extensionExtra is JSONObject");     // Catch: JSONException -> L49
        r114 = (JSONObject) r112;     // Catch: JSONException -> L49
        goto L52
    L38:
        if ((r112 instanceof com.alibaba.fastjson.JSONObject) == false) goto L42;
        Log.d("JSBridge", "extensionExtra is com.alibaba.fastjson.JSONObject");     // Catch: JSONException -> L49
        JSONObject r123 = new JSONObject(((com.alibaba.fastjson.JSONObject) r112).toJSONString());     // Catch: JSONException -> L49
    L40:
        r114 = r123;
        goto L52
    L42:
        if ((r112 instanceof String) == true) goto L44;
        r114 = new JSONObject();     // Catch: JSONException -> L49
        goto L52
    L44:
        if (TextUtils.isEmpty((CharSequence) r112) == false) goto L46;
        Log.d("JSBridge", "extensionExtra is empty , will return defaultExtraStr");     // Catch: JSONException -> L49
        r114 = new JSONObject(r113);     // Catch: JSONException -> L49
        goto L52
    L46:
        r123 = new JSONObject((String) r112);     // Catch: JSONException -> L49
        goto L40
    L32:
        r112 = null;
    L28:
        r109 = r100.getStatus();
    L15:
        r106 = this.f16252a;
        goto L16
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public d(String r100, a r101, String r102, String r103) {
        this.f16252a = r100;
        this.f16253b = r101;
        this.f16254c = r102;
        this.f16255d = r103;
        System.currentTimeMillis();
    }
}
