package k3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: k3.C, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0681C extends C0683E {
    @Override // k3.C0683E
    public final C0683E deadlineNanoTime(long j4) {
        return this;
    }

    @Override // k3.C0683E
    public final void throwIfReached() {
    }

    @Override // k3.C0683E
    public final C0683E timeout(long j4, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this;
    }
}
