package com.baidu.mapauto.auth.net;

/* JADX INFO: loaded from: classes39.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f31794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f31795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f31796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Exception f31797d;

    public b() {
        this.f31797d = null;
    }

    public final String toString() {
        StringBuilder r100 = com.baidu.mapauto.auth.b.a("NetBodyStringResponse{httpCode=");
        r100.append(this.f31794a);
        r100.append(", httpMessage='");
        r100.append(this.f31795b);
        r100.append('\'');
        r100.append(", body='");
        r100.append(this.f31796c);
        r100.append('\'');
        r100.append(", httpException=");
        r100.append(this.f31797d);
        r100.append('}');
        return r100.toString();
    }
}
