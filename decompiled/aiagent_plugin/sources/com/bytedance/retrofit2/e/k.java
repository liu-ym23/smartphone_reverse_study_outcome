package com.bytedance.retrofit2.e;

/* JADX INFO: compiled from: TypedString.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends g {
    public k(String r3) {
        super("text/plain; charset=UTF-8", a(r3), new String[0]);
    }

    private static byte[] a(String r1) {
        return r1.getBytes("UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.bytedance.retrofit2.e.g
    public String toString() {
        return "TypedString[" + new String(i(), "UTF-8") + "]";
    L5:
        throw new AssertionError("Must be able to decode UTF-8");
    }
}
