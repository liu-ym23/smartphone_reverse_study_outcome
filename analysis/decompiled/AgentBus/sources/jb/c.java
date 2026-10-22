package jb;

import ab.t;
import d7.e0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet f5428a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f5429b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r22 = t.class.getPackage();
        String name = r22 != null ? r22.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        linkedHashMap.put(t.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(hb.f.class.getName(), "okhttp.Http2");
        linkedHashMap.put(db.e.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f5429b = e0.a0(linkedHashMap);
    }
}
