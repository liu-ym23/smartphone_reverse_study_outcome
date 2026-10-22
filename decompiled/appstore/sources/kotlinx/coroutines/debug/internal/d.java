package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends WeakReference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21408a;

    public d(Object r10, ReferenceQueue r11) {
        super(r10, r11);
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        this.f21408a = r12;
        return;
    L5:
        r12 = 0;
        goto L6
    }
}
