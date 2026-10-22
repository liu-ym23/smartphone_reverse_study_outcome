package com.amap.api.col.jmsl;

/* loaded from: classes.dex */
public class H2 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f16097a = false;

    public static synchronized void a() {
        if (!f16097a) {
            O2.b().g("regeo", new b3("/geocode/regeo"));
            O2.b().g("placeAround", new b3("/place/around"));
            O2.b().g("placeText", new U2("/place/text"));
            O2.b().g("geo", new U2("/geocode/geo"));
            f16097a = true;
        }
    }
}
