package ld;

import ad.n;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<Logger> f10419a = new CopyOnWriteArraySet<>();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f10420b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r22 = n.class.getPackage();
        String name = r22 != null ? r22.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        linkedHashMap.put(n.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(hd.b.class.getName(), "okhttp.Http2");
        linkedHashMap.put(dd.e.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f10420b = kotlin.collections.b.n0(linkedHashMap);
    }
}
