package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class p {
    public static /* synthetic */ boolean a(AtomicReference r10, Object r11, Object r12) {
    L3:
        if (r10.compareAndSet(r11, r12) == true) goto L4;
        if (r10.get() == r11) goto L3;
        return false;
    L4:
        return true;
    }
}
