package b48;

import com.bytedance.android.livesdkapi.app.AppConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f17637b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f17636a, r101.f17636a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17637b, r101.f17637b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f17636a.hashCode() * 31;
        Object r101 = this.f17637b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SaaSAccountEvent(type=" + this.f17636a + ", rawEvent=" + this.f17637b + ')';
    }

    public final String getType() {
        return this.f17636a;
    }

    public k(Object r100) {
        Intrinsics.checkNotNullParameter(AppConstants.SESSION_EXPIRED, "type");
        this.f17636a = AppConstants.SESSION_EXPIRED;
        this.f17637b = r100;
    }
}
