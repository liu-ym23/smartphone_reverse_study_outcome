package androidx.concurrent.futures;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ boolean a(AtomicReferenceFieldUpdater r10, Object r11, Object r12, Object r13) {
    L3:
        if (r10.compareAndSet(r11, r12, r13) == true) goto L4;
        if (r10.get(r11) == r12) goto L3;
        return false;
    L4:
        return true;
    }
}
