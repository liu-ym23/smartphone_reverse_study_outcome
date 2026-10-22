package s;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class i extends c {
    public static volatile String f;
    public static volatile String g;
    public static final AtomicBoolean h = new AtomicBoolean(false);
    public final Context d;
    public final h e;

    public i(Context context, h hVar) {
        super(false, false);
        this.d = context;
        this.e = hVar;
    }

    @Override // s.c
    public final boolean a(JSONObject jSONObject) {
        try {
            if (f == null || g == null) {
                if (h.compareAndSet(false, true)) {
                    TelephonyManager telephonyManager = (TelephonyManager) this.d.getSystemService("phone");
                    w.h.a("DeviceParamsLoader do load operator", null);
                    if (telephonyManager != null) {
                        f = telephonyManager.getNetworkOperatorName();
                        g = telephonyManager.getNetworkOperator();
                    } else {
                        f = "";
                        g = "";
                    }
                } else {
                    f = "";
                    g = "";
                }
                h.b("carrier", jSONObject, f);
                h.b("mcc_mnc", jSONObject, g);
            }
        } catch (Throwable unused) {
            f = "";
            g = "";
            try {
                h.b("carrier", jSONObject, f);
                h.b("mcc_mnc", jSONObject, g);
            } catch (Throwable unused2) {
            }
        }
        try {
            h.b("clientudid", jSONObject, this.e.g.j());
            h.b("openudid", jSONObject, this.e.g.g());
            j.a(this.d);
        } catch (Throwable unused3) {
        }
        return true;
    }
}
