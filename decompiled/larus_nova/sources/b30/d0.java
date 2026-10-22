package b30;

import com.bytedance.android.livesdk.message.model.p4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p4 f17119a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f17119a, ((d0) r100).f17119a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        p4 r100 = this.f17119a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ShowFollowGuideEvent(message=" + this.f17119a + ")";
    }

    public d0(p4 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f17119a = r100;
    }
}
