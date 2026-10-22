package b84;

import com.bytedance.bdinstall.o0;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o0 f18025e;

    public h(o0 r100) {
        super(false, true);
        this.f18025e = r100;
    }

    @Override // b84.d
    public final boolean a(JSONObject r100) throws SecurityException {
        Map<String, Object> r101 = this.f18025e.f199742o;
        if (r101 == null) goto L26;
    L14:
        e = move-exception;
        e.printStackTrace();
        return true;
    L5:
        if (r101.isEmpty() == true) goto L27;
        Iterator<Map.Entry<String, Object>> r102 = r101.entrySet().iterator();     // Catch: Exception -> L14
    L8:
        if (r102.hasNext() == false) goto L28;
        Map.Entry<String, Object> r103 = r102.next();     // Catch: Exception -> L14
        if (r103 == null) goto L8;
        r100.put(r103.getKey(), r103.getValue());     // Catch: Exception -> L14
        goto L8
    L28:
        return true;
    L27:
        return true;
    L26:
        return true;
    }
}
