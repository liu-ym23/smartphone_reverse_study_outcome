package com.bytedance.rpc.a;

/* JADX INFO: compiled from: DefaultErrorFormatter.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final InterfaceC0221a f9697a = null;

    /* JADX INFO: renamed from: com.bytedance.rpc.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DefaultErrorFormatter.java */
    public interface InterfaceC0221a {
    }

    static {
        f9697a = new AnonymousClass1();
    }

    public static Throwable a(Throwable r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.getCause() == null) goto L9;
        r1 = r1.getCause();
        goto L4
    L9:
        return r1;
    }
}
