package com.bytedance.vmsdk.a.a.a;

import java.io.OutputStream;

/* JADX INFO: compiled from: LightHttpBody.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public abstract String a();

    public abstract void a(OutputStream r1);

    public abstract int b();

    public d() {
    }

    public static d a(String r1, String r2) {
        return a(r1.getBytes("UTF-8"), r2);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static d a(final byte[] r1, final String r2) {
        return new AnonymousClass1(r2, r1);
    }
}
