package x0;

import H.h;
import J2.c;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.apm.insight.log.ILog;
import com.apm.insight.log.VLog;
import com.bytedance.services.slardar.config.IConfigManager;
import j1.C1592a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: x0.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2112a {
    public static final C2112a c;

    /* renamed from: a, reason: collision with root package name */
    public boolean f6869a;
    public boolean b;

    static {
        C2112a c2112a = new C2112a();
        c2112a.f6869a = false;
        c2112a.b = true;
        c.f865a.b();
        ((IConfigManager) L2.a.a(IConfigManager.class)).registerConfigListener(new C1592a(c2112a, 2));
        c = c2112a;
    }

    public final void a(String str) {
        JSONObject jSONObject;
        try {
            if (!TextUtils.isEmpty(str) && this.f6869a && this.b) {
                ILog vLog = VLog.getInstance("APMPlus");
                if (vLog != null) {
                    vLog.i("APMPlus", str);
                }
                if (h.b) {
                    try {
                        jSONObject = new JSONObject(str);
                    } catch (JSONException unused) {
                        jSONObject = null;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(jSONObject != null ? jSONObject.optString(NotificationCompat.CATEGORY_SERVICE) : "");
                    sb.append(": ");
                    sb.append(str);
                    Log.d("APMPlus", U7.a.e(new String[]{sb.toString()}));
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
