package com.google.protobuf;

import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class J0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f2844a = Logger.getLogger(J0.class.getName());
    public static final int[] b = new int[0];
    public static final C1004w0[] c = new C1004w0[0];
    public static final D0[] d = new D0[0];
    public static final A0[] e = new A0[0];
    public static final I0[] f = new I0[0];
    public static final H0[] g = new H0[0];

    public static String a(E0 e02, C1004w0 c1004w0, String str) {
        if (c1004w0 != null) {
            return c1004w0.b + '.' + str;
        }
        String strG = e02.f2826a.G();
        if (strG.isEmpty()) {
            return str;
        }
        return strG + '.' + str;
    }
}
