package w0;

import androidx.autofill.HintConstants;
import org.json.JSONObject;

/* renamed from: w0.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2090k extends C2088i {
    public String d;
    public long e;
    public int f;
    public long g;

    @Override // w0.C2088i
    public final JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            String strReplace = this.d;
            if (strReplace.contains(C2091l.f6817w)) {
                strReplace = strReplace.replace(C2091l.f6817w, "internal");
            } else if (strReplace.contains(C2091l.y)) {
                strReplace = strReplace.replace(C2091l.y, "external");
            }
            jSONObject.put(HintConstants.AUTOFILL_HINT_NAME, strReplace);
            jSONObject.put("size", this.e);
            int i = this.f;
            if (i > 0) {
                jSONObject.put("num", i);
            }
            jSONObject.put("outdate_interval", this.g);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // w0.C2088i, java.lang.Comparable
    public final int compareTo(Object obj) {
        long j5 = this.g;
        long j6 = ((C2090k) obj).g;
        if (j5 == j6) {
            return 0;
        }
        return j5 > j6 ? 1 : -1;
    }
}
