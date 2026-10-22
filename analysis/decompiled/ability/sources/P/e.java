package P;

import H.h;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e implements N.b {

    /* renamed from: a, reason: collision with root package name */
    public String f1057a;
    public String b;
    public String c;
    public JSONObject d;
    public JSONObject e;
    public JSONObject f;
    public JSONObject g;

    public e(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.f1057a = str;
        this.b = str2;
        this.c = str3;
        this.d = jSONObject;
        this.e = jSONObject2;
        this.g = jSONObject3;
    }

    @Override // N.b
    public final JSONObject a() {
        try {
            if (this.g == null) {
                this.g = new JSONObject();
            }
            this.g.put("log_type", "performance_monitor");
            this.g.put(NotificationCompat.CATEGORY_SERVICE, this.f1057a);
            if (!S0.b.s0(this.d)) {
                this.g.put("extra_values", this.d);
            }
            if (TextUtils.equals("start", this.f1057a) && TextUtils.equals(TypedValues.TransitionType.S_FROM, this.g.optString("monitor-plugin"))) {
                if (this.e == null) {
                    this.e = new JSONObject();
                }
                this.e.put("start_mode", h.i);
            }
            if (!S0.b.s0(this.e)) {
                this.g.put("extra_status", this.e);
            }
            if (!S0.b.s0(this.f)) {
                this.g.put("filters", this.f);
            }
            return this.g;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac  */
    @Override // N.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b() {
        /*
            r6 = this;
            java.lang.String r0 = r6.b
            java.lang.String r1 = r6.c
            java.lang.String r2 = r6.f1057a
            java.lang.String r3 = "fps"
            boolean r2 = r3.equals(r2)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto Lae
            java.lang.String r2 = r6.f1057a
            java.lang.String r5 = "fps_drop"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L1c
            goto Lae
        L1c:
            java.lang.String r2 = r6.f1057a
            java.lang.String r5 = "temperature"
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto Lac
            java.lang.String r2 = r6.f1057a
            java.lang.String r5 = "battery"
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto Lac
            java.lang.String r2 = r6.f1057a
            java.lang.String r5 = "battery_summary"
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto Lac
            java.lang.String r2 = r6.f1057a
            java.lang.String r5 = "battery_capacity"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L46
            goto Lac
        L46:
            java.lang.String r2 = r6.f1057a
            java.lang.String r5 = "start"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L65
            java.lang.String r6 = r6.f1057a
            J0.a r1 = g1.AbstractC1451a.f4474w
            boolean r6 = r1.b(r6)
            if (r6 != 0) goto Lac
            J0.a r6 = g1.AbstractC1451a.f4474w
            boolean r6 = r6.c(r0)
            if (r6 == 0) goto L63
            goto Lac
        L63:
            r6 = r4
            goto Lb6
        L65:
            java.lang.String r0 = r6.f1057a
            java.lang.String r2 = "start_trace"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L87
            java.lang.String r0 = "enable_perf_data_collect"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7e
            J0.a r6 = g1.AbstractC1451a.f4474w
            boolean r6 = r6.a(r1)
            goto Lb6
        L7e:
            java.lang.String r6 = r6.f1057a
            J0.a r0 = g1.AbstractC1451a.f4474w
            boolean r6 = r0.b(r6)
            goto Lb6
        L87:
            java.lang.String r0 = r6.f1057a
            java.lang.String r2 = "disk"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L92
            goto Lac
        L92:
            java.lang.String r0 = r6.f1057a
            java.lang.String r2 = "operate"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto La3
            J0.a r6 = g1.AbstractC1451a.f4474w
            boolean r6 = r6.a(r1)
            goto Lb6
        La3:
            java.lang.String r6 = r6.f1057a
            J0.a r0 = g1.AbstractC1451a.f4474w
            boolean r6 = r0.b(r6)
            goto Lb6
        Lac:
            r6 = r3
            goto Lb6
        Lae:
            java.lang.String r6 = r6.f1057a
            J0.a r1 = g1.AbstractC1451a.f4474w
            boolean r6 = r1.a(r6, r0)
        Lb6:
            if (r6 == 0) goto Lb9
            return r3
        Lb9:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: P.e.b():boolean");
    }

    @Override // N.b
    public final String d() {
        return this.f1057a;
    }

    @Override // N.b
    public final String g() {
        return "performance_monitor";
    }
}
