package a3;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: a3.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0168m {

    /* renamed from: b, reason: collision with root package name */
    public static final C0167l f2314b = new C0167l();

    /* renamed from: a, reason: collision with root package name */
    public final Object f2315a;

    public final boolean equals(Object obj) {
        if (obj instanceof C0168m) {
            return Intrinsics.areEqual(this.f2315a, ((C0168m) obj).f2315a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f2315a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f2315a;
        if (obj instanceof C0166k) {
            return ((C0166k) obj).toString();
        }
        return "Value(" + obj + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
