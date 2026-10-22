package h3;

import k3.C0683E;

/* renamed from: h3.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0602k extends Cloneable {
    void cancel();

    void enqueue(InterfaceC0603l interfaceC0603l);

    b0 execute();

    boolean isCanceled();

    V request();

    C0683E timeout();
}
