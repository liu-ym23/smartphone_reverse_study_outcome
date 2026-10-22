package co2;

import com.bytedance.android.livesdk.performance.l0;
import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdk.performance.q;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class j implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f24610a;

    public j(l0 r100) {
        this.f24610a = r100;
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (this.f24610a == null) goto L18;
        JSONObject r102 = new JSONObject();
        Iterator<T> r103 = this.f24610a.f154676a.values().iterator();     // Catch: Exception -> L13
    L8:
        if (r103.hasNext() == false) goto L11;
        l0.a r104 = (l0.a) r103.next();     // Catch: Exception -> L13
        r102.put(r104.f154679a, r104.a());     // Catch: Exception -> L13
    L11:
        HashMap r105 = (HashMap) r100;
        r105.put(IPerformanceManager.Params.modules, r102.toString());
        return;
    }
}
