package w9;

import v9.InterfaceC2073b;

/* renamed from: w9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC2108a {
    InterfaceC2073b getOnLock();

    boolean holdsLock(Object obj);

    boolean isLocked();

    Object lock(Object obj, H7.c cVar);

    boolean tryLock(Object obj);

    void unlock(Object obj);
}
