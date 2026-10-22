package com.amap.api.mapcore.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Boolean> f28317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f28318b;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static x f28319a;

        static {
            f28319a = new x(null);
        }

        public static /* synthetic */ x a() {
            return f28319a;
        }
    }

    private void a() {
        this.f28317a.put("feature_mvt", Boolean.TRUE);
        Map<String, Boolean> r100 = this.f28317a;
        Boolean r101 = Boolean.FALSE;
        r100.put("feature_gltf", r101);
        this.f28317a.put("feature_terrain", r101);
    }

    public boolean b() {
        return this.f28318b.get();
    }

    private x() {
        this.f28317a = new ConcurrentHashMap();
        this.f28318b = new AtomicBoolean(false);
        a();
    }

    public /* synthetic */ x(a r100) {
        this();
    }

    public void a(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.optString("mvt_able");
        m5.a(r101, true);
        this.f28317a.put("feature_mvt", Boolean.valueOf(m5.a(r101, true)));
        String r102 = r100.optString("gltf_able");
        this.f28317a.put("feature_gltf", Boolean.valueOf(m5.a(r102, false)));
        String r103 = r100.optString("terrain_able");
        this.f28317a.put("feature_terrain", Boolean.valueOf(m5.a(r103, false)));
        this.f28318b.set(true);
    }

    public boolean a(String r100) {
        if (this.f28317a.containsKey(r100) == true) goto L5;
        return false;
    L5:
        return this.f28317a.get(r100).booleanValue();
    }
}
