package com.bytedance.frameworks.baselib.network.http;

/* JADX INFO: compiled from: BaseHttpClient.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements d {
    public a() {
    }

    public static String a(String r2) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    L4:
        if (com.bytedance.common.utility.j.a(r2) == true) goto L12;
        return new com.bytedance.frameworks.baselib.network.http.f.b(r2).b();
    L12:
        return "";
    }
}
