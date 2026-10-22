package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class v6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private w5 f28194a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Map<String, v6> f28195a;

        static {
            f28195a = new HashMap();
        }
    }

    private v6(w5 r100) {
        this.f28194a = r100;
    }

    public static v6 a(w5 r100) {
        if (a.f28195a.get(r100.d()) != null) goto L6;
        a.f28195a.put(r100.d(), new v6(r100));
    L6:
        return a.f28195a.get(r100.d());
    }

    public boolean b(Context r100) {
        return Boolean.parseBoolean(y6.a(r100, this.f28194a, "scisf"));
    L5:
        return true;
    }

    public boolean a(Context r100) {
        return Boolean.parseBoolean(y6.a(r100, this.f28194a, "sckey"));
    L5:
        return false;
    }

    public void a(Context r100, boolean r101, boolean r102) {
        y6.a(r100, this.f28194a, "sckey", "" + r101);
        if (r101 == false) goto L6;
        y6.a(r100, this.f28194a, "scisf", "" + r102);
        return;
    }
}
