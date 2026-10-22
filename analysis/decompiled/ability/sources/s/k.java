package s;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class k extends c {
    public static volatile String e;
    public static final AtomicBoolean f = new AtomicBoolean(false);
    public final Context d;

    public k(Context context) {
        super(true, false);
        this.d = context;
    }

    @Override // s.c
    public final boolean a(JSONObject jSONObject) {
        try {
            if (e == null && f.compareAndSet(false, true)) {
                w.h.a("SimCountryLoader do load sim country", null);
                try {
                    e = ((TelephonyManager) this.d.getSystemService("phone")).getSimCountryIso();
                } catch (Throwable unused) {
                }
                if (e == null) {
                    e = "";
                }
            }
            h.b("sim_region", jSONObject, e);
        } catch (Throwable unused2) {
        }
        return true;
    }
}
