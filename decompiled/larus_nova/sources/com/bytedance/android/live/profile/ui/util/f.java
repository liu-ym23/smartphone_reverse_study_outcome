package com.bytedance.android.live.profile.ui.util;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<NewProfileUser, Boolean> f86945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<com.bytedance.android.live.profile.ui.base.g> f86946b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f86945a, r101.f86945a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f86946b, r101.f86946b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Function1<NewProfileUser, Boolean> r100 = this.f86945a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function0<com.bytedance.android.live.profile.ui.base.g> r104 = this.f86946b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ComponentLoadInfo(loadPredicate=" + this.f86945a + ", generate=" + this.f86946b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super NewProfileUser, Boolean> r100, Function0<? extends com.bytedance.android.live.profile.ui.base.g> r101) {
        Intrinsics.checkNotNullParameter(r100, "loadPredicate");
        Intrinsics.checkNotNullParameter(r101, "generate");
        this.f86945a = r100;
        this.f86946b = r101;
    }
}
