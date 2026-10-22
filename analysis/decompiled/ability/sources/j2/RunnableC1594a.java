package j2;

import androidx.core.app.NotificationCompat;
import com.apm.insight.CrashType;
import com.apm.insight.IUploadCallback;
import com.apm.insight.g;
import com.apm.insight.log.ILog;
import g2.C1452a;
import java.util.Map;
import org.json.JSONObject;
import u1.d;
import w2.i;

/* renamed from: j2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1594a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f4754a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ Map d;
    public final /* synthetic */ Map e;
    public final /* synthetic */ IUploadCallback f;

    public RunnableC1594a(long j5, String str, Map map, Map map2, Map map3, IUploadCallback iUploadCallback) {
        this.f4754a = j5;
        this.b = str;
        this.c = map;
        this.d = map2;
        this.e = map3;
        this.f = iUploadCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.b;
        boolean zC = false;
        try {
            n2.a aVarP = d.s().p(CrashType.DART, n2.a.b(g.f2160a, this.f4754a, str));
            Map map = this.c;
            if (map != null) {
                JSONObject jSONObjectOptJSONObject = aVarP.f5345a.optJSONObject("custom");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                n2.a.k(jSONObjectOptJSONObject, map);
                aVarP.e(jSONObjectOptJSONObject, "custom");
            }
            Map map2 = this.d;
            if (map2 != null) {
                JSONObject jSONObjectOptJSONObject2 = aVarP.f5345a.optJSONObject("custom_long");
                if (jSONObjectOptJSONObject2 == null) {
                    jSONObjectOptJSONObject2 = new JSONObject();
                }
                n2.a.k(jSONObjectOptJSONObject2, map2);
                aVarP.e(jSONObjectOptJSONObject2, "custom_long");
            }
            Map map3 = this.e;
            if (map3 != null) {
                JSONObject jSONObjectOptJSONObject3 = aVarP.f5345a.optJSONObject("filters");
                if (jSONObjectOptJSONObject3 == null) {
                    jSONObjectOptJSONObject3 = new JSONObject();
                    aVarP.e(jSONObjectOptJSONObject3, "filters");
                }
                n2.a.k(jSONObjectOptJSONObject3, map3);
            }
            zC = i.a().c(aVarP.f5345a);
            C1452a.b().getClass();
            ILog iLogF = C1452a.f();
            if (iLogF != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("log_type", "dart");
                jSONObject.put(NotificationCompat.CATEGORY_SERVICE, "dart");
                jSONObject.put("body", str);
                iLogF.e("APMPlus", jSONObject.toString());
            }
        } catch (Throwable unused) {
        }
        IUploadCallback iUploadCallback = this.f;
        if (iUploadCallback != null) {
            try {
                iUploadCallback.afterUpload(zC);
            } catch (Throwable unused2) {
            }
        }
    }
}
