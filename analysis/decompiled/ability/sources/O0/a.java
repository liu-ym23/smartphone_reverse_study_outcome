package O0;

import D9.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;
import z9.g;

/* loaded from: classes2.dex */
public final class a {
    public static volatile a b;

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap f1031a;

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        a aVar = new a();
                        new CopyOnWriteArraySet();
                        aVar.f1031a = new ConcurrentHashMap();
                        b = aVar;
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry entry : this.f1031a.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public Object c(g descriptor, k kVar) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        Map map = (Map) this.f1031a.get(descriptor);
        Object obj = map != null ? map.get(kVar) : null;
        if (obj == null) {
            return null;
        }
        return obj;
    }
}
