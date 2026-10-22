package com.baidu.bbalbscesium.j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f30211c = "upc";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f30212d = 9000000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f30213e = "isc";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f30214f = 8000000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f30215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f30216b;

    public interface a {
        List a();
    }

    public b(a r100) {
        this.f30216b = new HashMap();
        this.f30215a = r100;
        Iterator r101 = r100.a().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        com.baidu.bbalbscesium.j.a r102 = (com.baidu.bbalbscesium.j.a) r101.next();
        this.f30216b.put(r102.a(), r102);
        goto L4
    }

    public com.baidu.bbalbscesium.j.a a(String r100) {
        return (com.baidu.bbalbscesium.j.a) this.f30216b.get(r100);
    }

    public List a() {
        return new ArrayList(this.f30216b.values());
    }
}
