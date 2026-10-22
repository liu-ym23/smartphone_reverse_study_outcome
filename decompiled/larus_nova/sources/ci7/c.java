package ci7;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.deeplink.ZlinkApi;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f23860a = 0;

    static {
    }

    public static void a(String r110, String r111, boolean r112, fi7.b r113) {
        String r100 = "";
        String r101 = UriProtector.parse(r111).buildUpon().appendQueryParameter("zlink", r110).appendQueryParameter("zlink_click_time", "" + (System.currentTimeMillis() / ((long) 1000))).build().toString();     // Catch: Exception -> L39
        JSONObject r102 = new JSONObject();
        r102.put("scheme", r101);
        JSONObject r103 = new JSONObject();
        Map r104 = MapsKt.emptyMap();
        String r105 = r102.toString();
        Charset r106 = Charsets.UTF_8;
        if (r105 == null) goto L38;
        String r107 = mi7.f.c("https://zlink.toutiao.com/api/cb_e", r104, r105.getBytes(r106), 0, r103);
        if (r107 != null) goto L52;
        String r114 = r103.optString("code", "response is null.");
        mi7.c.c(-1, r114, r110, r111);
        fi7.d.c(r113, -1, r114);
        return;
    L52:
        JSONObject r108 = new JSONObject(r107);     // Catch: JSONException -> L27
        int r109 = r108.optInt("code", -1);
        String r115 = r108.optString("message");
        if (r109 != 0) goto L26;
        String r116 = r108.optString("data");
        if (TextUtils.isEmpty(r116) == true) goto L25;
        if (r112 == false) goto L21;
        Application r117 = l.f23871a;
        if (r117 == null) goto L21;
        di7.a r118 = ZlinkApi.INSTANCE.getClipboardHandler();
        if (r118 == null) goto L21;
        r118.i(r117, r116, r116);
    L21:
        mi7.c.c(0, "success", r110, r111);
        String r119 = fi7.d.f477411a;
        if (mi7.h.d() == false) goto L24;
        r113.onSuccess();
        return;
    L24:
        mi7.h.e(new fi7.c(r113, r116));
        return;
    L25:
        mi7.c.c(-2, "token is empty.", r110, r111);
        fi7.d.c(r113, -2, "token is empty.");
        return;
    L26:
        mi7.c.c(r109, r115, r110, r111);
        fi7.d.c(r113, r109, r115);
        return;
    L27:
        e = move-exception;
        String r120 = e.getMessage();
        if (r120 != null) goto L32;
        r120 = "";
    L32:
        mi7.c.c(-2, r120, r110, r111);
        String r121 = e.getMessage();
        if (r121 == null) goto L35;
        r100 = r121;
    L35:
        fi7.d.c(r113, -2, r100);
        return;
    L38:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L39:
        e = move-exception;
        String r122 = e.getMessage();
        if (r122 != null) goto L44;
        r122 = r111 + "is not a valid url.";
    L44:
        mi7.c.c(10003, r122, r110, r111);
        String r123 = e.getMessage();
        if (r123 != null) goto L48;
        r123 = r111 + "is not a valid url.";
    L48:
        fi7.d.c(r113, 10003, r123);
    }
}
