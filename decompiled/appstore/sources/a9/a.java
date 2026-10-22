package a9;

import com.tmall.wireless.tangram.dataparser.concrete.Style;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends Style {
    public a() {
    }

    public void a(double[] r10, JSONObject r11, String r12) {
        JSONArray r13 = r11.optJSONArray(r12);
        if (r13 == null) goto L7;
        int r14 = Math.min(r10.length, r11.length());
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L9;
        r10[r15] = r13.optDouble(r15);
        r15 = r15 + 1;
        goto L5
    L9:
        return;
    }

    public void b(JSONObject r10) {
        this.aspectRatio = (float) r10.optDouble("aspectratio", 1.0d);
    }
}
