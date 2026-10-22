package a3;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: a3.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0166k extends C0167l {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f2313a;

    public C0166k(Throwable th) {
        this.f2313a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0166k) {
            if (Intrinsics.areEqual(this.f2313a, ((C0166k) obj).f2313a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f2313a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // a3.C0167l
    public final String toString() {
        return "Closed(" + this.f2313a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
