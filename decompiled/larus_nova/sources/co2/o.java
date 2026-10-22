package co2;

import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdk.performance.q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class o implements q {
    public o() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (r101 == null) goto L11;
        JSONObject r102 = new JSONObject();
        r102.put("value", r101.N);     // Catch: Exception -> L8
    L6:
        ((HashMap) r100).put("thermal", r102.toString());
        return;
    }
}
