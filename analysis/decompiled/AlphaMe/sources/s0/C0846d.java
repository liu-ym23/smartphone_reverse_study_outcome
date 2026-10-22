package s0;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: s0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0846d {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f14182a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f14183b;

    public C0846d(boolean z4, Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.f14182a = uri;
        this.f14183b = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(C0846d.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
        C0846d c0846d = (C0846d) obj;
        return Intrinsics.areEqual(this.f14182a, c0846d.f14182a) && this.f14183b == c0846d.f14183b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f14183b) + (this.f14182a.hashCode() * 31);
    }
}
