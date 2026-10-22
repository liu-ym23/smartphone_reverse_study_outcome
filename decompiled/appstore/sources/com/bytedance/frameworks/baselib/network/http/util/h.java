package com.bytedance.frameworks.baselib.network.http.util;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f7543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7544b;

    public h(String r10) {
        this.f7543a = new LinkedHashMap();
        this.f7544b = r10;
    }

    public void a(String r10, int r11) {
        List r12 = (List) this.f7543a.get(r10);
        if (r12 != null) goto L5;
        r12 = new LinkedList();
    L5:
        r12.add(String.valueOf(r11));
        this.f7543a.put(r10, r12);
    }

    public void b(String r10, String r11) {
        List r12 = (List) this.f7543a.get(r10);
        if (r12 != null) goto L5;
        r12 = new LinkedList();
    L5:
        r12.add(String.valueOf(r11));
        this.f7543a.put(r10, r12);
    }

    public String c() {
        if (this.f7543a.isEmpty() == true) goto L5;
        String r10 = i.c(this.f7543a, "UTF-8");
        String r11 = this.f7544b;
        if (r11 != null) goto L9;
    L17:
        return r10;
    L9:
        if (r11.length() == 0) goto L17;
        if (this.f7544b.indexOf(63) < 0) goto L16;
        return this.f7544b + "&" + r10;
    L16:
        return this.f7544b + "?" + r10;
    L5:
        return this.f7544b;
    }

    public String toString() {
        return c();
    }
}
