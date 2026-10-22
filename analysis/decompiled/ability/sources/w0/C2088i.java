package w0;

import androidx.autofill.HintConstants;
import org.json.JSONObject;

/* renamed from: w0.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2088i implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final String f6813a;
    public final long b;
    public final int c;

    public C2088i(String str, long j5, int i) {
        this.f6813a = str;
        this.b = j5;
        this.c = i;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            String strReplace = this.f6813a;
            if (strReplace.contains(C2091l.f6817w)) {
                strReplace = strReplace.replace(C2091l.f6817w, "internal");
            } else if (strReplace.contains(C2091l.y)) {
                strReplace = strReplace.replace(C2091l.y, "external");
            }
            jSONObject.put(HintConstants.AUTOFILL_HINT_NAME, strReplace);
            jSONObject.put("size", this.b);
            int i = this.c;
            if (i > 0) {
                jSONObject.put("num", i);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        long j5 = this.b;
        long j6 = ((C2088i) obj).b;
        if (j5 == j6) {
            return 0;
        }
        return j5 > j6 ? 1 : -1;
    }
}
