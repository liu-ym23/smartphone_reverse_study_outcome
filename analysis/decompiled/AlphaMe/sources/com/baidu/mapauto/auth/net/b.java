package com.baidu.mapauto.auth.net;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public Integer f7674a;

    /* renamed from: b, reason: collision with root package name */
    public String f7675b;

    /* renamed from: c, reason: collision with root package name */
    public String f7676c;

    /* renamed from: d, reason: collision with root package name */
    public Exception f7677d = null;

    public final String toString() {
        StringBuilder sbA = com.baidu.mapauto.auth.a.a("NetBodyStringResponse{httpCode=");
        sbA.append(this.f7674a);
        sbA.append(", httpMessage='");
        sbA.append(this.f7675b);
        sbA.append('\'');
        sbA.append(", body='");
        sbA.append(this.f7676c);
        sbA.append('\'');
        sbA.append(", httpException=");
        sbA.append(this.f7677d);
        sbA.append('}');
        return sbA.toString();
    }
}
