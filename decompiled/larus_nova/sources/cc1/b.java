package cc1;

import com.bytedance.android.live.user.api.event.UpdateUserReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Throwable f23131d;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("UserUpdateFailedEvent(reason=");
        r100.append(this.f23129a);
        r100.append(", isUpdateSuccess=");
        r100.append(this.f23130b);
        r100.append("), error=");
        Throwable r101 = this.f23131d;
        if (r101 == null) goto L5;
        String r102 = r101.getMessage();
    L6:
        r100.append(r102);
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public b(UpdateUserReason r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "updateReason");
        super(r100, false);
        this.f23131d = r101;
    }
}
