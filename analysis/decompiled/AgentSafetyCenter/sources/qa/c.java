package qa;

import android.content.Context;
import android.text.TextUtils;
import com.stepos.agentsafetycenter.AgentSafetyApplication;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import p5.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public a f10211a;

    /* renamed from: b, reason: collision with root package name */
    public a f10212b;

    /* renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap f10213c;

    /* renamed from: d, reason: collision with root package name */
    public ConcurrentHashMap f10214d;

    public static HashMap a(Context context) {
        String strO;
        HashMap map = new HashMap();
        Double dValueOf = Double.valueOf(0.0d);
        map.put("longitude", dValueOf);
        map.put("latitude", dValueOf);
        map.put("loc_time", 0L);
        map.put("operator", "");
        map.put("stepos_uid", "");
        if (TextUtils.isEmpty(ra.b.f10523g)) {
            Locale locale = context.getResources().getConfiguration().locale;
            String language = locale.getLanguage();
            String country = locale.getCountry();
            if (language == null) {
                language = "";
            }
            strO = k0.a.o(language, "_", country != null ? country : "");
            ra.b.f10523g = strO;
        } else {
            strO = ra.b.f10523g;
        }
        map.put("lla", strO);
        ua.c.a("c", "getVolatileProperty ..." + map);
        return map;
    }

    public static c b(AgentSafetyApplication agentSafetyApplication, String str, String str2) {
        ua.c.d("c", "buildSubject start， replacePackage: ");
        if (TextUtils.isEmpty("")) {
            i iVar = new i();
            iVar.f9730c = agentSafetyApplication;
            iVar.f9731f = str;
            iVar.f9732g = str2;
            return iVar.d();
        }
        i iVar2 = new i();
        iVar2.f9730c = agentSafetyApplication;
        iVar2.f9731f = str;
        iVar2.f9732g = str2;
        iVar2.f9733h = "";
        return iVar2.d();
    }

    public final void c(int i, String str) {
        if (str.isEmpty()) {
            return;
        }
        this.f10214d.put(str, Integer.valueOf(i));
    }

    public final void d(String str, String str2) {
        if (str.isEmpty() || str2 == null) {
            return;
        }
        this.f10214d.put(str, str2);
    }
}
