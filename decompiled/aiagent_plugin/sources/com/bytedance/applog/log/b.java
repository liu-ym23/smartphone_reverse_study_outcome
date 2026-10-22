package com.bytedance.applog.log;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AbstractAppLogLogger.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, f> f5699c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f5701b;

    static {
        f5699c = new ConcurrentHashMap();
    }

    public b() {
        ArrayList r0 = new ArrayList();
        this.f5701b = r0;
        r0.add("logger@" + hashCode());
    }

    @Override // com.bytedance.applog.log.f
    public void a(String r3) {
        this.f5700a = r3;
        f5699c.put(r3, this);
        d("Current logger bind to appId {}", new Object[]{r3});
    }

    public static f b(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(f5699c.get(r2), f.class, "com.obric.aiagent.plugin");
    }

    public void a(int r3, int r4, List<String> r5, Throwable r6, String r7, Object... r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (k.a() == false) goto L5;
        return;
    L5:
        h r10 = h.a().a(this.f5700a).b(r3).a(r4).b(Thread.currentThread().getName()).a(r6).a(a(r9)).c(a(r7, r8)).a();
        k.a(r10);
        g r2 = k.a(this.f5700a);
        if (r2 == null) goto L9;
        r2.a(r10);
        return;
    }

    public List<String> a(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        if (r4.size() <= 0) goto L9;
        ArrayList r0 = new ArrayList();
        r0.addAll(this.f5701b);
        r0.addAll(r4);
        return r0;
    L9:
        return this.f5701b;
    }

    public String a(String r8, Object... r9) {
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L28
        if (r9 != null) goto L5;
    L25:
        r0.append(r8);     // Catch: Throwable -> L28
    L26:
        return r0.toString();
    L5:
        if (r9.length == 0) goto L25;
        if (r8.contains("{}") == false) goto L25;
        int r1 = r8.length();     // Catch: Throwable -> L28
        int r2 = 0;
        int r3 = 0;
    L10:
        if (r2 >= r1) goto L26;
        char r4 = r8.charAt(r2);     // Catch: Throwable -> L28
        if (r2 >= (r1 - 1)) goto L14;
        char r5 = r8.charAt(r2 + 1);     // Catch: Throwable -> L28
    L16:
        if (r4 == '{') goto L18;
    L23:
        r0.append(r4);     // Catch: Throwable -> L28
    L24:
        r2 = r2 + 1;     // Catch: Throwable -> L28
        goto L10
    L18:
        if (r5 != '}') goto L23;
        if (r3 >= r9.length) goto L22;
        r0.append(a(r9[r3]));     // Catch: Throwable -> L28
        r3 = r3 + 1;     // Catch: Throwable -> L28
    L22:
        r2 = r2 + 1;     // Catch: Throwable -> L28
        goto L24
    L14:
        r5 = ' ';
    L28:
        return r8;
    }

    private String a(Object r1) {
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1.toString();
    }
}
