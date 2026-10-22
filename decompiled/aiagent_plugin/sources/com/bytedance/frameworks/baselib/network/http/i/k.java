package com.bytedance.frameworks.baselib.network.http.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: UrlBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, List<String>> f8390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8391b;

    public k(String r2) {
        this.f8390a = new LinkedHashMap();
        this.f8391b = r2;
    }

    public k() {
        this.f8390a = new LinkedHashMap();
        this.f8391b = null;
    }

    public void a(String r4, int r5) {
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(this.f8390a.get(r4), List.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new LinkedList();
    L5:
        r0.add(String.valueOf(r5));
        this.f8390a.put(r4, r0);
    }

    public void a(String r4, String r5) {
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(this.f8390a.get(r4), List.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new LinkedList();
    L5:
        r0.add(String.valueOf(r5));
        this.f8390a.put(r4, r0);
    }

    public String a() {
        if (this.f8390a.isEmpty() == true) goto L5;
        String r0 = l.a(this.f8390a, "UTF-8");
        String r1 = this.f8391b;
        if (r1 != null) goto L9;
    L17:
        return r0;
    L9:
        if (r1.length() == 0) goto L17;
        if (this.f8391b.indexOf(63) < 0) goto L16;
        return this.f8391b + "&" + r0;
    L16:
        return this.f8391b + "?" + r0;
    L5:
        return this.f8391b;
    }

    public String toString() {
        return a();
    }
}
