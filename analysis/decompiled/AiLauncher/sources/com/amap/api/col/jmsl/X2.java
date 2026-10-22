package com.amap.api.col.jmsl;

import android.content.Context;

/* loaded from: classes.dex */
public class X2 {

    /* renamed from: a, reason: collision with root package name */
    public Context f16471a;

    /* renamed from: b, reason: collision with root package name */
    public C1569j2 f16472b;

    /* renamed from: c, reason: collision with root package name */
    public String f16473c;

    public X2(Context context, C1569j2 c1569j2, String str) {
        this.f16471a = context.getApplicationContext();
        this.f16472b = c1569j2;
        this.f16473c = str;
    }

    public final byte[] a() {
        Context context = this.f16471a;
        C1569j2 c1569j2 = this.f16472b;
        String str = this.f16473c;
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("\"sdkversion\":\"");
            sb2.append(c1569j2.d());
            sb2.append("\",\"product\":\"");
            sb2.append(c1569j2.g());
            sb2.append("\",\"nt\":\"");
            sb2.append(S0.v(context));
            sb2.append("\",\"details\":");
            sb2.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return C1604s2.t(sb2.toString());
    }
}
