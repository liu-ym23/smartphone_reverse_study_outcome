package com.bytedance.frameworks.baselib.network.http.c;

/* JADX INFO: compiled from: HttpResponseException.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends b {
    private final int f;
    private final String g;

    public d(int r3, String r4, String r5, String r6) {
        StringBuilder r0 = new StringBuilder();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        StringBuilder r7 = r0.append(r4).append(" ");
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        super(r7.append(r5).toString());
        this.f = r3;
        this.g = r6;
    }

    public int a() {
        return this.f;
    }
}
