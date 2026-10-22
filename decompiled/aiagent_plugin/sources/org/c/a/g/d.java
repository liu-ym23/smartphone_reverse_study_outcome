package org.c.a.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: VersionTagsTuple.java */
/* JADX INFO: loaded from: classes5.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private org.c.a.a.e f40463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f40464b;

    public d(org.c.a.a.e r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.f40463a = r3;
        this.f40464b = r5;
    }

    public org.c.a.a.e a() {
        return this.f40463a;
    }

    public Map<String, String> b() {
        return this.f40464b;
    }

    public String toString() {
        return String.format("VersionTagsTuple<%s, %s>", new Object[]{this.f40463a, this.f40464b});
    }
}
