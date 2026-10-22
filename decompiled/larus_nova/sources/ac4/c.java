package ac4;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.n;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f2682d;

    public final void a(String r100) throws JSONException {
        JSONObject r101 = new JSONObject(r100);
        JSONObjectProtectorUtils.getInt(r101, "JSSDK");
        this.f2679a = JSONObjectProtectorUtils.getString(r101, "func");
        this.f2680b = JSONObjectProtectorUtils.getString(r101, "params");
        JSONObjectProtectorUtils.getString(r101, "__msg_type");
        this.f2681c = JSONObjectProtectorUtils.getString(r101, "__callback_id");
    }

    public c(b r100, String r101) {
        this.f2679a = null;
        this.f2680b = null;
        this.f2681c = null;
        this.f2682d = r100;
        a(r101);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        int r102 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public final void d(int r100, JSONObject r101) {
        b r102 = this.f2682d;
        if (r102 != null) goto L8;
        return;
    L8:
        r102.a(c(r100, r101, this).toString());     // Catch: JSONException -> L7
        return;
    }

    public static String b(String r100, JSONObject r101, String r102) {
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L5
        r103.put("code", 1);     // Catch: JSONException -> L5
        r103.put("func", r100);     // Catch: JSONException -> L5
        r103.put("__msg_type", NotificationCompat.CATEGORY_CALL);     // Catch: JSONException -> L5
        r103.put("data", r101);     // Catch: JSONException -> L5
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L5
        r104.put("__params", r103);     // Catch: JSONException -> L5
        r104.put("__callback_id", r102);     // Catch: JSONException -> L5
        return r104.toString();
    L5:
        e = move-exception;
        int r105 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
        return null;
    }

    public static JSONObject c(int r100, JSONObject r101, c r102) throws JSONException {
        JSONObject r103 = new JSONObject();
        r103.put("code", r100);
        r103.put("func", r102.f2679a);
        r103.put("__msg_type", "callback");
        Object r104 = r101;
        if (r101 != null) goto L5;
        r104 = SliceInitService.DEFAULT_SWITCH;
    L5:
        r103.put("data", r104);
        JSONObject r105 = new JSONObject();
        r105.put("__params", r103);
        r105.put("__callback_id", r102.f2681c);
        return r105;
    }
}
