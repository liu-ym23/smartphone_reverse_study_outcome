package cc1;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.user.api.event.UpdateUserReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final User f23132d;

    public final String toString() {
        return "UserUpdateSuccessEvent(reason=" + this.f23129a + ", isUpdateSuccess=" + this.f23130b + ')';
    }

    public c(UpdateUserReason r100, User r101) {
        Intrinsics.checkNotNullParameter(r100, "updateReason");
        Intrinsics.checkNotNullParameter(r101, "user");
        super(r100, true);
        this.f23132d = r101;
    }
}
