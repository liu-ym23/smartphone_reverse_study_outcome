package w0;

import android.text.TextUtils;
import com.stepos.aiengine.args.SingleFileBundle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: w0.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2087h {

    /* renamed from: a, reason: collision with root package name */
    public String f6812a;
    public long b;
    public float c;
    public boolean d;
    public String e = "normal";
    public ArrayList f = new ArrayList();

    public final long a() {
        long j5 = C2091l.f6815A;
        if (j5 > 0) {
            return j5;
        }
        if (TextUtils.equals(this.f6812a, C2091l.f6818x)) {
            long j6 = this.b;
            C2091l.f6815A = j6;
            return j6;
        }
        if (!this.f.isEmpty()) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                long jA = ((C2087h) it.next()).a();
                if (jA > 0) {
                    return jA;
                }
            }
        }
        return 0L;
    }

    public final JSONObject b(BigDecimal bigDecimal) {
        JSONObject jSONObject = new JSONObject();
        try {
            float fFloatValue = new BigDecimal(this.b).divide(bigDecimal, 4, 4).floatValue();
            this.c = fFloatValue;
            if (fFloatValue > 1.0f) {
                this.c = 0.0f;
            }
            String strReplace = this.f6812a;
            if (strReplace.contains(C2091l.f6817w)) {
                strReplace = strReplace.replace(C2091l.f6817w, "internal");
            } else if (strReplace.contains(C2091l.y)) {
                strReplace = strReplace.replace(C2091l.y, "external");
            }
            jSONObject.put(SingleFileBundle.KEY_PATH, strReplace);
            jSONObject.put("size", this.b);
            jSONObject.put("size_rate", this.c);
            jSONObject.put("is_folder", this.d);
            jSONObject.put("report_type", this.e);
            if (!this.f.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.f.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((C2087h) it.next()).b(bigDecimal));
                }
                jSONObject.put("next_disk", jSONArray);
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public final long c() {
        long j5 = C2091l.f6816B;
        if (j5 > 0) {
            return j5;
        }
        if (TextUtils.equals(this.f6812a, C2091l.f6819z)) {
            long j6 = this.b;
            C2091l.f6816B = j6;
            return j6;
        }
        if (!this.f.isEmpty()) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                long jC = ((C2087h) it.next()).c();
                if (jC > 0) {
                    return jC;
                }
            }
        }
        return 0L;
    }
}
